import sys
import os
from Tbl.StoryInfoTable import StoryInfoTable

def main():
    tbl_file_path = "StoryInfo.tbl"
    
    with open(tbl_file_path, 'rb') as f:
        buf = f.read()
    story_info_table = StoryInfoTable.GetRootAs(buf, 0)

    
    print(f"查找 no = 6 的记录...")
    
    found_record = None
    for i in range(story_info_table.StoryInfosLength()):
        story_info = story_info_table.StoryInfos(i)
        if story_info and story_info.No() == 6:
            found_record = story_info
            break
    
    if found_record:
        print(f"No: {found_record.No()}")
        print(f"Act: {found_record.Act()}")
        print(f"Episode: {found_record.Episode()}")
        bundle_path = found_record.BundlePath()
        print(f"BundlePath: {bundle_path}")
    
    print(f"查找 bundle_path_offset = Story/Main/100/03 的记录...")
    
    found_bundle_record = None
    for i in range(story_info_table.StoryInfosLength()):
        story_info = story_info_table.StoryInfos(i)
        if story_info:
            bundle_path = story_info.BundlePath()
            if bundle_path and bundle_path.decode('utf-8') == "Story/Main/100/03":
                found_bundle_record = story_info
                break
    
    if found_bundle_record:
        print(f"No: {found_bundle_record.No()}")
        print(f"Act: {found_bundle_record.Act()}")
        print(f"Episode: {found_bundle_record.Episode()}")
        print(f"TalkGroup: {found_bundle_record.TalkGroup()}")
        story_img = found_bundle_record.StoryImg()
        if story_img:
            print(f"StoryImage: {story_img}")
        bundle_path = found_bundle_record.BundlePath()
        if bundle_path:
            print(f"BundlePath: {bundle_path}")

if __name__ == "__main__":
    main() 