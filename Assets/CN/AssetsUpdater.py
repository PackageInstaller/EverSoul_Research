import re
import sys
import json
import hashlib
import shutil
import requests
import urllib3
import concurrent.futures
from pathlib import Path
from typing import Dict, Any

urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)


class ServerConfig:
    """服务器配置类"""

    def __init__(self, name: str, apps_json_url: str, config_key: str = "formal"):
        self.name = name
        self.apps_json_url = apps_json_url
        self.config_key = config_key  # "formal" 或 "review"
        self.patch_url = None


CN_LIVE_SERVER = ServerConfig(
    name="Live",
    apps_json_url="http://yhlh-client.zlongame.com/YHLH/obt/android/apps.json",
    config_key="formal",
)

CN_REVIEW_SERVER = ServerConfig(
    name="Review",
    apps_json_url="http://yhlh-client.zlongame.com/YHLH/obt/android/apps.json",
    config_key="review",
)

ALL_SERVERS = [CN_LIVE_SERVER, CN_REVIEW_SERVER]


def get_app_version_and_patch_url(server_config: ServerConfig) -> tuple[str, str]:
    """从中国服务器配置获取版本号和补丁URL"""
    print(f"从服务器获取配置信息 {server_config.name.upper()}...")

    try:
        response = requests.get(server_config.apps_json_url, verify=False, timeout=30)
        response.raise_for_status()
        config = response.json()
        server_cfg = config[server_config.config_key]
        version = server_cfg["custom"]["patchversion"]
        patch_url = server_cfg["patch_url"]["bundle_down_url"][0]
        server_config.patch_url = patch_url

        return version, patch_url
    except Exception as e:
        print(f"[{server_config.name}] 获取服务器配置失败: {e}")
        return None, None


def download_catalog(version: str, server_config: ServerConfig) -> dict | None:
    """下载游戏资源目录"""
    catalog_url = f"{server_config.patch_url}/{version}/Android/catalog_eversoul.json"
    print(f"[{server_config.name}] 下载目录: {catalog_url}")
    try:
        response = requests.get(catalog_url, verify=False, timeout=30)
        response.raise_for_status()
        return response.json()
    except Exception as e:
        print(f"[{server_config.name}] 下载游戏资源目录失败: {e}")
        return None


def read_base64(data: str) -> bytes:
    """Base64解码"""
    import base64

    return base64.b64decode(data)


class BinaryReader:
    """二进制读取器，简化版"""

    def __init__(self, data: bytes):
        self.data = data
        self.position = 0

    @property
    def u8(self) -> int:
        value = self.data[self.position]
        self.position += 1
        return value

    @property
    def u32(self) -> int:
        value = int.from_bytes(
            self.data[self.position : self.position + 4], byteorder="little"
        )
        self.position += 4
        return value

    @property
    def i32(self) -> int:
        value = int.from_bytes(
            self.data[self.position : self.position + 4],
            byteorder="little",
            signed=True,
        )
        self.position += 4
        return value

    @property
    def u16(self) -> int:
        value = int.from_bytes(
            self.data[self.position : self.position + 2], byteorder="little"
        )
        self.position += 2
        return value

    def str(self, length: int, encoding: str = "utf-8") -> str:
        value = self.data[self.position : self.position + length].decode(encoding)
        self.position += length
        return value

    @property
    def pos(self) -> int:
        return self.position

    @pos.setter
    def pos(self, value: int):
        self.position = value


def read_obj(reader: BinaryReader) -> Any:
    """读取对象"""
    objt = reader.u8
    if objt == 0:  # ascii string
        return reader.str(reader.u32)
    elif objt == 1:  # unicode(16) string
        return reader.str(reader.u32, "utf-16")
    elif objt == 2:  # u16
        return reader.u16
    elif objt == 3:  # u32
        return reader.u32
    elif objt == 4:  # i32
        return reader.i32
    elif objt == 7:  # json object
        return {
            "an": reader.str(reader.u8),
            "cn": reader.str(reader.u8),
            "js": json.loads(reader.str(reader.i32, "utf-16")),
        }
    elif objt == 8:
        objt = reader.u8
        return reader.u32
    else:
        raise RuntimeError(f"不支持的类型: {objt}")


