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
public final class KakaoGame2ndPwRestrictViewBinding implements ViewBinding {
    public final NotoSansTextView kakaoGame2ndPwError2lineMsg;
    public final NotoSansTextView kakaoGame2ndPwError2lineTime;
    public final NotoSansTextView kakaoGame2ndPwError2lineTimeGuide;
    public final NotoSansButton kakaoGame2ndPwErrorConfirm;
    public final RelativeLayout kakaoGame2ndPwErrorView;
    public final RelativeLayout kakaoGame2ndPwErrorViewBack;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwRestrictViewBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, NotoSansTextView notoSansTextView2, NotoSansTextView notoSansTextView3, NotoSansButton notoSansButton, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwError2lineMsg = notoSansTextView;
        this.kakaoGame2ndPwError2lineTime = notoSansTextView2;
        this.kakaoGame2ndPwError2lineTimeGuide = notoSansTextView3;
        this.kakaoGame2ndPwErrorConfirm = notoSansButton;
        this.kakaoGame2ndPwErrorView = relativeLayout2;
        this.kakaoGame2ndPwErrorViewBack = relativeLayout3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwRestrictViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwRestrictViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_restrict_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwRestrictViewBinding bind(View view) {
        int i = C2558R.id.kakao_game_2nd_pw_error_2line_msg;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2558R.id.kakao_game_2nd_pw_error_2line_time;
            NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView2 != null) {
                i = C2558R.id.kakao_game_2nd_pw_error_2line_time_guide;
                NotoSansTextView notoSansTextView3 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                if (notoSansTextView3 != null) {
                    i = C2558R.id.kakao_game_2nd_pw_error_confirm;
                    NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                    if (notoSansButton != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i = C2558R.id.kakao_game_2nd_pw_error_view_back;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout2 != null) {
                            return new KakaoGame2ndPwRestrictViewBinding(relativeLayout, notoSansTextView, notoSansTextView2, notoSansTextView3, notoSansButton, relativeLayout, relativeLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
