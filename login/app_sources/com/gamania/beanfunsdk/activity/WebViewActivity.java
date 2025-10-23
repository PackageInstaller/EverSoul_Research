package com.gamania.beanfunsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.gamania.beanfunsdk.C0857R;
import com.gamania.beanfunsdk.api.AppDefine;
import com.liapp.y;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebViewActivity extends Activity {

    /* renamed from: com.gamania.beanfunsdk.activity.WebViewActivity$a */
    class C0860a extends WebViewClient {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C0860a() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            String str2;
            if (str.contains("beanfun:")) {
                try {
                    str2 = str.split("#")[1].split("&")[0].split("=")[1];
                } catch (Exception e) {
                    e.printStackTrace();
                    str2 = "";
                }
                Intent intent = new Intent();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("AccessToken", str2);
                    jSONObject.put("ResultCode", 1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                intent.putExtra(AppDefine.BUNDLE_KEY_OPNEID_RESULT_DATA, jSONObject.toString());
                WebViewActivity.this.setResult(-1, intent);
            } else {
                if (!str.startsWith("market://")) {
                    webView.loadUrl(str);
                    return true;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(str));
                WebViewActivity.this.startActivity(intent2);
            }
            WebViewActivity.this.finish();
            return true;
        }
    }

    /* renamed from: com.gamania.beanfunsdk.activity.WebViewActivity$b */
    class ViewOnClickListenerC0861b implements View.OnClickListener {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ViewOnClickListenerC0861b() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.finish();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        y.٬خݮ۳ݯ(this);
        super.onCreate(bundle);
        setContentView(C0857R.layout.activity_webview);
        String stringExtra = getIntent() != null ? getIntent().getStringExtra("gameId") : null;
        WebView webView = (WebView) findViewById(C0857R.id.wvBindingHelp);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setMixedContentMode(0);
        webView.setWebViewClient(new C0860a());
        if (!TextUtils.isEmpty(stringExtra)) {
            webView.loadUrl(AppDefine.GET_OPEN_ID_ACCESS_TOKEN + stringExtra);
        }
        ((ImageView) findViewById(C0857R.id.tvClose)).setOnClickListener(new ViewOnClickListenerC0861b());
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
}
