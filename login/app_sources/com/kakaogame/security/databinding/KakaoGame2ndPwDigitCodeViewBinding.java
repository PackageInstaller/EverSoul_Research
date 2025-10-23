package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.secondpw.view.VirtualKeypad;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwDigitCodeViewBinding implements ViewBinding {
    public final KakaoGame2ndPwInputDetailViewBinding inputView;
    private final LinearLayout rootView;
    public final KakaoGame2ndPwSettingDetailViewBinding settingView;
    public final VirtualKeypad virtualKeypad;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwDigitCodeViewBinding(LinearLayout linearLayout, KakaoGame2ndPwInputDetailViewBinding kakaoGame2ndPwInputDetailViewBinding, KakaoGame2ndPwSettingDetailViewBinding kakaoGame2ndPwSettingDetailViewBinding, VirtualKeypad virtualKeypad) {
        this.rootView = linearLayout;
        this.inputView = kakaoGame2ndPwInputDetailViewBinding;
        this.settingView = kakaoGame2ndPwSettingDetailViewBinding;
        this.virtualKeypad = virtualKeypad;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDigitCodeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDigitCodeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_digit_code_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDigitCodeViewBinding bind(View view) {
        int i = C2558R.id.input_view;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            KakaoGame2ndPwInputDetailViewBinding bind = KakaoGame2ndPwInputDetailViewBinding.bind(findChildViewById);
            int i2 = C2558R.id.setting_view;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById2 != null) {
                KakaoGame2ndPwSettingDetailViewBinding bind2 = KakaoGame2ndPwSettingDetailViewBinding.bind(findChildViewById2);
                int i3 = C2558R.id.virtual_keypad;
                VirtualKeypad virtualKeypad = (VirtualKeypad) ViewBindings.findChildViewById(view, i3);
                if (virtualKeypad != null) {
                    return new KakaoGame2ndPwDigitCodeViewBinding((LinearLayout) view, bind, bind2, virtualKeypad);
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
