package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameProtectedUserUnregisterConfirmBinding implements ViewBinding {
    public final NotoSansTextView kakaoGameUnregisterGuideView;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameProtectedUserUnregisterConfirmBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView) {
        this.rootView = relativeLayout;
        this.kakaoGameUnregisterGuideView = notoSansTextView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterConfirmBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterConfirmBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_protected_user_unregister_confirm, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserUnregisterConfirmBinding bind(View view) {
        int i = C2382R.id.kakao_game_unregister_guide_view;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            return new KakaoGameProtectedUserUnregisterConfirmBinding((RelativeLayout) view, notoSansTextView);
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
