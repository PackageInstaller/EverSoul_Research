package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkDialogWebKakaoBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout zinnySdkDialogWeb;
    public final LinearLayout zinnySdkDialogWebContainer;
    public final WebView zinnySdkDialogWebContent;
    public final FrameLayout zinnySdkDialogWebCustomContainer;
    public final SwipeRefreshLayout zinnySdkDialogWebLayout;
    public final RelativeLayout zinnySdkDialogWebMain;
    public final RelativeLayout zinnySdkDialogWebTopbar;
    public final FrameLayout zinnySdkDialogWebTopbarBack;
    public final FrameLayout zinnySdkDialogWebTopbarClose;
    public final ImageView zinnySdkDialogWebTopbarCloseImage;
    public final ImageView zinnySdkDialogWebTopbarPreviousImage;
    public final TextView zinnySdkDialogWebTopbarTitle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkDialogWebKakaoBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, LinearLayout linearLayout, WebView webView, FrameLayout frameLayout, SwipeRefreshLayout swipeRefreshLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = relativeLayout;
        this.zinnySdkDialogWeb = relativeLayout2;
        this.zinnySdkDialogWebContainer = linearLayout;
        this.zinnySdkDialogWebContent = webView;
        this.zinnySdkDialogWebCustomContainer = frameLayout;
        this.zinnySdkDialogWebLayout = swipeRefreshLayout;
        this.zinnySdkDialogWebMain = relativeLayout3;
        this.zinnySdkDialogWebTopbar = relativeLayout4;
        this.zinnySdkDialogWebTopbarBack = frameLayout2;
        this.zinnySdkDialogWebTopbarClose = frameLayout3;
        this.zinnySdkDialogWebTopbarCloseImage = imageView;
        this.zinnySdkDialogWebTopbarPreviousImage = imageView2;
        this.zinnySdkDialogWebTopbarTitle = textView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkDialogWebKakaoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkDialogWebKakaoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_dialog_web_kakao, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkDialogWebKakaoBinding bind(View view) {
        int i = C2382R.id.zinny_sdk_dialog_web;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = C2382R.id.zinny_sdk_dialog_web_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = C2382R.id.zinny_sdk_dialog_web_content;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                if (webView != null) {
                    i = C2382R.id.zinny_sdk_dialog_web_custom_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = C2382R.id.zinny_sdk_dialog_web_layout;
                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, i);
                        if (swipeRefreshLayout != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) view;
                            i = C2382R.id.zinny_sdk_dialog_web_topbar;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout3 != null) {
                                i = C2382R.id.zinny_sdk_dialog_web_topbar_back;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout2 != null) {
                                    i = C2382R.id.zinny_sdk_dialog_web_topbar_close;
                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout3 != null) {
                                        i = C2382R.id.zinny_sdk_dialog_web_topbar_close_image;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = C2382R.id.zinny_sdk_dialog_web_topbar_previous_image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = C2382R.id.zinny_sdk_dialog_web_topbar_title;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    return new ZinnySdkDialogWebKakaoBinding(relativeLayout2, relativeLayout, linearLayout, webView, frameLayout, swipeRefreshLayout, relativeLayout2, relativeLayout3, frameLayout2, frameLayout3, imageView, imageView2, textView);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
