package com.kakaogame.secondpw;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import androidx.appcompat.C0047R;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.secondpw.viewdata.RestrictPopupViewData;
import com.kakaogame.security.C2558R;
import com.kakaogame.security.databinding.KakaoGame2ndPwRestrictViewBinding;
import com.liapp.y;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SecondPWRestrictViewDialog.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/secondpw/SecondPWRestrictViewDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "viewData", "Lcom/kakaogame/secondpw/viewdata/RestrictPopupViewData;", "callback", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Lcom/kakaogame/secondpw/viewdata/RestrictPopupViewData;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/kakaogame/security/databinding/KakaoGame2ndPwRestrictViewBinding;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "timer", "Ljava/util/Timer;", "getViewData", "()Lcom/kakaogame/secondpw/viewdata/RestrictPopupViewData;", "changeTime", "countDownSec", "", "closePopup", "onBackPressed", "startCountDownTimer", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SecondPWRestrictViewDialog extends Dialog {
    private final Activity activity;
    private final KakaoGame2ndPwRestrictViewBinding binding;
    private final Function0<Unit> callback;
    private Timer timer;
    private final RestrictPopupViewData viewData;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final RestrictPopupViewData getViewData() {
        return this.viewData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SecondPWRestrictViewDialog(Activity activity, RestrictPopupViewData restrictPopupViewData, Function0<Unit> function0) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(restrictPopupViewData, y.٬ݯح׭٩(576439206));
        Intrinsics.checkNotNullParameter(function0, y.֬ڱܱײٮ(-1159472767));
        this.activity = activity;
        this.viewData = restrictPopupViewData;
        this.callback = function0;
        KakaoGame2ndPwRestrictViewBinding inflate = KakaoGame2ndPwRestrictViewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
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
        Window window5 = getWindow();
        Intrinsics.checkNotNull(window5);
        window5.setNavigationBarColor(0);
        setCanceledOnTouchOutside(false);
        SpannableStringBuilder viewContent = restrictPopupViewData.getViewContent();
        int i = 0;
        for (int i2 = 0; i2 < viewContent.length(); i2++) {
            if (viewContent.charAt(i2) == '\n') {
                i++;
            }
        }
        if (i > 1) {
            inflate.kakaoGame2ndPwErrorViewBack.getLayoutParams().height = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_large_view_height);
            inflate.kakaoGame2ndPwErrorViewBack.getLayoutParams().width = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_view_width);
        } else {
            inflate.kakaoGame2ndPwErrorViewBack.getLayoutParams().height = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_view_height);
            inflate.kakaoGame2ndPwErrorViewBack.getLayoutParams().width = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_view_width);
        }
        inflate.kakaoGame2ndPwError2lineMsg.setText(this.viewData.getViewContent());
        inflate.kakaoGame2ndPwError2lineTimeGuide.setText(this.viewData.getTimeGuide());
        NotoSansTextView notoSansTextView = inflate.kakaoGame2ndPwError2lineTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(y.ݮڮֲڭܩ(-628458116) + this.viewData.getMinLabel() + y.ݬֲ֮ܲت(1512123591) + this.viewData.getSecLabel(), Arrays.copyOf(new Object[]{Integer.valueOf(this.viewData.getMin()), Integer.valueOf(this.viewData.getSec())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
        notoSansTextView.setText(format);
        inflate.kakaoGame2ndPwErrorConfirm.setText(this.viewData.getConfirmButtonText());
        inflate.kakaoGame2ndPwErrorConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWRestrictViewDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWRestrictViewDialog.lambda$2$lambda$1(SecondPWRestrictViewDialog.this, view);
            }
        });
        setContentView(this.binding.getRoot());
        startCountDownTimer();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void lambda$2$lambda$1(SecondPWRestrictViewDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closePopup();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void onBackPressed() {
        closePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void changeTime(int countDownSec) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SecondPWRestrictViewDialog$changeTime$1(this, countDownSec, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startCountDownTimer() {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = (this.viewData.getMin() * 60) + this.viewData.getSec();
        Timer timer = TimersKt.timer(null, false);
        timer.schedule(new TimerTask() { // from class: com.kakaogame.secondpw.SecondPWRestrictViewDialog$startCountDownTimer$$inlined$timer$default$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SecondPWRestrictViewDialog.this.changeTime(intRef.element);
                Ref.IntRef intRef2 = intRef;
                intRef2.element--;
                if (intRef.element == 0) {
                    SecondPWRestrictViewDialog.this.closePopup();
                }
            }
        }, 0L, 1000L);
        this.timer = timer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void closePopup() {
        Timer timer = this.timer;
        if (timer != null) {
            if (timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.دײܮڳܯ(2051081621));
                timer = null;
            }
            timer.cancel();
        }
        dismiss();
        this.callback.invoke();
    }
}
