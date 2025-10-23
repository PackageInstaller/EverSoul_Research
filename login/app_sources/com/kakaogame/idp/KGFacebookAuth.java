package com.kakaogame.idp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGFacebookProfile;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.json.JSONObject;

/* compiled from: KGFacebookAuth.kt */
@Metadata(m838d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002J*\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J*\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0002J2\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132 \u0010 \u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u000f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0!H\u0002J\u001e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0016J\u001c\u0010'\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f0(H\u0002J\u000e\u0010*\u001a\u00020)H\u0082@¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, m839d2 = {"Lcom/kakaogame/idp/KGFacebookAuth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "accessToken", "Lcom/facebook/AccessToken;", "callbackManager", "Lcom/facebook/CallbackManager;", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "profile", "Lcom/facebook/Profile;", "autoLogin", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "checkAuth", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "getAccessToken", "", "idpLogin", "extras", "initialize", "Ljava/lang/Void;", "loadProfile", "loginFacebook", "", "callback", "Lkotlin/Function2;", "Lcom/facebook/login/LoginResult;", "", "loginFacebookSync", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "refreshToken", "Lkotlin/Function1;", "", "refreshTokenSync", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregister", "Companion", "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGFacebookAuth implements IdpAuthHandler, IdpAuthExHandler {
    public static final String KEY_EXPIRE_TIME = "expireTime";
    public static final String KEY_GRAPH_DOMAIN = "graphDomain";
    public static final String KEY_NAME = "name";
    public static final String KEY_PERMISSIONS = "permissions";
    public static final String KEY_PROFILE_IMAGE_URL = "profileImageUrl";
    public static final String KEY_REFRESH_TIME = "refreshTime";
    private static final String TAG = "KGFacebookAuth";
    private AccessToken accessToken;
    private CallbackManager callbackManager = CallbackManager.Factory.create();
    private Profile profile;
    private static final List<String> permissions = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        String str = y.ݮڮֲڭܩ(-628436756);
        String str2 = y.֬ڱܱײٮ(-1158758935);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        try {
            String name = KGAuthActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!AndroidManifestUtil.checkActivity(activity, name)) {
                return KGResult.INSTANCE.getResult(3000);
            }
            List<String> list = permissions;
            list.add("public_profile");
            list.add("email");
            list.addAll(ArraysKt.filterNotNull(ResourceUtil.getStringArray(activity, "facebook_read_pemissions")));
            Logger.INSTANCE.m704i(str, str2 + list);
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            FacebookSdk.sdkInitialize(applicationContext);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(str, th.toString(), th);
            return KGResult.INSTANCE.getResult(4001, th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object loginFacebookSync(Activity activity, Continuation<? super KGResult<LoginResult>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        loginFacebook(activity, new Function2<KGResult<LoginResult>, Long, Unit>() { // from class: com.kakaogame.idp.KGFacebookAuth$loginFacebookSync$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(KGResult<LoginResult> kGResult, Long l) {
                invoke(kGResult, l.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void invoke(KGResult<LoginResult> kGResult, long j) {
                Intrinsics.checkNotNullParameter(kGResult, y.ٴسسݬߨ(1392585418));
                AuthActivityManager.INSTANCE.getInstance().finishActivity(j);
                Continuation<KGResult<LoginResult>> continuation2 = safeContinuation2;
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
    private final void loginFacebook(Activity activity, final Function2<? super KGResult<LoginResult>, ? super Long, Unit> callback) {
        final Ref.LongRef longRef = new Ref.LongRef();
        LoginManager.INSTANCE.getInstance().registerCallback(this.callbackManager, new FacebookCallback<LoginResult>() { // from class: com.kakaogame.idp.KGFacebookAuth$loginFacebook$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onSuccess(LoginResult result) {
                Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
                Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628436756), y.ݮڮֲڭܩ(-628441284) + result);
                callback.invoke(KGResult.INSTANCE.getSuccessResult(result), Long.valueOf(longRef.element));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628436756), y.دײܮڳܯ(2051508405));
                callback.invoke(KGResult.INSTANCE.getResult(9001), Long.valueOf(longRef.element));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException error) {
                Intrinsics.checkNotNullParameter(error, y.٬ݯح׭٩(576154958));
                Logger.INSTANCE.m701e(y.ݮڮֲڭܩ(-628436756), y.ۮڭڭܬި(862342763) + error);
                callback.invoke(KGResult.INSTANCE.getResult(4010, error.toString()), Long.valueOf(longRef.element));
            }
        });
        longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.KGFacebookAuth$loginFacebook$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                List list;
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                try {
                    LoginManager companion = LoginManager.INSTANCE.getInstance();
                    list = KGFacebookAuth.permissions;
                    companion.logInWithReadPermissions(activity2, list);
                } catch (Exception e) {
                    Logger.INSTANCE.m701e(y.ݮڮֲڭܩ(-628436756), y.ۮڭڭܬި(862342763) + e);
                    callback.invoke(KGResult.INSTANCE.getResult(4010, e.toString()), Long.valueOf(longRef.element));
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                CallbackManager callbackManager;
                Logger logger = Logger.INSTANCE;
                StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
                String str = y.ݮڮֲڭܩ(-628756788);
                String sb = append.append(str).append(resultCode).append(str).append(data).toString();
                String str2 = y.ݮڮֲڭܩ(-628436756);
                logger.m699d(str2, sb);
                try {
                    callbackManager = this.callbackManager;
                    callbackManager.onActivityResult(requestCode, resultCode, data);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str2, e.toString(), e);
                    callback.invoke(KGResult.INSTANCE.getResult(4001, e.toString()), Long.valueOf(longRef.element));
                }
            }
        }, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393486762);
        String str2 = y.ݮڮֲڭܩ(-628436756);
        logger.m699d(str2, str);
        try {
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
            if (AccessToken.INSTANCE.getCurrentAccessToken() == null) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGFacebookAuth$idpLogin$idpLoginResult$1(this, activity, null), 1, null);
                KGResult kGResult = (KGResult) runBlocking$default;
                Logger.INSTANCE.m699d(str2, "idpLoginResult: " + kGResult);
                Tracer tracer = Tracer.INSTANCE;
                TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
                int code = kGResult.getCode();
                String description = kGResult.getDescription();
                if (description == null) {
                    description = kGResult.toString();
                }
                tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                Object content = kGResult.getContent();
                Intrinsics.checkNotNull(content);
                AccessToken accessToken = ((LoginResult) content).getAccessToken();
                this.accessToken = accessToken;
                Intrinsics.checkNotNull(accessToken);
                String userId = accessToken.getUserId();
                AccessToken accessToken2 = this.accessToken;
                Intrinsics.checkNotNull(accessToken2);
                String token = accessToken2.getToken();
                Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_PROFILE);
                IdpAccount createFacebookAccount = IdpAccount.INSTANCE.createFacebookAccount(userId, token);
                KGResult<Profile> loadProfile = loadProfile();
                Tracer tracer2 = Tracer.INSTANCE;
                TraceLoginActionCode traceLoginActionCode2 = TraceLoginActionCode.SDK_IDP_PROFILE;
                int code2 = loadProfile.getCode();
                String description2 = loadProfile.getDescription();
                if (description2 == null) {
                    description2 = loadProfile.toString();
                }
                tracer2.finishAction(traceJobId, traceLoginActionCode2, code2, description2);
                if (loadProfile.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadProfile);
                }
                this.profile = loadProfile.getContent();
                return KGResult.INSTANCE.getSuccessResult(createFacebookAccount);
            }
            KGResult<IdpAccount> autoLogin = autoLogin();
            Tracer tracer3 = Tracer.INSTANCE;
            TraceLoginActionCode traceLoginActionCode3 = TraceLoginActionCode.SDK_IDP_LOGIN;
            int code3 = autoLogin.getCode();
            String description3 = autoLogin.getDescription();
            if (description3 == null) {
                description3 = autoLogin.toString();
            }
            tracer3.finishAction(traceJobId, traceLoginActionCode3, code3, description3);
            return autoLogin;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        if (currentAccessToken != null) {
            return currentAccessToken.getToken();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object refreshTokenSync(Continuation<? super Boolean> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        refreshToken(new Function1<Boolean, Unit>() { // from class: com.kakaogame.idp.KGFacebookAuth$refreshTokenSync$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void invoke(boolean z) {
                Boolean valueOf = Boolean.valueOf(z);
                Continuation<Boolean> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(valueOf));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void refreshToken(final Function1<? super Boolean, Unit> callback) {
        AccessToken.INSTANCE.refreshCurrentAccessTokenAsync(new AccessToken.AccessTokenRefreshCallback() { // from class: com.kakaogame.idp.KGFacebookAuth$refreshToken$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshed(AccessToken accessToken) {
                Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628436756), y.٬ݯح׭٩(576540198) + accessToken);
                callback.invoke(true);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.facebook.AccessToken.AccessTokenRefreshCallback
            public void OnTokenRefreshFailed(FacebookException exception) {
                Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628436756), y.֬ڱܱײٮ(-1158753247));
                callback.invoke(false);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount authData, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628436196));
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
        KGResult<IdpAccount> autoLogin = autoLogin();
        Tracer tracer = Tracer.INSTANCE;
        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
        int code = autoLogin.getCode();
        String description = autoLogin.getDescription();
        if (description == null) {
            description = autoLogin.toString();
        }
        tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
        return autoLogin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<IdpAccount> autoLogin() {
        Object runBlocking$default;
        String str = y.٬ݯح׭٩(576540198);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݮڮֲڭܩ(-628444396);
        String str3 = y.ݮڮֲڭܩ(-628436756);
        logger.m699d(str3, str2);
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGFacebookAuth$autoLogin$isSuccess$1(30000L, this, null), 1, null);
            if (!((Boolean) runBlocking$default).booleanValue()) {
                return KGResult.INSTANCE.getResult(4010, "refresh AccessToken Failure.");
            }
            AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
            Logger.INSTANCE.m699d(str3, str + currentAccessToken);
            if (currentAccessToken == null) {
                return KGResult.INSTANCE.getResult(4010, "new access token is null.");
            }
            IdpAccount createFacebookAccount = IdpAccount.INSTANCE.createFacebookAccount(currentAccessToken.getUserId(), currentAccessToken.getToken());
            KGResult<Profile> loadProfile = loadProfile();
            if (loadProfile.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(loadProfile);
            }
            this.profile = loadProfile.getContent();
            return KGResult.INSTANCE.getSuccessResult(createFacebookAccount);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051683317);
        String str2 = y.ݮڮֲڭܩ(-628436756);
        logger.m699d(str2, str);
        try {
            LoginManager.INSTANCE.getInstance().logOut();
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() {
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628436756), y.ٲٴݴ״ٰ(1781928656));
        return logout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Profile> loadProfile() {
        String token;
        JSONObject awaitGetGraphMeRequestWithCache;
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        if (currentAccessToken == null || (token = currentAccessToken.getToken()) == null || (awaitGetGraphMeRequestWithCache = Utility.awaitGetGraphMeRequestWithCache(token)) == null) {
            return KGResult.INSTANCE.getResult(4010, y.ݬֲ֮ܲت(1512557863));
        }
        String optString = awaitGetGraphMeRequestWithCache.optString(y.ٲٴݴ״ٰ(1781792816));
        if (optString == null) {
            return KGResult.INSTANCE.getResult(9999, y.ݮڮֲڭܩ(-628436628));
        }
        return KGResult.INSTANCE.getSuccessResult(new Profile(optString, awaitGetGraphMeRequestWithCache.optString(y.ݬֲ֮ܲت(1512558087)), awaitGetGraphMeRequestWithCache.optString(y.٬ݯح׭٩(576528846)), awaitGetGraphMeRequestWithCache.optString(y.֬ڱܱײٮ(-1158759591)), awaitGetGraphMeRequestWithCache.optString(y.ٲٴݴ״ٰ(1781623392)), Uri.parse(awaitGetGraphMeRequestWithCache.optString(y.ݮڮֲڭܩ(-628442580))), null, 64, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public KGIdpProfile getLocalIdpProfile() {
        IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
        if (authData == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AccessToken currentAccessToken = AccessToken.INSTANCE.getCurrentAccessToken();
        linkedHashMap.put(y.دײܮڳܯ(2051564517), y.ٲٴݴ״ٰ(1781824128));
        linkedHashMap.put(y.ݮڮֲڭܩ(-628796020), authData.getIdpUserId());
        linkedHashMap.put(y.ٴسسݬߨ(1392599370), authData.getIdpAccessToken());
        if (currentAccessToken != null) {
            linkedHashMap.put(y.ٲٴݴ״ٰ(1782315184), Long.valueOf(currentAccessToken.getExpires().getTime()));
            linkedHashMap.put(y.دײܮڳܯ(2051593325), currentAccessToken.getPermissions());
            linkedHashMap.put(y.ݮڮֲڭܩ(-628435884), Long.valueOf(currentAccessToken.getLastRefresh().getTime()));
            linkedHashMap.put(y.ٲٴݴ״ٰ(1782316920), currentAccessToken.getGraphDomain());
        }
        Profile profile = this.profile;
        Intrinsics.checkNotNull(profile);
        linkedHashMap.put(y.ٲٴݴ״ٰ(1781623392), profile.getName());
        linkedHashMap.put(y.٬ݯح׭٩(575735166), ImageRequest.INSTANCE.getProfilePictureUri(authData.getIdpUserId(), 50, 50).toString());
        return new KGFacebookProfile(linkedHashMap);
    }
}
