package com.kakaogame.promotion;

import android.app.Dialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StartingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.StartingPromotionManager$showStartingPromotionPopupsInternal$3", m855f = "StartingPromotionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class StartingPromotionManager$showStartingPromotionPopupsInternal$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StartingPromotionManager$showStartingPromotionPopupsInternal$3(Continuation<? super StartingPromotionManager$showStartingPromotionPopupsInternal$3> continuation) {
        super(2, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartingPromotionManager$showStartingPromotionPopupsInternal$3(continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StartingPromotionManager$showStartingPromotionPopupsInternal$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Dialog dialog;
        Dialog dialog2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            dialog = StartingPromotionManager.bgDialog;
            if (dialog != null) {
                dialog2 = StartingPromotionManager.bgDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.dismiss();
                StartingPromotionManager startingPromotionManager = StartingPromotionManager.INSTANCE;
                StartingPromotionManager.bgDialog = null;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
    }
}
