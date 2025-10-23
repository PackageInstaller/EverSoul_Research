package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGFriendLeaderboard;
import com.kakaogame.KGLeaderboard;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.leaderboard.LeaderboardService;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONUtil;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGFriendLeaderboard.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J$\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J4\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J4\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fH\u0007J2\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000e2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J.\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00072\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/KGFriendLeaderboard;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "initInterfaceBroker", "", "initialize", "loadFriendRankings", "leaderboardId", "callback", "Lcom/kakaogame/KGResultCallback;", "Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingResponse;", "Lcom/kakaogame/KGResult;", "seasonSequence", "", "loadLastSeasonFriendRankings", "loadLastSeasonPlayersRankings", "playerIds", "", "loadPlayersRankings", "idList", "loadPlayersRankingsImpl", "setRankings", "rankingInfos", "Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingInfo;", "ascending", "", "KGFriendRankingInfo", "KGFriendRankingResponse", "ScoreComparator", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGFriendLeaderboard {
    private static final String CLASS_NAME_KEY = "KGFriendLeaderboard";
    public static final KGFriendLeaderboard INSTANCE = new KGFriendLeaderboard();
    private static final String TAG = "KGFriendLeaderboard";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGFriendLeaderboard() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadFriendRankings(String leaderboardId, KGResultCallback<KGFriendRankingResponse> callback) {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512576175), y.ٲٴݴ״ٰ(1781797968) + leaderboardId);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFriendLeaderboard$loadFriendRankings$1(leaderboardId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonFriendRankings(String leaderboardId, KGResultCallback<KGFriendRankingResponse> callback) {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512576175), y.ݮڮֲڭܩ(-628805548) + leaderboardId);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFriendLeaderboard$loadLastSeasonFriendRankings$1(leaderboardId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadPlayersRankings(List<String> playerIds, String leaderboardId, KGResultCallback<KGFriendRankingResponse> callback) {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512576175), y.ۮڭڭܬި(862285523) + leaderboardId + y.ٲٴݴ״ٰ(1781799224) + playerIds);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFriendLeaderboard$loadPlayersRankings$1(playerIds, leaderboardId, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadLastSeasonPlayersRankings(List<String> playerIds, String leaderboardId, KGResultCallback<KGFriendRankingResponse> callback) {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512576175), y.ٲٴݴ״ٰ(1781799424) + leaderboardId + y.ٲٴݴ״ٰ(1781799224) + playerIds);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFriendLeaderboard$loadLastSeasonPlayersRankings$1(playerIds, leaderboardId, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGFriendRankingResponse> loadFriendRankings(String leaderboardId, int seasonSequence) {
        KGResult<KGFriendRankingResponse> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1781798808) + leaderboardId;
        String str2 = y.ݬֲ֮ܲت(1512576175);
        logger.m699d(str2, str);
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (TextUtils.isEmpty(leaderboardId)) {
            return KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862281739) + leaderboardId);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.ݬֲ֮ܲت(1512579487));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<KGFriendRankingResponse> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (currentPlayer == null) {
                KGResult<KGFriendRankingResponse> result3 = KGResult.INSTANCE.getResult(4002, "local player is null");
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result3, start.getDurationMs());
                return result3;
            }
            KGResult<List<KGPlayer>> loadFriendPlayers = KGPlayer.INSTANCE.loadFriendPlayers();
            if (loadFriendPlayers.isNotSuccess()) {
                KGResult<KGFriendRankingResponse> result4 = KGResult.INSTANCE.getResult(loadFriendPlayers);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result4, start.getDurationMs());
                return result4;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<KGPlayer> content = loadFriendPlayers.getContent();
            Intrinsics.checkNotNull(content);
            for (KGPlayer kGPlayer : content) {
                linkedHashMap.put(kGPlayer.getPlayerId(), kGPlayer);
            }
            linkedHashMap.put(currentPlayer.getPlayerId(), currentPlayer);
            KGResult<JSONObject> scores = LeaderboardService.getScores(leaderboardId, seasonSequence, new ArrayList(linkedHashMap.keySet()));
            if (scores.isNotSuccess()) {
                KGResult<KGFriendRankingResponse> result5 = KGResult.INSTANCE.getResult(scores);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result5, start.getDurationMs());
                return result5;
            }
            JSONObject content2 = scores.getContent();
            if (content2 == null) {
                KGResult<KGFriendRankingResponse> result6 = KGResult.INSTANCE.getResult(2003, "content is null");
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result6, start.getDurationMs());
                return result6;
            }
            KGFriendRankingResponse kGFriendRankingResponse = new KGFriendRankingResponse(content2, linkedHashMap);
            setRankings(kGFriendRankingResponse.getRankingInfos(), kGFriendRankingResponse.getSortOrder$gamesdk_release() == KGLeaderboard.KGRankingSortOrder.ASCENDING);
            result = KGResult.INSTANCE.getSuccessResult(kGFriendRankingResponse);
            start.stop();
            name = start.getName();
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
    public final KGResult<KGFriendRankingResponse> loadPlayersRankings(List<String> idList, String leaderboardId, int seasonSequence) {
        ArrayList arrayList;
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512576175), y.ۮڭڭܬި(862285731) + idList + y.٬ݯح׭٩(575849342) + leaderboardId);
        if (idList != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : idList) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.leaderboard)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        String str = leaderboardId;
        if (str == null || str.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, y.ۮڭڭܬި(862281739) + leaderboardId);
        }
        if (arrayList == null) {
            return KGResult.INSTANCE.getResult(4000, "playerId list is null.");
        }
        return arrayList.isEmpty() ? KGResult.INSTANCE.getSuccessResult(new KGFriendRankingResponse()) : CoreManager.INSTANCE.getInstance().isNotAuthorized() ? KGResult.INSTANCE.getResult(3002) : KGLocalPlayer.INSTANCE.getCurrentPlayer() == null ? KGResult.INSTANCE.getResult(4002, "local player is null") : loadPlayersRankingsImpl(arrayList, leaderboardId, seasonSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<KGFriendRankingResponse> loadPlayersRankingsImpl(List<String> playerIds, String leaderboardId, int seasonSequence) {
        KGResult<KGFriendRankingResponse> result;
        String name;
        KGResult<Map<String, KGPlayer>> loadPlayers;
        KGResult<KGFriendRankingResponse> result2;
        Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051539677));
        try {
            try {
                loadPlayers = KGPlayer.INSTANCE.loadPlayers(playerIds);
            } catch (Exception e) {
                Logger.INSTANCE.m702e("KGFriendLeaderboard", e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (loadPlayers.isNotSuccess()) {
                result2 = KGResult.INSTANCE.getResult(loadPlayers);
            } else {
                Map<String, KGPlayer> content = loadPlayers.getContent();
                Intrinsics.checkNotNull(content);
                Map<String, KGPlayer> map = content;
                KGResult<JSONObject> scores = LeaderboardService.getScores(leaderboardId, seasonSequence, playerIds);
                if (scores.isNotSuccess()) {
                    result2 = KGResult.INSTANCE.getResult(scores);
                } else {
                    JSONObject content2 = scores.getContent();
                    if (content2 != null) {
                        KGFriendRankingResponse kGFriendRankingResponse = new KGFriendRankingResponse(content2, map);
                        setRankings(kGFriendRankingResponse.getRankingInfos(), kGFriendRankingResponse.getSortOrder$gamesdk_release() == KGLeaderboard.KGRankingSortOrder.ASCENDING);
                        result = KGResult.INSTANCE.getSuccessResult(kGFriendRankingResponse);
                        start.stop();
                        name = start.getName();
                        KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                        return result;
                    }
                    result2 = KGResult.INSTANCE.getResult(2003, "content is null");
                }
            }
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051551341), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFriendLeaderboard$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadFriendRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                loadFriendRankings = KGFriendLeaderboard.INSTANCE.loadFriendRankings((String) request.getParameter("leaderboardId"), 0);
                FirebaseEvent.INSTANCE.sendEvent(y.ݬֲ֮ܲت(1512576175), y.ٴسسݬߨ(1392590722), loadFriendRankings);
                if (loadFriendRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadFriendRankings);
                }
                KGFriendLeaderboard.KGFriendRankingResponse kGFriendRankingResponse = (KGFriendLeaderboard.KGFriendRankingResponse) loadFriendRankings.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGFriendRankingResponse);
                List<KGFriendLeaderboard.KGFriendRankingInfo> rankingInfos = kGFriendRankingResponse.getRankingInfos();
                Intrinsics.checkNotNull(rankingInfos);
                for (KGFriendLeaderboard.KGFriendRankingInfo kGFriendRankingInfo : rankingInfos) {
                    kGFriendRankingInfo.put(y.٬ݯح׭٩(575863886), kGFriendRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                linkedHashMap.put(y.֬ڱܱײٮ(-1159633879), rankingInfos);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGFriendRankingResponse.getTotalPlayerCount$gamesdk_release()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGFriendRankingResponse.getSeasonSeq$gamesdk_release()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051551741), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFriendLeaderboard$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadFriendRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                loadFriendRankings = KGFriendLeaderboard.INSTANCE.loadFriendRankings((String) request.getParameter("leaderboardId"), -1);
                FirebaseEvent.INSTANCE.sendEvent(y.ݬֲ֮ܲت(1512576175), y.֬ڱܱײٮ(-1159633031), loadFriendRankings);
                if (loadFriendRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadFriendRankings);
                }
                KGFriendLeaderboard.KGFriendRankingResponse kGFriendRankingResponse = (KGFriendLeaderboard.KGFriendRankingResponse) loadFriendRankings.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGFriendRankingResponse);
                List<KGFriendLeaderboard.KGFriendRankingInfo> rankingInfos = kGFriendRankingResponse.getRankingInfos();
                Intrinsics.checkNotNull(rankingInfos);
                for (KGFriendLeaderboard.KGFriendRankingInfo kGFriendRankingInfo : rankingInfos) {
                    kGFriendRankingInfo.put(y.٬ݯح׭٩(575863886), kGFriendRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                linkedHashMap.put(y.֬ڱܱײٮ(-1159633879), rankingInfos);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGFriendRankingResponse.getTotalPlayerCount$gamesdk_release()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGFriendRankingResponse.getSeasonSeq$gamesdk_release()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862282875), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFriendLeaderboard$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadPlayersRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                loadPlayersRankings = KGFriendLeaderboard.INSTANCE.loadPlayersRankings((List<String>) request.getParameter(y.֬ڱܱײٮ(-1159633399)), (String) request.getParameter("leaderboardId"), 0);
                FirebaseEvent.INSTANCE.sendEvent(y.ݬֲ֮ܲت(1512576175), y.֬ڱܱײٮ(-1159633231), loadPlayersRankings);
                if (loadPlayersRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadPlayersRankings);
                }
                KGFriendLeaderboard.KGFriendRankingResponse kGFriendRankingResponse = (KGFriendLeaderboard.KGFriendRankingResponse) loadPlayersRankings.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGFriendRankingResponse);
                List<KGFriendLeaderboard.KGFriendRankingInfo> rankingInfos = kGFriendRankingResponse.getRankingInfos();
                Intrinsics.checkNotNull(rankingInfos);
                for (KGFriendLeaderboard.KGFriendRankingInfo kGFriendRankingInfo : rankingInfos) {
                    kGFriendRankingInfo.put(y.٬ݯح׭٩(575863886), kGFriendRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                linkedHashMap.put(y.֬ڱܱײٮ(-1159633879), rankingInfos);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGFriendRankingResponse.getTotalPlayerCount$gamesdk_release()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGFriendRankingResponse.getSeasonSeq$gamesdk_release()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628802924), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFriendLeaderboard$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> loadPlayersRankings;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                loadPlayersRankings = KGFriendLeaderboard.INSTANCE.loadPlayersRankings((List<String>) request.getParameter(y.֬ڱܱײٮ(-1159633399)), (String) request.getParameter("leaderboardId"), -1);
                FirebaseEvent.INSTANCE.sendEvent(y.ݬֲ֮ܲت(1512576175), y.ݬֲ֮ܲت(1512578991), loadPlayersRankings);
                if (loadPlayersRankings.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadPlayersRankings);
                }
                KGFriendLeaderboard.KGFriendRankingResponse kGFriendRankingResponse = (KGFriendLeaderboard.KGFriendRankingResponse) loadPlayersRankings.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGFriendRankingResponse);
                List<KGFriendLeaderboard.KGFriendRankingInfo> rankingInfos = kGFriendRankingResponse.getRankingInfos();
                Intrinsics.checkNotNull(rankingInfos);
                for (KGFriendLeaderboard.KGFriendRankingInfo kGFriendRankingInfo : rankingInfos) {
                    kGFriendRankingInfo.put(y.٬ݯح׭٩(575863886), kGFriendRankingInfo.getValue(y.دײܮڳܯ(2051899941)));
                }
                linkedHashMap.put(y.֬ڱܱײٮ(-1159633879), rankingInfos);
                linkedHashMap.put(y.ݬֲ֮ܲت(1512575535), Integer.valueOf(kGFriendRankingResponse.getTotalPlayerCount$gamesdk_release()));
                linkedHashMap.put(y.ݬֲ֮ܲت(1512576919), Integer.valueOf(kGFriendRankingResponse.getSeasonSeq$gamesdk_release()));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setRankings(List<KGFriendRankingInfo> rankingInfos, boolean ascending) {
        Collections.sort(rankingInfos, new ScoreComparator(ascending));
        Intrinsics.checkNotNull(rankingInfos);
        int i = 1;
        KGFriendRankingInfo kGFriendRankingInfo = null;
        for (KGFriendRankingInfo kGFriendRankingInfo2 : rankingInfos) {
            if (kGFriendRankingInfo2.getScore() == 0) {
                kGFriendRankingInfo2.setRanking(0);
            } else {
                if (kGFriendRankingInfo == null) {
                    kGFriendRankingInfo2.setRanking(i);
                } else if (kGFriendRankingInfo.getScore() == kGFriendRankingInfo2.getScore()) {
                    kGFriendRankingInfo2.setRanking(kGFriendRankingInfo.getRank());
                } else {
                    kGFriendRankingInfo2.setRanking(i);
                }
                kGFriendRankingInfo = kGFriendRankingInfo2;
                i++;
            }
        }
    }

    /* compiled from: KGFriendLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0010¢\u0006\u0002\u0010\u0002B#\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingResponse;", "", "()V", "object", "Lcom/kakaogame/util/json/JSONObject;", "playerMap", "", "", "Lcom/kakaogame/KGPlayer;", "(Lcom/kakaogame/util/json/JSONObject;Ljava/util/Map;)V", "rankingInfos", "", "Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingInfo;", "seasonSeq", "", "getSeasonSeq$gamesdk_release", "()I", SDKConstants.PARAM_SORT_ORDER, "Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "getSortOrder$gamesdk_release", "()Lcom/kakaogame/KGLeaderboard$KGRankingSortOrder;", "totalPlayerCount", "getTotalPlayerCount$gamesdk_release", "getRankingInfos", "", "toString", "RankingComparator", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGFriendRankingResponse {
        private final JSONObject object;
        private final List<KGFriendRankingInfo> rankingInfos;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGFriendRankingResponse() {
            this.rankingInfos = new ArrayList();
            this.object = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGFriendRankingResponse(JSONObject jSONObject, Map<String, ? extends KGPlayer> map) {
            Intrinsics.checkNotNullParameter(jSONObject, y.ٲٴݴ״ٰ(1781808624));
            Intrinsics.checkNotNullParameter(map, y.ٲٴݴ״ٰ(1781808176));
            this.rankingInfos = new ArrayList();
            this.object = jSONObject;
            JSONArray jSONArray = (JSONArray) jSONObject.get((Object) y.ٲٴݴ״ٰ(1781808232));
            Intrinsics.checkNotNull(jSONArray);
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                KGFriendRankingInfo kGFriendRankingInfo = new KGFriendRankingInfo((JSONObject) jSONArray.get(i));
                KGPlayer kGPlayer = map.get(kGFriendRankingInfo.getPlayerId());
                if (kGPlayer != null) {
                    kGFriendRankingInfo.setPlayer(kGPlayer);
                    kGPlayer.put(y.ٲٴݴ״ٰ(1781808296), Boolean.valueOf(kGPlayer.isOnline()));
                }
                List<KGFriendRankingInfo> list = this.rankingInfos;
                Intrinsics.checkNotNull(list);
                list.add(kGFriendRankingInfo);
            }
            Collections.sort(this.rankingInfos, new RankingComparator());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGFriendRankingInfo> getRankingInfos() {
            return this.rankingInfos;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalPlayerCount$gamesdk_release() {
            JSONObject jSONObject = this.object;
            if (jSONObject == null) {
                return 0;
            }
            return JSONUtil.getInt(jSONObject, y.ۮڭڭܬި(862279163), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getSeasonSeq$gamesdk_release() {
            JSONObject jSONObject = this.object;
            if (jSONObject == null) {
                return 0;
            }
            return JSONUtil.getInt(jSONObject, y.ݬֲ֮ܲت(1512576919), 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGLeaderboard.KGRankingSortOrder getSortOrder$gamesdk_release() {
            return KGLeaderboard.KGRankingSortOrder.INSTANCE.fromString(JSONUtil.getString(this.object, y.٬ݯح׭٩(575862870), ""));
        }

        /* compiled from: KGFriendLeaderboard.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingResponse$RankingComparator;", "Ljava/util/Comparator;", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "(Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingResponse;)V", "compare", "", "lhs", "rhs", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public final class RankingComparator implements Comparator<KGLeaderboard.KGRankingInfo> {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public RankingComparator() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.Comparator
            public int compare(KGLeaderboard.KGRankingInfo lhs, KGLeaderboard.KGRankingInfo rhs) {
                Intrinsics.checkNotNullParameter(lhs, y.ٲٴݴ״ٰ(1781808512));
                Intrinsics.checkNotNullParameter(rhs, y.ۮڭڭܬި(862276491));
                if (rhs.getRank() != 0 && lhs.getRank() >= rhs.getRank()) {
                    return lhs.getRank() == rhs.getRank() ? 0 : 1;
                }
                return -1;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.object != null) {
                stringBuffer.append(y.ٴسسݬߨ(1392590186));
                stringBuffer.append(this.object.toString());
            } else {
                stringBuffer.append(y.ٲٴݴ״ٰ(1781801616));
            }
            if (this.rankingInfos != null) {
                stringBuffer.append(y.ۮڭڭܬި(862278851));
                stringBuffer.append(this.rankingInfos.toString());
            } else {
                stringBuffer.append(y.ٲٴݴ״ٰ(1781801360));
            }
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
            return stringBuffer2;
        }
    }

    /* compiled from: KGFriendLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/KGFriendLeaderboard$KGFriendRankingInfo;", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "object", "Lcom/kakaogame/util/json/JSONObject;", "(Lcom/kakaogame/util/json/JSONObject;)V", "player", "Lcom/kakaogame/KGPlayer;", "getPlayer", "()Lcom/kakaogame/KGPlayer;", "setPlayer", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGFriendRankingInfo extends KGLeaderboard.KGRankingInfo {
        private static final String KEY_PLAYER = "player";
        private static final long serialVersionUID = -8830246341546584528L;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGFriendRankingInfo(JSONObject jSONObject) {
            super(jSONObject, "");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPlayer(KGPlayer player) {
            String str = y.ۮڭڭܬި(862276451);
            Intrinsics.checkNotNullParameter(player, str);
            put(str, player);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGPlayer getPlayer() {
            return (KGPlayer) get(y.ۮڭڭܬި(862276451));
        }
    }

    /* compiled from: KGFriendLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGFriendLeaderboard$ScoreComparator;", "Ljava/util/Comparator;", "Lcom/kakaogame/KGLeaderboard$KGRankingInfo;", "ascending", "", "(Z)V", "compare", "", "lhs", "rhs", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class ScoreComparator implements Comparator<KGLeaderboard.KGRankingInfo> {
        private final boolean ascending;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ScoreComparator(boolean z) {
            this.ascending = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Comparator
        public int compare(KGLeaderboard.KGRankingInfo lhs, KGLeaderboard.KGRankingInfo rhs) {
            Intrinsics.checkNotNullParameter(lhs, y.ٲٴݴ״ٰ(1781808512));
            Intrinsics.checkNotNullParameter(rhs, y.ۮڭڭܬި(862276491));
            if (rhs.getScore() == 0) {
                return -1;
            }
            if (this.ascending) {
                if (lhs.getScore() < rhs.getScore()) {
                    return -1;
                }
            } else if (lhs.getScore() > rhs.getScore()) {
                return -1;
            }
            return 1;
        }
    }
}
