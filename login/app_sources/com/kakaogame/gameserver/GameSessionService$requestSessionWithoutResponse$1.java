package com.kakaogame.gameserver;

import android.content.Context;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.session.WebSocketManager;
import com.kakaogame.util.NetworkUtil;
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

/* compiled from: GameSessionService.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.gameserver.GameSessionService$requestSessionWithoutResponse$1", m855f = "GameSessionService.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class GameSessionService$requestSessionWithoutResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ServerRequest $request;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GameSessionService$requestSessionWithoutResponse$1(Context context, ServerRequest serverRequest, Continuation<? super GameSessionService$requestSessionWithoutResponse$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$request = serverRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameSessionService$requestSessionWithoutResponse$1(this.$context, this.$request, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GameSessionService$requestSessionWithoutResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WebSocketManager webSocketManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        NetworkUtil networkUtil = NetworkUtil.INSTANCE;
        Context context = this.$context;
        Intrinsics.checkNotNull(context);
        boolean isNetworkConnected = networkUtil.isNetworkConnected(context);
        String str = y.ۮڭڭܬި(862637403);
        if (!isNetworkConnected) {
            Logger.INSTANCE.m701e(str, y.֬ڱܱײٮ(-1158743327));
            return Unit.INSTANCE;
        }
        if (!GameSessionService.INSTANCE.isConnected()) {
            KGResult<Void> requestConnect = GameSessionService.INSTANCE.requestConnect(this.$context);
            if (!requestConnect.isSuccess()) {
                Logger.INSTANCE.m701e(str, y.ٲٴݴ״ٰ(1782300344) + requestConnect);
                return Unit.INSTANCE;
            }
        }
        long timeout = this.$request.getTimeout();
        if (timeout <= 0) {
            timeout = GameSessionService.sessionTimeout;
        }
        webSocketManager = GameSessionService.manager;
        Intrinsics.checkNotNull(webSocketManager);
        webSocketManager.sendWithoutResponse(this.$request, timeout);
        return Unit.INSTANCE;
    }
}
