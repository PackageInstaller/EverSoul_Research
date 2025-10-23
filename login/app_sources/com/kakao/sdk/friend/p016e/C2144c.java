package com.kakao.sdk.friend.p016e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;

/* renamed from: com.kakao.sdk.friend.e.c */
/* loaded from: classes3.dex */
public final class C2144c implements ViewBinding {

    /* renamed from: a */
    public final LinearLayout f689a;

    /* renamed from: b */
    public final TextView f690b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2144c(LinearLayout linearLayout, TextView textView) {
        this.f689a = linearLayout;
        this.f690b = textView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public LinearLayout m503a() {
        return this.f689a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2144c m502a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2110R.layout.kakao_sdk_empty_search_result_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        int i = C2110R.id.empty_search_result_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i);
        if (textView != null) {
            return new C2144c((LinearLayout) inflate, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f689a;
    }
}
