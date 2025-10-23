package com.kakao.sdk.common;

import android.content.Context;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.model.ServerHosts;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoSdk.kt */
@Metadata(m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u00102\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u001aJY\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104J\b\u00105\u001a\u00020.H\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001c\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020(X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00067"}, m839d2 = {"Lcom/kakao/sdk/common/KakaoSdk;", "", "()V", "appKey", "", "getAppKey", "()Ljava/lang/String;", "applicationContextInfo", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "getApplicationContextInfo", "()Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "setApplicationContextInfo", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "approvalType", "Lcom/kakao/sdk/common/model/ApprovalType;", "getApprovalType", "()Lcom/kakao/sdk/common/model/ApprovalType;", "setApprovalType", "(Lcom/kakao/sdk/common/model/ApprovalType;)V", "hosts", "Lcom/kakao/sdk/common/model/ServerHosts;", "getHosts", "()Lcom/kakao/sdk/common/model/ServerHosts;", "setHosts", "(Lcom/kakao/sdk/common/model/ServerHosts;)V", "<set-?>", "", "isAutomotive", "()Z", "kaHeader", "getKaHeader", Constants.APP_KEY_HASH, "getKeyHash", "loggingEnabled", "getLoggingEnabled", "setLoggingEnabled", "(Z)V", "redirectUri", "getRedirectUri", "type", "Lcom/kakao/sdk/common/KakaoSdk$Type;", "getType", "()Lcom/kakao/sdk/common/KakaoSdk$Type;", "setType", "(Lcom/kakao/sdk/common/KakaoSdk$Type;)V", "init", "", "context", "Landroid/content/Context;", "customScheme", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/common/model/ServerHosts;Lcom/kakao/sdk/common/model/ApprovalType;Lcom/kakao/sdk/common/model/SdkIdentifier;)V", "registerLifecycleEventObserver", "Type", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoSdk {
    public static final KakaoSdk INSTANCE = new KakaoSdk();
    public static ApplicationContextInfo applicationContextInfo;
    public static ApprovalType approvalType;
    public static ServerHosts hosts;
    private static boolean isAutomotive;
    private static boolean loggingEnabled;
    public static Type type;

    /* compiled from: KakaoSdk.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakao/sdk/common/KakaoSdk$Type;", "", "(Ljava/lang/String;I)V", "KOTLIN", "RX_KOTLIN", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public enum Type {
        KOTLIN,
        RX_KOTLIN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        init$default(context, appKey, null, null, null, null, null, 124, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        init$default(context, appKey, str, null, null, null, null, 120, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        init$default(context, appKey, str, bool, null, null, null, 112, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey, String str, Boolean bool, ServerHosts serverHosts) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        init$default(context, appKey, str, bool, serverHosts, null, null, 96, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey, String str, Boolean bool, ServerHosts serverHosts, ApprovalType approvalType2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        init$default(context, appKey, str, bool, serverHosts, approvalType2, null, 64, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoSdk() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApplicationContextInfo getApplicationContextInfo() {
        ApplicationContextInfo applicationContextInfo2 = applicationContextInfo;
        if (applicationContextInfo2 != null) {
            return applicationContextInfo2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContextInfo");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setApplicationContextInfo(ApplicationContextInfo applicationContextInfo2) {
        Intrinsics.checkNotNullParameter(applicationContextInfo2, "<set-?>");
        applicationContextInfo = applicationContextInfo2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerHosts getHosts() {
        ServerHosts serverHosts = hosts;
        if (serverHosts != null) {
            return serverHosts;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hosts");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setHosts(ServerHosts serverHosts) {
        Intrinsics.checkNotNullParameter(serverHosts, "<set-?>");
        hosts = serverHosts;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getLoggingEnabled() {
        return loggingEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type getType() {
        Type type2 = type;
        if (type2 != null) {
            return type2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setType(Type type2) {
        Intrinsics.checkNotNullParameter(type2, "<set-?>");
        type = type2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApprovalType getApprovalType() {
        ApprovalType approvalType2 = approvalType;
        if (approvalType2 != null) {
            return approvalType2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("approvalType");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setApprovalType(ApprovalType approvalType2) {
        Intrinsics.checkNotNullParameter(approvalType2, "<set-?>");
        approvalType = approvalType2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAutomotive() {
        return isAutomotive;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void init$default(Context context, String str, String str2, Boolean bool, ServerHosts serverHosts, ApprovalType approvalType2, SdkIdentifier sdkIdentifier, int i, Object obj) {
        init(context, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : serverHosts, (i & 32) != 0 ? null : approvalType2, (i & 64) == 0 ? sdkIdentifier : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void init(Context context, String appKey, String customScheme, Boolean loggingEnabled2, ServerHosts hosts2, ApprovalType approvalType2, SdkIdentifier sdkIdentifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        INSTANCE.init(context, appKey, customScheme == null ? Intrinsics.stringPlus("kakao", appKey) : customScheme, loggingEnabled2 == null ? false : loggingEnabled2.booleanValue(), hosts2 == null ? new ServerHosts() : hosts2, approvalType2 == null ? new ApprovalType() : approvalType2, Type.KOTLIN, sdkIdentifier == null ? new SdkIdentifier(null, 1, null) : sdkIdentifier, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppKey() {
        return getApplicationContextInfo().getAppKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRedirectUri() {
        return getApplicationContextInfo().getRedirectUri();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKaHeader() {
        return getApplicationContextInfo().getKaHeader();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKeyHash() {
        return getApplicationContextInfo().getSigningKeyHash();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void init(Context context, String appKey, String customScheme, boolean loggingEnabled2, ServerHosts hosts2, ApprovalType approvalType2, Type type2, SdkIdentifier sdkIdentifier, boolean isAutomotive2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(customScheme, "customScheme");
        Intrinsics.checkNotNullParameter(hosts2, "hosts");
        Intrinsics.checkNotNullParameter(approvalType2, "approvalType");
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(sdkIdentifier, "sdkIdentifier");
        setHosts(hosts2);
        loggingEnabled = loggingEnabled2;
        setType(type2);
        setApprovalType(approvalType2);
        setApplicationContextInfo(new ApplicationContextInfo(context, appKey, customScheme, type2, sdkIdentifier));
        isAutomotive = isAutomotive2;
        registerLifecycleEventObserver();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void registerLifecycleEventObserver() {
        try {
            Class<?> cls = Class.forName(Constants.APP_LIFECYCLE_OBSERVER);
            Object invoke = cls.getDeclaredMethod(Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
            }
            ProcessLifecycleOwner.get().getLifecycle().addObserver((LifecycleEventObserver) invoke);
        } catch (Exception e) {
            SdkLog.INSTANCE.m470e(Intrinsics.stringPlus("Failed to register AppLifecycleObserver ", e));
        }
    }
}
