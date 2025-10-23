package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameSdkLogoutPopupBinding implements ViewBinding {
    public final TextView kakaoGameSdkLogoutBtnCancel;
    public final TextView kakaoGameSdkLogoutBtnOk;
    public final TextView kakaoGameSdkLogoutDesc;
    public final LinearLayout kakaoGameSdkLogoutIdp;
    public final TextView kakaoGameSdkLogoutIdpDesc;
    public final ImageView kakaoGameSdkLogoutIdpIcon;
    public final View kakaoGameSdkLogoutIdpLine;
    public final TextView kakaoGameSdkLogoutTitle;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSdkLogoutPopupBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, ImageView imageView, View view, TextView textView5) {
        this.rootView = relativeLayout;
        this.kakaoGameSdkLogoutBtnCancel = textView;
        this.kakaoGameSdkLogoutBtnOk = textView2;
        this.kakaoGameSdkLogoutDesc = textView3;
        this.kakaoGameSdkLogoutIdp = linearLayout;
        this.kakaoGameSdkLogoutIdpDesc = textView4;
        this.kakaoGameSdkLogoutIdpIcon = imageView;
        this.kakaoGameSdkLogoutIdpLine = view;
        this.kakaoGameSdkLogoutTitle = textView5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLogoutPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLogoutPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_sdk_logout_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLogoutPopupBinding bind(View view) {
        View findChildViewById;
        int i = C2382R.id.kakao_game_sdk_logout_btn_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C2382R.id.kakao_game_sdk_logout_btn_ok;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C2382R.id.kakao_game_sdk_logout_desc;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = C2382R.id.kakao_game_sdk_logout_idp;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C2382R.id.kakao_game_sdk_logout_idp_desc;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = C2382R.id.kakao_game_sdk_logout_idp_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C2382R.id.kakao_game_sdk_logout_idp_line))) != null) {
                                i = C2382R.id.kakao_game_sdk_logout_title;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    return new KakaoGameSdkLogoutPopupBinding((RelativeLayout) view, textView, textView2, textView3, linearLayout, textView4, imageView, findChildViewById, textView5);
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
