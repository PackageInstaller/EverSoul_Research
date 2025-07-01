import re
import os
import sys

def pascal_to_snake(name):
    """
    将 PascalCase 或 camelCase 转换为 snake_case。
    """
    s1 = re.sub('(.)([A-Z][a-z]+)', r'\1_\2', name)
    snake = re.sub('([a-z0-9])([A-Z])', r'\1_\2', s1).lower()
    return snake

def map_csharp_to_flatbuffers(csharp_type):
    """
    将 C# 类型映射到 FlatBuffers 类型。
    """
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
    return type_mapping.get(csharp_type, 'string')

def clean_parameter_string(param_str):
    """
    清理参数字符串，移除注释和多余的空白
    """
    # 移除 /* ... */ 注释
    param_str = re.sub(r'/\*[^*]*\*+(?:[^/*][^*]*\*+)*/', '', param_str)
    # 移除多余的空白
    param_str = re.sub(r'\s+', ' ', param_str).strip()
    return param_str

def extract_create_functions_from_tbl_namespace(content):
    """
    从TBL命名空间中提取 CreateXxx 函数及其参数。
    返回一个列表，每个元素是 (struct_name, parameters) 的元组。
    """
    structs = []
    
    namespace_pattern = re.compile(r'namespace\s+TBL\s*\{(.*?)\n\}', re.DOTALL)
    namespace_match = namespace_pattern.search(content)
    
    if not namespace_match:
        print("未找到 TBL 命名空间")
        return structs
    
    tbl_content = namespace_match.group(1)
    
    struct_pattern = re.compile(r'public\s+struct\s+(\w+)\s*:\s*IFlatbufferObject[^{]*\{(.*?)(?=\n\s*public\s+struct|\n\s*\}$)', re.DOTALL)
    
    for struct_match in struct_pattern.finditer(tbl_content):
        struct_name = struct_match.group(1)
        struct_body = struct_match.group(2)
        
        if struct_name.endswith('Table'):
            continue
        
        create_func_pattern = re.compile(
            rf'public\s+static\s+Offset<{re.escape(struct_name)}>\s+Create{re.escape(struct_name)}\s*\(\s*([^)]+)\)\s*;',
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
                if not param:
                    continue
                
                if 'FlatBufferBuilder' in param:
                    continue
                
                param_match = re.match(r'(\w+(?:<\w+>)?)\s+(\w+)(?:\s*=\s*[^,]*)?', param)
                if param_match:
                    param_type = param_match.group(1)
                    param_name = param_match.group(2)
                    
                    if param_name.endswith('Offset'):
                        clean_name = param_name[:-6] if param_name != 'Offset' else param_name
                        param_name = clean_name
                    
                    parameters.append((param_type, param_name))
        
        if parameters:
            structs.append((struct_name, parameters))
    
    return structs

def generate_fsb(struct_name, parameters):
    """
    根据提取的信息生成 FlatBuffers 的 schema 字符串。
    """
    namespace = "Tbl"

    main_table = f"table {struct_name} {{\n"
    for param_type, param_name in parameters:
        fb_type = map_csharp_to_flatbuffers(param_type)
        snake_name = pascal_to_snake(param_name)
        main_table += f"  {snake_name}: {fb_type};\n"
    main_table += "}\n\n"

    table_name = f"{struct_name}Table"
    field_name = pascal_to_snake(struct_name + "s")
    wrapper_table = f"table {table_name} {{\n  {field_name}: [{struct_name}];\n}}\n\n"
    
    root = f"root_type {table_name};\n"

    schema = f"namespace {namespace};\n\n{main_table}{wrapper_table}{root}"
    return schema

def main():
    input_file = 'types.cs'
    output_dir = '../schema'

    if not os.path.exists(input_file):
        print(f"Error: {input_file} 不存在。")
        sys.exit(1)

    with open(input_file, 'r', encoding='utf-8') as f:
        content = f.read()

    structs = extract_create_functions_from_tbl_namespace(content)

    if not structs:
        print("没有找到符合条件的 Create 函数。")
        sys.exit(0)

    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    for struct_name, parameters in structs:
        schema = generate_fsb(struct_name, parameters)
        output_path = os.path.join(output_dir, f"{struct_name}.fbs")
        with open(output_path, 'w', encoding='utf-8') as f:
            f.write(schema)
        print(f"生成了 {output_path}")

if __name__ == "__main__":
    main()