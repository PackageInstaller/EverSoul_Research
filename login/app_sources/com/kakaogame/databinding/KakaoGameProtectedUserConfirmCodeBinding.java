package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.kakaogame.p029ui.font.NotoSansEditText;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameProtectedUserConfirmCodeBinding implements ViewBinding {
    public final NotoSansTextView kakaoGameConfirmCodeGuide;
    public final NotoSansEditText kakaoGameConfirmCodeInput;
    public final FrameLayout kakaoGameInputBoxView;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameProtectedUserConfirmCodeBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, NotoSansEditText notoSansEditText, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.kakaoGameConfirmCodeGuide = notoSansTextView;
        this.kakaoGameConfirmCodeInput = notoSansEditText;
        this.kakaoGameInputBoxView = frameLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserConfirmCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserConfirmCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_protected_user_confirm_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserConfirmCodeBinding bind(View view) {
        int i = C2382R.id.kakao_game_confirm_code_guide;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2382R.id.kakao_game_confirm_code_input;
            NotoSansEditText notoSansEditText = (NotoSansEditText) ViewBindings.findChildViewById(view, i);
            if (notoSansEditText != null) {
                i = C2382R.id.kakao_game_input_box_view;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    return new KakaoGameProtectedUserConfirmCodeBinding((RelativeLayout) view, notoSansTextView, notoSansEditText, frameLayout);
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
