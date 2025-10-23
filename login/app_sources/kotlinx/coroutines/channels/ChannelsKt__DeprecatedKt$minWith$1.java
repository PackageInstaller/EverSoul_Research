package kotlinx.coroutines.channels;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deprecated.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m855f = "Deprecated.kt", m856i = {0, 0, 0, 1, 1, 1, 1}, m857l = {434, 436}, m858m = "minWith", m859n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", Base2ndPWViewData.KEY_MIN}, m860s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$minWith$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChannelsKt__DeprecatedKt$minWith$1(Continuation<? super ChannelsKt__DeprecatedKt$minWith$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object minWith;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        minWith = ChannelsKt__DeprecatedKt.minWith(null, null, this);
        return minWith;
    }
}
