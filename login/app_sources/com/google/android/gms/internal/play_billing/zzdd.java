package com.google.android.gms.internal.play_billing;

import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzdd {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object zza(@CheckForNull Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object[] zzb(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            zza(objArr[i2], i2);
        }
        return objArr;
    }
}
