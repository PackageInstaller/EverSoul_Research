package com.kakaogame.coupon;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.C0047R;
import com.kakaogame.C2382R;
import com.kakaogame.KGCoupon;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.coupon.CouponManager;
import com.kakaogame.databinding.ZinnySdkCouponPopupBinding;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CouponManager.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0087@¢\u0006\u0002\u0010\u000fJ<\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0004\u0012\u00020\u00110\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/coupon/CouponManager;", "", "()V", "TAG", "", "getErrorMessage", "context", "Landroid/content/Context;", "code", "", "showCouponPopup", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useCoupon", "", "couponCode", "dialog", "Landroid/app/Dialog;", "callback", "Lkotlin/Function1;", "CouponPopupDialog", "CouponResultCode", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CouponManager {
    public static final CouponManager INSTANCE = new CouponManager();
    private static final String TAG = "CouponManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CouponManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object showCouponPopup(Activity activity, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        try {
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.coupon)) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(5001)));
            }
            Stopwatch start = Stopwatch.INSTANCE.start("KGCoupon.showCouponPopup");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CouponManager$showCouponPopup$2$1(activity, safeContinuation2, FirebaseEvent.INSTANCE.getFirebaseEvent(KGCoupon.CLASS_NAME_KEY, "showCouponPopup"), start, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576630830), e.toString(), e);
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void useCoupon(Activity activity, String couponCode, Dialog dialog, Function1<? super KGResult<Void>, Unit> callback) {
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576630830), y.ݬֲ֮ܲت(1512333071) + couponCode);
        CustomProgressDialog customProgressDialog = new CustomProgressDialog(activity);
        customProgressDialog.show();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CouponManager$useCoupon$1(couponCode, activity, customProgressDialog, dialog, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorMessage(Context context, int code) {
        if (code == 403) {
            return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_invalid);
        }
        if (code == 469) {
            return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_ddos);
        }
        if (code != 503) {
            switch (code) {
                case 460:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_used);
                case 461:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_soldout);
                case 462:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_expired);
                case 463:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_exceed);
                case CouponResultCode.COUPON_NOT_OWNER /* 464 */:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_not_owner);
                case CouponResultCode.COUPON_IN_PROGRESSING /* 465 */:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_progress);
                default:
                    return ResourceUtil.getString(context, C2382R.string.zinny_sdk_error_msg_common, Integer.valueOf(code));
            }
        }
        return ResourceUtil.getString(context, C2382R.string.zinny_sdk_coupon_error_server);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CouponManager.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/coupon/CouponManager$CouponPopupDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class CouponPopupDialog extends Dialog {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CouponPopupDialog(final Activity activity, final Function1<? super KGResult<Void>, Unit> function1) {
            super(activity, C0047R.style.Base_AlertDialog_AppCompat);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(function1, y.֬ڱܱײٮ(-1159472767));
            requestWindowFeature(1);
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setFlags(1024, 1024);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.setBackgroundDrawable(new ColorDrawable(0));
            Window window3 = getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setSoftInputMode(4);
            Window window4 = getWindow();
            Intrinsics.checkNotNull(window4);
            window4.getAttributes().windowAnimations = R.style.Animation.Dialog;
            setCanceledOnTouchOutside(false);
            final ZinnySdkCouponPopupBinding inflate = ZinnySdkCouponPopupBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            inflate.zinnySdkCouponInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.kakaogame.coupon.CouponManager$CouponPopupDialog$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return CouponManager.CouponPopupDialog.lambda$4$lambda$0(ZinnySdkCouponPopupBinding.this, activity, this, function1, textView, i, keyEvent);
                }
            });
            setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.coupon.CouponManager$CouponPopupDialog$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    CouponManager.CouponPopupDialog.lambda$4$lambda$1(Function1.this, dialogInterface);
                }
            });
            inflate.zinnySdkCouponInputSubmit.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.coupon.CouponManager$CouponPopupDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CouponManager.CouponPopupDialog.lambda$4$lambda$2(ZinnySdkCouponPopupBinding.this, activity, this, function1, view);
                }
            });
            inflate.zinnySdkCouponInputCancel.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.coupon.CouponManager$CouponPopupDialog$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CouponManager.CouponPopupDialog.lambda$4$lambda$3(Function1.this, this, view);
                }
            });
            Window window5 = getWindow();
            Intrinsics.checkNotNull(window5);
            window5.addFlags(activity.getWindow().getAttributes().flags);
            if (Build.VERSION.SDK_INT >= 28) {
                Window window6 = getWindow();
                Intrinsics.checkNotNull(window6);
                window6.getAttributes().layoutInDisplayCutoutMode = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
            }
            setContentView(inflate.getRoot());
            DisplayUtil displayUtil = DisplayUtil.INSTANCE;
            Window window7 = getWindow();
            Intrinsics.checkNotNull(window7);
            displayUtil.setFullScreenView(activity, window7);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final boolean lambda$4$lambda$0(ZinnySdkCouponPopupBinding this_apply, Activity activity, CouponPopupDialog this$0, Function1 callback, TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            if (i != 6) {
                return false;
            }
            String obj = this_apply.zinnySdkCouponInputText.getText().toString();
            if (obj.length() > 0) {
                CouponManager.INSTANCE.useCoupon(activity, obj, this$0, callback);
            } else {
                DialogManager.showErrorDialog$default(DialogManager.INSTANCE, activity, ResourceUtil.getString(activity, C2382R.string.zinny_sdk_coupon_error_empty), false, null, 12, null);
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final void lambda$4$lambda$1(Function1 callback, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.invoke(KGResult.INSTANCE.getResult(9001));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final void lambda$4$lambda$2(ZinnySdkCouponPopupBinding this_apply, Activity activity, CouponPopupDialog this$0, Function1 callback, View view) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            String obj = this_apply.zinnySdkCouponInputText.getText().toString();
            if (obj.length() > 0) {
                CouponManager.INSTANCE.useCoupon(activity, obj, this$0, callback);
            } else {
                DialogManager.showErrorDialog$default(DialogManager.INSTANCE, activity, ResourceUtil.getString(activity, C2382R.string.zinny_sdk_coupon_error_empty), false, null, 12, null);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static final void lambda$4$lambda$3(Function1 callback, CouponPopupDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            callback.invoke(KGResult.INSTANCE.getResult(9001));
            this$0.dismiss();
        }
    }

    /* compiled from: CouponManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/coupon/CouponManager$CouponResultCode;", "", "()V", "COUPON_DDOS", "", "COUPON_EXCEED", "COUPON_EXPIRED", "COUPON_INVALID", "COUPON_IN_PROGRESSING", "COUPON_NOT_OWNER", "COUPON_SERVER_ERROR", "COUPON_SOLDOUT", "COUPON_USED", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class CouponResultCode {
        public static final int COUPON_DDOS = 469;
        public static final int COUPON_EXCEED = 463;
        public static final int COUPON_EXPIRED = 462;
        public static final int COUPON_INVALID = 403;
        public static final int COUPON_IN_PROGRESSING = 465;
        public static final int COUPON_NOT_OWNER = 464;
        public static final int COUPON_SERVER_ERROR = 503;
        public static final int COUPON_SOLDOUT = 461;
        public static final int COUPON_USED = 460;
        public static final CouponResultCode INSTANCE = new CouponResultCode();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CouponResultCode() {
        }
    }
}
