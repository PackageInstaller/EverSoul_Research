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
        'Int32': 'int32',
        'Int64': 'int64',
        'long': 'int64',
        'UInt32': 'uint32',
        'uint': 'uint32',
        'UInt64': 'uint64',
        'ulong': 'uint64',
        'Float': 'float',
        'float': 'float',
        'Double': 'double',
        'double': 'double',
        'String': 'string',
        'string': 'string',
        'StringOffset': 'string',
        'Bool': 'bool',
        'bool': 'bool',
        'Single': 'float',
        'SByte': 'int8',
        'sbyte': 'int8',
        'Byte': 'uint8',
        'byte': 'uint8',
        'Int16': 'int16',
        'short': 'int16',
        'UInt16': 'uint16',
        'ushort': 'uint16',
    }
    # 可空类型
    # nullable_match = re.match(r'Nullable<(\w+)>', csharp_type)
    # if nullable_match:
    #     base_type = nullable_match.group(1)
    #     return type_mapping.get(base_type, 'string')
    return type_mapping.get(csharp_type, 'string')

def extract_structs_and_create_methods(content):
    """
    提取实现了 IFlatbufferObject 且不以 'Table' 结尾的结构体，
    并从对应的 CreateXXX 方法中提取参数信息。
    返回一个列表，每个元素是 (struct_name, parameters) 的元组。
    """
    structs = []
    struct_pattern = re.compile(r'public\s+struct\s+(\w+)\s*:\s*IFlatbufferObject')
    
    for match in struct_pattern.finditer(content):
        struct_name = match.group(1)
        # 排除以 'Table' 结尾的结构体
        if struct_name.endswith('Table'):
            continue
        
        # 查找对应的 CreateXXX 方法
        create_method_pattern = re.compile(
            rf'public\s+static\s+Offset<{struct_name}>\s+Create{struct_name}\s*\(\s*FlatBufferBuilder\s+builder\s*,([^)]*)\)',
            re.MULTILINE | re.DOTALL
        )
        
        create_match = create_method_pattern.search(content)
        if not create_match:
            continue
        
        # 提取参数列表
        params_str = create_match.group(1).strip()
        if not params_str:
            continue
        
        # 解析参数
        parameters = []
        # 分割参数，处理默认值
        param_parts = re.split(r',(?![^<>]*>)', params_str)
        
        for param in param_parts:
            param = param.strip()
            if not param:
                continue
            
            # 匹配参数格式: type name = default_value 或 type name
            param_match = re.match(r'(\w+(?:<[^>]+>)?)\s+(\w+)(?:\s*=\s*[^,]*)?', param)
            if param_match:
                param_type = param_match.group(1)
                param_name = param_match.group(2)
                # 跳过 builder 参数
                if param_name.lower() != 'builder':
                    parameters.append((param_type, param_name))
        
        if parameters:
            structs.append((struct_name, parameters))
    
    return structs

def generate_fsb(struct_name, parameters):
    """
    根据提取的信息生成 FlatBuffers 的 schema 字符串。
    将命名空间设置为结构体名称。
    """
    # 将命名空间设置为结构体名称
    namespace = struct_name

    deserialization_table = "table Deserialization {\n"
    for param_type, param_name in parameters:
        fb_type = map_csharp_to_flatbuffers(param_type)
        # 如果映射结果为 None，则跳过该参数
        if fb_type is None:
            continue
        # 保持原始参数名，不转换为snake_case
        deserialization_table += f"    {param_name}: {fb_type};\n"
    deserialization_table += "}\n\n"

    main_table = f"table {struct_name} {{\n    json: [Deserialization];\n}}\n\n"
    root = f"root_type {struct_name};\n"

    schema = f"namespace {namespace};\n\n{deserialization_table}{main_table}{root}"
    return schema

def main():
    input_file = 'dump.cs'
    output_dir = '../schema'

    if not os.path.exists(input_file):
        print(f"Error: {input_file} 不存在。")
        sys.exit(1)

    with open(input_file, 'r', encoding='utf-8') as f:
        content = f.read()

    structs = extract_structs_and_create_methods(content)

    if not structs:
        print("没有找到符合条件的结构体。")
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
