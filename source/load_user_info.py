#!/usr/bin/env python3
# -*- coding: utf-8 -*-

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

def analyze_and_read_user_info(file_path):
    """分析并读取UserInfo数据
    
    Args:
        file_path: 序列化文件的路径
    """
    from python_api.UserInfo_pb2 import UserInfo
    
    with open(file_path, 'rb') as f:
        binary_data = f.read()
    
    # 移除调试输出
    # print("完整十六进制内容:")
    # print(binary_data.hex())
    
    # 尝试不同的偏移量解析文件
    try:
        data_without_header = binary_data[4:]
        user_info = UserInfo()
        user_info.ParseFromString(data_without_header)
        
        # 移除调试输出
        # print(f"\n成功！跳过{offset}字节后解析成功。")
        # print(f"用户名称: {user_info.user.nickName}")
        # print(f"英雄数量: {len(user_info.hero)}")
        return user_info
    except Exception as e:
        # 移除调试输出
        # print(f"\n尝试跳过{offset}字节失败: {str(e)}")
        pass
    
    print("无法解析文件，请检查文件格式或更新偏移量。")
    return None

def read_user_info(file_path, offset=8):
    """从序列化文件中读取UserInfo数据并输出原始内容
    
    Args:
        file_path: 序列化文件的路径
        offset: 要跳过的字节数，默认为8
    """
    from python_api.UserInfo_pb2 import UserInfo
    
    with open(file_path, 'rb') as f:
        binary_data = f.read()
    
    try:
        # 跳过指定字节的头部
        data_without_header = binary_data[offset:]
        user_info = UserInfo()
        user_info.ParseFromString(data_without_header)
        
        # 直接打印原始解析内容
        print(user_info)
        
        return user_info
    except Exception as e:
        print(f"解析失败: {str(e)}")
        print("尝试使用 analyze_and_read_user_info() 函数自动检测正确的偏移量。")
        return None

def extract_user_data(user_info):
    """提取并显示用户信息的主要数据
    
    Args:
        user_info: 已解析的UserInfo对象
    """
    if user_info is None:
        print("没有有效的用户信息对象")
        return
    
    # 基本用户信息
    print("\n===== 基本用户信息 =====")
    print(f"用户ID: {user_info.user.idx}")
    print(f"昵称: {user_info.user.nickName}")
    print(f"等级: {user_info.user.treeLevel}")
    print(f"最后登录时间: {user_info.user.lastLoginDt}")
    
    # 货币信息
    print("\n===== 货币信息 =====")
    for currency in user_info.currency.allCurrency:
        curr_name = {
            0: "无",
            1: "金币",
            2: "免费钻石",
            3: "魔尘",
            4: "魔晶",
            5: "经验",
            42: "付费钻石",
            100: "总钻石"
        }.get(currency.type, f"未知类型({currency.type})")
        print(f"{curr_name}: {currency.value}")
    
    # 英雄信息
    print(f"\n===== 英雄信息 (共{len(user_info.hero)}个) =====")
    for i, hero in enumerate(user_info.hero[:5]):  # 只显示前5个英雄
        print(f"英雄 {i+1}: 编号={hero.heroNo}, 等级={hero.level}, 品质={hero.gradeSno}")
    
    if len(user_info.hero) > 5:
        print(f"... 还有 {len(user_info.hero) - 5} 个英雄 ...")
    
    # 其他信息
    print("\n===== 其他信息 =====")
    print(f"自动战斗: {'开启' if user_info.battleAutoActive else '关闭'}")
    print(f"速度设置: {user_info.speed}")
    
    # 如果有公会信息 - 修复HasField检查
    if user_info.HasField("guild") and user_info.guild.name:
        print(f"公会名称: {user_info.guild.name}")

if __name__ == "__main__":
    import sys
    
    if len(sys.argv) < 2:
        print("用法: python load_user_info.py <文件路径> [偏移量]")
        sys.exit(1)
    
    file_path = sys.argv[1]
    
    if len(sys.argv) >= 3:
        try:
            offset = int(sys.argv[2])
            user_info = read_user_info(file_path, offset)
        except ValueError:
            print("偏移量必须是一个整数")
            sys.exit(1)
    else:
        # 先尝试使用默认偏移量
        user_info = read_user_info(file_path)
        
        # 如果失败，尝试分析并找到正确的偏移量
        if user_info is None:
            user_info = analyze_and_read_user_info(file_path)
    
    if user_info:
        extract_user_data(user_info) 