package com.kakao.sdk.friend.p024m;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.l */
/* loaded from: classes3.dex */
public final class C2209l extends Lambda implements Function0<Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2206i f895a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2209l(C2206i c2206i) {
        super(0);
        this.f895a = c2206i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if ((r5 == null || r5.isEmpty()) != false) goto L17;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlin.Unit invoke() {
        /*
            r8 = this;
            com.kakao.sdk.friend.m.i r0 = r8.f895a
            int r1 = com.kakao.sdk.friend.p024m.C2206i.f879j
            com.kakao.sdk.friend.o.g r0 = r0.m586e()
            java.util.List r1 = r0.m673b()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L15:
            boolean r3 = r1.hasNext()
            r4 = 1
            if (r3 == 0) goto L40
            java.lang.Object r3 = r1.next()
            r5 = r3
            com.kakao.sdk.friend.i.b$a r5 = (com.kakao.sdk.friend.p020i.AbstractC2169b.a) r5
            boolean r6 = r5.f787g
            r7 = 0
            if (r6 != 0) goto L39
            java.util.List<com.kakao.sdk.friend.model.DisableSelectOption> r5 = r5.f785e
            if (r5 == 0) goto L35
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L33
            goto L35
        L33:
            r5 = r7
            goto L36
        L35:
            r5 = r4
        L36:
            if (r5 == 0) goto L39
            goto L3a
        L39:
            r4 = r7
        L3a:
            if (r4 == 0) goto L15
            r2.add(r3)
            goto L15
        L40:
            java.util.Iterator r1 = r2.iterator()
        L44:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            com.kakao.sdk.friend.i.b$a r3 = (com.kakao.sdk.friend.p020i.AbstractC2169b.a) r3
            java.util.List<com.kakao.sdk.friend.i.b$a> r5 = r0.f965g
            r5.add(r3)
            r3.f787g = r4
            goto L44
        L58:
            r0.m676d()
            androidx.lifecycle.MutableLiveData<java.lang.Integer> r1 = r0.f972n
            java.util.List<com.kakao.sdk.friend.i.b$a> r3 = r0.f965g
            int r3 = r3.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.setValue(r3)
            com.kakao.sdk.friend.l.l<com.kakao.sdk.friend.k.b> r1 = r0.f973o
            com.kakao.sdk.friend.k.b$f r3 = new com.kakao.sdk.friend.k.b$f
            r3.<init>(r2)
            r1.setValue(r3)
            java.util.List<com.kakao.sdk.friend.i.b$a> r1 = r0.f965g
            int r1 = r1.size()
            com.kakao.sdk.friend.internal.InternalFriendsParams r2 = r0.f962d
            int r2 = r2.getMaxPickableCount()
            if (r1 < r2) goto L92
            androidx.lifecycle.MutableLiveData<com.kakao.sdk.friend.k.a> r1 = r0.f974p
            com.kakao.sdk.friend.k.a$b r2 = new com.kakao.sdk.friend.k.a$b
            com.kakao.sdk.friend.internal.InternalFriendsParams r0 = r0.f962d
            int r0 = r0.getMaxPickableCount()
            r2.<init>(r0)
            r1.setValue(r2)
        L92:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
            fill-array 0x0096: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.p024m.C2209l.invoke():java.lang.Object");
    }
}
