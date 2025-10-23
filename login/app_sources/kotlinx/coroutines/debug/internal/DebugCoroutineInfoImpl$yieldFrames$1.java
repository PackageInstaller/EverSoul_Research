package kotlinx.coroutines.debug.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugCoroutineInfoImpl.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", m855f = "DebugCoroutineInfoImpl.kt", m856i = {0, 0, 0}, m857l = {163}, m858m = "yieldFrames", m859n = {"this", "$this$yieldFrames", TypedValues.AttributesType.S_FRAME}, m860s = {"L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, Continuation<? super DebugCoroutineInfoImpl$yieldFrames$1> continuation) {
        super(continuation);
        this.this$0 = debugCoroutineInfoImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object yieldFrames;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        yieldFrames = this.this$0.yieldFrames(null, null, this);
        return yieldFrames;
    }
}
