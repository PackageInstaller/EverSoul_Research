package com.kakaogame.log.service;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.addon.KGService;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.PlayerLogManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogBucketService.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JO\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ(\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007J2\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0014\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011J(\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007JE\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0017J(\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007JJ\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H\u0002J@\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J@\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J(\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007J(\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007J&\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006#"}, m839d2 = {"Lcom/kakaogame/log/service/LogBucketService;", "", "()V", "TAG", "", "writeActionLog", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "category", "action", PlayerLogManager.KEY_GRADE, "", Constants.ScionAnalytics.PARAM_LABEL, "valueStr", "valueNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/kakaogame/KGResult;", "logBody", "", "writeEventLog", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "eventData", "writeItemLog", "writeNetworkLog", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/kakaogame/KGResult;", "writePlayerLog", "uri", "code", "tag1", "tag2", "writePlayerLogForApp", "writePlayerLogForPlatform", "writeResourceLog", "writeRoundLog", "writeSummaryLog", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LogBucketService {
    public static final LogBucketService INSTANCE = new LogBucketService();
    private static final String TAG = "LogBucketService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LogBucketService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writePlayerLogForApp(String code, String tag1, String tag2, Map<String, ? extends Object> logBody) {
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        return writePlayerLog(Settings.INSTANCE.getWritePlayerLogForAppUri(), code, tag1, tag2, logBody);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writePlayerLogForPlatform(String code, String tag1, String tag2, Map<String, ? extends Object> logBody) {
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        return writePlayerLog(Settings.INSTANCE.getWritePlayerLogForPlatformUri(), code, tag1, tag2, logBody);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> writePlayerLog(String uri, String code, String tag1, String tag2, Map<String, ? extends Object> logBody) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051416077);
        String str2 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str2, str);
        try {
            if (TextUtils.isEmpty(code)) {
                Logger.INSTANCE.m701e(str2, "code is null");
                return KGResult.INSTANCE.getResult(4000);
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                Logger.INSTANCE.m701e(str2, "Core is not login");
                return KGResult.INSTANCE.getResult(3002);
            }
            ServerRequest serverRequest = new ServerRequest(uri);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody("code", code);
            if (tag1 != null) {
                serverRequest.putBody("tag1", tag1);
            }
            if (tag2 != null) {
                serverRequest.putBody("tag2", tag2);
            }
            if (logBody != null) {
                serverRequest.putBody("logBody", logBody);
            } else {
                serverRequest.putBody("logBody", new LinkedHashMap());
            }
            serverRequest.setIgnoreTimeout(true);
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeEventLog(String eventId, Map<String, ? extends Object> eventData) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158716047);
        String str2 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str2, str);
        try {
            if (TextUtils.isEmpty(eventId)) {
                Logger.INSTANCE.m701e(str2, "eventId is null");
                return KGResult.INSTANCE.getResult(4000, "event id is null");
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteEventLogUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody(KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, eventId);
            if (eventData != null) {
                serverRequest.putBody("eventData", eventData);
            }
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeActionLog(String category, String action, Long grade, String label, String valueStr, Long valueNo) {
        String str = y.ٴسسݬߨ(1392657618);
        String str2 = y.٬ݯح׭٩(575766846);
        Logger logger = Logger.INSTANCE;
        String str3 = y.٬ݯح׭٩(576512494);
        String str4 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str4, str3);
        try {
            if (TextUtils.isEmpty(category)) {
                Logger.INSTANCE.m701e(str4, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (TextUtils.isEmpty(action)) {
                Logger.INSTANCE.m701e(str4, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteActionLogUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody("category", category);
            serverRequest.putBody("action", action);
            if (grade != null) {
                serverRequest.putBody(PlayerLogManager.KEY_GRADE, grade);
            }
            if (label != null) {
                serverRequest.putBody(Constants.ScionAnalytics.PARAM_LABEL, label);
            }
            if (valueStr != null) {
                serverRequest.putBody("valueStr", valueStr);
            }
            if (valueNo != null) {
                serverRequest.putBody("valueNo", valueNo);
            }
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> writeActionLog(Map<String, ? extends Object> logBody) {
        String str = y.ٴسسݬߨ(1392657618);
        String str2 = y.٬ݯح׭٩(575766846);
        String str3 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str4 = y.٬ݯح׭٩(576512494);
        String str5 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str5, str4);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str5, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (!logBody.containsKey("category")) {
                Logger.INSTANCE.m701e(str5, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("action")) {
                Logger.INSTANCE.m701e(str5, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteActionLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeNetworkLog(String category, Long grade, String label, String valueStr, Long valueNo) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628419164);
        String str2 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str2, str);
        try {
            if (TextUtils.isEmpty(category)) {
                Logger.INSTANCE.m701e(str2, "category is null");
                return KGResult.INSTANCE.getResult(4000);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteNetworkLogUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody("category", category);
            if (grade != null) {
                serverRequest.putBody(PlayerLogManager.KEY_GRADE, grade);
            }
            if (label != null) {
                serverRequest.putBody(Constants.ScionAnalytics.PARAM_LABEL, label);
            }
            if (valueStr != null) {
                serverRequest.putBody("valueStr", valueStr);
            }
            if (valueNo != null) {
                serverRequest.putBody("valueNo", valueNo);
            }
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> writeNetworkLog(Map<String, ? extends Object> logBody) {
        String str = y.٬ݯح׭٩(575766846);
        String str2 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ݮڮֲڭܩ(-628419164);
        String str4 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str4, str3);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str4, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("category")) {
                Logger.INSTANCE.m701e(str4, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteNetworkLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> writeRoundLog(Map<String, ? extends Object> logBody) {
        String str = y.ۮڭڭܬި(862672035);
        String str2 = y.٬ݯح׭٩(576518702);
        String str3 = y.ݮڮֲڭܩ(-628421916);
        String str4 = y.ٴسسݬߨ(1393508122);
        String str5 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str6 = y.ݮڮֲڭܩ(-628421756);
        String str7 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str7, str6);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str7, str5);
                return KGResult.INSTANCE.getResult(4000, str5);
            }
            if (!logBody.containsKey("gameMode")) {
                Logger.INSTANCE.m701e(str7, str4);
                return KGResult.INSTANCE.getResult(4000, str4);
            }
            if (!logBody.containsKey("resultTp")) {
                Logger.INSTANCE.m701e(str7, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (!logBody.containsKey("startTime")) {
                Logger.INSTANCE.m701e(str7, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("endTime")) {
                Logger.INSTANCE.m701e(str7, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteRoundLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str7, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeSummaryLog(Map<String, ? extends Object> logBody) {
        String str = y.ٲٴݴ״ٰ(1782201832);
        String str2 = y.֬ڱܱײٮ(-1158715911);
        String str3 = y.ٲٴݴ״ٰ(1782195768);
        String str4 = y.دײܮڳܯ(2051423205);
        String str5 = y.ٴسسݬߨ(1393506722);
        String str6 = y.ٴسسݬߨ(1392657618);
        String str7 = y.٬ݯح׭٩(575766846);
        String str8 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str9 = y.دײܮڳܯ(2051422213);
        String str10 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str10, str9);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str10, str8);
                return KGResult.INSTANCE.getResult(4000, str8);
            }
            if (!logBody.containsKey("category")) {
                Logger.INSTANCE.m701e(str10, str7);
                return KGResult.INSTANCE.getResult(4000, str7);
            }
            if (!logBody.containsKey("action")) {
                Logger.INSTANCE.m701e(str10, str6);
                return KGResult.INSTANCE.getResult(4000, str6);
            }
            if (!logBody.containsKey(KGService.COUNT)) {
                Logger.INSTANCE.m701e(str10, str5);
                return KGResult.INSTANCE.getResult(4000, str5);
            }
            if (!logBody.containsKey("sum")) {
                Logger.INSTANCE.m701e(str10, str4);
                return KGResult.INSTANCE.getResult(4000, str4);
            }
            if (!logBody.containsKey(Base2ndPWViewData.KEY_MIN)) {
                Logger.INSTANCE.m701e(str10, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (!logBody.containsKey("max")) {
                Logger.INSTANCE.m701e(str10, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("modTime")) {
                Logger.INSTANCE.m701e(str10, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteSummaryLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str10, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> writeItemLog(Map<String, ? extends Object> logBody) {
        String str = y.دײܮڳܯ(2051417245);
        String str2 = y.دײܮڳܯ(2051417373);
        String str3 = y.ݬֲ֮ܲت(1512442951);
        String str4 = y.ݬֲ֮ܲت(1512442863);
        String str5 = y.ۮڭڭܬި(862668851);
        String str6 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str7 = y.ٴسسݬߨ(1393500634);
        String str8 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str8, str7);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str8, str6);
                return KGResult.INSTANCE.getResult(4000, str6);
            }
            if (!logBody.containsKey("itemId")) {
                Logger.INSTANCE.m701e(str8, str5);
                return KGResult.INSTANCE.getResult(4000, str5);
            }
            if (!logBody.containsKey(FirebaseAnalytics.Param.QUANTITY)) {
                Logger.INSTANCE.m701e(str8, str4);
                return KGResult.INSTANCE.getResult(4000, str4);
            }
            if (!logBody.containsKey("rCurrency")) {
                Logger.INSTANCE.m701e(str8, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (!logBody.containsKey("cost")) {
                Logger.INSTANCE.m701e(str8, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("reason")) {
                Logger.INSTANCE.m701e(str8, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteItemLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str8, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> writeResourceLog(Map<String, ? extends Object> logBody) {
        String str = y.دײܮڳܯ(2051417245);
        String str2 = y.ٲٴݴ״ٰ(1782201832);
        String str3 = y.֬ڱܱײٮ(-1158709575);
        String str4 = y.ٲٴݴ״ٰ(1782194968);
        String str5 = y.ٴسسݬߨ(1393507538);
        String str6 = y.ݬֲ֮ܲت(1512442951);
        String str7 = y.ٲٴݴ״ٰ(1782200896);
        Logger logger = Logger.INSTANCE;
        String str8 = y.ٲٴݴ״ٰ(1782194704);
        String str9 = y.ݮڮֲڭܩ(-628420084);
        logger.m706v(str9, str8);
        try {
            if (logBody == null) {
                Logger.INSTANCE.m701e(str9, str7);
                return KGResult.INSTANCE.getResult(4000, str7);
            }
            if (!logBody.containsKey("rCurrency")) {
                Logger.INSTANCE.m701e(str9, str6);
                return KGResult.INSTANCE.getResult(4000, str6);
            }
            if (!logBody.containsKey("delta")) {
                Logger.INSTANCE.m701e(str9, str5);
                return KGResult.INSTANCE.getResult(4000, str5);
            }
            if (!logBody.containsKey("amount")) {
                Logger.INSTANCE.m701e(str9, str4);
                return KGResult.INSTANCE.getResult(4000, str4);
            }
            if (!logBody.containsKey("modType")) {
                Logger.INSTANCE.m701e(str9, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (!logBody.containsKey("modTime")) {
                Logger.INSTANCE.m701e(str9, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (!logBody.containsKey("reason")) {
                Logger.INSTANCE.m701e(str9, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWriteResourceLogUri());
            serverRequest.putAllBody(logBody);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("market", configuration.getMarket());
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str9, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: LogBucketService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006\""}, m839d2 = {"Lcom/kakaogame/log/service/LogBucketService$Settings;", "", "()V", "API_DEPRECATED", "", "writeActionLogUri", "getWriteActionLogUri", "()Ljava/lang/String;", "setWriteActionLogUri", "(Ljava/lang/String;)V", "writeEventLogUri", "getWriteEventLogUri", "setWriteEventLogUri", "writeItemLogUri", "getWriteItemLogUri", "setWriteItemLogUri", "writeNetworkLogUri", "getWriteNetworkLogUri", "setWriteNetworkLogUri", "writePlayerLogForAppUri", "getWritePlayerLogForAppUri", "setWritePlayerLogForAppUri", "writePlayerLogForPlatformUri", "getWritePlayerLogForPlatformUri", "setWritePlayerLogForPlatformUri", "writeResourceLogUri", "getWriteResourceLogUri", "setWriteResourceLogUri", "writeRoundLogUri", "getWriteRoundLogUri", "setWriteRoundLogUri", "writeSummaryLogUri", "getWriteSummaryLogUri", "setWriteSummaryLogUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        private static final String API_DEPRECATED = "DEPRECATED";
        private static String writeActionLogUri;
        private static String writeEventLogUri;
        private static String writeItemLogUri;
        private static String writeNetworkLogUri;
        private static String writePlayerLogForPlatformUri;
        private static String writeResourceLogUri;
        private static String writeRoundLogUri;
        private static String writeSummaryLogUri;
        public static final Settings INSTANCE = new Settings();
        private static String writePlayerLogForAppUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628366020), y.ݮڮֲڭܩ(-628365820));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            OpenApiService openApiService = OpenApiService.INSTANCE;
            String str = y.ݬֲ֮ܲت(1512503447);
            String str2 = y.دײܮڳܯ(2051358461);
            writePlayerLogForPlatformUri = openApiService.setOpenApiUri(str, str2);
            writeEventLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576514094), str2);
            writeActionLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051419789), y.دײܮڳܯ(2051459821));
            writeNetworkLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576514518), y.ۮڭڭܬި(862668771));
            writeRoundLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628417596), y.֬ڱܱײٮ(-1158711991));
            writeSummaryLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051418965), y.ݮڮֲڭܩ(-628374028));
            writeItemLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051418213), y.ۮڭڭܬި(862667739));
            writeResourceLogUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051418597), y.دײܮڳܯ(2051417853));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWritePlayerLogForAppUri() {
            return writePlayerLogForAppUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWritePlayerLogForAppUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writePlayerLogForAppUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWritePlayerLogForPlatformUri() {
            return writePlayerLogForPlatformUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWritePlayerLogForPlatformUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writePlayerLogForPlatformUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteEventLogUri() {
            return writeEventLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteEventLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeEventLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteActionLogUri() {
            return writeActionLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteActionLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeActionLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteNetworkLogUri() {
            return writeNetworkLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteNetworkLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeNetworkLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteRoundLogUri() {
            return writeRoundLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteRoundLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeRoundLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteSummaryLogUri() {
            return writeSummaryLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteSummaryLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeSummaryLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteItemLogUri() {
            return writeItemLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteItemLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeItemLogUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteResourceLogUri() {
            return writeResourceLogUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteResourceLogUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeResourceLogUri = str;
        }
    }
}
