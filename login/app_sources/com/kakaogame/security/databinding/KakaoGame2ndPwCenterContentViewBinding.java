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
public final class KakaoGame2ndPwCenterContentViewBinding implements ViewBinding {
    public final NotoSansTextView kakaoGame2ndPwCenterContent;
    public final RelativeLayout kakaoGame2ndPwCenterContentView;
    public final NotoSansTextView kakaoGame2ndPwCenterSubContent;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwCenterContentViewBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, RelativeLayout relativeLayout2, NotoSansTextView notoSansTextView2) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwCenterContent = notoSansTextView;
        this.kakaoGame2ndPwCenterContentView = relativeLayout2;
        this.kakaoGame2ndPwCenterSubContent = notoSansTextView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCenterContentViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCenterContentViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_center_content_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwCenterContentViewBinding bind(View view) {
        int i = C2558R.id.kakao_game_2nd_pw_center_content;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = C2558R.id.kakao_game_2nd_pw_center_sub_content;
            NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i2);
            if (notoSansTextView2 != null) {
                return new KakaoGame2ndPwCenterContentViewBinding(relativeLayout, notoSansTextView, relativeLayout, notoSansTextView2);
            }
            i = i2;
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
