package com.kakaogame.idp;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakaogame.Logger;
import com.kakaogame.apple.databinding.KakaoSdkSiwaDialogBinding;
import com.kakaogame.idp.SIWAWebDialog;
import com.kakaogame.p029ui.DeepLinkManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.web.WebDialog;
import com.kakaogame.web.WebViewContainer;
import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SIWAWebDialog.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/idp/SIWAWebDialog;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webUrl", "", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;)V", "responseData", "siwaWebBinding", "Lcom/kakaogame/apple/databinding/KakaoSdkSiwaDialogBinding;", "initViews", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "SIWAWebViewContainerImpl", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SIWAWebDialog extends WebDialog {
    private static final String TAG = "SIWAWebDialog";
    private static final String closeWebAppProtocol = "zinny://closeview";
    private static final String responseWebAppProtocol = "zinny://siwaResponse";
    public String responseData;
    private KakaoSdkSiwaDialogBinding siwaWebBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SIWAWebDialog(Activity activity, String str, WebDialog.Settings settings) {
        super(activity, str, settings);
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(settings);
        this.responseData = "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog
    protected void initViews() {
        KakaoSdkSiwaDialogBinding inflate = KakaoSdkSiwaDialogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        this.siwaWebBinding = inflate;
        KakaoSdkSiwaDialogBinding kakaoSdkSiwaDialogBinding = null;
        String str = y.دײܮڳܯ(2051489533);
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            inflate = null;
        }
        setContentView(inflate.getRoot());
        KakaoSdkSiwaDialogBinding kakaoSdkSiwaDialogBinding2 = this.siwaWebBinding;
        if (kakaoSdkSiwaDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            kakaoSdkSiwaDialogBinding = kakaoSdkSiwaDialogBinding2;
        }
        WebView webView = kakaoSdkSiwaDialogBinding.zinnySdkDialogWebContent;
        Intrinsics.checkNotNullExpressionValue(webView, y.ݮڮֲڭܩ(-628487844));
        setWebView(webView);
        getWebView().getSettings().setMixedContentMode(0);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(getWebView(), true);
        SwipeRefreshLayout swipeRefreshLayout = kakaoSdkSiwaDialogBinding.zinnySdkDialogWebLayout;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, y.دײܮڳܯ(2051489709));
        setWebLayout(swipeRefreshLayout);
        getWebLayout().setEnabled(true);
        getWebLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kakaogame.idp.SIWAWebDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SIWAWebDialog.initViews$lambda$2$lambda$0(SIWAWebDialog.this);
            }
        });
        setTopbarView(kakaoSdkSiwaDialogBinding.zinnySdkDialogWebTopbar);
        this.backView = kakaoSdkSiwaDialogBinding.zinnySdkDialogWebTopbarBack;
        kakaoSdkSiwaDialogBinding.zinnySdkDialogWebTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.idp.SIWAWebDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SIWAWebDialog.initViews$lambda$2$lambda$1(SIWAWebDialog.this, view);
            }
        });
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        this.container = new SIWAWebViewContainerImpl(this, ownerActivity, getWebView());
        WebViewContainer webViewContainer = this.container;
        Intrinsics.checkNotNull(webViewContainer);
        webViewContainer.initCookies(getContext(), this.webUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$2$lambda$0(SIWAWebDialog sIWAWebDialog) {
        Intrinsics.checkNotNullParameter(sIWAWebDialog, y.ٴسسݬߨ(1393322442));
        sIWAWebDialog.getWebLayout().setRefreshing(true);
        sIWAWebDialog.getWebView().reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$2$lambda$1(SIWAWebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog, com.kakaogame.KGActivityManager.ConfigChangeListener
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782267840), y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + getPreOrientation());
        if (getPreOrientation() < 0 || newConfig.orientation != getPreOrientation() || getPreScreenLayout() < 0 || newConfig.screenLayout != getPreScreenLayout()) {
            KakaoSdkSiwaDialogBinding inflate = KakaoSdkSiwaDialogBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            this.siwaWebBinding = inflate;
            initViews();
            setDialogVisibility();
            Activity ownerActivity = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            setMargin(DisplayUtil.checkCutout(ownerActivity));
            if (getPostData() == null) {
                getWebView().loadUrl(this.webUrl);
            } else {
                WebView webView = getWebView();
                String str = this.webUrl;
                byte[] postData = getPostData();
                Intrinsics.checkNotNull(postData);
                webView.postUrl(str, postData);
            }
        }
        setPreOrientation(newConfig.orientation);
        setPreScreenLayout(newConfig.screenLayout);
    }

    /* compiled from: SIWAWebDialog.kt */
    @Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J&\u0010\u0012\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u0017\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/idp/SIWAWebDialog$SIWAWebViewContainerImpl;", "Lcom/kakaogame/web/WebViewContainer;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "(Lcom/kakaogame/idp/SIWAWebDialog;Landroid/app/Activity;Landroid/webkit/WebView;)V", "onHideCustomView", "", "onJsAlert", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "message", "result", "Landroid/webkit/JsResult;", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedTitle", "title", "shouldOverrideUrlLoading", "idp_siwa_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    protected final class SIWAWebViewContainerImpl extends WebViewContainer {
        final /* synthetic */ SIWAWebDialog this$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        public void onHideCustomView() {
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
        public SIWAWebViewContainerImpl(SIWAWebDialog sIWAWebDialog, Activity activity, WebView webView) {
            super(activity, webView, null, 0, 12, null);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
            this.this$0 = sIWAWebDialog;
            webView.getSettings().setTextZoom(100);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected boolean shouldOverrideUrlLoading(WebView view, String url) {
            Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782267840), y.ݮڮֲڭܩ(-628484836) + url);
            if (url != null) {
                Locale locale = Locale.getDefault();
                String str = y.֬ڱܱײٮ(-1158775023);
                Intrinsics.checkNotNullExpressionValue(locale, str);
                String lowerCase = url.toLowerCase(locale);
                String str2 = y.ݮڮֲڭܩ(-628797244);
                Intrinsics.checkNotNullExpressionValue(lowerCase, str2);
                Locale locale2 = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale2, str);
                String lowerCase2 = y.֬ڱܱײٮ(-1158774903).toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, str2);
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    this.this$0.responseData = url;
                    this.this$0.dismiss();
                    return true;
                }
                if (DeepLinkManager.INSTANCE.isPlatformDeepLink(url)) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C2412x7784436d(this, url, null), 3, null);
                    return true;
                }
                if (StringsKt.equals(url, y.֬ڱܱײٮ(-1158775207), true)) {
                    this.this$0.dismiss();
                    return true;
                }
                if (StringsKt.startsWith$default(url, y.ٲٴݴ״ٰ(1782267112), false, 2, (Object) null)) {
                    AppUtil.launchIntent(getActivity(), url);
                    return true;
                }
                if (WebViewContainer.INSTANCE.handleCustomScheme(getActivity(), url)) {
                    this.this$0.dismiss();
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onPageFinished(WebView view, String url) {
            if (this.this$0.getWebLayout().isRefreshing()) {
                this.this$0.getWebLayout().setRefreshing(false);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            DialogManager.Settings settings = new DialogManager.Settings(null, null, message, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.idp.SIWAWebDialog$SIWAWebViewContainerImpl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SIWAWebDialog.SIWAWebViewContainerImpl.onJsAlert$lambda$0(result, dialogInterface, i);
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
