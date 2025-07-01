import re
import os
import sys
import subprocess
import glob
import shutil

def parse_cs_file_from_types(proto_type, file_path):
    """从types.cs文件解析C#文件，提取消息类型定义
    
    Args:
        proto_type: proto类型命名空间
        file_path: C#文件路径
        
    Returns:
        包含提取的类型定义的字典
    """
    print(f"解析types.cs文件: {file_path}，命名空间: {proto_type}")
    
    with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
        content = f.read()

    namespace = proto_type
    
    # 在types.cs中查找指定的命名空间
    namespace_pattern = re.compile(rf'namespace\s+{re.escape(proto_type)}\s*{{(.*?)(?=\nnamespace\s+\w+\s*{{|\n\}}\s*$)', re.DOTALL)
    namespace_match = namespace_pattern.search(content)
    
    if not namespace_match:
        print(f"未找到命名空间 {proto_type}")
        return namespace, {}, {}
    
    section_content = namespace_match.group(1)
    message_types = {}
    enum_types = {}
    
    # 提取枚举类型
    enum_pattern = r'public\s+enum\s+(\w+)[^{]*\{([^}]*)\}'
    enum_matches = re.finditer(enum_pattern, section_content, re.DOTALL)
    
    for match in enum_matches:
        enum_name = match.group(1)
        enum_content = match.group(2)
        
        # 提取枚举值
        enum_values = []
        # 匹配 EnumValue = 0, 这样的模式
        value_pattern = r'(\w+)\s*=\s*(\d+)'
        value_matches = re.finditer(value_pattern, enum_content)
        
        for value_match in value_matches:
            enum_values.append((value_match.group(1), int(value_match.group(2))))
        
        if enum_values:
            enum_types[enum_name] = sorted(enum_values, key=lambda x: x[1])
    
    # 查找所有类定义 - 匹配 IMessage<ClassName> 或 IMessage<EsPb.ClassName>
    class_pattern = rf'public\s+sealed\s+class\s+(\w+)\s*:\s*IMessage<(?:{re.escape(proto_type)}\.)?(\w+)>'
    classes = []
    
    for match in re.finditer(class_pattern, section_content):
        class_name = match.group(1)
        # 确保类名匹配
        if match.group(2) == class_name:
            classes.append(class_name)
    
    # 提取每个类的字段
    for class_name in classes:
        # 查找完整的类定义 - 使用更精确的模式
        class_def_pattern = rf'public\s+sealed\s+class\s+{re.escape(class_name)}\s*:[^{{]*\{{(.*?)(?=\n\s*public\s+(?:sealed\s+)?class|\n\s*public\s+enum|\n\s*\}}\s*$)'
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
            codec_pattern = rf'private\s+static\s+readonly\s+FieldCodec<([^>]+)>\s+_repeated_{re.escape(field_name.lower())}_codec'
            codec_match = re.search(codec_pattern, class_content, re.IGNORECASE)
            if codec_match:
                is_repeated = True
                field_type = codec_match.group(1)
            
            # 如果没找到编码器，尝试从字段定义中查找
            if not field_type:
                # 查找 RepeatedField 字段定义
                repeated_field_pattern = rf'private\s+readonly\s+RepeatedField<([^>]+)>\s+{re.escape(field_name.lower())}_'
                repeated_match = re.search(repeated_field_pattern, class_content, re.IGNORECASE)
                
                if repeated_match:
                    is_repeated = True
                    field_type = repeated_match.group(1)
                else:
                    # 查找普通字段定义
                    normal_field_pattern = rf'private\s+([^;]+?)\s+{re.escape(field_name.lower())}_'
                    normal_match = re.search(normal_field_pattern, class_content, re.IGNORECASE)
                    
                    if normal_match:
                        field_type_def = normal_match.group(1).strip()
                        # 提取类型名
                        type_match = re.search(r'(\w+(?:\.\w+)?)$', field_type_def)
                        if type_match:
                            field_type = type_match.group(1)
            
            # 清理类型名，移除命名空间前缀
            if field_type:
                # 移除 EsPb. 等命名空间前缀
                if '.' in field_type:
                    field_type = field_type.split('.')[-1]
            
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
        'String': 'string',
        'ByteString': 'bytes'
    }
    
    # 如果是基础类型映射
    if cs_type in type_mapping:
        return type_mapping[cs_type]
    
    # 清理类型名，移除可能的命名空间前缀
    if '.' in cs_type:
        cs_type = cs_type.split('.')[-1]
    
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

def process_types_file(proto_type, file_path, output_dir):
    """处理types.cs文件并生成相应的proto文件
    
    Args:
        proto_type: proto类型
        file_path: types.cs文件路径
        output_dir: 输出目录
        
    Returns:
        生成的proto文件数量
    """
    # 确保输出目录存在
    if not os.path.exists(output_dir):
        os.makedirs(output_dir)
    
    # 解析CS文件
    namespace, message_types, enum_types = parse_cs_file_from_types(proto_type, file_path)
    
    # 计数器，用于记录生成的文件数量
    generated_count = 0
    
    # 对于每个消息类型，生成一个proto文件
    for message_name in message_types:
        # 跳过以小写字母开头的消息类型，这些类型通常是辅助类型，用作其他消息的字段补充
        if message_name[0].islower():
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
    input_file = "types.cs"
    
    # 检查输入文件是否存在
    if not os.path.exists(input_file):
        print(f"错误: 输入文件 {input_file} 不存在")
        return 1
    
    # 定义目录
    response_proto_dir = "../response_proto"
    request_proto_dir = "../request_proto"
    eschatpb_proto_dir = "../eschatpb_proto"
    response_output_dir = "../response_proto_api"
    request_output_dir = "../request_proto_api"
    eschatpb_output_dir = "../eschatpb_proto_api"
    
    # 扩展proto类型以确保生成足够多的文件
    proto_types = ["EsPb", "ReqPb", "EsChatPb"]
    total_proto_generated = 0
    
    for proto_type in proto_types:
        # 设置输出目录
        if proto_type == "EsPb":
            output_dir = response_proto_dir
        elif proto_type == "ReqPb":
            output_dir = request_proto_dir
        else:  # EsChatPb 单独存放
            output_dir = eschatpb_proto_dir
        
        print(f"\n处理 {proto_type} 类型...")
        generated_count = process_types_file(proto_type, input_file, output_dir)
        total_proto_generated += generated_count
        print(f"{proto_type} 类型生成了 {generated_count} 个proto文件")
    
    print(f"\nproto文件生成完成，共生成 {total_proto_generated} 个文件")
    
    
    # 清空输出目录
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
    
    # 处理接收proto
    print("\n编译接收proto文件...")
    if os.path.exists(response_proto_dir):
        success, fail = process_proto_directory(response_proto_dir, response_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
        create_init_file(response_output_dir)
    else:
        print(f"目录 {response_proto_dir} 不存在，跳过")
    
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
    
    # 处理聊天proto
    print("\n编译聊天proto文件...")
    if os.path.exists(eschatpb_proto_dir):
        success, fail = process_proto_directory(eschatpb_proto_dir, eschatpb_output_dir)
        total_success += success
        total_fail += fail
        # 创建__init__.py使输出目录成为Python包
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