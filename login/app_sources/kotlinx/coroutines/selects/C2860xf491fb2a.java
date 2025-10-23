package kotlinx.coroutines.selects;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Select.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.selects.SelectImplementation", m855f = "Select.kt", m856i = {}, m857l = {TypedValues.TransitionType.TYPE_STAGGERED}, m858m = "processResultAndInvokeBlockRecoveringException", m859n = {}, m860s = {})
/* renamed from: kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 */
/* loaded from: classes3.dex */
final class C2860xf491fb2a extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2860xf491fb2a(SelectImplementation<R> selectImplementation, Continuation<? super C2860xf491fb2a> continuation) {
        super(continuation);
        this.this$0 = selectImplementation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processResultAndInvokeBlockRecoveringException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processResultAndInvokeBlockRecoveringException = this.this$0.processResultAndInvokeBlockRecoveringException(null, null, this);
        return processResultAndInvokeBlockRecoveringException;
    }
}
