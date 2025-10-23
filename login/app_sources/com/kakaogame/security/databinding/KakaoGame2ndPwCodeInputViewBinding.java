package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansEditText;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwCodeInputViewBinding implements ViewBinding {
    public final FrameLayout kakaoGame2ndPwCodeClear;
    public final NotoSansTextView kakaoGame2ndPwCodeContent;
    public final View kakaoGame2ndPwCodeContentLine;
    public final NotoSansEditText kakaoGame2ndPwCodeInput;
    public final NotoSansTextView kakaoGame2ndPwContentTitle;
    public final Button kakaoGame2ndPwResetButton;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwCodeInputViewBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, NotoSansTextView notoSansTextView, View view, NotoSansEditText notoSansEditText, NotoSansTextView notoSansTextView2, Button button) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwCodeClear = frameLayout;
        this.kakaoGame2ndPwCodeContent = notoSansTextView;
        this.kakaoGame2ndPwCodeContentLine = view;
        this.kakaoGame2ndPwCodeInput = notoSansEditText;
        this.kakaoGame2ndPwContentTitle = notoSansTextView2;
        this.kakaoGame2ndPwResetButton = button;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCodeInputViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCodeInputViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_code_input_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCodeInputViewBinding bind(View view) {
        View findChildViewById;
        int i = C2558R.id.kakao_game_2nd_pw_code_clear;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C2558R.id.kakao_game_2nd_pw_code_content;
            NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2558R.id.kakao_game_2nd_pw_code_content_line))) != null) {
                i = C2558R.id.kakao_game_2nd_pw_code_input;
                NotoSansEditText notoSansEditText = (NotoSansEditText) ViewBindings.findChildViewById(view, i);
                if (notoSansEditText != null) {
                    i = C2558R.id.kakao_game_2nd_pw_content_title;
                    NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                    if (notoSansTextView2 != null) {
                        i = C2558R.id.kakao_game_2nd_pw_reset_button;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            return new KakaoGame2ndPwCodeInputViewBinding((RelativeLayout) view, frameLayout, notoSansTextView, findChildViewById, notoSansEditText, notoSansTextView2, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
