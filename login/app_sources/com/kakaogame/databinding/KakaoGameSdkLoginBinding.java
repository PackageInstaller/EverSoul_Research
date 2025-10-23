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
public final class KakaoGameSdkLoginBinding implements ViewBinding {
    public final View kakaoGameLoginBottomSpace;
    public final ImageView kakaoGameLoginClose;
    public final LinearLayout kakaoGameLoginIdpList;
    public final LinearLayout kakaoGameLoginIdpList1;
    public final LinearLayout kakaoGameLoginIdpList2;
    public final LinearLayout kakaoGameLoginIdpListMulti;
    public final RelativeLayout kakaoGameLoginLayout;
    public final TextView kakaoGameLoginTitle;
    private final RelativeLayout rootView;
    public final RelativeLayout topBarSpace;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSdkLoginBinding(RelativeLayout relativeLayout, View view, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RelativeLayout relativeLayout2, TextView textView, RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.kakaoGameLoginBottomSpace = view;
        this.kakaoGameLoginClose = imageView;
        this.kakaoGameLoginIdpList = linearLayout;
        this.kakaoGameLoginIdpList1 = linearLayout2;
        this.kakaoGameLoginIdpList2 = linearLayout3;
        this.kakaoGameLoginIdpListMulti = linearLayout4;
        this.kakaoGameLoginLayout = relativeLayout2;
        this.kakaoGameLoginTitle = textView;
        this.topBarSpace = relativeLayout3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_sdk_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginBinding bind(View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, C2382R.id.kakao_game_login_bottom_space);
        int i = C2382R.id.kakao_game_login_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C2382R.id.kakao_game_login_idp_list;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, C2382R.id.kakao_game_login_idp_list1);
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, C2382R.id.kakao_game_login_idp_list2);
                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, C2382R.id.kakao_game_login_idp_list_multi);
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = C2382R.id.kakao_game_login_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new KakaoGameSdkLoginBinding(relativeLayout, findChildViewById, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, relativeLayout, textView, (RelativeLayout) ViewBindings.findChildViewById(view, C2382R.id.top_bar_space));
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
