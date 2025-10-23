package com.kakaogame.secondpw;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.appcompat.C0047R;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.p029ui.font.NotoSansEditText;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.secondpw.view.PasswordDisplayView;
import com.kakaogame.secondpw.view.VirtualKeypad;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.security.C2558R;
import com.kakaogame.security.databinding.KakaoGame2ndPw3lineContentViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwCenterContentViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwCodeInputViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwDigitCodeViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwErrorViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwInputDetailViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwNoPassiveViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwPassiveViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwPopupViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwSettingDetailViewBinding;
import com.kakaogame.security.databinding.KakaoGame2ndPwWarningViewBinding;
import com.kakaogame.security.databinding.KakaoGameSecondPasswordGuideViewBinding;
import com.liapp.y;
import java.io.File;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.TimersKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SecondPWViewDialog.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u001a\u0010\"\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0003J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000fH\u0002J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\bH\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\u0018\u00101\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m839d2 = {"Lcom/kakaogame/secondpw/SecondPWViewDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "action", "Lcom/kakaogame/secondpw/ActionType;", "callback", "Lcom/kakaogame/KGResultCallback;", "", "(Landroid/app/Activity;Lcom/kakaogame/secondpw/ActionType;Lcom/kakaogame/KGResultCallback;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/kakaogame/security/databinding/KakaoGameSecondPasswordGuideViewBinding;", "currentViewData", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "inputTimer", "Ljava/util/Timer;", "minLabel", "needReset", "", "secLabel", "typeface", "Landroid/graphics/Typeface;", "changeTime", "", "countDownSec", "", "clearView", "viewType", "Lcom/kakaogame/secondpw/PasswordViewType;", "onBackPressed", "refreshVirtualKeypad", "viewData", "selectView", "content", "showCenterContentView", "showCodeInputView", "showPasswordInputView", "showPopupVeiw", "showRestrictPopupVeiw", "showSetPasswordView", "showThreeLineContentView", "showTwoLineContentView", "startCountDownTimer", "startLimitTimer", "limitTime", "limitAction", "stopLimitTimer", "updateViewData", "data", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SecondPWViewDialog extends Dialog {
    private final Activity activity;
    private final KakaoGameSecondPasswordGuideViewBinding binding;
    private final KGResultCallback<String> callback;
    private Base2ndPWViewData currentViewData;
    private Timer inputTimer;
    private String minLabel;
    private boolean needReset;
    private String secLabel;
    private Typeface typeface;

    /* compiled from: SecondPWViewDialog.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[ActionType.values().length];
            try {
                iArr[ActionType.CLOSE_POPUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ActionType.RESET_DIGIT_CODE_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ActionType.RESET_DIGIT_CODE_2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SecondPWViewDialog(Activity activity, ActionType actionType, KGResultCallback<String> kGResultCallback) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(actionType, y.֬ڱܱײٮ(-1159583711));
        this.activity = activity;
        this.callback = kGResultCallback;
        KakaoGameSecondPasswordGuideViewBinding inflate = KakaoGameSecondPasswordGuideViewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.minLabel = "";
        this.secLabel = "";
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
        setContentView(inflate.getRoot());
        selectView$default(this, actionType.getValue(), null, 2, null);
        this.typeface = new File("/system/fonts/NotoSansCJK-Regular.ttc").exists() ? Typeface.createFromFile("/system/fonts/NotoSansCJK-Regular.ttc") : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void clearView(PasswordViewType viewType) {
        if (viewType == PasswordViewType.POPUP || viewType == PasswordViewType.POPUP_RESTRICT || viewType == PasswordViewType.RESET_DIGIT_CODE) {
            return;
        }
        KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.threeLineContentView.getRoot().setVisibility(8);
        kakaoGameSecondPasswordGuideViewBinding.warningView.getRoot().setVisibility(8);
        kakaoGameSecondPasswordGuideViewBinding.centerContentView.getRoot().setVisibility(8);
        kakaoGameSecondPasswordGuideViewBinding.codeInputView.getRoot().setVisibility(8);
        kakaoGameSecondPasswordGuideViewBinding.digitCodeView.getRoot().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void updateViewData(PasswordViewType viewType, Base2ndPWViewData data) {
        if (viewType == PasswordViewType.POPUP || viewType == PasswordViewType.POPUP_RESTRICT) {
            return;
        }
        this.currentViewData = data;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void selectView$default(SecondPWViewDialog secondPWViewDialog, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        secondPWViewDialog.selectView(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void selectView(String action, String content) {
        this.binding.kakaoGame2ndPwConfirmButton.setEnabled(false);
        SecondPWViewManager.INSTANCE.getUIData(this.activity, ActionTypeKt.getActionType(action), content, new Function1<Base2ndPWViewData, Unit>() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$selectView$2

            /* compiled from: SecondPWViewDialog.kt */
            @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                static {
                    int[] iArr = new int[PasswordViewType.values().length];
                    try {
                        iArr[PasswordViewType.POPUP.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PasswordViewType.POPUP_RESTRICT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PasswordViewType.RESET_DIGIT_CODE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PasswordViewType.GUIDE_3_LINE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[PasswordViewType.GUIDE_2_LINE.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[PasswordViewType.GUIDE_CENTER.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[PasswordViewType.INPUT_CODE.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[PasswordViewType.INPUT_PHONE.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[PasswordViewType.INPUT_EMAIL.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[PasswordViewType.SET_PASSWORD.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    try {
                        iArr[PasswordViewType.INPUT_PASSWORD.ordinal()] = 11;
                    } catch (NoSuchFieldError unused11) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Base2ndPWViewData base2ndPWViewData) {
                invoke2(base2ndPWViewData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Base2ndPWViewData base2ndPWViewData) {
                KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding;
                KGResultCallback kGResultCallback;
                KGResultCallback kGResultCallback2;
                Intrinsics.checkNotNullParameter(base2ndPWViewData, y.دײܮڳܯ(2051550101));
                PasswordViewType viewType = PasswordViewTypeKt.getViewType(base2ndPWViewData.getType());
                SecondPWViewDialog.this.clearView(viewType);
                SecondPWViewDialog.this.updateViewData(viewType, base2ndPWViewData);
                switch (WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()]) {
                    case 1:
                        SecondPWViewDialog.this.showPopupVeiw(base2ndPWViewData);
                        break;
                    case 2:
                        SecondPWViewDialog.this.showRestrictPopupVeiw(base2ndPWViewData);
                        break;
                    case 3:
                        SecondPWViewDialog.this.refreshVirtualKeypad(base2ndPWViewData);
                        break;
                    case 4:
                        SecondPWViewDialog.this.showThreeLineContentView(base2ndPWViewData);
                        break;
                    case 5:
                        SecondPWViewDialog.this.showTwoLineContentView(base2ndPWViewData);
                        break;
                    case 6:
                        SecondPWViewDialog.this.showCenterContentView(base2ndPWViewData);
                        break;
                    case 7:
                        SecondPWViewDialog.this.showCodeInputView(base2ndPWViewData);
                        break;
                    case 8:
                        SecondPWViewDialog.this.showCodeInputView(base2ndPWViewData);
                        break;
                    case 9:
                        SecondPWViewDialog.this.showCodeInputView(base2ndPWViewData);
                        break;
                    case 10:
                        SecondPWViewDialog.this.showSetPasswordView(base2ndPWViewData);
                        break;
                    case 11:
                        SecondPWViewDialog.this.showPasswordInputView(base2ndPWViewData);
                        break;
                    default:
                        if (base2ndPWViewData.getResultCode() == 200) {
                            kGResultCallback2 = SecondPWViewDialog.this.callback;
                            if (kGResultCallback2 != null) {
                                kGResultCallback2.onResult(KGResult.INSTANCE.getSuccessResult(base2ndPWViewData.getAccessKey()));
                            }
                        } else {
                            kGResultCallback = SecondPWViewDialog.this.callback;
                            if (kGResultCallback != null) {
                                kGResultCallback.onResult(KGResult.INSTANCE.getResult(base2ndPWViewData.getResultCode()));
                            }
                        }
                        SecondPWViewDialog.this.stopLimitTimer();
                        SecondPWViewDialog.this.dismiss();
                        break;
                }
                kakaoGameSecondPasswordGuideViewBinding = SecondPWViewDialog.this.binding;
                kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setEnabled(true);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void onBackPressed() {
        stopLimitTimer();
        dismiss();
        KGResultCallback<String> kGResultCallback = this.callback;
        if (kGResultCallback != null) {
            kGResultCallback.onResult(KGResult.INSTANCE.getResult(9001));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startLimitTimer(int limitTime, final String limitAction) {
        Timer timer = this.inputTimer;
        if (timer != null) {
            if (timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782390480));
                timer = null;
            }
            timer.cancel();
        }
        long j = limitTime * 60 * 1000;
        Timer timer2 = TimersKt.timer(null, false);
        timer2.schedule(new TimerTask() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$startLimitTimer$$inlined$timer$default$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SecondPWViewDialog.selectView$default(SecondPWViewDialog.this, limitAction, null, 2, null);
                cancel();
            }
        }, j, 1000L);
        this.inputTimer = timer2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopLimitTimer() {
        Timer timer = this.inputTimer;
        if (timer != null) {
            if (timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782390480));
                timer = null;
            }
            timer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void changeTime(int countDownSec) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new SecondPWViewDialog$changeTime$1(this, countDownSec, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startCountDownTimer(final Base2ndPWViewData viewData) {
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = (viewData.getMin() * 60) + viewData.getSec();
        TimersKt.timer(null, false).schedule(new TimerTask() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$startCountDownTimer$$inlined$timer$default$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SecondPWViewDialog$startCountDownTimer$$inlined$timer$default$1 secondPWViewDialog$startCountDownTimer$$inlined$timer$default$1 = this;
                SecondPWViewDialog.this.changeTime(intRef.element);
                Ref.IntRef intRef2 = intRef;
                intRef2.element--;
                if (intRef.element == 0) {
                    SecondPWViewDialog.selectView$default(SecondPWViewDialog.this, viewData.getConfirmAction(), null, 2, null);
                    secondPWViewDialog$startCountDownTimer$$inlined$timer$default$1.cancel();
                }
            }
        }, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshVirtualKeypad(Base2ndPWViewData viewData) {
        this.needReset = false;
        startLimitTimer(viewData.getTimeLimit(), viewData.getTimeLimitAction());
        KakaoGame2ndPwDigitCodeViewBinding bind = KakaoGame2ndPwDigitCodeViewBinding.bind(this.binding.digitCodeView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.virtualKeypad.setCode(viewData.getFirstVirtualKeypadKeys());
        bind.virtualKeypad.setKeypadImage(viewData.getFirstVirtualKeypadImage());
        KakaoGame2ndPwInputDetailViewBinding.bind(bind.inputView.getRoot()).kakaoGame2ndPwInputView.removeAll();
        KakaoGame2ndPwSettingDetailViewBinding bind2 = KakaoGame2ndPwSettingDetailViewBinding.bind(bind.settingView.getRoot());
        bind2.codeInputConfirmDisplayView.removeAll();
        bind2.codeInputDisplayView.removeAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showPopupVeiw(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.popupView.getRoot().setVisibility(0);
        KakaoGame2ndPwPopupViewBinding bind = KakaoGame2ndPwPopupViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.popupView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        SpannableStringBuilder viewContent = viewData.getViewContent();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= viewContent.length()) {
                break;
            }
            if (viewContent.charAt(i) == '\n') {
                i2++;
            }
            i++;
        }
        String str = y.ۮڭڭܬި(862752387);
        if (i2 > 1) {
            bind.kakaoGame2ndPwPopupViewBack.getLayoutParams().height = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_view_height);
            ViewGroup.LayoutParams layoutParams = bind.kakaoGame2ndPwPopupViewBack.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, str);
            ((RelativeLayout.LayoutParams) layoutParams).setMargins(0, this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_restrict_view_margin_top), 0, 0);
        } else {
            bind.kakaoGame2ndPwPopupViewBack.getLayoutParams().height = this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_popup_view_height);
            ViewGroup.LayoutParams layoutParams2 = bind.kakaoGame2ndPwPopupViewBack.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, str);
            ((RelativeLayout.LayoutParams) layoutParams2).setMargins(0, this.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_popup_view_margin_top), 0, 0);
        }
        bind.kakaoGame2ndPwError1lineMsg.setText(viewData.getViewContent());
        bind.kakaoGame2ndPwPopupConfirm.setText(viewData.getConfirmButtonText());
        bind.kakaoGame2ndPwPopupConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda24
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPopupVeiw$lambda$11$lambda$10$lambda$9(Base2ndPWViewData.this, kakaoGameSecondPasswordGuideViewBinding, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopupVeiw$lambda$11$lambda$10$lambda$9(Base2ndPWViewData viewData, KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[ActionTypeKt.getActionType(viewData.getConfirmAction()).ordinal()];
        if (i == 1) {
            this_apply.popupView.getRoot().setVisibility(8);
            return;
        }
        if (i == 2) {
            this_apply.popupView.getRoot().setVisibility(8);
            selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
        } else if (i == 3) {
            this_apply.popupView.getRoot().setVisibility(8);
            selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
        } else {
            selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showRestrictPopupVeiw(final Base2ndPWViewData viewData) {
        this.minLabel = viewData.getMinLabel();
        this.secLabel = viewData.getSecLabel();
        KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        SpannableStringBuilder viewContent = viewData.getViewContent();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= viewContent.length()) {
                break;
            }
            if (viewContent.charAt(i) == '\n') {
                i2++;
            }
            i++;
        }
        final RelativeLayout root = i2 > 1 ? kakaoGameSecondPasswordGuideViewBinding.errorLargeView.getRoot() : kakaoGameSecondPasswordGuideViewBinding.errorView.getRoot();
        Intrinsics.checkNotNull(root);
        root.setVisibility(0);
        KakaoGame2ndPwErrorViewBinding bind = KakaoGame2ndPwErrorViewBinding.bind(root);
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGame2ndPwError2lineMsg.setText(viewData.getViewContent());
        bind.kakaoGame2ndPwError2lineTimeGuide.setText(viewData.getTimeGuide());
        NotoSansTextView notoSansTextView = bind.kakaoGame2ndPwError2lineTime;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(y.ݮڮֲڭܩ(-628458116) + this.minLabel + y.ݬֲ֮ܲت(1512123591) + this.secLabel, Arrays.copyOf(new Object[]{Integer.valueOf(viewData.getMin()), Integer.valueOf(viewData.getSec())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
        notoSansTextView.setText(format);
        bind.kakaoGame2ndPwErrorConfirm.setText(viewData.getConfirmButtonText());
        bind.kakaoGame2ndPwErrorConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda23
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showRestrictPopupVeiw$lambda$15$lambda$14$lambda$13(Base2ndPWViewData.this, root, this, view);
            }
        });
        startCountDownTimer(viewData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showRestrictPopupVeiw$lambda$15$lambda$14$lambda$13(Base2ndPWViewData viewData, RelativeLayout rootView, SecondPWViewDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[ActionTypeKt.getActionType(viewData.getConfirmAction()).ordinal()] == 1) {
            rootView.setVisibility(8);
        } else {
            selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showThreeLineContentView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.threeLineContentView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda15
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showThreeLineContentView$lambda$20$lambda$16(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        KakaoGame2ndPw3lineContentViewBinding bind = KakaoGame2ndPw3lineContentViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.threeLineContentView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGame2ndPwTitle.setText(viewData.getTitle());
        bind.kakaoGame2ndPwContent.setText(viewData.getViewContent());
        bind.kakaoGame2ndPwDetail.setText(viewData.getDetail());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda16
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showThreeLineContentView$lambda$20$lambda$18(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda17
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showThreeLineContentView$lambda$20$lambda$19(SecondPWViewDialog.this, viewData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showThreeLineContentView$lambda$20$lambda$16(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showThreeLineContentView$lambda$20$lambda$18(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.threeLineContentView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showThreeLineContentView$lambda$20$lambda$19(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showTwoLineContentView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.warningView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda20
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showTwoLineContentView$lambda$25$lambda$21(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        KakaoGame2ndPwWarningViewBinding bind = KakaoGame2ndPwWarningViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.warningView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGame2ndPwTitle.setText(viewData.getTitle());
        bind.kakaoGame2ndPwContent.setText(viewData.getViewContent());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda21
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showTwoLineContentView$lambda$25$lambda$23(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda22
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showTwoLineContentView$lambda$25$lambda$24(SecondPWViewDialog.this, viewData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showTwoLineContentView$lambda$25$lambda$21(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showTwoLineContentView$lambda$25$lambda$23(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.warningView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showTwoLineContentView$lambda$25$lambda$24(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showCenterContentView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.centerContentView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda25
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCenterContentView$lambda$30$lambda$26(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        KakaoGame2ndPwCenterContentViewBinding bind = KakaoGame2ndPwCenterContentViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.centerContentView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGame2ndPwCenterContent.setText(viewData.getViewContent());
        bind.kakaoGame2ndPwCenterSubContent.setText(viewData.getSubContent());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCenterContentView$lambda$30$lambda$28(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCenterContentView$lambda$30$lambda$29(SecondPWViewDialog.this, viewData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCenterContentView$lambda$30$lambda$26(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCenterContentView$lambda$30$lambda$28(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.centerContentView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCenterContentView$lambda$30$lambda$29(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getConfirmAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showCodeInputView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.codeInputView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCodeInputView$lambda$39$lambda$31(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        final KakaoGame2ndPwCodeInputViewBinding bind = KakaoGame2ndPwCodeInputViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.codeInputView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGame2ndPwContentTitle.setText(viewData.getTitle());
        bind.kakaoGame2ndPwCodeContent.setText(viewData.getViewContent());
        Editable text = bind.kakaoGame2ndPwCodeInput.getText();
        if (text != null) {
            text.clear();
        }
        bind.kakaoGame2ndPwCodeClear.setVisibility(8);
        bind.kakaoGame2ndPwCodeInput.setHint(viewData.getInput());
        String type = viewData.getType();
        if (Intrinsics.areEqual(type, PasswordViewType.INPUT_EMAIL.getValue())) {
            bind.kakaoGame2ndPwCodeInput.setInputType(208);
            bind.kakaoGame2ndPwCodeInput.setFilters(new InputFilter[]{new InputFilter() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda10
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.text.InputFilter
                public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    CharSequence showCodeInputView$lambda$39$lambda$38$lambda$32;
                    showCodeInputView$lambda$39$lambda$38$lambda$32 = SecondPWViewDialog.showCodeInputView$lambda$39$lambda$38$lambda$32(charSequence, i, i2, spanned, i3, i4);
                    return showCodeInputView$lambda$39$lambda$38$lambda$32;
                }
            }});
        } else if (Intrinsics.areEqual(type, PasswordViewType.INPUT_PHONE.getValue())) {
            bind.kakaoGame2ndPwCodeInput.setInputType(3);
            bind.kakaoGame2ndPwCodeInput.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(11)});
        } else {
            bind.kakaoGame2ndPwCodeInput.setInputType(2);
            bind.kakaoGame2ndPwCodeInput.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(6)});
        }
        bind.kakaoGame2ndPwResetButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda12
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCodeInputView$lambda$39$lambda$38$lambda$33(KakaoGame2ndPwCodeInputViewBinding.this, view);
            }
        });
        NotoSansEditText notoSansEditText = bind.kakaoGame2ndPwCodeInput;
        Intrinsics.checkNotNullExpressionValue(notoSansEditText, y.ۮڭڭܬި(862742931));
        notoSansEditText.addTextChangedListener(new TextWatcher() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$showCodeInputView$lambda$39$lambda$38$$inlined$addTextChangedListener$default$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text2, int start, int count, int after) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text2, int start, int before, int count) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    if (s.length() > 0) {
                        KakaoGame2ndPwCodeInputViewBinding.this.kakaoGame2ndPwCodeContentLine.setBackgroundColor(-335616);
                        KakaoGame2ndPwCodeInputViewBinding.this.kakaoGame2ndPwCodeClear.setVisibility(0);
                    } else {
                        KakaoGame2ndPwCodeInputViewBinding.this.kakaoGame2ndPwCodeContentLine.setBackgroundColor(-1644826);
                        KakaoGame2ndPwCodeInputViewBinding.this.kakaoGame2ndPwCodeClear.setVisibility(8);
                    }
                }
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda13
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCodeInputView$lambda$39$lambda$38$lambda$36(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda14
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showCodeInputView$lambda$39$lambda$38$lambda$37(Base2ndPWViewData.this, this, bind, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCodeInputView$lambda$39$lambda$31(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final CharSequence showCodeInputView$lambda$39$lambda$38$lambda$32(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (Pattern.compile("^[a-zA-Z0-9_!@#$%&'*+/=?`{|}~^.-]+$").matcher(charSequence).matches()) {
            return null;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCodeInputView$lambda$39$lambda$38$lambda$33(KakaoGame2ndPwCodeInputViewBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Editable text = this_apply.kakaoGame2ndPwCodeInput.getText();
        if (text != null) {
            text.clear();
        }
        this_apply.kakaoGame2ndPwCodeClear.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCodeInputView$lambda$39$lambda$38$lambda$36(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.codeInputView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCodeInputView$lambda$39$lambda$38$lambda$37(Base2ndPWViewData viewData, SecondPWViewDialog this$0, KakaoGame2ndPwCodeInputViewBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String confirmAction = viewData.getConfirmAction();
        if (Intrinsics.areEqual(confirmAction, ActionType.SET_CODE_SMS.getValue())) {
            this$0.selectView(viewData.getConfirmAction(), ((Object) this_apply.kakaoGame2ndPwCodeInput.getText()) + ',' + viewData.getPhoneNumber());
        } else if (Intrinsics.areEqual(confirmAction, ActionType.SET_CODE_EMAIL.getValue())) {
            this$0.selectView(viewData.getConfirmAction(), ((Object) this_apply.kakaoGame2ndPwCodeInput.getText()) + ',' + viewData.getEmailAddress());
        } else {
            this$0.selectView(viewData.getConfirmAction(), this_apply.kakaoGame2ndPwCodeInput.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showSetPasswordView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.digitCodeView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showSetPasswordView$lambda$48$lambda$40(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        final KakaoGame2ndPwDigitCodeViewBinding bind = KakaoGame2ndPwDigitCodeViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.digitCodeView.getRoot());
        String str = y.ݬֲ֮ܲت(1512391959);
        Intrinsics.checkNotNullExpressionValue(bind, str);
        bind.settingView.getRoot().setVisibility(0);
        bind.inputView.getRoot().setVisibility(8);
        final KakaoGame2ndPwSettingDetailViewBinding bind2 = KakaoGame2ndPwSettingDetailViewBinding.bind(bind.settingView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind2, str);
        bind2.codeInputDisplayView.setTitle(viewData.getInput());
        bind2.codeInputConfirmDisplayView.setTitle(viewData.getInputConfirm());
        bind2.kakaoGame2ndPwBlockingGuide.setText(viewData.getDetail());
        if (viewData.getHasPassive()) {
            bind2.noPassiveView.getRoot().setVisibility(8);
            bind2.hasPassiveView.getRoot().setVisibility(0);
            final KakaoGame2ndPwPassiveViewBinding bind3 = KakaoGame2ndPwPassiveViewBinding.bind(bind2.hasPassiveView.getRoot());
            bind3.passiveViewDetail.setText(viewData.getPassiveDesc());
            bind3.kakaoGame2ndPwPassiveContentDump.setText(viewData.getPassive());
            bind3.kakaoGame2ndPwPassiveContentDump.post(new Runnable() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda11
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    SecondPWViewDialog.m711x99653766(SecondPWViewDialog.this, bind3, viewData);
                }
            });
        } else {
            bind2.noPassiveView.getRoot().setVisibility(0);
            bind2.hasPassiveView.getRoot().setVisibility(8);
            KakaoGame2ndPwNoPassiveViewBinding.bind(bind2.noPassiveView.getRoot()).passiveViewDetail.setText(viewData.getPassiveDesc());
        }
        bind.virtualKeypad.setCode(viewData.getFirstVirtualKeypadKeys());
        bind.virtualKeypad.setKeypadImage(viewData.getFirstVirtualKeypadImage());
        bind.virtualKeypad.setOnKeyListener(viewData, new Function2<Integer, Character, Unit>() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$showSetPasswordView$1$2$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Character ch) {
                invoke(num.intValue(), ch);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void invoke(int i, Character ch) {
                Base2ndPWViewData base2ndPWViewData;
                Base2ndPWViewData base2ndPWViewData2;
                boolean z;
                Base2ndPWViewData base2ndPWViewData3 = null;
                if (i == 0) {
                    KakaoGame2ndPwSettingDetailViewBinding.this.codeInputConfirmDisplayView.removeAll();
                    KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView.removeAll();
                    SecondPWViewDialog.selectView$default(this, viewData.getResetAction(), null, 2, null);
                    return;
                }
                if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    if (!KakaoGame2ndPwSettingDetailViewBinding.this.codeInputConfirmDisplayView.hasCode()) {
                        z = this.needReset;
                        if (z) {
                            this.needReset = false;
                            KakaoGame2ndPwSettingDetailViewBinding.this.codeInputConfirmDisplayView.removeAll();
                            KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView.removeAll();
                            SecondPWViewDialog.selectView$default(this, viewData.getResetAction(), null, 2, null);
                            return;
                        }
                        KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView.removeCode();
                        return;
                    }
                    KakaoGame2ndPwSettingDetailViewBinding.this.codeInputConfirmDisplayView.removeCode();
                    return;
                }
                if (KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView.isFull()) {
                    PasswordDisplayView passwordDisplayView = KakaoGame2ndPwSettingDetailViewBinding.this.codeInputConfirmDisplayView;
                    Intrinsics.checkNotNull(ch);
                    passwordDisplayView.updateCode(ch.charValue());
                    return;
                }
                PasswordDisplayView passwordDisplayView2 = KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView;
                Intrinsics.checkNotNull(ch);
                passwordDisplayView2.updateCode(ch.charValue());
                if (KakaoGame2ndPwSettingDetailViewBinding.this.codeInputDisplayView.isFull()) {
                    this.needReset = true;
                    VirtualKeypad virtualKeypad = bind.virtualKeypad;
                    base2ndPWViewData = this.currentViewData;
                    String str2 = y.ٴسسݬߨ(1393033282);
                    if (base2ndPWViewData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                        base2ndPWViewData = null;
                    }
                    virtualKeypad.setCode(base2ndPWViewData.getSecondVirtualKeypadKeys());
                    VirtualKeypad virtualKeypad2 = bind.virtualKeypad;
                    base2ndPWViewData2 = this.currentViewData;
                    if (base2ndPWViewData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                    } else {
                        base2ndPWViewData3 = base2ndPWViewData2;
                    }
                    virtualKeypad2.setKeypadImage(base2ndPWViewData3.getSecondVirtualKeypadImage());
                }
            }
        });
        startLimitTimer(viewData.getTimeLimit(), viewData.getTimeLimitAction());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda18
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showSetPasswordView$lambda$48$lambda$47$lambda$46$lambda$44(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda19
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showSetPasswordView$lambda$48$lambda$47$lambda$46$lambda$45(SecondPWViewDialog.this, viewData, bind2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showSetPasswordView$lambda$48$lambda$40(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: showSetPasswordView$lambda$48$lambda$47$lambda$46$lambda$42$lambda$41 */
    public static final void m711x99653766(SecondPWViewDialog secondPWViewDialog, KakaoGame2ndPwPassiveViewBinding kakaoGame2ndPwPassiveViewBinding, Base2ndPWViewData base2ndPWViewData) {
        Intrinsics.checkNotNullParameter(secondPWViewDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(kakaoGame2ndPwPassiveViewBinding, y.ݬֲ֮ܲت(1512392063));
        Intrinsics.checkNotNullParameter(base2ndPWViewData, y.ٴسسݬߨ(1393033522));
        int dimensionPixelSize = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_check_size) + secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_check_round_side_margin) + (secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_content_side_margin) * 3) + kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContentDump.getWidth();
        int dimensionPixelSize2 = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_back_image_width);
        int dimensionPixelSize3 = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_back_image_max_width);
        if (dimensionPixelSize < dimensionPixelSize2) {
            dimensionPixelSize = dimensionPixelSize2;
        } else if (dimensionPixelSize > dimensionPixelSize3) {
            dimensionPixelSize = dimensionPixelSize3;
        }
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveBg.getLayoutParams().width = dimensionPixelSize;
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContent.setText(base2ndPWViewData.getPassive());
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContentDump.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showSetPasswordView$lambda$48$lambda$47$lambda$46$lambda$44(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.digitCodeView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showSetPasswordView$lambda$48$lambda$47$lambda$46$lambda$45(SecondPWViewDialog this$0, Base2ndPWViewData viewData, KakaoGame2ndPwSettingDetailViewBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.selectView(viewData.getConfirmAction(), this_apply.codeInputDisplayView.getCode() + ',' + this_apply.codeInputConfirmDisplayView.getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showPasswordInputView(final Base2ndPWViewData viewData) {
        final KakaoGameSecondPasswordGuideViewBinding kakaoGameSecondPasswordGuideViewBinding = this.binding;
        kakaoGameSecondPasswordGuideViewBinding.digitCodeView.getRoot().setVisibility(0);
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPasswordInputView$lambda$59$lambda$49(SecondPWViewDialog.this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwTopbarTitle.setText(viewData.getTitleBar());
        KakaoGame2ndPwDigitCodeViewBinding bind = KakaoGame2ndPwDigitCodeViewBinding.bind(kakaoGameSecondPasswordGuideViewBinding.digitCodeView.getRoot());
        String str = y.ݬֲ֮ܲت(1512391959);
        Intrinsics.checkNotNullExpressionValue(bind, str);
        bind.settingView.getRoot().setVisibility(8);
        bind.inputView.getRoot().setVisibility(0);
        final KakaoGame2ndPwInputDetailViewBinding bind2 = KakaoGame2ndPwInputDetailViewBinding.bind(bind.inputView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind2, str);
        bind2.kakaoGame2ndPwInputView.removeAll();
        bind2.kakaoGame2ndPwInputView.setTitle(viewData.getInput());
        bind2.kakaoGame2ndPwBlockingGuide.setText(viewData.getDetail());
        if (viewData.getHasPassive()) {
            bind2.noPassiveView.getRoot().setVisibility(8);
            bind2.hasPassiveView.getRoot().setVisibility(0);
            final KakaoGame2ndPwPassiveViewBinding bind3 = KakaoGame2ndPwPassiveViewBinding.bind(bind2.hasPassiveView.getRoot());
            bind3.passiveViewDetail.setText(viewData.getPassiveDesc());
            bind3.kakaoGame2ndPwPassiveContentDump.setText(viewData.getPassive());
            bind3.kakaoGame2ndPwPassiveContentDump.post(new Runnable() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    SecondPWViewDialog.m710x2444d914(SecondPWViewDialog.this, bind3, viewData);
                }
            });
        } else {
            bind2.noPassiveView.getRoot().setVisibility(0);
            bind2.hasPassiveView.getRoot().setVisibility(8);
            KakaoGame2ndPwNoPassiveViewBinding.bind(bind2.noPassiveView.getRoot()).passiveViewDetail.setText(viewData.getPassiveDesc());
        }
        bind2.kakaoGame2ndPwResetButton.setText(viewData.getResetPasswordButtonText());
        bind2.kakaoGame2ndPwResetButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$53(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        bind2.kakaoGame2ndPwRemoveButton.setText(viewData.getRemovePasswordButtonText());
        bind2.kakaoGame2ndPwRemoveButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$54(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        bind.virtualKeypad.setCode(viewData.getFirstVirtualKeypadKeys());
        bind.virtualKeypad.setKeypadImage(viewData.getFirstVirtualKeypadImage());
        bind.virtualKeypad.setOnKeyListener(viewData, new Function2<Integer, Character, Unit>() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$showPasswordInputView$1$2$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Character ch) {
                invoke(num.intValue(), ch);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void invoke(int i, Character ch) {
                if (i == 0) {
                    KakaoGame2ndPwInputDetailViewBinding.this.kakaoGame2ndPwInputView.removeAll();
                    SecondPWViewDialog.selectView$default(this, viewData.getResetAction(), null, 2, null);
                } else if (i != 1) {
                    if (i != 2) {
                        return;
                    }
                    KakaoGame2ndPwInputDetailViewBinding.this.kakaoGame2ndPwInputView.removeCode();
                } else {
                    PasswordDisplayView passwordDisplayView = KakaoGame2ndPwInputDetailViewBinding.this.kakaoGame2ndPwInputView;
                    Intrinsics.checkNotNull(ch);
                    passwordDisplayView.updateCode(ch.charValue());
                }
            }
        });
        startLimitTimer(viewData.getTimeLimit(), viewData.getTimeLimitAction());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setText(viewData.getCancelButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwCancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$55(KakaoGameSecondPasswordGuideViewBinding.this, this, viewData, view);
            }
        });
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setText(viewData.getConfirmButtonText());
        kakaoGameSecondPasswordGuideViewBinding.kakaoGame2ndPwConfirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.secondpw.SecondPWViewDialog$$ExternalSyntheticLambda8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SecondPWViewDialog.showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$56(SecondPWViewDialog.this, viewData, bind2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordInputView$lambda$59$lambda$49(SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        selectView$default(this$0, viewData.getExitAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$51$lambda$50 */
    public static final void m710x2444d914(SecondPWViewDialog secondPWViewDialog, KakaoGame2ndPwPassiveViewBinding kakaoGame2ndPwPassiveViewBinding, Base2ndPWViewData base2ndPWViewData) {
        Intrinsics.checkNotNullParameter(secondPWViewDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(kakaoGame2ndPwPassiveViewBinding, y.ݬֲ֮ܲت(1512392063));
        Intrinsics.checkNotNullParameter(base2ndPWViewData, y.ٴسسݬߨ(1393033522));
        int dimensionPixelSize = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_check_size) + secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_check_round_side_margin) + (secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_content_side_margin) * 3) + kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContentDump.getWidth();
        int dimensionPixelSize2 = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_back_image_width);
        int dimensionPixelSize3 = secondPWViewDialog.activity.getResources().getDimensionPixelSize(C2558R.dimen.sdk_2nd_password_passive_back_image_max_width);
        if (dimensionPixelSize < dimensionPixelSize2) {
            dimensionPixelSize = dimensionPixelSize2;
        } else if (dimensionPixelSize > dimensionPixelSize3) {
            dimensionPixelSize = dimensionPixelSize3;
        }
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveBg.getLayoutParams().width = dimensionPixelSize;
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContent.setText(base2ndPWViewData.getPassive());
        kakaoGame2ndPwPassiveViewBinding.kakaoGame2ndPwPassiveContentDump.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$53(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.digitCodeView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getResetPasswordAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$54(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.digitCodeView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getRemovePasswordAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$55(KakaoGameSecondPasswordGuideViewBinding this_apply, SecondPWViewDialog this$0, Base2ndPWViewData viewData, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        this_apply.digitCodeView.getRoot().setVisibility(8);
        selectView$default(this$0, viewData.getCancelAction(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordInputView$lambda$59$lambda$58$lambda$57$lambda$56(SecondPWViewDialog this$0, Base2ndPWViewData viewData, KakaoGame2ndPwInputDetailViewBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewData, "$viewData");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.selectView(viewData.getConfirmAction(), this_apply.kakaoGame2ndPwInputView.getCode());
    }
}
