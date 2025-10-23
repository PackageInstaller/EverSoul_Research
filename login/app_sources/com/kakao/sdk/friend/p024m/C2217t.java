package com.kakao.sdk.friend.p024m;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.t */
/* loaded from: classes3.dex */
public final class C2217t {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m590a(Function1 action, View it) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        action.invoke(it);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m589a(View view, final Function1<? super View, Unit> action) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        view.setOnClickListener(new ViewOnClickListenerC2216s(new View.OnClickListener() { // from class: com.kakao.sdk.friend.m.t$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C2217t.m590a(Function1.this, view2);
            }
        }, 500L));
    }
}
