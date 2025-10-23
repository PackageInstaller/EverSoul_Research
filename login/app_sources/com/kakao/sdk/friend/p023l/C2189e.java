package com.kakao.sdk.friend.p023l;

import java.util.Comparator;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.l.e */
/* loaded from: classes3.dex */
public final class C2189e implements Comparator<InterfaceC2192h> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final int m547a(String str, String str2) {
        if (str == null || StringsKt.isBlank(str)) {
            if (str2 == null || StringsKt.isBlank(str2)) {
                return 0;
            }
        }
        if (str == null || StringsKt.isBlank(str)) {
            return 1;
        }
        if (str2 == null || StringsKt.isBlank(str2)) {
            return -1;
        }
        char m552a = C2194j.m552a(str);
        char m552a2 = C2194j.m552a(str2);
        C2194j c2194j = C2194j.f850a;
        int m561e = c2194j.m561e(m552a) - c2194j.m561e(m552a2);
        return (m561e == 0 && (m561e = m552a - m552a2) == 0) ? str.compareTo(str2) : m561e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public int compare(InterfaceC2192h interfaceC2192h, InterfaceC2192h interfaceC2192h2) {
        InterfaceC2192h interfaceC2192h3 = interfaceC2192h;
        InterfaceC2192h interfaceC2192h4 = interfaceC2192h2;
        return m547a(interfaceC2192h3 == null ? null : interfaceC2192h3.m549a(), interfaceC2192h4 != null ? interfaceC2192h4.m549a() : null);
    }
}
