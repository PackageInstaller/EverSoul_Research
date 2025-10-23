package com.google.android.gms.internal.play_billing;

import kotlin.UByte$$ExternalSyntheticBackport0;
import sun.misc.Unsafe;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzea {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!UByte$$ExternalSyntheticBackport0.m853m(unsafe, obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
