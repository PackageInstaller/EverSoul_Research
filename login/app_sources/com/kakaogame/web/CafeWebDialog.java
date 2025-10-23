package com.kakaogame.web;

import android.app.Activity;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.kakaogame.C2382R;
import com.kakaogame.Logger;
import com.kakaogame.databinding.ZinnySdkCafeDialogWebKakaoBinding;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.web.WebDialog;
import com.liapp.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CafeWebDialog.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/web/CafeWebDialog;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webUrl", "", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;)V", "cafeBinding", "Lcom/kakaogame/databinding/ZinnySdkCafeDialogWebKakaoBinding;", "getCafeBinding", "()Lcom/kakaogame/databinding/ZinnySdkCafeDialogWebKakaoBinding;", "cafeBinding$delegate", "Lkotlin/Lazy;", "initViews", "", "setMargin", "cutoutSize", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CafeWebDialog extends WebDialog {
    private static final String TAG = "CafeWebDialog";

    /* renamed from: cafeBinding$delegate, reason: from kotlin metadata */
    private final Lazy cafeBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CafeWebDialog(Activity activity, String str, WebDialog.Settings settings) {
        super(activity, str, settings);
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(settings);
        this.cafeBinding = LazyKt.lazy(new Function0<ZinnySdkCafeDialogWebKakaoBinding>() { // from class: com.kakaogame.web.CafeWebDialog$cafeBinding$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final ZinnySdkCafeDialogWebKakaoBinding invoke() {
                return ZinnySdkCafeDialogWebKakaoBinding.inflate(CafeWebDialog.this.getLayoutInflater());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ZinnySdkCafeDialogWebKakaoBinding getCafeBinding() {
        return (ZinnySdkCafeDialogWebKakaoBinding) this.cafeBinding.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog
    protected void initViews() {
        setContentView(getCafeBinding().getRoot());
        final ZinnySdkCafeDialogWebKakaoBinding cafeBinding = getCafeBinding();
        WebView webView = cafeBinding.zinnySdkDialogWebContent;
        String str = y.ݮڮֲڭܩ(-628487844);
        Intrinsics.checkNotNullExpressionValue(webView, str);
        setWebView(webView);
        SwipeRefreshLayout swipeRefreshLayout = cafeBinding.zinnySdkDialogWebLayout;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, y.دײܮڳܯ(2051489709));
        setWebLayout(swipeRefreshLayout);
        this.logoView = cafeBinding.zinnySdkDialogCafeLogo;
        this.backView = cafeBinding.zinnySdkDialogWebTopbarBack;
        if (this.settings.getBackgroundColor() != Integer.MAX_VALUE) {
            cafeBinding.zinnySdkDialogWebMain.setBackgroundColor(this.settings.getBackgroundColor());
        }
        getWebView().getSettings().setMixedContentMode(0);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(getWebView(), true);
        getWebLayout().setEnabled(true);
        getWebLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kakaogame.web.CafeWebDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CafeWebDialog.initViews$lambda$3$lambda$0(CafeWebDialog.this, cafeBinding);
            }
        });
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        WebView webView2 = cafeBinding.zinnySdkDialogWebContent;
        Intrinsics.checkNotNullExpressionValue(webView2, str);
        this.container = new WebDialog.WebViewContainerImpl(this, ownerActivity, webView2, this.settings);
        if (!InfodeskHelper.INSTANCE.offWebViewPopupUI() && !TextUtils.isEmpty(this.webUrl) && StringsKt.contains$default((CharSequence) this.webUrl, (CharSequence) y.ٲٴݴ״ٰ(1782578536), false, 2, (Object) null)) {
            WebSettings settings = cafeBinding.zinnySdkDialogWebContent.getSettings();
            Intrinsics.checkNotNullExpressionValue(settings, y.ۮڭڭܬި(862808243));
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setSupportMultipleWindows(true);
        }
        View view = this.backView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.CafeWebDialog$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CafeWebDialog.initViews$lambda$3$lambda$1(CafeWebDialog.this, view2);
                }
            });
        }
        cafeBinding.zinnySdkDialogWebTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.CafeWebDialog$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CafeWebDialog.initViews$lambda$3$lambda$2(CafeWebDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$3$lambda$0(CafeWebDialog cafeWebDialog, ZinnySdkCafeDialogWebKakaoBinding zinnySdkCafeDialogWebKakaoBinding) {
        Intrinsics.checkNotNullParameter(cafeWebDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(zinnySdkCafeDialogWebKakaoBinding, y.ݬֲ֮ܲت(1512392063));
        cafeWebDialog.getWebLayout().setRefreshing(true);
        zinnySdkCafeDialogWebKakaoBinding.zinnySdkDialogWebContent.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$3$lambda$1(CafeWebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebViewContainer webViewContainer = this$0.container;
        Intrinsics.checkNotNull(webViewContainer);
        if (webViewContainer.hasInnerPopupView()) {
            WebViewContainer webViewContainer2 = this$0.container;
            Intrinsics.checkNotNull(webViewContainer2);
            webViewContainer2.goBackInnerPopupView();
        } else {
            if (this$0.getWebView().canGoBack()) {
                this$0.getWebView().goBack();
                return;
            }
            View view2 = this$0.backView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            View view3 = this$0.logoView;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$3$lambda$2(CafeWebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.settings.getCloseListener() != null) {
            WebDialog.OnCloseListener closeListener = this$0.settings.getCloseListener();
            Intrinsics.checkNotNull(closeListener);
            closeListener.onClose(this$0);
            return;
        }
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog
    protected void setMargin(int cutoutSize) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        RelativeLayout relativeLayout = getCafeBinding().zinnySdkDialogWeb;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, y.ٲٴݴ״ٰ(1782578656));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        Point currentWindowMetricsPointCompat = DisplayUtil.getCurrentWindowMetricsPointCompat(ownerActivity);
        int i = currentWindowMetricsPointCompat.y;
        int i2 = currentWindowMetricsPointCompat.x;
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393222610) + i2 + y.ݮڮֲڭܩ(-628176812) + i;
        String str2 = y.ۮڭڭܬި(862885283);
        logger.m699d(str2, str);
        Activity ownerActivity2 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity2);
        boolean isScreenPortrait = DisplayUtil.isScreenPortrait(ownerActivity2);
        Activity ownerActivity3 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity3);
        int dimensionPixelSize = (i - ownerActivity3.getResources().getDimensionPixelSize(this.settings.getHeight(isScreenPortrait))) / 2;
        Activity ownerActivity4 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity4);
        this.viewMargin = Math.min(dimensionPixelSize, (i2 - ownerActivity4.getResources().getDimensionPixelSize(this.settings.getWidth(isScreenPortrait))) / 2);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(relativeLayout.getLayoutParams());
        Activity ownerActivity5 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity5);
        int dimensionPixelSize2 = ownerActivity5.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_menu_tab);
        Activity ownerActivity6 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity6);
        int dimensionPixelSize3 = ownerActivity6.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_title);
        String str3 = y.ٴسسݬߨ(1393229138);
        String str4 = y.ݬֲ֮ܲت(1512298015);
        String str5 = y.ٲٴݴ״ٰ(1782571768);
        String str6 = y.ٲٴݴ״ٰ(1782571376);
        String str7 = y.ݬֲ֮ܲت(1512297807);
        String str8 = y.ٲٴݴ״ٰ(1782571128);
        String str9 = y.٬ݯح׭٩(576273446);
        String str10 = y.֬ڱܱײٮ(-1159027311);
        if (isScreenPortrait) {
            Activity ownerActivity7 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity7);
            int dimensionPixelSize4 = ownerActivity7.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_min_bottom_margin);
            Activity ownerActivity8 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity8);
            int dimensionPixelSize5 = ownerActivity8.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_min_side_margin);
            Logger.INSTANCE.m699d(str2, str10 + dimensionPixelSize3 + str9 + dimensionPixelSize2 + str8 + dimensionPixelSize4 + str7 + dimensionPixelSize5);
            int i3 = i2 - (dimensionPixelSize5 * 2);
            int i4 = (i3 * 155) / 100;
            int i5 = ((i - i4) - dimensionPixelSize2) - dimensionPixelSize3;
            if (i5 < dimensionPixelSize4) {
                i4 = ((i - dimensionPixelSize2) - dimensionPixelSize3) - dimensionPixelSize4;
                i3 = (i4 * 100) / 155;
                dimensionPixelSize5 = (i2 - i3) / 2;
            } else {
                dimensionPixelSize4 = i5;
            }
            Logger.INSTANCE.m699d(str2, str6 + i4 + str5 + i3);
            Logger.INSTANCE.m699d(str2, str4 + dimensionPixelSize5 + str3 + dimensionPixelSize4);
            marginLayoutParams2.setMargins(dimensionPixelSize5, cutoutSize, dimensionPixelSize5, dimensionPixelSize4);
            marginLayoutParams = marginLayoutParams2;
        } else {
            Activity ownerActivity9 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity9);
            int dimensionPixelSize6 = ownerActivity9.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_land_min_bottom_margin);
            Activity ownerActivity10 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity10);
            int dimensionPixelSize7 = ownerActivity10.getResources().getDimensionPixelSize(C2382R.dimen.sdk_cafe_land_min_side_margin);
            Logger.INSTANCE.m699d(str2, str10 + dimensionPixelSize3 + str9 + dimensionPixelSize2 + str8 + dimensionPixelSize6 + str7 + dimensionPixelSize7);
            int i6 = i - dimensionPixelSize3;
            int i7 = i6 - dimensionPixelSize6;
            int i8 = i7 * 2;
            int i9 = ((i2 - i8) - dimensionPixelSize2) / 2;
            if (i9 < dimensionPixelSize7) {
                i8 = (i2 - dimensionPixelSize2) - (dimensionPixelSize7 * 2);
                i7 = i8 / 2;
                dimensionPixelSize6 = i6 - i7;
            } else {
                dimensionPixelSize7 = i9;
            }
            Logger.INSTANCE.m699d(str2, str6 + i7 + str5 + i8);
            Logger.INSTANCE.m699d(str2, str4 + dimensionPixelSize7 + str3 + dimensionPixelSize6);
            Activity ownerActivity11 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity11);
            if (DisplayUtil.getLandscapeDirection(ownerActivity11) == 0) {
                marginLayoutParams = marginLayoutParams2;
                marginLayoutParams.setMargins(dimensionPixelSize7 + cutoutSize, 0, dimensionPixelSize7, dimensionPixelSize6);
            } else {
                marginLayoutParams = marginLayoutParams2;
                Activity ownerActivity12 = getOwnerActivity();
                Intrinsics.checkNotNull(ownerActivity12);
                if (DisplayUtil.getLandscapeDirection(ownerActivity12) == 1) {
                    marginLayoutParams.setMargins(dimensionPixelSize7, 0, dimensionPixelSize7 + cutoutSize, dimensionPixelSize6);
                }
            }
        }
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(marginLayoutParams));
    }
}
