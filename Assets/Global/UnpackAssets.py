import sys
import warnings
from pathlib import Path
from glob import glob
from dataclasses import dataclass
from typing import Callable, Optional, Tuple
from concurrent.futures import ThreadPoolExecutor, as_completed
import threading
import json
import UnityPy
import UnityPy.config
from UnityPy.enums import ClassIDType
from rich.console import Console
from rich.progress import (
    Progress,
    SpinnerColumn,
    BarColumn,
    TextColumn,
    TimeElapsedColumn,
    TaskProgressColumn,
)

warnings.filterwarnings("ignore", category=UserWarning, module="UnityPy")
UnityPy.config.FALLBACK_UNITY_VERSION = "2022.3.62f3"
console = Console()


@dataclass
class BundleTask:
    pattern: str
    output_subdir: str
    asset_type: str
    name_filter: Optional[Callable[[str], bool]] = None
    description: str = ""
    override_output_dir: Optional[str] = None


def get_script_dir() -> Path:
    return Path(__file__).parent.resolve()


def ensure_dir(path: Path) -> None:
    path.mkdir(parents=True, exist_ok=True)


def load_bundle(bundle_path: str) -> tuple:
    try:
        env = UnityPy.load(bundle_path)
        return (bundle_path, env)
    except Exception as e:
        return (bundle_path, None)


def save_asset(args: Tuple) -> Tuple[bool, str, str]:
    asset_data, output_path, name, subdir, asset_type = args
    try:
        if asset_type in ("Texture2D", "Sprite"):
            asset_data.save(output_path)
            return (True, name, subdir)
        elif asset_type == "MonoBehaviour":
            with open(output_path, "w", encoding="utf-8") as f:
                json.dump(asset_data, f, ensure_ascii=False, indent=4)
            return (True, name, subdir)
        return (False, name, subdir)
    except Exception as e:
        return (False, name, subdir)


def process_task(
    task: BundleTask, input_dir: Path, unpack_dir: Path, progress: Progress, task_id
) -> int:
    if task.override_output_dir:
        output_dir = Path(task.override_output_dir)
        if task.output_subdir:
            output_dir = output_dir / task.output_subdir
    else:
        output_dir = unpack_dir / task.output_subdir
    ensure_dir(output_dir)
    full_pattern = str(input_dir / task.pattern)
    bundle_files = glob(full_pattern, recursive=True)

    if not bundle_files:
        progress.update(
            task_id, description=f"[yellow]{task.description}: 未找到bundle"
        )
        return 0

    progress.update(
        task_id,
        description=f"[cyan]{task.description}: 加载中...",
        total=len(bundle_files),
        completed=0,
    )

    loaded_bundles = []
    with ThreadPoolExecutor(max_workers=8) as executor:
        futures = {executor.submit(load_bundle, path): path for path in bundle_files}
        for future in as_completed(futures):
            path, env = future.result()
            if env is not None:
                loaded_bundles.append(env)
            progress.advance(task_id)

    if not loaded_bundles:
        progress.update(task_id, description=f"[red]{task.description}: 加载失败")
        return 0

    progress.update(
        task_id,
        description=f"[magenta]{task.description}: 扫描资产...",
        total=None,
        completed=0,
    )

    export_tasks = []
    if task.asset_type == "Texture2D":
        target_type = ClassIDType.Texture2D
    elif task.asset_type == "Sprite":
        target_type = ClassIDType.Sprite
    elif task.asset_type == "MonoBehaviour":
        target_type = ClassIDType.MonoBehaviour
    else:
        target_type = None

    for env in loaded_bundles:
        for asset in env.objects:
            if target_type and asset.type != target_type:
                continue

            try:
                data = asset.read()
                name = getattr(data, "m_Name", getattr(data, "name", ""))
                if not name:
                    name = getattr(data, "m_PathID", asset.path_id)
                    name = f"Unnamed_{name}"
                    
                if task.asset_type == "MonoBehaviour":
                    tree = asset.read_typetree()
                    if tree.get("m_Name"):
                        name = tree.get("m_Name")
                
                if task.name_filter and not task.name_filter(name):
                    continue
                
                if task.asset_type in ("Texture2D", "Sprite"):
                    img = data.image
                    output_path = output_dir / f"{name}.png"
                    export_tasks.append((img, str(output_path), name, task.output_subdir, task.asset_type))
                elif task.asset_type == "MonoBehaviour":
                    output_path = output_dir / f"{name}.json"
                    export_tasks.append((tree, str(output_path), name, task.output_subdir, task.asset_type))

            except Exception:
                pass

    if not export_tasks:
        progress.update(task_id, description=f"[yellow]{task.description}: 无匹配资产")
        del loaded_bundles
        return 0

    progress.update(
        task_id,
        description=f"[green]{task.description}: 导出中...",
        total=len(export_tasks),
        completed=0,
    )

    success_count = 0
    lock = threading.Lock()

    with ThreadPoolExecutor(max_workers=16) as executor:
        futures = [executor.submit(save_asset, args) for args in export_tasks]

        for future in as_completed(futures):
            success, name, subdir = future.result()
            if success:
                with lock:
                    success_count += 1
            progress.advance(task_id)

    unit = "个" if task.asset_type == "MonoBehaviour" else "张"
    progress.update(
        task_id, description=f"[bold green]{task.description}: ✓ {success_count}{unit}"
    )

    del loaded_bundles
    del export_tasks

    return success_count


