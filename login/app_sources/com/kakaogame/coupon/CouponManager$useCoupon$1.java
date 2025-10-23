package com.kakaogame.coupon;

import android.app.Activity;
import android.app.Dialog;
import com.kakaogame.C2382R;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CouponManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.coupon.CouponManager$useCoupon$1", m855f = "CouponManager.kt", m856i = {}, m857l = {73}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class CouponManager$useCoupon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Function1<KGResult<Void>, Unit> $callback;
    final /* synthetic */ String $couponCode;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ CustomProgressDialog $progress;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CouponManager$useCoupon$1(String str, Activity activity, CustomProgressDialog customProgressDialog, Dialog dialog, Function1<? super KGResult<Void>, Unit> function1, Continuation<? super CouponManager$useCoupon$1> continuation) {
        super(2, continuation);
        this.$couponCode = str;
        this.$activity = activity;
        this.$progress = customProgressDialog;
        this.$dialog = dialog;
        this.$callback = function1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CouponManager$useCoupon$1(this.$couponCode, this.$activity, this.$progress, this.$dialog, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CouponManager$useCoupon$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult result = KGResult.INSTANCE.getResult(CouponService.useCoupon(this.$couponCode));
            Logger.INSTANCE.m699d(y.٬ݯح׭٩(576630830), y.ٲٴݴ״ٰ(1782080592) + result);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C24021(result, this.$activity, this.$progress, this.$dialog, this.$callback, null), this) == coroutine_suspended) {
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

    /* compiled from: CouponManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.coupon.CouponManager$useCoupon$1$1", m855f = "CouponManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.coupon.CouponManager$useCoupon$1$1 */
    static final class C24021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Function1<KGResult<Void>, Unit> $callback;
        final /* synthetic */ Dialog $dialog;
        final /* synthetic */ CustomProgressDialog $progress;
        final /* synthetic */ KGResult<Void> $useResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24021(KGResult<Void> kGResult, Activity activity, CustomProgressDialog customProgressDialog, Dialog dialog, Function1<? super KGResult<Void>, Unit> function1, Continuation<? super C24021> continuation) {
            super(2, continuation);
            this.$useResult = kGResult;
            this.$activity = activity;
            this.$progress = customProgressDialog;
            this.$dialog = dialog;
            this.$callback = function1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24021(this.$useResult, this.$activity, this.$progress, this.$dialog, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String errorMessage;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            if (!this.$useResult.isSuccess()) {
                errorMessage = CouponManager.INSTANCE.getErrorMessage(this.$activity, this.$useResult.getCode());
                DialogManager.showErrorDialog$default(DialogManager.INSTANCE, this.$activity, errorMessage, false, null, 12, null);
            } else {
                String string = ResourceUtil.getString(this.$activity, C2382R.string.zinny_sdk_coupon_success);
                DialogManager dialogManager = DialogManager.INSTANCE;
                Activity activity = this.$activity;
                final Dialog dialog = this.$dialog;
                final Function1<KGResult<Void>, Unit> function1 = this.$callback;
                final KGResult<Void> kGResult = this.$useResult;
                dialogManager.showDialog(activity, string, new Function1<Boolean, Unit>() { // from class: com.kakaogame.coupon.CouponManager.useCoupon.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public final void invoke(boolean z) {
                        dialog.dismiss();
                        function1.invoke(kGResult);
                    }
                });
            }
            this.$progress.dismiss();
            return Unit.INSTANCE;
        }
    }
}
