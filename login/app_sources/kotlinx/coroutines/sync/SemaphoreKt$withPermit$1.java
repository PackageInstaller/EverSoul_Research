package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Semaphore.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
@DebugMetadata(m854c = "kotlinx.coroutines.sync.SemaphoreKt", m855f = "Semaphore.kt", m856i = {0, 0}, m857l = {86}, m858m = "withPermit", m859n = {"$this$withPermit", "action"}, m860s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class SemaphoreKt$withPermit$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SemaphoreKt$withPermit$1(Continuation<? super SemaphoreKt$withPermit$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SemaphoreKt.withPermit(null, null, this);
    }
}
