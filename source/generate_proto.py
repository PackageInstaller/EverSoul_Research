#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import os
import sys
import subprocess
import glob
import shutil
from collections import defaultdict

def parse_cs_file(proto_type, file_path):
    """解析C#文件，提取消息类型定义
    
    Args:
        proto_type: proto类型命名空间
        file_path: C#文件路径
        
    Returns:
        包含提取的类型定义的字典
    """
    print(f"解析文件: {file_path}，命名空间: {proto_type}")
    
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read()

    namespace = proto_type
    
    # 分割文件内容，按照命名空间的注释进行分割
    namespace_sections = re.split(r'//\s*Namespace:\s*(\w+)', content)
    
    message_types = {}
    enum_types = {}
    
    # 处理每个命名空间部分
    for i in range(1, len(namespace_sections), 2):
        section_namespace = namespace_sections[i]
        section_content = namespace_sections[i+1] if i+1 < len(namespace_sections) else ""
        
        # 只处理指定命名空间
        if section_namespace != proto_type:
            continue
        
        # 提取枚举类型
        enum_pattern = r'public\s+enum\s+(\w+)[^{]*{([^}]*)}'
        enum_matches = re.finditer(enum_pattern, section_content)
        
        for match in enum_matches:
            enum_name = match.group(1)
            enum_content = match.group(2)
            
            # 提取枚举值
            enum_values = []
            for line in enum_content.split('\n'):
                # 匹配 public const E_XXX Value = 1; 这样的模式
                value_match = re.search(r'public\s+const\s+\w+\s+(\w+)\s*=\s*(\d+)', line)
                if value_match:
                    enum_values.append((value_match.group(1), int(value_match.group(2))))
            
            if enum_values:
                enum_types[enum_name] = sorted(enum_values, key=lambda x: x[1])
        
        # 查找所有类定义
        class_pattern = r'public\s+sealed\s+class\s+(\w+)\s*:\s*IMessage<\1>'
        classes = re.findall(class_pattern, section_content)
        
        # 提取每个类的字段
        for class_name in classes:
            # 查找完整的类定义
            class_def_pattern = r'public\s+sealed\s+class\s+' + class_name + r'\s*:.*?{(.*?)(?=}\s*(?:\/\/|$))'
            class_match = re.search(class_def_pattern, section_content, re.DOTALL)
            
            if not class_match:
                continue
            
            class_content = class_match.group(1)
            
            # 提取字段
            fields = []
            
            # 获取所有字段编号定义
            field_number_pattern = r'public\s+const\s+int\s+(\w+)FieldNumber\s*=\s*(\d+);'
            field_number_matches = re.finditer(field_number_pattern, class_content)
            
            for field_number_match in field_number_matches:
                field_name = field_number_match.group(1)
                field_number = int(field_number_match.group(2))
                # 按照proto命名规则，首字母改为小写
                proto_field_name = field_name[0].lower() + field_name[1:]
                
                # 查找该字段是否为repeated类型，先在字段编码器中查找
                is_repeated = False
                field_type = None
                
                # 查找 RepeatedField 编码器定义
                codec_pattern = r'private\s+static\s+readonly\s+FieldCodec<(\w+)>\s+_repeated_' + field_name.lower() + r'_codec;'
                codec_match = re.search(codec_pattern, class_content, re.IGNORECASE)
                if codec_match:
                    is_repeated = True
                    field_type = codec_match.group(1)
                
                # 如果没找到编码器，尝试从字段定义中查找
                if not field_type:
                    # 查找字段定义，兼容大小写
                    field_def_pattern = r'private\s+(readonly\s+RepeatedField<(\w+)>|(\w+))\s+' + field_name.lower() + r'_;'
                    field_def_match = re.search(field_def_pattern, class_content, re.IGNORECASE)
                    
                    if field_def_match:
                        # 检查是否是RepeatedField
                        if field_def_match.group(2):  # 匹配到RepeatedField
                            is_repeated = True
                            field_type = field_def_match.group(2)
                        else:  # 普通字段
                            field_type = field_def_match.group(3)
                
                # 如果还是找不到类型，使用一个通用方法尝试提取
                if not field_type:
                    # 查找所有可能的字段定义
                    field_def_pattern = r'private\s+(?:readonly\s+)?(?:RepeatedField<)?(\w+)(?:>)?\s+' + field_name.lower() + r'_;'
                    field_def_match = re.search(field_def_pattern, class_content, re.IGNORECASE)
                    
                    if field_def_match:
                        field_type = field_def_match.group(1)
                        # 再次检查是否是Repeated类型
                        repeated_check = re.search(r'private\s+readonly\s+RepeatedField<' + field_type + r'>\s+' + field_name.lower() + r'_;', class_content, re.IGNORECASE)
                        if repeated_check:
                            is_repeated = True
                
                # 最后的兜底检查
                if not field_type:
                    # 只要找到任何与字段名相关的定义
                    any_field_def = re.search(r'private.*?' + field_name.lower() + r'_', class_content, re.IGNORECASE)
                    if any_field_def:
                        field_def_line = any_field_def.group(0)
                        # 尝试从中提取类型
                        type_match = re.search(r'private\s+(?:readonly\s+)?(?:RepeatedField<)?(\w+)', field_def_line)
                        if type_match:
                            field_type = type_match.group(1)
                            if 'RepeatedField' in field_def_line:
                                is_repeated = True
                
                # 如果仍然找不到类型，使用默认值
                if not field_type:
                    field_type = "string"  # 默认为string类型
                
                fields.append((proto_field_name, field_number, field_type, is_repeated))
            
            if fields:
                message_types[class_name] = sorted(fields, key=lambda x: x[1])
    
    return namespace, message_types, enum_types

