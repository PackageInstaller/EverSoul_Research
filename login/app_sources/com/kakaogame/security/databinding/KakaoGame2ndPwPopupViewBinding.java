package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwPopupViewBinding implements ViewBinding {
    public final NotoSansTextView kakaoGame2ndPwError1lineMsg;
    public final NotoSansButton kakaoGame2ndPwPopupConfirm;
    public final RelativeLayout kakaoGame2ndPwPopupView;
    public final RelativeLayout kakaoGame2ndPwPopupViewBack;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwPopupViewBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, NotoSansButton notoSansButton, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwError1lineMsg = notoSansTextView;
        this.kakaoGame2ndPwPopupConfirm = notoSansButton;
        this.kakaoGame2ndPwPopupView = relativeLayout2;
        this.kakaoGame2ndPwPopupViewBack = relativeLayout3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_popup_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupViewBinding bind(View view) {
        int i = C2558R.id.kakao_game_2nd_pw_error_1line_msg;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2558R.id.kakao_game_2nd_pw_popup_confirm;
            NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
            if (notoSansButton != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = C2558R.id.kakao_game_2nd_pw_popup_view_back;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout2 != null) {
                    return new KakaoGame2ndPwPopupViewBinding(relativeLayout, notoSansTextView, notoSansButton, relativeLayout, relativeLayout2);
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
