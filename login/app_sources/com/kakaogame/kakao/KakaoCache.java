package com.kakaogame.kakao;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.user.Constants;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.game.StringSet;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.AES256Cipher;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoCache.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0014\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\tH\u0007J\u0018\u0010\u0017\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\u000eJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0002J\u001c\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoCache;", "", "()V", "FREINEDS_KEY", "", "NAME", "PROFILE_KEY", "TAG", "loadRegisteredFriends", "", "Lcom/kakaogame/util/json/JSONObject;", "context", "Landroid/content/Context;", "loadUserProfile", "Lcom/kakaogame/kakao/UserProfile;", "onLogout", "", "parseFriendsMap", "data", "parseUserProfile", "saveRegisteredFriends", "friendInfoMap", "Lcom/kakao/sdk/talk/model/Friend;", "saveUserProfile", "userProfile", "toFriendJSONObject", StringSet.info, "toFriendsMapString", "toUserProfileString", "profile", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoCache {
    private static final String FREINEDS_KEY = "friends";
    public static final KakaoCache INSTANCE = new KakaoCache();
    private static final String NAME = "KakaoCachedData";
    private static final String PROFILE_KEY = "profile";
    private static final String TAG = "KakaoCache";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoCache() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveUserProfile(Context context, UserProfile userProfile) {
        String encryptIV;
        Intrinsics.checkNotNullParameter(userProfile, y.ٴسسݬߨ(1393534834));
        if (context == null) {
            return;
        }
        try {
            String userProfileString = toUserProfileString(userProfile);
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return;
            }
            String encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, userProfileString);
            Intrinsics.checkNotNull(encodeString);
            PreferenceUtil.setString(context, NAME, "profile", encodeString);
        } catch (Exception e) {
            Logger.INSTANCE.m701e(y.دײܮڳܯ(2051450605), y.ݬֲ֮ܲت(1512476399) + e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[Catch: Exception -> 0x0047, TRY_LEAVE, TryCatch #0 {Exception -> 0x0047, blocks: (B:6:0x0004, B:9:0x0018, B:12:0x0021, B:15:0x002a, B:17:0x0036, B:22:0x0042), top: B:5:0x0004 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.kakao.UserProfile loadUserProfile(android.content.Context r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "KakaoCachedData"
            java.lang.String r2 = "profile"
            java.lang.String r3 = ""
            java.lang.String r5 = com.kakaogame.util.PreferenceUtil.getString(r5, r1, r2, r3)     // Catch: java.lang.Exception -> L47
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L47
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L47
            if (r1 == 0) goto L18
            return r0
        L18:
            com.kakaogame.infodesk.InfodeskHelper r1 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE     // Catch: java.lang.Exception -> L47
            java.lang.String r1 = r1.getEncryptKey()     // Catch: java.lang.Exception -> L47
            if (r1 != 0) goto L21
            return r0
        L21:
            com.kakaogame.infodesk.InfodeskHelper r2 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE     // Catch: java.lang.Exception -> L47
            java.lang.String r2 = r2.getEncryptIV()     // Catch: java.lang.Exception -> L47
            if (r2 != 0) goto L2a
            return r0
        L2a:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Exception -> L47
            java.lang.String r5 = com.kakaogame.util.AES256Cipher.decodeString(r1, r2, r5)     // Catch: java.lang.Exception -> L47
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L47
            if (r1 == 0) goto L3f
            int r1 = r1.length()     // Catch: java.lang.Exception -> L47
            if (r1 != 0) goto L3d
            goto L3f
        L3d:
            r1 = 0
            goto L40
        L3f:
            r1 = 1
        L40:
            if (r1 != 0) goto L47
            com.kakaogame.kakao.UserProfile r5 = r4.parseUserProfile(r5)     // Catch: java.lang.Exception -> L47
            return r5
        L47:
            return r0
            fill-array 0x0048: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoCache.loadUserProfile(android.content.Context):com.kakaogame.kakao.UserProfile");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onLogout(Context context) {
        if (context == null) {
            return;
        }
        try {
            PreferenceUtil.remove(context, NAME);
            CoreManager.INSTANCE.getInstance().offKakaoCacheMode();
        } catch (Exception e) {
            Logger.INSTANCE.m701e(y.دײܮڳܯ(2051450605), y.ݬֲ֮ܲت(1512476399) + e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveRegisteredFriends(Context context, Map<String, Friend> friendInfoMap) {
        String encryptIV;
        Intrinsics.checkNotNullParameter(friendInfoMap, y.ٴسسݬߨ(1393534114));
        if (context == null) {
            return;
        }
        try {
            String friendsMapString = INSTANCE.toFriendsMapString(friendInfoMap);
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return;
            }
            String encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, friendsMapString);
            Intrinsics.checkNotNull(encodeString);
            PreferenceUtil.setString(context, NAME, "friends", encodeString);
        } catch (Exception e) {
            Logger.INSTANCE.m701e(y.دײܮڳܯ(2051450605), y.ݬֲ֮ܲت(1512476399) + e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, JSONObject> loadRegisteredFriends(Context context) {
        String string;
        String encryptKey;
        String encryptIV;
        if (context == null) {
            return null;
        }
        try {
            string = PreferenceUtil.getString(context, NAME, "friends", "");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string) || (encryptKey = InfodeskHelper.INSTANCE.getEncryptKey()) == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
            return null;
        }
        Intrinsics.checkNotNull(string);
        String decodeString = AES256Cipher.decodeString(encryptKey, encryptIV, string);
        if (!TextUtils.isEmpty(decodeString)) {
            return parseFriendsMap(decodeString);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String toUserProfileString(UserProfile profile) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", Long.valueOf(profile.getId()));
            String nickname = profile.getNickname();
            String str = y.دײܮڳܯ(2051779213);
            if (nickname != null) {
                jSONObject.put(str, profile.getNickname());
            } else {
                jSONObject.put(str, "");
            }
            String thumbnailImagePath = profile.getThumbnailImagePath();
            String str2 = y.٬ݯح׭٩(576479694);
            if (thumbnailImagePath != null) {
                jSONObject.put(str2, profile.getThumbnailImagePath());
            } else {
                jSONObject.put(str2, "");
            }
            String profileImagePath = profile.getProfileImagePath();
            String str3 = y.֬ڱܱײٮ(-1158677599);
            if (profileImagePath != null) {
                jSONObject.put(str3, profile.getProfileImagePath());
            } else {
                jSONObject.put(str3, "");
            }
            String uuid = profile.getUuid();
            String str4 = y.ٴسسݬߨ(1392679994);
            if (uuid != null) {
                jSONObject.put(str4, profile.getUuid());
            } else {
                jSONObject.put(str4, "");
            }
            jSONObject.put(KGKakao2Auth.KEY_SERVICE_USER_ID, Long.valueOf(profile.getServiceUserId()));
            jSONObject.put(KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, Integer.valueOf(profile.getRemainingInviteCount()));
            jSONObject.put("remainingGroupMsgCount", Integer.valueOf(profile.getRemainingGroupMsgCount()));
            jSONObject.put("hasSignedUp", 1);
            Map<String, String> properties = profile.getProperties();
            String str5 = y.دײܮڳܯ(2051766413);
            if (properties != null) {
                jSONObject.put(str5, profile.getProperties());
            } else {
                jSONObject.put(str5, new HashMap());
            }
            return jSONObject.toJSONString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final UserProfile parseUserProfile(String data) {
        if (TextUtils.isEmpty(data)) {
            return null;
        }
        try {
            Object parse = JSONValue.parse(data);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
            JSONObject jSONObject = (JSONObject) parse;
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain(...)");
            Number number = (Number) jSONObject.get((Object) "id");
            obtain.writeLong(number != null ? number.longValue() : 0L);
            obtain.writeString((String) jSONObject.get((Object) "nickname"));
            obtain.writeString((String) jSONObject.get((Object) "thumbnailImagePath"));
            obtain.writeString((String) jSONObject.get((Object) "profileImagePath"));
            obtain.writeString((String) jSONObject.get((Object) "uuid"));
            Number number2 = (Number) jSONObject.get((Object) KGKakao2Auth.KEY_SERVICE_USER_ID);
            obtain.writeLong(number2 != null ? number2.longValue() : 0L);
            Number number3 = (Number) jSONObject.get((Object) KGKakao2Auth.KEY_REMAINING_INVITE_COUNT);
            obtain.writeInt(number3 != null ? number3.intValue() : 0);
            Number number4 = (Number) jSONObject.get((Object) "remainingGroupMsgCount");
            obtain.writeInt(number4 != null ? number4.intValue() : 0);
            obtain.writeInt(1);
            obtain.writeMap((Map) jSONObject.get((Object) Constants.PROPERTIES));
            obtain.setDataPosition(0);
            return new UserProfile(obtain);
        } catch (ParseException | Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String toFriendsMapString(Map<String, Friend> friendInfoMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : friendInfoMap.keySet()) {
                jSONObject.put(str, toFriendJSONObject(friendInfoMap.get(str)));
            }
            return jSONObject.toJSONString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject toFriendJSONObject(Friend info) {
        JSONObject jSONObject = new JSONObject();
        try {
            Intrinsics.checkNotNull(info);
            jSONObject.put("id", info.getId());
            String profileNickname = info.getProfileNickname();
            String str = y.دײܮڳܯ(2051787741);
            if (profileNickname != null) {
                jSONObject.put(str, info.getProfileNickname());
            } else {
                jSONObject.put(str, "");
            }
            String profileThumbnailImage = info.getProfileThumbnailImage();
            String str2 = y.٬ݯح׭٩(575737358);
            if (profileThumbnailImage != null) {
                jSONObject.put(str2, info.getProfileThumbnailImage());
            } else {
                jSONObject.put(str2, "");
            }
            jSONObject.put("uuid", info.getUuid());
            jSONObject.put("talk_os", "");
            jSONObject.put(com.kakao.sdk.talk.Constants.FAVORITE, info.getFavorite());
            jSONObject.put(com.kakao.sdk.talk.Constants.SERVICE_USER_ID, info.getServiceUserId());
            jSONObject.put("app_registered", true);
            jSONObject.put(com.kakao.sdk.talk.Constants.ALLOWED_MSG, info.getAllowedMsg());
        } catch (Exception e) {
            Logger.INSTANCE.m701e(y.دײܮڳܯ(2051450605), y.ٴسسݬߨ(1393417658) + e);
        }
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Map<String, JSONObject> parseFriendsMap(String data) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(data)) {
            return hashMap;
        }
        try {
            Object parse = JSONValue.parse(data);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
            JSONObject jSONObject = (JSONObject) parse;
            for (String str : jSONObject.keySet()) {
                if (jSONObject.get((Object) str) instanceof JSONObject) {
                    hashMap.put(str, (JSONObject) jSONObject.get((Object) str));
                }
            }
        } catch (ParseException e) {
            Logger.INSTANCE.m701e(y.دײܮڳܯ(2051450605), y.دײܮڳܯ(2051450493) + e);
        }
        return hashMap;
    }
}
