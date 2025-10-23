package com.kakaogame.twitter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.twitter.TwitterOAuthWebViewClient;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwitterOAuthActivity.kt */
@Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0002J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0016\u0010 \u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0016H\u0016J\u001c\u0010!\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u001fH\u0014J\u0012\u0010%\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J0\u0010&\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010)\u001a\u0004\u0018\u00010*H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m839d2 = {"Lcom/kakaogame/twitter/TwitterOAuthActivity;", "Landroid/app/Activity;", "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$Listener;", "()V", "spinner", "Landroid/widget/ProgressBar;", "webView", "Landroid/webkit/WebView;", "buildCallbackUrl", "", "dismissSpinner", "", "dismissWebView", "handleAuthError", ServerConstants.TRACE_RESULT_CODE, "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleWebViewError", "exception", "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient$WebViewException;", "Lcom/kakaogame/twitter/TwitterOAuthWebViewClient;", "handleWebViewSuccess", "verifier", "onBackPressed", "onComplete", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onPageFinished", "url", "onSaveInstanceState", "outState", "onSuccess", "setUpWebView", "webViewClient", "Landroid/webkit/WebViewClient;", "webChromeClient", "Landroid/webkit/WebChromeClient;", "Companion", "idp_twitter_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TwitterOAuthActivity extends Activity implements TwitterOAuthWebViewClient.Listener {
    public static final String AUTHORIZE_URL = "authorize_url";
    private static final String CALLBACK_URL = "twittersdk://";
    private static final String STATE_PROGRESS = "progress";
    private static final String TAG = "TwitterOAuthActivity";
    private ProgressBar spinner;
    private WebView webView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        y.ݯױܭ۱ݭ(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        y.ݱݬ׬۬ݨ(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C2559R.layout.activity_twitter_o_auth);
        this.spinner = (ProgressBar) findViewById(C2559R.id.tw__spinner);
        this.webView = (WebView) findViewById(C2559R.id.tw__web_view);
        boolean z = savedInstanceState != null ? savedInstanceState.getBoolean(y.٬ݯح׭٩(576373310), false) : true;
        ProgressBar progressBar = this.spinner;
        if (progressBar != null) {
            progressBar.setVisibility(z ? 0 : 8);
        }
        String stringExtra = getIntent().getStringExtra(y.ۮڭڭܬި(862632875));
        if (stringExtra == null) {
            handleAuthError(1, new Exception(y.ٲٴݴ״ٰ(1782323528)));
            finish();
        }
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051017389), y.٬ݯح׭٩(576373630));
        setUpWebView(this.webView, new TwitterOAuthWebViewClient(buildCallbackUrl(), this), stringExtra, new WebChromeClient());
        getWindow().addFlags(16777216);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String buildCallbackUrl() {
        String uri = Uri.parse(y.֬ڱܱײٮ(-1158771159)).buildUpon().build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, y.ٲٴݴ״ٰ(1781855688));
        return uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.twitter.TwitterOAuthWebViewClient.Listener
    public void onComplete(int resultCode, Intent data) {
        setResult(resultCode, data);
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.twitter.TwitterOAuthWebViewClient.Listener
    public void onPageFinished(WebView webView, String url) {
        dismissSpinner();
        Intrinsics.checkNotNull(webView);
        webView.setVisibility(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.twitter.TwitterOAuthWebViewClient.Listener
    public void onSuccess(String verifier) {
        handleWebViewSuccess(verifier);
        dismissWebView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void dismissWebView() {
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        webView.stopLoading();
        dismissSpinner();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void dismissSpinner() {
        ProgressBar progressBar = this.spinner;
        Intrinsics.checkNotNull(progressBar);
        progressBar.setVisibility(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setUpWebView(WebView webView, WebViewClient webViewClient, String url, WebChromeClient webChromeClient) {
        Intrinsics.checkNotNull(webView);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, y.ۮڭڭܬި(862808243));
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        Intrinsics.checkNotNull(webViewClient);
        webView.setWebViewClient(webViewClient);
        Intrinsics.checkNotNull(url);
        webView.loadUrl(url);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void handleWebViewSuccess(String verifier) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051017725);
        String str2 = y.دײܮڳܯ(2051017389);
        logger.m699d(str2, str);
        if (verifier != null) {
            Intent intent = new Intent();
            intent.putExtra(y.֬ڱܱײٮ(-1159112711), verifier);
            onComplete(-1, intent);
        } else {
            Logger logger2 = Logger.INSTANCE;
            String str3 = y.دײܮڳܯ(2051017013);
            logger2.m702e(str2, str3, null);
            handleAuthError(1, new Exception(str3));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void handleAuthError(int resultCode, Exception error) {
        Intent intent = new Intent();
        intent.putExtra(y.ٴسسݬߨ(1393102698), error);
        onComplete(resultCode, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.twitter.TwitterOAuthWebViewClient.Listener
    public void onError(TwitterOAuthWebViewClient.WebViewException exception) {
        handleWebViewError(exception);
        dismissWebView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void handleWebViewError(TwitterOAuthWebViewClient.WebViewException exception) {
        Logger.INSTANCE.m702e(y.دײܮڳܯ(2051017389), y.دײܮڳܯ(2051018221), exception);
        Intrinsics.checkNotNull(exception);
        handleAuthError(1, new Exception(exception.getDescription()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, y.ۮڭڭܬި(862808067));
        ProgressBar progressBar = this.spinner;
        Intrinsics.checkNotNull(progressBar);
        if (progressBar.getVisibility() == 0) {
            outState.putBoolean(y.٬ݯح׭٩(576373310), true);
        }
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onBackPressed() {
        WebView webView = this.webView;
        Intrinsics.checkNotNull(webView);
        if (!webView.canGoBack()) {
            handleAuthError(0, new Exception(y.ݮڮֲڭܩ(-628281100)));
            return;
        }
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.goBack();
    }
}
