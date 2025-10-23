package com.kakaogame.session;

import com.kakaogame.Logger;
import com.kakaogame.session.websocket.WebSocketClient;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WebSocketManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.session.WebSocketManager$disconnect$1", m855f = "WebSocketManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class WebSocketManager$disconnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WebSocketManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WebSocketManager$disconnect$1(WebSocketManager webSocketManager, Continuation<? super WebSocketManager$disconnect$1> continuation) {
        super(2, continuation);
        this.this$0 = webSocketManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketManager$disconnect$1(this.this$0, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebSocketManager$disconnect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.this$0.lock;
            WebSocketManager webSocketManager = this.this$0;
            synchronized (obj2) {
                Logger logger = Logger.INSTANCE;
                str = webSocketManager.TAG;
                logger.m704i(str, "disconnect");
                try {
                    try {
                        if (webSocketManager.isConnected()) {
                            WebSocketClient webSocketClient = webSocketManager.webSocket;
                            Intrinsics.checkNotNull(webSocketClient);
                            webSocketClient.disconnect();
                        }
                        webSocketManager.webSocket = null;
                    } catch (Exception e) {
                        Logger logger2 = Logger.INSTANCE;
                        str2 = webSocketManager.TAG;
                        logger2.m702e(str2, e.toString(), e);
                        webSocketManager.webSocket = null;
                    }
                    webSocketManager.webSocketListener = null;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    webSocketManager.webSocket = null;
                    webSocketManager.webSocketListener = null;
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
    }
}
