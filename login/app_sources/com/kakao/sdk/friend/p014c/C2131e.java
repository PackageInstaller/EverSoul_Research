package com.kakao.sdk.friend.p014c;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p016e.C2144c;
import com.kakao.sdk.friend.p023l.C2191g;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.c.e */
/* loaded from: classes3.dex */
public final class C2131e extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public final boolean f655a;

    /* renamed from: b */
    public final C2144c f656b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2131e(boolean z, C2144c binding) {
        super(binding.m503a());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.f655a = z;
        this.f656b = binding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m484a() {
        if (C2191g.f848c == 2) {
            TextView textView = this.f656b.f690b;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ((LinearLayout.LayoutParams) layoutParams).topMargin = textView.getResources().getDimensionPixelSize(this.f655a ? C2110R.dimen.popup_empty_search_result_margin_top_landscape : C2110R.dimen.empty_search_result_margin_top_landscape);
            return;
        }
        if (this.f655a) {
            TextView textView2 = this.f656b.f690b;
            ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
            if (layoutParams2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            ((LinearLayout.LayoutParams) layoutParams2).topMargin = textView2.getResources().getDimensionPixelSize(C2110R.dimen.popup_empty_search_result_margin_top);
        }
    }
}
