package com.kakaogame.session;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.sdk.share.Constants;
import com.kakaogame.Logger;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.session.websocket.WebSocketClient;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WebSocketManager.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\"#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J \u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m839d2 = {"Lcom/kakaogame/session/WebSocketManager;", "", "serverUrl", "", "serverCategory", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "isConnected", "", "()Z", "lock", "webSocket", "Lcom/kakaogame/session/websocket/WebSocketClient;", "webSocketListener", "Lcom/kakaogame/session/WebSocketManager$WebSocketListenerImpl;", "websocketEventListener", "Lcom/kakaogame/session/WebSocketManager$WebSocketEventListener;", "connect", "Lcom/kakaogame/server/KeyBaseResult;", "Lcom/kakaogame/server/ServerResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "timeout", "", "connectInternal", "disconnect", "", "ping", Constants.TALK_SHARE_AUTHORITY, "sendInternal", "sendWithoutResponse", "setSessionUrl", "setWebsocketListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "WebSocketEventListener", "WebSocketListenerImpl", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class WebSocketManager {
    private String TAG;
    private final Object lock;
    private final String serverCategory;
    private String serverUrl;
    private WebSocketClient webSocket;
    private WebSocketListenerImpl webSocketListener;
    private WebSocketEventListener websocketEventListener;

    /* compiled from: WebSocketManager.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/session/WebSocketManager$WebSocketEventListener;", "", "onConnect", "", "onDisconnect", "onServerMessage", "response", "Lcom/kakaogame/server/ServerResponse;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface WebSocketEventListener {
        void onConnect();

        void onDisconnect();

        void onServerMessage(ServerResponse response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebSocketManager(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, y.ݬֲ֮ܲت(1512110687));
        Intrinsics.checkNotNullParameter(str2, y.ٲٴݴ״ٰ(1782368768));
        this.TAG = y.ٲٴݴ״ٰ(1782369544);
        this.lock = new Object();
        this.TAG += ':' + str2;
        Logger.INSTANCE.m704i(this.TAG, y.ٴسسݬߨ(1393152754) + str);
        this.serverUrl = str;
        this.serverCategory = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSessionUrl(String serverUrl) {
        Intrinsics.checkNotNullParameter(serverUrl, y.ݬֲ֮ܲت(1512110687));
        Logger.INSTANCE.m704i(this.TAG, y.ݬֲ֮ܲت(1512047335) + serverUrl);
        this.serverUrl = serverUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setWebsocketListener(WebSocketEventListener listener) {
        this.websocketEventListener = listener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isConnected() {
        String str = y.ݮڮֲڭܩ(-628453444);
        try {
            WebSocketClient webSocketClient = this.webSocket;
            boolean isConnected = webSocketClient != null ? webSocketClient.isConnected() : false;
            Logger.INSTANCE.m699d(this.TAG, str + isConnected);
            return isConnected;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void disconnect() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebSocketManager$disconnect$1(this, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KeyBaseResult<ServerResult> connect(ServerRequest request, long timeout) {
        KeyBaseResult<ServerResult> connectInternal;
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger.INSTANCE.m699d(this.TAG, y.ٲٴݴ״ٰ(1782174440) + request + y.ݮڮֲڭܩ(-628756788) + timeout);
        try {
            synchronized (this.lock) {
                if (isConnected()) {
                    Logger.INSTANCE.m704i(this.TAG, "connect using connection");
                    connectInternal = KeyBaseResult.INSTANCE.getSuccessResult();
                } else {
                    connectInternal = connectInternal(request, timeout);
                }
            }
            return connectInternal;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
            disconnect();
            return KeyBaseResult.INSTANCE.getResult(2002, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KeyBaseResult<ServerResult> connectInternal(ServerRequest request, long timeout) {
        Logger.INSTANCE.m699d(this.TAG, y.ٲٴݴ״ٰ(1782369280));
        String str = this.serverUrl + '?' + SessionUtil.getConnectParameter(request);
        Logger.INSTANCE.m699d(this.TAG, y.دײܮڳܯ(2051068397) + str);
        MutexLock createLock = MutexLock.INSTANCE.createLock();
        this.webSocketListener = new WebSocketListenerImpl(this, this.serverCategory, createLock);
        URI create = URI.create(str);
        Intrinsics.checkNotNullExpressionValue(create, y.ݮڮֲڭܩ(-628754148));
        WebSocketListenerImpl webSocketListenerImpl = this.webSocketListener;
        Intrinsics.checkNotNull(webSocketListenerImpl);
        this.webSocket = new WebSocketClient(create, webSocketListenerImpl, null);
        ArrayList<SyncServerRequest> arrayList = new ArrayList();
        WebSocketListenerImpl webSocketListenerImpl2 = this.webSocketListener;
        Intrinsics.checkNotNull(webSocketListenerImpl2);
        arrayList.add(new SyncServerRequest(request, webSocketListenerImpl2));
        long currentTimeMillis = System.currentTimeMillis() + timeout;
        long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
        WebSocketClient webSocketClient = this.webSocket;
        Intrinsics.checkNotNull(webSocketClient);
        webSocketClient.connect();
        createLock.lock(currentTimeMillis2);
        KeyBaseResult keyBaseResult = (KeyBaseResult) createLock.getContent();
        if (keyBaseResult == null) {
            Logger.INSTANCE.m699d(this.TAG, y.ٴسسݬߨ(1393110218) + System.currentTimeMillis() + y.ݮڮֲڭܩ(-628756788) + currentTimeMillis);
            if (System.currentTimeMillis() >= currentTimeMillis) {
                return KeyBaseResult.INSTANCE.getResult(2001);
            }
            return KeyBaseResult.INSTANCE.getResult(2004);
        }
        if (!keyBaseResult.isSuccess()) {
            return KeyBaseResult.INSTANCE.getResult(keyBaseResult);
        }
        ServerResult serverResult = null;
        for (SyncServerRequest syncServerRequest : arrayList) {
            long currentTimeMillis3 = currentTimeMillis - System.currentTimeMillis();
            if (currentTimeMillis3 <= 0) {
                Logger.INSTANCE.m699d(this.TAG, y.٬ݯح׭٩(576383342));
                return KeyBaseResult.INSTANCE.getResult(2001);
            }
            serverResult = syncServerRequest.getSessionResponse(currentTimeMillis3);
            Logger.INSTANCE.m699d(this.TAG, y.ݮڮֲڭܩ(-628286852) + serverResult.getCode());
            if (!serverResult.isSuccess() && serverResult.getCode() == 2001) {
                return KeyBaseResult.INSTANCE.getResult(serverResult);
            }
        }
        return KeyBaseResult.INSTANCE.getSuccessResult(null, serverResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerResult send(ServerRequest request, long timeout) {
        ServerResult sendInternal;
        String str = y.ۮڭڭܬި(862799587);
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        Logger.INSTANCE.m699d(this.TAG, y.ݬֲ֮ܲت(1512047567) + request.getRequestUri());
        try {
            synchronized (this.lock) {
                sendInternal = sendInternal(request, timeout);
                Logger.INSTANCE.m699d(this.TAG, str + sendInternal);
                int code = sendInternal.getCode();
                if (code == 401) {
                    disconnect();
                } else if (code == 2001 && !request.isIgnoreTimeout()) {
                    disconnect();
                }
            }
            return sendInternal;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
            return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(2002, e.toString()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ServerResult sendInternal(ServerRequest request, long timeout) {
        Logger.INSTANCE.m706v(this.TAG, y.ٲٴݴ״ٰ(1782329376));
        if (this.webSocketListener == null) {
            return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(2004), request);
        }
        WebSocketListenerImpl webSocketListenerImpl = this.webSocketListener;
        Intrinsics.checkNotNull(webSocketListenerImpl);
        SyncServerRequest syncServerRequest = new SyncServerRequest(request, webSocketListenerImpl);
        WebSocketClient webSocketClient = this.webSocket;
        if (webSocketClient != null) {
            webSocketClient.send(request.getRequestMessage());
        }
        return syncServerRequest.getSessionResponse(timeout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendWithoutResponse(ServerRequest request, long timeout) {
        Intrinsics.checkNotNullParameter(request, "request");
        Logger.INSTANCE.m699d(this.TAG, y.ٲٴݴ״ٰ(1782331264));
        try {
            WebSocketClient webSocketClient = this.webSocket;
            Intrinsics.checkNotNull(webSocketClient);
            webSocketClient.send(request.getRequestMessage());
        } catch (Exception e) {
            Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void ping() {
        Logger.INSTANCE.m699d(this.TAG, y.ۮڭڭܬި(862799507));
        try {
            WebSocketClient webSocketClient = this.webSocket;
            Intrinsics.checkNotNull(webSocketClient);
            webSocketClient.ping();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
        }
    }

    /* compiled from: WebSocketManager.kt */
    @Metadata(m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0010J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u000e\u0010\u001b\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m839d2 = {"Lcom/kakaogame/session/WebSocketManager$WebSocketListenerImpl;", "Lcom/kakaogame/session/websocket/WebSocketClient$Listener;", "serverCategory", "", "lock", "Lcom/kakaogame/util/MutexLock;", "Lcom/kakaogame/server/KeyBaseResult;", "Ljava/lang/Void;", "(Lcom/kakaogame/session/WebSocketManager;Ljava/lang/String;Lcom/kakaogame/util/MutexLock;)V", "TAG", "connectLock", "syncRequestMap", "", "", "Lcom/kakaogame/session/SyncServerRequest;", "addRequest", "", "request", "clearRequests", "handleResponse", "response", "Lcom/kakaogame/server/ServerResponse;", "onConnect", "onDisconnect", "code", "reason", "onError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onMessage", "data", "", "message", "removeRequest", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public final class WebSocketListenerImpl implements WebSocketClient.Listener {
        private String TAG;
        private final MutexLock<KeyBaseResult<Void>> connectLock;
        private final Map<Integer, SyncServerRequest> syncRequestMap;
        final /* synthetic */ WebSocketManager this$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebSocketListenerImpl(WebSocketManager webSocketManager, String str, MutexLock<KeyBaseResult<Void>> mutexLock) {
            Intrinsics.checkNotNullParameter(str, y.ٲٴݴ״ٰ(1782368768));
            Intrinsics.checkNotNullParameter(mutexLock, y.ݬֲ֮ܲت(1512111631));
            this.this$0 = webSocketManager;
            this.TAG = "WebSocketListenerImpl";
            this.syncRequestMap = new LinkedHashMap();
            this.TAG += ':' + str;
            this.connectLock = mutexLock;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.session.websocket.WebSocketClient.Listener
        public void onConnect() {
            Logger logger = Logger.INSTANCE;
            String str = this.TAG;
            String str2 = y.ٴسسݬߨ(1393468754);
            logger.m699d(str, str2);
            try {
                WebSocketEventListener webSocketEventListener = this.this$0.websocketEventListener;
                if (webSocketEventListener != null) {
                    webSocketEventListener.onConnect();
                }
                if (this.connectLock.isLock()) {
                    this.connectLock.setContent(KeyBaseResult.INSTANCE.getSuccessResult());
                    this.connectLock.unlock();
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, str2, e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.session.websocket.WebSocketClient.Listener
        public void onMessage(String message) {
            Logger.INSTANCE.m706v(this.TAG, y.ۮڭڭܬި(862828843) + message);
            try {
                ServerResponse response = ServerResponse.INSTANCE.getResponse(message);
                if (response != null) {
                    handleResponse(response);
                } else {
                    Logger.INSTANCE.m701e(this.TAG, "onMessage(String) : server response is null");
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, y.ݬֲ֮ܲت(1512110943), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.session.websocket.WebSocketClient.Listener
        public void onMessage(byte[] data) {
            Logger.INSTANCE.m699d(this.TAG, y.֬ڱܱײٮ(-1159099359) + data);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.session.websocket.WebSocketClient.Listener
        public void onDisconnect(int code, String reason) {
            Logger.INSTANCE.m699d(this.TAG, y.ۮڭڭܬި(862830179) + code + y.ݮڮֲڭܩ(-628756788) + reason);
            try {
                WebSocketEventListener webSocketEventListener = this.this$0.websocketEventListener;
                if (webSocketEventListener != null) {
                    webSocketEventListener.onDisconnect();
                }
                if (this.connectLock.isLock()) {
                    KeyBaseResult.Companion companion = KeyBaseResult.INSTANCE;
                    Intrinsics.checkNotNull(reason);
                    this.connectLock.setContent(companion.getResult(code, reason));
                    this.connectLock.unlock();
                }
                clearRequests();
                Object obj = this.this$0.lock;
                WebSocketManager webSocketManager = this.this$0;
                synchronized (obj) {
                    if (webSocketManager.webSocketListener == this) {
                        webSocketManager.webSocket = null;
                        webSocketManager.webSocketListener = null;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, y.٬ݯح׭٩(576545110), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.session.websocket.WebSocketClient.Listener
        public void onError(Exception error) {
            Logger.INSTANCE.m709w(this.TAG, y.ۮڭڭܬި(862342763) + error, error);
            try {
                if (this.this$0.webSocket != null) {
                    WebSocketClient webSocketClient = this.this$0.webSocket;
                    Intrinsics.checkNotNull(webSocketClient);
                    if (webSocketClient.isConnected()) {
                        this.this$0.disconnect();
                    }
                }
                if (this.connectLock.isLock()) {
                    this.connectLock.setContent(KeyBaseResult.INSTANCE.getResult(2002, String.valueOf(error)));
                    this.connectLock.unlock();
                }
                clearRequests();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, y.ٲٴݴ״ٰ(1782368448), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clearRequests() {
            synchronized (this.syncRequestMap) {
                Iterator<SyncServerRequest> it = this.syncRequestMap.values().iterator();
                while (it.hasNext()) {
                    it.next().setSessionResponse(null);
                }
                this.syncRequestMap.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void addRequest(SyncServerRequest request) {
            Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
            synchronized (this.syncRequestMap) {
                this.syncRequestMap.put(Integer.valueOf(request.getTransactionNo()), request);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void removeRequest(SyncServerRequest request) {
            Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
            synchronized (this.syncRequestMap) {
                this.syncRequestMap.remove(Integer.valueOf(request.getTransactionNo()));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void handleResponse(ServerResponse response) {
            String str = y.ۮڭڭܬި(862829811);
            if (response == null) {
                return;
            }
            String requestUri = response.getRequestUri();
            Logger.INSTANCE.m699d(this.TAG, y.ݮڮֲڭܩ(-628235628) + requestUri);
            Map<Integer, SyncServerRequest> map = this.syncRequestMap;
            WebSocketManager webSocketManager = this.this$0;
            synchronized (map) {
                int transactionNo = response.getTransactionNo();
                SyncServerRequest syncServerRequest = this.syncRequestMap.get(Integer.valueOf(transactionNo));
                if (syncServerRequest != null && StringsKt.equals(syncServerRequest.getRequestUri(), requestUri, true)) {
                    this.syncRequestMap.remove(Integer.valueOf(transactionNo));
                    syncServerRequest.setSessionResponse(response);
                    Unit unit = Unit.INSTANCE;
                } else {
                    Logger.INSTANCE.m699d(this.TAG, str + transactionNo + " : " + response);
                    WebSocketEventListener webSocketEventListener = webSocketManager.websocketEventListener;
                    if (webSocketEventListener != null) {
                        webSocketEventListener.onServerMessage(response);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }
    }
}
