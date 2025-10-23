package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.secondpw.view.PasswordDisplayView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwInputDetailViewBinding implements ViewBinding {
    public final KakaoGame2ndPwPassiveViewBinding hasPassiveView;
    public final NotoSansTextView kakaoGame2ndPwBlockingGuide;
    public final PasswordDisplayView kakaoGame2ndPwInputView;
    public final NotoSansButton kakaoGame2ndPwRemoveButton;
    public final NotoSansButton kakaoGame2ndPwResetButton;
    public final KakaoGame2ndPwNoPassiveViewBinding noPassiveView;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwInputDetailViewBinding(RelativeLayout relativeLayout, KakaoGame2ndPwPassiveViewBinding kakaoGame2ndPwPassiveViewBinding, NotoSansTextView notoSansTextView, PasswordDisplayView passwordDisplayView, NotoSansButton notoSansButton, NotoSansButton notoSansButton2, KakaoGame2ndPwNoPassiveViewBinding kakaoGame2ndPwNoPassiveViewBinding) {
        this.rootView = relativeLayout;
        this.hasPassiveView = kakaoGame2ndPwPassiveViewBinding;
        this.kakaoGame2ndPwBlockingGuide = notoSansTextView;
        this.kakaoGame2ndPwInputView = passwordDisplayView;
        this.kakaoGame2ndPwRemoveButton = notoSansButton;
        this.kakaoGame2ndPwResetButton = notoSansButton2;
        this.noPassiveView = kakaoGame2ndPwNoPassiveViewBinding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDetailViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDetailViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_input_detail_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDetailViewBinding bind(View view) {
        View findChildViewById;
        int i = C2558R.id.has_passive_view;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            KakaoGame2ndPwPassiveViewBinding bind = KakaoGame2ndPwPassiveViewBinding.bind(findChildViewById2);
            i = C2558R.id.kakao_game_2nd_pw_blocking_guide;
            NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView != null) {
                i = C2558R.id.kakao_game_2nd_pw_input_view;
                PasswordDisplayView passwordDisplayView = (PasswordDisplayView) ViewBindings.findChildViewById(view, i);
                if (passwordDisplayView != null) {
                    i = C2558R.id.kakao_game_2nd_pw_remove_button;
                    NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                    if (notoSansButton != null) {
                        i = C2558R.id.kakao_game_2nd_pw_reset_button;
                        NotoSansButton notoSansButton2 = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                        if (notoSansButton2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2558R.id.no_passive_view))) != null) {
                            return new KakaoGame2ndPwInputDetailViewBinding((RelativeLayout) view, bind, notoSansTextView, passwordDisplayView, notoSansButton, notoSansButton2, KakaoGame2ndPwNoPassiveViewBinding.bind(findChildViewById));
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
