#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
简化的解密测试脚本
"""

import base64
import hashlib
import xml.etree.ElementTree as ET
from Crypto.Cipher import AES
from Crypto.Protocol.KDF import PBKDF2
import binascii

def xor_message(message, key="com.kakao.api"):
    """XOR 解密"""
    if not message or not key:
        return None
    
    try:
        result = []
        for i, char in enumerate(message):
            xor_char = chr(ord(char) ^ ord(key[i % len(key)]))
            result.append(xor_char)
        return ''.join(result)
    except:
        return None

def base64_decode_and_xor(source):
    """Base64 解码并 XOR"""
    try:
        decoded = base64.b64decode(source).decode('utf-8')
        return xor_message(decoded)
    except:
        return None

def test_decrypt():
    """测试解密"""
    
    # 从 AESCipher.java 获取的固定值
    init_vector = bytes([112, 78, 75, 55, 202, 226, 246, 44, 102, 130, 130, 92, 140, 208, 133, 201])
    
    # 解码算法字符串
    key_gen_algo = base64_decode_and_xor("My0oeSI1IzInbyA+LVFaW2wiNSokPAMiMipOLS4=")
    cipher_algo = base64_decode_and_xor("Iio+ASgjKE4/ZSIjXDMOCUoCDww=")
    
    print(f"密钥生成算法: {key_gen_algo}")
    print(f"加密算法: {cipher_algo}")
    
    # 读取XML文件
    xml_files = ['Account.xml', 'LoginData.xml']
    
    for xml_file in xml_files:
        try:
            print(f"\n=== 处理文件: {xml_file} ===")
            tree = ET.parse(xml_file)
            root = tree.getroot()
            
            for string_elem in root.findall('.//string'):
                name = string_elem.get('name')
                encrypted_data = string_elem.text
                
                if encrypted_data:
                    print(f"\n字段: {name}")
                    print(f"加密数据长度: {len(encrypted_data)}")
                    print(f"数据前100字符: {encrypted_data[:100]}...")
                    
                    # 尝试不同的解密方法
                    
                    # 方法1: 直接Base64解码
                    try:
                        decoded = base64.b64decode(encrypted_data)
                        print(f"Base64解码长度: {len(decoded)}")
                        print(f"前32字节(hex): {decoded[:32].hex()}")
                        
                        # 尝试作为UTF-8解码
                        try:
                            utf8_text = decoded.decode('utf-8')
                            print(f"UTF-8解码: {utf8_text[:100]}...")
                        except:
                            print("无法作为UTF-8解码")
                            
                    except Exception as e:
                        print(f"Base64解码失败: {e}")
                    
                    # 方法2: 尝试AES解密 (需要密钥)
                    # 这里我们需要正确的签名哈希和盐值
                    
        except Exception as e:
            print(f"处理文件 {xml_file} 失败: {e}")

def analyze_encrypted_data():
    """分析加密数据的特征"""
    xml_files = ['Account.xml', 'LoginData.xml']
    
    for xml_file in xml_files:
        try:
            print(f"\n=== 分析文件: {xml_file} ===")
            tree = ET.parse(xml_file)
            root = tree.getroot()
            
            for string_elem in root.findall('.//string'):
                name = string_elem.get('name')
                encrypted_data = string_elem.text
                
                if encrypted_data:
                    print(f"\n字段: {name}")
                    print(f"长度: {len(encrypted_data)}")
                    
                    # 检查是否是有效的Base64
                    try:
                        decoded = base64.b64decode(encrypted_data)
                        print(f"Base64解码成功，长度: {len(decoded)}")
                        
                        # 分析数据模式
                        if len(decoded) % 16 == 0:
                            print("数据长度是16的倍数 (可能是AES块)")
                        
                        # 显示前几个字节
                        print(f"前16字节(hex): {decoded[:16].hex()}")
                        print(f"前16字节(int): {list(decoded[:16])}")
                        
                        # 检查是否有重复模式
                        blocks = [decoded[i:i+16] for i in range(0, len(decoded), 16)]
                        unique_blocks = set(blocks)
                        print(f"总块数: {len(blocks)}, 唯一块数: {len(unique_blocks)}")
                        
                    except Exception as e:
                        print(f"Base64解码失败: {e}")
                        
        except Exception as e:
            print(f"分析文件 {xml_file} 失败: {e}")

if __name__ == "__main__":
    print("=== Kakao SDK 加密数据分析 ===")
    analyze_encrypted_data()
    print("\n" + "="*50)
    test_decrypt()
