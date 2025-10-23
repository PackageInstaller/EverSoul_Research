package com.kakao.sdk.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.IntentResolveClient;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.share.model.KakaoTalkSharingAttachment;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
import com.kakaogame.server.ServerConstants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoTalkShareIntentClient.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H\u0002J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJB\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u0012H\u0007J\u0010\u0010!\u001a\n #*\u0004\u0018\u00010\"0\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, m839d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "intentResolveClient", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/util/IntentResolveClient;)V", "getApplicationInfo", "()Lcom/kakao/sdk/common/model/ApplicationInfo;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "getIntentResolveClient", "()Lcom/kakao/sdk/common/util/IntentResolveClient;", "attachmentSize", "", "appKey", "", "response", "Lcom/kakao/sdk/share/model/ValidationResult;", "serverCallbackArgs", "", "extrasWithServerCallbacks", "Lcom/google/gson/JsonObject;", "extras", "isKakaoTalkSharingAvailable", "", "context", "Landroid/content/Context;", "sharingResultFromResponse", "Lcom/kakao/sdk/share/model/SharingResult;", ServerConstants.APP_VERSION, "sharingUriBuilder", "Landroid/net/Uri$Builder;", "kotlin.jvm.PlatformType", "Companion", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoTalkShareIntentClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KakaoTalkShareIntentClient> instance$delegate = LazyKt.lazy(new Function0<KakaoTalkShareIntentClient>() { // from class: com.kakao.sdk.share.KakaoTalkShareIntentClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final KakaoTalkShareIntentClient invoke() {
            return new KakaoTalkShareIntentClient(null, null, null, 7, null);
        }
    });
    private final ApplicationInfo applicationInfo;
    private final ContextInfo contextInfo;
    private final IntentResolveClient intentResolveClient;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoTalkShareIntentClient() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharingResult sharingResultFromResponse(Context context, ValidationResult response, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(response, "response");
        return sharingResultFromResponse$default(this, context, response, map, null, null, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharingResult sharingResultFromResponse(Context context, ValidationResult response, Map<String, String> map, String appKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        return sharingResultFromResponse$default(this, context, response, map, appKey, null, 16, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoTalkShareIntentClient(ContextInfo contextInfo, ApplicationInfo applicationInfo, IntentResolveClient intentResolveClient) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        Intrinsics.checkNotNullParameter(intentResolveClient, "intentResolveClient");
        this.contextInfo = contextInfo;
        this.applicationInfo = applicationInfo;
        this.intentResolveClient = intentResolveClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KakaoTalkShareIntentClient(ApplicationContextInfo applicationContextInfo, ApplicationContextInfo applicationContextInfo2, IntentResolveClient intentResolveClient, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo, (i & 2) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo2, (i & 4) != 0 ? IntentResolveClient.INSTANCE.getInstance() : intentResolveClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IntentResolveClient getIntentResolveClient() {
        return this.intentResolveClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SharingResult sharingResultFromResponse$default(KakaoTalkShareIntentClient kakaoTalkShareIntentClient, Context context, ValidationResult validationResult, Map map, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str = kakaoTalkShareIntentClient.applicationInfo.getAppKey();
        }
        String str3 = str;
        if ((i & 16) != 0) {
            str2 = kakaoTalkShareIntentClient.contextInfo.getAppVer();
        }
        return kakaoTalkShareIntentClient.sharingResultFromResponse(context, validationResult, map, str3, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SharingResult sharingResultFromResponse(Context context, ValidationResult response, Map<String, String> serverCallbackArgs, String appKey, String appVer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(appVer, "appVer");
        int attachmentSize = attachmentSize(appKey, response, serverCallbackArgs);
        if (attachmentSize > 10240) {
            throw new ClientError(ClientErrorCause.BadParameter, "KakaoTalk Share intent size is " + attachmentSize + " bytes. It should be less than 10240 bytes.");
        }
        Uri build = sharingUriBuilder().appendQueryParameter(Constants.LINKVER, Constants.LINKVER_40).appendQueryParameter(Constants.APP_KEY, appKey).appendQueryParameter(Constants.APP_VER, appVer).appendQueryParameter("template_id", String.valueOf(response.getTemplateId())).appendQueryParameter("template_args", String.valueOf(response.getTemplateArgs())).appendQueryParameter(Constants.TEMPLATE_JSON, response.getTemplateMsg().toString()).appendQueryParameter("extras", extrasWithServerCallbacks(this.contextInfo.getExtras(), serverCallbackArgs).toString()).build();
        SdkLog.INSTANCE.m471i(build);
        Intent addFlags = new Intent("android.intent.action.SEND", build).addFlags(335544320);
        Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(Intent.ACTION_SEN….FLAG_ACTIVITY_CLEAR_TOP)");
        Intent resolveTalkIntent = this.intentResolveClient.resolveTalkIntent(context, addFlags);
        if (resolveTalkIntent != null) {
            return new SharingResult(resolveTalkIntent, (Map) KakaoJson.INSTANCE.fromJson(String.valueOf(response.getWarningMsg()), Map.class), (Map) KakaoJson.INSTANCE.fromJson(String.valueOf(response.getArgumentMsg()), Map.class));
        }
        throw new ClientError(ClientErrorCause.NotSupported, "Kakaotalk not installed");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoTalkSharingAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.intentResolveClient.resolveTalkIntent(context, new Intent("android.intent.action.VIEW", sharingUriBuilder().build())) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Uri.Builder sharingUriBuilder() {
        return new Uri.Builder().scheme(Constants.LINK_SCHEME).authority(Constants.TALK_SHARE_AUTHORITY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int attachmentSize(String appKey, ValidationResult response, Map<String, String> serverCallbackArgs) {
        return KakaoJson.INSTANCE.toJson(new KakaoTalkSharingAttachment(null, null, appKey, response.getTemplateMsg().get("P").getAsJsonObject(), response.getTemplateMsg().get("C").getAsJsonObject(), response.getTemplateId(), response.getTemplateArgs(), extrasWithServerCallbacks(this.contextInfo.getExtras(), serverCallbackArgs), 3, null)).length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JsonObject extrasWithServerCallbacks(JsonObject extras, Map<String, String> serverCallbackArgs) {
        JsonObject clone = extras.deepCopy();
        if (serverCallbackArgs == null) {
            Intrinsics.checkNotNullExpressionValue(clone, "clone");
            return clone;
        }
        clone.addProperty(Constants.LCBA, KakaoJson.INSTANCE.toJson(serverCallbackArgs));
        Intrinsics.checkNotNullExpressionValue(clone, "clone");
        return clone;
    }

    /* compiled from: KakaoTalkShareIntentClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "instance$delegate", "Lkotlin/Lazy;", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KakaoTalkShareIntentClient getInstance() {
            return (KakaoTalkShareIntentClient) KakaoTalkShareIntentClient.instance$delegate.getValue();
        }
    }
}
