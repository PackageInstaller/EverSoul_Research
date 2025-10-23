package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Deprecated.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m855f = "Deprecated.kt", m856i = {0, 0, 1, 1}, m857l = {487, 278}, m858m = "toChannel", m859n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, m860s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$toChannel$1<E, C extends SendChannel<? super E>> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChannelsKt__DeprecatedKt$toChannel$1(Continuation<? super ChannelsKt__DeprecatedKt$toChannel$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.toChannel(null, null, this);
    }
}
