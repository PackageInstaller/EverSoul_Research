package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.kakaogame.promotion.share.KGAnimationButton;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameSdkShareScreenshotBinding implements ViewBinding {
    public final RelativeLayout kakaoGameSdkBound;
    public final View kakaoGameSdkBoundBottomnRight;
    public final View kakaoGameSdkBoundTopLeft;
    public final KGAnimationButton kakaoGameSdkDialogTopbarClose;
    public final KGAnimationButton kakaoGameSdkScreenshotCamera;
    public final KGAnimationButton kakaoGameSdkScreenshotCrop;
    public final ImageView kakaoGameSdkScreenshotCropType;
    public final RelativeLayout kakaoGameSdkScreenshotLayout;
    public final ImageView kakaoGameSdkScreenshotResultImage;
    public final FrameLayout kakaoGameSdkScreenshotWatermark;
    public final ImageView kakaoGameSdkScreenshotWatermarkButton;
    public final ImageView kakaoGameSdkScreenshotWatermarkCropImage;
    public final ImageView kakaoGameSdkScreenshotWatermarkImage;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSdkShareScreenshotBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, View view, View view2, KGAnimationButton kGAnimationButton, KGAnimationButton kGAnimationButton2, KGAnimationButton kGAnimationButton3, ImageView imageView, RelativeLayout relativeLayout3, ImageView imageView2, FrameLayout frameLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        this.rootView = relativeLayout;
        this.kakaoGameSdkBound = relativeLayout2;
        this.kakaoGameSdkBoundBottomnRight = view;
        this.kakaoGameSdkBoundTopLeft = view2;
        this.kakaoGameSdkDialogTopbarClose = kGAnimationButton;
        this.kakaoGameSdkScreenshotCamera = kGAnimationButton2;
        this.kakaoGameSdkScreenshotCrop = kGAnimationButton3;
        this.kakaoGameSdkScreenshotCropType = imageView;
        this.kakaoGameSdkScreenshotLayout = relativeLayout3;
        this.kakaoGameSdkScreenshotResultImage = imageView2;
        this.kakaoGameSdkScreenshotWatermark = frameLayout;
        this.kakaoGameSdkScreenshotWatermarkButton = imageView3;
        this.kakaoGameSdkScreenshotWatermarkCropImage = imageView4;
        this.kakaoGameSdkScreenshotWatermarkImage = imageView5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkShareScreenshotBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkShareScreenshotBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_sdk_share_screenshot, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkShareScreenshotBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = C2382R.id.kakao_game_sdk_bound;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2382R.id.kakao_game_sdk_bound_bottomn_right))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C2382R.id.kakao_game_sdk_bound_top_left))) != null) {
            i = C2382R.id.kakao_game_sdk_dialog_topbar_close;
            KGAnimationButton kGAnimationButton = (KGAnimationButton) ViewBindings.findChildViewById(view, i);
            if (kGAnimationButton != null) {
                i = C2382R.id.kakao_game_sdk_screenshot_camera;
                KGAnimationButton kGAnimationButton2 = (KGAnimationButton) ViewBindings.findChildViewById(view, i);
                if (kGAnimationButton2 != null) {
                    i = C2382R.id.kakao_game_sdk_screenshot_crop;
                    KGAnimationButton kGAnimationButton3 = (KGAnimationButton) ViewBindings.findChildViewById(view, i);
                    if (kGAnimationButton3 != null) {
                        i = C2382R.id.kakao_game_sdk_screenshot_crop_type;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            RelativeLayout relativeLayout2 = (RelativeLayout) view;
                            i = C2382R.id.kakao_game_sdk_screenshot_result_image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = C2382R.id.kakao_game_sdk_screenshot_watermark;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = C2382R.id.kakao_game_sdk_screenshot_watermark_button;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = C2382R.id.kakao_game_sdk_screenshot_watermark_crop_image;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = C2382R.id.kakao_game_sdk_screenshot_watermark_image;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                return new KakaoGameSdkShareScreenshotBinding(relativeLayout2, relativeLayout, findChildViewById, findChildViewById2, kGAnimationButton, kGAnimationButton2, kGAnimationButton3, imageView, relativeLayout2, imageView2, frameLayout, imageView3, imageView4, imageView5);
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
