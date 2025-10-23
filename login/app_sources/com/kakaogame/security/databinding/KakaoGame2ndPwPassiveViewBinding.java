package com.kakaogame.security.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.kakaogame.security.C2558R;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGame2ndPwPassiveViewBinding implements ViewBinding {
    public final RelativeLayout kakaoGame2ndPwPassiveBg;
    public final NotoSansTextView kakaoGame2ndPwPassiveContent;
    public final NotoSansTextView kakaoGame2ndPwPassiveContentDump;
    public final ImageView kakaoGame2ndPwPassiveRound;
    public final NotoSansTextView passiveViewDetail;
    private final RelativeLayout rootView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGame2ndPwPassiveViewBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, NotoSansTextView notoSansTextView, NotoSansTextView notoSansTextView2, ImageView imageView, NotoSansTextView notoSansTextView3) {
        this.rootView = relativeLayout;
        this.kakaoGame2ndPwPassiveBg = relativeLayout2;
        this.kakaoGame2ndPwPassiveContent = notoSansTextView;
        this.kakaoGame2ndPwPassiveContentDump = notoSansTextView2;
        this.kakaoGame2ndPwPassiveRound = imageView;
        this.passiveViewDetail = notoSansTextView3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPassiveViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPassiveViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2558R.layout.kakao_game_2nd_pw_passive_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGame2ndPwPassiveViewBinding bind(View view) {
        int i = C2558R.id.kakao_game_2nd_pw_passive_bg;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = C2558R.id.kakao_game_2nd_pw_passive_content;
            NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView != null) {
                i = C2558R.id.kakao_game_2nd_pw_passive_content_dump;
                NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                if (notoSansTextView2 != null) {
                    i = C2558R.id.kakao_game_2nd_pw_passive_round;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = C2558R.id.passive_view_detail;
                        NotoSansTextView notoSansTextView3 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                        if (notoSansTextView3 != null) {
                            return new KakaoGame2ndPwPassiveViewBinding((RelativeLayout) view, relativeLayout, notoSansTextView, notoSansTextView2, imageView, notoSansTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException(y.٬ݯح׭٩(576682446).concat(view.getResources().getResourceName(i)));
    }
}
