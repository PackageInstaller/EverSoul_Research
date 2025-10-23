package com.kakaogame.session;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.Logger;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.session.WebSocketManager;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncServerRequest.kt */
@Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\nR\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/session/SyncServerRequest;", "", "request", "Lcom/kakaogame/server/ServerRequest;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/session/WebSocketManager$WebSocketListenerImpl;", "Lcom/kakaogame/session/WebSocketManager;", "(Lcom/kakaogame/server/ServerRequest;Lcom/kakaogame/session/WebSocketManager$WebSocketListenerImpl;)V", "lock", "Lcom/kakaogame/util/MutexLock;", "Lcom/kakaogame/server/ServerResponse;", "requestUri", "", "getRequestUri", "()Ljava/lang/String;", "transactionNo", "", "getTransactionNo", "()I", "getSessionResponse", "Lcom/kakaogame/server/ServerResult;", "timeout", "", "setSessionResponse", "", "response", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SyncServerRequest {
    private static final String TAG = "SyncServerRequest";
    private final WebSocketManager.WebSocketListenerImpl listener;
    private final MutexLock<ServerResponse> lock;
    private final ServerRequest request;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SyncServerRequest(ServerRequest serverRequest, WebSocketManager.WebSocketListenerImpl webSocketListenerImpl) {
        Intrinsics.checkNotNullParameter(serverRequest, y.٬ݯح׭٩(575820214));
        Intrinsics.checkNotNullParameter(webSocketListenerImpl, y.٬ݯح׭٩(575816662));
        this.request = serverRequest;
        this.listener = webSocketListenerImpl;
        this.lock = MutexLock.INSTANCE.createLock();
        webSocketListenerImpl.addRequest(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTransactionNo() {
        return this.request.getTransactionNo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRequestUri() {
        return this.request.getRequestUri();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerResult getSessionResponse(long timeout) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628232892) + timeout;
        String str2 = y.ٴسسݬߨ(1393154474);
        logger.m706v(str2, str);
        this.lock.lock(timeout);
        ServerResponse content = this.lock.getContent();
        Logger.INSTANCE.m706v(str2, y.֬ڱܱײٮ(-1159100495) + content);
        this.listener.removeRequest(this);
        if (content == null) {
            Logger.INSTANCE.m701e(str2, y.֬ڱܱײٮ(-1159100847) + this.request + y.ݮڮֲڭܩ(-628756788) + this.lock.isTimeout());
            if (this.lock.isTimeout()) {
                return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(2001), this.request);
            }
            return ServerResult.INSTANCE.getServerErrorResult(KeyBaseResult.INSTANCE.getResult(2004), this.request);
        }
        return ServerResult.INSTANCE.getServerResult(this.request, content);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSessionResponse(ServerResponse response) {
        Logger.INSTANCE.m706v(y.ٴسسݬߨ(1393154474), y.ݮڮֲڭܩ(-628236236) + response);
        this.lock.setContent(response);
        this.lock.unlock();
    }
}
