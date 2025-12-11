import sys
import warnings
from pathlib import Path
from glob import glob
from dataclasses import dataclass
from typing import Callable, Optional, Tuple
from concurrent.futures import ThreadPoolExecutor, as_completed
import threading
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


def save_image(args: Tuple) -> Tuple[bool, str, str]:
    img, output_path, name, subdir = args
    try:
        img.save(output_path)
        return (True, name, subdir)
    except Exception as e:
        return (False, name, subdir)


def process_task(
    task: BundleTask, input_dir: Path, unpack_dir: Path, progress: Progress, task_id
) -> int:
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
    target_type = (
        ClassIDType.Texture2D if task.asset_type == "Texture2D" else ClassIDType.Sprite
    )

    for env in loaded_bundles:
        for asset in env.objects:
            if asset.type != target_type:
                continue

            try:
                data = asset.read()
                name = data.m_Name
                if task.name_filter and not task.name_filter(name):
                    continue
                img = data.image
                output_path = output_dir / f"{name}.png"
                export_tasks.append((img, str(output_path), name, task.output_subdir))

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
        futures = [executor.submit(save_image, args) for args in export_tasks]

        for future in as_completed(futures):
            success, name, subdir = future.result()
            if success:
                with lock:
                    success_count += 1
            progress.advance(task_id)

    progress.update(
        task_id, description=f"[bold green]{task.description}: ✓ {success_count}张"
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
    unpack_dir = script_dir / "unpack"
    tasks = [
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/banner/*.bundle",
            output_subdir="banner",
            asset_type="Texture2D",
            description="banner",
        ),
        BundleTask(
            pattern="story_assets_assets/bundles/story/love/*/*.bundle",
            output_subdir="cg",
            asset_type="Texture2D",
            name_filter=lambda name: name.startswith("Talk_Event_"),
            description="cg",
        ),
        BundleTask(
            pattern="story_assets_assets/bundles/story/talk.bundle",
            output_subdir="evertalk",
            asset_type="Texture2D",
            name_filter=lambda name: name.startswith("Evertalk_"),
            description="evertalk",
        ),
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/souls/*.bundle",
            output_subdir="soul",
            asset_type="Texture2D",
            description="soul",
        ),
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/town.bundle",
            output_subdir="town",
            asset_type="Texture2D",
            description="town",
        ),
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/atlas/item.spriteatlas.bundle",
            output_subdir="tier",
            asset_type="Sprite",
            name_filter=lambda name: "Tier" in name,
            description="tier",
        ),
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/atlas/stickeratlas.spriteatlas.bundle",
            output_subdir="sticker",
            asset_type="Sprite",
            description="sticker",
        ),
        BundleTask(
            pattern="ui_assets_assets/bundles/ui/textures/atlas/profileframeatlas.spriteatlas.bundle",
            output_subdir="frame",
            asset_type="Sprite",
            description="frame",
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
        if count > 0:
            console.print(f"[green]✓[/] {subdir}: [bold]{count}[/] 张图片")
        else:
            console.print(f"[yellow]○[/] {subdir}: 无")


if __name__ == "__main__":
    main()
