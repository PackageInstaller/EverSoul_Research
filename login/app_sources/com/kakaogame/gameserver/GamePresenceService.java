package com.kakaogame.gameserver;

import android.content.Context;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.TimerManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GamePresenceService.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0007J\b\u0010\u0011\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/gameserver/GamePresenceService;", "", "()V", "DEFAULT_PING_INTERVAL", "", "TAG", "", "lock", "pingTask", "Ljava/lang/Runnable;", "pingTimer", "Lcom/kakaogame/core/TimerManager;", "sendPing", "", "context", "Landroid/content/Context;", "startPing", "stopPing", "HeartBeatTask", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GamePresenceService {
    private static final long DEFAULT_PING_INTERVAL = 120000;
    private static final String TAG = "GamePresenceService";
    private static TimerManager pingTimer;
    public static final GamePresenceService INSTANCE = new GamePresenceService();
    private static final Object lock = new Object();
    private static final Runnable pingTask = new HeartBeatTask();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GamePresenceService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void startPing() {
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051517165), y.دײܮڳܯ(2051516853));
        synchronized (lock) {
            if (pingTimer != null) {
                return;
            }
            TimerManager timerManager = new TimerManager(pingTask, 0L, DEFAULT_PING_INTERVAL);
            pingTimer = timerManager;
            Intrinsics.checkNotNull(timerManager);
            timerManager.startTimer();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void stopPing() {
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051517165), y.ٲٴݴ״ٰ(1782299400));
        synchronized (lock) {
            TimerManager timerManager = pingTimer;
            if (timerManager != null) {
                Intrinsics.checkNotNull(timerManager);
                timerManager.stopTimer();
                pingTimer = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendPing(Context context) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628450028);
        String str2 = y.دײܮڳܯ(2051517165);
        logger.m699d(str2, str);
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            Logger.INSTANCE.m699d(str2, y.٬ݯح׭٩(576548350));
            stopPing();
        } else if (CoreManager.INSTANCE.getInstance().isPaused()) {
            Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628449588));
            stopPing();
        } else {
            if (!GameSessionService.INSTANCE.isConnected()) {
                GameSessionService.INSTANCE.requestConnect(context);
            }
            GameSessionService.INSTANCE.ping();
            Logger.INSTANCE.m699d(str2, y.دײܮڳܯ(2051516733));
        }
    }

    /* compiled from: GamePresenceService.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/gameserver/GamePresenceService$HeartBeatTask;", "Ljava/lang/Runnable;", "()V", "run", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class HeartBeatTask implements Runnable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                GamePresenceService.INSTANCE.sendPing(CoreManager.INSTANCE.getInstance().getContext());
            } catch (Exception e) {
                Logger.INSTANCE.m700d(y.دײܮڳܯ(2051517165), e.toString(), e);
            }
        }
    }
}
