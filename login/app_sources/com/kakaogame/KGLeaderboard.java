package com.kakaogame;

import android.app.Activity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.sdk.user.Constants;
import com.kakaogame.KGLeaderboard;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.leaderboard.LeaderboardService;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGLeaderboard.kt */
@Metadata(m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004%&'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J6\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J3\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0006\u0010\u0012\u001a\u00020\u0007J$\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\fH\u0007J.\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\fH\u0007J4\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\fH\u0007J>\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\fH\u0007J$\u0010\u001a\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\fH\u0007J.\u0010\u001a\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\fH\u0007J,\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J4\u0010\u001c\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\fH\u0007J>\u0010\u001c\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\fH\u0007JE\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001dJ,\u0010\u001e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J6\u0010\u001e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J3\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010\u0010J4\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0018\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010!H\u0002J>\u0010\u001f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0018\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010!2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J4\u0010\u001f\u001a\u00020\u00072\u0018\u0010 \u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010!2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J.\u0010\"\u001a\u00020\u00072\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J8\u0010\"\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "accumulateScore", "", "leaderboardId", "score", "", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", ServerConstants.SUB_KEY, "Lcom/kakaogame/KGResult;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/kakaogame/KGResult;", "initInterfaceBroker", "initialize", "loadLastSeasonMyRanking", "Lcom/kakaogame/KGLeaderboard$KGMyRankingResponse;", "loadLastSeasonRankings", "beginRank", "", "endRank", "Lcom/kakaogame/KGLeaderboard$KGRankingResponse;", "loadMyRanking", "seqNo", "loadRankings", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;)Lcom/kakaogame/KGResult;", "reportScore", "saveRankingProperties", Constants.PROPERTIES, "", "saveRankingProperty", "key", "value", "KGMyRankingResponse", "KGRankingInfo", "KGRankingResponse", "KGRankingSortOrder", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGLeaderboard {
    private static final String CLASS_NAME_KEY = "KGLeaderboard";
    public static final KGLeaderboard INSTANCE = new KGLeaderboard();
    private static final String TAG = "KGLeaderboard";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGLeaderboard() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void reportScore(String leaderboardId, long score, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$reportScore$1(leaderboardId, score, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void accumulateScore(String leaderboardId, long score, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$accumulateScore$1(leaderboardId, score, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadMyRanking(String leaderboardId, KGResultCallback<KGMyRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadMyRanking$1(leaderboardId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonMyRanking(String leaderboardId, KGResultCallback<KGMyRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadLastSeasonMyRanking$1(leaderboardId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadRankings(String leaderboardId, int beginRank, int endRank, KGResultCallback<KGRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadRankings$1(leaderboardId, beginRank, endRank, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonRankings(String leaderboardId, int beginRank, int endRank, KGResultCallback<KGRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadLastSeasonRankings$1(leaderboardId, beginRank, endRank, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveRankingProperty(String key, Object value, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$saveRankingProperty$1(key, value, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveRankingProperties(Map<String, ? extends Object> properties, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$saveRankingProperties$1(properties, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void reportScore(String leaderboardId, String subkey, long score, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$reportScore$2(leaderboardId, subkey, score, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void accumulateScore(String leaderboardId, String subkey, long score, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$accumulateScore$2(leaderboardId, subkey, score, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadMyRanking(String leaderboardId, String subkey, KGResultCallback<KGMyRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadMyRanking$2(leaderboardId, subkey, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonMyRanking(String leaderboardId, String subkey, KGResultCallback<KGMyRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadLastSeasonMyRanking$2(leaderboardId, subkey, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadRankings(String leaderboardId, String subkey, int beginRank, int endRank, KGResultCallback<KGRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadRankings$2(leaderboardId, subkey, beginRank, endRank, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonRankings(String leaderboardId, String subkey, int beginRank, int endRank, KGResultCallback<KGRankingResponse> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$loadLastSeasonRankings$2(leaderboardId, subkey, beginRank, endRank, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveRankingProperty(String subkey, String key, Object value, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$saveRankingProperty$2(key, value, subkey, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void saveRankingProperties(String subkey, Map<String, ? extends Object> properties, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLeaderboard$saveRankingProperties$2(subkey, properties, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> reportScore(String leaderboardId, String subkey, Long score) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ݮڮֲڭܩ(-628742444)).append(leaderboardId);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(subkey).append(str).append(score).toString();
        String str2 = y.֬ڱܱײٮ(-1159572759);
        logger.m699d(str2, sb);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String str3 = leaderboardId;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, "leaderboardId is null");
        }
        if (score == null) {
            return KGResult.INSTANCE.getResult(4000, "score is null");
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575788750));
        try {
            try {
                KGResult<Void> reportScore = LeaderboardService.reportScore(leaderboardId, subkey, score.longValue());
                result = reportScore.isNotSuccess() ? KGResult.INSTANCE.getResult(reportScore) : KGResult.INSTANCE.getSuccessResult();
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> accumulateScore(String leaderboardId, String subkey, Long score) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159577255)).append(leaderboardId);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(subkey).append(str).append(score).toString();
        String str2 = y.֬ڱܱײٮ(-1159572759);
        logger.m699d(str2, sb);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String str3 = leaderboardId;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862281739) + leaderboardId);
        }
        if (score == null) {
            return KGResult.INSTANCE.getResult(4000, "score is null");
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.ݮڮֲڭܩ(-628741972));
        try {
            try {
                KGResult<Void> accumulateScore = LeaderboardService.accumulateScore(leaderboardId, subkey, score.longValue());
                result = accumulateScore.isNotSuccess() ? KGResult.INSTANCE.getResult(accumulateScore) : KGResult.INSTANCE.getSuccessResult();
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGMyRankingResponse> loadMyRanking(String leaderboardId, String subkey, int seqNo) {
        KGResult<KGMyRankingResponse> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575787910) + leaderboardId + y.ݮڮֲڭܩ(-628756788) + subkey;
        String str2 = y.֬ڱܱײٮ(-1159572759);
        logger.m699d(str2, str);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String str3 = leaderboardId;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862281739) + leaderboardId);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575788046));
        try {
            try {
                KGResult<JSONObject> rank = LeaderboardService.getRank(leaderboardId, subkey, seqNo);
                if (rank.isNotSuccess()) {
                    result = KGResult.INSTANCE.getResult(rank);
                } else {
                    JSONObject content = rank.getContent();
                    if (content == null) {
                        KGResult<KGMyRankingResponse> result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                        start.stop();
                        KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                        return result2;
                    }
                    result = KGResult.INSTANCE.getSuccessResult(new KGMyRankingResponse(content, subkey));
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGRankingResponse> loadRankings(String leaderboardId, String subkey, int seqNo, Integer beginRank, Integer endRank) {
        KGResult<KGRankingResponse> result;
        String name;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1159574503)).append(leaderboardId);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(beginRank).append(str).append(endRank).toString();
        String str2 = y.֬ڱܱײٮ(-1159572759);
        logger.m699d(str2, sb);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String str3 = leaderboardId;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, "leaderboardId is null: " + leaderboardId);
        }
        if (beginRank == null) {
            return KGResult.INSTANCE.getResult(4000, "beginRank is null");
        }
        if (endRank == null) {
            return KGResult.INSTANCE.getResult(4000, "endRank is null");
        }
        if (beginRank.intValue() < 1) {
            return KGResult.INSTANCE.getResult(4000, "beginRank < 1: " + beginRank);
        }
        if (beginRank.intValue() > endRank.intValue()) {
            return KGResult.INSTANCE.getResult(4000, "beginRank > endRank: " + beginRank);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575788438));
        try {
            try {
                KGResult<JSONObject> rankedScores = LeaderboardService.getRankedScores(leaderboardId, seqNo, beginRank.intValue(), endRank.intValue());
                if (rankedScores.isNotSuccess()) {
                    result = KGResult.INSTANCE.getResult(rankedScores);
                } else {
                    JSONObject content = rankedScores.getContent();
                    if (content == null) {
                        KGResult<KGRankingResponse> result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                        start.stop();
                        KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                        return result2;
                    }
                    result = KGResult.INSTANCE.getSuccessResult(new KGRankingResponse(content, subkey));
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> saveRankingProperties(String subkey, Map<String, ? extends Object> properties) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512781903) + properties;
        String str2 = y.֬ڱܱײٮ(-1159572759);
        logger.m699d(str2, str);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        if (properties == null) {
            return KGResult.INSTANCE.getResult(4000, y.ݬֲ֮ܲت(1512785671));
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575777038));
        try {
            try {
                KGResult<Void> putProperty = LeaderboardService.putProperty(subkey, properties);
                result = putProperty.isNotSuccess() ? KGResult.INSTANCE.getResult(putProperty) : KGResult.INSTANCE.getSuccessResult();
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512781423), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> reportScore;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                Number number = (Number) request.getParameter(y.ٴسسݬߨ(1392578978));
                Long valueOf = number != null ? Long.valueOf(number.longValue()) : null;
                String str2 = y.ٲٴݴ״ٰ(1781995032);
                String str3 = request.containsParameterKey(str2) ? (String) request.getParameter(str2) : null;
                reportScore = KGLeaderboard.INSTANCE.reportScore(str, str3, valueOf);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.ݮڮֲڭܩ(-628736572).concat(str3 != null ? y.٬ݯح׭٩(575786366) : ""), reportScore);
                return reportScore;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051742861), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> accumulateScore;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                Number number = (Number) request.getParameter(y.ٴسسݬߨ(1392578978));
                Long valueOf = number != null ? Long.valueOf(number.longValue()) : null;
                String str2 = y.ٲٴݴ״ٰ(1781995032);
                String str3 = request.containsParameterKey(str2) ? (String) request.getParameter(str2) : null;
                accumulateScore = KGLeaderboard.INSTANCE.accumulateScore(str, str3, valueOf);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.ٴسسݬߨ(1392643858).concat(str3 != null ? y.٬ݯح׭٩(575786366) : ""), accumulateScore);
                return accumulateScore;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051742293), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadMyRanking;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                String str2 = y.ٲٴݴ״ٰ(1781995032);
                String str3 = request.containsParameterKey(str2) ? (String) request.getParameter(str2) : null;
                loadMyRanking = KGLeaderboard.INSTANCE.loadMyRanking(str, str3, 0);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.֬ڱܱײٮ(-1159572287).concat(str3 != null ? "_subkey" : ""), loadMyRanking);
                if (loadMyRanking.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadMyRanking);
                }
                Object content = loadMyRanking.getContent();
                Intrinsics.checkNotNull(content);
                KGLeaderboard.KGMyRankingResponse kGMyRankingResponse = (KGLeaderboard.KGMyRankingResponse) content;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                KGLeaderboard.KGRankingInfo rankingInfo = kGMyRankingResponse.getRankingInfo();
                rankingInfo.put(y.٬ݯح׭٩(575863886), rankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                linkedHashMap.put(y.ۮڭڭܬި(862348099), rankingInfo);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGMyRankingResponse.getTotalPlayerCount()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGMyRankingResponse.getSeasonSeq()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781990952), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadMyRanking;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                String str2 = y.ٲٴݴ״ٰ(1781995032);
                String str3 = request.containsParameterKey(str2) ? (String) request.getParameter(str2) : null;
                loadMyRanking = KGLeaderboard.INSTANCE.loadMyRanking(str, str3, -1);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.ٲٴݴ״ٰ(1781994952).concat(str3 != null ? "_subkey" : ""), loadMyRanking);
                if (loadMyRanking.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadMyRanking);
                }
                KGLeaderboard.KGMyRankingResponse kGMyRankingResponse = (KGLeaderboard.KGMyRankingResponse) loadMyRanking.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGMyRankingResponse);
                KGLeaderboard.KGRankingInfo rankingInfo = kGMyRankingResponse.getRankingInfo();
                rankingInfo.put(y.٬ݯح׭٩(575863886), rankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                linkedHashMap.put(y.ۮڭڭܬި(862348099), rankingInfo);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGMyRankingResponse.getTotalPlayerCount()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGMyRankingResponse.getSeasonSeq()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575790742), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                Number number = (Number) request.getParameter("beginRank");
                Integer valueOf = number != null ? Integer.valueOf(number.intValue()) : null;
                Number number2 = (Number) request.getParameter("endRank");
                Integer valueOf2 = number2 != null ? Integer.valueOf(number2.intValue()) : null;
                String str2 = request.containsParameterKey(ServerConstants.SUB_KEY) ? (String) request.getParameter(ServerConstants.SUB_KEY) : null;
                loadRankings = KGLeaderboard.INSTANCE.loadRankings(str, str2, 0, valueOf, valueOf2);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.ݬֲ֮ܲت(1512775743).concat(str2 != null ? "_subkey" : ""), loadRankings);
                if (loadRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadRankings);
                }
                Object content = loadRankings.getContent();
                Intrinsics.checkNotNull(content);
                KGLeaderboard.KGRankingResponse kGRankingResponse = (KGLeaderboard.KGRankingResponse) content;
                List<KGLeaderboard.KGRankingInfo> rankingInfos = kGRankingResponse.getRankingInfos();
                for (KGLeaderboard.KGRankingInfo kGRankingInfo : rankingInfos) {
                    kGRankingInfo.put(y.٬ݯح׭٩(575863886), kGRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to(y.ٴسسݬߨ(1392641098), rankingInfos), TuplesKt.m846to(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGRankingResponse.getTotalPlayerCount())), TuplesKt.m846to("seasonSeq", Integer.valueOf(kGRankingResponse.getSeasonSeq()))));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628740124), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("leaderboardId");
                Number number = (Number) request.getParameter("beginRank");
                Integer valueOf = number != null ? Integer.valueOf(number.intValue()) : null;
                Number number2 = (Number) request.getParameter("endRank");
                Integer valueOf2 = number2 != null ? Integer.valueOf(number2.intValue()) : null;
                String str2 = request.containsParameterKey(ServerConstants.SUB_KEY) ? (String) request.getParameter(ServerConstants.SUB_KEY) : null;
                loadRankings = KGLeaderboard.INSTANCE.loadRankings(str, str2, -1, valueOf, valueOf2);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.دײܮڳܯ(2051737333).concat(str2 != null ? "_subkey" : ""), loadRankings);
                if (loadRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadRankings);
                }
                Object content = loadRankings.getContent();
                Intrinsics.checkNotNull(content);
                KGLeaderboard.KGRankingResponse kGRankingResponse = (KGLeaderboard.KGRankingResponse) content;
                List<KGLeaderboard.KGRankingInfo> rankingInfos = kGRankingResponse.getRankingInfos();
                for (KGLeaderboard.KGRankingInfo kGRankingInfo : rankingInfos) {
                    kGRankingInfo.put(y.٬ݯح׭٩(575863886), kGRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to(y.ٴسسݬߨ(1392641098), rankingInfos), TuplesKt.m846to(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGRankingResponse.getTotalPlayerCount())), TuplesKt.m846to("seasonSeq", Integer.valueOf(kGRankingResponse.getSeasonSeq()))));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628743868), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> saveRankingProperties;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("key");
                Object parameter = request.getParameter(y.ݬֲ֮ܲت(1512942783));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(str, parameter);
                String str2 = request.containsParameterKey(ServerConstants.SUB_KEY) ? (String) request.getParameter(ServerConstants.SUB_KEY) : null;
                saveRankingProperties = KGLeaderboard.INSTANCE.saveRankingProperties(str2, (Map<String, ? extends Object>) linkedHashMap);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.֬ڱܱײٮ(-1159571335).concat(str2 != null ? "_subkey" : ""), saveRankingProperties);
                if (saveRankingProperties.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(saveRankingProperties);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781991752), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLeaderboard$initInterfaceBroker$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> saveRankingProperties;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                Map map = (Map) request.getParameter(Constants.PROPERTIES);
                String str = y.ٲٴݴ״ٰ(1781995032);
                String str2 = request.containsParameterKey(str) ? (String) request.getParameter(str) : null;
                saveRankingProperties = KGLeaderboard.INSTANCE.saveRankingProperties(str2, (Map<String, ? extends Object>) map);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.֬ڱܱײٮ(-1159571247).concat(str2 != null ? "_subkey" : ""), saveRankingProperties);
                if (saveRankingProperties.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(saveRankingProperties);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "", "(Ljava/lang/String;I)V", "ASCENDING", "DESCENDING", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGRankingSortOrder {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGRankingSortOrder[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final KGRankingSortOrder ASCENDING = new KGRankingSortOrder(y.ݮڮֲڭܩ(-628737340), 0);
        public static final KGRankingSortOrder DESCENDING = new KGRankingSortOrder(y.ٴسسݬߨ(1392643762), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGRankingSortOrder[] $values() {
            return new KGRankingSortOrder[]{ASCENDING, DESCENDING};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGRankingSortOrder> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGRankingSortOrder valueOf(String str) {
            return (KGRankingSortOrder) Enum.valueOf(KGRankingSortOrder.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGRankingSortOrder[] values() {
            return (KGRankingSortOrder[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGRankingSortOrder(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGRankingSortOrder[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGLeaderboard.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder$Companion;", "", "()V", "fromString", "Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "value", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGRankingSortOrder fromString(String value) {
                if (StringsKt.equals(y.ݬֲ֮ܲت(1512777207), value, true)) {
                    return KGRankingSortOrder.ASCENDING;
                }
                return KGRankingSortOrder.DESCENDING;
            }
        }
    }

    /* compiled from: KGLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "Lcom/kakaogame/KGObject;", "object", "Lcom/kakaogame/util/json/JSONObject;", ServerConstants.SUB_KEY, "", "(Lcom/kakaogame/util/json/JSONObject;Ljava/lang/String;)V", "isLocalPlayer", "", "()Z", "getObject", "()Lcom/kakaogame/util/json/JSONObject;", "playerId", "getPlayerId", "()Ljava/lang/String;", "rank", "", "getRank", "()I", "rankingProperties", "", "", "getRankingProperties", "()Ljava/util/Map;", "score", "", "getScore", "()J", "setRanking", "", "ranking", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static class KGRankingInfo extends KGObject {
        private static final long serialVersionUID = 1467238404010843548L;
        private final JSONObject object;
        private String subkey;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGRankingInfo(JSONObject jSONObject, String str) {
            super(jSONObject);
            this.object = jSONObject;
            this.subkey = "";
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            this.subkey = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.KGObject
        public JSONObject getObject() {
            return this.object;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPlayerId() {
            return JSONUtil.getString(getObject(), y.ݬֲ֮ܲت(1512589743), "");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getRank() {
            return JSONUtil.getInt(getObject(), y.ٲٴݴ״ٰ(1781994184), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getScore() {
            return JSONUtil.getInt(getObject(), y.ٴسسݬߨ(1392578978), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getRankingProperties() {
            JSONObject jSONObject = (JSONObject) get(y.دײܮڳܯ(2051899941));
            if (jSONObject != null) {
                JSONObject jSONObject2 = jSONObject;
                ArrayList arrayList = new ArrayList(jSONObject2.size());
                for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                    arrayList.add(TuplesKt.m846to(entry.getKey(), entry.getValue()));
                }
                Map<String, Object> map = MapsKt.toMap(arrayList);
                if (map != null) {
                    return map;
                }
            }
            return new HashMap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isLocalPlayer() {
            return StringsKt.equals(getPlayerId(), this.subkey.length() == 0 ? CoreManager.INSTANCE.getInstance().getPlayerId() : CoreManager.INSTANCE.getInstance() + y.֬ڱܱײٮ(-1159572687) + this.subkey, true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRanking(int ranking) {
            Integer valueOf = Integer.valueOf(ranking);
            JSONObject object = getObject();
            Intrinsics.checkNotNull(object);
            object.put(y.ٲٴݴ״ٰ(1781994184), valueOf);
        }
    }

    /* compiled from: KGLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGMyRankingResponse;", "", "object", "Lcom/kakaogame/util/json/JSONObject;", ServerConstants.SUB_KEY, "", "(Lcom/kakaogame/util/json/JSONObject;Ljava/lang/String;)V", "rankingInfo", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "getRankingInfo", "()Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "seasonSeq", "", "getSeasonSeq", "()I", "totalPlayerCount", "getTotalPlayerCount", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGMyRankingResponse {
        private final JSONObject object;
        private final String subkey;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGMyRankingResponse(JSONObject jSONObject, String str) {
            Intrinsics.checkNotNullParameter(jSONObject, y.ٲٴݴ״ٰ(1781808624));
            this.object = jSONObject;
            this.subkey = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGRankingInfo getRankingInfo() {
            return new KGRankingInfo(this.object, this.subkey);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalPlayerCount() {
            return JSONUtil.getInt(this.object, y.ۮڭڭܬި(862279163), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getSeasonSeq() {
            return JSONUtil.getInt(this.object, y.ݬֲ֮ܲت(1512576919), 0);
        }
    }

    /* compiled from: KGLeaderboard.kt */
    @Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGRankingResponse;", "", "object", "Lcom/kakaogame/util/json/JSONObject;", ServerConstants.SUB_KEY, "", "(Lcom/kakaogame/util/json/JSONObject;Ljava/lang/String;)V", "rankingInfos", "", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "seasonSeq", "", "getSeasonSeq", "()I", SDKConstants.PARAM_SORT_ORDER, "Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "getSortOrder", "()Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "totalPlayerCount", "getTotalPlayerCount", "getRankingInfos", "RankingComparator", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGRankingResponse {
        private final JSONObject object;
        private List<? extends KGRankingInfo> rankingInfos;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGRankingResponse(JSONObject jSONObject, String str) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(jSONObject, y.ٲٴݴ״ٰ(1781808624));
            this.object = jSONObject;
            JSONArray jSONArray = (JSONArray) jSONObject.get((Object) y.ٲٴݴ״ٰ(1781808232));
            if (jSONArray != null) {
                JSONArray jSONArray2 = jSONArray;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray2, 10));
                Iterator<Object> it = jSONArray2.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new KGRankingInfo((JSONObject) it.next(), str));
                }
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList();
            }
            this.rankingInfos = arrayList;
            Collections.sort(arrayList, new RankingComparator());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGRankingInfo> getRankingInfos() {
            return this.rankingInfos;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalPlayerCount() {
            return JSONUtil.getInt(this.object, y.ۮڭڭܬި(862279163), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getSeasonSeq() {
            return JSONUtil.getInt(this.object, y.ݬֲ֮ܲت(1512576919), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGRankingSortOrder getSortOrder() {
            return KGRankingSortOrder.INSTANCE.fromString(JSONUtil.getString(this.object, y.٬ݯح׭٩(575862870), ""));
        }

        /* compiled from: KGLeaderboard.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/KGLeaderboard$KGRankingResponse$RankingComparator;", "Ljava/util/Comparator;", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "(Lcom/kakaogame/KGLeaderboard$KGRankingResponse;)V", "compare", "", "lhs", "rhs", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public final class RankingComparator implements Comparator<KGRankingInfo> {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public RankingComparator() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.Comparator
            public int compare(KGRankingInfo lhs, KGRankingInfo rhs) {
                Intrinsics.checkNotNullParameter(lhs, y.ٲٴݴ״ٰ(1781808512));
                Intrinsics.checkNotNullParameter(rhs, y.ۮڭڭܬި(862276491));
                if (rhs.getRank() != 0 && lhs.getRank() >= rhs.getRank()) {
                    return lhs.getRank() == rhs.getRank() ? 0 : 1;
                }
                return -1;
            }
        }
    }
}
