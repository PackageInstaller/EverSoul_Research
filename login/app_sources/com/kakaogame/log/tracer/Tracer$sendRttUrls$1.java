package com.kakaogame.log.tracer;

import com.kakaogame.log.service.TracerService;
import com.kakaogame.server.KeyBaseResult;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Tracer.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.log.tracer.Tracer$sendRttUrls$1", m855f = "Tracer.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class Tracer$sendRttUrls$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $requestTime;
    final /* synthetic */ KeyBaseResult<Object> $result;
    final /* synthetic */ long $rtt;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Tracer$sendRttUrls$1(long j, long j2, KeyBaseResult<Object> keyBaseResult, String str, Continuation<? super Tracer$sendRttUrls$1> continuation) {
        super(2, continuation);
        this.$requestTime = j;
        this.$rtt = j2;
        this.$result = keyBaseResult;
        this.$url = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Tracer$sendRttUrls$1(this.$requestTime, this.$rtt, this.$result, this.$url, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Tracer$sendRttUrls$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        TracerService tracerService = TracerService.INSTANCE;
        str = Tracer.traceId;
        tracerService.sendTrace(str, new Trace(-1, y.دײܮڳܯ(2051408493), y.دײܮڳܯ(2051408493), this.$requestTime, this.$rtt, this.$result.getCode(), this.$result.getDescription(), this.$url));
        return Unit.INSTANCE;
    }
}
