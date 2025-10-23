package com.kakao.sdk.friend.p016e;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;

/* renamed from: com.kakao.sdk.friend.e.o */
/* loaded from: classes3.dex */
public final class C2156o implements ViewBinding {

    /* renamed from: a */
    public final ConstraintLayout f729a;

    /* renamed from: b */
    public final ImageButton f730b;

    /* renamed from: c */
    public final TextView f731c;

    /* renamed from: d */
    public final ConstraintLayout f732d;

    /* renamed from: e */
    public final TextView f733e;

    /* renamed from: f */
    public final TextView f734f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2156o(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.f729a = constraintLayout;
        this.f730b = imageButton;
        this.f731c = textView;
        this.f732d = constraintLayout2;
        this.f733e = textView2;
        this.f734f = textView3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2156o m511a(View view) {
        int i = C2110R.id.back_btn;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = C2110R.id.done_btn;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C2110R.id.done_btn_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = C2110R.id.picked_count_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C2110R.id.title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new C2156o((ConstraintLayout) view, imageButton, textView, constraintLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f729a;
    }
}
