package com.kakaogame.leaderboard;

import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.player.PlayerService;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeaderboardService.kt */
@Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J,\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J2\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J4\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J4\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0018\u0010\u001e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001fH\u0007J,\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/leaderboard/LeaderboardService;", "", "()V", "CURRENT_SEASON_SEQUENCE", "", "KEY_LEADERBOARD_ID", "", "KEY_SEASON_SEQUENCE", "KEY_SUBKEY", "LAST_SEASON_SEQUENCE", "TAG", "accumulateScore", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", LeaderboardService.KEY_LEADERBOARD_ID, "subkey", "score", "", "getRank", "Lcom/kakaogame/util/json/JSONObject;", "sequenceNo", "getRankedScores", "fromRank", "toRank", "getScores", "playerIds", "", "initialize", "", "putProperty", PlayerService.FIELD_KEY_CUSTOM_PROPERTY, "", "reportScore", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LeaderboardService {
    public static final int CURRENT_SEASON_SEQUENCE = 0;
    public static final LeaderboardService INSTANCE = new LeaderboardService();
    private static final String KEY_LEADERBOARD_ID = "leaderboardId";
    private static final String KEY_SEASON_SEQUENCE = "seasonSeq";
    private static final String KEY_SUBKEY = "subkey";
    public static final int LAST_SEASON_SEQUENCE = -1;
    private static final String TAG = "LearderboardService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LeaderboardService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getRank(String leaderboardId, String subkey, int sequenceNo) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetRankUri());
            serverRequest.putBody(KEY_LEADERBOARD_ID, leaderboardId);
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(KEY_SEASON_SEQUENCE, Integer.valueOf(sequenceNo));
            if (!TextUtils.isEmpty(subkey)) {
                serverRequest.putBody("subkey", subkey);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getScores(String leaderboardId, int sequenceNo, List<String> playerIds) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetScoresUri());
            serverRequest.putBody(KEY_LEADERBOARD_ID, leaderboardId);
            serverRequest.putBody("playerIds", playerIds);
            serverRequest.putBody(KEY_SEASON_SEQUENCE, Integer.valueOf(sequenceNo));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getRankedScores(String leaderboardId, int sequenceNo, int fromRank, int toRank) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetRankedScoresUri());
            serverRequest.putBody(KEY_LEADERBOARD_ID, leaderboardId);
            serverRequest.putBody(KEY_SEASON_SEQUENCE, Integer.valueOf(sequenceNo));
            serverRequest.putBody("fromRank", Integer.valueOf(fromRank));
            serverRequest.putBody("toRank", Integer.valueOf(toRank));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> reportScore(String leaderboardId, String subkey, long score) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getReportScoreUri());
            serverRequest.putBody(KEY_LEADERBOARD_ID, leaderboardId);
            serverRequest.putBody("score", Long.valueOf(score));
            if (!TextUtils.isEmpty(subkey)) {
                serverRequest.putBody("subkey", subkey);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> putProperty(String subkey, Map<String, ? extends Object> customProperty) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getPutPropertyUri());
            serverRequest.putBody("property", customProperty);
            if (!TextUtils.isEmpty(subkey)) {
                serverRequest.putBody("subkey", subkey);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> accumulateScore(String leaderboardId, String subkey, long score) {
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getAccumulateScoreUri());
            serverRequest.putBody(KEY_LEADERBOARD_ID, leaderboardId);
            serverRequest.putBody("delta", Long.valueOf(score));
            if (!TextUtils.isEmpty(subkey)) {
                serverRequest.putBody("subkey", subkey);
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628368644), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: LeaderboardService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/leaderboard/LeaderboardService$Settings;", "", "()V", "accumulateScoreUri", "", "getAccumulateScoreUri", "()Ljava/lang/String;", "setAccumulateScoreUri", "(Ljava/lang/String;)V", "getRankUri", "getGetRankUri", "setGetRankUri", "getRankedScoresUri", "getGetRankedScoresUri", "setGetRankedScoresUri", "getScoresUri", "getGetScoresUri", "setGetScoresUri", "putPropertyUri", "getPutPropertyUri", "setPutPropertyUri", "reportScoreUri", "getReportScoreUri", "setReportScoreUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getRankUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393531858), y.دײܮڳܯ(2051446317));
        private static String getScoresUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512488639), y.֬ڱܱײٮ(-1158689991));
        private static String getRankedScoresUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576475846), y.ۮڭڭܬި(862714163));
        private static String reportScoreUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782222840), y.دײܮڳܯ(2051445677));
        private static String putPropertyUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782222288), y.ٴسسݬߨ(1393529834));
        private static String accumulateScoreUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512490767), y.ۮڭڭܬި(862684307));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetRankUri() {
            return getRankUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetRankUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getRankUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetScoresUri() {
            return getScoresUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetScoresUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getScoresUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetRankedScoresUri() {
            return getRankedScoresUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetRankedScoresUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getRankedScoresUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getReportScoreUri() {
            return reportScoreUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setReportScoreUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            reportScoreUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getPutPropertyUri() {
            return putPropertyUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPutPropertyUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            putPropertyUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getAccumulateScoreUri() {
            return accumulateScoreUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setAccumulateScoreUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            accumulateScoreUri = str;
        }
    }
}
