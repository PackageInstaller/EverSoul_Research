package com.kakaogame.twitter;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TwitterOAuthWebViewClient.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0003H\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0003H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/twitter/TwitterOAuthWebViewClient;", "Landroid/webkit/WebViewClient;", "completeUrl", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$Listener;", "(Ljava/lang/String;Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$Listener;)V", "handleUrl", "", "url", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "Listener", "WebViewException", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TwitterOAuthWebViewClient extends WebViewClient {
    private final String completeUrl;
    private final Listener listener;

    /* compiled from: TwitterOAuthWebViewClient.kt */
    @Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0018\u00010\nR\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$Listener;", "", "onComplete", "", ServerConstants.TRACE_RESULT_CODE, "", "data", "Landroid/content/Intent;", "onError", "exception", "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$WebViewException;", "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient;", "onPageFinished", "webView", "Landroid/webkit/WebView;", "url", "", "onSuccess", "verifier", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface Listener {
        void onComplete(int resultCode, Intent data);

        void onError(WebViewException exception);

        void onPageFinished(WebView webView, String url);

        void onSuccess(String verifier);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterOAuthWebViewClient(String str, Listener listener) {
        Intrinsics.checkNotNullParameter(str, y.ݬֲ֮ܲت(1512057231));
        Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
        this.completeUrl = str;
        this.listener = listener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        super.onPageFinished(view, url);
        this.listener.onPageFinished(view, url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.webkit.WebViewClient
    @Deprecated(message = "")
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        if (handleUrl(url)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, y.ٲٴݴ״ٰ(1781855688));
        if (handleUrl(uri)) {
            return true;
        }
        return super.shouldOverrideUrlLoading(view, request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean handleUrl(String url) {
        if (StringsKt.startsWith$default(url, this.completeUrl, false, 2, (Object) null)) {
            this.listener.onSuccess(Uri.parse(url).getQueryParameter(y.֬ڱܱײٮ(-1159112711)));
        } else if (!StringsKt.startsWith$default(url, y.دײܮڳܯ(2051014669), false, 2, (Object) null)) {
            if (!StringsKt.startsWith$default(url, y.٬ݯح׭٩(576575190), false, 2, (Object) null)) {
                return false;
            }
            Intent intent = new Intent(y.ٲٴݴ״ٰ(1781642640));
            intent.setData(Uri.parse(url));
            CoreManager.INSTANCE.getInstance().getActivity().startActivity(intent);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
        Intrinsics.checkNotNullParameter(failingUrl, y.ݮڮֲڭܩ(-628279516));
        super.onReceivedError(view, errorCode, description, failingUrl);
        this.listener.onError(new WebViewException(errorCode, description, failingUrl));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
        Intrinsics.checkNotNullParameter(handler, y.ٴسسݬߨ(1393099658));
        Intrinsics.checkNotNullParameter(error, y.٬ݯح׭٩(576154958));
        super.onReceivedSslError(view, handler, error);
        this.listener.onError(new WebViewException(error.getPrimaryError(), null, null));
    }

    /* compiled from: TwitterOAuthWebViewClient.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$WebViewException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "description", "", "failingUrl", "(Lcom/kakaogame/twitter/TwitterOAuthWebViewClient;ILjava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getErrorCode", "()I", "getFailingUrl", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public final class WebViewException extends Exception {
        private final int errorCode;
        private final String failingUrl;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebViewException(int i, String str, String str2) {
            super(str);
            this.errorCode = i;
            this.failingUrl = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getFailingUrl() {
            return this.failingUrl;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDescription() {
            String message = getMessage();
            Intrinsics.checkNotNull(message);
            return message;
        }
    }
}
