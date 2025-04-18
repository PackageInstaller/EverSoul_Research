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
    }
    # 处理可空类型
    nullable_match = re.match(r'Nullable<(\w+)>', csharp_type)
    if nullable_match:
        base_type = nullable_match.group(1)
        return type_mapping.get(base_type, 'string')  # 未找到时默认为 string
    return type_mapping.get(csharp_type, 'string')

def extract_structs_and_properties(content):
    """
    提取实现了 IFlatbufferObject 且不以 'Table' 结尾的结构体及其属性。
    返回一个列表，每个元素是 (struct_name, properties) 的元组。
    """
    structs = []
    struct_pattern = re.compile(r'public\s+struct\s+(\w+)\s*:\s*IFlatbufferObject')
    for match in struct_pattern.finditer(content):
        struct_name = match.group(1)
        # 排除以 'Table' 结尾的结构体
        if struct_name.endswith('Table'):
            continue
        # 查找结构体的起始位置
        start = match.end()
        # 查找结构体的起始大括号
        brace_start = content.find('{', start)
        if brace_start == -1:
            continue
        # 通过维护大括号的嵌套级别找到结构体的结束位置
        brace_level = 1
        i = brace_start + 1
        while i < len(content) and brace_level > 0:
            if content[i] == '{':
                brace_level += 1
            elif content[i] == '}':
                brace_level -= 1
            i += 1
        struct_body = content[brace_start + 1:i - 1]
        # 提取属性，排除 ByteBuffer
        prop_pattern = re.compile(r'public\s+([\w\<\>\[\]]+)\s+(\w+)\s*\{\s*get;\s*\}')
        props = prop_pattern.findall(struct_body)
        # 过滤掉 ByteBuffer 属性
        props = [prop for prop in props if prop[1] != 'ByteBuffer']
        if props:
            structs.append((struct_name, props))
    return structs

def generate_fsb(struct_name, properties):
    """
    根据提取的信息生成 FlatBuffers 的 schema 字符串。
    将命名空间设置为结构体名称，并排除不需要的属性。
    """
    # 将命名空间设置为结构体名称
    namespace = struct_name

    deserialization_table = "table Deserialization {\n"
    for csharp_type, prop_name in properties:
        fb_type = map_csharp_to_flatbuffers(csharp_type)
        # 如果映射结果为 None，则跳过该属性
        if fb_type is None:
            continue
        snake_name = pascal_to_snake(prop_name)
        deserialization_table += f"    {snake_name}: {fb_type};\n"
    deserialization_table += "}\n\n"

    main_table = f"table {struct_name} {{\n    json: [Deserialization];\n}}\n\n"
    root = f"root_type {struct_name};\n"

    schema = f"namespace {namespace};\n\n{deserialization_table}{main_table}{root}"
    return schema

def main():
    input_file = 'dump.cs'
    output_dir = 'schema'

    if not os.path.exists(input_file):
        print(f"Error: {input_file} 不存在。")
        sys.exit(1)

    with open(input_file, 'r', encoding='utf-8') as f:
        content = f.read()

    structs = extract_structs_and_properties(content)

    if not structs:
        print("没有找到符合条件的结构体。")
        sys.exit(0)

    if not os.path.exists(output_dir):
        os.makedirs(output_dir)

    for struct_name, properties in structs:
        schema = generate_fsb(struct_name, properties)
        output_path = os.path.join(output_dir, f"{struct_name}.fbs")
        with open(output_path, 'w', encoding='utf-8') as f:
            f.write(schema)
        print(f"生成了 {output_path}")

if __name__ == "__main__":
    main()
