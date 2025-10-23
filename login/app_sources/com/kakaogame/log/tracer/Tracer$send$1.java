package com.kakaogame.log.tracer;

import android.util.Log;
import com.kakaogame.KGResult;
import com.kakaogame.log.service.TracerService;
import com.liapp.y;
import java.util.LinkedList;
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
@DebugMetadata(m854c = "com.kakaogame.log.tracer.Tracer$send$1", m855f = "Tracer.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class Tracer$send$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Tracer$send$1(Continuation<? super Tracer$send$1> continuation) {
        super(2, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Tracer$send$1(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Tracer$send$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Trace trace;
        String str;
        LinkedList linkedList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            trace = Tracer.INSTANCE.getTrace();
            if (trace != null) {
                TracerService tracerService = TracerService.INSTANCE;
                str = Tracer.traceId;
                KGResult<Void> sendTrace = tracerService.sendTrace(str, trace);
                boolean isNotSuccess = sendTrace.isNotSuccess();
                String str2 = y.ٴسسݬߨ(1393493874);
                if (isNotSuccess) {
                    Log.d(str2, y.ݮڮֲڭܩ(-628411436));
                    Tracer.INSTANCE.sendFailure(trace);
                }
                Tracer.INSTANCE.sendCompleted();
                if (sendTrace.isSuccess()) {
                    linkedList = Tracer.requestQueue;
                    if (linkedList.size() > 0) {
                        Log.d(str2, "--- Send Next");
                        Tracer.INSTANCE.send();
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
    }
}
