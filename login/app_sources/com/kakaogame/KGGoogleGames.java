package com.kakaogame;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.idp.GoogleGameAuth;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGGoogleGames.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007J\"\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0007J\u001a\u0010\u0012\u001a\u00020\n2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\u0005\u0010\b¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/KGGoogleGames;", "", "()V", "TAG", "", "isLoggedIn", "", "isLoggedIn$annotations", "()Z", "initInterfaceBroker", "", "initialize", FirebaseAnalytics.Event.LOGIN, "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "logout", "idp_googlegame_v2_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGGoogleGames {
    public static final KGGoogleGames INSTANCE = new KGGoogleGames();
    private static final String TAG = "KGGoogleGames";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isLoggedIn$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGGoogleGames() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512584807), y.ٲٴݴ״ٰ(1781793120));
        INSTANCE.initInterfaceBroker();
        KGGoogleGamesAchievements.initialize();
        KGGoogleGamesLeaderboards.initialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void login(Activity activity, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (!isLoggedIn()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGGoogleGames$login$1(activity, callback, null), 3, null);
        } else if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getSuccessResult());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void logout(KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGGoogleGames$logout$1(callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isLoggedIn() {
        try {
            return GoogleGameAuth.INSTANCE.isConnected();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512584807), e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575850358), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGames$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult<String> manualLogin = GoogleGameAuth.manualLogin(activity, false);
                if (manualLogin.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(manualLogin);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159642847), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGames$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<Void> logout = GoogleGameAuth.logout();
                if (logout.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(logout);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628807508), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGGoogleGames$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                boolean isLoggedIn = KGGoogleGames.isLoggedIn();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575850198), Boolean.valueOf(isLoggedIn));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
