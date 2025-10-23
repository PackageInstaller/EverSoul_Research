package com.kakaogame.auth.view;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import androidx.appcompat.C0047R;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.C2382R;
import com.kakaogame.KGSystem;
import com.kakaogame.auth.view.PunishedUserDialog;
import com.kakaogame.databinding.KakaoGameProtectedUserConfirmCodeBinding;
import com.kakaogame.databinding.KakaoGameProtectedUserPopupBinding;
import com.kakaogame.databinding.KakaoGameProtectedUserRestrictGuideBinding;
import com.kakaogame.databinding.KakaoGameProtectedUserUnregisterAgreementBinding;
import com.kakaogame.databinding.KakaoGameProtectedUserUnregisterConfirmBinding;
import com.kakaogame.databinding.KakaoGameProtectedUserWebviewBinding;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.p029ui.font.NotoSansEditText;
import com.kakaogame.p029ui.font.StyleTextBuilder;
import com.kakaogame.p029ui.font.StyleTextKt;
import com.kakaogame.p029ui.font.TextBuilder;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.web.WebViewContainer;
import com.liapp.y;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PunishedUserDialog.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0003@ABBC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0012\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0012H\u0002J\b\u00100\u001a\u00020\u000bH\u0002J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\u0010\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u0018H\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020\u000bH\u0002J\f\u0010;\u001a\u00020\u0012*\u00020\u0012H\u0002J\f\u0010<\u001a\u00020\u0012*\u00020\u0012H\u0002J\u0014\u0010=\u001a\u00020\u000b*\u00020>2\u0006\u0010?\u001a\u00020%H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006C"}, m839d2 = {"Lcom/kakaogame/auth/view/PunishedUserDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "onetimeToken", "", "userId", "message", FirebaseAnalytics.Param.TERM, "callback", "Lkotlin/Function1;", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getActivity", "()Landroid/app/Activity;", "binding", "Lcom/kakaogame/databinding/KakaoGameProtectedUserPopupBinding;", "currentView", "Lcom/kakaogame/auth/view/PunishedUserDialog$ViewType;", "getCurrentView", "()Lcom/kakaogame/auth/view/PunishedUserDialog$ViewType;", "setCurrentView", "(Lcom/kakaogame/auth/view/PunishedUserDialog$ViewType;)V", "disableTextColor", "", "getDisableTextColor", "()I", "getMessage", "()Ljava/lang/String;", "normalTextColor", "getNormalTextColor", "getOnetimeToken", "getTerm", "terminateTimer", "Ljava/util/Timer;", "getUserId", "viewSizeChanged", "", "getViewSizeChanged", "()Z", "setViewSizeChanged", "(Z)V", "callbackResult", "result", "clearView", "requestUnregister", "selectView", "viewType", "showAgreement", "showAgreementDetail", "showConfirmCode", "showNotice", "showUnregisterEnd", ServerConstants.TRACE_RESULT_CODE, "showUnregisterGuide", "startTerminateTimer", "timeLimit", "", "stopTerminateTimer", "getCancelView", "getNextView", "setEnable", "Lcom/kakaogame/ui/font/NotoSansButton;", "enable", "Companion", "ViewType", "WebViewContainerImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PunishedUserDialog extends Dialog {
    private final Activity activity;
    private final KakaoGameProtectedUserPopupBinding binding;
    private final Function1<String, Unit> callback;
    private ViewType currentView;
    private final int disableTextColor;
    private final String message;
    private final int normalTextColor;
    private final String onetimeToken;
    private final String term;
    private Timer terminateTimer;
    private final String userId;
    private boolean viewSizeChanged;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RESULT_EMAIL = y.֬ڱܱײٮ(-1159479551);
    private static final String RESULT_UNREGISTERED = y.ٲٴݴ״ٰ(1781928656);
    private static final String RESULT_TERMINATE = y.ٲٴݴ״ٰ(1782149840);

    /* compiled from: PunishedUserDialog.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[ViewType.values().length];
            try {
                iArr[ViewType.AGREEMENT_DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewType.NOTICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ViewType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ViewType.AGREEMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ViewType.CONFIRM_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ViewType.UNREGISTER_GUIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ViewType.UNREGISTER_CONFIRM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOnetimeToken() {
        return this.onetimeToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMessage() {
        return this.message;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTerm() {
        return this.term;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PunishedUserDialog(Activity activity, String str, String str2, String str3, String str4, Function1<? super String, Unit> function1) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576652574));
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1393323586));
        Intrinsics.checkNotNullParameter(str3, y.دײܮڳܯ(2051551053));
        Intrinsics.checkNotNullParameter(str4, y.ٴسسݬߨ(1393323522));
        Intrinsics.checkNotNullParameter(function1, y.֬ڱܱײٮ(-1159472767));
        this.activity = activity;
        this.onetimeToken = str;
        this.userId = str2;
        this.message = str3;
        this.term = str4;
        this.callback = function1;
        KakaoGameProtectedUserPopupBinding inflate = KakaoGameProtectedUserPopupBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.currentView = ViewType.NOTICE;
        this.normalTextColor = Color.parseColor("#191919");
        this.disableTextColor = Color.parseColor("#999999");
        requestWindowFeature(1);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setSoftInputMode(4);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.getAttributes().windowAnimations = R.style.Animation.Dialog;
        setCanceledOnTouchOutside(false);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window4 = getWindow();
            Intrinsics.checkNotNull(window4);
            window4.getAttributes().layoutInDisplayCutoutMode = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        }
        setContentView(inflate.getRoot());
        DisplayUtil displayUtil = DisplayUtil.INSTANCE;
        Window window5 = getWindow();
        Intrinsics.checkNotNull(window5);
        displayUtil.setFullScreenView(activity, window5);
        clearView();
        inflate.kakaoGameProtectedPopupCancel.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.lambda$3$lambda$0(PunishedUserDialog.this, view);
            }
        });
        inflate.kakaoGameProtectedPopupConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.lambda$3$lambda$1(PunishedUserDialog.this, view);
            }
        });
        inflate.kakaoGameProtectedUserTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.lambda$3$lambda$2(PunishedUserDialog.this, view);
            }
        });
        selectView(ViewType.NOTICE);
        setCancelable(false);
        startTerminateTimer(10000L);
    }

    /* compiled from: PunishedUserDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/auth/view/PunishedUserDialog$Companion;", "", "()V", "RESULT_EMAIL", "", "getRESULT_EMAIL", "()Ljava/lang/String;", "RESULT_TERMINATE", "getRESULT_TERMINATE", "RESULT_UNREGISTERED", "getRESULT_UNREGISTERED", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRESULT_EMAIL() {
            return PunishedUserDialog.RESULT_EMAIL;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRESULT_UNREGISTERED() {
            return PunishedUserDialog.RESULT_UNREGISTERED;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRESULT_TERMINATE() {
            return PunishedUserDialog.RESULT_TERMINATE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ViewType getCurrentView() {
        return this.currentView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCurrentView(ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, y.ٴسسݬߨ(1392633402));
        this.currentView = viewType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getViewSizeChanged() {
        return this.viewSizeChanged;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setViewSizeChanged(boolean z) {
        this.viewSizeChanged = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getNormalTextColor() {
        return this.normalTextColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getDisableTextColor() {
        return this.disableTextColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void lambda$3$lambda$0(PunishedUserDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectView(this$0.getCancelView(this$0.currentView));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void lambda$3$lambda$1(PunishedUserDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectView(this$0.getNextView(this$0.currentView));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static final void lambda$3$lambda$2(PunishedUserDialog this$0, View view) {
        ViewType viewType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[this$0.currentView.ordinal()] == 1) {
            viewType = this$0.getCancelView(this$0.currentView);
        } else {
            viewType = ViewType.CLOSE;
        }
        this$0.selectView(viewType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void callbackResult(String result) {
        this.callback.invoke(result);
        stopTerminateTimer();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void startTerminateTimer(long timeLimit) {
        Timer timer = this.terminateTimer;
        if (timer != null) {
            if (timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.ݬֲ֮ܲت(1512391127));
                timer = null;
            }
            timer.cancel();
        }
        Timer timer2 = new Timer();
        this.terminateTimer = timer2;
        timer2.schedule(new TimerTask() { // from class: com.kakaogame.auth.view.PunishedUserDialog$startTerminateTimer$$inlined$schedule$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                PunishedUserDialog.this.callbackResult(null);
            }
        }, timeLimit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void stopTerminateTimer() {
        Timer timer = this.terminateTimer;
        if (timer != null) {
            if (timer == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.ݬֲ֮ܲت(1512391127));
                timer = null;
            }
            timer.cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void clearView() {
        KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.restrictGuideView.getRoot().setVisibility(8);
        kakaoGameProtectedUserPopupBinding.unregisterAgreementView.getRoot().setVisibility(8);
        kakaoGameProtectedUserPopupBinding.confirmCodeView.getRoot().setVisibility(8);
        kakaoGameProtectedUserPopupBinding.unregisterConfirmView.getRoot().setVisibility(8);
        kakaoGameProtectedUserPopupBinding.webView.getRoot().setVisibility(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void selectView(ViewType viewType) {
        clearView();
        this.currentView = viewType;
        switch (WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()]) {
            case 1:
                showAgreementDetail();
                break;
            case 2:
                showNotice();
                break;
            case 3:
                dismiss();
                callbackResult(RESULT_EMAIL);
                break;
            case 4:
                showAgreement();
                break;
            case 5:
                showConfirmCode();
                break;
            case 6:
                showUnregisterGuide();
                break;
            case 7:
                requestUnregister();
                break;
            default:
                dismiss();
                callbackResult(null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setEnable(NotoSansButton notoSansButton, boolean z) {
        notoSansButton.setEnabled(z);
        notoSansButton.setTextColor(z ? this.normalTextColor : this.disableTextColor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showNotice() {
        final KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.restrictGuideView.getRoot().setVisibility(0);
        final KakaoGameProtectedUserRestrictGuideBinding bind = KakaoGameProtectedUserRestrictGuideBinding.bind(kakaoGameProtectedUserPopupBinding.restrictGuideView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGameProtectedPopupDetailReasonDump.setText(this.message);
        bind.kakaoGameProtectedPopupDetailReasonDump.post(new Runnable() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                PunishedUserDialog.showNotice$lambda$8$lambda$7$lambda$6(KakaoGameProtectedUserRestrictGuideBinding.this, this, kakaoGameProtectedUserPopupBinding);
            }
        });
        bind.kakaoGameProtectedPopupContent.setText(StyleTextKt.getString(StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showNotice$1$1$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StyleTextBuilder styleTextBuilder) {
                invoke2(styleTextBuilder);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StyleTextBuilder styleTextBuilder) {
                Intrinsics.checkNotNullParameter(styleTextBuilder, y.ٴسسݬߨ(1393323090));
                final PunishedUserDialog punishedUserDialog = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showNotice$1$1$2.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog2 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.1.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(PunishedUserDialog.this.getActivity(), C2382R.string.kakao_game_sdk_protected_user_reason_view_content_pre);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
                final PunishedUserDialog punishedUserDialog2 = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showNotice$1$1$2.2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog3 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.2.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return PunishedUserDialog.this.getUserId();
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.2.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.دײܮڳܯ(2051597077), y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
                final PunishedUserDialog punishedUserDialog3 = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showNotice$1$1$2.3
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog4 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.3.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(PunishedUserDialog.this.getActivity(), C2382R.string.kakao_game_sdk_protected_user_reason_view_content_post);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showNotice.1.1.2.3.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.٬ݯح׭٩(576694694)};
                            }
                        });
                    }
                });
            }
        })));
        bind.kakaoGameProtectedPopupDetailTerm.setText(this.term);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_reason_view_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupCancel.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_reason_view_left_btn)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_reason_view_right_btn)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotice$lambda$8$lambda$7$lambda$6(KakaoGameProtectedUserRestrictGuideBinding kakaoGameProtectedUserRestrictGuideBinding, PunishedUserDialog punishedUserDialog, KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding) {
        Intrinsics.checkNotNullParameter(kakaoGameProtectedUserRestrictGuideBinding, y.ݬֲ֮ܲت(1512392063));
        Intrinsics.checkNotNullParameter(punishedUserDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(kakaoGameProtectedUserPopupBinding, y.ٴسسݬߨ(1393322378));
        int height = kakaoGameProtectedUserRestrictGuideBinding.kakaoGameProtectedPopupDetailReasonDump.getHeight() - kakaoGameProtectedUserRestrictGuideBinding.kakaoGameProtectedPopupDetailReason.getHeight();
        if (height > 0) {
            punishedUserDialog.viewSizeChanged = true;
            kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.getLayoutParams().height += height;
            kakaoGameProtectedUserRestrictGuideBinding.kakaoGameProtectedPopupDetailReasonDump.setVisibility(8);
        }
        kakaoGameProtectedUserRestrictGuideBinding.kakaoGameProtectedPopupDetailReason.setText(punishedUserDialog.message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showAgreement() {
        startTerminateTimer(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
        final KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.unregisterAgreementView.getRoot().setVisibility(0);
        if (this.viewSizeChanged) {
            this.viewSizeChanged = false;
            ValueAnimator ofInt = ValueAnimator.ofInt(kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.getMeasuredHeight(), this.activity.getResources().getDimensionPixelSize(C2382R.dimen.sdk_2nd_protected_user_popup_height));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda8
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PunishedUserDialog.showAgreement$lambda$14$lambda$9(KakaoGameProtectedUserPopupBinding.this, valueAnimator);
                }
            });
            ofInt.setDuration(500L);
            ofInt.start();
        }
        final KakaoGameProtectedUserUnregisterAgreementBinding bind = KakaoGameProtectedUserUnregisterAgreementBinding.bind(kakaoGameProtectedUserPopupBinding.unregisterAgreementView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        NotoSansButton notoSansButton = kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm;
        Intrinsics.checkNotNullExpressionValue(notoSansButton, y.ٲٴݴ״ٰ(1782150016));
        setEnable(notoSansButton, bind.kakaoGameProtectedPopupCheckBoxOn.getVisibility() == 0);
        bind.kakaoGameProtectedPopupCheckBoxOff.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.showAgreement$lambda$14$lambda$13$lambda$10(KakaoGameProtectedUserUnregisterAgreementBinding.this, this, kakaoGameProtectedUserPopupBinding, view);
            }
        });
        bind.kakaoGameProtectedPopupCheckBoxOn.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.showAgreement$lambda$14$lambda$13$lambda$11(KakaoGameProtectedUserUnregisterAgreementBinding.this, this, kakaoGameProtectedUserPopupBinding, view);
            }
        });
        bind.kakaoSdkProtectedUserPopupAgreementBtn.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.showAgreement$lambda$14$lambda$13$lambda$12(PunishedUserDialog.this, view);
            }
        });
        bind.kakaoGameProtectedPopupAgreementTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_popup_agreement_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_agreement_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupCancel.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_disagree)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_agree)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreement$lambda$14$lambda$9(KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(kakaoGameProtectedUserPopupBinding, y.ݬֲ֮ܲت(1512392063));
        Intrinsics.checkNotNullParameter(valueAnimator, y.٬ݯح׭٩(576695166));
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, y.ۮڭڭܬި(862379403));
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.getLayoutParams();
        layoutParams.height = intValue;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreement$lambda$14$lambda$13$lambda$10(KakaoGameProtectedUserUnregisterAgreementBinding this_apply, PunishedUserDialog this$0, KakaoGameProtectedUserPopupBinding this_apply$1, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply$1, "$this_apply$1");
        this_apply.kakaoGameProtectedPopupCheckBoxOn.setVisibility(0);
        NotoSansButton kakaoGameProtectedPopupConfirm = this_apply$1.kakaoGameProtectedPopupConfirm;
        Intrinsics.checkNotNullExpressionValue(kakaoGameProtectedPopupConfirm, "kakaoGameProtectedPopupConfirm");
        this$0.setEnable(kakaoGameProtectedPopupConfirm, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreement$lambda$14$lambda$13$lambda$11(KakaoGameProtectedUserUnregisterAgreementBinding this_apply, PunishedUserDialog this$0, KakaoGameProtectedUserPopupBinding this_apply$1, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply$1, "$this_apply$1");
        this_apply.kakaoGameProtectedPopupCheckBoxOn.setVisibility(8);
        NotoSansButton kakaoGameProtectedPopupConfirm = this_apply$1.kakaoGameProtectedPopupConfirm;
        Intrinsics.checkNotNullExpressionValue(kakaoGameProtectedPopupConfirm, "kakaoGameProtectedPopupConfirm");
        this$0.setEnable(kakaoGameProtectedPopupConfirm, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreement$lambda$14$lambda$13$lambda$12(PunishedUserDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectView(ViewType.AGREEMENT_DETAIL);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showAgreementDetail() {
        String str;
        this.viewSizeChanged = true;
        int dimensionPixelSize = this.activity.getResources().getDimensionPixelSize(C2382R.dimen.sdk_2nd_protected_user_popup_web_height);
        final KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        if (dimensionPixelSize >= DisplayUtil.getDisplayHeight(this.activity)) {
            dimensionPixelSize = (int) (DisplayUtil.getDisplayHeight(this.activity) * 0.96d);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.getMeasuredHeight(), dimensionPixelSize);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                PunishedUserDialog.showAgreementDetail$lambda$18$lambda$15(KakaoGameProtectedUserPopupBinding.this, valueAnimator);
            }
        });
        ofInt.setDuration(500L);
        ofInt.start();
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.webView.getRoot().setVisibility(0);
        KakaoGameProtectedUserWebviewBinding bind = KakaoGameProtectedUserWebviewBinding.bind(kakaoGameProtectedUserPopupBinding.webView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.webContent.getSettings().setMixedContentMode(0);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(bind.webContent, true);
        StringBuilder append = new StringBuilder().append(InfodeskHelper.INSTANCE.getUnregisterAgreementUrl()).append(y.دײܮڳܯ(2051370421));
        String countryCode = KGSystem.getCountryCode();
        String str2 = y.ݮڮֲڭܩ(-628797244);
        String str3 = null;
        if (countryCode != null) {
            str = countryCode.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, str2);
        } else {
            str = null;
        }
        StringBuilder append2 = append.append(str).append(y.ٲٴݴ״ٰ(1782150920));
        String languageCode = KGSystem.getLanguageCode();
        if (languageCode != null) {
            str3 = languageCode.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str3, str2);
        }
        String sb = append2.append(str3).toString();
        Activity activity = this.activity;
        WebView webView = bind.webContent;
        Intrinsics.checkNotNullExpressionValue(webView, y.ݮڮֲڭܩ(-628597748));
        new WebViewContainerImpl(this, activity, webView).initCookies(this.activity, sb);
        bind.webContent.loadUrl(sb);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_agreement_detail_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_confirm)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.showAgreementDetail$lambda$18$lambda$17(PunishedUserDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreementDetail$lambda$18$lambda$15(KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(kakaoGameProtectedUserPopupBinding, y.ݬֲ֮ܲت(1512392063));
        Intrinsics.checkNotNullParameter(valueAnimator, y.٬ݯح׭٩(576695166));
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, y.ۮڭڭܬި(862379403));
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.getLayoutParams();
        layoutParams.height = intValue;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupViewBack.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAgreementDetail$lambda$18$lambda$17(PunishedUserDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectView(this$0.getNextView(this$0.currentView));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showConfirmCode() {
        final KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.confirmCodeView.getRoot().setVisibility(0);
        NotoSansButton notoSansButton = kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm;
        Intrinsics.checkNotNullExpressionValue(notoSansButton, y.ٲٴݴ״ٰ(1782150016));
        setEnable(notoSansButton, false);
        final String string = ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_confirm_code);
        KakaoGameProtectedUserConfirmCodeBinding bind = KakaoGameProtectedUserConfirmCodeBinding.bind(kakaoGameProtectedUserPopupBinding.confirmCodeView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        NotoSansEditText notoSansEditText = bind.kakaoGameConfirmCodeInput;
        Intrinsics.checkNotNullExpressionValue(notoSansEditText, y.ݬֲ֮ܲت(1512391463));
        notoSansEditText.addTextChangedListener(new TextWatcher() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showConfirmCode$lambda$22$lambda$21$$inlined$addTextChangedListener$default$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    PunishedUserDialog punishedUserDialog = PunishedUserDialog.this;
                    NotoSansButton notoSansButton2 = kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm;
                    Intrinsics.checkNotNullExpressionValue(notoSansButton2, y.ٲٴݴ״ٰ(1782150016));
                    punishedUserDialog.setEnable(notoSansButton2, Intrinsics.areEqual(s.toString(), string));
                }
            }
        });
        bind.kakaoGameConfirmCodeGuide.setText(StyleTextKt.getString(StyleTextKt.styleText(new Function1<StyleTextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showConfirmCode$1$1$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StyleTextBuilder styleTextBuilder) {
                invoke2(styleTextBuilder);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StyleTextBuilder styleTextBuilder) {
                Intrinsics.checkNotNullParameter(styleTextBuilder, y.ٴسسݬߨ(1393323090));
                final PunishedUserDialog punishedUserDialog = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showConfirmCode$1$1$2.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog2 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.1.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(PunishedUserDialog.this.getActivity(), C2382R.string.kakao_game_sdk_protected_user_confirm_code_guide_pre);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.1.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
                final PunishedUserDialog punishedUserDialog2 = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showConfirmCode$1$1$2.2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog3 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.2.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(PunishedUserDialog.this.getActivity(), C2382R.string.kakao_game_sdk_protected_user_unregister_confirm_code_string);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.2.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.֬ڱܱײٮ(-1158918439)};
                            }
                        });
                    }
                });
                final PunishedUserDialog punishedUserDialog3 = PunishedUserDialog.this;
                styleTextBuilder.string(new Function1<TextBuilder, Unit>() { // from class: com.kakaogame.auth.view.PunishedUserDialog$showConfirmCode$1$1$2.3
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(1);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextBuilder textBuilder) {
                        invoke2(textBuilder);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextBuilder textBuilder) {
                        Intrinsics.checkNotNullParameter(textBuilder, y.ݬֲ֮ܲت(1512388847));
                        final PunishedUserDialog punishedUserDialog4 = PunishedUserDialog.this;
                        textBuilder.text(new Function0<String>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.3.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(0);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return ResourceUtil.getString(PunishedUserDialog.this.getActivity(), C2382R.string.kakao_game_sdk_protected_user_confirm_code_guide_post);
                            }
                        });
                        textBuilder.styles(new Function0<String[]>() { // from class: com.kakaogame.auth.view.PunishedUserDialog.showConfirmCode.1.1.2.3.2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function0
                            public final String[] invoke() {
                                return new String[]{y.ۮڭڭܬި(862484995)};
                            }
                        });
                    }
                });
            }
        })));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupCancel.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_cancel)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_confirm)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showUnregisterGuide() {
        KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.unregisterConfirmView.getRoot().setVisibility(0);
        KakaoGameProtectedUserUnregisterConfirmBinding bind = KakaoGameProtectedUserUnregisterConfirmBinding.bind(kakaoGameProtectedUserPopupBinding.unregisterConfirmView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGameUnregisterGuideView.setText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_guide));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupCancel.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_cancel)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupConfirm.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_confirm)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void requestUnregister() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PunishedUserDialog$requestUnregister$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showUnregisterEnd(final int resultCode) {
        KakaoGameProtectedUserPopupBinding kakaoGameProtectedUserPopupBinding = this.binding;
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedButtonLayout.setVisibility(8);
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setVisibility(0);
        kakaoGameProtectedUserPopupBinding.unregisterConfirmView.getRoot().setVisibility(0);
        KakaoGameProtectedUserUnregisterConfirmBinding bind = KakaoGameProtectedUserUnregisterConfirmBinding.bind(kakaoGameProtectedUserPopupBinding.unregisterConfirmView.getRoot());
        Intrinsics.checkNotNullExpressionValue(bind, y.ݬֲ֮ܲت(1512391959));
        bind.kakaoGameUnregisterGuideView.setText(resultCode == 200 ? ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_done) : ResourceUtil.getString(this.activity, C2382R.string.zinny_sdk_error_msg_common, Integer.valueOf(resultCode)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupTitle.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_title)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setText(StyleTextKt.getBoldText(ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_protected_user_unregister_confirm)));
        kakaoGameProtectedUserPopupBinding.kakaoGameProtectedPopupClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PunishedUserDialog.showUnregisterEnd$lambda$27$lambda$26(PunishedUserDialog.this, resultCode, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUnregisterEnd$lambda$27$lambda$26(PunishedUserDialog this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        this$0.callbackResult(i == 200 ? RESULT_UNREGISTERED : RESULT_TERMINATE);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PunishedUserDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/auth/view/PunishedUserDialog$ViewType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "NOTICE", "EMAIL", "AGREEMENT", "CONFIRM_CODE", "UNREGISTER_GUIDE", "UNREGISTER_CONFIRM", "AGREEMENT_DETAIL", "CLOSE", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class ViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewType[] $VALUES;
        private final int value;
        public static final ViewType NOTICE = new ViewType(y.دײܮڳܯ(2051551133), 0, 0);
        public static final ViewType EMAIL = new ViewType(y.֬ڱܱײٮ(-1158918911), 1, 1);
        public static final ViewType AGREEMENT = new ViewType(y.دײܮڳܯ(2051346949), 2, 2);
        public static final ViewType CONFIRM_CODE = new ViewType(y.دײܮڳܯ(2051347133), 3, 3);
        public static final ViewType UNREGISTER_GUIDE = new ViewType(y.֬ڱܱײٮ(-1158919167), 4, 4);
        public static final ViewType UNREGISTER_CONFIRM = new ViewType(y.ٴسسݬߨ(1393299858), 5, 5);
        public static final ViewType AGREEMENT_DETAIL = new ViewType(y.٬ݯح׭٩(576706142), 6, 6);
        public static final ViewType CLOSE = new ViewType(y.ۮڭڭܬި(862485451), 7, 7);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{NOTICE, EMAIL, AGREEMENT, CONFIRM_CODE, UNREGISTER_GUIDE, UNREGISTER_CONFIRM, AGREEMENT_DETAIL, CLOSE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<ViewType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ViewType valueOf(String str) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ViewType(String str, int i, int i2) {
            this.value = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            ViewType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ViewType getNextView(ViewType viewType) {
        int i = WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()];
        if (i == 1) {
            return ViewType.AGREEMENT;
        }
        if (i == 2) {
            return ViewType.AGREEMENT;
        }
        if (i == 4) {
            return ViewType.CONFIRM_CODE;
        }
        if (i == 5) {
            return ViewType.UNREGISTER_GUIDE;
        }
        if (i == 6) {
            return ViewType.UNREGISTER_CONFIRM;
        }
        if (i == 7) {
            return ViewType.CLOSE;
        }
        return ViewType.CLOSE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ViewType getCancelView(ViewType viewType) {
        int i = WhenMappings.$EnumSwitchMapping$0[viewType.ordinal()];
        if (i == 1) {
            return ViewType.AGREEMENT;
        }
        if (i == 2) {
            return ViewType.EMAIL;
        }
        if (i == 4 || i == 5 || i == 6) {
            return ViewType.CLOSE;
        }
        return ViewType.CLOSE;
    }

    /* compiled from: PunishedUserDialog.kt */
    @Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J&\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/auth/view/PunishedUserDialog$WebViewContainerImpl;", "Lcom/kakaogame/web/WebViewContainer;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "(Lcom/kakaogame/auth/view/PunishedUserDialog;Landroid/app/Activity;Landroid/webkit/WebView;)V", "onHideCustomView", "", "onJsAlert", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "message", "result", "Landroid/webkit/JsResult;", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedTitle", "title", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    protected final class WebViewContainerImpl extends WebViewContainer {
        final /* synthetic */ PunishedUserDialog this$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        public void onHideCustomView() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onPageFinished(WebView view, String url) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedTitle(WebView view, String title) {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebViewContainerImpl(PunishedUserDialog punishedUserDialog, Activity activity, WebView webView) {
            super(activity, webView, null, 0, 12, null);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
            this.this$0 = punishedUserDialog;
            webView.getSettings().setTextZoom(100);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            DialogManager.Settings settings = new DialogManager.Settings(null, null, message, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.PunishedUserDialog$WebViewContainerImpl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PunishedUserDialog.WebViewContainerImpl.onJsAlert$lambda$0(result, dialogInterface, i);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(getActivity(), settings);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void onJsAlert$lambda$0(JsResult jsResult, DialogInterface dialogInterface, int i) {
            if (jsResult != null) {
                jsResult.confirm();
            }
            dialogInterface.dismiss();
        }
    }
}
