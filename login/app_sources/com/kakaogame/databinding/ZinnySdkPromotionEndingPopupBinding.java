package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkPromotionEndingPopupBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView zinnySdkPromotionEndingPopupCancel;
    public final RelativeLayout zinnySdkPromotionEndingPopupContent;
    public final ImageView zinnySdkPromotionEndingPopupImage;
    public final TextView zinnySdkPromotionEndingPopupOk;
    public final ImageView zinnySdkPromotionEndingPopupProgress;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkPromotionEndingPopupBinding(RelativeLayout relativeLayout, TextView textView, RelativeLayout relativeLayout2, ImageView imageView, TextView textView2, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.zinnySdkPromotionEndingPopupCancel = textView;
        this.zinnySdkPromotionEndingPopupContent = relativeLayout2;
        this.zinnySdkPromotionEndingPopupImage = imageView;
        this.zinnySdkPromotionEndingPopupOk = textView2;
        this.zinnySdkPromotionEndingPopupProgress = imageView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionEndingPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionEndingPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_promotion_ending_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionEndingPopupBinding bind(View view) {
        int i = C2382R.id.zinny_sdk_promotion_ending_popup_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C2382R.id.zinny_sdk_promotion_ending_popup_content;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = C2382R.id.zinny_sdk_promotion_ending_popup_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C2382R.id.zinny_sdk_promotion_ending_popup_ok;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C2382R.id.zinny_sdk_promotion_ending_popup_progress;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            return new ZinnySdkPromotionEndingPopupBinding((RelativeLayout) view, textView, relativeLayout, imageView, textView2, imageView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
