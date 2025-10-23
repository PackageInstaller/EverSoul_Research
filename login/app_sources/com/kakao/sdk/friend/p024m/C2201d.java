package com.kakao.sdk.friend.p024m;

import com.kakao.sdk.friend.p020i.AbstractC2168a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.d */
/* loaded from: classes3.dex */
public final class C2201d extends Lambda implements Function1<AbstractC2168a.a, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2199b f874a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2201d(C2199b c2199b) {
        super(1);
        this.f874a = c2199b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AbstractC2168a.a aVar) {
        AbstractC2168a.a it = aVar;
        Intrinsics.checkNotNullParameter(it, "it");
        C2199b c2199b = this.f874a;
        int i = C2199b.f862h;
        c2199b.m574d().m666a();
        return Unit.INSTANCE;
    }
}
