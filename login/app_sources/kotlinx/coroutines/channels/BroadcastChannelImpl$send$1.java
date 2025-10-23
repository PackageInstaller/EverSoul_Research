package kotlinx.coroutines.channels;

import com.kakao.sdk.share.Constants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BroadcastChannel.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.BroadcastChannelImpl", m855f = "BroadcastChannel.kt", m856i = {0, 0}, m857l = {230}, m858m = Constants.TALK_SHARE_AUTHORITY, m859n = {"this", "element"}, m860s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class BroadcastChannelImpl$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BroadcastChannelImpl<E> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BroadcastChannelImpl$send$1(BroadcastChannelImpl<E> broadcastChannelImpl, Continuation<? super BroadcastChannelImpl$send$1> continuation) {
        super(continuation);
        this.this$0 = broadcastChannelImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, this);
    }
}
