import importlib.util
import sys
print("installed" if importlib.util.find_spec("google_play_scraper") else "not_installed")
