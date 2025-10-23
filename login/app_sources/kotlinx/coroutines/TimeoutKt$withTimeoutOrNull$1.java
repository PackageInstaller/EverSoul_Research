package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Timeout.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.TimeoutKt", m855f = "Timeout.kt", m856i = {0, 0, 0}, m857l = {104}, m858m = "withTimeoutOrNull", m859n = {"block", "coroutine", "timeMillis"}, m860s = {"L$0", "L$1", "J$0"})
/* loaded from: classes3.dex */
final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TimeoutKt$withTimeoutOrNull$1(Continuation<? super TimeoutKt$withTimeoutOrNull$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TimeoutKt.withTimeoutOrNull(0L, null, this);
    }
}
