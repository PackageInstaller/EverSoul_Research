import json
from google_play_scraper import app as playstore_app

try:
    result = playstore_app(app_id="com.kakaogames.eversoul", lang="en", country="kr")
    print(json.dumps({"success": True, "version": result["version"]}))
except Exception as e:
    print(json.dumps({"success": False, "error": str(e)}))
