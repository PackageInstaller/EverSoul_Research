package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m838d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, m839d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 176)
/* loaded from: classes3.dex */
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    /* compiled from: Emitters.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2 */
    public static final class C28242<T> implements FlowCollector {
        final /* synthetic */ Function2 $predicate$inlined;
        final /* synthetic */ FlowCollector $this_unsafeFlow;

        /* compiled from: Emitters.kt */
        @Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 176)
        @DebugMetadata(m854c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", m855f = "Transform.kt", m856i = {0, 0}, m857l = {223, 223}, m858m = "emit", m859n = {"value", "$this$filter_u24lambda_u240"}, m860s = {"L$0", "L$1"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return C28242.this.emit(null, this);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public C28242(FlowCollector flowCollector, Function2 function2) {
            this.$this_unsafeFlow = flowCollector;
            this.$predicate$inlined = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.C28242.AnonymousClass1
                if (r0 == 0) goto L14
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.C28242.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1
                r0.<init>(r8)
            L19:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3f
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r8)
                goto L70
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L35:
                java.lang.Object r7 = r0.L$1
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                java.lang.Object r2 = r0.L$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5a
            L3f:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                r2 = r0
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                kotlin.jvm.functions.Function2 r2 = r6.$predicate$inlined
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r2 = r2.invoke(r7, r0)
                if (r2 != r1) goto L56
                return r1
            L56:
                r5 = r2
                r2 = r7
                r7 = r8
                r8 = r5
            L5a:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L70
                r8 = 0
                r0.L$0 = r8
                r0.L$1 = r8
                r0.label = r3
                java.lang.Object r7 = r7.emit(r2, r0)
                if (r7 != r1) goto L70
                return r1
            L70:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
                fill-array 0x0074: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.C28242.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Object emit$$forInline(Object obj, Continuation continuation) {
            InlineMarker.mark(4);
            new AnonymousClass1(continuation);
            InlineMarker.mark(5);
            FlowCollector flowCollector = this.$this_unsafeFlow;
            if (((Boolean) this.$predicate$inlined.invoke(obj, continuation)).booleanValue()) {
                InlineMarker.mark(0);
                flowCollector.emit(obj, continuation);
                InlineMarker.mark(1);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = flow;
        this.$predicate$inlined = function2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new C28242(flowCollector, this.$predicate$inlined), continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.1
            int label;
            /* synthetic */ Object result;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.this.collect(null, this);
            }
        };
        InlineMarker.mark(5);
        Flow flow = this.$this_unsafeTransform$inlined;
        C28242 c28242 = new C28242(flowCollector, this.$predicate$inlined);
        InlineMarker.mark(0);
        flow.collect(c28242, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
