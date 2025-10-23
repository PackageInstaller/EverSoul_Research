package com.kakaogame.server;

import android.content.Context;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.TimerManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.openapi.OpenApiService;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PresenceService.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\rJ\b\u0010\u001c\u001a\u00020\u0016H\u0007J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/server/PresenceService;", "", "()V", "DEFAULT_HEART_BEAT_INTERVAL", "", "TAG", "", "heartBeatInterval", "heartBeatTask", "Ljava/lang/Runnable;", "heartBeatTimer", "Lcom/kakaogame/core/TimerManager;", "isReconnect", "", "isReconnect$annotations", "()Z", "setReconnect", "(Z)V", "lock", "sequenceId", "Ljava/util/concurrent/atomic/AtomicLong;", "initialize", "", "sendHeartBeat", "setHeartbeatInterval", "interval", "setHeartbeatUri", "useHeartbeat", "startHeartbeat", "stopHeartbeat", "HeartBeatTask", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PresenceService {
    private static final String TAG = "PresenceService";
    private static TimerManager heartBeatTimer;
    private static boolean isReconnect;
    private static AtomicLong sequenceId;
    public static final PresenceService INSTANCE = new PresenceService();
    private static final Object lock = new Object();
    private static final Runnable heartBeatTask = new HeartBeatTask();
    private static final long DEFAULT_HEART_BEAT_INTERVAL = 120000;
    private static long heartBeatInterval = DEFAULT_HEART_BEAT_INTERVAL;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isReconnect$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PresenceService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isReconnect() {
        return isReconnect;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setReconnect(boolean z) {
        isReconnect = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.server.PresenceService$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onConnect(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onUnregister(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                PresenceService.INSTANCE.stopHeartbeat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onPause() {
                PresenceService.INSTANCE.stopHeartbeat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogout(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                PresenceService.INSTANCE.stopHeartbeat();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogin(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                PresenceService.startHeartbeat();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setHeartbeatUri(boolean useHeartbeat) {
        Settings settings = Settings.INSTANCE;
        Settings.heartbeatUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628251316), useHeartbeat ? "v3/player/heartbeat" : OpenApiService.NOT_USED);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startHeartbeat() {
        String str = y.֬ڱܱײٮ(-1159089911);
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862845347), y.ݬֲ֮ܲت(1512097639));
        InfodeskHelper.ServerConnectionType serverConnectionType = InfodeskHelper.INSTANCE.getServerConnectionType();
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862845347), y.ٴسسݬߨ(1393159458) + serverConnectionType);
        if (serverConnectionType == null) {
            Logger.INSTANCE.m706v(y.ۮڭڭܬި(862845347), y.دײܮڳܯ(2051381581));
            return;
        }
        synchronized (lock) {
            if (!isReconnect) {
                if (heartBeatTimer != null) {
                    INSTANCE.stopHeartbeat();
                } else {
                    sequenceId = new AtomicLong(1L);
                }
                Logger.INSTANCE.m706v(TAG, str + heartBeatInterval);
                TimerManager timerManager = new TimerManager(heartBeatTask, 0L, heartBeatInterval);
                heartBeatTimer = timerManager;
                Intrinsics.checkNotNull(timerManager);
                timerManager.startTimer();
            } else {
                isReconnect = false;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setHeartbeatInterval(long interval) {
        if (interval > 0) {
            heartBeatInterval = interval;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopHeartbeat() {
        Logger.INSTANCE.m706v(y.ۮڭڭܬި(862845347), y.٬ݯح׭٩(576334350));
        synchronized (lock) {
            TimerManager timerManager = heartBeatTimer;
            if (timerManager != null) {
                timerManager.stopTimer();
            }
            heartBeatTimer = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendHeartBeat() {
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            stopHeartbeat();
            return;
        }
        InfodeskHelper.ServerConnectionType serverConnectionType = InfodeskHelper.INSTANCE.getServerConnectionType();
        InfodeskHelper.ServerConnectionType serverConnectionType2 = InfodeskHelper.ServerConnectionType.https;
        String str = y.ۮڭڭܬި(862845347);
        if (serverConnectionType == serverConnectionType2) {
            if (StringsKt.equals(y.ۮڭڭܬި(862845739), OpenApiService.INSTANCE.getOpenApiUri(Settings.heartbeatUri), true)) {
                Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512094207));
                return;
            }
        }
        Logger.INSTANCE.m699d(str, y.دײܮڳܯ(2051051885));
        ServerRequest serverRequest = new ServerRequest(Settings.heartbeatUri);
        AtomicLong atomicLong = sequenceId;
        Intrinsics.checkNotNull(atomicLong);
        serverRequest.putBody(y.دײܮڳܯ(2051707837), Long.valueOf(atomicLong.getAndIncrement()));
        serverRequest.putBody(y.ۮڭڭܬި(862411867), CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
        serverRequest.putBody(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
        serverRequest.putBody(y.ݮڮֲڭܩ(-628723908), KGSystem.getOSName());
        serverRequest.putBody(y.دײܮڳܯ(2051393733), KGSystem.getCountryCode());
        serverRequest.putBody(y.دײܮڳܯ(2051758173), CoreManager.INSTANCE.getInstance().getConfiguration().getMarket());
        serverRequest.putBody(y.ݮڮֲڭܩ(-628250684), Long.valueOf(heartBeatInterval));
        serverRequest.putBody(y.֬ڱܱײٮ(-1158899247), Long.valueOf(System.currentTimeMillis()));
        serverRequest.putAllBody(Settings.INSTANCE.getPresenceParamMap());
        ServerService.INSTANCE.requestServerWithoutResponse(serverRequest);
    }

    /* compiled from: PresenceService.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/server/PresenceService$HeartBeatTask;", "Ljava/lang/Runnable;", "()V", "run", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class HeartBeatTask implements Runnable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                Context context = CoreManager.INSTANCE.getInstance().getContext();
                PresenceService.INSTANCE.sendHeartBeat();
                AuthDataManager.INSTANCE.requestRefreshZAT(context);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862845347), e.toString(), e);
            }
        }
    }

    /* compiled from: PresenceService.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/server/PresenceService$Settings;", "", "()V", "heartbeatUri", "", "presenceParamMap", "", "getPresenceParamMap", "()Ljava/util/Map;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        public static String heartbeatUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628251316), y.ۮڭڭܬި(862845739));
        private static final Map<String, Object> presenceParamMap = new LinkedHashMap();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getPresenceParamMap() {
            return presenceParamMap;
        }
    }
}
