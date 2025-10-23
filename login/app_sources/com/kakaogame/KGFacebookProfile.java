package com.kakaogame;

import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.ImageRequest;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: KGFacebookProfile.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e0\rH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/KGFacebookProfile;", "Lcom/kakaogame/KGIdpProfile;", "content", "", "", "", "(Ljava/util/Map;)V", "name", "getName", "()Ljava/lang/String;", "profileImageUrl", "getProfileImageUrl", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGFacebookProfile extends KGIdpProfile {
    private static final String TAG = "KGFacebookProfile";
    private static final long serialVersionUID = -2875654182578894278L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGFacebookProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public KGResult<Map<String, KGIdpProfile>> loadFriendProfiles() {
        String str = y.ٲٴݴ״ٰ(1781623392);
        String str2 = y.دײܮڳܯ(2051550101);
        String str3 = y.ݬֲ֮ܲت(1512573855);
        String str4 = y.ݬֲ֮ܲت(1512573703);
        String str5 = y.ݬֲ֮ܲت(1512573671);
        try {
            GraphResponse executeAndWait = new GraphRequest(AccessToken.INSTANCE.getCurrentAccessToken(), "me/friends?fields=name,picture", null, HttpMethod.GET, null, null, 48, null).executeAndWait();
            FacebookRequestError error = executeAndWait.getError();
            if (error != null) {
                return KGResult.INSTANCE.getResult(error.getErrorCode(), error.getErrorMessage());
            }
            JSONObject jsonObject = executeAndWait.getJsonObject();
            Logger.INSTANCE.m704i(str3, str5 + jsonObject);
            if (jsonObject == null) {
                return KGResult.INSTANCE.getResult(2003, "response.getJSONObject() is null");
            }
            JSONArray optJSONArray = jsonObject.optJSONArray(str2);
            Logger.INSTANCE.m704i(str3, str4 + optJSONArray);
            if (optJSONArray == null) {
                return KGResult.INSTANCE.getResult(2003, "response.getJSONObject().optJSONArray(\"data\") is null");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = optJSONArray.getJSONObject(i);
                Logger.INSTANCE.m704i(str3, "friend: " + jSONObject);
                String string = jSONObject.getString("id");
                String string2 = jSONObject.getString(str);
                String string3 = jSONObject.getJSONObject("picture").getJSONObject(str2).getString("url");
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("idpCode", "Facebook");
                linkedHashMap2.put("idpUserId", string);
                linkedHashMap2.put(str, string2);
                linkedHashMap2.put("profileImageUrl", string3);
                KGFacebookProfile kGFacebookProfile = new KGFacebookProfile(linkedHashMap2);
                Intrinsics.checkNotNull(string);
                linkedHashMap.put(string, kGFacebookProfile);
            }
            return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return (String) get(y.ٲٴݴ״ٰ(1781623392));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        String uri = ImageRequest.INSTANCE.getProfilePictureUri(getIdpUserId(), 50, 50).toString();
        Intrinsics.checkNotNullExpressionValue(uri, y.ٲٴݴ״ٰ(1781855688));
        return uri;
    }
}
