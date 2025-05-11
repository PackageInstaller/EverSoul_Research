#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import importlib
import argparse
import sys
import binascii
import re

def read_binary_file(file_path, debug=False):
    """读取二进制文件内容"""
    with open(file_path, 'rb') as f:
        data = f.read()
        if debug:
            # 打印前32字节的十六进制表示，帮助分析文件格式
            if len(data) > 0:
                print(f"文件头32字节: {binascii.hexlify(data[:32])}")
            if len(data) > 4:
                print(f"前4个字节: {binascii.hexlify(data[:4])}")
                value = int.from_bytes(data[:4], byteorder='little')
                print(f"前4字节转为整数(小端): {value}")
                value = int.from_bytes(data[:4], byteorder='big')
                print(f"前4字节转为整数(大端): {value}")
        return data

def parse_proto_message(binary_data, proto_module, message_class, debug=False):
    """解析二进制数据为proto消息"""
    try:
        # 优先尝试直接在模块中查找类
        if hasattr(proto_module, message_class):
            message_class_obj = getattr(proto_module, message_class)
            print(f"直接使用类{message_class}")
        # 检查模块中是否有EsPb属性
        elif hasattr(proto_module, 'EsPb'):
            # 尝试从EsPb命名空间获取消息类
            message_class_obj = getattr(proto_module.EsPb, message_class)
            print(f"使用命名空间EsPb.{message_class}")
        else:
            # 尝试动态构造EsPb命名空间路径
            all_classes = dir(proto_module)
            print(f"可用的类: {[c for c in all_classes if not c.startswith('_')][:10]}...")
            
            # 查看是否有嵌套类型可能匹配
            nested_classes = []
            for cls_name in all_classes:
                if not cls_name.startswith('_'):
                    cls = getattr(proto_module, cls_name)
                    if hasattr(cls, message_class):
                        nested_classes.append(f"{cls_name}.{message_class}")
            
            if nested_classes:
                print(f"找到可能的嵌套类: {nested_classes}")
                # 尝试第一个嵌套类
                parent_class_name, child_class_name = nested_classes[0].split('.')
                parent_class = getattr(proto_module, parent_class_name)
                message_class_obj = getattr(parent_class, child_class_name)
                print(f"使用嵌套类 {nested_classes[0]}")
            else:
                # 最后的尝试，查找_USERINFO这样的常量，可能指示类型位置
                print("无法找到目标类，尝试其他方法")
                raise AttributeError(f"找不到类 {message_class} 或 EsPb.{message_class}")
        
        message = message_class_obj()
        if debug:
            print(f"消息类型: {type(message)}")
            print(f"二进制数据大小: {len(binary_data)} 字节")
        
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

def try_different_offsets(binary_data, proto_module, message_class, offsets=[0, 4, 8, 16]):
    """尝试不同的偏移量来解析二进制数据"""
    print("\n尝试不同的偏移量:")
    for offset in offsets:
        if offset >= len(binary_data):
            print(f"  偏移量 {offset} 超出文件大小，跳过")
            continue
        
        print(f"  尝试偏移量 {offset}...")
        try:
            message_class_obj = getattr(proto_module, message_class)
            message = message_class_obj()
            message.ParseFromString(binary_data[offset:])
            print(f"  成功! 在偏移量 {offset} 找到有效的 {message_class} 消息")
            return message, offset
        except Exception as e:
            print(f"  偏移量 {offset} 解析失败: {str(e)[:50]}...")
    
    print("所有偏移量都失败")
    return None, None


