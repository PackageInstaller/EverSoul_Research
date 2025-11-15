import UnityPy
from PIL import Image

UnityPy.config.FALLBACK_UNITY_VERSION = "2022.3.62f1"

def replace(source_bundle_path, output_bundle_path, target_texture_name, replacement_image_path):
    try:
        env = UnityPy.load(source_bundle_path)
        found_and_replaced = False

        for obj in env.objects:
            if obj.type.name == "Texture2D":
                data = obj.read()
                if data.m_Name == target_texture_name:

                    new_image = Image.open(replacement_image_path)
                    data.image = new_image
                    data.save()
                    found_and_replaced = True
                    print(f"成功将 '{target_texture_name}' 的内容替换为 '{replacement_image_path}'")
                    break

        if not found_and_replaced:
            print(f"未找到'{target_texture_name}'")
            return

        with open(output_bundle_path, "wb") as f:
            f.write(env.file.save())
        
        print(f"新的 AssetBundle 已保存到: '{output_bundle_path}'")

    except Exception as e:
        print(f"发生错误: {e}")

if __name__ == '__main__':
    # 原始 AssetBundle
    source_bundle = '__data'  
    
    # 修改后保存的新 AssetBundle
    output_bundle = '__data_modified'

    # 想要替换的 AssetBundle 内部的 Texture2D
    target_texture_name = 'Eve_2048'

    # 用来替换的外部图片文件
    replacement_image_file = 'test.png'

    replace(source_bundle, output_bundle, target_texture_name, replacement_image_file)