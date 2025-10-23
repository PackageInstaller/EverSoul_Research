package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwInputDisplayBinding implements ViewBinding {
    public final ImageView pwInputNone;
    public final NotoSansTextView pwInputValue;
    private final FrameLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwInputDisplayBinding(FrameLayout frameLayout, ImageView imageView, NotoSansTextView notoSansTextView) {
        this.rootView = frameLayout;
        this.pwInputNone = imageView;
        this.pwInputValue = notoSansTextView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDisplayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDisplayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_input_display, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwInputDisplayBinding bind(View view) {
        int i = C2558R.id.pw_input_none;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C2558R.id.pw_input_value;
            NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView != null) {
                return new KakaoGame2ndPwInputDisplayBinding((FrameLayout) view, imageView, notoSansTextView);
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