def main():
    parser = argparse.ArgumentParser(description='读取二进制文件并根据proto定义解析')
    parser.add_argument('binary_file', help='要读取的二进制文件路径')
    parser.add_argument('-p', '--proto_dir', help='proto_api目录路径', default='receive_proto_api')
    parser.add_argument('-c', '--class_name', help='消息类名称(如果与文件名不同)', default=None)
    parser.add_argument('-v', '--verbose', help='显示详细信息', action='store_true')
    parser.add_argument('-n', '--namespace', help='强制使用指定的命名空间', default=None)
    parser.add_argument('-o', '--offset', help='跳过前N个字节', type=int, default=None)
    parser.add_argument('-d', '--debug', help='显示调试信息', action='store_true')
    parser.add_argument('--try-offsets', help='尝试多个不同的偏移量', action='store_true')
    parser.add_argument('--hex-dump', help='显示二进制内容的十六进制表示', action='store_true')
    parser.add_argument('--pretty-binary', help='以十六进制显示二进制字段', action='store_true')
    args = parser.parse_args()
    
    # 获取文件名（不含扩展名）作为消息类型名
    file_basename = os.path.basename(args.binary_file)
    message_class = args.class_name if args.class_name else os.path.splitext(file_basename)[0]
    
    # 构建proto模块名
    proto_module_name = f"{args.proto_dir}.{os.path.splitext(file_basename)[0]}_pb2"
    
    try:
        # 将模块目录添加到路径
        if not os.path.exists(args.proto_dir):
            print(f"错误: 目录 {args.proto_dir} 不存在")
            return 1
        
        # 动态导入proto模块
        proto_module = importlib.import_module(proto_module_name)
        print(f"成功导入模块: {proto_module_name}")
        
        # 读取二进制文件
        binary_data = read_binary_file(args.binary_file, args.debug)
        print(f"读取文件大小: {len(binary_data)} 字节")
        
        if args.hex_dump:
            max_bytes = 128  # 最多显示前128字节
            print("\n文件十六进制内容(前{}字节):".format(max_bytes))
            hex_data = binascii.hexlify(binary_data[:max_bytes]).decode('ascii')
            for i in range(0, len(hex_data), 32):
                print(f"{i//2:04x}: {hex_data[i:i+32]}")
            
            print("\n文件ASCII内容(前{}字节):".format(max_bytes))
            for i in range(0, min(len(binary_data), max_bytes), 16):
                hex_line = ' '.join(f"{b:02x}" for b in binary_data[i:i+16])
                ascii_line = ''.join(chr(b) if 32 <= b <= 126 else '.' for b in binary_data[i:i+16])
                print(f"{i:04x}: {hex_line:<48} {ascii_line}")
        
        # 确定实际使用的偏移量
        offset = args.offset
        if offset is None:
            if args.proto_dir == 'request_proto_api':
                # 请求proto不忽略前字节
                offset = 0
                print("解析全部内容")
            else:
                # 接收proto默认忽略前8字节（根据实测结果）
                offset = 8
                if len(binary_data) > 8:
                    print(f"忽略前8个字节，实际解析大小: {len(binary_data) - 8} 字节")
                else:
                    print("警告：文件小于8字节，将解析全部内容")
                    offset = 0
        else:
            print(f"使用指定的偏移量: {offset}")
        
        # 获取实际数据
        actual_data = binary_data[offset:] if offset > 0 else binary_data
        
        # 检查是否有_USERINFO常量定义
        descriptor_name = f"_{message_class.upper()}"
        if hasattr(proto_module, descriptor_name):
            print(f"找到描述符: {descriptor_name}")
        
        # 如果指定了命名空间，则尝试使用特定命名空间
        if args.namespace:
            print(f"尝试使用指定的命名空间: {args.namespace}")
            namespace_parts = args.namespace.split('.')
            current_obj = proto_module
            for part in namespace_parts:
                if hasattr(current_obj, part):
                    current_obj = getattr(current_obj, part)
                else:
                    print(f"错误：找不到命名空间部分 '{part}'")
                    return 1
            
            if hasattr(current_obj, message_class):
                message_class_obj = getattr(current_obj, message_class)
                message = message_class_obj()
                message.ParseFromString(actual_data)
                print("\n解析结果:")
                print("=" * 30)
                print(message)
                print("=" * 30)
                return 0
            else:
                print(f"错误：在命名空间 {args.namespace} 中找不到类 {message_class}")
                return 1
        
        # 直接尝试使用模块中的类
        try:
            if hasattr(proto_module, message_class):
                message_class_obj = getattr(proto_module, message_class)
                message = message_class_obj()
                if args.debug:
                    print(f"消息类型: {type(message)}")
                    print(f"二进制数据大小: {len(actual_data)} 字节")
                
                message.ParseFromString(actual_data)
                
                # 打印解析后的消息内容
                print("\n解析结果:")
                print("=" * 30)
                print(message)
                print("=" * 30)
                return 0
            else:
                print(f"无法直接找到类 {message_class}，尝试使用通过 parse_proto_message")
                # 如果找不到直接的类，尝试使用解析函数
                message = parse_proto_message(actual_data, proto_module, message_class, args.debug)
                
                if message:
                    # 打印解析后的消息内容
                    print("\n解析结果:")
                    print("=" * 30)
                    print(message)
                    print("=" * 30)
                    return 0
        except Exception as e:
            print(f"直接解析时错误: {e}")
            import traceback
            print(traceback.format_exc())
        
        # 如果启用了尝试不同偏移量选项
        if args.try_offsets:
            message, found_offset = try_different_offsets(binary_data, proto_module, message_class)
            if message:
                print("\n解析结果:")
                print("=" * 30)
                print(message)
                print("=" * 30)
                print(f"成功使用偏移量: {found_offset}")
                return 0
        
        # 如果上面的尝试都失败了
        print("解析失败，请确认文件格式与proto定义是否匹配")
        
        # 打印可能有用的类
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
        print(f"  python read_binary.py {args.binary_file} --try-offsets  # 尝试多个偏移量")
        print(f"  python read_binary.py {args.binary_file} --hex-dump  # 查看文件内容")
        print(f"  python read_binary.py {args.binary_file} -d  # 显示调试信息")
    
    except ImportError as e:
        print(f"导入模块失败: {e}")
        print(f"请确保 {proto_module_name} 模块存在")
    except Exception as e:
        print(f"发生错误: {e}")
        import traceback
        print(traceback.format_exc())

if __name__ == "__main__":
    main()