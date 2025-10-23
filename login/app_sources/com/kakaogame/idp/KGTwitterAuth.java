package com.kakaogame.idp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.KGTwitterProfile;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.twitter.TwitterOAuthActivity;
import com.kakaogame.twitter.TwitterSSOAuthHandler;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import twitter4j.HttpRequest;
import twitter4j.RequestMethod;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/* compiled from: KGTwitterAuth.kt */
@Metadata(m838d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B\u0005¢\u0006\u0002\u0010\u0003J<\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\u001a\u0010#\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%\u0012\u0004\u0012\u00020\u001d0$J*\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0%2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010'2\u0006\u0010+\u001a\u00020\u001fH\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010\u00072\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010)J\u0010\u0010\u0018\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001fH\u0002J*\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0%2\u0006\u0010(\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u001fH\u0016J&\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020\"H\u0082@¢\u0006\u0002\u00102J2\u00103\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2 \u0010#\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u001d04H\u0002J\u001e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050%2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u00107J\u0018\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090%2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090%H\u0016J\u0010\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090%H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006="}, m839d2 = {"Lcom/kakaogame/idp/KGTwitterAuth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "accessToken", "Ltwitter4j/auth/AccessToken;", "callbackUrl", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "requestToken", "Ltwitter4j/auth/RequestToken;", IdpAccount.IdpCode.TWITTER, "Ltwitter4j/Twitter;", "user", "Ltwitter4j/User;", "getUser", "()Ltwitter4j/User;", "setUser", "(Ltwitter4j/User;)V", "activityResultOnIdpLogin", "", "requestCode", "", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "callback", "Lkotlin/Function1;", "Lcom/kakaogame/KGResult;", "checkAuth", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "getAccessToken", "getAccessTokenSecret", "idpLogin", "extras", "idpLoginWithTwitterSync", SDKConstants.PARAM_INTENT, "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "idpLoginWithWebView", "Lkotlin/Function2;", "", "idpLoginWithWebViewSync", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "Ljava/lang/Void;", "logout", "unregister", "Companion", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGTwitterAuth implements IdpAuthHandler, IdpAuthExHandler {
    private static String CONSUMER_KEY = null;
    private static String CONSUMER_SECRET = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_AUTH_ERROR = "oauth_error";
    public static final String KEY_AUTH_VERIFIER = "oauth_verifier";
    public static final String KEY_CONSUMER_KEY = "consumerKey";
    public static final String KEY_CONSUMER_SECRET = "consumerSecret";
    public static final String KEY_PROFILE_URL = "profileImageUrl";
    public static final String KEY_SCREEN_NAME = "screenName";
    public static final String KEY_TOKEN_SECRET = "idpAccessTokenSecret";
    public static final int SSOAUTH_REQUEST_CODE = 141;
    private static final String TAG = "KGTwitterAuth";
    public static final int WEBLOGIN_REQUEST_CODE = 140;
    private AccessToken accessToken;
    private final String callbackUrl = y.֬ڱܱײٮ(-1158771159);
    private Context context;
    private RequestToken requestToken;
    private Twitter twitter;
    private User user;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setUser(User user) {
        this.user = user;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setContext(Context context) {
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Activity activity2 = activity;
        CONSUMER_KEY = ResourceUtil.getString(activity2, y.ݮڮֲڭܩ(-628482572));
        CONSUMER_SECRET = ResourceUtil.getString(activity2, y.دײܮڳܯ(2051483685));
        if (TextUtils.isEmpty(CONSUMER_KEY) || TextUtils.isEmpty(CONSUMER_SECRET)) {
            return KGResult.INSTANCE.getResult(3000, "트위터 앱에 대한 컨슈머 키와 컨슈머 시크릿 필요함!!");
        }
        this.context = activity.getApplicationContext();
        if (!AndroidManifestUtil.checkActivities(activity2, CollectionsKt.listOf((Object[]) new String[]{KGAuthActivity.class.getName(), TwitterOAuthActivity.class.getName()}))) {
            return KGResult.INSTANCE.getResult(3000);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> idpLogin(Activity activity, String extras, int traceJobId) {
        Object runBlocking$default;
        Object runBlocking$default2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        PackageManager packageManager = activity.getPackageManager();
        Intent component = new Intent().setComponent(new ComponentName(y.֬ڱܱײٮ(-1158778103), y.دײܮڳܯ(2051484845)));
        Intrinsics.checkNotNullExpressionValue(component, y.ݬֲ֮ܲت(1512506295));
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(component, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, y.ݮڮֲڭܩ(-628482924));
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LOGIN);
        if (queryIntentActivities.isEmpty()) {
            runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new KGTwitterAuth$idpLogin$result$1(this, activity, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default2;
            Tracer tracer = Tracer.INSTANCE;
            TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LOGIN;
            int code = kGResult.getCode();
            String description = kGResult.getDescription();
            if (description == null) {
                description = kGResult.toString();
            }
            tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
            if (!kGResult.isSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
        } else {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGTwitterAuth$idpLogin$result$2(this, activity, component, null), 1, null);
            KGResult kGResult2 = (KGResult) runBlocking$default;
            Tracer tracer2 = Tracer.INSTANCE;
            TraceLoginActionCode traceLoginActionCode2 = TraceLoginActionCode.SDK_IDP_LOGIN;
            int code2 = kGResult2.getCode();
            String description2 = kGResult2.getDescription();
            if (description2 == null) {
                description2 = kGResult2.toString();
            }
            tracer2.finishAction(traceJobId, traceLoginActionCode2, code2, description2);
            if (kGResult2.isSuccess()) {
                try {
                    Twitter twitter = this.twitter;
                    Intrinsics.checkNotNull(twitter);
                    this.accessToken = twitter.getOAuthAccessToken();
                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            } else {
                return KGResult.INSTANCE.getResult(kGResult2);
            }
        }
        try {
            getUser(traceJobId);
        } catch (TwitterException e2) {
            e2.printStackTrace();
        }
        IdpAccount.Companion companion = IdpAccount.INSTANCE;
        AccessToken accessToken = this.accessToken;
        Intrinsics.checkNotNull(accessToken);
        long userId = accessToken.getUserId();
        AccessToken accessToken2 = this.accessToken;
        Intrinsics.checkNotNull(accessToken2);
        String token = accessToken2.getToken();
        Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
        AccessToken accessToken3 = this.accessToken;
        Intrinsics.checkNotNull(accessToken3);
        return KGResult.INSTANCE.getSuccessResult(companion.createTwitterAccount(userId, token, accessToken3.getTokenSecret(), CONSUMER_KEY, CONSUMER_SECRET));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object idpLoginWithTwitterSync(Activity activity, final Intent intent, Continuation<? super KGResult<AccessToken>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.KGTwitterAuth$idpLoginWithTwitterSync$2$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                TwitterSSOAuthHandler.startAuthActivityForResult(activity2, intent);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                KGTwitterAuth kGTwitterAuth = this;
                final Ref.LongRef longRef2 = longRef;
                final Continuation<KGResult<AccessToken>> continuation2 = safeContinuation2;
                kGTwitterAuth.activityResultOnIdpLogin(requestCode, resultCode, data, new Function1<KGResult<AccessToken>, Unit>() { // from class: com.kakaogame.idp.KGTwitterAuth$idpLoginWithTwitterSync$2$eventListener$1$onActivityResult$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KGResult<AccessToken> kGResult) {
                        invoke2(kGResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KGResult<AccessToken> kGResult) {
                        Intrinsics.checkNotNullParameter(kGResult, y.ٴسسݬߨ(1392585418));
                        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782304048), y.دײܮڳܯ(2051377101) + kGResult);
                        AuthActivityManager.INSTANCE.getInstance().finishActivity(Ref.LongRef.this.element);
                        AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                        Continuation<KGResult<AccessToken>> continuation3 = continuation2;
                        Result.Companion companion = Result.INSTANCE;
                        continuation3.resumeWith(Result.m1440constructorimpl(kGResult));
                    }
                });
            }
        }, null, 4, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object idpLoginWithWebViewSync(android.app.Activity r6, kotlin.coroutines.Continuation<? super com.kakaogame.KGResult<twitter4j.auth.AccessToken>> r7) {
        /*
            r5 = this;
            kotlin.coroutines.SafeContinuation r0 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r7)
            r0.<init>(r1)
            r1 = r0
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            twitter4j.conf.ConfigurationBuilder r2 = new twitter4j.conf.ConfigurationBuilder
            r2.<init>()
            java.lang.String r3 = com.kakaogame.idp.KGTwitterAuth.CONSUMER_KEY
            r2.setOAuthConsumerKey(r3)
            java.lang.String r3 = com.kakaogame.idp.KGTwitterAuth.CONSUMER_SECRET
            r2.setOAuthConsumerSecret(r3)
            twitter4j.conf.Configuration r2 = r2.build()
            twitter4j.TwitterFactory r3 = new twitter4j.TwitterFactory
            r3.<init>(r2)
            twitter4j.Twitter r2 = r3.getInstance()
            r5.twitter = r2
            r3 = 0
            if (r2 == 0) goto L34
            java.lang.String r4 = r5.callbackUrl     // Catch: twitter4j.TwitterException -> L34
            twitter4j.auth.RequestToken r2 = r2.getOAuthRequestToken(r4)     // Catch: twitter4j.TwitterException -> L34
            goto L35
        L34:
            r2 = r3
        L35:
            r5.requestToken = r2
            if (r2 == 0) goto L45
            com.kakaogame.idp.KGTwitterAuth$idpLoginWithWebViewSync$2$1$1 r2 = new com.kakaogame.idp.KGTwitterAuth$idpLoginWithWebViewSync$2$1$1
            r2.<init>()
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r5.idpLoginWithWebView(r6, r2)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L45:
            if (r3 != 0) goto L5b
            r6 = r5
            com.kakaogame.idp.KGTwitterAuth r6 = (com.kakaogame.idp.KGTwitterAuth) r6
            kotlin.Result$Companion r6 = kotlin.Result.INSTANCE
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE
            r2 = 4001(0xfa1, float:5.607E-42)
            com.kakaogame.KGResult r6 = r6.getResult(r2)
            java.lang.Object r6 = kotlin.Result.m1440constructorimpl(r6)
            r1.resumeWith(r6)
        L5b:
            java.lang.Object r6 = r0.getOrThrow()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r0) goto L68
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r7)
        L68:
            return r6
            fill-array 0x006a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGTwitterAuth.idpLoginWithWebViewSync(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void idpLoginWithWebView(Activity activity, final Function2<? super KGResult<AccessToken>, ? super Long, Unit> callback) {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.KGTwitterAuth$idpLoginWithWebView$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                RequestToken requestToken;
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                Intent intent = new Intent(activity2, (Class<?>) TwitterOAuthActivity.class);
                requestToken = KGTwitterAuth.this.requestToken;
                intent.putExtra(y.ۮڭڭܬި(862632875), requestToken != null ? requestToken.getAuthorizationURL() : null);
                activity2.startActivityForResult(intent, KGTwitterAuth.WEBLOGIN_REQUEST_CODE);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                KGTwitterAuth kGTwitterAuth = KGTwitterAuth.this;
                final KGTwitterAuth kGTwitterAuth2 = KGTwitterAuth.this;
                final Function2<KGResult<AccessToken>, Long, Unit> function2 = callback;
                final Ref.LongRef longRef2 = longRef;
                kGTwitterAuth.activityResultOnIdpLogin(requestCode, resultCode, data, new Function1<KGResult<AccessToken>, Unit>() { // from class: com.kakaogame.idp.KGTwitterAuth$idpLoginWithWebView$eventListener$1$onActivityResult$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(KGResult<AccessToken> kGResult) {
                        invoke2(kGResult);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(KGResult<AccessToken> kGResult) {
                        Twitter twitter;
                        AccessToken accessToken;
                        Intrinsics.checkNotNullParameter(kGResult, y.ٴسسݬߨ(1392585418));
                        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782304048), y.دײܮڳܯ(2051377101) + kGResult);
                        if (kGResult.isSuccess()) {
                            KGTwitterAuth.this.accessToken = kGResult.getContent();
                            twitter = KGTwitterAuth.this.twitter;
                            if (twitter != null) {
                                accessToken = KGTwitterAuth.this.accessToken;
                                twitter.setOAuthAccessToken(accessToken);
                            }
                        }
                        function2.invoke(kGResult, Long.valueOf(longRef2.element));
                        AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                    }
                });
            }
        }, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void getUser(int traceJobId) {
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_PROFILE);
        Twitter twitter = this.twitter;
        if (twitter != null) {
            try {
                this.user = twitter.verifyCredentials();
                Tracer.INSTANCE.finishAction(traceJobId, TraceLoginActionCode.SDK_IDP_PROFILE, 200, "Success");
            } catch (TwitterException e) {
                Logger logger = Logger.INSTANCE;
                String twitterException = e.toString();
                Intrinsics.checkNotNullExpressionValue(twitterException, y.ٲٴݴ״ٰ(1781855688));
                logger.m702e(y.ٲٴݴ״ٰ(1782304048), twitterException, e);
                Tracer.INSTANCE.finishAction(traceJobId, TraceLoginActionCode.SDK_IDP_PROFILE, Tracer.INSTANCE.makeCustomErrorCode(traceJobId, 209), y.ݬֲ֮ܲت(1512568855));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<IdpAccount> checkAuth(Activity activity, IdpAccount authData, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628436196);
        String str2 = y.ٲٴݴ״ٰ(1782304048);
        logger.m699d(str2, str);
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(CONSUMER_KEY);
        configurationBuilder.setOAuthConsumerSecret(CONSUMER_SECRET);
        Intrinsics.checkNotNull(authData);
        configurationBuilder.setOAuthAccessToken(authData.getIdpAccessToken());
        configurationBuilder.setOAuthAccessTokenSecret(authData.getTokenSecret());
        Twitter twitterFactory = new TwitterFactory(configurationBuilder.build()).getInstance();
        this.twitter = twitterFactory;
        if (twitterFactory != null) {
            try {
                getUser(traceJobId);
            } catch (TwitterException e) {
                Logger logger2 = Logger.INSTANCE;
                String twitterException = e.toString();
                Intrinsics.checkNotNullExpressionValue(twitterException, y.ٲٴݴ״ٰ(1781855688));
                logger2.m702e(str2, twitterException, e);
                return KGResult.INSTANCE.getResult(4010);
            }
        }
        return KGResult.INSTANCE.getSuccessResult(authData);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() throws Exception {
        Twitter twitter = this.twitter;
        Intrinsics.checkNotNull(twitter);
        Authorization authorization = twitter.getAuthorization();
        Intrinsics.checkNotNull(authorization, y.ۮڭڭܬި(862601771));
        OAuthAuthorization oAuthAuthorization = (OAuthAuthorization) authorization;
        String authorizationHeader = oAuthAuthorization.getAuthorizationHeader(new HttpRequest(RequestMethod.POST, y.٬ݯح׭٩(576577902), null, oAuthAuthorization, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ٲٴݴ״ٰ(1782078608), authorizationHeader);
        int code = HttpService.requestPOST(y.٬ݯح׭٩(576577902), linkedHashMap, null, HttpService.HttpContentType.STRING).getCode();
        if (code == 200) {
            Twitter twitter2 = this.twitter;
            if (twitter2 != null) {
                twitter2.setOAuthAccessToken(null);
            }
        } else if (code == 401) {
            Logger.INSTANCE.m701e(y.ٲٴݴ״ٰ(1782304048), y.֬ڱܱײٮ(-1158775871));
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() throws Exception {
        Twitter twitter = this.twitter;
        Intrinsics.checkNotNull(twitter);
        Authorization authorization = twitter.getAuthorization();
        Intrinsics.checkNotNull(authorization, y.ۮڭڭܬި(862601771));
        OAuthAuthorization oAuthAuthorization = (OAuthAuthorization) authorization;
        String authorizationHeader = oAuthAuthorization.getAuthorizationHeader(new HttpRequest(RequestMethod.POST, y.٬ݯح׭٩(576577902), null, oAuthAuthorization, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ٲٴݴ״ٰ(1782078608), authorizationHeader);
        int code = HttpService.requestPOST(y.٬ݯح׭٩(576577902), linkedHashMap, null, HttpService.HttpContentType.STRING).getCode();
        if (code == 200) {
            Twitter twitter2 = this.twitter;
            if (twitter2 != null) {
                twitter2.setOAuthAccessToken(null);
            }
        } else if (code == 401) {
            Logger.INSTANCE.m701e(y.ٲٴݴ״ٰ(1782304048), y.֬ڱܱײٮ(-1158775871));
        }
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
        User user = this.user;
        String screenName = user != null ? user.getScreenName() : null;
        if (screenName == null) {
            screenName = "";
        }
        User user2 = this.user;
        String profileImageURL = user2 != null ? user2.getProfileImageURL() : null;
        String str = profileImageURL != null ? profileImageURL : "";
        linkedHashMap.put(y.دײܮڳܯ(2051564517), y.ݬֲ֮ܲت(1512590647));
        linkedHashMap.put(y.ݮڮֲڭܩ(-628796020), authData.getIdpUserId());
        linkedHashMap.put(y.ٴسسݬߨ(1392599370), authData.getIdpAccessToken());
        linkedHashMap.put(y.ٲٴݴ״ٰ(1782264464), authData.getTokenSecret());
        linkedHashMap.put(y.ۮڭڭܬި(862650195), CONSUMER_KEY);
        linkedHashMap.put(y.֬ڱܱײٮ(-1158755343), CONSUMER_SECRET);
        linkedHashMap.put(y.ٴسسݬߨ(1392727170), screenName);
        linkedHashMap.put(y.٬ݯح׭٩(575735166), str);
        return new KGTwitterProfile(linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        AccessToken accessToken = this.accessToken;
        Intrinsics.checkNotNull(accessToken);
        return accessToken.getToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccessTokenSecret(Activity activity) {
        AccessToken accessToken = this.accessToken;
        Intrinsics.checkNotNull(accessToken);
        String tokenSecret = accessToken.getTokenSecret();
        Intrinsics.checkNotNullExpressionValue(tokenSecret, y.دײܮڳܯ(2051485357));
        return tokenSecret;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void activityResultOnIdpLogin(int requestCode, int resultCode, Intent data, Function1<? super KGResult<AccessToken>, Unit> callback) {
        String str;
        KGResult result;
        String intent;
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
        String str2 = y.ݮڮֲڭܩ(-628756788);
        logger.m699d(y.ٲٴݴ״ٰ(1782304048), append.append(str2).append(resultCode).append(str2).append(data).toString());
        str = "";
        if (requestCode == 140) {
            if (resultCode == -1) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGTwitterAuth$activityResultOnIdpLogin$1(data, callback, this, null), 3, null);
                return;
            } else if (resultCode == 1) {
                callback.invoke(KGResult.INSTANCE.getResult(4010, (data != null ? data.getExtras() : null) != null ? data.getStringExtra(KEY_AUTH_ERROR) : ""));
                return;
            } else {
                callback.invoke(KGResult.INSTANCE.getResult(9001));
                return;
            }
        }
        if (requestCode == 141) {
            if (resultCode == -1) {
                String str3 = CONSUMER_KEY;
                String str4 = CONSUMER_SECRET;
                Intrinsics.checkNotNull(data);
                this.twitter = TwitterSSOAuthHandler.handleOnActivityResult(str3, str4, data);
                try {
                    KGResult.Companion companion = KGResult.INSTANCE;
                    Twitter twitter = this.twitter;
                    Intrinsics.checkNotNull(twitter);
                    result = companion.getSuccessResult(twitter.getOAuthAccessToken());
                } catch (TwitterException e) {
                    result = KGResult.INSTANCE.getResult(4010, e.toString());
                }
            } else if (resultCode == 0) {
                result = KGResult.INSTANCE.getResult(9001);
            } else {
                KGResult.Companion companion2 = KGResult.INSTANCE;
                if (data != null && (intent = data.toString()) != null) {
                    str = intent;
                }
                result = companion2.getResult(4010, str);
            }
            callback.invoke(result);
            return;
        }
        callback.invoke(KGResult.INSTANCE.getResult(9001));
    }

    /* compiled from: KGTwitterAuth.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/idp/KGTwitterAuth$Companion;", "", "()V", "CONSUMER_KEY", "", "getCONSUMER_KEY", "()Ljava/lang/String;", "setCONSUMER_KEY", "(Ljava/lang/String;)V", "CONSUMER_SECRET", "getCONSUMER_SECRET", "setCONSUMER_SECRET", "KEY_AUTH_ERROR", "KEY_AUTH_VERIFIER", "KEY_CONSUMER_KEY", "KEY_CONSUMER_SECRET", "KEY_PROFILE_URL", "KEY_SCREEN_NAME", "KEY_TOKEN_SECRET", "SSOAUTH_REQUEST_CODE", "", "TAG", "WEBLOGIN_REQUEST_CODE", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCONSUMER_KEY() {
            return KGTwitterAuth.CONSUMER_KEY;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCONSUMER_KEY(String str) {
            KGTwitterAuth.CONSUMER_KEY = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCONSUMER_SECRET() {
            return KGTwitterAuth.CONSUMER_SECRET;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCONSUMER_SECRET(String str) {
            KGTwitterAuth.CONSUMER_SECRET = str;
        }
    }
}
