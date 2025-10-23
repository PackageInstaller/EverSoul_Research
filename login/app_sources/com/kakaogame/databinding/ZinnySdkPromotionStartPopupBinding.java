package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class ZinnySdkPromotionStartPopupBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout zinnySdkPromotionImageView;
    public final RelativeLayout zinnySdkPromotionStartPopupBottom;
    public final LinearLayout zinnySdkPromotionStartPopupCheck;
    public final ImageView zinnySdkPromotionStartPopupCheckImage;
    public final FrameLayout zinnySdkPromotionStartPopupClose;
    public final ImageView zinnySdkPromotionStartPopupImage;
    public final ImageView zinnySdkPromotionStartPopupProgress;
    public final RelativeLayout zinnySdkPromotionView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ZinnySdkPromotionStartPopupBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout4) {
        this.rootView = relativeLayout;
        this.zinnySdkPromotionImageView = relativeLayout2;
        this.zinnySdkPromotionStartPopupBottom = relativeLayout3;
        this.zinnySdkPromotionStartPopupCheck = linearLayout;
        this.zinnySdkPromotionStartPopupCheckImage = imageView;
        this.zinnySdkPromotionStartPopupClose = frameLayout;
        this.zinnySdkPromotionStartPopupImage = imageView2;
        this.zinnySdkPromotionStartPopupProgress = imageView3;
        this.zinnySdkPromotionView = relativeLayout4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionStartPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionStartPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.zinny_sdk_promotion_start_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ZinnySdkPromotionStartPopupBinding bind(View view) {
        int i = C2382R.id.zinny_sdk_promotion_image_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = C2382R.id.zinny_sdk_promotion_start_popup_bottom;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                i = C2382R.id.zinny_sdk_promotion_start_popup_check;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = C2382R.id.zinny_sdk_promotion_start_popup_check_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = C2382R.id.zinny_sdk_promotion_start_popup_close;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = C2382R.id.zinny_sdk_promotion_start_popup_image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = C2382R.id.zinny_sdk_promotion_start_popup_progress;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = C2382R.id.zinny_sdk_promotion_view;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        return new ZinnySdkPromotionStartPopupBinding((RelativeLayout) view, relativeLayout, relativeLayout2, linearLayout, imageView, frameLayout, imageView2, imageView3, relativeLayout3);
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
