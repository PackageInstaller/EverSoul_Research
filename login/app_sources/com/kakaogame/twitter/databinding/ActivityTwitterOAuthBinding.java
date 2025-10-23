package com.kakaogame.twitter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.twitter.C2559R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ActivityTwitterOAuthBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ProgressBar twSpinner;
    public final WebView twWebView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ActivityTwitterOAuthBinding(RelativeLayout relativeLayout, ProgressBar progressBar, WebView webView) {
        this.rootView = relativeLayout;
        this.twSpinner = progressBar;
        this.twWebView = webView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityTwitterOAuthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityTwitterOAuthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2559R.layout.activity_twitter_o_auth, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityTwitterOAuthBinding bind(View view) {
        int i = C2559R.id.tw__spinner;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = C2559R.id.tw__web_view;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                return new ActivityTwitterOAuthBinding((RelativeLayout) view, progressBar, webView);
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
