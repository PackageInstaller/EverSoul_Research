package com.kakaogame.player;

import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalPlayerService.kt */
@Metadata(m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0011J\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011J(\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010&H\u0007J(\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&H\u0007J(\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010&H\u0007J\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f¨\u0006-"}, m839d2 = {"Lcom/kakaogame/player/LocalPlayerService;", "", "()V", "FIELD_KEY_AGREEMENT", "", "FIELD_KEY_FIRST_LOGIN_TIME", "FIELD_KEY_MEMBER_KEY", "FIELD_KEY_PUSH_OPTION", "FIELD_KEY_PUSH_TOKEN", "TAG", "appId", "localPlayerFields", "", "getLocalPlayerFields$annotations", "getLocalPlayerFields", "()Ljava/util/List;", "cancelForRemove", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "playerId", "traceJobId", "", "getLocalPlayer", "Lcom/kakaogame/player/LocalPlayer;", "getLocalPlayerRequest", "Lcom/kakaogame/server/ServerRequest;", ServerConstants.ZAT, "getPaymentUserId", "handleGetLocalPlayerResult", "result", "Lcom/kakaogame/server/ServerResult;", "initialize", "", "configuration", "Lcom/kakaogame/config/Configuration;", "remove", "updateCustomProperty", "updateCustomPropertyMap", "", "updatePlayer", "fieldMap", "updateSecureProperty", "updateSecurePropertyMap", "waitForRemove", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LocalPlayerService {
    public static final String FIELD_KEY_AGREEMENT = "agreement";
    public static final String FIELD_KEY_FIRST_LOGIN_TIME = "firstLoginTime";
    public static final String FIELD_KEY_MEMBER_KEY = "memberKey";
    public static final String FIELD_KEY_PUSH_OPTION = "pushOption";
    public static final String FIELD_KEY_PUSH_TOKEN = "pushToken";
    public static final LocalPlayerService INSTANCE = new LocalPlayerService();
    private static final String TAG = "LocalPlayerService";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getLocalPlayerFields$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocalPlayerService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        appId = configuration.getAppId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> remove() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051432957);
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getRemoveUri());
            serverRequest.putBody("appId", appId);
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> waitForRemove() {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393517018);
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getWaitForRemoveUri());
            serverRequest.putBody("appId", appId);
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> cancelForRemove(String playerId, int traceJobId) {
        KGResult<Void> successResult;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782216984);
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", appId);
            linkedHashMap.put("playerId", playerId);
            KGResult<String> requestOpenApi = OpenApiService.INSTANCE.requestOpenApi(Settings.INSTANCE.getCancelForRemovePlayerOpenAPIUri(), linkedHashMap, null, traceJobId);
            if (!requestOpenApi.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestOpenApi);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<LocalPlayer> getLocalPlayer(int traceJobId) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576496398);
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        try {
            List<String> localPlayerFields = getLocalPlayerFields();
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetLocalPlayerUri());
            serverRequest.putBody("appId", appId);
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("fields", localPlayerFields);
            JSONObject content = ServerService.requestServer(serverRequest, traceJobId).getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = (JSONObject) content.get((Object) "player");
            if (jSONObject == null) {
                return KGResult.INSTANCE.getResult(2003, "player is null");
            }
            LocalPlayer localPlayer = new LocalPlayer(jSONObject);
            if (localPlayer.getPlayerId().length() == 0) {
                return KGResult.INSTANCE.getResult(2003, "player id is null");
            }
            return KGResult.INSTANCE.getSuccessResult(localPlayer);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> getPaymentUserId() {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158725831);
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        try {
            JSONObject content = ServerService.requestServer$default(new ServerRequest(Settings.INSTANCE.getGetPaymentUserIdUri()), 0, 2, null).getContent();
            Intrinsics.checkNotNull(content);
            String str3 = (String) content.get((Object) ServerConstants.ZINNY_UUID);
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                return KGResult.INSTANCE.getResult(2003, "zinnyUuid id is null");
            }
            return KGResult.INSTANCE.getSuccessResult(str3);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> updatePlayer(Map<String, ? extends Object> fieldMap) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512459111) + fieldMap;
        String str2 = y.ݬֲ֮ܲت(1512459527);
        logger.m699d(str2, str);
        if (fieldMap != null) {
            try {
                if (!fieldMap.isEmpty()) {
                    ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getUpdatePlayerUri());
                    serverRequest.putBody("appId", appId);
                    serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
                    serverRequest.putAllBody(fieldMap);
                    return KGResult.INSTANCE.getResult(ServerService.requestServer$default(serverRequest, 0, 2, null));
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }
        return KGResult.INSTANCE.getResult(4000);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> updateCustomProperty(Map<String, String> updateCustomPropertyMap) {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512459527), y.֬ڱܱײٮ(-1158721575) + updateCustomPropertyMap);
        if (updateCustomPropertyMap == null || updateCustomPropertyMap.isEmpty()) {
            return KGResult.INSTANCE.getResult(4000);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.֬ڱܱײٮ(-1159585167), updateCustomPropertyMap);
        return updatePlayer(linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> updateSecureProperty(Map<String, String> updateSecurePropertyMap) {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512459527), y.ٴسسݬߨ(1393519866) + updateSecurePropertyMap);
        if (updateSecurePropertyMap == null || updateSecurePropertyMap.isEmpty()) {
            return KGResult.INSTANCE.getResult(4000);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.دײܮڳܯ(2051436117), updateSecurePropertyMap);
        return updatePlayer(linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerRequest getLocalPlayerRequest(String appId2, String playerId, String zat) {
        String str = y.ۮڭڭܬި(862411867);
        Intrinsics.checkNotNullParameter(appId2, str);
        String str2 = y.ݬֲ֮ܲت(1512589743);
        Intrinsics.checkNotNullParameter(playerId, str2);
        String str3 = y.ݮڮֲڭܩ(-628583628);
        Intrinsics.checkNotNullParameter(zat, str3);
        ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetLocalPlayerUri());
        serverRequest.putHeader(str2, playerId);
        serverRequest.putHeader(str3, zat);
        serverRequest.putBody(str, appId2);
        serverRequest.putBody(str2, playerId);
        serverRequest.putBody("fields", getLocalPlayerFields());
        return serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<LocalPlayer> handleGetLocalPlayerResult(ServerResult result) {
        Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512459527), y.ۮڭڭܬި(862653355) + result);
        if (result == null) {
            return KGResult.INSTANCE.getResult(2001);
        }
        if (result.isSuccess()) {
            JSONObject content = result.getContent();
            if (content == null) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            JSONObject jSONObject = (JSONObject) content.get((Object) y.ۮڭڭܬި(862276451));
            if (jSONObject == null) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            LocalPlayer localPlayer = new LocalPlayer(jSONObject);
            if (TextUtils.isEmpty(localPlayer.getPlayerId())) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            return KGResult.INSTANCE.getSuccessResult(localPlayer);
        }
        return KGResult.INSTANCE.getResult(result);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final List<String> getLocalPlayerFields() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y.ݬֲ֮ܲت(1512589743));
        arrayList.add(y.֬ڱܱײٮ(-1159585167));
        arrayList.add(y.دײܮڳܯ(2051436117));
        arrayList.add(y.٬ݯح׭٩(576496630));
        arrayList.add(y.ٲٴݴ״ٰ(1782218504));
        arrayList.add(y.ݬֲ֮ܲت(1512616079));
        arrayList.add(y.ٲٴݴ״ٰ(1782046688));
        arrayList.add(y.ٴسسݬߨ(1393516578));
        arrayList.add(y.٬ݯح׭٩(576655054));
        arrayList.addAll(Settings.localPlayerFieldKeyList);
        return arrayList;
    }

    /* compiled from: LocalPlayerService.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/player/LocalPlayerService$Settings;", "", "()V", "cancelForRemovePlayerOpenAPIUri", "", "getCancelForRemovePlayerOpenAPIUri", "()Ljava/lang/String;", "setCancelForRemovePlayerOpenAPIUri", "(Ljava/lang/String;)V", "getLocalPlayerUri", "getGetLocalPlayerUri", "setGetLocalPlayerUri", "getPaymentUserIdUri", "getGetPaymentUserIdUri", "setGetPaymentUserIdUri", "localPlayerFieldKeyList", "", "removeUri", "getRemoveUri", "setRemoveUri", "updatePlayerUri", "getUpdatePlayerUri", "setUpdatePlayerUri", "waitForRemoveUri", "getWaitForRemoveUri", "setWaitForRemoveUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getPaymentUserIdUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782215280), y.ٴسسݬߨ(1393520146));
        private static String updatePlayerUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512457599), y.ٴسسݬߨ(1393520538));
        private static String getLocalPlayerUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576498790), y.ݮڮֲڭܩ(-628400876));
        private static String removeUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782216432), y.٬ݯح׭٩(576499446));
        private static String waitForRemoveUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628400380), y.ۮڭڭܬި(862653787));
        private static String cancelForRemovePlayerOpenAPIUri = y.ٲٴݴ״ٰ(1782217248);
        public static final Set<String> localPlayerFieldKeyList = new LinkedHashSet();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetPaymentUserIdUri() {
            return getPaymentUserIdUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetPaymentUserIdUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getPaymentUserIdUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getUpdatePlayerUri() {
            return updatePlayerUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setUpdatePlayerUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            updatePlayerUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetLocalPlayerUri() {
            return getLocalPlayerUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetLocalPlayerUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getLocalPlayerUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRemoveUri() {
            return removeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRemoveUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            removeUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWaitForRemoveUri() {
            return waitForRemoveUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWaitForRemoveUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            waitForRemoveUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCancelForRemovePlayerOpenAPIUri() {
            return cancelForRemovePlayerOpenAPIUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCancelForRemovePlayerOpenAPIUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            cancelForRemovePlayerOpenAPIUri = str;
        }
    }
}
