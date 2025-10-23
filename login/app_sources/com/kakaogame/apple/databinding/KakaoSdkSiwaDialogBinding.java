package com.kakaogame.apple.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.apple.C2383R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoSdkSiwaDialogBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout zinnySdkDialogWeb;
    public final View zinnySdkDialogWebContainer;
    public final WebView zinnySdkDialogWebContent;
    public final FrameLayout zinnySdkDialogWebCustomContainer;
    public final SwipeRefreshLayout zinnySdkDialogWebLayout;
    public final RelativeLayout zinnySdkDialogWebMain;
    public final RelativeLayout zinnySdkDialogWebTopbar;
    public final ImageView zinnySdkDialogWebTopbarBack;
    public final FrameLayout zinnySdkDialogWebTopbarClose;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoSdkSiwaDialogBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, View view, WebView webView, FrameLayout frameLayout, SwipeRefreshLayout swipeRefreshLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ImageView imageView, FrameLayout frameLayout2) {
        this.rootView = relativeLayout;
        this.zinnySdkDialogWeb = relativeLayout2;
        this.zinnySdkDialogWebContainer = view;
        this.zinnySdkDialogWebContent = webView;
        this.zinnySdkDialogWebCustomContainer = frameLayout;
        this.zinnySdkDialogWebLayout = swipeRefreshLayout;
        this.zinnySdkDialogWebMain = relativeLayout3;
        this.zinnySdkDialogWebTopbar = relativeLayout4;
        this.zinnySdkDialogWebTopbarBack = imageView;
        this.zinnySdkDialogWebTopbarClose = frameLayout2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoSdkSiwaDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoSdkSiwaDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2383R.layout.kakao_sdk_siwa_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoSdkSiwaDialogBinding bind(View view) {
        View findChildViewById;
        int i = C2383R.id.zinny_sdk_dialog_web;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2383R.id.zinny_sdk_dialog_web_container))) != null) {
            i = C2383R.id.zinny_sdk_dialog_web_content;
            WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView != null) {
                i = C2383R.id.zinny_sdk_dialog_web_custom_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = C2383R.id.zinny_sdk_dialog_web_layout;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                    if (swipeRefreshLayout != null) {
                        RelativeLayout relativeLayout2 = (RelativeLayout) view;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, C2383R.id.zinny_sdk_dialog_web_topbar);
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C2383R.id.zinny_sdk_dialog_web_topbar_back);
                        i = C2383R.id.zinny_sdk_dialog_web_topbar_close;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            return new KakaoSdkSiwaDialogBinding(relativeLayout2, relativeLayout, findChildViewById, webView, frameLayout, swipeRefreshLayout, relativeLayout2, relativeLayout3, imageView, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
