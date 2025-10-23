package com.kakaogame.promotion;

import android.app.Activity;
import android.content.DialogInterface;
import com.kakaogame.KGResult;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.promotion.EndingPromotionManager;
import com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$handleClick$1$1;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EndingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$handleClick$1$1", m855f = "EndingPromotionManager.kt", m856i = {}, m857l = {131}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class EndingPromotionManager$EndingPopupDialog$handleClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $applyClick;
    final /* synthetic */ CustomProgressDialog $progress;
    final /* synthetic */ KGPromotionData $promotion;
    int label;
    final /* synthetic */ EndingPromotionManager.EndingPopupDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EndingPromotionManager$EndingPopupDialog$handleClick$1$1(boolean z, KGPromotionData kGPromotionData, CustomProgressDialog customProgressDialog, EndingPromotionManager.EndingPopupDialog endingPopupDialog, Continuation<? super EndingPromotionManager$EndingPopupDialog$handleClick$1$1> continuation) {
        super(2, continuation);
        this.$applyClick = z;
        this.$promotion = kGPromotionData;
        this.$progress = customProgressDialog;
        this.this$0 = endingPopupDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EndingPromotionManager$EndingPopupDialog$handleClick$1$1(this.$applyClick, this.$promotion, this.$progress, this.this$0, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EndingPromotionManager$EndingPopupDialog$handleClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult successResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$applyClick) {
                successResult = KGResult.INSTANCE.getResult(this.$promotion.apply());
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
            KGResult kGResult = successResult;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C24281(this.$applyClick, this.$progress, kGResult, this.$promotion, this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: EndingPromotionManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$handleClick$1$1$1", m855f = "EndingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$handleClick$1$1$1 */
    static final class C24281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $applyClick;
        final /* synthetic */ CustomProgressDialog $progress;
        final /* synthetic */ KGPromotionData $promotion;
        final /* synthetic */ KGResult<Void> $result;
        int label;
        final /* synthetic */ EndingPromotionManager.EndingPopupDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24281(boolean z, CustomProgressDialog customProgressDialog, KGResult<Void> kGResult, KGPromotionData kGPromotionData, EndingPromotionManager.EndingPopupDialog endingPopupDialog, Continuation<? super C24281> continuation) {
            super(2, continuation);
            this.$applyClick = z;
            this.$progress = customProgressDialog;
            this.$result = kGResult;
            this.$promotion = kGPromotionData;
            this.this$0 = endingPopupDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void invokeSuspend$lambda$0(DialogInterface dialogInterface) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24281(this.$applyClick, this.$progress, this.$result, this.$promotion, this.this$0, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Activity activity;
            Activity activity2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            if (this.$applyClick) {
                this.$progress.dismiss();
            }
            if (this.$result.isSuccess()) {
                String linkUrl = this.$promotion.getLinkUrl();
                if (!(linkUrl == null || linkUrl.length() == 0)) {
                    this.this$0.setClickLink(this.$promotion.getLinkUrl());
                    this.this$0.dismiss();
                }
            } else {
                StartingPromotionManager startingPromotionManager = StartingPromotionManager.INSTANCE;
                activity = this.this$0.activity;
                String errorMessage = startingPromotionManager.getErrorMessage(activity, this.$result.getCode());
                DialogManager dialogManager = DialogManager.INSTANCE;
                activity2 = this.this$0.activity;
                dialogManager.showErrorDialog(activity2, errorMessage, false, new DialogInterface.OnDismissListener() { // from class: com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$handleClick$1$1$1$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        EndingPromotionManager$EndingPopupDialog$handleClick$1$1.C24281.invokeSuspend$lambda$0(dialogInterface);
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }
}
