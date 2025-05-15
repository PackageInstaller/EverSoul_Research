from google.protobuf import text_format
from request_proto_api.ProfileCustomSave_pb2 import ProfileCustomSave

def serialize_profile():
    # 创建消息对象
    message = ProfileCustomSave()
    
    # 设置字段值
    message.saveType = 2
    message.uid = 33088
    
    # 处理 profile 字符串
    profile_str = "empty,0,12,117,0,0,0,1,1,1,0,1,1,1,1,1,16,2303,-301.15,22.07,0,1.56,1.56,1,332.02,1,1,1,1,2,6,0,135.24,-191.1,0,1,1,1,0,1,1,1,1,3,7,0,248.68,35.02,0,1,1,1,0,1,1,1,1,4,16,2303,266.75,-44.66,0,1.5,1.5,1,33.03,1,1,1,1"
    message.profile = profile_str.encode('utf-8')
    
    # 序列化为二进制
    binary_data = message.SerializeToString()
    
    # 打印二进制数据的十六进制表示
    print("Serialized data (hex):")
    print(binary_data.hex())
    
    with open("serialized_data.bin", "wb") as f:
        f.write(binary_data)
    
    return binary_data

def deserialize_profile(binary_data):
    # 反序列化测试
    message = ProfileCustomSave()
    message.ParseFromString(binary_data)
    
    print("\nDeserialized data:")
    print(f"saveType: {message.saveType}")
    print(f"uid: {message.uid}")
    print(f"profile: {message.profile.decode('utf-8')}")

if __name__ == "__main__":
    # 序列化
    binary_data = serialize_profile()
    
    # 反序列化测试
    deserialize_profile(binary_data)