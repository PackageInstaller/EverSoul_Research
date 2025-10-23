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
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameProtectedUserUnregisterAgreementBinding implements ViewBinding {
    public final RelativeLayout kakaoGameProtectedPopupAgreementCheck;
    public final NotoSansTextView kakaoGameProtectedPopupAgreementTitle;
    public final ImageView kakaoGameProtectedPopupCheckBoxOff;
    public final ImageView kakaoGameProtectedPopupCheckBoxOn;
    public final FrameLayout kakaoSdkProtectedUserPopupAgreementBtn;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameProtectedUserUnregisterAgreementBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, NotoSansTextView notoSansTextView, ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.kakaoGameProtectedPopupAgreementCheck = relativeLayout2;
        this.kakaoGameProtectedPopupAgreementTitle = notoSansTextView;
        this.kakaoGameProtectedPopupCheckBoxOff = imageView;
        this.kakaoGameProtectedPopupCheckBoxOn = imageView2;
        this.kakaoSdkProtectedUserPopupAgreementBtn = frameLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterAgreementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterAgreementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_protected_user_unregister_agreement, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterAgreementBinding bind(View view) {
        int i = C2382R.id.kakao_game_protected_popup_agreement_check;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = C2382R.id.kakao_game_protected_popup_agreement_title;
            NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView != null) {
                i = C2382R.id.kakao_game_protected_popup_check_box_off;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C2382R.id.kakao_game_protected_popup_check_box_on;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = C2382R.id.kakao_sdk_protected_user_popup_agreement_btn;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            return new KakaoGameProtectedUserUnregisterAgreementBinding((RelativeLayout) view, relativeLayout, notoSansTextView, imageView, imageView2, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
