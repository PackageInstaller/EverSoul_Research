package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwWarningViewBinding implements ViewBinding {
    public final RelativeLayout kakaoGame2ndPwCenterWarningView;
    public final NotoSansTextView kakaoGame2ndPwContent;
    public final NotoSansTextView kakaoGame2ndPwTitle;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwWarningViewBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, NotoSansTextView notoSansTextView, NotoSansTextView notoSansTextView2) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwCenterWarningView = relativeLayout2;
        this.kakaoGame2ndPwContent = notoSansTextView;
        this.kakaoGame2ndPwTitle = notoSansTextView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwWarningViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwWarningViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_warning_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwWarningViewBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = C2558R.id.kakao_game_2nd_pw_content;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2558R.id.kakao_game_2nd_pw_title;
            NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView2 != null) {
                return new KakaoGame2ndPwWarningViewBinding(relativeLayout, relativeLayout, notoSansTextView, notoSansTextView2);
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
