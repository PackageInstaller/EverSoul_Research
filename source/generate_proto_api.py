#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import os
import subprocess
import sys
import glob
import shutil

def ensure_directory(directory):
    """确保目录存在，如果不存在则创建"""
    if not os.path.exists(directory):
        os.makedirs(directory)
        print(f"创建目录: {directory}")

def compile_proto_to_python(proto_file, output_dir):
    """将单个proto文件编译为Python代码
    
    Args:
        proto_file: proto文件路径
        output_dir: 输出目录
    
    Returns:
        编译是否成功
    """
    try:
        cmd = ["protoc", f"--python_out={output_dir}", f"-I={os.path.dirname(proto_file)}", proto_file]
        result = subprocess.run(cmd, check=True, stderr=subprocess.PIPE, text=True)
        return True
    except subprocess.CalledProcessError as e:
        print(f"编译 {proto_file} 失败: {e.stderr}")
        return False
    except Exception as e:
        print(f"编译 {proto_file} 时发生错误: {str(e)}")
        return False

def process_proto_directory(proto_dir, output_dir):
    """处理一个proto目录中的所有文件
    
    Args:
        proto_dir: proto文件目录
        output_dir: 输出目录
        
    Returns:
        (成功数, 失败数)
    """
    # 确保输出目录存在
    ensure_directory(output_dir)
    
    # 查找所有proto文件
    proto_files = glob.glob(os.path.join(proto_dir, "*.proto"))
    print(f"在 {proto_dir} 中找到 {len(proto_files)} 个proto文件")
    
    # 编译所有proto文件
    success_count = 0
    fail_count = 0
    
    for proto_file in proto_files:
        print(f"处理文件: {proto_file}")
        if compile_proto_to_python(proto_file, output_dir):
            success_count += 1
        else:
            fail_count += 1
    
    return success_count, fail_count

def create_init_file(directory):
    """在目录中创建__init__.py文件"""
    init_file = os.path.join(directory, "__init__.py")
    if not os.path.exists(init_file):
        with open(init_file, 'w', encoding='utf-8') as f:
            pass  # 创建空文件
        print(f"创建文件: {init_file}")

def main():
    # 设置工作目录为脚本所在目录
    script_dir = os.path.dirname(os.path.abspath(__file__))
    os.chdir(script_dir)
    
    # 定义源目录和目标目录
    receive_proto_dir = "../receive_proto"
    request_proto_dir = "../request_proto"
    receive_output_dir = "../receive_proto_api"
    request_output_dir = "../request_proto_api"
    
    # 清空输出目录
    for output_dir in [receive_output_dir, request_output_dir]:
        if os.path.exists(output_dir):
            for item in os.listdir(output_dir):
                item_path = os.path.join(output_dir, item)
                if os.path.isfile(item_path):
                    os.remove(item_path)
                elif os.path.isdir(item_path):
                    shutil.rmtree(item_path)
    
    total_success = 0
    total_fail = 0
    
    # 处理接收proto
    print("\n处理接收proto文件...")
    if os.path.exists(receive_proto_dir):
        success, fail = process_proto_directory(receive_proto_dir, receive_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
        create_init_file(receive_output_dir)
    else:
        print(f"目录 {receive_proto_dir} 不存在，跳过")
    
    # 处理请求proto
    print("\n处理请求proto文件...")
    if os.path.exists(request_proto_dir):
        success, fail = process_proto_directory(request_proto_dir, request_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
        create_init_file(request_output_dir)
    else:
        print(f"目录 {request_proto_dir} 不存在，跳过")
    
    # 输出统计信息
    print("\n编译完成:")
    print(f"成功: {total_success} 个文件")
    print(f"失败: {total_fail} 个文件")
    
    if total_fail > 0:
        return 1
    return 0

if __name__ == "__main__":
    sys.exit(main()) 