package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.secondpw.view.PasswordDisplayView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwSettingDetailViewBinding implements ViewBinding {
    public final FrameLayout codeInputConfirmDisplayFrameView;
    public final PasswordDisplayView codeInputConfirmDisplayView;
    public final PasswordDisplayView codeInputDisplayView;
    public final KakaoGame2ndPwPassiveViewBinding hasPassiveView;
    public final NotoSansTextView kakaoGame2ndPwBlockingGuide;
    public final KakaoGame2ndPwNoPassiveViewBinding noPassiveView;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwSettingDetailViewBinding(RelativeLayout relativeLayout, FrameLayout frameLayout, PasswordDisplayView passwordDisplayView, PasswordDisplayView passwordDisplayView2, KakaoGame2ndPwPassiveViewBinding kakaoGame2ndPwPassiveViewBinding, NotoSansTextView notoSansTextView, KakaoGame2ndPwNoPassiveViewBinding kakaoGame2ndPwNoPassiveViewBinding) {
        this.rootView = relativeLayout;
        this.codeInputConfirmDisplayFrameView = frameLayout;
        this.codeInputConfirmDisplayView = passwordDisplayView;
        this.codeInputDisplayView = passwordDisplayView2;
        this.hasPassiveView = kakaoGame2ndPwPassiveViewBinding;
        this.kakaoGame2ndPwBlockingGuide = notoSansTextView;
        this.noPassiveView = kakaoGame2ndPwNoPassiveViewBinding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwSettingDetailViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwSettingDetailViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_setting_detail_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwSettingDetailViewBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = C2558R.id.code_input_confirm_display_frame_view;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C2558R.id.code_input_confirm_display_view;
            PasswordDisplayView passwordDisplayView = (PasswordDisplayView) ViewBindings.findChildViewById(view, i);
            if (passwordDisplayView != null) {
                i = C2558R.id.code_input_display_view;
                PasswordDisplayView passwordDisplayView2 = (PasswordDisplayView) ViewBindings.findChildViewById(view, i);
                if (passwordDisplayView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2558R.id.has_passive_view))) != null) {
                    KakaoGame2ndPwPassiveViewBinding bind = KakaoGame2ndPwPassiveViewBinding.bind(findChildViewById);
                    i = C2558R.id.kakao_game_2nd_pw_blocking_guide;
                    NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                    if (notoSansTextView != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C2558R.id.no_passive_view))) != null) {
                        return new KakaoGame2ndPwSettingDetailViewBinding((RelativeLayout) view, frameLayout, passwordDisplayView, passwordDisplayView2, bind, notoSansTextView, KakaoGame2ndPwNoPassiveViewBinding.bind(findChildViewById2));
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
