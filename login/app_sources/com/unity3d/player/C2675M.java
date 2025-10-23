package com.unity3d.player;

import java.lang.reflect.Member;

/* renamed from: com.unity3d.player.M */
/* loaded from: classes3.dex */
final class C2675M {

    /* renamed from: a */
    private final Class f1193a;

    /* renamed from: b */
    private final String f1194b;

    /* renamed from: c */
    private final String f1195c;

    /* renamed from: d */
    private final int f1196d;

    /* renamed from: e */
    public volatile Member f1197e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2675M(Class cls, String str, String str2) {
        this.f1193a = cls;
        this.f1194b = str;
        this.f1195c = str2;
        this.f1196d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + 527) * 31)) * 31);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2675M)) {
            return false;
        }
        C2675M c2675m = (C2675M) obj;
        return this.f1196d == c2675m.f1196d && this.f1195c.equals(c2675m.f1195c) && this.f1194b.equals(c2675m.f1194b) && this.f1193a.equals(c2675m.f1193a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.f1196d;
    }
}
