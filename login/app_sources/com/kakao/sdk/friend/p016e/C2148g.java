package com.kakao.sdk.friend.p016e;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.kakao.sdk.friend.view.EmptyView;

/* renamed from: com.kakao.sdk.friend.e.g */
/* loaded from: classes3.dex */
public final class C2148g implements ViewBinding {

    /* renamed from: a */
    public final ConstraintLayout f698a;

    /* renamed from: b */
    public final TextView f699b;

    /* renamed from: c */
    public final EmptyView f700c;

    /* renamed from: d */
    public final TextView f701d;

    /* renamed from: e */
    public final ViewPager2 f702e;

    /* renamed from: f */
    public final TabLayout f703f;

    /* renamed from: g */
    public final C2156o f704g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2148g(ConstraintLayout constraintLayout, TextView textView, EmptyView emptyView, TextView textView2, ViewPager2 viewPager2, TabLayout tabLayout, C2156o c2156o) {
        this.f698a = constraintLayout;
        this.f699b = textView;
        this.f700c = emptyView;
        this.f701d = textView2;
        this.f702e = viewPager2;
        this.f703f = tabLayout;
        this.f704g = c2156o;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f698a;
    }
}
