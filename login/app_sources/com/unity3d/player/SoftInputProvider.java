package com.unity3d.player;

import com.unity3d.player.p030a.AbstractC2704a;
import com.unity3d.player.p030a.AbstractC2707d;

/* loaded from: classes3.dex */
abstract class SoftInputProvider {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static int m755a() {
        int nativeGetSoftInputType = nativeGetSoftInputType();
        for (int i : AbstractC2704a.m774b(3)) {
            if (AbstractC2707d.m775a(i) == nativeGetSoftInputType) {
                return i;
            }
        }
        return 1;
    }

    private static final native int nativeGetSoftInputType();
}
