package com.kakaogame.gameserver;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.KGAppOption;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.gameserver.GameSessionService;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerInfo;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.session.WebSocketManager;
import com.kakaogame.util.NetworkUtil;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: GameSessionService.kt */
@Metadata(m838d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0006\u0010\u001f\u001a\u00020\u0018J\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010&\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J\u0010\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\nJ\b\u0010)\u001a\u00020\u0018H\u0002J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m839d2 = {"Lcom/kakaogame/gameserver/GameSessionService;", "", "()V", "CONNECT_REQUETS_URI", "", "DEFAULT_TIMEOUT", "", "SERVER_RETRY_DELAY_KEY", "TAG", "gameServerMessageListener", "Lcom/kakaogame/gameserver/GameSessionService$GameServerMessageListener;", "isConnected", "", "()Z", "manager", "Lcom/kakaogame/session/WebSocketManager;", "sessionRetryDelay", "", "sessionTimeout", ServerInfo.KEY_SESSION_URL, "getSessionUrl", "()Ljava/lang/String;", "useGameServer", "disconnect", "", "initWebsocket", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "initialize", "context", "Landroid/content/Context;", "ping", "requestConnect", "requestSession", "Lcom/kakaogame/server/ServerResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "requestSessionImpl", "requestSessionWithoutResponse", "setGameServerMessageListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setServerInfoFromInfodesk", "setTimeout", "timeout", "GameServerMessageListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GameSessionService {
    private static final String CONNECT_REQUETS_URI = "session://v2/app/login";
    private static final int DEFAULT_TIMEOUT = 10000;
    private static final String SERVER_RETRY_DELAY_KEY = "gameServerRetryDelay";
    private static final String TAG = "GameSessionService";
    private static GameServerMessageListener gameServerMessageListener;
    private static WebSocketManager manager;
    private static long sessionRetryDelay;
    private static boolean useGameServer;
    public static final GameSessionService INSTANCE = new GameSessionService();
    private static long sessionTimeout = 10000;

    /* compiled from: GameSessionService.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007H&¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/gameserver/GameSessionService$GameServerMessageListener;", "", "onMessage", "", "uri", "", "message", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface GameServerMessageListener {
        void onMessage(String uri, Map<String, ? extends Object> message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GameSessionService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(final Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m704i(y.ۮڭڭܬި(862637403), y.ٲٴݴ״ٰ(1781793120));
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.gameserver.GameSessionService$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onConnect(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogin(String playerId) {
                boolean z;
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                Logger logger = Logger.INSTANCE;
                String str = y.دײܮڳܯ(2051290013) + playerId;
                String str2 = y.ۮڭڭܬި(862637403);
                logger.m699d(str2, str);
                z = GameSessionService.useGameServer;
                if (z) {
                    GameSessionService.INSTANCE.setServerInfoFromInfodesk();
                    if (!GameSessionService.INSTANCE.isConnected()) {
                        Logger.INSTANCE.m704i(str2, y.֬ڱܱײٮ(-1158743215) + GameSessionService.INSTANCE.requestConnect(context));
                    }
                    GamePresenceService.startPing();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogout(String playerId) {
                boolean z;
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.ݬֲ֮ܲت(1512541335) + playerId);
                z = GameSessionService.useGameServer;
                if (z) {
                    GamePresenceService.stopPing();
                    GameSessionService.INSTANCE.disconnect();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onPause() {
                boolean z;
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.٬ݯح׭٩(575803878));
                z = GameSessionService.useGameServer;
                if (z) {
                    GamePresenceService.stopPing();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onUnregister(String playerId) {
                boolean z;
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.֬ڱܱײٮ(-1158743471));
                z = GameSessionService.useGameServer;
                if (z) {
                    GamePresenceService.stopPing();
                    GameSessionService.INSTANCE.disconnect();
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getSessionUrl() {
        String value = KGAppOption.getValue(y.ݬֲ֮ܲت(1512540367));
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.دײܮڳܯ(2051514797) + value);
        String str = value;
        if (str == null || str.length() == 0) {
            return null;
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #1 {Exception -> 0x0053, blocks: (B:3:0x001c, B:5:0x0036, B:7:0x003b, B:12:0x0047), top: B:2:0x001c }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setServerInfoFromInfodesk() {
        /*
            r7 = this;
            r0 = 1393473858(0x530eb942, float:6.1299347E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            r1 = 862637403(0x336acd5b, float:5.466914E-8)
            java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
            r2 = 1782294232(0x6a3ba6d8, float:5.6714256E25)
            java.lang.String r2 = com.liapp.y.ٲٴݴ״ٰ(r2)
            r3 = -1158749743(0xffffffffbaeee1d1, float:-0.0018225258)
            java.lang.String r3 = com.liapp.y.֬ڱܱײٮ(r3)
            java.lang.String r4 = r7.getSessionUrl()     // Catch: java.lang.Exception -> L53
            com.kakaogame.Logger r5 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L53
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L53
            r6.<init>(r3)     // Catch: java.lang.Exception -> L53
            java.lang.StringBuilder r3 = r6.append(r4)     // Catch: java.lang.Exception -> L53
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L53
            r5.m699d(r1, r3)     // Catch: java.lang.Exception -> L53
            com.kakaogame.session.WebSocketManager r3 = com.kakaogame.gameserver.GameSessionService.manager     // Catch: java.lang.Exception -> L53
            if (r3 == 0) goto L5f
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> L53
            if (r3 == 0) goto L44
            int r3 = r3.length()     // Catch: java.lang.Exception -> L53
            if (r3 != 0) goto L42
            goto L44
        L42:
            r3 = 0
            goto L45
        L44:
            r3 = 1
        L45:
            if (r3 != 0) goto L5f
            com.kakaogame.session.WebSocketManager r3 = com.kakaogame.gameserver.GameSessionService.manager     // Catch: java.lang.Exception -> L53
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Exception -> L53
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: java.lang.Exception -> L53
            r3.setSessionUrl(r4)     // Catch: java.lang.Exception -> L53
            goto L5f
        L53:
            r3 = move-exception
            com.kakaogame.Logger r4 = com.kakaogame.Logger.INSTANCE
            java.lang.String r5 = r3.toString()
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r4.m702e(r1, r5, r3)
        L5f:
            java.lang.String r3 = com.kakaogame.KGAppOption.getValue(r0)     // Catch: java.lang.Exception -> L87
            if (r3 == 0) goto L93
            java.lang.String r0 = com.kakaogame.KGAppOption.getValue(r0)     // Catch: java.lang.Exception -> L87
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L87
            long r3 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Exception -> L87
            com.kakaogame.gameserver.GameSessionService.sessionRetryDelay = r3     // Catch: java.lang.Exception -> L87
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L87
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L87
            r3.<init>(r2)     // Catch: java.lang.Exception -> L87
            long r4 = com.kakaogame.gameserver.GameSessionService.sessionRetryDelay     // Catch: java.lang.Exception -> L87
            java.lang.StringBuilder r2 = r3.append(r4)     // Catch: java.lang.Exception -> L87
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L87
            r0.m704i(r1, r2)     // Catch: java.lang.Exception -> L87
            goto L93
        L87:
            r0 = move-exception
            com.kakaogame.Logger r2 = com.kakaogame.Logger.INSTANCE
            java.lang.String r3 = r0.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.m702e(r1, r3, r0)
        L93:
            return
            fill-array 0x0094: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.gameserver.GameSessionService.setServerInfoFromInfodesk():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> initWebsocket() {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782293344);
        String str2 = y.ۮڭڭܬި(862637403);
        logger.m704i(str2, str);
        String sessionUrl = getSessionUrl();
        Logger.INSTANCE.m699d(str2, y.֬ڱܱײٮ(-1158749743) + sessionUrl);
        String str3 = sessionUrl;
        if (str3 == null || str3.length() == 0) {
            return KGResult.INSTANCE.getResult(3000, y.٬ݯح׭٩(576551278));
        }
        useGameServer = true;
        Intrinsics.checkNotNull(sessionUrl);
        WebSocketManager webSocketManager = new WebSocketManager(sessionUrl, y.֬ڱܱײٮ(-1158749647));
        manager = webSocketManager;
        Intrinsics.checkNotNull(webSocketManager);
        webSocketManager.setWebsocketListener(new WebSocketManager.WebSocketEventListener() { // from class: com.kakaogame.gameserver.GameSessionService$initWebsocket$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onServerMessage(ServerResponse response) {
                GameSessionService.GameServerMessageListener gameServerMessageListener2;
                GameSessionService.GameServerMessageListener gameServerMessageListener3;
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.֬ڱܱײٮ(-1158743831) + response);
                if (response == null) {
                    return;
                }
                String requestUri = response.getRequestUri();
                JSONObject body = response.getBody();
                gameServerMessageListener2 = GameSessionService.gameServerMessageListener;
                if (gameServerMessageListener2 != null) {
                    gameServerMessageListener3 = GameSessionService.gameServerMessageListener;
                    Intrinsics.checkNotNull(gameServerMessageListener3);
                    gameServerMessageListener3.onMessage(requestUri, body);
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onConnect() {
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.ٴسسݬߨ(1393468754));
                GamePresenceService.startPing();
                KGResult.INSTANCE.getSuccessResult();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.session.WebSocketManager.WebSocketEventListener
            public void onDisconnect() {
                Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.٬ݯح׭٩(576545110));
                GamePresenceService.stopPing();
                KGResult.INSTANCE.getSuccessResult();
            }
        });
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTimeout(long timeout) {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.ݬֲ֮ܲت(1512545175) + timeout);
        sessionTimeout = timeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isConnected() {
        boolean isConnected;
        WebSocketManager webSocketManager = manager;
        String str = y.ۮڭڭܬި(862637403);
        if (webSocketManager == null) {
            Logger.INSTANCE.m701e(str, y.ݮڮֲڭܩ(-628453756));
            isConnected = false;
        } else {
            Intrinsics.checkNotNull(webSocketManager);
            isConnected = webSocketManager.isConnected();
        }
        Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628453444) + isConnected);
        return isConnected;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void disconnect() {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.ٲٴݴ״ٰ(1782293856));
        WebSocketManager webSocketManager = manager;
        if (webSocketManager != null) {
            Intrinsics.checkNotNull(webSocketManager);
            webSocketManager.disconnect();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized KGResult<Void> requestConnect(Context context) {
        String str = y.ۮڭڭܬި(862641491);
        synchronized (this) {
            Intrinsics.checkNotNullParameter(context, "context");
            Logger.INSTANCE.m699d(TAG, "requestConnect");
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] not authorized");
                return KGResult.INSTANCE.getResult(3002, "not authorized");
            }
            if (CoreManager.INSTANCE.getInstance().isPaused()) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] app paused");
                return KGResult.INSTANCE.getResult(4002, "app is paused");
            }
            if (manager == null) {
                KGResult<Void> initWebsocket = initWebsocket();
                if (!initWebsocket.isSuccess()) {
                    return KGResult.INSTANCE.getResult(initWebsocket);
                }
            }
            WebSocketManager webSocketManager = manager;
            Intrinsics.checkNotNull(webSocketManager);
            if (webSocketManager.isConnected()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            if (!NetworkUtil.INSTANCE.isNetworkConnected(context)) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] network is not connected");
                return KGResult.INSTANCE.getResult(1001);
            }
            String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
            if (TextUtils.isEmpty(playerId)) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] player id is null");
                return KGResult.INSTANCE.getResult(3002, "player id is null");
            }
            String accessToken = CoreManager.INSTANCE.getInstance().getAccessToken();
            if (TextUtils.isEmpty(accessToken)) {
                Logger.INSTANCE.m701e(TAG, "[requestConnect] zat is null");
                return KGResult.INSTANCE.getResult(3002, "zat is null");
            }
            ServerRequest serverRequest = new ServerRequest(CONNECT_REQUETS_URI);
            Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration);
            serverRequest.putBody("appId", configuration.getAppId());
            Configuration configuration2 = CoreManager.INSTANCE.getInstance().getConfiguration();
            Intrinsics.checkNotNull(configuration2);
            serverRequest.putBody("appSecret", configuration2.getAppSecret());
            serverRequest.putBody("playerId", playerId);
            serverRequest.putBody(ServerConstants.ZAT, accessToken);
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            Logger.INSTANCE.m699d(TAG, str + serverRequest);
            WebSocketManager webSocketManager2 = manager;
            Intrinsics.checkNotNull(webSocketManager2);
            KeyBaseResult<ServerResult> connect = webSocketManager2.connect(serverRequest, sessionTimeout);
            if (!connect.isSuccess()) {
                return KGResult.INSTANCE.getResult(connect);
            }
            GamePresenceService.startPing();
            return KGResult.INSTANCE.getSuccessResult();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerResult requestSession(Context context, ServerRequest request) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576715966) + request;
        String str2 = y.ۮڭڭܬި(862637403);
        logger.m699d(str2, str);
        ServerResult requestSessionImpl = requestSessionImpl(context, request);
        if (requestSessionImpl.getCode() == 2004) {
            do {
                Logger.INSTANCE.m708w(str2, y.֬ڱܱײٮ(-1158747975) + 1);
                request.putBody(y.֬ڱܱײٮ(-1158747223), true);
                long j = sessionRetryDelay;
                if (j > 0) {
                    try {
                        Thread.sleep(j);
                    } catch (Exception unused) {
                    }
                }
                requestSessionImpl = requestSessionImpl(context, request);
            } while (requestSessionImpl.getCode() == 2004);
        }
        return requestSessionImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ServerResult requestSessionImpl(Context context, ServerRequest request) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862639627) + request;
        String str2 = y.ۮڭڭܬި(862637403);
        logger.m699d(str2, str);
        NetworkUtil networkUtil = NetworkUtil.INSTANCE;
        Intrinsics.checkNotNull(context);
        if (!networkUtil.isNetworkConnected(context)) {
            Logger.INSTANCE.m701e(str2, "[requestSession] network is not connected");
            return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(1001));
        }
        if (!isConnected()) {
            KGResult<Void> requestConnect = requestConnect(context);
            if (!requestConnect.isSuccess()) {
                Logger.INSTANCE.m701e(str2, y.ݮڮֲڭܩ(-628454468) + requestConnect);
                return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(requestConnect));
            }
        }
        long timeout = request.getTimeout();
        if (timeout <= 0) {
            timeout = sessionTimeout;
        }
        WebSocketManager webSocketManager = manager;
        Intrinsics.checkNotNull(webSocketManager);
        return webSocketManager.send(request, timeout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestSessionWithoutResponse(Context context, ServerRequest request) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862637403), y.ٲٴݴ״ٰ(1782294544) + request);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GameSessionService$requestSessionWithoutResponse$1(context, request, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void ping() {
        WebSocketManager webSocketManager = manager;
        if (webSocketManager != null) {
            Intrinsics.checkNotNull(webSocketManager);
            webSocketManager.ping();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGameServerMessageListener(GameServerMessageListener listener) {
        gameServerMessageListener = listener;
    }
}
