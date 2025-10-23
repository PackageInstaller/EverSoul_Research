package com.kakao.sdk.friend.p016e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;

/* renamed from: com.kakao.sdk.friend.e.i */
/* loaded from: classes3.dex */
public final class C2150i implements ViewBinding {

    /* renamed from: a */
    public final ConstraintLayout f708a;

    /* renamed from: b */
    public final TextView f709b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2150i(ConstraintLayout constraintLayout, TextView textView) {
        this.f708a = constraintLayout;
        this.f709b = textView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public ConstraintLayout m506a() {
        return this.f708a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2150i m505a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C2110R.layout.kakao_sdk_header_friend_picker, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        int i = C2110R.id.title_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i);
        if (textView != null) {
            return new C2150i((ConstraintLayout) inflate, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f708a;
    }
}
