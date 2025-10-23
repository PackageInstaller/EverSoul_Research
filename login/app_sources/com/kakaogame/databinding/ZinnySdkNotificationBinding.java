package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkNotificationBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout zinnySdkNotification;
    public final TextView zinnySdkNotificationContent;
    public final ImageView zinnySdkNotificationIcon;
    public final TextView zinnySdkNotificationTime;
    public final TextView zinnySdkNotificationTitle;
    public final RelativeLayout zinnySdkNotificationTop;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkNotificationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView, TextView textView2, TextView textView3, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.zinnySdkNotification = linearLayout2;
        this.zinnySdkNotificationContent = textView;
        this.zinnySdkNotificationIcon = imageView;
        this.zinnySdkNotificationTime = textView2;
        this.zinnySdkNotificationTitle = textView3;
        this.zinnySdkNotificationTop = relativeLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkNotificationBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = C2382R.id.zinny_sdk_notification_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C2382R.id.zinny_sdk_notification_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C2382R.id.zinny_sdk_notification_time;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = C2382R.id.zinny_sdk_notification_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = C2382R.id.zinny_sdk_notification_top;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            return new ZinnySdkNotificationBinding(linearLayout, linearLayout, textView, imageView, textView2, textView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
