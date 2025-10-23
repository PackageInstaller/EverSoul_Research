package com.kakao.sdk.friend.p016e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.kakao.sdk.friend.view.SquircleImageView;

/* renamed from: com.kakao.sdk.friend.e.l */
/* loaded from: classes3.dex */
public final class C2153l implements ViewBinding {

    /* renamed from: a */
    public final ConstraintLayout f721a;

    /* renamed from: b */
    public final TextView f722b;

    /* renamed from: c */
    public final SquircleImageView f723c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2153l(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, SquircleImageView squircleImageView) {
        this.f721a = constraintLayout;
        this.f722b = textView;
        this.f723c = squircleImageView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public ConstraintLayout m509a() {
        return this.f721a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f721a;
    }
}
