package com.kakao.sdk.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.IntentResolveClient;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.KakaoResultReceiver;
import com.kakao.sdk.common.util.SdkLog;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: AuthCodeClient.kt */
@Metadata(m838d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u008f\u0002\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00132:\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\f0\"H\u0007¢\u0006\u0002\u0010(J°\u0001\u0010)\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010*\u001a\u00020+2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00132:\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\f0\"H\u0007J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eJe\u0010-\u001a<\u00128\u00126\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\f0\"0.2\u001c\u0010!\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0004\u0012\u00020\f0\"H\u0000¢\u0006\u0002\b/R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthCodeClient;", "", "intentResolveClient", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "approvalType", "Lcom/kakao/sdk/common/model/ApprovalType;", "(Lcom/kakao/sdk/common/util/IntentResolveClient;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApprovalType;)V", "authorizeWithKakaoAccount", "", "context", "Landroid/content/Context;", "prompts", "", "Lcom/kakao/sdk/auth/model/Prompt;", com.kakao.sdk.user.Constants.SCOPES, "", "nonce", Constants.AGT, "channelPublicIds", "serviceTerms", "forceAccountLogin", "", "loginHint", "accountParameters", "", "codeVerifier", "accountsSkipIntro", "accountsTalkLoginVisible", "kauthTxId", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "", "error", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "authorizeWithKakaoTalk", "requestCode", "", "isKakaoTalkLoginAvailable", "resultReceiver", "Lcom/kakao/sdk/common/util/KakaoResultReceiver;", "resultReceiver$auth_release", "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthCodeClient {
    public static final int DEFAULT_REQUEST_CODE = 10012;
    private final ApplicationInfo applicationInfo;
    private final ApprovalType approvalType;
    private final ContextInfo contextInfo;
    private final IntentResolveClient intentResolveClient;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AuthCodeClient> instance$delegate = LazyKt.lazy(new Function0<AuthCodeClient>() { // from class: com.kakao.sdk.auth.AuthCodeClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final AuthCodeClient invoke() {
            return new AuthCodeClient(null, null, null, null, 15, null);
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthCodeClient() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final AuthCodeClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, false, null, null, null, null, null, null, callback, 16256, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, String str3, Map<String, String> map, String str4, Boolean bool, Boolean bool2, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, str3, map, str4, bool, bool2, null, callback, 8192, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, String str3, Map<String, String> map, String str4, Boolean bool, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, str3, map, str4, bool, null, null, callback, 12288, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, String str3, Map<String, String> map, String str4, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, str3, map, str4, null, null, null, callback, 14336, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, String str3, Map<String, String> map, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, str3, map, null, null, null, null, callback, 15360, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, String str3, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, str3, null, null, null, null, null, callback, 15872, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, List<String> list4, boolean z, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, list4, z, null, null, null, null, null, null, callback, 16128, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, List<String> list3, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, list3, null, false, null, null, null, null, null, null, callback, 16320, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, String str2, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, str2, null, null, false, null, null, null, null, null, null, callback, 16352, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, String str, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, str, null, null, null, false, null, null, null, null, null, null, callback, 16368, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, List<String> list2, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, list2, null, null, null, null, false, null, null, null, null, null, null, callback, 16376, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> list, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, list, null, null, null, null, null, false, null, null, null, null, null, null, callback, 16380, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoAccount$default(this, context, null, null, null, null, null, null, false, null, null, null, null, null, null, callback, 16382, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, int i, String str, List<String> list2, List<String> list3, String str2, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, i, str, list2, list3, str2, null, callback, 128, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, int i, String str, List<String> list2, List<String> list3, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, i, str, list2, list3, null, null, callback, 192, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, int i, String str, List<String> list2, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, i, str, list2, null, null, null, callback, 224, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, int i, String str, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, i, str, null, null, null, null, callback, 240, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, int i, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, i, null, null, null, null, null, callback, 248, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> list, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, list, 0, null, null, null, null, null, callback, 252, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        authorizeWithKakaoTalk$default(this, context, null, 0, null, null, null, null, null, callback, 254, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthCodeClient(IntentResolveClient intentResolveClient, ApplicationInfo applicationInfo, ContextInfo contextInfo, ApprovalType approvalType) {
        Intrinsics.checkNotNullParameter(intentResolveClient, "intentResolveClient");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        Intrinsics.checkNotNullParameter(approvalType, "approvalType");
        this.intentResolveClient = intentResolveClient;
        this.applicationInfo = applicationInfo;
        this.contextInfo = contextInfo;
        this.approvalType = approvalType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AuthCodeClient(IntentResolveClient intentResolveClient, ApplicationContextInfo applicationContextInfo, ApplicationContextInfo applicationContextInfo2, ApprovalType approvalType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntentResolveClient.INSTANCE.getInstance() : intentResolveClient, (i & 2) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo, (i & 4) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo2, (i & 8) != 0 ? KakaoSdk.INSTANCE.getApprovalType() : approvalType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoTalkLoginAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.intentResolveClient.resolveTalkIntent(context, AuthCodeIntentFactory.INSTANCE.talkBase()) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void authorizeWithKakaoTalk$default(AuthCodeClient authCodeClient, Context context, List list, int i, String str, List list2, List list3, String str2, String str3, Function2 function2, int i2, Object obj) {
        authCodeClient.authorizeWithKakaoTalk(context, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? 10012 : i, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : list2, (i2 & 32) != 0 ? null : list3, (i2 & 64) != 0 ? null : str2, (i2 & 128) != 0 ? null : str3, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoTalk(Context context, List<? extends Prompt> prompts, int requestCode, String nonce, List<String> channelPublicIds, List<String> serviceTerms, String codeVerifier, String kauthTxId, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!isKakaoTalkLoginAvailable(context)) {
            callback.invoke(null, new ClientError(ClientErrorCause.NotSupported, "KakaoTalk not installed"));
            return;
        }
        try {
            AuthCodeIntentFactory authCodeIntentFactory = AuthCodeIntentFactory.INSTANCE;
            String appKey = this.applicationInfo.getAppKey();
            String redirectUri = this.applicationInfo.getRedirectUri();
            String kaHeader = this.contextInfo.getKaHeader();
            Bundle bundle = new Bundle();
            if (channelPublicIds != null) {
                bundle.putString("channel_public_id", CollectionsKt.joinToString$default(channelPublicIds, ",", null, null, 0, null, null, 62, null));
            }
            if (serviceTerms != null) {
                bundle.putString("service_terms", CollectionsKt.joinToString$default(serviceTerms, ",", null, null, 0, null, null, 62, null));
            }
            String value = this.approvalType.getValue();
            if (value != null) {
                bundle.putString(Constants.APPROVAL_TYPE, value);
            }
            if (codeVerifier != null) {
                Companion companion = INSTANCE;
                byte[] bytes = codeVerifier.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                bundle.putString("code_challenge", companion.codeChallenge(bytes));
                bundle.putString("code_challenge_method", Constants.CODE_CHALLENGE_METHOD_VALUE);
            }
            if (prompts != null) {
                bundle.putString(Constants.PROMPT, CollectionsKt.joinToString$default(prompts, ",", null, null, 0, null, new Function1<Prompt, CharSequence>() { // from class: com.kakao.sdk.auth.AuthCodeClient$authorizeWithKakaoTalk$1$5$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Prompt prompt) {
                        Intrinsics.checkNotNullParameter(prompt, "prompt");
                        return prompt.getValue();
                    }
                }, 30, null));
            }
            if (nonce != null) {
                bundle.putString("nonce", nonce);
            }
            if (kauthTxId != null) {
                bundle.putString(Constants.KAUTH_TX_ID, kauthTxId);
            }
            Unit unit = Unit.INSTANCE;
            context.startActivity(authCodeIntentFactory.talk(context, requestCode, appKey, redirectUri, kaHeader, bundle, resultReceiver$auth_release(callback)));
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
            callback.invoke(null, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void authorizeWithKakaoAccount$default(AuthCodeClient authCodeClient, Context context, List list, List list2, String str, String str2, List list3, List list4, boolean z, String str3, Map map, String str4, Boolean bool, Boolean bool2, String str5, Function2 function2, int i, Object obj) {
        authCodeClient.authorizeWithKakaoAccount(context, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : list4, (i & 128) != 0 ? false : z, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : map, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? null : bool, (i & 4096) != 0 ? null : bool2, (i & 8192) != 0 ? null : str5, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void authorizeWithKakaoAccount(Context context, List<? extends Prompt> prompts, List<String> scopes, String nonce, String agt, List<String> channelPublicIds, List<String> serviceTerms, boolean forceAccountLogin, String loginHint, Map<String, String> accountParameters, String codeVerifier, Boolean accountsSkipIntro, Boolean accountsTalkLoginVisible, String kauthTxId, Function2<? super String, ? super Throwable, Unit> callback) {
        String codeChallenge;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        UriUtility uriUtility = new UriUtility(null, 1, null);
        String appKey = this.applicationInfo.getAppKey();
        String redirectUri = this.applicationInfo.getRedirectUri();
        String kaHeader = this.contextInfo.getKaHeader();
        String value = this.approvalType.getValue();
        if (codeVerifier == null) {
            codeChallenge = null;
        } else {
            Companion companion = INSTANCE;
            byte[] bytes = codeVerifier.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            codeChallenge = companion.codeChallenge(bytes);
        }
        Uri authorize = uriUtility.authorize(appKey, agt, redirectUri, scopes, kaHeader, channelPublicIds, serviceTerms, prompts, loginHint, nonce, value, codeChallenge, codeVerifier == null ? null : Constants.CODE_CHALLENGE_METHOD_VALUE, accountsSkipIntro, accountsTalkLoginVisible, kauthTxId);
        if (forceAccountLogin && accountParameters != null) {
            authorize = uriUtility.accountLoginAndAuthorize(authorize, accountParameters);
        }
        SdkLog.INSTANCE.m471i(authorize);
        try {
            context.startActivity(AuthCodeIntentFactory.INSTANCE.account(context, authorize, this.applicationInfo.getRedirectUri(), resultReceiver$auth_release(callback)));
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
            callback.invoke(null, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ KakaoResultReceiver resultReceiver$auth_release(Function2 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        KakaoResultReceiver<Function2<? super String, ? super Throwable, ? extends Unit>> kakaoResultReceiver = new KakaoResultReceiver<Function2<? super String, ? super Throwable, ? extends Unit>>() { // from class: com.kakao.sdk.auth.AuthCodeClient$resultReceiver$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void receiveOk(Bundle resultData) {
                Uri uri;
                Object m1440constructorimpl;
                String queryParameter;
                if (Build.VERSION.SDK_INT >= 33) {
                    if (resultData != null) {
                        uri = (Uri) resultData.getParcelable(Constants.KEY_URL, Uri.class);
                    }
                    uri = null;
                } else {
                    if (resultData != null) {
                        uri = (Uri) resultData.getParcelable(Constants.KEY_URL);
                    }
                    uri = null;
                }
                String queryParameter2 = uri == null ? null : uri.getQueryParameter("code");
                if (queryParameter2 != null) {
                    Function2<? super String, ? super Throwable, ? extends Unit> emitter = getEmitter();
                    if (emitter == null) {
                        return;
                    }
                    emitter.invoke(queryParameter2, null);
                    return;
                }
                String str = "unknown";
                if (uri != null && (queryParameter = uri.getQueryParameter("error")) != null) {
                    str = queryParameter;
                }
                String queryParameter3 = uri == null ? null : uri.getQueryParameter("error_description");
                Function2<? super String, ? super Throwable, ? extends Unit> emitter2 = getEmitter();
                if (emitter2 == null) {
                    return;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m1440constructorimpl = Result.m1440constructorimpl((AuthErrorCause) KakaoJson.INSTANCE.fromJson(str, AuthErrorCause.class));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1440constructorimpl = Result.m1440constructorimpl(ResultKt.createFailure(th));
                }
                AuthErrorCause authErrorCause = AuthErrorCause.Unknown;
                if (Result.m1446isFailureimpl(m1440constructorimpl)) {
                    m1440constructorimpl = authErrorCause;
                }
                emitter2.invoke(null, new AuthError(302, (AuthErrorCause) m1440constructorimpl, new AuthErrorResponse(str, queryParameter3)));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void receiveCanceled(Bundle resultData) {
                KakaoSdkError kakaoSdkError;
                if (Build.VERSION.SDK_INT >= 33) {
                    kakaoSdkError = resultData == null ? null : (KakaoSdkError) resultData.getSerializable(Constants.KEY_EXCEPTION, KakaoSdkError.class);
                } else {
                    Serializable serializable = resultData == null ? null : resultData.getSerializable(Constants.KEY_EXCEPTION);
                    if (serializable == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.kakao.sdk.common.model.KakaoSdkError");
                    }
                    kakaoSdkError = (KakaoSdkError) serializable;
                }
                Function2<? super String, ? super Throwable, ? extends Unit> emitter = getEmitter();
                if (emitter == null) {
                    return;
                }
                emitter.invoke(null, kakaoSdkError);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.common.util.KakaoResultReceiver
            public void processError() {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown resultCode in AuthCodeReceiver#onReceivedResult()");
                Function2<? super String, ? super Throwable, ? extends Unit> emitter = getEmitter();
                if (emitter == null) {
                    return;
                }
                emitter.invoke(null, illegalArgumentException);
            }
        };
        kakaoResultReceiver.setEmitter(callback);
        return kakaoResultReceiver;
    }

    /* compiled from: AuthCodeClient.kt */
    @Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthCodeClient$Companion;", "", "()V", "DEFAULT_REQUEST_CODE", "", "instance", "Lcom/kakao/sdk/auth/AuthCodeClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/auth/AuthCodeClient;", "instance$delegate", "Lkotlin/Lazy;", "codeChallenge", "", "codeVerifier", "", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
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
        public final AuthCodeClient getInstance() {
            return (AuthCodeClient) AuthCodeClient.instance$delegate.getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String codeVerifier() {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.CODE_VERIFIER_ALGORITHM);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            byte[] bytes = uuid.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = Base64.encodeToString(messageDigest.digest(bytes), 3);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(\n        ….NO_PADDING\n            )");
            return encodeToString;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String codeChallenge(byte[] codeVerifier) {
            Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
            String encodeToString = Base64.encodeToString(MessageDigest.getInstance(Constants.CODE_CHALLENGE_ALGORITHM).digest(codeVerifier), 11);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(\n        …64.URL_SAFE\n            )");
            return encodeToString;
        }
    }
}
