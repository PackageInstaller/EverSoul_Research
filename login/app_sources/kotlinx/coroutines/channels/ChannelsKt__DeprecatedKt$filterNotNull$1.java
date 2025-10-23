package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Deprecated.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "E", "", "it"}, m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
@DebugMetadata(m854c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", m855f = "Deprecated.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ChannelsKt__DeprecatedKt$filterNotNull$1<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ChannelsKt__DeprecatedKt$filterNotNull$1(Continuation<? super ChannelsKt__DeprecatedKt$filterNotNull$1> continuation) {
        super(2, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(continuation);
        channelsKt__DeprecatedKt$filterNotNull$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return invoke2((ChannelsKt__DeprecatedKt$filterNotNull$1<E>) obj, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(E e, Continuation<? super Boolean> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(this.L$0 != null);
    }
}
