import re
import os
import sys
import subprocess
import glob
import shutil

def parse_cs_file_from_types(proto_type, file_path):
    print(f"解析types.cs文件: {file_path}，命名空间: {proto_type}")
    
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read()

    namespace = proto_type
    
    # --- 核心修改部分 ---
    # 1. 修改正则表达式，使其更简单、更通用，能匹配一个完整的命名空间块。
    namespace_pattern = re.compile(rf'namespace\s+{re.escape(proto_type)}\s*{{(.*?)\n}}', re.DOTALL)
    
    # 2. 使用 re.finditer 遍历所有匹配的命名空间块，并将它们的内容拼接起来。
    combined_content = ""
    matches = namespace_pattern.finditer(content)
    for match in matches:
        combined_content += match.group(1)

    # 3. 如果拼接后的内容为空，则说明确实没有找到任何匹配的命名空间。
    if not combined_content:
        print(f"未找到命名空间 {proto_type}")
        return namespace, {}, {}
    
    # 4. 后续所有的解析操作都基于拼接后的 combined_content 进行，而不是单个的 section_content。
    section_content = combined_content
    # --- 修改结束 ---

    message_types = {}
    enum_types = {}
    
    enum_pattern = r'public\s+enum\s+(\w+)[^{]*\{([^}]*)\}'
    enum_matches = re.finditer(enum_pattern, section_content, re.DOTALL)
    
    for match in enum_matches:
        enum_name = match.group(1)
        enum_content = match.group(2)
        
        enum_values = []
        value_pattern = r'(\w+)\s*=\s*(\d+)'
        value_matches = re.finditer(value_pattern, enum_content)
        
        for value_match in value_matches:
            enum_values.append((value_match.group(1), int(value_match.group(2))))
        
        if enum_values:
            enum_types[enum_name] = sorted(enum_values, key=lambda x: x[1])
    
    class_pattern = rf'public\s+sealed\s+class\s+(\w+)\s*:\s*IMessage<(?:{re.escape(proto_type)}\.)?(\w+)>'
    classes = []
    
    for match in re.finditer(class_pattern, section_content):
        class_name = match.group(1)
        if match.group(2) == class_name:
            classes.append(class_name)
    
    for class_name in classes:
        class_def_pattern = rf'public\s+sealed\s+class\s+{re.escape(class_name)}\s*:[^{{]*\{{(.*?)(?=\n\s*public\s+(?:sealed\s+)?class|\n\s*public\s+enum|\n\s*\}}\s*$)'
        class_match = re.search(class_def_pattern, section_content, re.DOTALL)
        
        if not class_match:
            continue
        
        class_content = class_match.group(1)
        
        fields = []
        
        field_number_pattern = r'public\s+const\s+int\s+(\w+)FieldNumber\s*=\s*(\d+);'
        field_number_matches = re.finditer(field_number_pattern, class_content)
        
        for field_number_match in field_number_matches:
            field_name = field_number_match.group(1)
            field_number = int(field_number_match.group(2))
            proto_field_name = field_name[0].lower() + field_name[1:]
            
            is_repeated = False
            field_type = None
            
            codec_pattern = rf'private\s+static\s+readonly\s+FieldCodec<([^>]+)>\s+_repeated_{re.escape(field_name.lower())}_codec'
            codec_match = re.search(codec_pattern, class_content, re.IGNORECASE)
            if codec_match:
                is_repeated = True
                field_type = codec_match.group(1)
            
            if not field_type:
                repeated_field_pattern = rf'private\s+readonly\s+RepeatedField<([^>]+)>\s+{re.escape(field_name.lower())}_'
                repeated_match = re.search(repeated_field_pattern, class_content, re.IGNORECASE)
                
                if repeated_match:
                    is_repeated = True
                    field_type = repeated_match.group(1)
                else:
                    normal_field_pattern = rf'private\s+([^;]+?)\s+{re.escape(field_name.lower())}_'
                    normal_match = re.search(normal_field_pattern, class_content, re.IGNORECASE)
                    
                    if normal_match:
                        field_type_def = normal_match.group(1).strip()
                        type_match = re.search(r'(\w+(?:\.\w+)?)$', field_type_def)
                        if type_match:
                            field_type = type_match.group(1)
            
            if field_type:
                if '.' in field_type:
                    field_type = field_type.split('.')[-1]
            
            if not field_type:
                field_type = "string"
            
            fields.append((proto_field_name, field_number, field_type, is_repeated))
        
        if fields:
            message_types[class_name] = sorted(fields, key=lambda x: x[1])
    
    return namespace, message_types, enum_types

# ----- 以下的函数无需修改，保持原样即可 -----

def cs_type_to_proto_type(cs_type, known_messages):
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
        'String': 'string',
        'ByteString': 'bytes'
    }
    
    if cs_type in type_mapping:
        return type_mapping[cs_type]
    
    if '.' in cs_type:
        cs_type = cs_type.split('.')[-1]
    
    return cs_type

def generate_proto_file(namespace, message_types, enum_types, output_file):
    print(f"生成proto文件: {output_file}")
    
    message_type_names = set(message_types.keys())
    
    with open(output_file, 'w', encoding='utf-8') as f:
        f.write(f'syntax = "proto3";\n\n')
        f.write(f'package {namespace};\n\n')
        
        for enum_name, enum_values in enum_types.items():
            f.write(f'enum {enum_name} {{\n')
            for value_name, value_number in enum_values:
                if value_name in message_type_names:
                    value_name = value_name + "_"
                
                f.write(f'  {value_name} = {value_number};\n')
            f.write('}\n\n')
        
        for message_name, fields in message_types.items():
            f.write(f'message {message_name} {{\n')
            
            for field_name, field_number, field_type, is_repeated in fields:
                proto_field_type = cs_type_to_proto_type(field_type, message_types.keys())
                
                repeated = "repeated " if is_repeated else ""
                
                f.write(f'  {repeated}{proto_field_type} {field_name} = {field_number};\n')
            
            f.write('}\n\n')

