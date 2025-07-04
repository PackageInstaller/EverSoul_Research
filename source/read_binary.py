import os
import importlib
import argparse
import sys
import binascii
import re

def read_binary_file(file_path):
    """读取二进制文件内容"""
    with open(file_path, 'rb') as f:
        data = f.read()
        return data

def parse_proto_message(binary_data, proto_module, message_class):
    """解析二进制数据为proto消息"""
    try:
        # 优先尝试直接在模块中查找类
        if hasattr(proto_module, message_class):
            message_class_obj = getattr(proto_module, message_class)
        elif hasattr(proto_module, 'EsPb'):
            # 尝试从EsPb命名空间获取消息类
            message_class_obj = getattr(proto_module.EsPb, message_class)
        else:
            # 尝试动态构造EsPb命名空间路径
            all_classes = dir(proto_module)
            nested_classes = []
            for cls_name in all_classes:
                if not cls_name.startswith('_'):
                    cls = getattr(proto_module, cls_name)
                    if hasattr(cls, message_class):
                        nested_classes.append(f"{cls_name}.{message_class}")
            
            if nested_classes:
                parent_class_name, child_class_name = nested_classes[0].split('.')
                parent_class = getattr(proto_module, parent_class_name)
                message_class_obj = getattr(parent_class, child_class_name)
            else:
                raise AttributeError(f"找不到类 {message_class} 或 EsPb.{message_class}")
        
        message = message_class_obj()
        
        message.ParseFromString(binary_data)
        return message
    except AttributeError as e:
        print(f"类访问错误: {e}")
        # 尝试检查是否存在_USERINFO等常量定义
        constants = [name for name in dir(proto_module) if name.startswith('_') and name.endswith(message_class.upper())]
        if constants:
            print(f"找到可能相关的常量定义: {constants}")
            
        # 尝试打印一些模块的基本信息来帮助调试
        print("\n模块信息:")
        print(f"模块名: {proto_module.__name__}")
        print(f"模块路径: {getattr(proto_module, '__file__', '未知')}")
        print(f"模块内容结构: {dir(proto_module)[:20]}...")
        return None
    except Exception as e:
        print(f"解析失败: {e}")
        import traceback
        print(traceback.format_exc())
        return None

def main():
    parser = argparse.ArgumentParser(description='读取二进制文件并根据proto定义解析')
    parser.add_argument('binary_file', help='要读取的二进制文件路径')
    parser.add_argument('-p', '--proto_dir', help='proto_api目录路径', default='../response_proto_api')
    parser.add_argument('-c', '--class_name', help='消息类名称(如果与文件名不同)', default=None)
    args = parser.parse_args()
    
    # 获取文件名（不含扩展名）作为消息类型名
    file_basename = os.path.basename(args.binary_file)
    message_class = args.class_name if args.class_name else os.path.splitext(file_basename)[0]
    
    # 解析proto目录路径
    proto_dir_abs = os.path.abspath(args.proto_dir)
    if not os.path.exists(proto_dir_abs):
        print(f"错误: 目录 {proto_dir_abs} 不存在")
        return 1
    
    # 将proto目录添加到Python路径中
    if proto_dir_abs not in sys.path:
        sys.path.insert(0, proto_dir_abs)
    
    # 构建proto模块名（现在只需要模块名，不需要目录前缀）
    proto_module_name = f"{os.path.splitext(file_basename)[0]}_pb2"
    
    try:
        proto_module = importlib.import_module(proto_module_name)
        binary_data = read_binary_file(args.binary_file)

        # 根据proto目录名判断偏移量
        proto_dir_name = os.path.basename(args.proto_dir)
        if proto_dir_name == 'request_proto_api':
            # 请求proto忽略前4字节
            offset = 4
        else:
            # 接收proto默认忽略前8字节
            offset = 8
        
        # 获取实际数据
        actual_data = binary_data[offset:] if offset > 0 else binary_data
        
        try:
            if hasattr(proto_module, message_class):
                message_class_obj = getattr(proto_module, message_class)
                message = message_class_obj()
                message.ParseFromString(actual_data)
                
                print(message)
                return 0
            else:
                message = parse_proto_message(actual_data, proto_module, message_class)
                
                if message:
                    print(message)
                    return 0
        except Exception as e:
            print(f"直接解析时错误: {e}")
            import traceback
            print(traceback.format_exc())
        
        print("\n可能有用的类:")
        for name in dir(proto_module):
            if not name.startswith('_'):  # 忽略内部属性
                try:
                    obj = getattr(proto_module, name)
                    if callable(obj) and hasattr(obj, 'ParseFromString'):
                        print(f"  - {name} (可解析类)")
                except:
                    pass
        
        print("\n尝试使用以下命令可能会有帮助:")
        print(f"  python read_binary.py {args.binary_file} -o 0  # 不跳过任何字节")
        print(f"  python read_binary.py {args.binary_file} -o 4  # 跳过前4个字节")
    
    except ImportError as e:
        print(f"导入模块失败: {e}")
        print(f"请确保 {proto_module_name} 模块存在")
    except Exception as e:
        print(f"发生错误: {e}")
        import traceback
        print(traceback.format_exc())

if __name__ == "__main__":
    main()