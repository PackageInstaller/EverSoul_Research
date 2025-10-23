package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkPermissionNotiBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout zinnySdkNotification;
    public final TextView zinnySdkPermissionNotiContent;
    public final ImageView zinnySdkPermissionNotiIcon;
    public final ScrollView zinnySdkPermissionNotiScrollview;
    public final TextView zinnySdkPermissionNotiTitle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkPermissionNotiBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView, ScrollView scrollView, TextView textView2) {
        this.rootView = linearLayout;
        this.zinnySdkNotification = linearLayout2;
        this.zinnySdkPermissionNotiContent = textView;
        this.zinnySdkPermissionNotiIcon = imageView;
        this.zinnySdkPermissionNotiScrollview = scrollView;
        this.zinnySdkPermissionNotiTitle = textView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPermissionNotiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPermissionNotiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_permission_noti, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPermissionNotiBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = C2382R.id.zinny_sdk_permission_noti_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C2382R.id.zinny_sdk_permission_noti_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C2382R.id.zinny_sdk_permission_noti_scrollview;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                if (scrollView != null) {
                    i = C2382R.id.zinny_sdk_permission_noti_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ZinnySdkPermissionNotiBinding(linearLayout, linearLayout, textView, imageView, scrollView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
