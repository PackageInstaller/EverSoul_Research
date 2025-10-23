package com.kakaogame.promotion;

import android.app.Activity;
import com.kakaogame.Logger;
import com.kakaogame.promotion.StartingPromotionManager;
import com.kakaogame.promotion.view.StartingPromotionDialog;
import com.kakaogame.util.MutexLock;
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

/* compiled from: StartingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.StartingPromotionManager$showStartingPromotionPopupsInternal$2", m855f = "StartingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class StartingPromotionManager$showStartingPromotionPopupsInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ MutexLock<String> $dismissLock;
    final /* synthetic */ KGPromotionData $promotion;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StartingPromotionManager$showStartingPromotionPopupsInternal$2(KGPromotionData kGPromotionData, Activity activity, MutexLock<String> mutexLock, Continuation<? super StartingPromotionManager$showStartingPromotionPopupsInternal$2> continuation) {
        super(2, continuation);
        this.$promotion = kGPromotionData;
        this.$activity = activity;
        this.$dismissLock = mutexLock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartingPromotionManager$showStartingPromotionPopupsInternal$2(this.$promotion, this.$activity, this.$dismissLock, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StartingPromotionManager$showStartingPromotionPopupsInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159150407) + this.$promotion;
        String str2 = y.ݬֲ֮ܲت(1512157999);
        logger.m699d(str2, str);
        try {
            final MutexLock<String> mutexLock = this.$dismissLock;
            final Activity activity = this.$activity;
            final KGPromotionData kGPromotionData = this.$promotion;
            new StartingPromotionDialog(this.$activity, this.$promotion, new StartingPromotionDialog.StartingPromotionDialogListener() { // from class: com.kakaogame.promotion.StartingPromotionManager$showStartingPromotionPopupsInternal$2$callback$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.promotion.view.StartingPromotionDialog.StartingPromotionDialogListener
                public void onDismiss() {
                    mutexLock.setContent("");
                    mutexLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.promotion.view.StartingPromotionDialog.StartingPromotionDialogListener
                public void onCheckClicked() {
                    StartingPromotionManager.HidePrefManager.INSTANCE.saveHideDate(activity, kGPromotionData.getSequence());
                    mutexLock.setContent("");
                    mutexLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.promotion.view.StartingPromotionDialog.StartingPromotionDialogListener
                public void onImageLinkClicked(String clickLink) {
                    mutexLock.setContent(clickLink);
                    mutexLock.unlock();
                }
            }).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, y.ٴسسݬߨ(1393510498) + e, e);
            this.$dismissLock.unlock();
        }
        return Unit.INSTANCE;
    }
}
