import json
import shutil
import warnings
from pathlib import Path
from typing import Optional

import UnityPy
import UnityPy.config
from UnityPy.enums import ClassIDType
import yaml

warnings.filterwarnings("ignore", category=UserWarning, module="UnityPy")
UnityPy.config.FALLBACK_UNITY_VERSION = "2022.3.62f3"

EVERSOUL_CONFIG = Path("/home/rikka/zhenxun_bot/zhenxun/plugins/nonebot_plugin_eversoul_tools/data/config")
EVERSOUL_TABLE_LIVE = Path("/home/rikka/zhenxun_bot/zhenxun/plugins/nonebot_plugin_eversoul_tools/data/table/global/live")
EVERSOUL_TABLE_REVIEW = Path("/home/rikka/zhenxun_bot/zhenxun/plugins/nonebot_plugin_eversoul_tools/data/table/global/review")


def get_script_dir() -> Path:
    return Path(__file__).parent.resolve()


def load_bundle(bundle_path: str) -> tuple:
    try:
        env = UnityPy.load(bundle_path)
        return (bundle_path, env)
    except Exception:
        return (bundle_path, None)


def load_ids_from_yamls() -> tuple[set[int], set[int], set[int], set[int]]:
    """返回 (live_hero_ids, live_raid_ids, review_hero_ids, review_raid_ids)"""
    live_hero: set[int] = set()
    live_raid: set[int] = set()
    review_hero: set[int] = set()
    review_raid: set[int] = set()

    for fname, target in (
        ("live_hero_aliase.yaml", live_hero),
        ("live_raid_aliase.yaml", live_raid),
        ("review_hero_aliase.yaml", review_hero),
        ("review_raid_aliase.yaml", review_raid),
    ):
        p = EVERSOUL_CONFIG / fname
        if p.exists():
            with open(p, encoding="utf-8") as f:
                d = yaml.safe_load(f)
                if d and "names" in d:
                    for n in d["names"]:
                        if "hero_id" in n:
                            target.add(int(n["hero_id"]))
    return live_hero, live_raid, review_hero, review_raid


def build_id_to_timeline_map(table_dir: Path) -> dict[int, str]:
    """hero_id -> timeline_folder (小写)"""
    hero_path = table_dir / "Hero.json"
    costume_path = table_dir / "ItemCostume.json"
    if not hero_path.exists() or not costume_path.exists():
        return {}

    with open(hero_path, encoding="utf-8") as f:
        hero_data = json.load(f)
    with open(costume_path, encoding="utf-8") as f:
        costume_data = json.load(f)

    hero_list = hero_data.get("json", [])
    costume_list = costume_data.get("json", [])

    prefab_to_timeline: dict[int, str] = {}
    for c in costume_list:
        no = c.get("no")
        t = c.get("timeline_path")
        if no is not None and t:
            prefab_to_timeline[int(no)] = str(t).strip()

    result: dict[int, str] = {}
    for h in hero_list:
        no = h.get("no")
        prefab = h.get("prefab_path")
        if no is None or prefab is None:
            continue
        hero_id = int(no)
        prefab_id = int(prefab) if isinstance(prefab, (int, float)) else prefab
        timeline = prefab_to_timeline.get(prefab_id)
        if timeline:
            result[hero_id] = timeline.lower()
    return result


def extract_clip_times(asset) -> Optional[tuple[str, float, float]]:
    """提取 AnimationClip 的 (m_Name, m_StartTime, m_StopTime)"""
    try:
        data = asset.read()
    except Exception:
        return None
    name = getattr(data, "m_Name", None) or ""
    if "Clip Parameters" in name or "Recorded" in name:
        return None
    if not hasattr(data, "m_MuscleClip") or not data.m_MuscleClip:
        return None
    mc = data.m_MuscleClip
    start = getattr(mc, "m_StartTime", None)
    stop = getattr(mc, "m_StopTime", None)
    if start is None or stop is None:
        return None
    return (name, float(start), float(stop))


def collect_clips_from_timeline_bundle(bundle_path: Path) -> list[dict]:
    _, env = load_bundle(str(bundle_path))
    if env is None:
        return []
    seen: dict[str, tuple[float, float]] = {}
    for obj in env.objects:
        if obj.type != ClassIDType.AnimationClip:
            continue
        r = extract_clip_times(obj)
        if r is None:
            continue
        name, start, stop = r
        if name not in seen:
            seen[name] = (start, stop)
    return [{"name": n, "start_time": s, "end_time": round(e, 2)} for n, (s, e) in seen.items()]


def generate_animation_yaml(mode: str, kind: str, ids: set[int]) -> dict:
    """mode=live|review, kind=hero|raid"""
    script_dir = get_script_dir()
    table_dir = EVERSOUL_TABLE_LIVE if mode == "live" else EVERSOUL_TABLE_REVIEW
    char_base = script_dir / ("gl_live" if mode == "live" else "gl_review")
    char_base = char_base / "assets" / "character_assets_assets" / "bundles" / "character"

    id_map = build_id_to_timeline_map(table_dir)
    key = "hero_animations" if kind == "hero" else "raid_animations"
    result: dict = {key: {}}

    for vid in sorted(ids):
        folder = id_map.get(vid)
        if not folder:
            continue
        timeline_bundle = char_base / folder / "timeline.bundle"
        if not timeline_bundle.exists():
            continue
        clips = collect_clips_from_timeline_bundle(timeline_bundle)
        if clips:
            result[key][vid] = clips
    return result


def main():
    script_dir = get_script_dir()
    live_hero, live_raid, review_hero, review_raid = load_ids_from_yamls()

    for mode, kind, ids, out_name in (
        ("live", "hero", live_hero, "live_hero_animation.yaml"),
        ("live", "raid", live_raid, "live_raid_animation.yaml"),
        ("review", "hero", review_hero, "review_hero_animation.yaml"),
        ("review", "raid", review_raid, "review_raid_animation.yaml"),
    ):
        data = generate_animation_yaml(mode, kind, ids)
        out_path = script_dir / out_name
        with open(out_path, "w", encoding="utf-8") as f:
            yaml.dump(data, f, allow_unicode=True, default_flow_style=False, sort_keys=False)
        dst = EVERSOUL_CONFIG / out_name
        shutil.copy2(out_path, dst)
        count = len(data.get("hero_animations" if kind == "hero" else "raid_animations", {}))
        print(f"已写入: {out_path} -> {dst} ({count} 个)")


if __name__ == "__main__":
    main()
