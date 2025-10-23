package com.kakao.sdk.common.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.Utility;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplicationContextInfo.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000eR\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u000e¨\u00060"}, m839d2 = {"Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ContextInfo;", "context", "Landroid/content/Context;", "appKey", "", "customScheme", "sdkType", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/common/KakaoSdk$Type;Lcom/kakao/sdk/common/model/SdkIdentifier;)V", "getAppKey", "()Ljava/lang/String;", ServerConstants.APP_VERSION, "getAppVer", "applicationContext", "getApplicationContext", "()Landroid/content/Context;", "getCustomScheme", "extras", "Lcom/google/gson/JsonObject;", "getExtras", "()Lcom/google/gson/JsonObject;", "kaHeader", "getKaHeader", "mAppVer", "mApplicationContext", "mClientId", "mCustomScheme", "mExtras", "mKaHeader", "mKeyHash", "mSalt", "", "mSharedPreferences", "Landroid/content/SharedPreferences;", "redirectUri", "getRedirectUri", "salt", "getSalt", "()[B", "sharedPreferences", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "signingKeyHash", "getSigningKeyHash", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ApplicationContextInfo implements ApplicationInfo, ContextInfo {
    private final String mAppVer;
    private final Context mApplicationContext;
    private final String mClientId;
    private final String mCustomScheme;
    private final JsonObject mExtras;
    private final String mKaHeader;
    private final String mKeyHash;
    private final byte[] mSalt;
    private final SharedPreferences mSharedPreferences;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApplicationContextInfo(Context context, String appKey, String customScheme, KakaoSdk.Type sdkType, SdkIdentifier sdkIdentifier) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(customScheme, "customScheme");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        Intrinsics.checkNotNullParameter(sdkIdentifier, "sdkIdentifier");
        this.mClientId = appKey;
        this.mCustomScheme = customScheme;
        this.mKaHeader = Utility.INSTANCE.getKAHeader(context, sdkType, sdkIdentifier);
        this.mKeyHash = Utility.INSTANCE.getKeyHash(context);
        this.mExtras = Utility.INSTANCE.getExtras(context, sdkType);
        SharedPreferences sharedPreferences = context.getSharedPreferences(appKey, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.mSharedPreferences = sharedPreferences;
        if (Build.VERSION.SDK_INT >= 33) {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L)).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        context.packag…      ).versionName\n    }");
        } else {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        @Suppress(\"DEP…ame, 0).versionName\n    }");
        }
        this.mAppVer = str;
        this.mSalt = Utility.INSTANCE.androidId(context);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.mApplicationContext = applicationContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ApplicationInfo
    public String getAppKey() {
        return this.mClientId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ApplicationInfo
    public String getCustomScheme() {
        return this.mCustomScheme;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ApplicationInfo
    public String getRedirectUri() {
        return Intrinsics.stringPlus(this.mCustomScheme, "://oauth");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ContextInfo
    public String getKaHeader() {
        return this.mKaHeader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ContextInfo
    public String getSigningKeyHash() {
        return this.mKeyHash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ContextInfo
    public JsonObject getExtras() {
        return this.mExtras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ContextInfo
    public String getAppVer() {
        return this.mAppVer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.model.ContextInfo
    public byte[] getSalt() {
        return this.mSalt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharedPreferences getSharedPreferences() {
        return this.mSharedPreferences;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }
}
