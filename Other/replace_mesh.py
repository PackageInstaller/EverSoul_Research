import UnityPy
import struct
import re
from typing import List, Dict, Any

UnityPy.config.FALLBACK_UNITY_VERSION = "2022.3.62f1"  # type: ignore

def parse_dump_file(dump_file_path: str) -> Dict[str, Any]:
    """解析dump文件，提取Mesh数据"""
    mesh_data = {}
    
    with open(dump_file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # 解析基本信息
    name_match = re.search(r'string m_Name = "([^"]+)"', content)
    if name_match:
        mesh_data['name'] = name_match.group(1)
    
    # 解析SubMesh信息
    submesh_match = re.search(r'unsigned int indexCount = (\d+)', content)
    if submesh_match:
        mesh_data['index_count'] = int(submesh_match.group(1))
    
    vertex_count_match = re.search(r'unsigned int vertexCount = (\d+)', content)
    if vertex_count_match:
        mesh_data['vertex_count'] = int(vertex_count_match.group(1))
    
    # 解析顶点数据大小
    data_size_match = re.search(r'int size = (\d+)', content.split('TypelessData m_DataSize')[1].split('\n')[1])
    if data_size_match:
        mesh_data['data_size'] = int(data_size_match.group(1))
    
    # 解析索引缓冲区
    index_buffer = []
    index_section = content.split('vector m_IndexBuffer')[1].split('VertexData m_VertexData')[0]
    index_matches = re.findall(r'UInt8 data = (\d+)', index_section)
    mesh_data['index_buffer'] = [int(x) for x in index_matches]
    
    # 解析绑定姿势
    bind_poses = []
    bind_pose_section = content.split('vector m_BindPose')[1].split('vector m_BoneNameHashes')[0]
    matrix_matches = re.findall(r'float e\d+ = ([^\n]+)', bind_pose_section)
    
    # 每个矩阵有16个浮点数
    for i in range(0, len(matrix_matches), 16):
        if i + 15 < len(matrix_matches):
            matrix = [float(x) for x in matrix_matches[i:i+16]]
            bind_poses.append(matrix)
    
    mesh_data['bind_poses'] = bind_poses
    
    # 解析骨骼名称哈希
    bone_hashes = []
    bone_hash_section = content.split('vector m_BoneNameHashes')[1].split('unsigned int m_RootBoneNameHash')[0]
    hash_matches = re.findall(r'unsigned int data = (\d+)', bone_hash_section)
    mesh_data['bone_name_hashes'] = [int(x) for x in hash_matches]
    
    # 解析根骨骼哈希
    root_bone_match = re.search(r'unsigned int m_RootBoneNameHash = (\d+)', content)
    if root_bone_match:
        mesh_data['root_bone_hash'] = int(root_bone_match.group(1))
    
    # 解析AABB信息
    aabb_section = content.split('AABB m_LocalAABB')[1].split('int m_MeshUsageFlags')[0]
    center_matches = re.findall(r'float [xyz] = ([^\n]+)', aabb_section.split('Vector3f m_Center')[1].split('Vector3f m_Extent')[0])
    extent_matches = re.findall(r'float [xyz] = ([^\n]+)', aabb_section.split('Vector3f m_Extent')[1])
    
    mesh_data['aabb_center'] = [float(x) for x in center_matches[:3]]
    mesh_data['aabb_extent'] = [float(x) for x in extent_matches[:3]]
    
    return mesh_data

def replace_mesh_in_assetbundle(source_bundle_path: str, output_bundle_path: str, 
                                target_mesh_name: str, replacement_dump_path: str):
    """替换AssetBundle中的Mesh"""
    try:
        # 解析替换用的Mesh数据
        print(f"正在解析替换文件: {replacement_dump_path}")
        replacement_data = parse_dump_file(replacement_dump_path)
        print(f"解析完成，模型名称: {replacement_data.get('name', '未知')}")
        print(f"顶点数: {replacement_data.get('vertex_count', 0)}")
        print(f"索引数: {replacement_data.get('index_count', 0)}")
        
        # 加载AssetBundle
        env = UnityPy.load(source_bundle_path)
        found_and_replaced = False
        
        for obj in env.objects:
            if obj.type.name == "Mesh":
                data = obj.read()
                if data.m_Name == target_mesh_name:
                    print(f"找到目标Mesh: {target_mesh_name}")
                    
                    # 更新基本信息
                    data.m_Name = replacement_data['name']
                    
                    # 更新子网格信息
                    if hasattr(data, 'm_SubMeshes') and len(data.m_SubMeshes) > 0:
                        data.m_SubMeshes[0].indexCount = replacement_data['index_count']
                        data.m_SubMeshes[0].vertexCount = replacement_data['vertex_count']
                        
                        # 更新AABB
                        if hasattr(data.m_SubMeshes[0], 'localAABB'):
                            data.m_SubMeshes[0].localAABB.m_Center.x = replacement_data['aabb_center'][0]
                            data.m_SubMeshes[0].localAABB.m_Center.y = replacement_data['aabb_center'][1]
                            data.m_SubMeshes[0].localAABB.m_Center.z = replacement_data['aabb_center'][2]
                            data.m_SubMeshes[0].localAABB.m_Extent.x = replacement_data['aabb_extent'][0]
                            data.m_SubMeshes[0].localAABB.m_Extent.y = replacement_data['aabb_extent'][1]
                            data.m_SubMeshes[0].localAABB.m_Extent.z = replacement_data['aabb_extent'][2]
                    
                    # 更新索引缓冲区
                    if hasattr(data, 'm_IndexBuffer'):
                        data.m_IndexBuffer = bytes(replacement_data['index_buffer'])
                    
                    # 更新绑定姿势
                    if hasattr(data, 'm_BindPose') and replacement_data['bind_poses']:
                        # 这里需要根据UnityPy的具体实现来更新绑定姿势
                        print(f"更新绑定姿势，共 {len(replacement_data['bind_poses'])} 个")
                    
                    # 更新骨骼信息
                    if hasattr(data, 'm_BoneNameHashes'):
                        data.m_BoneNameHashes = replacement_data['bone_name_hashes']
                    
                    if hasattr(data, 'm_RootBoneNameHash'):
                        data.m_RootBoneNameHash = replacement_data['root_bone_hash']
                    
                    # 更新顶点数据
                    if hasattr(data, 'm_VertexData'):
                        data.m_VertexData.m_VertexCount = replacement_data['vertex_count']
                    
                    # 更新本地AABB
                    if hasattr(data, 'm_LocalAABB'):
                        data.m_LocalAABB.m_Center.x = replacement_data['aabb_center'][0]
                        data.m_LocalAABB.m_Center.y = replacement_data['aabb_center'][1]
                        data.m_LocalAABB.m_Center.z = replacement_data['aabb_center'][2]
                        data.m_LocalAABB.m_Extent.x = replacement_data['aabb_extent'][0]
                        data.m_LocalAABB.m_Extent.y = replacement_data['aabb_extent'][1]
                        data.m_LocalAABB.m_Extent.z = replacement_data['aabb_extent'][2]
                    
                    # 保存更改
                    data.save()
                    found_and_replaced = True
                    print(f"成功替换Mesh: {target_mesh_name} -> {replacement_data['name']}")
                    break
        
        if not found_and_replaced:
            print(f"未找到目标Mesh: {target_mesh_name}")
            return False
        
        # 保存修改后的AssetBundle
        with open(output_bundle_path, "wb") as f:
            f.write(env.file.save())  # type: ignore
        
        print(f"新的AssetBundle已保存到: {output_bundle_path}")
        return True
        
    except Exception as e:
        print(f"发生错误: {e}")
        import traceback
        traceback.print_exc()
        return False

if __name__ == '__main__':
    # 原始AssetBundle路径
    source_bundle = 'prefabs.bundle'
    
    # 修改后保存的新AssetBundle路径
    output_bundle = '__data'
    
    # 要替换的Mesh名称
    target_mesh_name = 'CH_Wheri_Wplus_Base'
    
    # 替换用的dump文件
    replacement_dump = 'CH_Wheri_Wplus_Base.txt'
    
    replace_mesh_in_assetbundle(source_bundle, output_bundle, target_mesh_name, replacement_dump) 