package com.kakaogame.server;

import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.server.session.SessionService;
import com.liapp.y;
import java.security.Security;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ServerService.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0019\u001a\u00020\u000bH\u0007J\b\u0010\u001a\u001a\u00020\u000bH\u0007J\b\u0010\u001b\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\u0007\u0010\t¨\u0006\u001c"}, m839d2 = {"Lcom/kakaogame/server/ServerService;", "", "()V", "TAG", "", "<set-?>", "", "isUseSession", "isUseSession$annotations", "()Z", "disconnect", "", "initialize", "configuration", "Lcom/kakaogame/config/Configuration;", "requestConnect", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/server/ServerResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "type", "traceJobId", "", "requestServer", "requestServerWithoutResponse", "setSessionUrl", "useHttpConnection", "useSessionConnection", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerService {
    private static final String TAG = "ServerService";
    public static final ServerService INSTANCE = new ServerService();
    private static boolean isUseSession = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isUseSession$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ServerService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isUseSession() {
        return isUseSession;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        Security.setProperty(y.٬ݯح׭٩(576338958), y.ݮڮֲڭܩ(-628926708));
        Security.setProperty(y.دײܮڳܯ(2051079037), y.دײܮڳܯ(2051900013));
        SessionService.initialize(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void useHttpConnection() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051077749);
        String str2 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str2, str);
        try {
            isUseSession = false;
            disconnect();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void useSessionConnection() {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512103687);
        String str2 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str2, str);
        try {
            isUseSession = true;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void disconnect() {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782293856);
        String str2 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str2, str);
        try {
            if (isUseSession) {
                SessionService.disconnect();
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<ServerResult> requestConnect(ServerRequest request, String type, int traceJobId) {
        String str = y.ݬֲ֮ܲت(1512100287);
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݮڮֲڭܩ(-628240708) + isUseSession;
        String str3 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str3, str2);
        try {
            if (!KGSystem.isNetworkConnected()) {
                Logger.INSTANCE.m701e(str3, "[requestConnect] network is not connected");
                return KGResult.INSTANCE.getResult(1001);
            }
            if (isUseSession) {
                return SessionService.requestConnect(request, type, traceJobId);
            }
            ServerResult requestServer = requestServer(request, traceJobId);
            Logger.INSTANCE.m704i(str3, str + requestServer);
            KGResult<ServerResult> result = KGResult.INSTANCE.getResult(requestServer);
            result.put((KGResult<ServerResult>) "content", (String) requestServer);
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ServerResult requestServer$default(ServerRequest serverRequest, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return requestServer(serverRequest, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResult requestServer(ServerRequest request, int traceJobId) {
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159092671) + isUseSession;
        String str2 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str2, str);
        try {
            if (!KGSystem.isNetworkConnected()) {
                Logger.INSTANCE.m701e(str2, "[requestServer] network is not connected");
                return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(1001));
            }
            if (isUseSession) {
                return SessionService.requestSession(request, traceJobId);
            }
            return OpenApiService.requestServerApi(request, traceJobId);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(4001), request);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestServerWithoutResponse(ServerRequest request) {
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512103639) + isUseSession;
        String str2 = y.ٲٴݴ״ٰ(1782374608);
        logger.m704i(str2, str);
        try {
            if (!KGSystem.isNetworkConnected()) {
                Logger.INSTANCE.m701e(str2, "[requestServerWithoutResponse] network is not connected");
            } else if (isUseSession) {
                SessionService.requestSessionWithoutResponse(request);
            } else {
                OpenApiService.requestServerApiWithoutResponse(request);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setSessionUrl() {
        Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
        String str = (String) (configuration != null ? configuration.get(y.ݬֲ֮ܲت(1512366615)) : null);
        if (str == null || StringsKt.equals(str, y.دײܮڳܯ(2051336581), true) || StringsKt.equals(str, y.دײܮڳܯ(2051341917), true)) {
            return;
        }
        SessionService.setSessionUrl(InfodeskHelper.INSTANCE.getSessionUrl());
        SessionService.setTimeout(InfodeskHelper.INSTANCE.getSesseionTimeout());
    }
}
