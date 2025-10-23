package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
class EntitiesParseUtil {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EntitiesParseUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static UserMentionEntity[] getUserMentions(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.֬ڱܱײٮ(-1158942687);
        if (jSONObject.isNull(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        UserMentionEntity[] userMentionEntityArr = new UserMentionEntity[length];
        for (int i = 0; i < length; i++) {
            userMentionEntityArr[i] = new UserMentionEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return userMentionEntityArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static URLEntity[] getUrls(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.ݬֲ֮ܲت(1512528087);
        if (jSONObject.isNull(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        URLEntity[] uRLEntityArr = new URLEntity[length];
        for (int i = 0; i < length; i++) {
            uRLEntityArr[i] = new URLEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return uRLEntityArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static HashtagEntity[] getHashtags(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.ۮڭڭܬި(862963123);
        if (jSONObject.isNull(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        HashtagEntity[] hashtagEntityArr = new HashtagEntity[length];
        for (int i = 0; i < length; i++) {
            hashtagEntityArr[i] = new HashtagEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return hashtagEntityArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SymbolEntity[] getSymbols(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.دײܮڳܯ(2051190437);
        if (jSONObject.isNull(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        SymbolEntity[] symbolEntityArr = new SymbolEntity[length];
        for (int i = 0; i < length; i++) {
            symbolEntityArr[i] = new HashtagEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return symbolEntityArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static MediaEntity[] getMedia(JSONObject jSONObject) throws JSONException, TwitterException {
        String str = y.ۮڭڭܬި(862094195);
        if (jSONObject.isNull(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        int length = jSONArray.length();
        MediaEntity[] mediaEntityArr = new MediaEntity[length];
        for (int i = 0; i < length; i++) {
            mediaEntityArr[i] = new MediaEntityJSONImpl(jSONArray.getJSONObject(i));
        }
        return mediaEntityArr;
    }
}
