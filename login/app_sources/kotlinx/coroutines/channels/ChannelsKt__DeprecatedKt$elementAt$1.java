package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.addon.KGService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Deprecated.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m855f = "Deprecated.kt", m856i = {0, 0, 0}, m857l = {38}, m858m = "elementAt", m859n = {"$this$consume$iv", FirebaseAnalytics.Param.INDEX, KGService.COUNT}, m860s = {"L$0", "I$0", "I$1"})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> continuation) {
        super(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object elementAt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        elementAt = ChannelsKt__DeprecatedKt.elementAt(null, 0, this);
        return elementAt;
    }
}
