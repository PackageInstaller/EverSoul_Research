package com.kakaogame.game;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.liapp.y;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: GameMessageBlockDialog.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0015J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/game/GameMessageBlockDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function0;", "", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "displayCutoutMode", "", "progressDialog", "Landroid/app/ProgressDialog;", "url", "", "webView", "Landroid/webkit/WebView;", "hideProgressDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyUp", "", "keyCode", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onWindowFocusChanged", "hasFocus", "setDialogVisibility", "showProgressDialog", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GameMessageBlockDialog extends Dialog {
    private static final String SETTING_URL = "https://apps.kakao.com/feedblock";
    private final Activity activity;
    private final Function0<Unit> callback;
    private int displayCutoutMode;
    private ProgressDialog progressDialog;
    private final String url;
    private WebView webView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Function0<Unit> getCallback() {
        return this.callback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GameMessageBlockDialog(Activity activity, Function0<Unit> function0) {
        super(activity, R.style.Theme.DeviceDefault);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(function0, y.֬ڱܱײٮ(-1159472767));
        this.activity = activity;
        this.callback = function0;
        Locale locale = activity.getResources().getConfiguration().locale;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(y.ݮڮֲڭܩ(-628525500), Arrays.copyOf(new Object[]{y.ݮڮֲڭܩ(-628525740), locale.getLanguage()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
        this.url = format;
        if (Build.VERSION.SDK_INT >= 28) {
            this.displayCutoutMode = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogVisibility() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
        decorView.setSystemUiVisibility(this.activity.getWindow().getDecorView().getSystemUiVisibility());
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.addFlags(this.activity.getWindow().getAttributes().flags);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window3 = getWindow();
            Intrinsics.checkNotNull(window3);
            window3.getAttributes().layoutInDisplayCutoutMode = this.displayCutoutMode;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.getDecorView().setSystemUiVisibility(5894);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDialogVisibility();
        WebView webView = new WebView(getContext());
        this.webView = webView;
        Intrinsics.checkNotNull(webView);
        webView.setWebViewClient(new WebViewClient() { // from class: com.kakaogame.game.GameMessageBlockDialog$onCreate$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
                Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
                super.onPageStarted(view, url, favicon);
                GameMessageBlockDialog.this.showProgressDialog();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, y.ٲٴݴ״ٰ(1782079424));
                Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
                super.onPageFinished(view, url);
                GameMessageBlockDialog.this.hideProgressDialog();
            }
        });
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder(y.دײܮڳܯ(2051293517));
        OAuthToken token = TokenManager.INSTANCE.getInstance().getToken();
        Intrinsics.checkNotNull(token);
        hashMap.put(y.ٲٴݴ״ٰ(1782078608), sb.append(token.getAccessToken()).toString());
        hashMap.put(y.ۮڭڭܬި(862530251), KakaoSdk.INSTANCE.getApplicationContextInfo().getKaHeader());
        WebView webView2 = this.webView;
        Intrinsics.checkNotNull(webView2);
        webView2.loadUrl(this.url, hashMap);
        WebView webView3 = this.webView;
        Intrinsics.checkNotNull(webView3);
        webView3.getSettings().setJavaScriptEnabled(true);
        WebView webView4 = this.webView;
        Intrinsics.checkNotNull(webView4);
        webView4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WebView webView5 = this.webView;
        Intrinsics.checkNotNull(webView5);
        addContentView(webView5, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, y.ٲٴݴ״ٰ(1782060104));
        if (keyCode == 4) {
            WebView webView = this.webView;
            Intrinsics.checkNotNull(webView);
            if (webView.canGoBack()) {
                WebView webView2 = this.webView;
                Intrinsics.checkNotNull(webView2);
                webView2.goBack();
                return true;
            }
            this.callback.invoke();
            dismiss();
        }
        return super.onKeyUp(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showProgressDialog() {
        hideProgressDialog();
        this.progressDialog = ProgressDialog.show(getContext(), null, y.ݬֲ֮ܲت(1512335687));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void hideProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            Intrinsics.checkNotNull(progressDialog);
            progressDialog.dismiss();
            this.progressDialog = null;
        }
    }
}