def del_str(name: str) -> str:
    """处理文件名，移除哈希值"""
    if "%3D" in name:
        return name.split("%3D")[0]

    is_bundle = name.endswith(".bundle")
    base_name = name[:-7] if is_bundle else name

    hash_match = re.search(r"_[0-9a-f]{32}(?=\.bundle$|$)", name)
    if hash_match:
        clean_name = name[: hash_match.start()]
        if is_bundle:
            clean_name += ".bundle"
        return clean_name

    if is_bundle:
        n = base_name
        n = n[:-4] if n.endswith("_all") else n
        n = n[:-7] if n.endswith("_assets") else n
        return f"{n}.bundle"
    else:
        c = name.find("_") > 0 and len(name) > 32 and name[-33:-1].isalnum()
        n = name[:-33] if c else name
        n = n[:-4] if n.endswith("_all") else n
        n = n[:-7] if n.endswith("_assets") else n
        return n


def parse_catalog(
    catalog: dict, prefix: str = "", server_config: ServerConfig = None
) -> Dict[str, Dict[str, Any]]:
    """解析游戏资源目录"""
    results = {}

    kds = BinaryReader(read_base64(catalog["m_KeyDataString"]))
    eds = BinaryReader(read_base64(catalog["m_EntryDataString"]))
    xds = BinaryReader(read_base64(catalog["m_ExtraDataString"]))

    skds = [read_obj(kds) for _ in range(kds.u32)]
    mii = catalog["m_InternalIds"]

    for _ in range(eds.u32):
        ii, pi, dki, dh, di, pk, rt = (
            eds.i32,
            eds.i32,
            eds.i32,
            eds.i32,
            eds.i32,
            eds.i32,
            eds.i32,
        )
        obj, enckey = None, None

        if di >= 0:
            xds.pos = di
            obj = read_obj(xds)
            if isinstance(obj, dict):
                if "m_EncryptKey" in obj["js"]:
                    enckey = obj["js"]["m_EncryptKey"]
                if "m_BundleSize" in obj["js"]:
                    obj = obj["js"]["m_BundleSize"]
                elif "m_FileSize" in obj["js"]:
                    obj = obj["js"]["m_FileSize"]
                else:
                    obj = 0

        on, nn = mii[ii], skds[pk]
        d = None if dki < 0 else skds[dki]

        start_check = on.startswith("https://")
        end_check = on.endswith(".bundle")

        if start_check and end_check:
            n = (
                on.split("https://eversoul.com/", 1)[1]
                if "https://eversoul.com/" in on
                else on
            )
            nn = del_str(n)
            url = f"{server_config.patch_url}/{prefix}/Android/{n}" if prefix else on

            results[nn] = {"name": nn, "url": url, "size": obj}

            if enckey is not None:
                results[nn]["key"] = enckey

    return results


def calculate_file_md5(file_path: str) -> str:
    """计算文件MD5值"""
    hash_md5 = hashlib.md5()
    with open(file_path, "rb") as f:
        for chunk in iter(lambda: f.read(4096), b""):
            hash_md5.update(chunk)
    return hash_md5.hexdigest()


def check_assets(
    assets_dir: Path, asset_list: Dict[str, Dict[str, Any]]
) -> Dict[str, Dict[str, Any]]:
    """检查本地资产与远程资产的差异"""
    updated_files = {}

    if not assets_dir.exists():
        assets_dir.mkdir(parents=True, exist_ok=True)
        return asset_list

    for filename, info in asset_list.items():
        file_path = assets_dir / filename

        if not file_path.exists():
            updated_files[filename] = info
        elif "size" in info and info["size"] > 0:
            local_size = file_path.stat().st_size
            remote_size = info["size"]

            if local_size != remote_size:
                print(
                    f"文件大小不匹配: {filename} (本地: {local_size}, 远程: {remote_size})"
                )
                updated_files[filename] = info

    return updated_files


def download_file(url: str, file_path: Path, retries: int = 3) -> bool:
    """下载文件"""
    for attempt in range(retries):
        try:
            response = requests.get(url, stream=True, timeout=30, verify=False)
            response.raise_for_status()

            file_path.parent.mkdir(parents=True, exist_ok=True)

            with open(file_path, "wb") as f:
                for chunk in response.iter_content(chunk_size=8192):
                    if chunk:
                        f.write(chunk)
            return True
        except Exception as e:
            print(f"下载 {url} 失败 (尝试 {attempt+1}/{retries}): {e}")
            if attempt == retries - 1:
                return False
    return False


