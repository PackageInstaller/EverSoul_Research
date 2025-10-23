package com.kakaogame.promotion;

import android.app.Activity;
import android.content.DialogInterface;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.promotion.EndingPromotionManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EndingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.EndingPromotionManager$showEndingPromotionPopup$1", m855f = "EndingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class EndingPromotionManager$showEndingPromotionPopup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<String> $callback;
    final /* synthetic */ KGPromotionData $promotion;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EndingPromotionManager$showEndingPromotionPopup$1(Activity activity, KGPromotionData kGPromotionData, KGResultCallback<String> kGResultCallback, Continuation<? super EndingPromotionManager$showEndingPromotionPopup$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$promotion = kGPromotionData;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EndingPromotionManager$showEndingPromotionPopup$1(this.$activity, this.$promotion, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EndingPromotionManager$showEndingPromotionPopup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        final EndingPromotionManager.EndingPopupDialog endingPopupDialog = new EndingPromotionManager.EndingPopupDialog(this.$activity, this.$promotion);
        final KGResultCallback<String> kGResultCallback = this.$callback;
        final Activity activity = this.$activity;
        endingPopupDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.promotion.EndingPromotionManager$showEndingPromotionPopup$1$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EndingPromotionManager$showEndingPromotionPopup$1.invokeSuspend$lambda$0(EndingPromotionManager.EndingPopupDialog.this, kGResultCallback, activity, dialogInterface);
            }
        });
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862660595);
        String str2 = y.ٴسسݬߨ(1393512226);
        logger.m699d(str2, str);
        try {
            endingPopupDialog.show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, y.ٴسسݬߨ(1393510498) + e, e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void invokeSuspend$lambda$0(EndingPromotionManager.EndingPopupDialog endingPopupDialog, KGResultCallback kGResultCallback, Activity activity, DialogInterface dialogInterface) {
        String clickLink = endingPopupDialog.getClickLink();
        String str = clickLink;
        if (!(str == null || str.length() == 0)) {
            EndingPromotionManager.INSTANCE.showClickLink(activity, clickLink, kGResultCallback);
            return;
        }
        KGResult successResult = KGResult.INSTANCE.getSuccessResult("");
        if (kGResultCallback != null) {
            kGResultCallback.onResult(successResult);
        }
    }
}
