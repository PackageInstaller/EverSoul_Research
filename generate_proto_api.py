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
        print(f"执行命令: {' '.join(cmd)}")
        result = subprocess.run(cmd, check=True, stderr=subprocess.PIPE, text=True)
        return True
    except subprocess.CalledProcessError as e:
        print(f"编译 {proto_file} 失败: {e.stderr}")
        return False
    except Exception as e:
        print(f"编译 {proto_file} 时发生错误: {str(e)}")
        return False

def create_init_files(directory):
    """在目录及其子目录中创建__init__.py文件"""
    for root, dirs, files in os.walk(directory):
        init_file = os.path.join(root, "__init__.py")
        if not os.path.exists(init_file):
            with open(init_file, 'w', encoding='utf-8') as f:
                pass  # 创建空文件
            print(f"创建文件: {init_file}")

def main():
    # 设置工作目录为脚本所在目录
    script_dir = os.path.dirname(os.path.abspath(__file__))
    os.chdir(script_dir)
    
    # 定义源目录和目标目录
    proto_dir = "proto"
    output_dir = "proto_api"
    
    # 确保输出目录存在
    ensure_directory(output_dir)
    
    # 清空输出目录（可选）
    for item in os.listdir(output_dir):
        item_path = os.path.join(output_dir, item)
        if os.path.isfile(item_path):
            os.remove(item_path)
        elif os.path.isdir(item_path):
            shutil.rmtree(item_path)
    
    # 查找所有proto文件
    proto_files = glob.glob(os.path.join(proto_dir, "*.proto"))
    
    print(f"找到 {len(proto_files)} 个proto文件")
    
    # 编译所有proto文件
    success_count = 0
    fail_count = 0
    
    for proto_file in proto_files:
        print(f"处理文件: {proto_file}")
        if compile_proto_to_python(proto_file, output_dir):
            success_count += 1
        else:
            fail_count += 1
    
    # 创建__init__.py文件，使输出目录成为Python包
    create_init_files(output_dir)
    
    # 输出统计信息
    print("\n编译完成:")
    print(f"成功: {success_count} 个文件")
    print(f"失败: {fail_count} 个文件")
    
    if fail_count > 0:
        return 1
    return 0

if __name__ == "__main__":
    sys.exit(main()) 