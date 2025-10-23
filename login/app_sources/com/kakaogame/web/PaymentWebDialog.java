package com.kakaogame.web;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.C2382R;
import com.kakaogame.Logger;
import com.kakaogame.web.WebDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PaymentWebDialog.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/web/PaymentWebDialog;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webUrl", "", "closeUrl", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/web/PaymentWebDialog$Listener;", "checkCloseUrl", "", "createContainer", "", "webView", "Landroid/webkit/WebView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setListener", "Companion", "Listener", "PaymentWebViewContainer", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PaymentWebDialog extends WebDialog {
    private static final String TAG = "PaymentWebDialog";
    private final String closeUrl;
    private Listener listener;

    /* compiled from: PaymentWebDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/web/PaymentWebDialog$Listener;", "", "onCallbackError", "", "onCanceled", "onSuccess", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface Listener {
        void onCallbackError();

        void onCanceled();

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PaymentWebDialog(Activity activity, String str, String str2, WebDialog.Settings settings) {
        super(activity, str, settings);
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(settings);
        this.closeUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.web.PaymentWebDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$0;
                onCreate$lambda$0 = PaymentWebDialog.onCreate$lambda$0(PaymentWebDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$0;
            }
        });
        findViewById(C2382R.id.zinny_sdk_dialog_web_topbar_close).setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.PaymentWebDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PaymentWebDialog.onCreate$lambda$1(PaymentWebDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$0(PaymentWebDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        WebViewContainer webViewContainer = this$0.container;
        Intrinsics.checkNotNull(webViewContainer);
        if (webViewContainer.hasInnerPopupView()) {
            WebViewContainer webViewContainer2 = this$0.container;
            Intrinsics.checkNotNull(webViewContainer2);
            webViewContainer2.goBackInnerPopupView();
            return true;
        }
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393228746), y.ٲٴݴ״ٰ(1782572512) + this$0.getWebView().canGoBack());
        WebViewContainer webViewContainer3 = this$0.container;
        Intrinsics.checkNotNull(webViewContainer3, "null cannot be cast to non-null type com.kakaogame.web.WebDialog.WebViewContainerImpl");
        if (((WebDialog.WebViewContainerImpl) webViewContainer3).getCustomView() != null) {
            WebViewContainer webViewContainer4 = this$0.container;
            Intrinsics.checkNotNull(webViewContainer4);
            webViewContainer4.onHideCustomView();
        } else if (this$0.getWebView().canGoBack()) {
            this$0.getWebView().goBack();
        } else {
            Listener listener = this$0.listener;
            if (listener != null) {
                Intrinsics.checkNotNull(listener);
                listener.onCanceled();
            }
            this$0.dismiss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onCreate$lambda$1(PaymentWebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Listener listener = this$0.listener;
        if (listener != null) {
            Intrinsics.checkNotNull(listener);
            listener.onCanceled();
        }
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog
    protected void createContainer(Activity activity, WebView webView, WebDialog.Settings settings) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        this.container = new PaymentWebViewContainer(this, activity, webView, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkCloseUrl(String webUrl) {
        String str = this.closeUrl;
        if (str != null) {
            return StringsKt.equals(webUrl, str, true);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    /* compiled from: PaymentWebDialog.kt */
    @Metadata(m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J&\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0015J.\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0014J&\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0015J&\u0010\u001b\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0014¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/web/PaymentWebDialog$PaymentWebViewContainer;", "Lcom/kakaogame/web/WebDialog$WebViewContainerImpl;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Lcom/kakaogame/web/PaymentWebDialog;Landroid/app/Activity;Landroid/webkit/WebView;Lcom/kakaogame/web/WebDialog$Settings;)V", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private final class PaymentWebViewContainer extends WebDialog.WebViewContainerImpl {
        final /* synthetic */ PaymentWebDialog this$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PaymentWebViewContainer(PaymentWebDialog paymentWebDialog, Activity activity, WebView webView, WebDialog.Settings settings) {
            super(paymentWebDialog, activity, webView, settings);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
            Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
            this.this$0 = paymentWebDialog;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            PaymentWebDialog paymentWebDialog = this.this$0;
            Intrinsics.checkNotNull(view);
            if (paymentWebDialog.checkCloseUrl(view.getUrl())) {
                Listener listener = this.this$0.listener;
                Intrinsics.checkNotNull(listener);
                listener.onCallbackError();
                this.this$0.dismiss();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            PaymentWebDialog paymentWebDialog = this.this$0;
            Intrinsics.checkNotNull(view);
            if (paymentWebDialog.checkCloseUrl(view.getUrl())) {
                Listener listener = this.this$0.listener;
                Intrinsics.checkNotNull(listener);
                listener.onCallbackError();
                this.this$0.dismiss();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            PaymentWebDialog paymentWebDialog = this.this$0;
            Intrinsics.checkNotNull(request);
            if (!paymentWebDialog.checkCloseUrl(request.getUrl().toString())) {
                PaymentWebDialog paymentWebDialog2 = this.this$0;
                Intrinsics.checkNotNull(view);
                if (!paymentWebDialog2.checkCloseUrl(view.getUrl())) {
                    return;
                }
            }
            Listener listener = this.this$0.listener;
            Intrinsics.checkNotNull(listener);
            listener.onCallbackError();
            this.this$0.dismiss();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebDialog.WebViewContainerImpl, com.kakaogame.web.WebViewContainer
        protected void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (this.this$0.checkCloseUrl(url)) {
                Listener listener = this.this$0.listener;
                Intrinsics.checkNotNull(listener);
                listener.onSuccess();
                this.this$0.dismiss();
            }
        }
    }
}
