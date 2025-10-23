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
public final class KakaoGame2ndPwPopupLargeViewBinding implements ViewBinding {
    public final NotoSansTextView kakaoGame2ndPwError1lineMsg;
    public final NotoSansButton kakaoGame2ndPwPopupConfirm;
    public final RelativeLayout kakaoGame2ndPwPopupView;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwPopupLargeViewBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, NotoSansButton notoSansButton, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwError1lineMsg = notoSansTextView;
        this.kakaoGame2ndPwPopupConfirm = notoSansButton;
        this.kakaoGame2ndPwPopupView = relativeLayout2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupLargeViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupLargeViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_popup_large_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPopupLargeViewBinding bind(View view) {
        int i = C2558R.id.kakao_game_2nd_pw_error_1line_msg;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2558R.id.kakao_game_2nd_pw_popup_confirm;
            NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
            if (notoSansButton != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                return new KakaoGame2ndPwPopupLargeViewBinding(relativeLayout, notoSansTextView, notoSansButton, relativeLayout);
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
