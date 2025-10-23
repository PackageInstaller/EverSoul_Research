package com.kakao.sdk.friend.p025n;

import android.content.Context;
import android.view.ViewGroup;
import com.kakao.sdk.friend.p024m.C2218u;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.n.b */
/* loaded from: classes3.dex */
public final class C2223b {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final C2218u m615a(ViewGroup viewGroup, String placeHolder) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        C2218u c2218u = new C2218u(context);
        c2218u.setPlaceholderText(placeHolder);
        viewGroup.addView(c2218u);
        return c2218u;
    }
}
