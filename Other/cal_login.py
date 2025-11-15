def get_string_hash_code(s):
    if not s:
        return 0
    hash1 = (5381 << 16) + 5381
    hash2 = hash1

    for i in range(0, len(s), 2):
        hash1 = ((hash1 << 5) + hash1) ^ ord(s[i])
        if i + 1 < len(s):
            hash2 = ((hash2 << 5) + hash2) ^ ord(s[i + 1])

        hash1 = hash1 & 0xFFFFFFFF
        if hash1 & 0x80000000:
            hash1 = -(0x100000000 - hash1)
            
        hash2 = hash2 & 0xFFFFFFFF
        if hash2 & 0x80000000:
            hash2 = -(0x100000000 - hash2)

    final_hash = hash1 + (hash2 * 1566083941)
    final_hash = final_hash & 0xFFFFFFFF
    if final_hash & 0x80000000:
        final_hash = -(0x100000000 - final_hash)

    return final_hash

def get_int_hash_code(value):
    return value

def get_login_hash_code(playerId, accessToken, type_val, appId, deviceType_val, deviceModel, country, market, region):

    v5 = 0

    if playerId:
        player_id_hash = get_string_hash_code(playerId)
        v5 = player_id_hash ^ 1
    else:
        v5 = 1

    if accessToken:
        access_token_hash = get_string_hash_code(accessToken)
        v5 ^= access_token_hash

    if type_val != 0:
        v5 ^= get_int_hash_code(type_val)

    if appId != 0:
        v5 ^= get_int_hash_code(appId)

    if deviceType_val != 0:
        v5 ^= get_int_hash_code(deviceType_val)

    if deviceModel:
        device_model_hash = get_string_hash_code(deviceModel)
        v5 ^= device_model_hash

    if country:
        country_hash = get_string_hash_code(country)
        v5 ^= country_hash

    if market:
        market_hash = get_string_hash_code(market)
        v5 ^= market_hash

    if region:
        region_hash = get_string_hash_code(region)
        v5 ^= region_hash
    return v5


player_id = "734521179911"
access_token = "fwPla7fQ8ty9+DZT/lD//td0tuQHQqwAkgVpMUHsu1TZcdLsYBkQfWclKRwT963RVlU0aDmjbwsodDdoy2UxHQCNiCDlm0mm0HgVBBa7VmE9KQ0p1akIuU0O9+2sWW7/qeWckn1ZH1n6ypSZqdtLpl1TYPsXiMU9ZsnyP8NaqM/7IUfu9sxj62v1DtJWO5G7xARTCi3ctE+l+7xxkMqbnBMVKbFI7eDy4jK/S3qhHv0NQ3J6Glj8sqoaURP5Js0k"
type_enum = 1
app_id = 743487
device_type_enum = 1
device_model = "PJE110"
country_code = "kr"
market_code = "0"
region_code = ""

result = get_login_hash_code(
    player_id,
    access_token,
    type_enum,
    app_id,
    device_type_enum,
    device_model,
    country_code,
    market_code,
    region_code
)

print(f" {result}")