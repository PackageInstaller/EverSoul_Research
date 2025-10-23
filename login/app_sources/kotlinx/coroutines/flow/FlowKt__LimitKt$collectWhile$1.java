package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Limit.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
@DebugMetadata(m854c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m855f = "Limit.kt", m856i = {0}, m857l = {136}, m858m = "collectWhile", m859n = {"collector"}, m860s = {"L$0"})
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FlowKt__LimitKt$collectWhile$1(Continuation<? super FlowKt__LimitKt$collectWhile$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FlowKt__LimitKt.collectWhile(null, null, this);
    }
}
