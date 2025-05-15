import zlib
import binascii
import json

def decompress_zlib_file(filename):
    with open(filename, 'rb') as f:
        data = f.read()
    
    print(f"读取文件 {filename}, 大小: {len(data)} 字节")
    print(f"文件头: {binascii.hexlify(data[:4]).decode()}")
    
    if data.startswith(b'\x78\x9c'):
        print("文件头匹配zlib格式，但可能需要用deflate方式解压")
    
    # 尝试所有可能的deflate窗口大小
    print("\n尝试所有deflate窗口大小参数 (-9到-15):")
    for wbits in range(-9, -16, -1):
        try:
            # 对整个数据使用deflate模式解压
            print(f"  尝试wbits={wbits}...")
            decompressed = zlib.decompress(data, wbits)
            print(f"  成功! wbits={wbits}, 解压后大小: {len(decompressed)} 字节")
            show_data_preview(decompressed)
            save_result(decompressed, f"decompressed_wbits_{wbits}.bin")
            return
        except Exception as e:
            print(f"  失败: {e}")
    
    # 尝试去掉zlib头然后用deflate解压
    print("\n尝试去掉zlib头(2字节)后用deflate解压:")
    data_without_header = data[2:]
    for wbits in range(-9, -16, -1):
        try:
            print(f"  尝试wbits={wbits}...")
            decompressed = zlib.decompress(data_without_header, wbits)
            print(f"  成功! wbits={wbits}, 解压后大小: {len(decompressed)} 字节")
            show_data_preview(decompressed)
            save_result(decompressed, f"decompressed_no_header_wbits_{wbits}.bin")
            return
        except Exception as e:
            print(f"  失败: {e}")
            
    # 尝试每个字节偏移后再解压
    print("\n尝试不同的数据偏移位置:")
    for offset in [0, 1, 2, 3, 4]:
        for wbits in range(-9, -16, -1):
            try:
                print(f"  尝试偏移={offset}, wbits={wbits}...")
                decompressed = zlib.decompress(data[offset:], wbits)
                print(f"  成功! 偏移={offset}, wbits={wbits}, 解压后大小: {len(decompressed)} 字节")
                show_data_preview(decompressed)
                save_result(decompressed, f"decompressed_offset_{offset}_wbits_{wbits}.bin")
                return
            except:
                pass
    
    print("\n所有deflate参数尝试均失败")

def show_data_preview(data):
    """显示解压数据预览"""
    try:
        # 尝试作为JSON解析
        if data.startswith(b'{') or data.startswith(b'['):
            try:
                json_data = json.loads(data)
                print(f"JSON数据: {json.dumps(json_data, indent=2, ensure_ascii=False)[:500]}...")
                return
            except:
                print("数据看起来像JSON但解析失败")
                
        # 尝试作为文本解析
        text = data.decode('utf-8', errors='replace')
        if len(text) > 200:
            text = text[:200] + "..."
        print(f"文本预览: {text}")
    except:
        # 显示二进制预览
        print(f"二进制前50字节: {binascii.hexlify(data[:50]).decode()}")

def save_result(data, filename):
    """保存解压结果"""
    with open(filename, 'wb') as f:
        f.write(data)
    print(f"解压数据已保存到: {filename}")
    
    # 如果看起来像JSON，也保存为JSON文件
    try:
        if data.startswith(b'{') or data.startswith(b'['):
            json_data = json.loads(data)
            with open(filename + ".json", 'w', encoding='utf-8') as f:
                json.dump(json_data, f, indent=2, ensure_ascii=False)
            print(f"也保存为JSON格式: {filename}.json")
    except:
        pass

if __name__ == "__main__":
    decompress_zlib_file("decoded_data.bin")
