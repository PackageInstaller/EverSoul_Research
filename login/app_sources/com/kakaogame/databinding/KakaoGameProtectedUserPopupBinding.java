package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.kakaogame.p029ui.font.NotoSansButton;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameProtectedUserPopupBinding implements ViewBinding {
    public final KakaoGameProtectedUserConfirmCodeBinding confirmCodeView;
    public final RelativeLayout kakaoGameProtectedButtonLayout;
    public final NotoSansButton kakaoGameProtectedPopupCancel;
    public final NotoSansButton kakaoGameProtectedPopupClose;
    public final NotoSansButton kakaoGameProtectedPopupConfirm;
    public final RelativeLayout kakaoGameProtectedPopupContentView;
    public final NotoSansTextView kakaoGameProtectedPopupTitle;
    public final RelativeLayout kakaoGameProtectedPopupTitleView;
    public final RelativeLayout kakaoGameProtectedPopupView;
    public final RelativeLayout kakaoGameProtectedPopupViewBack;
    public final FrameLayout kakaoGameProtectedUserTopbarClose;
    public final KakaoGameProtectedUserRestrictGuideBinding restrictGuideView;
    private final RelativeLayout rootView;
    public final KakaoGameProtectedUserUnregisterAgreementBinding unregisterAgreementView;
    public final KakaoGameProtectedUserUnregisterConfirmBinding unregisterConfirmView;
    public final KakaoGameProtectedUserWebviewBinding webView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameProtectedUserPopupBinding(RelativeLayout relativeLayout, KakaoGameProtectedUserConfirmCodeBinding kakaoGameProtectedUserConfirmCodeBinding, RelativeLayout relativeLayout2, NotoSansButton notoSansButton, NotoSansButton notoSansButton2, NotoSansButton notoSansButton3, RelativeLayout relativeLayout3, NotoSansTextView notoSansTextView, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, FrameLayout frameLayout, KakaoGameProtectedUserRestrictGuideBinding kakaoGameProtectedUserRestrictGuideBinding, KakaoGameProtectedUserUnregisterAgreementBinding kakaoGameProtectedUserUnregisterAgreementBinding, KakaoGameProtectedUserUnregisterConfirmBinding kakaoGameProtectedUserUnregisterConfirmBinding, KakaoGameProtectedUserWebviewBinding kakaoGameProtectedUserWebviewBinding) {
        this.rootView = relativeLayout;
        this.confirmCodeView = kakaoGameProtectedUserConfirmCodeBinding;
        this.kakaoGameProtectedButtonLayout = relativeLayout2;
        this.kakaoGameProtectedPopupCancel = notoSansButton;
        this.kakaoGameProtectedPopupClose = notoSansButton2;
        this.kakaoGameProtectedPopupConfirm = notoSansButton3;
        this.kakaoGameProtectedPopupContentView = relativeLayout3;
        this.kakaoGameProtectedPopupTitle = notoSansTextView;
        this.kakaoGameProtectedPopupTitleView = relativeLayout4;
        this.kakaoGameProtectedPopupView = relativeLayout5;
        this.kakaoGameProtectedPopupViewBack = relativeLayout6;
        this.kakaoGameProtectedUserTopbarClose = frameLayout;
        this.restrictGuideView = kakaoGameProtectedUserRestrictGuideBinding;
        this.unregisterAgreementView = kakaoGameProtectedUserUnregisterAgreementBinding;
        this.unregisterConfirmView = kakaoGameProtectedUserUnregisterConfirmBinding;
        this.webView = kakaoGameProtectedUserWebviewBinding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_protected_user_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserPopupBinding bind(View view) {
        View findChildViewById;
        int i = C2382R.id.confirm_code_view;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            KakaoGameProtectedUserConfirmCodeBinding bind = KakaoGameProtectedUserConfirmCodeBinding.bind(findChildViewById2);
            i = C2382R.id.kakao_game_protected_button_layout;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = C2382R.id.kakao_game_protected_popup_cancel;
                NotoSansButton notoSansButton = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                if (notoSansButton != null) {
                    i = C2382R.id.kakao_game_protected_popup_close;
                    NotoSansButton notoSansButton2 = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                    if (notoSansButton2 != null) {
                        i = C2382R.id.kakao_game_protected_popup_confirm;
                        NotoSansButton notoSansButton3 = (NotoSansButton) ViewBindings.findChildViewById(view, i);
                        if (notoSansButton3 != null) {
                            i = C2382R.id.kakao_game_protected_popup_content_view;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = C2382R.id.kakao_game_protected_popup_title;
                                NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                                if (notoSansTextView != null) {
                                    i = C2382R.id.kakao_game_protected_popup_title_view;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        RelativeLayout relativeLayout4 = (RelativeLayout) view;
                                        i = C2382R.id.kakao_game_protected_popup_view_back;
                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                        if (relativeLayout5 != null) {
                                            i = C2382R.id.kakao_game_protected_user_topbar_close;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2382R.id.restrict_guide_view))) != null) {
                                                KakaoGameProtectedUserRestrictGuideBinding bind2 = KakaoGameProtectedUserRestrictGuideBinding.bind(findChildViewById);
                                                i = C2382R.id.unregister_agreement_view;
                                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById3 != null) {
                                                    KakaoGameProtectedUserUnregisterAgreementBinding bind3 = KakaoGameProtectedUserUnregisterAgreementBinding.bind(findChildViewById3);
                                                    i = C2382R.id.unregister_confirm_view;
                                                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                                                    if (findChildViewById4 != null) {
                                                        KakaoGameProtectedUserUnregisterConfirmBinding bind4 = KakaoGameProtectedUserUnregisterConfirmBinding.bind(findChildViewById4);
                                                        i = C2382R.id.web_view;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                                        if (findChildViewById5 != null) {
                                                            return new KakaoGameProtectedUserPopupBinding(relativeLayout4, bind, relativeLayout, notoSansButton, notoSansButton2, notoSansButton3, relativeLayout2, notoSansTextView, relativeLayout3, relativeLayout4, relativeLayout5, frameLayout, bind2, bind3, bind4, KakaoGameProtectedUserWebviewBinding.bind(findChildViewById5));
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