def cs_type_to_proto_type(cs_type, known_messages):
    """将C#类型转换为proto类型
    
    Args:
        cs_type: C#类型名称
        known_messages: 已知消息类型列表
    
    Returns:
        相应的proto类型名称
    """
    type_mapping = {
        'int': 'int32',
        'Int32': 'int32',
        'long': 'int64',
        'Int64': 'int64',
        'uint': 'uint32',
        'UInt32': 'uint32',
        'ulong': 'uint64',
        'UInt64': 'uint64',
        'float': 'float',
        'Float': 'float',
        'double': 'double',
        'Double': 'double',
        'bool': 'bool',
        'Bool': 'bool',
        'string': 'string',
        'ByteString': 'bytes'
    }
    
    # 如果是基础类型映射
    if cs_type in type_mapping:
        return type_mapping[cs_type]
    
    # 其他类型保持原样
    return cs_type

def generate_proto_file(namespace, message_types, enum_types, output_file):
    """生成proto文件
    
    Args:
        namespace: 命名空间
        message_types: 消息类型字典
        enum_types: 枚举类型字典
        output_file: 输出文件路径
    """
    print(f"生成proto文件: {output_file}")
    
    # 创建消息类型名称集合，用于检查命名冲突
    message_type_names = set(message_types.keys())
    
    with open(output_file, 'w', encoding='utf-8') as f:
        # 写入头部
        f.write(f'syntax = "proto3";\n\n')
        f.write(f'package {namespace};\n\n')
        
        # 写入所有枚举定义
        for enum_name, enum_values in enum_types.items():
            f.write(f'enum {enum_name} {{\n')
            for value_name, value_number in enum_values:
                # 检查枚举值是否与消息类型同名
                if value_name in message_type_names:
                    # 如果冲突，在枚举值后添加下划线
                    value_name = value_name + "_"
                
                f.write(f'  {value_name} = {value_number};\n')
            f.write('}\n\n')
        
        # 写入所有消息类型定义
        for message_name, fields in message_types.items():
            f.write(f'message {message_name} {{\n')
            
            for field_name, field_number, field_type, is_repeated in fields:
                # 转换类型
                proto_field_type = cs_type_to_proto_type(field_type, message_types.keys())
                
                # 是否是repeated字段
                repeated = "repeated " if is_repeated else ""
                
                f.write(f'  {repeated}{proto_field_type} {field_name} = {field_number};\n')
            
            f.write('}\n\n')

