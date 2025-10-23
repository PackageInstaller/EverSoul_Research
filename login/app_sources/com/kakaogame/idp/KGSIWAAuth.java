package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.KGSigninWithAppleProfile;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSIWAAuth.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J*\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\fH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/idp/KGSIWAAuth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "clientId", "", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "redirectUri", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "getAccessToken", "getClientId", "idpLogin", "extras", "idpLoginSync", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "Ljava/lang/Void;", "logout", "unregister", "Companion", "Settings", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSIWAAuth implements IdpAuthHandler, IdpAuthExHandler {
    private static final String TAG = "KGSIWAAuth";
    private static final String authPageUrl = "https://appleid.apple.com/auth/authorize?";
    private String clientId;
    private String redirectUri = "";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String accessToken = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String clientId = getClientId(activity);
        if (clientId != null) {
            this.clientId = clientId;
            String name = KGAuthActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, y.ٴسسݬߨ(1393481690));
            if (!AndroidManifestUtil.checkActivity(activity, name)) {
                return KGResult.INSTANCE.getResult(3000);
            }
            return KGResult.INSTANCE.getSuccessResult();
        }
        return KGResult.INSTANCE.getResult(3000, y.ٴسسݬߨ(1393481642));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getClientId(Activity activity) {
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, y.دײܮڳܯ(2051529069));
        if (string.length() > 0) {
            return string;
        }
        if (Intrinsics.areEqual(AndroidManifestUtil.getPackageName(activity2), y.دײܮڳܯ(2051529197))) {
            return y.ٴسسݬߨ(1393480754);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object idpLoginSync(Activity activity, Continuation<? super KGResult<IdpAccount>> continuation) {
        String str = y.֬ڱܱײٮ(-1158772671);
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        try {
            this.redirectUri = OpenApiService.INSTANCE.getOpenApiUri() + "/service/v3/redirect/siwa";
            StringBuilder sb = new StringBuilder(str);
            String str2 = this.clientId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientId");
                str2 = null;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGSIWAAuth$idpLoginSync$2$1(activity, sb.append(str2).append("&redirect_uri=").append(this.redirectUri).append("&response_type=code%20id_token&scope=email&response_mode=form_post&state=siwa").toString(), this, safeContinuation2, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393481594), e.toString(), e);
            KGResult result = KGResult.INSTANCE.getResult(4001, e.toString());
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(result));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393481594), y.ٴسسݬߨ(1393486762));
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGSIWAAuth$idpLogin$loginResult$1(this, activity, null), 1, null);
        KGResult<IdpAccount> kGResult = (KGResult) runBlocking$default;
        Tracer tracer = Tracer.INSTANCE;
        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
        int code = kGResult.getCode();
        String description = kGResult.getDescription();
        if (description == null) {
            description = kGResult.toString();
        }
        tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
        return kGResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        return accessToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049 A[Catch: Exception -> 0x00b2, TryCatch #0 {Exception -> 0x00b2, blocks: (B:3:0x002a, B:5:0x0030, B:6:0x0036, B:8:0x003d, B:13:0x0049, B:16:0x0051, B:21:0x007b), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: Exception -> 0x00b2, TryCatch #0 {Exception -> 0x00b2, blocks: (B:3:0x002a, B:5:0x0030, B:6:0x0036, B:8:0x003d, B:13:0x0049, B:16:0x0051, B:21:0x007b), top: B:2:0x002a }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kakaogame.KGResult<com.kakaogame.idp.IdpAccount> checkAuth(android.app.Activity r7, com.kakaogame.idp.IdpAccount r8, int r9) {
        /*
            r6 = this;
            r0 = -1159305015(0xffffffffbae668c9, float:-0.0017578836)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = -1158754847(0xffffffffbaeecde1, float:-0.0018219316)
            java.lang.String r2 = com.liapp.y.֬ڱܱײٮ(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r8 = r1.append(r8)
            java.lang.String r8 = r8.toString()
            r1 = 1393481594(0x530ed77a, float:6.1350045E11)
            java.lang.String r1 = com.liapp.y.ٴسسݬߨ(r1)
            r0.m699d(r1, r8)
            com.kakaogame.auth.LoginData r8 = com.kakaogame.auth.AuthDataManager.getLoginData()     // Catch: java.lang.Exception -> Lb2
            if (r8 == 0) goto L35
            java.lang.String r8 = r8.getSiwaRefreshToken()     // Catch: java.lang.Exception -> Lb2
            goto L36
        L35:
            r8 = 0
        L36:
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lb2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L46
            int r0 = r0.length()     // Catch: java.lang.Exception -> Lb2
            if (r0 != 0) goto L44
            goto L46
        L44:
            r0 = r2
            goto L47
        L46:
            r0 = r3
        L47:
            if (r0 == 0) goto L51
            java.lang.String r8 = ""
            com.kakaogame.KGResult r7 = r6.idpLogin(r7, r8, r9)     // Catch: java.lang.Exception -> Lb2
            goto Lcb
        L51:
            com.kakaogame.log.tracer.Tracer r7 = com.kakaogame.log.tracer.Tracer.INSTANCE     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.log.tracer.TraceLoginActionCode r0 = com.kakaogame.log.tracer.TraceLoginActionCode.SDK_IDP_LOGIN     // Catch: java.lang.Exception -> Lb2
            r7.startAction(r9, r0)     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.idp.IdpAccount r7 = com.kakaogame.auth.AuthDataManager.getAccount()     // Catch: java.lang.Exception -> Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r7 = r7.getIdpUserId()     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.idp.IdpAccount r0 = com.kakaogame.auth.AuthDataManager.getAccount()     // Catch: java.lang.Exception -> Lb2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r0 = r0.getIdpAccessToken()     // Catch: java.lang.Exception -> Lb2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lb2
            int r4 = r0.length()     // Catch: java.lang.Exception -> Lb2
            if (r4 != 0) goto L77
            r2 = r3
        L77:
            if (r2 == 0) goto L7b
            java.lang.String r0 = "refreshTokenLogin"
        L7b:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb2
            r2.<init>()     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.server.openapi.OpenApiService r3 = com.kakaogame.server.openapi.OpenApiService.INSTANCE     // Catch: java.lang.Exception -> Lb2
            java.lang.String r3 = r3.getOpenApiUri()     // Catch: java.lang.Exception -> Lb2
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r3 = "/service/v3/redirect/siwa"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lb2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lb2
            r6.redirectUri = r2     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.log.tracer.Tracer r2 = com.kakaogame.log.tracer.Tracer.INSTANCE     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.log.tracer.TraceLoginActionCode r3 = com.kakaogame.log.tracer.TraceLoginActionCode.SDK_IDP_LOGIN     // Catch: java.lang.Exception -> Lb2
            java.lang.String r4 = "Success"
            r5 = 200(0xc8, float:2.8E-43)
            r2.finishAction(r9, r3, r5, r4)     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.KGResult$Companion r9 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.idp.IdpAccount$Companion r2 = com.kakaogame.idp.IdpAccount.INSTANCE     // Catch: java.lang.Exception -> Lb2
            java.lang.String r3 = r6.redirectUri     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.idp.IdpAccount r7 = r2.createSIWAAccount(r7, r0, r8, r3)     // Catch: java.lang.Exception -> Lb2
            com.kakaogame.KGResult r7 = r9.getSuccessResult(r7)     // Catch: java.lang.Exception -> Lb2
            goto Lcb
        Lb2:
            r7 = move-exception
            com.kakaogame.Logger r8 = com.kakaogame.Logger.INSTANCE
            java.lang.String r9 = r7.toString()
            r0 = r7
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r8.m702e(r1, r9, r0)
            com.kakaogame.KGResult$Companion r8 = com.kakaogame.KGResult.INSTANCE
            r9 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r7 = r7.toString()
            com.kakaogame.KGResult r7 = r8.getResult(r9, r7)
        Lcb:
            return r7
            fill-array 0x00cc: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGSIWAAuth.checkAuth(android.app.Activity, com.kakaogame.idp.IdpAccount, int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() {
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() {
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public KGIdpProfile getLocalIdpProfile() {
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        if (authData == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.دײܮڳܯ(2051564517), y.ݮڮֲڭܩ(-628796812));
        linkedHashMap.put(y.ݮڮֲڭܩ(-628796020), authData.getIdpUserId());
        linkedHashMap.put(y.ٴسسݬߨ(1392599370), authData.getIdpAccessToken());
        return new KGSigninWithAppleProfile(linkedHashMap);
    }

    /* compiled from: KGSIWAAuth.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/idp/KGSIWAAuth$Settings;", "", "()V", "redirectUri", "", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        public static final String redirectUri = "v3/redirect/siwa";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }
    }

    /* compiled from: KGSIWAAuth.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/idp/KGSIWAAuth$Companion;", "", "()V", "TAG", "", "accessToken", "authPageUrl", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }
    }
}
