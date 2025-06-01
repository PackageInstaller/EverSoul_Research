def decrypt_liapp_string(data: bytes) -> str:
    if not data or len(data) < 2:
        return ""
    result = bytearray()
    first_byte = data[0]
    for i in range(1, len(data)):
        result.append(data[i] ^ first_byte)
    return result.decode(errors='ignore')

def encrypt_liapp_string(plaintext: str, key_byte: int = None) -> bytes:
    data = plaintext.encode()
    
    if key_byte is None and data:
        key_byte = data[0]
    
    result = bytearray()
    result.append(key_byte)  
    
    for b in data:
        result.append(b ^ key_byte)
        
    return bytes(result)


# 测试用例
plaintext = "gameassistant"
print(f"明文: {plaintext}")

# 自动从明文获取密钥
enc = encrypt_liapp_string(plaintext)
print(f"加密后 (bytes): {enc}")
print(f"加密后 (str): {enc.decode('utf-8', errors='ignore')}")

# 解密测试
dec = decrypt_liapp_string(b"H/)%-);;!;<)&<")
print(f"解密结果: {dec}")
print(f"解密结果是否匹配原文: {dec == plaintext}")