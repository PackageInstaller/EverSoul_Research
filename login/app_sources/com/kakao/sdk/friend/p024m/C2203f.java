package com.kakao.sdk.friend.p024m;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.f */
/* loaded from: classes3.dex */
public final class C2203f extends Lambda implements Function1<View, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2199b f876a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2203f(C2199b c2199b) {
        super(1);
        this.f876a = c2199b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View it = view;
        Intrinsics.checkNotNullParameter(it, "it");
        C2199b c2199b = this.f876a;
        int i = C2199b.f862h;
        c2199b.m570a();
        return Unit.INSTANCE;
    }
}
