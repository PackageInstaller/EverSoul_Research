package com.kakao.sdk.friend.p026o;

import com.kakao.sdk.friend.internal.InternalFriendsParams;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.o.a */
/* loaded from: classes3.dex */
public final class C2226a extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2227b f937a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2226a(C2227b c2227b) {
        super(1);
        this.f937a = c2227b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        if (th != null) {
            this.f937a.f952o.setValue(AbstractC2181a.a.f807a);
        } else {
            C2227b c2227b = this.f937a;
            c2227b.getClass();
            if (C2171d.f794j == null) {
                C2171d.f794j = new C2171d();
            }
            C2171d c2171d = C2171d.f794j;
            Intrinsics.checkNotNull(c2171d);
            c2171d.f800f = new InternalFriendsParams(null, null, null, null, null, null, null, c2227b.f949l, false, false, false, c2227b.f940c.getDisableSelectOptions(), c2227b.f940c.getDisplayAllProfile(), false, c2227b.f940c.getMaxPickableCount(), c2227b.f940c.getMinPickableCount(), 8319, null);
            this.f937a.f951n.setValue(AbstractC2182b.d.f814a);
        }
        return Unit.INSTANCE;
    }
}
