package com.kakao.sdk.friend.p024m;

import com.kakao.sdk.friend.p020i.AbstractC2169b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.r */
/* loaded from: classes3.dex */
public final class C2215r extends Lambda implements Function1<AbstractC2169b.a, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2206i f900a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2215r(C2206i c2206i) {
        super(1);
        this.f900a = c2206i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AbstractC2169b.a aVar) {
        AbstractC2169b.a it = aVar;
        Intrinsics.checkNotNullParameter(it, "it");
        C2206i c2206i = this.f900a;
        int i = C2206i.f879j;
        c2206i.m586e().m671a(it);
        return Unit.INSTANCE;
    }
}
