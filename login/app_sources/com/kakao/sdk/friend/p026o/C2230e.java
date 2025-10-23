package com.kakao.sdk.friend.p026o;

import com.kakao.sdk.friend.p022k.AbstractC2181a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.o.e */
/* loaded from: classes3.dex */
public final class C2230e extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2232g f956a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2230e(C2232g c2232g) {
        super(1);
        this.f956a = c2232g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        Throwable it = th;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f956a.f974p.setValue(AbstractC2181a.a.f807a);
        return Unit.INSTANCE;
    }
}
