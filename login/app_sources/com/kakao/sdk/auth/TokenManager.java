package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.AESCipher;
import com.kakao.sdk.common.util.Cipher;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.PersistentKVStore;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.common.util.SharedPrefsWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenManager.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m839d2 = {"Lcom/kakao/sdk/auth/TokenManager;", "Lcom/kakao/sdk/auth/TokenManageable;", "appCache", "Lcom/kakao/sdk/common/util/PersistentKVStore;", "encryptor", "Lcom/kakao/sdk/common/util/Cipher;", "(Lcom/kakao/sdk/common/util/PersistentKVStore;Lcom/kakao/sdk/common/util/Cipher;)V", "getAppCache", "()Lcom/kakao/sdk/common/util/PersistentKVStore;", "currentToken", "Lcom/kakao/sdk/auth/model/OAuthToken;", "getEncryptor", "()Lcom/kakao/sdk/common/util/Cipher;", "clear", "", "getToken", "migrateFromOldVersion", "setToken", com.kakao.sdk.partner.talk.Constants.TOKEN, "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TokenManager implements TokenManageable {
    public static final String atExpiresAtKey = "com.kakao.token.OAuthToken.ExpiresAt";
    public static final String atKey = "com.kakao.token.AccessToken";
    public static final String rtExpiresAtKey = "com.kakao.token.RefreshToken.ExpiresAt";
    public static final String rtKey = "com.kakao.token.RefreshToken";
    public static final String secureModeKey = "com.kakao.token.KakaoSecureMode";
    public static final String tokenKey = "com.kakao.sdk.oauth_token";
    public static final String versionKey = "com.kakao.sdk.version";
    private final PersistentKVStore appCache;
    private OAuthToken currentToken;
    private final Cipher encryptor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<TokenManager> instance$delegate = LazyKt.lazy(new Function0<TokenManager>() { // from class: com.kakao.sdk.auth.TokenManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final TokenManager invoke() {
            return new TokenManager(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TokenManager() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final TokenManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TokenManager(PersistentKVStore appCache, Cipher encryptor) {
        Intrinsics.checkNotNullParameter(appCache, "appCache");
        Intrinsics.checkNotNullParameter(encryptor, "encryptor");
        this.appCache = appCache;
        this.encryptor = encryptor;
        OAuthToken oAuthToken = null;
        if (PersistentKVStore.DefaultImpls.getString$default(appCache, versionKey, null, 2, null) == null) {
            migrateFromOldVersion();
        }
        String string$default = PersistentKVStore.DefaultImpls.getString$default(appCache, tokenKey, null, 2, null);
        if (string$default != null) {
            try {
                oAuthToken = (OAuthToken) KakaoJson.INSTANCE.fromJson(getEncryptor().decrypt(string$default), OAuthToken.class);
            } catch (Throwable th) {
                SdkLog.INSTANCE.m470e(th);
            }
        }
        this.currentToken = oAuthToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ TokenManager(SharedPrefsWrapper sharedPrefsWrapper, AESCipher aESCipher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SharedPrefsWrapper(KakaoSdk.INSTANCE.getApplicationContextInfo().getSharedPreferences()) : sharedPrefsWrapper, (i & 2) != 0 ? new AESCipher(null, 1, null) : aESCipher);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PersistentKVStore getAppCache() {
        return this.appCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Cipher getEncryptor() {
        return this.encryptor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.auth.TokenManageable
    public OAuthToken getToken() {
        return this.currentToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.auth.TokenManageable
    public synchronized void setToken(OAuthToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        OAuthToken oAuthToken = new OAuthToken(token.getAccessToken(), token.getAccessTokenExpiresAt(), token.getRefreshToken(), token.getRefreshTokenExpiresAt(), null, token.getScopes(), 16, null);
        try {
            this.appCache.putString(tokenKey, this.encryptor.encrypt(KakaoJson.INSTANCE.toJson(oAuthToken))).commit();
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
        }
        this.currentToken = oAuthToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.auth.TokenManageable
    public void clear() {
        this.currentToken = null;
        this.appCache.remove(tokenKey).commit();
    }

    /* compiled from: TokenManager.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u00020\u00078FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakao/sdk/auth/TokenManager$Companion;", "", "()V", "atExpiresAtKey", "", "atKey", "instance", "Lcom/kakao/sdk/auth/TokenManager;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/auth/TokenManager;", "instance$delegate", "Lkotlin/Lazy;", "rtExpiresAtKey", "rtKey", "secureModeKey", "tokenKey", "versionKey", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final TokenManager getInstance() {
            return (TokenManager) TokenManager.instance$delegate.getValue();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011a A[Catch: Exception -> 0x0134, TRY_LEAVE, TryCatch #3 {Exception -> 0x0134, blocks: (B:27:0x010f, B:40:0x011a), top: B:26:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void migrateFromOldVersion() {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.auth.TokenManager.migrateFromOldVersion():void");
    }
}