def process_dump_file(proto_type, file_path, output_dir):
    """处理dump.cs文件并生成相应的proto文件
    
    Args:
        proto_type: proto类型
        file_path: dump.cs文件路径
        output_dir: 输出目录
        
    Returns:
        生成的proto文件数量
    """
    # 确保输出目录存在
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
    
    # 解析CS文件
    namespace, message_types, enum_types = parse_cs_file(proto_type, file_path)
    
    # 计数器，用于记录生成的文件数量
    generated_count = 0
    
    # 对于每个消息类型，生成一个proto文件
    for message_name in message_types:
        # 跳过以's'开头的消息类型，这些类型通常用作其他消息的字段补充
        if message_name.startswith('s'):
            continue
            
        # 创建一个集合用于存储所有需要包含的消息类型
        related_messages = {}
        related_enums = {}
        
        # 添加当前消息
        related_messages[message_name] = message_types[message_name]
        
        # 递归查找所有引用的类型
        def find_referenced_types(msg_name, msg_fields):
            for field_name, field_number, field_type, is_repeated in msg_fields:
                if field_type in message_types and field_type not in related_messages:
                    related_messages[field_type] = message_types[field_type]
                    # 递归查找新添加消息中引用的类型
                    find_referenced_types(field_type, message_types[field_type])
                elif field_type in enum_types and field_type not in related_enums:
                    related_enums[field_type] = enum_types[field_type]

        # 查找直接引用的类型
        find_referenced_types(message_name, message_types[message_name])
        
        # 检查字段中可能存在的枚举类型引用
        for field_name, field_number, field_type, is_repeated in message_types[message_name]:
            # 查找该字段类型是否为枚举
            for enum_name in enum_types:
                if enum_name == field_type or f"E_{field_type}" == enum_name or field_type == f"E_{enum_name}":
                    related_enums[enum_name] = enum_types[enum_name]
        
        # 生成proto文件
        output_file = os.path.join(output_dir, f"{message_name}.proto")
        generate_proto_file(namespace, related_messages, related_enums, output_file)
        generated_count += 1
    
    return generated_count

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
        print(f"编译文件: {proto_file}")
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
    
    # 输入文件
    input_file = "dump.cs"
    
    # 检查输入文件是否存在
    if not os.path.exists(input_file):
        print(f"错误: 输入文件 {input_file} 不存在")
        return 1
    
    # 定义目录
    receive_proto_dir = "../receive_proto"
    request_proto_dir = "../request_proto"
    receive_output_dir = "../receive_proto_api"
    request_output_dir = "../request_proto_api"
    
    # 第一步：生成proto文件
    print("=" * 50)
    print("第一步：生成proto文件")
    print("=" * 50)
    
    proto_types = ["EsPb", "ReqPb"]
    total_proto_generated = 0
    
    for proto_type in proto_types:
        # 设置输出目录
        if proto_type == "EsPb":
            output_dir = receive_proto_dir
        else:  # ReqPb
            output_dir = request_proto_dir
        
        print(f"\n处理 {proto_type} 类型...")
        generated_count = process_dump_file(proto_type, input_file, output_dir)
        total_proto_generated += generated_count
        print(f"{proto_type} 类型生成了 {generated_count} 个proto文件")
    
    print(f"\nproto文件生成完成，共生成 {total_proto_generated} 个文件")
    
    # 第二步：编译proto文件为Python API
    print("\n" + "=" * 50)
    print("第二步：编译proto文件为Python API")
    print("=" * 50)
    
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
    print("\n编译接收proto文件...")
    if os.path.exists(receive_proto_dir):
        success, fail = process_proto_directory(receive_proto_dir, receive_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
        create_init_file(receive_output_dir)
    else:
        print(f"目录 {receive_proto_dir} 不存在，跳过")
    
    # 处理请求proto
    print("\n编译请求proto文件...")
    if os.path.exists(request_proto_dir):
        success, fail = process_proto_directory(request_proto_dir, request_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
        create_init_file(request_output_dir)
    else:
        print(f"目录 {request_proto_dir} 不存在，跳过")
    
    # 输出最终统计信息
    print("\n" + "=" * 50)
    print("处理完成统计")
    print("=" * 50)
    print(f"生成proto文件: {total_proto_generated} 个")
    print(f"编译成功: {total_success} 个")
    print(f"编译失败: {total_fail} 个")
    
    if total_fail > 0:
        return 1
    return 0

if __name__ == "__main__":
    sys.exit(main()) 