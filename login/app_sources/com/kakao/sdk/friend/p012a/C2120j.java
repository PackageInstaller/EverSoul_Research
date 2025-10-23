package com.kakao.sdk.friend.p012a;

import com.kakao.sdk.friend.p015d.C2138b;
import com.kakao.sdk.friend.p015d.InterfaceC2137a;
import com.kakao.sdk.friend.p021j.C2178a;
import com.kakao.sdk.friend.p021j.InterfaceC2179b;
import com.kakao.sdk.friend.p021j.InterfaceC2180c;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.a.j */
/* loaded from: classes3.dex */
public final class C2120j {

    /* renamed from: a */
    public static final C2120j f620a = new C2120j();

    /* renamed from: b */
    public static volatile InterfaceC2137a f621b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final InterfaceC2137a m477a() {
        Object create = C2178a.m531b().create(InterfaceC2179b.class);
        Intrinsics.checkNotNullExpressionValue(create, "kapiWithOAuthNoLog.create(FriendApi::class.java)");
        Object create2 = C2178a.m530a().create(InterfaceC2180c.class);
        Intrinsics.checkNotNullExpressionValue(create2, "kapiNoLog.create(UserScopeApi::class.java)");
        f621b = new C2138b((InterfaceC2179b) create, (InterfaceC2180c) create2);
        InterfaceC2137a interfaceC2137a = f621b;
        Intrinsics.checkNotNull(interfaceC2137a);
        return interfaceC2137a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final InterfaceC2137a m478b() {
        InterfaceC2137a interfaceC2137a;
        synchronized (this) {
            C2120j c2120j = f620a;
            interfaceC2137a = f621b;
            if (interfaceC2137a == null) {
                interfaceC2137a = c2120j.m477a();
            }
        }
        return interfaceC2137a;
    }
}
