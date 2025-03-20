from proto.HeroEquipRecommendation_pb2 import HeroEquipRecommendation

def inspect_binary_file(file_path):
    """检查二进制文件内容
    
    Args:
        file_path: 序列化文件的路径
    """
    with open(file_path, 'rb') as f:
        binary_data = f.read()
        # 移除调试输出
        # print("文件大小:", len(binary_data), "字节")
        # print("前20个字节的十六进制:", binary_data[:20].hex())

def analyze_and_read_hero_equip(file_path):
    """分析并读取HeroEquipRecommendation数据
    
    Args:
        file_path: 序列化文件的路径
    """
    from proto.HeroEquipRecommendation_pb2 import HeroEquipRecommendation
    
    with open(file_path, 'rb') as f:
        binary_data = f.read()
    
    # 移除调试输出
    # print("完整十六进制内容:")
    # print(binary_data.hex())
    
    # 尝试跳过前8个字节（可能是头部）
    try:
        data_without_header = binary_data[8:]
        hero_equip = HeroEquipRecommendation()
        hero_equip.ParseFromString(data_without_header)
        
        # 移除调试输出
        # print("\n成功解析！数据内容：")
        # for set_equip in hero_equip.heroSetEquipList:
        #     print(f"Set Effect Numbers: {list(set_equip.setEffectNo)}")
        #     print(f"Count: {set_equip.count}")
        return hero_equip
    except Exception as e:
        # 移除调试输出
        # print(f"\n跳过8字节后解析失败: {str(e)}")
        pass
    
    # 如果上面失败，尝试其他偏移量
    for offset in [4, 12, 16]:
        try:
            data_without_header = binary_data[offset:]
            hero_equip = HeroEquipRecommendation()
            hero_equip.ParseFromString(data_without_header)
            # 移除调试输出
            # print(f"\n成功！跳过{offset}字节后解析成功。数据内容：")
            # for set_equip in hero_equip.heroSetEquipList:
            #     print(f"Set Effect Numbers: {list(set_equip.setEffectNo)}")
            #     print(f"Count: {set_equip.count}")
            return hero_equip
        except:
            # 移除调试输出
            # print(f"\n尝试跳过{offset}字节失败")
            pass

def read_hero_equip_recommendation(file_path):
    """从序列化文件中读取HeroEquipRecommendation数据并输出原始内容
    
    Args:
        file_path: 序列化文件的路径
    """
    with open(file_path, 'rb') as f:
        binary_data = f.read()
    
    # 跳过8字节的头部
    data_without_header = binary_data[8:]
    hero_equip = HeroEquipRecommendation()
    hero_equip.ParseFromString(data_without_header)
    
    # 直接打印原始解析内容
    print(hero_equip)
    
    return hero_equip

# 使用示例
file_path = "proto/HeroEquipRecommendation"  # 替换为你的文件路径
# 移除调试函数调用
# inspect_binary_file(file_path)  # 先检查文件内容
hero_equip = read_hero_equip_recommendation(file_path)