package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Channels.common.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", m855f = "Channels.common.kt", m856i = {0, 0}, m857l = {106}, m858m = "consumeEach", m859n = {"action", "$this$consume$iv"}, m860s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class ChannelsKt__Channels_commonKt$consumeEach$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChannelsKt__Channels_commonKt$consumeEach$1(Continuation<? super ChannelsKt__Channels_commonKt$consumeEach$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt__Channels_commonKt.consumeEach((ReceiveChannel) null, (Function1) null, this);
    }
}
