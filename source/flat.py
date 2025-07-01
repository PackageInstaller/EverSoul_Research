import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)))
from Tbl.StoryInfoTable import StoryInfoTable

def main():

    tbl_file_path = "../live_table/StoryInfo.tbl"
    try:
        with open(tbl_file_path, 'rb') as f:
            buf = f.read()
        story_info_table = StoryInfoTable.GetRootAs(buf, 0)
    except Exception as e:
        print(f"❌ 读取失败: {e}")
        return
    
    target_no = 6
    print(f"🔍 查找 no = {target_no} 的记录...")
    
    found_record = None
    for i in range(story_info_table.StoryInfosLength()):
        story_info = story_info_table.StoryInfos(i)
        if story_info is not None and story_info.No() == target_no:
            found_record = story_info
            break
    
    if found_record:
        print(f"✅ 找到记录:")
        print(f"   No: {found_record.No()}")
        print(f"   Act: {found_record.Act()}")
        print(f"   Episode: {found_record.Episode()}")
        bundle_path = found_record.BundlePathOffset()
        if bundle_path:
            print(f"   Bundle Path: {bundle_path.decode('utf-8')}")
    
    
    # 3. 查找bundle_path_offset为"Story/Main/100/03"的记录
    target_bundle_path = "Story/Main/100/03"
    print(f"🔍 查找 bundle_path_offset = '{target_bundle_path}' 的记录...")
    
    found_bundle_record = None
    for i in range(story_info_table.StoryInfosLength()):
        story_info = story_info_table.StoryInfos(i)
        if story_info is not None:
            bundle_path = story_info.BundlePathOffset()
            if bundle_path is not None and bundle_path.decode('utf-8') == target_bundle_path:
                found_bundle_record = story_info
                break
    
    if found_bundle_record:
        print(f"✅ 找到记录:")
        print(f"   No: {found_bundle_record.No()}")
        print(f"   Act: {found_bundle_record.Act()}")
        print(f"   Episode: {found_bundle_record.Episode()}")
        print(f"   Talk Group: {found_bundle_record.TalkGroup()}")
        story_img = found_bundle_record.StoryImgOffset()
        if story_img:
            print(f"   Story Image: {story_img.decode('utf-8')}")
        bundle_path = found_bundle_record.BundlePathOffset()
        if bundle_path:
            print(f"   Bundle Path: {bundle_path.decode('utf-8')}")

if __name__ == "__main__":
    main() 