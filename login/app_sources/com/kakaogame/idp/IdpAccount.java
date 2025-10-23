package com.kakaogame.idp;

import android.text.TextUtils;
import com.kakao.sdk.partner.talk.Constants;
import com.kakaogame.Logger;
import com.kakaogame.MapObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdpAccount.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\tR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\t¨\u0006$"}, m839d2 = {"Lcom/kakaogame/idp/IdpAccount;", "Lcom/kakaogame/MapObject;", "m", "", "", "", "(Ljava/util/Map;)V", "cI", "getCI", "()Ljava/lang/String;", "consumerKey", "getConsumerKey", "consumerSecret", "getConsumerSecret", "idpAccessToken", "getIdpAccessToken", "idpCode", "getIdpCode", "idpLoginType", "getIdpLoginType", "idpRefreshToken", "getIdpRefreshToken", "idpUserId", "getIdpUserId", "redirectUri", "getRedirectUri", IdpAccount.KEY_TOKEN_SECRET, "getTokenSecret", "put", "", "key", "value", "update", "newData", "Companion", "IdpCode", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class IdpAccount extends MapObject {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_ACCESS_TOKEN = "accessToken";
    public static final String KEY_CI = "ci";
    public static final String KEY_CONSUMER_KEY = "consumerKey";
    public static final String KEY_CONSUMER_SECRET = "consumerSecret";
    public static final String KEY_IDP_CODE = "idpCode";
    public static final String KEY_IDP_LOGIN_TYPE = "idpLoginType";
    public static final String KEY_REDIRECT_URI = "redirectUri";
    public static final String KEY_REFRESH_TOKEN = "refreshToken";
    public static final String KEY_TOKEN_SECRET = "tokenSecret";
    public static final String KEY_USER_ID = "userId";
    public static final String LOGIN_TYPE_INSTALLED_APP = "INSTALLED_APP";
    public static final String LOGIN_TYPE_INSTALLED_WEB = "INSTALLED_WEB";
    public static final String LOGIN_TYPE_NOT_INSTALLED_WEB = "NOT_INSTALLED_WEB";
    private static final String TAG = "IdpAccount";
    private static final long serialVersionUID = -5079632821886016463L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createDeviceAccount(String str, String str2) {
        return INSTANCE.createDeviceAccount(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createFacebookAccount(String str, String str2) {
        return INSTANCE.createFacebookAccount(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createGamaniaAccount(String str, String str2) {
        return INSTANCE.createGamaniaAccount(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createGoogleAccount(String str, String str2) {
        return INSTANCE.createGoogleAccount(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createIdpAccount(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.createIdpAccount(str, str2, str3, str4, str5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createSIWAAccount(String str, String str2, String str3, String str4) {
        return INSTANCE.createSIWAAccount(str, str2, str3, str4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount createTwitterAccount(long j, String str, String str2, String str3, String str4) {
        return INSTANCE.createTwitterAccount(j, str, str2, str3, str4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IdpAccount(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpCode() {
        Object obj = get(y.دײܮڳܯ(2051564517));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpUserId() {
        Object obj = get(y.ٴسسݬߨ(1393323586));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpAccessToken() {
        Object obj = get(y.ݬֲ֮ܲت(1512323967));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpRefreshToken() {
        return (String) get(y.֬ڱܱײٮ(-1158898111));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCI() {
        return (String) get(y.ۮڭڭܬި(862366179));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRedirectUri() {
        return (String) get(y.֬ڱܱײٮ(-1158755711));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTokenSecret() {
        return (String) get(y.ݬֲ֮ܲت(1512553407));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getConsumerKey() {
        return (String) get(y.ۮڭڭܬި(862650195));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getConsumerSecret() {
        return (String) get(y.֬ڱܱײٮ(-1158755343));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpLoginType() {
        String str = y.֬ڱܱײٮ(-1158755727);
        if (containsKey(str)) {
            return (String) get(str);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.MapObject
    public void put(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        super.put(key, value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void update(IdpAccount newData) {
        Intrinsics.checkNotNullParameter(newData, y.ٲٴݴ״ٰ(1782170968));
        Map<String, Object> content = newData.getContent();
        Intrinsics.checkNotNull(content);
        for (String str : content.keySet()) {
            Map<String, Object> content2 = newData.getContent();
            Intrinsics.checkNotNull(content2);
            Object obj = content2.get(str);
            if (obj != null) {
                put(str, obj);
            }
        }
    }

    /* compiled from: IdpAccount.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/idp/IdpAccount$IdpCode;", "", "()V", "DEVICE", "", "FACEBOOK", "GOOGLE", "Gamania", "Kakao", "SigninWithApple", "TWITTER", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class IdpCode {
        public static final String DEVICE = "zd3";
        public static final String FACEBOOK = "facebook";
        public static final String GOOGLE = "google";
        public static final String Gamania = "gamania";
        public static final IdpCode INSTANCE = new IdpCode();
        public static final String Kakao = "kakaocapri";
        public static final String SigninWithApple = "siwa";
        public static final String TWITTER = "twitter";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private IdpCode() {
        }
    }

    /* compiled from: IdpAccount.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J4\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0007J*\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J,\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0007J6\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, m839d2 = {"Lcom/kakaogame/idp/IdpAccount$Companion;", "", "()V", "KEY_ACCESS_TOKEN", "", "KEY_CI", "KEY_CONSUMER_KEY", "KEY_CONSUMER_SECRET", "KEY_IDP_CODE", "KEY_IDP_LOGIN_TYPE", "KEY_REDIRECT_URI", "KEY_REFRESH_TOKEN", "KEY_TOKEN_SECRET", "KEY_USER_ID", "LOGIN_TYPE_INSTALLED_APP", "LOGIN_TYPE_INSTALLED_WEB", "LOGIN_TYPE_NOT_INSTALLED_WEB", "TAG", "serialVersionUID", "", "createDeviceAccount", "Lcom/kakaogame/idp/IdpAccount;", "userId", "accessToken", "createFacebookAccount", "createGamaniaAccount", "createGoogleAccount", "createIdpAccount", "idpCode", "ci", "loginType", "createKakaoAccount", "createSIWAAccount", "refreshToken", "redirectUri", "createTwitterAccount", Constants.TOKEN, IdpAccount.KEY_TOKEN_SECRET, "consumerKey", "consumerSecret", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final IdpAccount createKakaoAccount(String userId, String accessToken, String ci, String loginType) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            return createIdpAccount(y.ٴسسݬߨ(1392600890), userId, accessToken, ci, loginType);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createDeviceAccount(String userId, String accessToken) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            return createIdpAccount(y.ݮڮֲڭܩ(-628796564), userId, accessToken, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createGoogleAccount(String userId, String accessToken) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            return createIdpAccount(y.ݮڮֲڭܩ(-628796348), userId, accessToken, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createFacebookAccount(String userId, String accessToken) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            return createIdpAccount(y.ٲٴݴ״ٰ(1781823696), userId, accessToken, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createSIWAAccount(String userId, String accessToken, String refreshToken, String redirectUri) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            IdpAccount createIdpAccount = createIdpAccount(y.ٲٴݴ״ٰ(1781825344), userId, accessToken, null, null);
            if (redirectUri != null) {
                createIdpAccount.put("redirectUri", redirectUri);
            }
            if (refreshToken != null) {
                createIdpAccount.put("refreshToken", refreshToken);
            }
            return createIdpAccount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createGamaniaAccount(String userId, String accessToken) {
            Intrinsics.checkNotNullParameter(userId, y.ٴسسݬߨ(1393323586));
            Intrinsics.checkNotNullParameter(accessToken, y.ݬֲ֮ܲت(1512323967));
            return createIdpAccount(y.ݮڮֲڭܩ(-628796260), userId, accessToken, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createTwitterAccount(long userId, String token, String tokenSecret, String consumerKey, String consumerSecret) {
            Intrinsics.checkNotNullParameter(token, y.٬ݯح׭٩(576089758));
            IdpAccount createIdpAccount = createIdpAccount(y.ۮڭڭܬި(862259635), String.valueOf(userId), token, null, null);
            createIdpAccount.put(IdpAccount.KEY_TOKEN_SECRET, tokenSecret);
            createIdpAccount.put("consumerKey", consumerKey);
            createIdpAccount.put("consumerSecret", consumerSecret);
            return createIdpAccount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final IdpAccount createIdpAccount(String idpCode, String userId, String accessToken, String ci, String loginType) {
            String str = y.دײܮڳܯ(2051564517);
            Intrinsics.checkNotNullParameter(idpCode, str);
            String str2 = y.ٴسسݬߨ(1393323586);
            Intrinsics.checkNotNullParameter(userId, str2);
            String str3 = y.ݬֲ֮ܲت(1512323967);
            Intrinsics.checkNotNullParameter(accessToken, str3);
            boolean isEmpty = TextUtils.isEmpty(idpCode);
            String str4 = y.دײܮڳܯ(2051511413);
            if (isEmpty) {
                Logger.INSTANCE.m701e(str4, "idpCode is null");
                throw new IllegalArgumentException("idpCode is null");
            }
            if (TextUtils.isEmpty(userId)) {
                Logger.INSTANCE.m701e(str4, "userId is null");
                throw new IllegalArgumentException("userId is null");
            }
            if (TextUtils.isEmpty(accessToken)) {
                Logger.INSTANCE.m701e(str4, "accessToken is null");
                throw new IllegalArgumentException("accessToken is null");
            }
            IdpAccount idpAccount = new IdpAccount(new LinkedHashMap());
            idpAccount.put(str, idpCode);
            idpAccount.put(str2, userId);
            idpAccount.put(str3, accessToken);
            if (ci == null) {
                idpAccount.put("ci", "");
            } else {
                idpAccount.put("ci", ci);
            }
            if (!TextUtils.isEmpty(loginType)) {
                idpAccount.put("idpLoginType", loginType);
            }
            return idpAccount;
        }
    }
}
