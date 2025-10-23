package com.kakaogame.coupon;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.coupon.CouponManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CouponManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.coupon.CouponManager$showCouponPopup$2$1", m855f = "CouponManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class CouponManager$showCouponPopup$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<Void>> $cont;
    final /* synthetic */ FirebaseEvent $fbEvent;
    final /* synthetic */ Stopwatch $stopwatch;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CouponManager$showCouponPopup$2$1(Activity activity, Continuation<? super KGResult<Void>> continuation, FirebaseEvent firebaseEvent, Stopwatch stopwatch, Continuation<? super CouponManager$showCouponPopup$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$cont = continuation;
        this.$fbEvent = firebaseEvent;
        this.$stopwatch = stopwatch;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CouponManager$showCouponPopup$2$1(this.$activity, this.$cont, this.$fbEvent, this.$stopwatch, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CouponManager$showCouponPopup$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        Activity activity = this.$activity;
        final Continuation<KGResult<Void>> continuation = this.$cont;
        final FirebaseEvent firebaseEvent = this.$fbEvent;
        final Stopwatch stopwatch = this.$stopwatch;
        new CouponManager.CouponPopupDialog(activity, new Function1<KGResult<Void>, Unit>() { // from class: com.kakaogame.coupon.CouponManager$showCouponPopup$2$1$dialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KGResult<Void> kGResult) {
                invoke2(kGResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KGResult<Void> kGResult) {
                Intrinsics.checkNotNullParameter(kGResult, y.ٲٴݴ״ٰ(1782134480));
                Continuation<KGResult<Void>> continuation2 = continuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(kGResult));
                firebaseEvent.setResult(kGResult);
                stopwatch.stop();
                KGResultUtil.writeClientApiCall(stopwatch.getName(), kGResult, stopwatch.getDurationMs());
            }
        }).show();
        return Unit.INSTANCE;
    }
}