def download_assets(
    assets_to_download: Dict[str, Dict[str, Any]],
    target_dir: Path,
    max_workers: int = 100,
) -> Dict[str, bool]:
    """多线程下载资产"""
    results = {}

    with concurrent.futures.ThreadPoolExecutor(max_workers=max_workers) as executor:
        future_to_file = {
            executor.submit(download_file, info["url"], target_dir / filename): filename
            for filename, info in assets_to_download.items()
        }

        for future in concurrent.futures.as_completed(future_to_file):
            filename = future_to_file[future]
            try:
                success = future.result()
                results[filename] = success
                status = "成功" if success else "失败"
                print(f"下载 {filename}: {status}")
            except Exception as e:
                results[filename] = False
                print(f"下载 {filename} 失败: {e}")

    return results


def sync_update_to_assets(
    download_results: Dict[str, bool], update_dir: Path, assets_dir: Path
) -> int:
    """将 update 目录下载成功的文件同步复制到 assets 目录"""
    copied_count = 0
    for filename, success in download_results.items():
        if not success:
            continue

        src = update_dir / filename
        dst = assets_dir / filename
        if not src.exists():
            continue

        dst.parent.mkdir(parents=True, exist_ok=True)
        shutil.copy2(src, dst)
        copied_count += 1

    return copied_count


def save_asset_list(asset_list: Dict[str, Dict[str, Any]], file_path: Path):
    """保存资产列表到JSON文件"""
    with open(file_path, "w", encoding="utf-8") as f:
        json.dump(asset_list, f, ensure_ascii=False, indent=4)


def load_asset_list(file_path: Path) -> Dict[str, Dict[str, Any]]:
    """从JSON文件加载资产列表"""
    if not file_path.exists():
        return {}

    with open(file_path, "r", encoding="utf-8") as f:
        return json.load(f)


def process_server(server_config: ServerConfig, base_dir: Path) -> bool:
    """处理指定服务器的资产更新"""
    print(f"\n{'='*60}")
    print(f"开始处理服务器: {server_config.name.upper()}")
    print(f"{'='*60}")

    server_dir = base_dir / server_config.name
    assets_dir = server_dir / "assets"
    update_dir = server_dir / "update"
    asset_list_file = server_dir / "asset_list.json"

    server_dir.mkdir(exist_ok=True)
    assets_dir.mkdir(exist_ok=True)

    has_assets = assets_dir.exists() and any(assets_dir.iterdir())
    version, patch_url = get_app_version_and_patch_url(server_config)

    if version is None:
        print(f"[{server_config.name}] 跳过此服务器")
        return False

    print(f"[{server_config.name}] 下载游戏资源目录...")
    catalog = download_catalog(version, server_config)
    if catalog is None:
        print(f"[{server_config.name}] 跳过此服务器")
        return False

    print(f"[{server_config.name}] 解析游戏资源目录...")
    asset_list = parse_catalog(catalog, version, server_config)
    print(f"[{server_config.name}] 找到 {len(asset_list)} 个资源文件")

    save_asset_list(asset_list, asset_list_file)

    print(f"[{server_config.name}] 检查本地资源...")
    updated_files = check_assets(assets_dir, asset_list)

    print(f"[{server_config.name}] 需要更新的文件数量: {len(updated_files)}")

    if updated_files:
        print(f"[{server_config.name}] 需要更新的文件:")
        for file, info in list(updated_files.items())[:10]:
            print(f"  - {file}")

        if len(updated_files) > 10:
            print(f"  ... {len(updated_files) - 10} 更多文件")

        target_dir = assets_dir if not has_assets else update_dir
        target_dir.mkdir(parents=True, exist_ok=True)

        print(f"[{server_config.name}] 开始下载文件到 {target_dir}...")
        download_results = download_assets(updated_files, target_dir)

        success_count = sum(1 for success in download_results.values() if success)
        print(f"[{server_config.name}] 下载成功: {success_count}/{len(updated_files)}")

        if target_dir == update_dir:
            copied_count = sync_update_to_assets(download_results, update_dir, assets_dir)
            print(f"[{server_config.name}] 已复制到 assets: {copied_count} 个文件")

    else:
        print(f"[{server_config.name}] 所有文件都是最新的, 无需更新")

    return True


if __name__ == "__main__":
    base_dir = Path(".")
    process_server(CN_LIVE_SERVER, base_dir)
    process_server(CN_REVIEW_SERVER, base_dir)
