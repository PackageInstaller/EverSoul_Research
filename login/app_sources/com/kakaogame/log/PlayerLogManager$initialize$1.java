package com.kakaogame.log;

import android.content.Context;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.TimerManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.PlayerLogManager;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayerLogManager.kt */
@Metadata(m838d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, m839d2 = {"com/kakaogame/log/PlayerLogManager$initialize$1", "Lcom/kakaogame/core/CoreManager$CoreStateListener;", "onConnect", "", "playerId", "", "onLogin", "onLogout", "onPause", "onUnregister", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PlayerLogManager$initialize$1 implements CoreManager.CoreStateListener {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.core.CoreManager.CoreStateListener
    public void onConnect(String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PlayerLogManager$initialize$1() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.core.CoreManager.CoreStateListener
    public void onUnregister(String playerId) {
        Object obj;
        TimerManager timerManager;
        TimerManager timerManager2;
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        obj = PlayerLogManager.LOCK;
        synchronized (obj) {
            timerManager = PlayerLogManager.timer;
            if (timerManager != null) {
                timerManager2 = PlayerLogManager.timer;
                Intrinsics.checkNotNull(timerManager2);
                timerManager2.stopTimer();
                PlayerLogManager playerLogManager = PlayerLogManager.INSTANCE;
                PlayerLogManager.timer = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.core.CoreManager.CoreStateListener
    public void onPause() {
        Object obj;
        TimerManager timerManager;
        TimerManager timerManager2;
        obj = PlayerLogManager.LOCK;
        synchronized (obj) {
            timerManager = PlayerLogManager.timer;
            if (timerManager != null) {
                timerManager2 = PlayerLogManager.timer;
                Intrinsics.checkNotNull(timerManager2);
                timerManager2.stopTimer();
                PlayerLogManager playerLogManager = PlayerLogManager.INSTANCE;
                PlayerLogManager.timer = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.core.CoreManager.CoreStateListener
    public void onLogout(String playerId) {
        Object obj;
        TimerManager timerManager;
        TimerManager timerManager2;
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        obj = PlayerLogManager.LOCK;
        synchronized (obj) {
            timerManager = PlayerLogManager.timer;
            if (timerManager != null) {
                timerManager2 = PlayerLogManager.timer;
                Intrinsics.checkNotNull(timerManager2);
                timerManager2.stopTimer();
                PlayerLogManager playerLogManager = PlayerLogManager.INSTANCE;
                PlayerLogManager.timer = null;
            }
            PlayerLogManager.INSTANCE.writePlayerGameData(playerId);
            PlayerLogManager.INSTANCE.writeSummaryLog(playerId);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.core.CoreManager.CoreStateListener
    public void onLogin(final String playerId) {
        Object obj;
        Map map;
        List list;
        TimerManager timerManager;
        TimerManager timerManager2;
        List<PlayerLogManager.SummaryLogData> loadSummaryLogs;
        List list2;
        Map<String, Object> loadPlayerGameData;
        Map map2;
        Map map3;
        String str = y.ݬֲ֮ܲت(1512317487);
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        if (SDKVersion.isPublishing) {
            obj = PlayerLogManager.LOCK;
            synchronized (obj) {
                Context context = CoreManager.INSTANCE.getInstance().getContext();
                map = PlayerLogManager.playerGameDataLogMap;
                if (map.isEmpty() && (loadPlayerGameData = PlayerLogManager.PrefManager.INSTANCE.loadPlayerGameData(context, playerId)) != null) {
                    map2 = PlayerLogManager.playerGameDataMap;
                    map2.putAll(loadPlayerGameData);
                    map3 = PlayerLogManager.playerGameDataLogMap;
                    map3.putAll(loadPlayerGameData);
                }
                PlayerLogManager.INSTANCE.writePlayerGameData(playerId);
                list = PlayerLogManager.logDataList;
                if (list.isEmpty() && (loadSummaryLogs = PlayerLogManager.PrefManager.INSTANCE.loadSummaryLogs(context, playerId)) != null) {
                    list2 = PlayerLogManager.logDataList;
                    list2.addAll(loadSummaryLogs);
                }
                PlayerLogManager.INSTANCE.writeSummaryLog(playerId);
                timerManager = PlayerLogManager.timer;
                if (timerManager == null) {
                    long logInterval = InfodeskHelper.INSTANCE.getLogInterval();
                    Logger.INSTANCE.m699d("PlayerLogManager", str + logInterval);
                    Runnable runnable = new Runnable() { // from class: com.kakaogame.log.PlayerLogManager$initialize$1$$ExternalSyntheticLambda0
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            PlayerLogManager$initialize$1.onLogin$lambda$4$lambda$3(playerId);
                        }
                    };
                    PlayerLogManager playerLogManager = PlayerLogManager.INSTANCE;
                    PlayerLogManager.timer = new TimerManager(runnable, logInterval, logInterval);
                    timerManager2 = PlayerLogManager.timer;
                    Intrinsics.checkNotNull(timerManager2);
                    timerManager2.startTimer();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onLogin$lambda$4$lambda$3(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576708326));
        Logger.INSTANCE.m706v(y.ݬֲ֮ܲت(1512496655), y.֬ڱܱײٮ(-1158697327));
        PlayerLogManager.INSTANCE.writePlayerGameData(str);
        PlayerLogManager.INSTANCE.writeSummaryLog(str);
    }
}
