package com.kakao.sdk.friend.p024m;

import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p026o.C2232g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.j */
/* loaded from: classes3.dex */
public final class C2207j extends Lambda implements Function1<AbstractC2169b.a, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2206i f893a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2207j(C2206i c2206i) {
        super(1);
        this.f893a = c2206i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AbstractC2169b.a aVar) {
        AbstractC2169b.a user = aVar;
        Intrinsics.checkNotNullParameter(user, "it");
        C2206i c2206i = this.f893a;
        int i = C2206i.f879j;
        C2232g m586e = c2206i.m586e();
        m586e.getClass();
        Intrinsics.checkNotNullParameter(user, "user");
        if (m586e.f965g.size() >= m586e.f962d.getMaxPickableCount()) {
            m586e.f974p.setValue(new AbstractC2181a.b(m586e.f962d.getMaxPickableCount()));
        } else {
            if (m586e.f966h && m586e.f965g.size() > 0) {
                AbstractC2169b.a aVar2 = m586e.f965g.get(0);
                m586e.f965g.clear();
                m586e.m671a(aVar2);
            }
            m586e.f965g.add(0, user);
            m586e.f972n.setValue(Integer.valueOf(m586e.f965g.size()));
            m586e.m674b(user, true);
            m586e.m676d();
            boolean z = !m586e.f969k && m586e.f970l && m586e.f965g.size() == 1;
            if (z) {
                m586e.f964f.add(0, AbstractC2170c.a.f790a);
                m586e.f975q++;
            }
            m586e.f973o.setValue(m586e.m668a(user, z));
        }
        return Unit.INSTANCE;
    }
}
