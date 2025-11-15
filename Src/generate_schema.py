import re
import os
import sys

def pascal_to_snake(name):
    if '_' in name:
        parts = name.split('_')
        snake_parts = []
        for part in parts:
            if part:
                s1 = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', part)
                snake_part = re.sub('([a-z0-9])([A-Z])', r'\1_\2', s1).lower()
                snake_parts.append(snake_part)
        return '_'.join(snake_parts)
    else:
        s1 = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', name)
        snake = re.sub('([a-z0-9])([A-Z])', r'\1_\2', s1).lower()
        return snake

def map_csharp_to_flatbuffers(csharp_type):
    type_mapping = {
        'int': 'int32',
        'long': 'int64',
        'uint': 'uint32',
        'ulong': 'uint64',
        'float': 'float',
        'double': 'double',
        'string': 'string',
        'bool': 'bool',
        'byte': 'uint8',
        'sbyte': 'int8',
        'short': 'int16',
        'ushort': 'uint16',
        'Int32': 'int32',
        'Int64': 'int64',
        'UInt32': 'uint32',
        'UInt64': 'uint64',
        'Float': 'float',
        'Double': 'double',
        'String': 'string',
        'Bool': 'bool',
        'Single': 'float',
        'SByte': 'int8',
        'Byte': 'uint8',
        'Int16': 'int16',
        'UInt16': 'uint16',
        'StringOffset': 'string'
    }
    if '<' in csharp_type and '>' in csharp_type:
        return 'string'
    return type_mapping.get(csharp_type, 'string')

def clean_parameter_string(param_str):
    param_str = re.sub(r'/\*[^*]*\*+(?:[^/*][^*]*\*+)*/', '', param_str)
    param_str = re.sub(r'\s+', ' ', param_str).strip()
    return param_str

def extract_structs_from_tbl_namespaces(content):
    all_structs = []
    namespace_pattern = re.compile(r'namespace\s+TBL\s*\{(.*?)\n\}', re.DOTALL)
    namespace_matches = list(namespace_pattern.finditer(content))

    for namespace_match in namespace_matches:
        tbl_content = namespace_match.group(1)
        struct_pattern = re.compile(r'public\s+struct\s+(\w+)\s*:\s*IFlatbufferObject[^{]*\{(.*?)(?=\n\s*public\s+struct|\n\s*\}$)', re.DOTALL)
        
        for struct_match in struct_pattern.finditer(tbl_content):
            struct_name = struct_match.group(1)
            struct_body = struct_match.group(2)
            
            if struct_name.endswith('Table'):
                continue
    
            create_func_pattern = re.compile(
                rf'public\s+static\s+Offset<{re.escape(struct_name)}>\s+Create{re.escape(struct_name)}\s*\(\s*([^)]+)\)\s*;.*',
                re.DOTALL
            )
            
            create_match = create_func_pattern.search(struct_body)
            if not create_match:
                continue
            params_str = create_match.group(1)
            params_str = clean_parameter_string(params_str)
            
            parameters = []
            if params_str.strip():
                param_parts = []
                current_param = ""
                paren_level = 0
                
                for char in params_str + ',':
                    if char == '(':
                        paren_level += 1
                    elif char == ')':
                        paren_level -= 1
                    elif char == ',' and paren_level == 0:
                        if current_param.strip():
                            param_parts.append(current_param.strip())
                        current_param = ""
                        continue
                    current_param += char
                
                for param in param_parts:
                    param = param.strip()
                    if not param or 'FlatBufferBuilder' in param:
                        continue
                    
                    param_match = re.match(r'([\w\.<>]+)\s+(\w+)(?:\s*=\s*[^,]*)?', param)
                    if param_match:
                        param_type = param_match.group(1)
                        param_name = param_match.group(2)
                        
                        if param_name.endswith('Offset'):
                            clean_name = param_name[:-6] if param_name != 'Offset' else param_name
                            param_name = clean_name
                        
                        parameters.append((param_type, param_name))
            
            if parameters:
                all_structs.append((struct_name, parameters))
                
    return all_structs

def generate_fbs(struct_name, parameters):
    namespace = "Tbl"

    main_table = f"table {struct_name} {{\n"
    for param_type, param_name in parameters:
        fb_type = map_csharp_to_flatbuffers(param_type)
        snake_name = pascal_to_snake(param_name)
        main_table += f"  {snake_name}: {fb_type};\n"
    main_table += "}\n\n"

    table_name = f"{struct_name}Table"
    # field_name = pascal_to_snake(struct_name + "s")
    field_name = "json"
    wrapper_table = f"table {table_name} {{\n  {field_name}: [{struct_name}];\n}}\n\n"
    
    root = f"root_type {table_name};\n"

    schema = f"namespace {namespace};\n\n{main_table}{wrapper_table}{root}"
    return schema

def main():
    input_file = 'il2cpp.cs'
    output_dir = '../schema'

    if not os.path.exists(input_file):
        print(f"错误: 输入文件 {input_file} 不存在。")
        sys.exit(1)

    with open(input_file, 'r', encoding='utf-8') as f:
        content = f.read()

    structs = extract_structs_from_tbl_namespaces(content)

    if not structs:
        print("没有在任何 TBL 命名空间中找到符合条件的 Create 函数。")
        sys.exit(0)

    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
        
    print(f"共找到 {len(structs)} 个符合条件的结构，开始生成 schema...")
    for struct_name, parameters in structs:
        schema = generate_fbs(struct_name, parameters)
        output_path = os.path.join(output_dir, f"{struct_name}.fbs")
        with open(output_path, 'w', encoding='utf-8') as f:
            f.write(schema)
        print(f"已生成: {output_path}")

if __name__ == "__main__":
    main()