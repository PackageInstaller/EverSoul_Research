package com.kakao.sdk.friend.p016e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.kakao.sdk.friend.C2110R;

/* renamed from: com.kakao.sdk.friend.e.a */
/* loaded from: classes3.dex */
public final class C2142a implements ViewBinding {

    /* renamed from: a */
    public final LinearLayout f686a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2142a(LinearLayout linearLayout) {
        this.f686a = linearLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public LinearLayout m501a() {
        return this.f686a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2142a m500a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2110R.layout.kakao_sdk_category_divider, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        if (inflate != null) {
            return new C2142a((LinearLayout) inflate);
        }
        throw new NullPointerException("rootView");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f686a;
    }
}