def main():
    if len(sys.argv) < 2:
        console.print("[bold red]用法:[/] python unpack_assets.py <输入文件夹路径>")
        console.print("[dim]示例: python unpack_assets.py /path/to/bundles[/]")
        sys.exit(1)

    input_dir = Path(sys.argv[1]).resolve()

    if not input_dir.exists():
        console.print(f"[bold red]错误:[/] 输入目录不存在: {input_dir}")
        sys.exit(1)

    if not input_dir.is_dir():
        console.print(f"[bold red]错误:[/] 输入路径不是目录: {input_dir}")
        sys.exit(1)

    script_dir = get_script_dir()
    unpack_dir = Path("/home/rikka/zhenxun_bot/zhenxun/plugins/nonebot_plugin_eversoul_tools/resource/image")
    tasks = [
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/banner/*.bundle",
        #     output_subdir="banner",
        #     asset_type="Texture2D",
        #     description="banner",
        # ),
        # BundleTask(
        #     pattern="story_assets_assets/bundles/story/love/*/*.bundle",
        #     output_subdir="cg",
        #     asset_type="Texture2D",
        #     name_filter=lambda name: name.startswith("Talk_Event_"),
        #     description="cg",
        # ),
        # BundleTask(
        #     pattern="story_assets_assets/bundles/story/talk.bundle",
        #     output_subdir="evertalk",
        #     asset_type="Texture2D",
        #     name_filter=lambda name: name.startswith("Evertalk_"),
        #     description="evertalk",
        # ),
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/souls/*.bundle",
        #     output_subdir="soul",
        #     asset_type="Texture2D",
        #     description="soul",
        # ),
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/town.bundle",
        #     output_subdir="town",
        #     asset_type="Texture2D",
        #     description="town",
        # ),
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/atlas/item.spriteatlas.bundle",
        #     output_subdir="tier",
        #     asset_type="Sprite",
        #     name_filter=lambda name: "Tier" in name,
        #     description="tier",
        # ),
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/atlas/stickeratlas.spriteatlas.bundle",
        #     output_subdir="sticker",
        #     asset_type="Sprite",
        #     description="sticker",
        # ),
        # BundleTask(
        #     pattern="ui_assets_assets/bundles/ui/textures/atlas/profileframeatlas.spriteatlas.bundle",
        #     output_subdir="frame",
        #     asset_type="Sprite",
        #     description="frame",
        # ),
        BundleTask(
            pattern="scriptable_assets_assets/bundles/**/*.bundle",
            output_subdir="",
            asset_type="MonoBehaviour",
            description="scriptable",
            override_output_dir="/home/rikka/zhenxun_bot/zhenxun/plugins/nonebot_plugin_eversoul_tools/data/table/script"
        ),
    ]

    stats = {}

    with Progress(
        SpinnerColumn(),
        TextColumn("[progress.description]{task.description}"),
        BarColumn(bar_width=30),
        TaskProgressColumn(),
        TimeElapsedColumn(),
        console=console,
        transient=False,
    ) as progress:
        main_task = progress.add_task("[bold blue]准备中...", total=None)

        for i, task in enumerate(tasks):
            progress.update(
                main_task,
                description=f"[bold blue][{i+1}/{len(tasks)}] {task.description}",
            )
            count = process_task(task, input_dir, unpack_dir, progress, main_task)
            stats[task.output_subdir] = count
    for subdir, count in stats.items():
        name = subdir if subdir else "scriptable"
        if count > 0:
            console.print(f"[green]✓[/] {name}: [bold]{count}[/] 个文件/图片")
        else:
            console.print(f"[yellow]○[/] {name}: 无")


if __name__ == "__main__":
    main()