def process_types_file(proto_type, file_path, output_dir):

    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
    
    namespace, message_types, enum_types = parse_cs_file_from_types(proto_type, file_path)
    
    generated_count = 0
    
    for message_name in message_types:
        if message_name[0].islower():
            continue
            
        related_messages = {}
        related_enums = {}
        
        related_messages[message_name] = message_types[message_name]
        
        def find_referenced_types(msg_name, msg_fields):
            for field_name, field_number, field_type, is_repeated in msg_fields:
                if field_type in message_types and field_type not in related_messages:
                    related_messages[field_type] = message_types[field_type]
                    find_referenced_types(field_type, message_types[field_type])
                elif field_type in enum_types and field_type not in related_enums:
                    related_enums[field_type] = enum_types[field_type]

        find_referenced_types(message_name, message_types[message_name])
        
        for field_name, field_number, field_type, is_repeated in message_types[message_name]:
            for enum_name in enum_types:
                if enum_name == field_type or f"E_{field_type}" == enum_name or field_type == f"E_{enum_name}":
                    related_enums[enum_name] = enum_types[enum_name]
        
        output_file = os.path.join(output_dir, f"{message_name}.proto")
        generate_proto_file(namespace, related_messages, related_enums, output_file)
        generated_count += 1
    
    return generated_count

def ensure_directory(directory):
    if not os.path.exists(directory):
        os.makedirs(directory)

def compile_proto_to_python(proto_file, output_dir):

    try:
        cmd = ["protoc", f"--python_out={output_dir}", f"-I={os.path.dirname(proto_file)}", proto_file]
        subprocess.run(cmd, check=True, stderr=subprocess.PIPE, text=True)
        return True
    except subprocess.CalledProcessError as e:
        print(f"编译 {proto_file} 失败: {e.stderr}")
        return False
    except Exception as e:
        print(f"编译 {proto_file} 时发生错误: {str(e)}")
        return False

def process_proto_directory(proto_dir, output_dir):

    ensure_directory(output_dir)
    
    proto_files = glob.glob(os.path.join(proto_dir, "*.proto"))
    print(f"在 {proto_dir} 中找到 {len(proto_files)} 个proto文件")
    
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
            pass
        print(f"创建文件: {init_file}")

def main():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    os.chdir(script_dir)
    
    response_proto_dir = "../response_proto"
    request_proto_dir = "../request_proto"
    eschatpb_proto_dir = "../eschatpb_proto"
    response_output_dir = "../response_proto_api"
    request_output_dir = "../request_proto_api"
    eschatpb_output_dir = "../eschatpb_proto_api"
    
    proto_types = ["EsPb", "ReqPb", "EsChatPb"]
    total_proto_generated = 0
    
    for proto_type in proto_types:
        if proto_type == "EsPb":
            output_dir = response_proto_dir
        elif proto_type == "ReqPb":
            output_dir = request_proto_dir
        else:  # EsChatPb 单独存放
            output_dir = eschatpb_proto_dir
        
        print(f"\n处理 {proto_type} 类型...")
        generated_count = process_types_file(proto_type, "il2cpp.cs", output_dir)
        total_proto_generated += generated_count
        print(f"{proto_type} 类型生成了 {generated_count} 个proto文件")
    
    print(f"\nproto文件生成完成，共生成 {total_proto_generated} 个文件")
    
    for output_dir in [response_output_dir, request_output_dir, eschatpb_output_dir]:
        if os.path.exists(output_dir):
            for item in os.listdir(output_dir):
                item_path = os.path.join(output_dir, item)
                if os.path.isfile(item_path):
                    os.remove(item_path)
                elif os.path.isdir(item_path):
                    shutil.rmtree(item_path)
    
    total_success = 0
    total_fail = 0
    
    print("\n编译响应proto文件...")
    if os.path.exists(response_proto_dir):
        success, fail = process_proto_directory(response_proto_dir, response_output_dir)
        total_success += success
        total_fail += fail
        create_init_file(response_output_dir)
    else:
        print(f"目录 {response_proto_dir} 不存在，跳过")
    
    print("\n编译请求proto文件...")
    if os.path.exists(request_proto_dir):
        success, fail = process_proto_directory(request_proto_dir, request_output_dir)
        total_success += success
        total_fail += fail
        create_init_file(request_output_dir)
    else:
        print(f"目录 {request_proto_dir} 不存在，跳过")
    
    print("\n编译聊天proto文件...")
    if os.path.exists(eschatpb_proto_dir):
        success, fail = process_proto_directory(eschatpb_proto_dir, eschatpb_output_dir)
        total_success += success
        total_fail += fail
        create_init_file(eschatpb_output_dir)
    else:
        print(f"目录 {eschatpb_proto_dir} 不存在，跳过")
    
    print(f"生成proto文件: {total_proto_generated} 个")
    print(f"编译成功: {total_success} 个")
    print(f"编译失败: {total_fail} 个")
    
    if total_fail > 0:
        return 1
    return 0

if __name__ == "__main__":
    sys.exit(main())