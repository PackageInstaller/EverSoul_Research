package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameSdkLoginItemSpaceBinding implements ViewBinding {
    public final View kakaoGameLoginBottomSpace;
    public final RelativeLayout kakaoGameLoginIdpItemSpace;
    private final FrameLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameSdkLoginItemSpaceBinding(FrameLayout frameLayout, View view, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.kakaoGameLoginBottomSpace = view;
        this.kakaoGameLoginIdpItemSpace = relativeLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginItemSpaceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginItemSpaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_sdk_login_item_space, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameSdkLoginItemSpaceBinding bind(View view) {
        int i = C2382R.id.kakao_game_login_bottom_space;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C2382R.id.kakao_game_login_idp_item_space;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                return new KakaoGameSdkLoginItemSpaceBinding((FrameLayout) view, findChildViewById, relativeLayout);
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
