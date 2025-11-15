import os
import importlib
import argparse
import sys

def read_binary_file(file_path):
    """读取二进制文件内容"""
    with open(file_path, 'rb') as f:
        data = f.read()
        return data

def parse_proto_message(binary_data, proto_module, message_class):
    """解析二进制数据为proto消息"""
    try:
        if hasattr(proto_module, message_class):
            message_class_obj = getattr(proto_module, message_class)
        elif hasattr(proto_module, 'EsPb'):
            message_class_obj = getattr(proto_module.EsPb, message_class)
        else:
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
        constants = [name for name in dir(proto_module) if name.startswith('_') and name.endswith(message_class.upper())]
        if constants:
            print(f"找到可能相关的常量定义: {constants}")
            
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

    file_basename = os.path.basename(args.binary_file)
    message_class = args.class_name if args.class_name else os.path.splitext(file_basename)[0]
    
    proto_dir_abs = os.path.abspath(args.proto_dir)
    if not os.path.exists(proto_dir_abs):
        print(f"错误: 目录 {proto_dir_abs} 不存在")
        return 1

    if proto_dir_abs not in sys.path:
        sys.path.insert(0, proto_dir_abs)

    proto_module_name = f"{os.path.splitext(file_basename)[0]}_pb2"
    
    try:
        proto_module = importlib.import_module(proto_module_name)
        binary_data = read_binary_file(args.binary_file)

        proto_dir_name = os.path.basename(args.proto_dir)
        if proto_dir_name == 'request_proto_api':
            offset = 4
        else:
            offset = 8
        
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
            if not name.startswith('_'):
                try:
                    obj = getattr(proto_module, name)
                    if callable(obj) and hasattr(obj, 'ParseFromString'):
                        print(f"  - {name} (可解析类)")
                except:
                    pass
    
    except ImportError as e:
        print(f"导入模块失败: {e}")
        print(f"请确保 {proto_module_name} 模块存在")
    except Exception as e:
        print(f"发生错误: {e}")
        import traceback
        print(traceback.format_exc())

if __name__ == "__main__":
    main()