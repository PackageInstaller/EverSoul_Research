package com.kakao.sdk.friend.p016e;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;

/* renamed from: com.kakao.sdk.friend.e.d */
/* loaded from: classes3.dex */
public final class C2145d implements ViewBinding {

    /* renamed from: a */
    public final ConstraintLayout f691a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2145d(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, ImageButton imageButton) {
        this.f691a = constraintLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2145d m504a(View view) {
        int i = C2110R.id.error_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C2110R.id.error_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C2110R.id.refresh_button;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    return new C2145d((ConstraintLayout) view, linearLayout, textView, imageButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f691a;
    }
}
