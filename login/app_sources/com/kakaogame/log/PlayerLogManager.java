package com.kakaogame.log;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.kakaogame.KGObject;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.TimerManager;
import com.kakaogame.manager.LogThreadPoolManager;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlayerLogManager.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003$%&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\b\u0010\u001e\u001a\u00020\u0016H\u0007J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020 H\u0007J\u001a\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m839d2 = {"Lcom/kakaogame/log/PlayerLogManager;", "", "()V", "KEY_COHORT1", "", "KEY_COHORT2", "KEY_COHORT3", "KEY_COHORT4", "KEY_COHORT5", "KEY_GRADE", "KEY_PLAYER_LEVEL", "LOCK", "TAG", "logDataList", "", "Lcom/kakaogame/log/PlayerLogManager$SummaryLogData;", "playerGameDataLogMap", "", "playerGameDataMap", "timer", "Lcom/kakaogame/core/TimerManager;", "addSummaryLog", "", "category", "action", Constants.ScionAnalytics.PARAM_LABEL, "value", "", "getPlayerGameData", "key", "initialize", "setPlayerGameData", "", "writePlayerGameData", "playerId", "writeSummaryLog", "PrefManager", "Settings", "SummaryLogData", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PlayerLogManager {
    public static final String KEY_COHORT1 = "cohort1";
    public static final String KEY_COHORT2 = "cohort2";
    public static final String KEY_COHORT3 = "cohort3";
    public static final String KEY_COHORT4 = "cohort4";
    public static final String KEY_COHORT5 = "cohort5";
    public static final String KEY_GRADE = "grade";
    public static final String KEY_PLAYER_LEVEL = "playerLv";
    private static final String TAG = "PlayerLogManager";
    private static TimerManager timer;
    public static final PlayerLogManager INSTANCE = new PlayerLogManager();
    private static final Object LOCK = new Object();
    private static final Map<String, Object> playerGameDataMap = new LinkedHashMap();
    private static final Map<String, Object> playerGameDataLogMap = new LinkedHashMap();
    private static final List<SummaryLogData> logDataList = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PlayerLogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new PlayerLogManager$initialize$1());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setPlayerGameData(String key, int value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512496655), y.٬ݯح׭٩(576457078) + key + y.ݮڮֲڭܩ(-628756788) + value);
        try {
            String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
            if (TextUtils.isEmpty(playerId)) {
                Logger.INSTANCE.m708w(TAG, "player id is null");
                return;
            }
            Map<String, ? extends Object> map = playerGameDataLogMap;
            synchronized (map) {
                playerGameDataMap.put(key, Integer.valueOf(value));
                map.put(key, Integer.valueOf(value));
                PrefManager.INSTANCE.savePlayerGameData(CoreManager.INSTANCE.getInstance().getContext(), playerId, map);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512496655), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setPlayerGameData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512496655), y.٬ݯح׭٩(576457078) + key + y.ݮڮֲڭܩ(-628756788) + value);
        try {
            String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
            if (TextUtils.isEmpty(playerId)) {
                Logger.INSTANCE.m708w(TAG, "player id is null");
                return;
            }
            Map<String, ? extends Object> map = playerGameDataLogMap;
            synchronized (map) {
                if (value != null) {
                    playerGameDataMap.put(key, value);
                    map.put(key, value);
                } else {
                    playerGameDataMap.remove(key);
                    map.remove(key);
                }
                PrefManager.INSTANCE.savePlayerGameData(CoreManager.INSTANCE.getInstance().getContext(), playerId, map);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512496655), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object getPlayerGameData(String key) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512496655), y.دײܮڳܯ(2051460845) + key);
        return playerGameDataMap.get(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void writePlayerGameData(final String playerId) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862692571) + playerId;
        String str2 = y.ݬֲ֮ܲت(1512496655);
        logger.m706v(str2, str);
        if (TextUtils.isEmpty(playerId)) {
            Logger.INSTANCE.m708w(str2, y.ٴسسݬߨ(1393544954));
        } else {
            LogThreadPoolManager.INSTANCE.run(new Runnable() { // from class: com.kakaogame.log.PlayerLogManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerLogManager.writePlayerGameData$lambda$3(playerId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void writePlayerGameData$lambda$3(String str) {
        String str2 = y.ٲٴݴ״ٰ(1782239272);
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576708326));
        Map<String, Object> map = playerGameDataLogMap;
        synchronized (map) {
            if (map.isEmpty()) {
                Logger.INSTANCE.m706v(TAG, "playerGameDataMap is empty");
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("playerId", str);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(map);
            CoreManager.INSTANCE.getInstance().getContext();
            KGResult<String> requestOpenApi = OpenApiService.requestOpenApi(Settings.INSTANCE.getUpdatePlayerGameDataOpenAPIUri(), linkedHashMap, linkedHashMap2);
            Logger.INSTANCE.m699d(TAG, str2 + requestOpenApi);
            if (requestOpenApi.isSuccess()) {
                map.clear();
                PrefManager.INSTANCE.clearPlayerGameData(CoreManager.INSTANCE.getInstance().getContext(), str);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void addSummaryLog(String category, String action, String label, long value) {
        SummaryLogData summaryLogData;
        Intrinsics.checkNotNullParameter(category, y.ۮڭڭܬި(862689795));
        Intrinsics.checkNotNullParameter(action, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(label, y.ٲٴݴ״ٰ(1782016584));
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512496655), y.ݬֲ֮ܲت(1512499087) + category + y.ݮڮֲڭܩ(-628756788) + action + y.ݮڮֲڭܩ(-628756788) + label + y.ݮڮֲڭܩ(-628756788) + value);
        try {
            String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
            if (TextUtils.isEmpty(playerId)) {
                Logger.INSTANCE.m708w(TAG, "player id is null");
                return;
            }
            List<SummaryLogData> list = logDataList;
            synchronized (list) {
                Iterator<SummaryLogData> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        summaryLogData = null;
                        break;
                    } else {
                        summaryLogData = it.next();
                        if (summaryLogData.equals(category, action, label)) {
                            break;
                        }
                    }
                }
                if (summaryLogData == null) {
                    summaryLogData = new SummaryLogData(category, action, label);
                    logDataList.add(summaryLogData);
                }
                summaryLogData.setValue(value);
                PrefManager.INSTANCE.saveSummayrLogs(CoreManager.INSTANCE.getInstance().getContext(), playerId, logDataList);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void writeSummaryLog(final String playerId) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782241040) + playerId;
        String str2 = y.ݬֲ֮ܲت(1512496655);
        logger.m699d(str2, str);
        if (TextUtils.isEmpty(playerId)) {
            Logger.INSTANCE.m708w(str2, y.ٴسسݬߨ(1393544954));
        } else {
            LogThreadPoolManager.INSTANCE.run(new Runnable() { // from class: com.kakaogame.log.PlayerLogManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerLogManager.writeSummaryLog$lambda$6(playerId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void writeSummaryLog$lambda$6(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576708326));
        List<SummaryLogData> list = logDataList;
        synchronized (list) {
            if (list.isEmpty()) {
                Logger.INSTANCE.m706v(TAG, "logDataList is empty");
                return;
            }
            for (SummaryLogData summaryLogData : new ArrayList(list)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("playerId", str);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Map<String, Object> object = summaryLogData.getObject();
                Intrinsics.checkNotNull(object);
                linkedHashMap2.putAll(object);
                Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
                Intrinsics.checkNotNull(configuration);
                linkedHashMap2.put("market", configuration.getMarket());
                linkedHashMap2.put("lang", KGSystem.getLanguageCode());
                linkedHashMap2.put("country", KGSystem.getCountryCode());
                Map<String, Object> map = playerGameDataMap;
                if (map.containsKey(KEY_GRADE)) {
                    linkedHashMap2.put(KEY_GRADE, map.get(KEY_GRADE));
                }
                if (map.containsKey(KEY_PLAYER_LEVEL)) {
                    linkedHashMap2.put(KEY_PLAYER_LEVEL, map.get(KEY_PLAYER_LEVEL));
                }
                CoreManager.INSTANCE.getInstance().getContext();
                KGResult<String> requestOpenApi = OpenApiService.requestOpenApi(Settings.INSTANCE.getWriteSummaryLogOpenAPIUri(), linkedHashMap, linkedHashMap2);
                Logger.INSTANCE.m699d(TAG, "writeSummaryLog result : " + requestOpenApi);
                if (requestOpenApi.isSuccess()) {
                    List<SummaryLogData> list2 = logDataList;
                    list2.remove(summaryLogData);
                    Context context = CoreManager.INSTANCE.getInstance().getContext();
                    if (list2.isEmpty()) {
                        PrefManager.INSTANCE.clearSummaryLogs(context, str);
                    } else {
                        PrefManager.INSTANCE.saveSummayrLogs(context, str, list2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerLogManager.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006B\u001d\b\u0016\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/log/PlayerLogManager$SummaryLogData;", "Lcom/kakaogame/KGObject;", SummaryLogData.KEY_CATEGORY, "", "action", "label", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "map", "", "", "(Ljava/util/Map;)V", "equals", "", "setValue", "", "value", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class SummaryLogData extends KGObject {
        private static final String KEY_ACTION = "action";
        private static final String KEY_CATEGORY = "category";
        private static final String KEY_COUNT = "count";
        private static final String KEY_LABEL = "label";
        private static final String KEY_MAX = "max";
        private static final String KEY_MIN = "min";
        private static final String KEY_MOD_TIME = "modTime";
        private static final String KEY_SUM = "sum";
        private static final long serialVersionUID = 4632271269086954934L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SummaryLogData(String str, String str2, String str3) {
            super(null, 1, null);
            String str4 = y.ۮڭڭܬި(862689795);
            Intrinsics.checkNotNullParameter(str, str4);
            String str5 = y.֬ڱܱײٮ(-1159583711);
            Intrinsics.checkNotNullParameter(str2, str5);
            String str6 = y.ٲٴݴ״ٰ(1782016584);
            Intrinsics.checkNotNullParameter(str3, str6);
            put(str4, str);
            put(str5, str2);
            put(str6, str3);
            put("count", 0L);
            put(KEY_SUM, 0L);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SummaryLogData(Map<String, Object> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, y.ݮڮֲڭܩ(-628373548));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final synchronized void setValue(long value) {
            long j;
            Object obj = get("count");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            put("count", Long.valueOf(((Long) obj).longValue() + 1));
            Object obj2 = get(KEY_SUM);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            put(KEY_SUM, Long.valueOf(((Long) obj2).longValue() + value));
            if (containsKey(KEY_MAX)) {
                Long l = (Long) get(KEY_MAX);
                Intrinsics.checkNotNull(l);
                j = Math.max(l.longValue(), value);
            } else {
                j = value;
            }
            put(KEY_MAX, Long.valueOf(j));
            if (containsKey("min")) {
                Long l2 = (Long) get("min");
                Intrinsics.checkNotNull(l2);
                value = Math.min(l2.longValue(), value);
            }
            put("min", Long.valueOf(value));
            put(KEY_MOD_TIME, Long.valueOf(CoreManager.INSTANCE.getInstance().currentTimeMillis()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean equals(String category, String action, String label) {
            String str = y.ۮڭڭܬި(862689795);
            Intrinsics.checkNotNullParameter(category, str);
            String str2 = y.֬ڱܱײٮ(-1159583711);
            Intrinsics.checkNotNullParameter(action, str2);
            if (Intrinsics.areEqual(category, get(str)) && Intrinsics.areEqual(action, get(str2))) {
                return get("label") == null ? label == null : Intrinsics.areEqual(label, get("label"));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerLogManager.kt */
    @Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J&\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/log/PlayerLogManager$PrefManager;", "", "()V", "PLAYER_DATA_NAME", "", "SUMMARY_LOG_NAME", "clearPlayerGameData", "", "context", "Landroid/content/Context;", "playerId", "clearSummaryLogs", "loadPlayerGameData", "", "loadSummaryLogs", "", "Lcom/kakaogame/log/PlayerLogManager$SummaryLogData;", "savePlayerGameData", "data", "saveSummayrLogs", com.kakao.sdk.template.Constants.TYPE_LIST, "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class PrefManager {
        public static final PrefManager INSTANCE = new PrefManager();
        private static final String PLAYER_DATA_NAME = "PlayerGameData";
        private static final String SUMMARY_LOG_NAME = "LoggerBucket.Summary";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PrefManager() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void savePlayerGameData(Context context, String playerId, Map<String, ? extends Object> data) {
            String str = y.ݬֲ֮ܲت(1512496655);
            String str2 = y.ݮڮֲڭܩ(-628374380);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            Intrinsics.checkNotNullParameter(data, y.دײܮڳܯ(2051550101));
            try {
                String jSONString = JSONValue.toJSONString(data);
                Logger.INSTANCE.m699d(str, str2 + playerId + " : " + data);
                PreferenceUtil.setString(context, PLAYER_DATA_NAME, playerId, jSONString);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> loadPlayerGameData(Context context, String playerId) {
            String str = y.ݬֲ֮ܲت(1512496655);
            String str2 = y.ۮڭڭܬި(862690891);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            try {
                String string = PreferenceUtil.getString(context, PLAYER_DATA_NAME, playerId, null);
                Logger.INSTANCE.m699d(str, str2 + playerId + " : " + string);
                if (string == null) {
                    return null;
                }
                Object parse = JSONValue.parse(string);
                Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                return (Map) parse;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clearPlayerGameData(Context context, String playerId) {
            String str = y.ݬֲ֮ܲت(1512496655);
            String str2 = y.ٲٴݴ״ٰ(1782245680);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            try {
                Logger.INSTANCE.m699d(str, str2 + playerId);
                PreferenceUtil.removeKey(context, PLAYER_DATA_NAME, playerId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void saveSummayrLogs(Context context, String playerId, List<SummaryLogData> list) {
            String str = y.ݬֲ֮ܲت(1512496655);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            Intrinsics.checkNotNullParameter(list, y.ݮڮֲڭܩ(-628374236));
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<SummaryLogData> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.add(it.next().toJSONString());
                }
                String jSONString = jSONArray.toJSONString();
                Logger.INSTANCE.m699d(str, "saveSummayrLogs: " + playerId + " : " + jSONString);
                PreferenceUtil.setString(context, SUMMARY_LOG_NAME, playerId, jSONString);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<SummaryLogData> loadSummaryLogs(Context context, String playerId) {
            String str = y.ݬֲ֮ܲت(1512496655);
            String str2 = y.٬ݯح׭٩(576467998);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            try {
                String string = PreferenceUtil.getString(context, SUMMARY_LOG_NAME, playerId, null);
                Logger.INSTANCE.m699d(str, str2 + playerId + " : " + string);
                if (string == null) {
                    return null;
                }
                Object parse = JSONValue.parse(string);
                Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONArray");
                JSONArray jSONArray = (JSONArray) parse;
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    Object parse2 = JSONValue.parse((String) jSONArray.get(i));
                    Intrinsics.checkNotNull(parse2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll((Map) parse2);
                    arrayList.add(new SummaryLogData(linkedHashMap));
                }
                return arrayList;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clearSummaryLogs(Context context, String playerId) {
            String str = y.ݬֲ֮ܲت(1512496655);
            String str2 = y.ٴسسݬߨ(1393555074);
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            try {
                Logger.INSTANCE.m699d(str, str2 + playerId);
                PreferenceUtil.removeKey(context, SUMMARY_LOG_NAME, playerId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
            }
        }
    }

    /* compiled from: PlayerLogManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/log/PlayerLogManager$Settings;", "", "()V", "updatePlayerGameDataOpenAPIUri", "", "getUpdatePlayerGameDataOpenAPIUri", "()Ljava/lang/String;", "setUpdatePlayerGameDataOpenAPIUri", "(Ljava/lang/String;)V", "writeSummaryLogOpenAPIUri", "getWriteSummaryLogOpenAPIUri", "setWriteSummaryLogOpenAPIUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String writeSummaryLogOpenAPIUri = y.ݮڮֲڭܩ(-628374028);
        private static String updatePlayerGameDataOpenAPIUri = y.٬ݯح׭٩(576468566);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteSummaryLogOpenAPIUri() {
            return writeSummaryLogOpenAPIUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteSummaryLogOpenAPIUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeSummaryLogOpenAPIUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getUpdatePlayerGameDataOpenAPIUri() {
            return updatePlayerGameDataOpenAPIUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setUpdatePlayerGameDataOpenAPIUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            updatePlayerGameDataOpenAPIUri = str;
        }
    }
}
