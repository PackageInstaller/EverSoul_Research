package com.kakaogame;

import android.app.Activity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGSession;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.session.SessionService;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: KGSession.kt */
@Metadata(m838d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003567B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J*\u0010 \u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\u0010\u0019\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010\u000f\u0018\u00010\u001aH\u0007J$\u0010\"\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J$\u0010#\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J$\u0010$\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0007J`\u0010(\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*0)2\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*2\u0006\u0010.\u001a\u00020/H\u0002Jj\u0010(\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*2\u0006\u0010.\u001a\u00020/2\u001e\u0010\u0019\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010*\u0018\u00010\u001aH\u0007J$\u00100\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J$\u00101\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J.\u00101\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u00102\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J$\u00103\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001aH\u0007J\u0012\u00104\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\n\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, m839d2 = {"Lcom/kakaogame/KGSession;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "accessToken", "getAccessToken$annotations", "getAccessToken", "()Ljava/lang/String;", "isLoggedIn", "", "isLoggedIn$annotations", "()Z", "marketRefundInfoList", "", "Lcom/kakaogame/KGMarketRefundInfo;", "getMarketRefundInfoList", "()Ljava/util/List;", "onlinePushManager", "Lcom/kakaogame/KGSession$OnlinePushManager;", "connect", "", "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "initInterfaceBroker", "initModule", "invokeInitialize", "className", "loadAppInfos", "Lcom/kakaogame/KGSession$KGAppInfo;", FirebaseAnalytics.Event.LOGIN, "logout", "pause", "registerOnlineNotificationListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/KGSession$KGOnlineNotificationListener;", "request", "Lcom/kakaogame/KGResult;", "", "uri", KeyBaseResult.KEY_HEADER, SDKConstants.PARAM_A2U_BODY, "timeout", "", "resume", "start", "appId", "unregister", "unregisterOnlineNotificationListener", "KGAppInfo", "KGOnlineNotificationListener", "OnlinePushManager", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSession {
    private static final String CLASS_NAME_KEY = "KGSession";
    public static final KGSession INSTANCE;
    private static final String TAG = "KGSession";
    private static final OnlinePushManager onlinePushManager;

    /* compiled from: KGSession.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005H&¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGSession$KGOnlineNotificationListener;", "", "onMessage", "", "message", "", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface KGOnlineNotificationListener {
        void onMessage(Map<String, ? extends Object> message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getAccessToken$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isLoggedIn$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGSession() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        KGSession kGSession = new KGSession();
        INSTANCE = kGSession;
        OnlinePushManager onlinePushManager2 = new OnlinePushManager();
        onlinePushManager = onlinePushManager2;
        kGSession.initModule();
        kGSession.initInterfaceBroker();
        SessionService.addOnlinePushListener(onlinePushManager2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isLoggedIn() {
        try {
            return CoreManager.INSTANCE.getInstance().isAuthorized();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1392718866), e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getAccessToken() {
        return CoreManager.INSTANCE.getInstance().getAccessToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void start(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575722822);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.دײܮڳܯ(2051675085));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$start$1(activity, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void start(Activity activity, String appId, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862419459) + appId;
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.دײܮڳܯ(2051675085));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$start$2(activity, appId, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadAppInfos(Activity activity, KGResultCallback<List<KGAppInfo>> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781932000);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.دײܮڳܯ(2051670789));
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݬֲ֮ܲت(1512712831));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$loadAppInfos$1(activity, firebaseTrace, callback, null), 3, null);
            return;
        }
        KGResult<List<KGAppInfo>> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void resume(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392710010);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str3 = y.ٲٴݴ״ٰ(1781928728);
        FirebaseEvent firebaseTrace = companion.getFirebaseTrace(str2, str3);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݬֲ֮ܲت(1512712831));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$resume$1(activity, firebaseTrace, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
        firebaseTrace.setTraceResult(result);
        FirebaseEvent.INSTANCE.sendEvent(str2, str3, result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void pause(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159510671);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݮڮֲڭܩ(-628675388));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$pause$1(callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
        FirebaseEvent.INSTANCE.sendEvent(str2, y.دײܮڳܯ(2051682333), result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void login(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512712447);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.֬ڱܱײٮ(-1159504239));
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ݮڮֲڭܩ(-628672588));
        }
        if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$login$1(activity, firebaseTrace, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.ݮڮֲڭܩ(-628676340));
        if (callback != null) {
            callback.onResult(result);
        }
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void connect(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392709242);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, y.ݮڮֲڭܩ(-628671956));
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.٬ݯح׭٩(575720182));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$connect$1(activity, firebaseTrace, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
        firebaseTrace.setTraceResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void logout(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862418763);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.֬ڱܱײٮ(-1159511055));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$logout$1(activity, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void unregister(Activity activity, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575723454);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.ٲٴݴ״ٰ(1781927144));
        }
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$unregister$1(activity, callback, null), 3, null);
            return;
        }
        KGResult<Void> result = KGResult.INSTANCE.getResult(4000, y.֬ڱܱײٮ(-1159506575));
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void request(String uri, Map<String, ? extends Object> header, Map<String, ? extends Object> body, long timeout, KGResultCallback<Map<String, Object>> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781926352);
        String str2 = y.ٴسسݬߨ(1392718866);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m708w(str2, y.֬ڱܱײٮ(-1159509471));
        }
        if (uri != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSession$request$1(uri, header, body, timeout, callback, null), 3, null);
            return;
        }
        KGResult<Map<String, Object>> result = KGResult.INSTANCE.getResult(4000, y.ݬֲ֮ܲت(1512717119));
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Map<String, Object>> request(String uri, Map<String, ? extends Object> header, Map<String, ? extends Object> body, long timeout) {
        KGResult<Map<String, Object>> result;
        String str = y.ۮڭڭܬި(862420123);
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ٴسسݬߨ(1393014090)).append(uri);
        String str2 = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str2).append(header).append(str2).append(body).append(str2).append(timeout).toString();
        String str3 = y.ٴسسݬߨ(1392718866);
        logger.m699d(str3, sb);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ݬֲ֮ܲت(1512717751));
        try {
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                result = KGResult.INSTANCE.getResult(3002);
            } else if (uri == null) {
                result = KGResult.INSTANCE.getResult(4000, "uri is null");
            } else {
                ServerRequest serverRequest = new ServerRequest(uri);
                if (header != null) {
                    serverRequest.putAllHeader(header);
                }
                if (body != null) {
                    serverRequest.putAllBody(body);
                }
                Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
                Intrinsics.checkNotNull(configuration);
                serverRequest.putBody("appId", configuration.getAppId());
                serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
                if (timeout > 0) {
                    serverRequest.setTimeout(timeout);
                }
                ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
                Logger.INSTANCE.m699d(str3, str + requestServer$default);
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            result = KGResult.INSTANCE.getResult(4001, e.toString());
        }
        start.stop();
        KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
        return result;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<KGMarketRefundInfo> getMarketRefundInfoList() {
        return CoreManager.INSTANCE.getInstance().getMarketRefundInfoList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void registerOnlineNotificationListener(KGOnlineNotificationListener listener) {
        Logger.INSTANCE.m704i(y.ٴسسݬߨ(1392718866), y.ݬֲ֮ܲت(1512714647) + listener);
        if (listener == null) {
            Logger.INSTANCE.m701e(y.ٴسسݬߨ(1392718866), y.ݮڮֲڭܩ(-628674788));
            return;
        }
        try {
            synchronized (OnlinePushManager.INSTANCE.getOnlinePushListeners()) {
                OnlinePushManager.INSTANCE.getOnlinePushListeners().add(listener);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1392718866), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void unregisterOnlineNotificationListener(KGOnlineNotificationListener listener) {
        Logger.INSTANCE.m704i(y.ٴسسݬߨ(1392718866), y.ۮڭڭܬި(862389419) + listener);
        if (listener == null) {
            Logger.INSTANCE.m701e(y.ٴسسݬߨ(1392718866), y.ݮڮֲڭܩ(-628674788));
            return;
        }
        try {
            synchronized (OnlinePushManager.INSTANCE.getOnlinePushListeners()) {
                OnlinePushManager.INSTANCE.getOnlinePushListeners().remove(listener);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1392718866), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initModule() {
        KGAppOption.INSTANCE.initialize();
        KGCoupon.INSTANCE.initialize();
        KGFriendLeaderboard.INSTANCE.initialize();
        KGLeaderboard.INSTANCE.initialize();
        KGLocalPlayer.INSTANCE.initialize();
        KGLog.INSTANCE.initialize();
        KGMessage.INSTANCE.initialize();
        KGPlayer.INSTANCE.initialize();
        KGPlayerGameData.INSTANCE.initialize();
        KGPromotion.INSTANCE.initialize();
        KGPush.INSTANCE.initialize();
        KGSupport.INSTANCE.initialize();
        KGIdpProfile.INSTANCE.initialize();
        KGInvitation.INSTANCE.initialize();
        KGSNSShare.INSTANCE.initialize();
        KGMarketRefundInfo.INSTANCE.initialize();
        invokeInitialize(y.ٲٴݴ״ٰ(1781929016));
        invokeInitialize(y.دײܮڳܯ(2051672461));
        invokeInitialize(y.٬ݯح׭٩(575717590));
        invokeInitialize(y.֬ڱܱײٮ(-1159505687));
        invokeInitialize(y.٬ݯح׭٩(575718182));
        invokeInitialize(y.֬ڱܱײٮ(-1159505167));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void invokeInitialize(String className) {
        String str = y.ٴسسݬߨ(1392718866);
        String str2 = y.ۮڭڭܬި(862415259);
        try {
            Class<?> cls = Class.forName(className);
            Logger.INSTANCE.m704i(str, str2 + cls.getName());
            Method method = cls.getMethod("initialize", new Class[0]);
            method.invoke(null, new Object[0]);
            Logger.INSTANCE.m704i(str, className + ClassUtils.PACKAGE_SEPARATOR_CHAR + method + " is invoked");
        } catch (Exception e) {
            Logger.INSTANCE.m709w(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781929952), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSession$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> request2;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("uri");
                Map map = (Map) request.getParameter(KeyBaseResult.KEY_HEADER);
                Map map2 = (Map) request.getParameter(SDKConstants.PARAM_A2U_BODY);
                Object parameter = request.getParameter("timeout");
                Intrinsics.checkNotNull(parameter, "null cannot be cast to non-null type kotlin.Long");
                request2 = KGSession.INSTANCE.request(str, map, map2, ((Long) parameter).longValue());
                if (!request2.isSuccess()) {
                    return request2;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Object content = request2.getContent();
                Intrinsics.checkNotNull(content);
                linkedHashMap.put(y.٬ݯح׭٩(575793966), content);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862412939), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSession$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGSession.OnlinePushManager onlinePushManager2;
                Map<String, Object> message;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                do {
                    onlinePushManager2 = KGSession.onlinePushManager;
                    message = onlinePushManager2.getMessage();
                } while (message == null);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.دײܮڳܯ(2051551053), message);
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KGSession.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002J*\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004H\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/KGSession$OnlinePushManager;", "Lcom/kakaogame/server/session/SessionService$OnlinePushListener;", "()V", "message", "", "", "", "getMessage", "()Ljava/util/Map;", "notifyMessage", "", "onMessage", "uri", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class OnlinePushManager implements SessionService.OnlinePushListener {
        private static final Condition condition;
        private static final ReentrantLock onlinePushListLock;
        private static final String onlinePushUri = "push://v2/online/onMessage";

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final List<Map<String, Object>> onlinePushList = new ArrayList();
        private static final Set<KGOnlineNotificationListener> onlinePushListeners = new LinkedHashSet();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.server.session.SessionService.OnlinePushListener
        public void onMessage(String uri, Map<String, ? extends Object> message) {
            try {
                if (StringsKt.equals(onlinePushUri, uri, true)) {
                    HashMap hashMap = new HashMap();
                    Intrinsics.checkNotNull(message);
                    hashMap.putAll(message);
                    notifyMessage(hashMap);
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ٴسسݬߨ(1392718866), e.toString(), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getMessage() {
            List<Map<String, Object>> list;
            ReentrantLock reentrantLock = onlinePushListLock;
            reentrantLock.lock();
            while (true) {
                try {
                    list = onlinePushList;
                    if (!list.isEmpty()) {
                        break;
                    }
                    try {
                        Logger.INSTANCE.m699d("KGSession", "waitOnlinePushMessage");
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                }
                reentrantLock.unlock();
            }
            return list.isEmpty() ^ true ? list.remove(0) : null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void notifyMessage(Map<String, ? extends Object> message) {
            Logger.INSTANCE.m699d(y.ٴسسݬߨ(1392718866), y.ۮڭڭܬި(862412603) + message);
            ReentrantLock reentrantLock = onlinePushListLock;
            reentrantLock.lock();
            try {
                List<Map<String, Object>> list = onlinePushList;
                if (list.size() >= 100) {
                    list.remove(0);
                }
                list.add(message);
                condition.signalAll();
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                Set<KGOnlineNotificationListener> set = onlinePushListeners;
                synchronized (set) {
                    Iterator<KGOnlineNotificationListener> it = set.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().onMessage(message);
                        } catch (Exception e) {
                            Logger.INSTANCE.m702e("KGSession", e.toString(), e);
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* compiled from: KGSession.kt */
        @Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/KGSession$OnlinePushManager$Companion;", "", "()V", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "onlinePushList", "", "", "", "onlinePushListLock", "Ljava/util/concurrent/locks/ReentrantLock;", "onlinePushListeners", "", "Lcom/kakaogame/KGSession$KGOnlineNotificationListener;", "getOnlinePushListeners", "()Ljava/util/Set;", "onlinePushUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Set<KGOnlineNotificationListener> getOnlinePushListeners() {
                return OnlinePushManager.onlinePushListeners;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ReentrantLock reentrantLock = new ReentrantLock();
            onlinePushListLock = reentrantLock;
            condition = reentrantLock.newCondition();
        }
    }

    /* compiled from: KGSession.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/KGSession$KGAppInfo;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "appId", "getAppId", "()Ljava/lang/String;", KGAppInfo.KEY_DISPLAY_NAME, "getDisplayName", KGAppInfo.KEY_SERVICE_STATUS, "", "()Z", "getValue", "key", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGAppInfo extends KGObject {
        public static final String KEY_APP_ID = "appId";
        public static final String KEY_DISPLAY_NAME = "displayName";
        public static final String KEY_SERVICE_STATUS = "isServiceAvailable";

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGAppInfo(Map<String, Object> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, y.ٴسسݬߨ(1392530698));
            JSONObject jSONObject = (JSONObject) map.get(y.֬ڱܱײٮ(-1159501927));
            if (jSONObject != null) {
                putAll(jSONObject);
            }
            boolean z = true;
            String str = y.֬ڱܱײٮ(-1159501871);
            put(str, true);
            if (map.containsKey(y.֬ڱܱײٮ(-1159613431))) {
                Map<String, Object> object = getObject();
                Intrinsics.checkNotNull(object);
                List<InfodeskData.KGInfodeskNotice> notices = new InfodeskData(object).getNotices();
                if (notices != null) {
                    Logger.INSTANCE.m699d(y.ٴسسݬߨ(1392718866), y.ۮڭڭܬި(862409403) + notices.size());
                    List<InfodeskData.KGInfodeskNotice> list = notices;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            } else if (Intrinsics.areEqual(((InfodeskData.KGInfodeskNotice) it.next()).get(y.ٴسسݬߨ(1392719098)), y.ݮڮֲڭܩ(-628686508))) {
                                z = false;
                                break;
                            }
                        }
                    }
                    put(str, Boolean.valueOf(z));
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getAppId() {
            String str = y.ۮڭڭܬި(862411867);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDisplayName() {
            String str = y.٬ݯح׭٩(575730070);
            return containsKey(str) ? (String) get(str) : "";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isServiceAvailable() {
            String str = y.֬ڱܱײٮ(-1159501871);
            if (!containsKey(str)) {
                return true;
            }
            Object obj = get(str);
            Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
            return ((Boolean) obj).booleanValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.KGObject
        public String getValue(String key) {
            Object obj = get(key);
            return (obj != null && (obj instanceof String)) ? (String) obj : "";
        }
    }
}
