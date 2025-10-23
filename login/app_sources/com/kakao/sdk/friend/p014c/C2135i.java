package com.kakao.sdk.friend.p014c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.p016e.C2152k;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.c.i */
/* loaded from: classes3.dex */
public final class C2135i extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public final boolean f663a;

    /* renamed from: b */
    public final C2152k f664b;

    /* renamed from: c */
    public final Function1<AbstractC2169b.a, Unit> f665c;

    /* renamed from: d */
    public final Function1<AbstractC2169b.a, Unit> f666d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2135i(boolean z, C2152k binding, Function1<? super AbstractC2169b.a, Unit> checkCallback, Function1<? super AbstractC2169b.a, Unit> uncheckCallback) {
        super(binding.m508a());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(checkCallback, "checkCallback");
        Intrinsics.checkNotNullParameter(uncheckCallback, "uncheckCallback");
        this.f663a = z;
        this.f664b = binding;
        this.f665c = checkCallback;
        this.f666d = uncheckCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m489a(C2152k this_bindRoot, C2135i this$0, AbstractC2169b.a user, View view) {
        Intrinsics.checkNotNullParameter(this_bindRoot, "$this_bindRoot");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(user, "$user");
        (!this_bindRoot.f717b.isChecked() ? this$0.f665c : this$0.f666d).invoke(user);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if ((!r0.isEmpty()) == true) goto L9;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m490a(final com.kakao.sdk.friend.p016e.C2152k r4, final com.kakao.sdk.friend.p020i.AbstractC2169b.a r5) {
        /*
            r3 = this;
            java.util.List<com.kakao.sdk.friend.model.DisableSelectOption> r0 = r5.f785e
            r1 = 0
            if (r0 != 0) goto L6
            goto Lf
        L6:
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 != r2) goto Lf
            goto L10
        Lf:
            r2 = r1
        L10:
            if (r2 == 0) goto L38
            androidx.appcompat.widget.AppCompatRadioButton r5 = r4.f717b
            r0 = 8
            r5.setVisibility(r0)
            com.kakao.sdk.friend.e.k r5 = r3.f664b
            com.kakao.sdk.friend.view.SquircleImageView r5 = r5.f719d
            r0 = 1050253722(0x3e99999a, float:0.3)
            r5.setAlpha(r0)
            com.kakao.sdk.friend.e.k r5 = r3.f664b
            android.widget.TextView r5 = r5.f718c
            r5.setAlpha(r0)
            com.kakao.sdk.friend.e.k r5 = r3.f664b
            android.widget.TextView r5 = r5.f720e
            r5.setAlpha(r0)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r4.f716a
            r5 = 0
            r4.setOnClickListener(r5)
            return
        L38:
            androidx.appcompat.widget.AppCompatRadioButton r0 = r4.f717b
            r0.setVisibility(r1)
            com.kakao.sdk.friend.e.k r0 = r3.f664b
            com.kakao.sdk.friend.view.SquircleImageView r0 = r0.f719d
            r1 = 1065353216(0x3f800000, float:1.0)
            r0.setAlpha(r1)
            com.kakao.sdk.friend.e.k r0 = r3.f664b
            android.widget.TextView r0 = r0.f718c
            r0.setAlpha(r1)
            com.kakao.sdk.friend.e.k r0 = r3.f664b
            android.widget.TextView r0 = r0.f720e
            r0.setAlpha(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r4.f716a
            com.kakao.sdk.friend.c.i$$ExternalSyntheticLambda0 r1 = new com.kakao.sdk.friend.c.i$$ExternalSyntheticLambda0
            r1.<init>()
            r0.setOnClickListener(r1)
            return
            fill-array 0x0060: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p014c.C2135i.m490a(com.kakao.sdk.friend.e.k, com.kakao.sdk.friend.i.b$a):void");
    }
}
