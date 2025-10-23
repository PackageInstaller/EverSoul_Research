package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.secondpw.view.PasswordCodeDisplayView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwDisplayTextEditBinding implements ViewBinding {
    public final PasswordCodeDisplayView displayCode1;
    public final PasswordCodeDisplayView displayCode2;
    public final PasswordCodeDisplayView displayCode3;
    public final PasswordCodeDisplayView displayCode4;
    public final PasswordCodeDisplayView displayCode5;
    public final PasswordCodeDisplayView displayCode6;
    public final View kakaoGame2ndPwCodeContentLine;
    public final NotoSansTextView pwInputTitle;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwDisplayTextEditBinding(RelativeLayout relativeLayout, PasswordCodeDisplayView passwordCodeDisplayView, PasswordCodeDisplayView passwordCodeDisplayView2, PasswordCodeDisplayView passwordCodeDisplayView3, PasswordCodeDisplayView passwordCodeDisplayView4, PasswordCodeDisplayView passwordCodeDisplayView5, PasswordCodeDisplayView passwordCodeDisplayView6, View view, NotoSansTextView notoSansTextView) {
        this.rootView = relativeLayout;
        this.displayCode1 = passwordCodeDisplayView;
        this.displayCode2 = passwordCodeDisplayView2;
        this.displayCode3 = passwordCodeDisplayView3;
        this.displayCode4 = passwordCodeDisplayView4;
        this.displayCode5 = passwordCodeDisplayView5;
        this.displayCode6 = passwordCodeDisplayView6;
        this.kakaoGame2ndPwCodeContentLine = view;
        this.pwInputTitle = notoSansTextView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDisplayTextEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDisplayTextEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_display_text_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwDisplayTextEditBinding bind(View view) {
        View findChildViewById;
        int i = C2558R.id.display_code_1;
        PasswordCodeDisplayView passwordCodeDisplayView = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
        if (passwordCodeDisplayView != null) {
            i = C2558R.id.display_code_2;
            PasswordCodeDisplayView passwordCodeDisplayView2 = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
            if (passwordCodeDisplayView2 != null) {
                i = C2558R.id.display_code_3;
                PasswordCodeDisplayView passwordCodeDisplayView3 = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
                if (passwordCodeDisplayView3 != null) {
                    i = C2558R.id.display_code_4;
                    PasswordCodeDisplayView passwordCodeDisplayView4 = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
                    if (passwordCodeDisplayView4 != null) {
                        i = C2558R.id.display_code_5;
                        PasswordCodeDisplayView passwordCodeDisplayView5 = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
                        if (passwordCodeDisplayView5 != null) {
                            i = C2558R.id.display_code_6;
                            PasswordCodeDisplayView passwordCodeDisplayView6 = (PasswordCodeDisplayView) ViewBindings.findChildViewById(view, i);
                            if (passwordCodeDisplayView6 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2558R.id.kakao_game_2nd_pw_code_content_line))) != null) {
                                i = C2558R.id.pw_input_title;
                                NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                                if (notoSansTextView != null) {
                                    return new KakaoGame2ndPwDisplayTextEditBinding((RelativeLayout) view, passwordCodeDisplayView, passwordCodeDisplayView2, passwordCodeDisplayView3, passwordCodeDisplayView4, passwordCodeDisplayView5, passwordCodeDisplayView6, findChildViewById, notoSansTextView);
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
