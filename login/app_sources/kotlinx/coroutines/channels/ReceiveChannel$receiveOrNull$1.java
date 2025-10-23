package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: Channel.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ReceiveChannel$DefaultImpls", m855f = "Channel.kt", m856i = {}, m857l = {372}, m858m = "receiveOrNull", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ReceiveChannel$receiveOrNull$1(Continuation<? super ReceiveChannel$receiveOrNull$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.DefaultImpls.receiveOrNull(null, this);
    }
}
