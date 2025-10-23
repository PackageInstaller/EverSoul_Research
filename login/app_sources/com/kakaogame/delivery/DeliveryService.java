package com.kakaogame.delivery;

import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.addon.KGService;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeliveryService.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0007J8\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0007J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0007J \u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/delivery/DeliveryService;", "", "()V", "TAG", "", "deleteMessages", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "messageIds", "", "getReceivedMessages", "Lcom/kakaogame/util/json/JSONObject;", "messageBoxId", KGService.COUNT, "", "pageKey", "", "states", "getUnreadMessageCount", "markAsReadMessages", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DeliveryService {
    public static final DeliveryService INSTANCE = new DeliveryService();
    private static final String TAG = "DeliveryService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DeliveryService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Integer> getUnreadMessageCount(String messageBoxId) {
        String str = y.ݮڮֲڭܩ(-628649356);
        Intrinsics.checkNotNullParameter(messageBoxId, str);
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(576621734) + messageBoxId;
        String str3 = y.ݬֲ֮ܲت(1512334543);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetUnreadMessageCountUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("receiverId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(str, messageBoxId);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            Number number = (Number) content.get((Object) KGService.COUNT);
            Intrinsics.checkNotNull(number);
            return KGResult.INSTANCE.getSuccessResult(Integer.valueOf(number.intValue()));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getReceivedMessages(String messageBoxId, int count, long pageKey, List<String> states) {
        String str = y.ݮڮֲڭܩ(-628649356);
        Intrinsics.checkNotNullParameter(messageBoxId, str);
        String str2 = y.ݮڮֲڭܩ(-628649276);
        Intrinsics.checkNotNullParameter(states, str2);
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ݬֲ֮ܲت(1512334407)).append(messageBoxId);
        String str3 = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str3).append(count).append(str3).append(pageKey).append(str3).append(states).toString();
        String str4 = y.ݬֲ֮ܲت(1512334543);
        logger.m699d(str4, sb);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetMessagesUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("receiverId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(str, messageBoxId);
            serverRequest.putBody(KGService.COUNT, Integer.valueOf(count));
            serverRequest.putBody("nextPageKey", Long.valueOf(pageKey));
            serverRequest.putBody(str2, states);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult(requestServer$default.getContent());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> markAsReadMessages(List<String> messageIds) {
        KGResult<Void> successResult;
        String str = y.֬ڱܱײٮ(-1158868135);
        Intrinsics.checkNotNullParameter(messageIds, str);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݮڮֲڭܩ(-628523764) + messageIds;
        String str3 = y.ݬֲ֮ܲت(1512334543);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getMarkAsReadUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("receiverId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(str, messageIds);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> deleteMessages(List<String> messageIds) {
        KGResult<Void> successResult;
        String str = y.֬ڱܱײٮ(-1158868135);
        Intrinsics.checkNotNullParameter(messageIds, str);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݬֲ֮ܲت(1512334687) + messageIds;
        String str3 = y.ݬֲ֮ܲت(1512334543);
        logger.m699d(str3, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getDeleteMessagesUri());
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            serverRequest.putBody("receiverId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody(str, messageIds);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                successResult = KGResult.INSTANCE.getResult(requestServer$default);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* compiled from: DeliveryService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/delivery/DeliveryService$Settings;", "", "()V", "deleteMessagesUri", "", "getDeleteMessagesUri", "()Ljava/lang/String;", "setDeleteMessagesUri", "(Ljava/lang/String;)V", "getMessagesUri", "getGetMessagesUri", "setGetMessagesUri", "getUnreadMessageCountUri", "getGetUnreadMessageCountUri", "setGetUnreadMessageCountUri", "markAsReadUri", "getMarkAsReadUri", "setMarkAsReadUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String getUnreadMessageCountUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782081992), y.ݮڮֲڭܩ(-628538348));
        private static String getMessagesUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782083080), y.֬ڱܱײٮ(-1158861047));
        private static String markAsReadUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628537724), y.֬ڱܱײٮ(-1158861095));
        private static String deleteMessagesUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782076296), y.֬ڱܱײٮ(-1158868751));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetUnreadMessageCountUri() {
            return getUnreadMessageCountUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetUnreadMessageCountUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getUnreadMessageCountUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetMessagesUri() {
            return getMessagesUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setGetMessagesUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            getMessagesUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMarkAsReadUri() {
            return markAsReadUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setMarkAsReadUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            markAsReadUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDeleteMessagesUri() {
            return deleteMessagesUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setDeleteMessagesUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            deleteMessagesUri = str;
        }
    }
}
