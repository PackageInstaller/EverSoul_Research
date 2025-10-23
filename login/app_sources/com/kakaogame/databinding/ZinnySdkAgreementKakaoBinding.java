package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkAgreementKakaoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ImageView zinnySdkAgreementImageBack;
    public final RelativeLayout zinnySdkAgreementKakao;
    public final FrameLayout zinnySdkAgreementKakaoTopbarBack;
    public final TextView zinnySdkAgreementKakaoTopbarTitle;
    public final WebView zinnySdkAgreementKakaoWebview;
    public final RelativeLayout zinnySdkDialogWebTopbar;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkAgreementKakaoBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, FrameLayout frameLayout, TextView textView, WebView webView, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.zinnySdkAgreementImageBack = imageView;
        this.zinnySdkAgreementKakao = relativeLayout2;
        this.zinnySdkAgreementKakaoTopbarBack = frameLayout;
        this.zinnySdkAgreementKakaoTopbarTitle = textView;
        this.zinnySdkAgreementKakaoWebview = webView;
        this.zinnySdkDialogWebTopbar = relativeLayout3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkAgreementKakaoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkAgreementKakaoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_agreement_kakao, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkAgreementKakaoBinding bind(View view) {
        int i = C2382R.id.zinny_sdk_agreement_image_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = C2382R.id.zinny_sdk_agreement_kakao_topbar_back;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C2382R.id.zinny_sdk_agreement_kakao_topbar_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C2382R.id.zinny_sdk_agreement_kakao_webview;
                    WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                    if (webView != null) {
                        i = C2382R.id.zinny_sdk_dialog_web_topbar;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            return new ZinnySdkAgreementKakaoBinding(relativeLayout, imageView, relativeLayout, frameLayout, textView, webView, relativeLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
