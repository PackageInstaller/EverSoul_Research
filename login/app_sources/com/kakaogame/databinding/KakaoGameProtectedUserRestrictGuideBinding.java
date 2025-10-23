package com.kakaogame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakaogame.C2382R;
import com.kakaogame.p029ui.font.NotoSansTextView;
import com.liapp.y;

/* loaded from: classes3.dex */
public final class KakaoGameProtectedUserRestrictGuideBinding implements ViewBinding {
    public final NotoSansTextView kakaoGameProtectedPopupContent;
    public final NotoSansTextView kakaoGameProtectedPopupDetailReason;
    public final NotoSansTextView kakaoGameProtectedPopupDetailReasonDump;
    public final NotoSansTextView kakaoGameProtectedPopupDetailTerm;
    public final RelativeLayout kakaoGameProtectedPopupRestrictView;
    public final LinearLayout reasonLabel;
    public final RelativeLayout reasonView;
    private final RelativeLayout rootView;
    public final RelativeLayout termsLabel;
    public final ImageView yellowDot1;
    public final ImageView yellowDot2;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoGameProtectedUserRestrictGuideBinding(RelativeLayout relativeLayout, NotoSansTextView notoSansTextView, NotoSansTextView notoSansTextView2, NotoSansTextView notoSansTextView3, NotoSansTextView notoSansTextView4, RelativeLayout relativeLayout2, LinearLayout linearLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ImageView imageView, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.kakaoGameProtectedPopupContent = notoSansTextView;
        this.kakaoGameProtectedPopupDetailReason = notoSansTextView2;
        this.kakaoGameProtectedPopupDetailReasonDump = notoSansTextView3;
        this.kakaoGameProtectedPopupDetailTerm = notoSansTextView4;
        this.kakaoGameProtectedPopupRestrictView = relativeLayout2;
        this.reasonLabel = linearLayout;
        this.reasonView = relativeLayout3;
        this.termsLabel = relativeLayout4;
        this.yellowDot1 = imageView;
        this.yellowDot2 = imageView2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserRestrictGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserRestrictGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2382R.layout.kakao_game_protected_user_restrict_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static KakaoGameProtectedUserRestrictGuideBinding bind(View view) {
        int i = C2382R.id.kakao_game_protected_popup_content;
        NotoSansTextView notoSansTextView = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
        if (notoSansTextView != null) {
            i = C2382R.id.kakao_game_protected_popup_detail_reason;
            NotoSansTextView notoSansTextView2 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
            if (notoSansTextView2 != null) {
                i = C2382R.id.kakao_game_protected_popup_detail_reason_dump;
                NotoSansTextView notoSansTextView3 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                if (notoSansTextView3 != null) {
                    i = C2382R.id.kakao_game_protected_popup_detail_term;
                    NotoSansTextView notoSansTextView4 = (NotoSansTextView) ViewBindings.findChildViewById(view, i);
                    if (notoSansTextView4 != null) {
                        i = C2382R.id.kakao_game_protected_popup_restrict_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                        if (relativeLayout != null) {
                            i = C2382R.id.reason_label;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = C2382R.id.reason_view;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                if (relativeLayout2 != null) {
                                    i = C2382R.id.terms_label;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                    if (relativeLayout3 != null) {
                                        i = C2382R.id.yellow_dot_1;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = C2382R.id.yellow_dot_2;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                return new KakaoGameProtectedUserRestrictGuideBinding((RelativeLayout) view, notoSansTextView, notoSansTextView2, notoSansTextView3, notoSansTextView4, relativeLayout, linearLayout, relativeLayout2, relativeLayout3, imageView, imageView2);
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
