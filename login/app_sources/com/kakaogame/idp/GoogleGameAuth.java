package com.kakaogame.idp;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: GoogleGameAuth.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00170\u0019H\u0002J\u001a\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0007J \u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0007H\u0007J\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0017H\u0002J&\u0010!\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00170\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, m839d2 = {"Lcom/kakaogame/idp/GoogleGameAuth;", "", "()V", "LOGIN_STATUS_PREF_NAME", "", "TAG", "isConnected", "", "()Z", "isSignIn", "needBackgroundLogout", "serverClientId", "version", "", "getVersion$annotations", "getVersion", "()I", "autoLogin", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "getServerToken", "", "callback", "Lkotlin/Function1;", "initialize", "logout", "manualLogin", "isBackgroundLogin", "signIn", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signInCompleted", "signInWithCallback", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GoogleGameAuth {
    private static final String LOGIN_STATUS_PREF_NAME = "GoogleGamesLoginStatus";
    private static final String TAG = "GoogleGameAuth";
    private static boolean isSignIn;
    private static final boolean needBackgroundLogout = false;
    public static final GoogleGameAuth INSTANCE = new GoogleGameAuth();
    private static String serverClientId = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int getVersion() {
        return 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getVersion$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GoogleGameAuth() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> initialize(final Activity activity) {
        KGResult<Void> successResult;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781793120);
        String str2 = y.֬ڱܱײٮ(-1158757407);
        logger.m699d(str2, str);
        try {
            List listOf = CollectionsKt.listOf(KGAuthActivity.class.getName());
            serverClientId = ResourceUtil.getString(activity, "kg_google_web_app_client_id");
            Intrinsics.checkNotNull(activity);
            if (!AndroidManifestUtil.checkMetaData(activity, "com.google.android.gms.version")) {
                successResult = KGResult.INSTANCE.getResult(3000, "com.google.android.gms.version is not defined.");
            } else if (!AndroidManifestUtil.checkMetaData(activity, "com.google.android.gms.games.APP_ID")) {
                successResult = KGResult.INSTANCE.getResult(3000, "com.google.android.gms.games.APP_ID is not defined.");
            } else if (!AndroidManifestUtil.checkActivities(activity, listOf)) {
                successResult = KGResult.INSTANCE.getResult(3000, "No required Activities.");
            } else {
                if (serverClientId.length() == 0) {
                    successResult = KGResult.INSTANCE.getResult(3000, "kg_google_web_app_client_id is not defined in res/values/kakao_game_sdk_google_auth.xml");
                } else {
                    CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.idp.GoogleGameAuth$initialize$result$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.core.CoreManager.CoreStateListener
                        public void onConnect(String playerId) {
                            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.core.CoreManager.CoreStateListener
                        public void onLogin(String playerId) {
                            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.core.CoreManager.CoreStateListener
                        public void onPause() {
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.core.CoreManager.CoreStateListener
                        public void onUnregister(String playerId) {
                            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.core.CoreManager.CoreStateListener
                        public void onLogout(String playerId) {
                            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                            GoogleGameAuth.INSTANCE.isConnected();
                        }
                    });
                    successResult = KGResult.INSTANCE.getSuccessResult();
                }
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void getServerToken(Activity activity, final Function1<? super String, Unit> callback) {
        GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(activity);
        Intrinsics.checkNotNullExpressionValue(gamesSignInClient, y.ݬֲ֮ܲت(1512551623));
        gamesSignInClient.requestServerSideAccess(serverClientId, false).addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.idp.GoogleGameAuth$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GoogleGameAuth.getServerToken$lambda$0(Function1.this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void getServerToken$lambda$0(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(function1, y.دײܮڳܯ(2051512901));
        Intrinsics.checkNotNullParameter(task, y.دײܮڳܯ(2051295277));
        if (task.isSuccessful()) {
            function1.invoke((String) task.getResult());
            INSTANCE.signInCompleted();
            return;
        }
        Exception exception = task.getException();
        Intrinsics.checkNotNull(exception, y.ٴسسݬߨ(1393465554));
        Log.d(y.֬ڱܱײٮ(-1158757407), y.ݬֲ֮ܲت(1512550575) + ((ApiException) exception).getStatusCode());
        function1.invoke(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void signInWithCallback(final Activity activity, final Function1<? super String, Unit> callback) {
        final GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(activity);
        Intrinsics.checkNotNullExpressionValue(gamesSignInClient, y.ݬֲ֮ܲت(1512551623));
        gamesSignInClient.isAuthenticated().addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.idp.GoogleGameAuth$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                GoogleGameAuth.signInWithCallback$lambda$2(activity, callback, gamesSignInClient, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void signInWithCallback$lambda$2(final Activity activity, final Function1 function1, GamesSignInClient gamesSignInClient, Task task) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(function1, y.دײܮڳܯ(2051512901));
        Intrinsics.checkNotNullParameter(gamesSignInClient, y.دײܮڳܯ(2051511869));
        Intrinsics.checkNotNullParameter(task, y.ٲٴݴ״ٰ(1782284576));
        boolean z = task.isSuccessful() && ((AuthenticationResult) task.getResult()).isAuthenticated();
        String str = y.֬ڱܱײٮ(-1158757407);
        if (z) {
            Log.d(str, "isAuthenticated : true");
            INSTANCE.getServerToken(activity, function1);
        } else {
            Log.d(str, "isAuthenticated : false");
            gamesSignInClient.signIn().addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.idp.GoogleGameAuth$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task2) {
                    GoogleGameAuth.signInWithCallback$lambda$2$lambda$1(activity, function1, task2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void signInWithCallback$lambda$2$lambda$1(Activity activity, Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(function1, y.دײܮڳܯ(2051512901));
        Intrinsics.checkNotNullParameter(task, y.ݬֲ֮ܲت(1512554359));
        boolean isSuccessful = task.isSuccessful();
        String str = y.֬ڱܱײٮ(-1158757407);
        if (isSuccessful) {
            Log.d(str, y.٬ݯح׭٩(576541054) + task.getResult());
            INSTANCE.getServerToken(activity, function1);
        } else {
            Exception exception = task.getException();
            Intrinsics.checkNotNull(exception, "null cannot be cast to non-null type com.google.android.gms.common.api.ApiException");
            Log.d(str, y.ݬֲ֮ܲت(1512550575) + ((ApiException) exception).getStatusCode());
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object signIn(Activity activity, Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        INSTANCE.signInWithCallback(activity, new Function1<String, Unit>() { // from class: com.kakaogame.idp.GoogleGameAuth$signIn$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Continuation<String> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(str));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> manualLogin(Activity activity, boolean isBackgroundLogin) {
        Object runBlocking$default;
        KGResult<String> successResult;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393466298);
        String str2 = y.֬ڱܱײٮ(-1158757407);
        logger.m699d(str2, str);
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new GoogleGameAuth$manualLogin$1(activity, null), 1, null);
            String str3 = (String) runBlocking$default;
            return (str3 == null || (successResult = KGResult.INSTANCE.getSuccessResult(str3)) == null) ? KGResult.INSTANCE.getResult(4010) : successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> autoLogin(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628444396);
        String str2 = y.֬ڱܱײٮ(-1158757407);
        logger.m699d(str2, str);
        try {
            GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(activity);
            Intrinsics.checkNotNullExpressionValue(gamesSignInClient, "getGamesSignInClient(...)");
            gamesSignInClient.isAuthenticated().addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.idp.GoogleGameAuth$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    GoogleGameAuth.autoLogin$lambda$5(task);
                }
            });
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void autoLogin$lambda$5(Task task) {
        Intrinsics.checkNotNullParameter(task, y.ٲٴݴ״ٰ(1782284576));
        boolean z = task.isSuccessful() && ((AuthenticationResult) task.getResult()).isAuthenticated();
        String str = y.֬ڱܱײٮ(-1158757407);
        if (z) {
            Log.d(str, "isAuthenticated : true");
            INSTANCE.signInCompleted();
        } else {
            Log.d(str, "isAuthenticated : false");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> logout() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051683317);
        String str2 = y.֬ڱܱײٮ(-1158757407);
        logger.m699d(str2, str);
        try {
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void signInCompleted() {
        isSignIn = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isConnected() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1158757407), y.٬ݯح׭٩(576541102));
        return isSignIn;
    }
}
