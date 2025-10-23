package com.kakaogame.promotion;

import android.app.Activity;
import com.kakaogame.KGResultCallback;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EndingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1", m855f = "EndingPromotionManager.kt", m856i = {1}, m857l = {40, 49}, m858m = "invokeSuspend", m859n = {"result"}, m860s = {"L$0"})
/* loaded from: classes3.dex */
final class EndingPromotionManager$showEndingPromotions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<String> $callback;
    final /* synthetic */ Ref.ObjectRef<CustomProgressDialog> $progress;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EndingPromotionManager$showEndingPromotions$1(Activity activity, Ref.ObjectRef<CustomProgressDialog> objectRef, KGResultCallback<String> kGResultCallback, Continuation<? super EndingPromotionManager$showEndingPromotions$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$progress = objectRef;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EndingPromotionManager$showEndingPromotions$1(this.$activity, this.$progress, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EndingPromotionManager$showEndingPromotions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0087  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L28
            if (r1 == r3) goto L24
            if (r1 != r2) goto L17
            java.lang.Object r0 = r7.L$0
            com.kakaogame.KGResult r0 = (com.kakaogame.KGResult) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L81
        L17:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r0 = 1392608770(0x53018602, float:5.5629906E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            r8.<init>(r0)
            throw r8
        L24:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L28:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$1 r1 = new com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$1
            kotlin.jvm.internal.Ref$ObjectRef<com.kakaogame.ui.CustomProgressDialog> r5 = r7.$progress
            android.app.Activity r6 = r7.$activity
            r1.<init>(r5, r6, r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r5)
            if (r8 != r0) goto L48
            return r0
        L48:
            com.kakaogame.core.CoreManager$Companion r8 = com.kakaogame.core.CoreManager.INSTANCE
            com.kakaogame.core.CoreManager r8 = r8.getInstance()
            boolean r8 = r8.isAuthorized()
            if (r8 == 0) goto L5b
            com.kakaogame.promotion.KGPromotionData$Companion r8 = com.kakaogame.promotion.KGPromotionData.INSTANCE
            com.kakaogame.KGResult r8 = r8.loadEndingPromotion()
            goto L63
        L5b:
            com.kakaogame.KGResult$Companion r8 = com.kakaogame.KGResult.INSTANCE
            r1 = 3002(0xbba, float:4.207E-42)
            com.kakaogame.KGResult r8 = r8.getResult(r1)
        L63:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$2 r3 = new com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$2
            kotlin.jvm.internal.Ref$ObjectRef<com.kakaogame.ui.CustomProgressDialog> r5 = r7.$progress
            r3.<init>(r5, r4)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r5)
            if (r1 != r0) goto L80
            return r0
        L80:
            r0 = r8
        L81:
            boolean r8 = r0.isSuccess()
            if (r8 == 0) goto L8e
            java.lang.Object r8 = r0.getContent()
            r4 = r8
            com.kakaogame.promotion.KGPromotionData r4 = (com.kakaogame.promotion.KGPromotionData) r4
        L8e:
            com.kakaogame.promotion.EndingPromotionManager r8 = com.kakaogame.promotion.EndingPromotionManager.INSTANCE
            android.app.Activity r0 = r7.$activity
            com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$3 r1 = new com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$3
            com.kakaogame.KGResultCallback<java.lang.String> r2 = r7.$callback
            r1.<init>()
            com.kakaogame.KGResultCallback r1 = (com.kakaogame.KGResultCallback) r1
            com.kakaogame.promotion.EndingPromotionManager.access$showEndingPromotionPopup(r8, r0, r4, r1)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
            fill-array 0x00a2: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: EndingPromotionManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$1", m855f = "EndingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$1 */
    static final class C24291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Ref.ObjectRef<CustomProgressDialog> $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24291(Ref.ObjectRef<CustomProgressDialog> objectRef, Activity activity, Continuation<? super C24291> continuation) {
            super(2, continuation);
            this.$progress = objectRef;
            this.$activity = activity;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24291(this.$progress, this.$activity, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, com.kakaogame.ui.CustomProgressDialog] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            this.$progress.element = new CustomProgressDialog(this.$activity);
            CustomProgressDialog customProgressDialog = this.$progress.element;
            if (customProgressDialog == null) {
                return null;
            }
            customProgressDialog.show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: EndingPromotionManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$2", m855f = "EndingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.EndingPromotionManager$showEndingPromotions$1$2 */
    static final class C24302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<CustomProgressDialog> $progress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24302(Ref.ObjectRef<CustomProgressDialog> objectRef, Continuation<? super C24302> continuation) {
            super(2, continuation);
            this.$progress = objectRef;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24302(this.$progress, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            CustomProgressDialog customProgressDialog = this.$progress.element;
            if (customProgressDialog == null) {
                return null;
            }
            customProgressDialog.dismiss();
            return Unit.INSTANCE;
        }
    }
}
