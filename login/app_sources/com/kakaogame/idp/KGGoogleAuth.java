package com.kakaogame.idp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGGoogleProfile;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.auth.AuthService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGGoogleAuth.kt */
@Metadata(m838d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J*\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0018H\u0016J\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0018H\u0082@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010*J2\u0010+\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u00072 \u0010-\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020,0.H\u0002J\u0016\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0018H\u0082@¢\u0006\u0002\u0010(J\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0082@¢\u0006\u0002\u0010(J\u0010\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u00064"}, m839d2 = {"Lcom/kakaogame/idp/KGGoogleAuth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "accessToken", "", "activity", "Landroid/app/Activity;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "permissions", "", "serverClientId", "signInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getSignInOptions", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "slientSignInOptions", "getSlientSignInOptions", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "account", "traceJobId", "", "getAccessToken", "handleGoogleSignInAccount", "googleAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "idpLogin", "extras", "initialize", "Ljava/lang/Void;", "isGooglePlayServicesAvailable", "logout", "revokeAccess", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInWithCallback", "", "callback", "Lkotlin/Function2;", "", "signOut", "silentSignIn", "unregister", "Companion", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGoogleAuth implements IdpAuthHandler, IdpAuthExHandler {
    private static final int RC_SIGN_IN = 2925;
    private static final int RESULT_CODE_CANCEL = 12501;
    private static final String TAG = "KGGoogleAuth";
    private Activity activity;
    private GoogleSignInClient googleSignInClient;
    private String serverClientId = "";
    private List<String> permissions = new ArrayList();
    private String accessToken = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        KGResult<Void> successResult;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782310352);
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        try {
            this.activity = activity;
            List listOf = CollectionsKt.listOf((Object[]) new String[]{KGAuthActivity.class.getName(), SignInHubActivity.class.getName()});
            this.serverClientId = ResourceUtil.getString(activity, "kg_google_web_app_client_id");
            if (!AndroidManifestUtil.checkMetaData(activity, "com.google.android.gms.version")) {
                successResult = KGResult.INSTANCE.getResult(3000, "com.google.android.gms.version is not defined.");
            } else if (!AndroidManifestUtil.checkMetaData(activity, "com.google.android.gms.games.APP_ID")) {
                successResult = KGResult.INSTANCE.getResult(3000, "com.google.android.gms.games.APP_ID is not defined.");
            } else if (!AndroidManifestUtil.checkActivities(activity, listOf)) {
                successResult = KGResult.INSTANCE.getResult(3000, "No required Activities.");
            } else {
                if (this.serverClientId.length() == 0) {
                    successResult = KGResult.INSTANCE.getResult(3000, "kg_google_web_app_client_id is not defined in res/values/kakao_game_sdk_google_auth.xml");
                } else {
                    this.permissions = ArraysKt.filterNotNull(ResourceUtil.getStringArray(activity, "google_pemissions"));
                    AuthService.Settings.INSTANCE.getLoginParamMap().putAll(MapsKt.mapOf(TuplesKt.m846to("gsiToken", true)));
                    GoogleGameAuth.initialize(activity);
                    successResult = KGResult.INSTANCE.getSuccessResult();
                }
            }
            return successResult;
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(str2, th.toString(), th);
            return KGResult.INSTANCE.getResult(4001, th.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393486762);
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        try {
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
            KGResult<Void> isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity);
            if (isGooglePlayServicesAvailable.isNotSuccess()) {
                Tracer tracer = Tracer.INSTANCE;
                TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
                int code = isGooglePlayServicesAvailable.getCode();
                String description = isGooglePlayServicesAvailable.getDescription();
                if (description == null) {
                    description = isGooglePlayServicesAvailable.toString();
                }
                tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
                return KGResult.INSTANCE.getResult(isGooglePlayServicesAvailable);
            }
            this.googleSignInClient = GoogleSignIn.getClient(activity, getSignInOptions());
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGGoogleAuth$idpLogin$signInResult$1(this, activity, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            Logger.INSTANCE.m699d(str2, "signInResult: " + kGResult);
            Tracer tracer2 = Tracer.INSTANCE;
            TraceLoginActionCode traceLoginActionCode2 = TraceLoginActionCode.SDK_IDP_LOGIN;
            int code2 = kGResult.getCode();
            String description2 = kGResult.getDescription();
            if (description2 == null) {
                description2 = kGResult.toString();
            }
            tracer2.finishAction(traceJobId, traceLoginActionCode2, code2, description2);
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            return KGResult.INSTANCE.getSuccessResult((IdpAccount) kGResult.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object signIn(Activity activity, Continuation<? super KGResult<IdpAccount>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        signInWithCallback(activity, new Function2<KGResult<IdpAccount>, Long, Unit>() { // from class: com.kakaogame.idp.KGGoogleAuth$signIn$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(KGResult<IdpAccount> kGResult, Long l) {
                invoke(kGResult, l.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void invoke(KGResult<IdpAccount> kGResult, long j) {
                Intrinsics.checkNotNullParameter(kGResult, y.ٴسسݬߨ(1392585418));
                AuthActivityManager.INSTANCE.getInstance().finishActivity(j);
                Continuation<KGResult<IdpAccount>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(kGResult));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void signInWithCallback(Activity activity, final Function2<? super KGResult<IdpAccount>, ? super Long, Unit> callback) {
        final Ref.LongRef longRef = new Ref.LongRef();
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        Intrinsics.checkNotNull(googleSignInClient);
        final Intent signInIntent = googleSignInClient.getSignInIntent();
        Intrinsics.checkNotNullExpressionValue(signInIntent, y.ݮڮֲڭܩ(-628437436));
        longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.KGGoogleAuth$signInWithCallback$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                activity2.startActivityForResult(signInIntent, 2925);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                KGResult<IdpAccount> result;
                Logger logger = Logger.INSTANCE;
                StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
                String str = y.ݮڮֲڭܩ(-628756788);
                String sb = append.append(str).append(resultCode).append(str).append(data).toString();
                String str2 = y.֬ڱܱײٮ(-1158758615);
                logger.m699d(str2, sb);
                if (requestCode == 2925) {
                    Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
                    Intrinsics.checkNotNullExpressionValue(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
                    try {
                        result = this.handleGoogleSignInAccount(signedInAccountFromIntent.getResult(ApiException.class));
                    } catch (ApiException e) {
                        Log.w(str2, "signInResult:failed code=" + e.getStatusCode());
                        if (e.getStatusCode() == 12501) {
                            result = KGResult.INSTANCE.getResult(9001);
                        } else {
                            result = KGResult.INSTANCE.getResult(4010, y.ݬֲ֮ܲت(1512556919) + e.getStatusCode());
                        }
                    }
                    AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                    callback.invoke(result, Long.valueOf(longRef.element));
                }
            }
        }, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount account, int traceJobId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628436196);
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        try {
            this.googleSignInClient = GoogleSignIn.getClient(activity, getSlientSignInOptions());
            if (CoreManager.testGoogleErrorCode != 200) {
                if (InfodeskHelper.INSTANCE.isZrtError(IdpAccount.IdpCode.GOOGLE, CoreManager.testGoogleErrorCode)) {
                    return KGResult.INSTANCE.getResult(KGResult.KGResultCode.ZAT_REFRESH_ONLY, "Set Google error code for test.");
                }
                return KGResult.INSTANCE.getResult(401, "Set Google error code for test.");
            }
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGGoogleAuth$checkAuth$signInResult$1(this, null), 1, null);
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
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object silentSignIn(Continuation<? super KGResult<IdpAccount>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        Intrinsics.checkNotNull(googleSignInClient);
        Task<GoogleSignInAccount> silentSignIn = googleSignInClient.silentSignIn();
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        silentSignIn.addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.kakaogame.idp.KGGoogleAuth$silentSignIn$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<GoogleSignInAccount> task) {
                KGResult result;
                Intrinsics.checkNotNullParameter(task, y.دײܮڳܯ(2051295277));
                if (task.isSuccessful()) {
                    result = KGGoogleAuth.this.handleGoogleSignInAccount(task.getResult());
                } else {
                    ApiException apiException = (ApiException) task.getException();
                    if (apiException == null) {
                        result = KGResult.INSTANCE.getResult(401);
                    } else if (InfodeskHelper.INSTANCE.isZrtError(y.ݮڮֲڭܩ(-628796348), apiException.getStatusCode())) {
                        result = KGResult.INSTANCE.getResult(KGResult.KGResultCode.ZAT_REFRESH_ONLY, String.valueOf(task.getException()));
                    } else {
                        result = apiException.getStatusCode() == 7 ? KGResult.INSTANCE.getResult(1001, String.valueOf(task.getException())) : KGResult.INSTANCE.getResult(401, String.valueOf(task.getException()));
                    }
                }
                Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1158758615), y.֬ڱܱײٮ(-1158766151) + result);
                Continuation<KGResult<IdpAccount>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() {
        Object runBlocking$default;
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051683317);
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        try {
            if (this.googleSignInClient != null) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGGoogleAuth$logout$1$1(this, null), 1, null);
                KGResult<Void> kGResult = (KGResult) runBlocking$default;
                if (kGResult != null) {
                    return kGResult;
                }
            }
            return KGResult.INSTANCE.getResult(4010, "google signin client is not init");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object signOut(Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        Intrinsics.checkNotNull(googleSignInClient);
        Task<Void> signOut = googleSignInClient.signOut();
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        signOut.addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.kakaogame.idp.KGGoogleAuth$signOut$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<Void> task) {
                KGResult result;
                Intrinsics.checkNotNullParameter(task, y.دײܮڳܯ(2051295277));
                Logger logger = Logger.INSTANCE;
                String str = y.ۮڭڭܬި(862620267) + task;
                String str2 = y.֬ڱܱײٮ(-1158758615);
                logger.m699d(str2, str);
                if (task.isSuccessful()) {
                    result = KGResult.INSTANCE.getSuccessResult();
                } else if (task.getException() != null) {
                    KGResult.Companion companion = KGResult.INSTANCE;
                    StringBuilder sb = new StringBuilder(y.֬ڱܱײٮ(-1158758471));
                    Exception exception = task.getException();
                    Intrinsics.checkNotNull(exception);
                    result = companion.getResult(4010, sb.append(exception.getMessage()).toString());
                } else {
                    result = KGResult.INSTANCE.getResult(4010);
                }
                Logger.INSTANCE.m699d(str2, y.٬ݯح׭٩(576530382) + result);
                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() {
        Object runBlocking$default;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781928656);
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        try {
            if (this.googleSignInClient != null) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGGoogleAuth$unregister$1$1(this, null), 1, null);
                KGResult<Void> kGResult = (KGResult) runBlocking$default;
                if (kGResult != null) {
                    return kGResult;
                }
            }
            return KGResult.INSTANCE.getResult(4010, "google signin client is not init");
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object revokeAccess(Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        GoogleSignInClient googleSignInClient = this.googleSignInClient;
        Intrinsics.checkNotNull(googleSignInClient);
        Task<Void> revokeAccess = googleSignInClient.revokeAccess();
        Activity activity = this.activity;
        Intrinsics.checkNotNull(activity);
        revokeAccess.addOnCompleteListener(activity, new OnCompleteListener() { // from class: com.kakaogame.idp.KGGoogleAuth$revokeAccess$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task<Void> task) {
                KGResult result;
                Intrinsics.checkNotNullParameter(task, y.دײܮڳܯ(2051295277));
                Logger logger = Logger.INSTANCE;
                String str = y.٬ݯح׭٩(576529790) + task;
                String str2 = y.֬ڱܱײٮ(-1158758615);
                logger.m699d(str2, str);
                if (task.isSuccessful()) {
                    result = KGResult.INSTANCE.getSuccessResult();
                } else if (task.getException() != null) {
                    KGResult.Companion companion = KGResult.INSTANCE;
                    StringBuilder sb = new StringBuilder(y.֬ڱܱײٮ(-1158758471));
                    Exception exception = task.getException();
                    Intrinsics.checkNotNull(exception);
                    result = companion.getResult(4010, sb.append(exception.getMessage()).toString());
                } else {
                    result = KGResult.INSTANCE.getResult(4010);
                }
                Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628575740) + result);
                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public KGIdpProfile getLocalIdpProfile() {
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        if (authData == null) {
            return null;
        }
        return new KGGoogleProfile(MapsKt.mutableMapOf(TuplesKt.m846to(y.دײܮڳܯ(2051564517), y.٬ݯح׭٩(575840726)), TuplesKt.m846to(y.ݮڮֲڭܩ(-628796020), authData.getIdpUserId()), TuplesKt.m846to(y.ٴسسݬߨ(1392599370), authData.getIdpAccessToken())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final GoogleSignInOptions getSlientSignInOptions() {
        GoogleSignInOptions.Builder requestId = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestIdToken(this.serverClientId).requestId();
        Intrinsics.checkNotNullExpressionValue(requestId, y.٬ݯح׭٩(576535182));
        GoogleSignInOptions build = requestId.build();
        Intrinsics.checkNotNullExpressionValue(build, y.٬ݯح׭٩(576535150));
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final GoogleSignInOptions getSignInOptions() {
        GoogleSignInOptions.Builder requestProfile = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().requestId().requestServerAuthCode(this.serverClientId).requestIdToken(this.serverClientId).requestProfile();
        Intrinsics.checkNotNullExpressionValue(requestProfile, y.֬ڱܱײٮ(-1158766455));
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1158758615), y.֬ڱܱײٮ(-1158758935) + this.permissions);
        if (!this.permissions.isEmpty()) {
            int i = 0;
            Scope scope = new Scope(this.permissions.get(0));
            if (this.permissions.size() == 1) {
                requestProfile.requestScopes(scope, new Scope[0]);
            } else {
                int size = this.permissions.size() - 1;
                Scope[] scopeArr = new Scope[size];
                int size2 = this.permissions.size() - 1;
                while (i < size2) {
                    int i2 = i + 1;
                    scopeArr[i] = new Scope(this.permissions.get(i2));
                    i = i2;
                }
                requestProfile.requestScopes(scope, (Scope[]) Arrays.copyOf(scopeArr, size));
            }
        }
        GoogleSignInOptions build = requestProfile.build();
        Intrinsics.checkNotNullExpressionValue(build, y.٬ݯح׭٩(576535150));
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<IdpAccount> handleGoogleSignInAccount(GoogleSignInAccount googleAccount) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628438164) + googleAccount;
        String str2 = y.֬ڱܱײٮ(-1158758615);
        logger.m699d(str2, str);
        if (googleAccount != null) {
            try {
                String id = googleAccount.getId();
                this.accessToken = googleAccount.getIdToken();
                IdpAccount.Companion companion = IdpAccount.INSTANCE;
                Intrinsics.checkNotNull(id);
                String str3 = this.accessToken;
                Intrinsics.checkNotNull(str3);
                KGResult<IdpAccount> successResult = KGResult.INSTANCE.getSuccessResult(companion.createGoogleAccount(id, str3));
                if (successResult != null) {
                    return successResult;
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }
        return KGResult.INSTANCE.getResult(4010);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> isGooglePlayServicesAvailable(Activity activity) {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1158758615), y.ٴسسݬߨ(1393490042));
        int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 2 || isGooglePlayServicesAvailable == 3 || isGooglePlayServicesAvailable == 9) {
            Dialog errorDialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, isGooglePlayServicesAvailable, 0);
            if (errorDialog != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGGoogleAuth$isGooglePlayServicesAvailable$1$1(errorDialog, null), 3, null);
            }
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.GOOGLE_PLAY_SERVICE_NOT_AVAILABLE, y.٬ݯح׭٩(576535854) + isGooglePlayServicesAvailable);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }
}
