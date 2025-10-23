package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameSecondPasswordGuideViewBinding implements ViewBinding {
    public final KakaoGame2ndPwCenterContentViewBinding centerContentView;
    public final KakaoGame2ndPwCodeInputViewBinding codeInputView;
    public final KakaoGame2ndPwDigitCodeViewBinding digitCodeView;
    public final KakaoGame2ndPwErrorLargeViewBinding errorLargeView;
    public final KakaoGame2ndPwErrorViewBinding errorView;
    public final LinearLayout kakaoGame2ndPwButtons;
    public final NotoSansButton kakaoGame2ndPwCancelButton;
    public final NotoSansButton kakaoGame2ndPwConfirmButton;
    public final FrameLayout kakaoGame2ndPwTopbarClose;
    public final TextView kakaoGame2ndPwTopbarTitle;
    public final RelativeLayout kakaoGameTitleView;
    public final KakaoGame2ndPwPopupLargeViewBinding popupLargeView;
    public final KakaoGame2ndPwPopupViewBinding popupView;
    private final RelativeLayout rootView;
    public final KakaoGame2ndPw3lineContentViewBinding threeLineContentView;
    public final KakaoGame2ndPwWarningViewBinding warningView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSecondPasswordGuideViewBinding(RelativeLayout relativeLayout, KakaoGame2ndPwCenterContentViewBinding kakaoGame2ndPwCenterContentViewBinding, KakaoGame2ndPwCodeInputViewBinding kakaoGame2ndPwCodeInputViewBinding, KakaoGame2ndPwDigitCodeViewBinding kakaoGame2ndPwDigitCodeViewBinding, KakaoGame2ndPwErrorLargeViewBinding kakaoGame2ndPwErrorLargeViewBinding, KakaoGame2ndPwErrorViewBinding kakaoGame2ndPwErrorViewBinding, LinearLayout linearLayout, NotoSansButton notoSansButton, NotoSansButton notoSansButton2, FrameLayout frameLayout, TextView textView, RelativeLayout relativeLayout2, KakaoGame2ndPwPopupLargeViewBinding kakaoGame2ndPwPopupLargeViewBinding, KakaoGame2ndPwPopupViewBinding kakaoGame2ndPwPopupViewBinding, KakaoGame2ndPw3lineContentViewBinding kakaoGame2ndPw3lineContentViewBinding, KakaoGame2ndPwWarningViewBinding kakaoGame2ndPwWarningViewBinding) {
        this.rootView = relativeLayout;
        this.centerContentView = kakaoGame2ndPwCenterContentViewBinding;
        this.codeInputView = kakaoGame2ndPwCodeInputViewBinding;
        this.digitCodeView = kakaoGame2ndPwDigitCodeViewBinding;
        this.errorLargeView = kakaoGame2ndPwErrorLargeViewBinding;
        this.errorView = kakaoGame2ndPwErrorViewBinding;
        this.kakaoGame2ndPwButtons = linearLayout;
        this.kakaoGame2ndPwCancelButton = notoSansButton;
        this.kakaoGame2ndPwConfirmButton = notoSansButton2;
        this.kakaoGame2ndPwTopbarClose = frameLayout;
        this.kakaoGame2ndPwTopbarTitle = textView;
        this.kakaoGameTitleView = relativeLayout2;
        this.popupLargeView = kakaoGame2ndPwPopupLargeViewBinding;
        this.popupView = kakaoGame2ndPwPopupViewBinding;
        this.threeLineContentView = kakaoGame2ndPw3lineContentViewBinding;
        this.warningView = kakaoGame2ndPwWarningViewBinding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSecondPasswordGuideViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSecondPasswordGuideViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_second_password_guide_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSecondPasswordGuideViewBinding bind(View view) {
        View findChildViewById;
        int i = C2558R.id.center_content_view;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            KakaoGame2ndPwCenterContentViewBinding bind = KakaoGame2ndPwCenterContentViewBinding.bind(findChildViewById2);
            i = C2558R.id.code_input_view;
            View findChildViewById3 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById3 != null) {
                KakaoGame2ndPwCodeInputViewBinding bind2 = KakaoGame2ndPwCodeInputViewBinding.bind(findChildViewById3);
                i = C2558R.id.digit_code_view;
                View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById4 != null) {
                    KakaoGame2ndPwDigitCodeViewBinding bind3 = KakaoGame2ndPwDigitCodeViewBinding.bind(findChildViewById4);
                    i = C2558R.id.error_large_view;
                    View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById5 != null) {
                        KakaoGame2ndPwErrorLargeViewBinding bind4 = KakaoGame2ndPwErrorLargeViewBinding.bind(findChildViewById5);
                        i = C2558R.id.error_view;
                        View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById6 != null) {
                            KakaoGame2ndPwErrorViewBinding bind5 = KakaoGame2ndPwErrorViewBinding.bind(findChildViewById6);
                            i = C2558R.id.kakao_game_2nd_pw_buttons;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = C2558R.id.kakao_game_2nd_pw_cancel_button;
                                NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                                if (notoSansButton != null) {
                                    i = C2558R.id.kakao_game_2nd_pw_confirm_button;
                                    NotoSansButton notoSansButton2 = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                                    if (notoSansButton2 != null) {
                                        i = C2558R.id.kakao_game_2nd_pw_topbar_close;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                        if (frameLayout != null) {
                                            i = C2558R.id.kakao_game_2nd_pw_topbar_title;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView != null) {
                                                i = C2558R.id.kakao_game_title_view;
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2558R.id.popup_large_view))) != null) {
                                                    KakaoGame2ndPwPopupLargeViewBinding bind6 = KakaoGame2ndPwPopupLargeViewBinding.bind(findChildViewById);
                                                    i = C2558R.id.popup_view;
                                                    View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                                    if (findChildViewById7 != null) {
                                                        KakaoGame2ndPwPopupViewBinding bind7 = KakaoGame2ndPwPopupViewBinding.bind(findChildViewById7);
                                                        i = C2558R.id.three_line_content_view;
                                                        View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                                        if (findChildViewById8 != null) {
                                                            KakaoGame2ndPw3lineContentViewBinding bind8 = KakaoGame2ndPw3lineContentViewBinding.bind(findChildViewById8);
                                                            i = C2558R.id.warning_view;
                                                            View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById9 != null) {
                                                                return new KakaoGameSecondPasswordGuideViewBinding((RelativeLayout) view, bind, bind2, bind3, bind4, bind5, linearLayout, notoSansButton, notoSansButton2, frameLayout, textView, relativeLayout, bind6, bind7, bind8, KakaoGame2ndPwWarningViewBinding.bind(findChildViewById9));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
