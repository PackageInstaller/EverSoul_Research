package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.singular.sdk.internal.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BufferedChannel.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.BufferedChannel", m855f = "BufferedChannel.kt", m856i = {0, 0, 0, 0}, m857l = {3056}, m858m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", m859n = {"this", "segment", FirebaseAnalytics.Param.INDEX, Constants.REVENUE_AMOUNT_KEY}, m860s = {"L$0", "L$1", "I$0", "J$0"})
/* loaded from: classes3.dex */
final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BufferedChannel<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, Continuation<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> continuation) {
        super(continuation);
        this.this$0 = bufferedChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m2946receiveCatchingOnNoWaiterSuspendGKJJFZk;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m2946receiveCatchingOnNoWaiterSuspendGKJJFZk = this.this$0.m2946receiveCatchingOnNoWaiterSuspendGKJJFZk(null, 0, 0L, this);
        return m2946receiveCatchingOnNoWaiterSuspendGKJJFZk == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m2946receiveCatchingOnNoWaiterSuspendGKJJFZk : ChannelResult.m2953boximpl(m2946receiveCatchingOnNoWaiterSuspendGKJJFZk);
    }
}
