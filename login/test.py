# import requests
# import json

# url = "https://gc-openapi-zinny3.kakaogames.com/service/v4/device/accessToken/create"

# payload = {
#   "appVer": "1.22.101",
#   "sdkVer": "3.19.0",
#   "os": "android",
#   "market": "googlePlay",
#   "deviceId": "899ab7a1-2615-4e0a-ad7e-361e8f62701d",
#   "serialNo": "android",
#   "previousDeviceId": "899ab7a1-2615-4e0a-ad7e-361e8f62701d",
#   "previousSerialNo": "android"
# }

# headers = {
#   'Content-Type': "application/json",
#   'appId': "743487",
#   'appSecret': "b953bedf9e8064130414a22fa255d584",
#   'DLS': "5;LynaOCuns3fNpo/FdiON76mDyHGymbceWedJhs11aKg=",
#   'requestedBy': "android"
# }

# response = requests.post(url, data=json.dumps(payload), headers=headers)

# print(response.text)

# import requests

# url = "https://kauth.kakao.com/oauth/token"

# payload = {
#     'client_id': "b953bedf9e8064130414a22fa255d584",
#     'android_key_hash': "hxzTbXEVyRdePZdlMFSQ8TlKaEI=",
#     'refresh_token': "ttkAo6k-wMt6oiAFsDghBJIPkiFWluQcAAAAAgoXFp8AAAGW3Z67WqhuWkW__Nqy",
#     'grant_type': "refresh_token"
# }

# response = requests.post(url, data=payload)

# print(response.text)

# import base64
# token = "fwPla7fQ8ty9+DZT/lD//kfb3qv48r871Rt6cTazo8gswG0F83kpBVhCZJgq2+nutTnynHMaPcrZlVOlTlJlb0oV8RoaPhEPrmGXKkJrPLztU19c4RtrbXr9D3xKe8LTuisMjhy+QROBlha8E6Gf/aGa5vbQA3iXY4sQbYQptyAUk25D9ze875IJ9aUn0KaYI45CwpAPKDvI4INZxKFMf9HbhRvkvfc/v5OfiyLXVP0="
# decoded = base64.urlsafe_b64decode(token)
# print(decoded)

# data = ""
# decoded = base64.b64decode(data)
# print(decoded)


import hmac
import hashlib
import base64
import json

body = {
    "appVer": "1.22.101",
    "sdkVer": "3.19.0",
    "os": "android",
    "market": "googlePlay",
    "deviceId": "899ab7a1-2615-4e0a-ad7e-361e8f62701d",
    "serialNo": "android",
    "previousDeviceId": "899ab7a1-2615-4e0a-ad7e-361e8f62701d",
    "previousSerialNo": "android"
}

appSecret = b"b953bedf9e8064130414a22fa255d584"

body_json = json.dumps(body, separators=(',', ':'), ensure_ascii=False).encode()
sig = hmac.new(appSecret, body_json, hashlib.sha256).digest()
dls_value = "5;" + base64.b64encode(sig).decode()

print(dls_value)
