package com.kakao.sdk.friend.p013b;

import com.kakao.sdk.friend.p020i.AbstractC2169b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.b.d */
/* loaded from: classes3.dex */
public final class C2124d extends Lambda implements Function1<AbstractC2169b.a, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2125e f642a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2124d(C2125e c2125e) {
        super(1);
        this.f642a = c2125e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AbstractC2169b.a aVar) {
        AbstractC2169b.a it = aVar;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f642a.f644b.invoke(it);
        return Unit.INSTANCE;
    }
}
