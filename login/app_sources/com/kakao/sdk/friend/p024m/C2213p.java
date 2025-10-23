package com.kakao.sdk.friend.p024m;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.p */
/* loaded from: classes3.dex */
public final class C2213p extends Lambda implements Function1<View, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2206i f899a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2213p(C2206i c2206i) {
        super(1);
        this.f899a = c2206i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(View view) {
        View it = view;
        Intrinsics.checkNotNullParameter(it, "it");
        C2206i c2206i = this.f899a;
        int i = C2206i.f879j;
        c2206i.m581a();
        return Unit.INSTANCE;
    }
}
