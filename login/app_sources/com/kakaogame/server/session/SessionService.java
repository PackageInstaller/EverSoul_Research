package com.kakaogame.server.session;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.LoginData;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.APILogManager;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerInfo;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.session.SessionService;
import com.kakaogame.session.WebSocketManager;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionService.kt */
@Metadata(m838d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0007J\u0016\u0010\u001b\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0007J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0007J(\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0007J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0017H\u0007J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m839d2 = {"Lcom/kakaogame/server/session/SessionService;", "", "()V", "DEFAULT_TIMEOUT", "", "SESSION_REQUEST_URI", "", "TAG", "connecting", "", "isConnected", "isConnected$annotations", "()Z", "manager", "Lcom/kakaogame/session/WebSocketManager;", "onlinePushListenerList", "", "Lcom/kakaogame/server/session/SessionService$OnlinePushListener;", "queueLock", "requestQueue", "Ljava/util/LinkedList;", "Lcom/kakaogame/util/MutexLock;", "sessionTimeout", "", "addOnlinePushListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addRequestQueue", "requestLock", "disconnect", "initialize", "configuration", "Lcom/kakaogame/config/Configuration;", "requestConnect", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/server/ServerResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "type", "traceJobId", "requestSession", "requestSessionWithoutResponse", "setSessionUrl", ServerInfo.KEY_SESSION_URL, "setTimeout", "timeout", "unLockRequestQueue", ServerConstants.TRACE_RESULT_CODE, "OnlinePushListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SessionService {
    private static final int DEFAULT_TIMEOUT = 20000;
    private static final String SESSION_REQUEST_URI = "/session";
    private static final String TAG = "SessionService";
    private static boolean connecting;
    private static WebSocketManager manager;
    public static final SessionService INSTANCE = new SessionService();
    private static long sessionTimeout = 20000;
    private static final Set<OnlinePushListener> onlinePushListenerList = new LinkedHashSet();
    private static final LinkedList<MutexLock<Integer>> requestQueue = new LinkedList<>();
    private static final Object queueLock = new Object();

    /* compiled from: SessionService.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/server/session/SessionService$OnlinePushListener;", "", "onMessage", "", "uri", "", "message", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface OnlinePushListener {
        void onMessage(String uri, Map<String, ? extends Object> message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isConnected$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SessionService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, y.ٴسسݬߨ(1393326218));
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576325158), y.ٲٴݴ״ٰ(1781793120));
        WebSocketManager webSocketManager = new WebSocketManager(configuration.getServerInfo().getSessionUrl() + y.دײܮڳܯ(2051064037), y.٬ݯح׭٩(576325334));
        manager = webSocketManager;
        Intrinsics.checkNotNull(webSocketManager);
        webSocketManager.setWebsocketListener(new WebSocketManager.WebSocketEventListener() { // from class: com.kakaogame.server.session.SessionService$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onConnect() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onServerMessage(ServerResponse response) {
                Set set;
                Logger logger = Logger.INSTANCE;
                String str = y.֬ڱܱײٮ(-1158743831) + response;
                String str2 = y.٬ݯح׭٩(576325158);
                logger.m699d(str2, str);
                if (response == null) {
                    return;
                }
                String requestUri = response.getRequestUri();
                JSONObject body = response.getBody();
                set = SessionService.onlinePushListenerList;
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    try {
                        ((SessionService.OnlinePushListener) it.next()).onMessage(requestUri, body);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str2, e.toString(), e);
                    }
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onDisconnect() {
                boolean z;
                if (!CoreManager.INSTANCE.getInstance().isAuthorized() || CoreManager.INSTANCE.getInstance().isPaused() || SessionService.isConnected()) {
                    return;
                }
                z = SessionService.connecting;
                if (z) {
                    return;
                }
                Logger.INSTANCE.m704i(y.٬ݯح׭٩(576325158), y.ݬֲ֮ܲت(1512106735) + CoreManager.INSTANCE.getInstance().reconnectAutoLogin());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setSessionUrl(String sessionUrl) {
        WebSocketManager webSocketManager;
        try {
            if (TextUtils.isEmpty(sessionUrl) || (webSocketManager = manager) == null) {
                return;
            }
            Intrinsics.checkNotNull(webSocketManager);
            Intrinsics.checkNotNull(sessionUrl);
            webSocketManager.setSessionUrl(sessionUrl);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576325158), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setTimeout(long timeout) {
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576325158), y.ݬֲ֮ܲت(1512545175) + timeout);
        sessionTimeout = timeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isConnected() {
        boolean isConnected;
        String str = y.٬ݯح׭٩(576325158);
        String str2 = y.ݮڮֲڭܩ(-628453444);
        try {
            WebSocketManager webSocketManager = manager;
            if (webSocketManager == null) {
                Logger.INSTANCE.m701e(str, "[isConnected] manager is not init");
                isConnected = false;
            } else {
                Intrinsics.checkNotNull(webSocketManager);
                isConnected = webSocketManager.isConnected();
            }
            Logger.INSTANCE.m699d(str, str2 + isConnected);
            return isConnected;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void disconnect() {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782293856);
        String str2 = y.٬ݯح׭٩(576325158);
        logger.m699d(str2, str);
        try {
            WebSocketManager webSocketManager = manager;
            if (webSocketManager != null) {
                webSocketManager.disconnect();
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void addRequestQueue(MutexLock<Integer> requestLock) {
        synchronized (queueLock) {
            requestQueue.add(requestLock);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void unLockRequestQueue(int resultCode) {
        synchronized (queueLock) {
            LinkedList<MutexLock<Integer>> linkedList = requestQueue;
            if (!linkedList.isEmpty()) {
                Iterator<MutexLock<Integer>> it = linkedList.iterator();
                while (it.hasNext()) {
                    MutexLock<Integer> next = it.next();
                    next.setContent(Integer.valueOf(resultCode));
                    next.unlock();
                }
                requestQueue.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final synchronized KGResult<ServerResult> requestConnect(ServerRequest request, String type, int traceJobId) {
        KGResult<ServerResult> result;
        ServerResponse response;
        String str = y.ݬֲ֮ܲت(1512106159);
        String str2 = y.ݮڮֲڭܩ(-628240708);
        synchronized (SessionService.class) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(type, "type");
            Log.d(TAG, str2 + request);
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                connecting = false;
                result = KGResult.INSTANCE.getResult(4001, e.toString());
            }
            if (manager == null) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] manager is not init");
                return KGResult.INSTANCE.getResult(3001, "manager is not init");
            }
            SessionService sessionService = INSTANCE;
            connecting = true;
            if (traceJobId > 0) {
                request.putHeader(ServerConstants.HEADER_TRACE_ID, Tracer.INSTANCE.getTraceId());
                request.putHeader("jobId", Integer.valueOf(traceJobId));
                request.putHeader(ServerConstants.TRACE_JOB_NAME, Tracer.INSTANCE.getJobName(traceJobId));
                request.putHeader(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            }
            String rttData = Tracer.INSTANCE.getRttData();
            if (rttData != null) {
                request.putHeader(ServerConstants.HEADER_TRACE_ID, Tracer.INSTANCE.getTraceId());
                request.putHeader(ServerConstants.HEADER_X_TRACE_INFO, rttData);
            }
            Stopwatch start = Stopwatch.INSTANCE.start(str + type);
            long requestUri = Tracer.INSTANCE.requestUri(traceJobId, request.getRequestUri());
            WebSocketManager webSocketManager = manager;
            Intrinsics.checkNotNull(webSocketManager);
            KeyBaseResult<ServerResult> connect = webSocketManager.connect(request, sessionTimeout);
            Tracer tracer = Tracer.INSTANCE;
            ServerResult content = connect.getContent();
            tracer.response(requestUri, (content == null || (response = content.getResponse()) == null) ? null : response.getHeader());
            connecting = false;
            sessionService.unLockRequestQueue(connect.getCode());
            start.stop();
            APILogManager.INSTANCE.writeServerApiCall(start.getName(), connect, start.getDurationMs());
            result = KGResult.INSTANCE.getResult(connect.getCode(), connect.getDescription(), connect.getContent());
            return result;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ce, code lost:
    
        if (r2.intValue() != 200) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0179, code lost:
    
        r10.putBody(r0, com.kakaogame.core.CoreManager.INSTANCE.getInstance().getPlayerId());
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0154 A[Catch: Exception -> 0x01dd, TryCatch #0 {Exception -> 0x01dd, blocks: (B:3:0x003d, B:5:0x0041, B:10:0x0062, B:11:0x0088, B:13:0x0090, B:14:0x009e, B:16:0x00af, B:18:0x00b3, B:21:0x00d0, B:23:0x00ca, B:25:0x011f, B:27:0x0127, B:28:0x0129, B:30:0x0139, B:32:0x0148, B:37:0x0154, B:38:0x0161, B:40:0x016f, B:45:0x0179, B:47:0x0186, B:49:0x01af, B:50:0x01b3, B:52:0x01b8, B:53:0x01c9, B:55:0x00df, B:57:0x00ef, B:59:0x011a), top: B:2:0x003d }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.server.ServerResult requestSession(com.kakaogame.server.ServerRequest r10, int r11) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.session.SessionService.requestSession(com.kakaogame.server.ServerRequest, int):com.kakaogame.server.ServerResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestSessionWithoutResponse(ServerRequest request) {
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782294544) + request;
        String str2 = y.٬ݯح׭٩(576325158);
        logger.m699d(str2, str);
        WebSocketManager webSocketManager = manager;
        if (webSocketManager == null) {
            Logger.INSTANCE.m701e(str2, y.ݮڮֲڭܩ(-628234100));
            return;
        }
        Intrinsics.checkNotNull(webSocketManager);
        if (!webSocketManager.isConnected()) {
            if (connecting) {
                MutexLock<Integer> createLock = MutexLock.INSTANCE.createLock();
                INSTANCE.addRequestQueue(createLock);
                MutexLock.lock$default(createLock, 0L, 1, null);
                Integer content = createLock.getContent();
                if (content == null || content.intValue() != 200) {
                    return;
                }
            } else {
                KGResult<LoginData> reconnectAutoLogin = CoreManager.INSTANCE.getInstance().reconnectAutoLogin();
                if (!reconnectAutoLogin.isSuccess()) {
                    Logger.INSTANCE.m701e(str2, y.٬ݯح׭٩(576330422) + reconnectAutoLogin);
                    return;
                }
            }
        }
        long timeout = request.getTimeout();
        if (timeout <= 0) {
            timeout = sessionTimeout;
        }
        WebSocketManager webSocketManager2 = manager;
        Intrinsics.checkNotNull(webSocketManager2);
        webSocketManager2.sendWithoutResponse(request, timeout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void addOnlinePushListener(OnlinePushListener listener) {
        if (listener != null) {
            onlinePushListenerList.add(listener);
        }
    }
}
