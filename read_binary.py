#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import importlib
import argparse

def read_binary_file(file_path):
    """读取二进制文件内容
    
    Args:
        file_path: 二进制文件路径
        
    Returns:
        二进制文件内容
    """
    with open(file_path, 'rb') as f:
        return f.read()

def parse_proto_message(binary_data, proto_module, message_class):
    """解析二进制数据为proto消息
    
    Args:
        binary_data: 二进制数据
        proto_module: 导入的proto模块
        message_class: 消息类名
        
    Returns:
        解析后的proto消息对象
    """
    try:
        message_class_obj = getattr(proto_module, message_class)
        message = message_class_obj()
        message.ParseFromString(binary_data)
        return message
    except Exception as e:
        print(f"解析失败: {e}")
        return None

def main():
    parser = argparse.ArgumentParser(description='读取二进制文件并根据proto定义解析')
    parser.add_argument('binary_file', help='要读取的二进制文件路径')
    parser.add_argument('-p', '--proto_dir', help='proto_api目录路径', default='proto_api')
    args = parser.parse_args()
    
    # 获取文件名（不含扩展名）作为消息类型名
    file_basename = os.path.basename(args.binary_file)
    message_class = os.path.splitext(file_basename)[0]
    
    # 构建proto模块名
    proto_module_name = f"{args.proto_dir}.{message_class}_pb2"
    
    try:
        # 动态导入proto模块
        proto_module = importlib.import_module(proto_module_name)
        print(f"成功导入模块: {proto_module_name}")
        
        # 读取二进制文件
        binary_data = read_binary_file(args.binary_file)
        print(f"读取文件大小: {len(binary_data)} 字节")
        
        # 忽略前4个字节
        if len(binary_data) > 4:
            actual_data = binary_data[4:]
            print(f"忽略前4个字节，实际解析大小: {len(actual_data)} 字节")
        else:
            actual_data = binary_data
            print("警告：文件小于4字节，将解析全部内容")
        
        # 解析proto消息
        message = parse_proto_message(actual_data, proto_module, message_class)
        
        if message:
            # 打印解析后的消息内容
            print("\n解析结果:")
            print("=" * 30)
            print(message)
            print("=" * 30)
        else:
            print("解析失败，请确认文件格式与proto定义是否匹配")
    
    except ImportError as e:
        print(f"导入模块失败: {e}")
        print(f"请确保 {proto_module_name} 模块存在")
    except Exception as e:
        print(f"发生错误: {e}")

if __name__ == "__main__":
    main() 