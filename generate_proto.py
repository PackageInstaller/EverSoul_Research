#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import re
import os
import sys
from collections import defaultdict
import argparse

def parse_cs_file(proto_type, file_path):
    """解析C#文件，提取消息类型定义
    
    Args:
        file_path: C#文件路径
        
    Returns:
        包含提取的类型定义的字典
    """
    print(f"解析文件: {file_path}")
    
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read()

    if proto_type is None:
        namespace = "EsPb"
    else:
        namespace = proto_type
    
    # 分割文件内容，按照命名空间的注释进行分割
    namespace_sections = re.split(r'//\s*Namespace:\s*(\w+)', content)
    
    message_types = {}
    enum_types = {}
    
    # 处理每个命名空间部分
    for i in range(1, len(namespace_sections), 2):
        section_namespace = namespace_sections[i]
        section_content = namespace_sections[i+1] if i+1 < len(namespace_sections) else ""
        
        # 只处理EsPb命名空间
        if section_namespace != "EsPb":
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
    
    with open(output_file, 'w', encoding='utf-8') as f:
        # 写入头部
        f.write(f'syntax = "proto3";\n\n')
        f.write(f'package {namespace};\n\n')
        
        # 写入所有枚举定义
        for enum_name, enum_values in enum_types.items():
            f.write(f'enum {enum_name} {{\n')
            for value_name, value_number in enum_values:
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

def process_dump_file(proto_type, file_path, output_dir=None):
    """处理dump.cs文件并生成相应的proto文件
    
    Args:
        file_path: dump.cs文件路径
        output_dir: 输出目录（可选）
    """
    if output_dir is None:
        output_dir = os.path.dirname(file_path)
    
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
    
    print(f"处理完成。共生成 {generated_count} 个proto文件。")

def main():
    parser = argparse.ArgumentParser(description='从C#文件生成proto文件')
    parser.add_argument('input_file', help='输入的C#文件路径')
    parser.add_argument('-o', '--output_dir', help='输出目录路径', default=None)
    parser.add_argument('-p', '--proto_type', help='proto类型', default=None)
    args = parser.parse_args()
    
    process_dump_file(args.proto_type, args.input_file, args.output_dir)

if __name__ == "__main__":
    main() 