package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzcs extends zzcy {
    private final AtomicReference<Bundle> zza = new AtomicReference<>();
    private boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza(long j) {
        Bundle bundle;
        synchronized (this.zza) {
            if (!this.zzb) {
                try {
                    this.zza.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = this.zza.get();
        }
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long zzb(long j) {
        return (Long) zza(zza(j), Long.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        r3 = r3.get(com.singular.sdk.internal.Constants.REVENUE_AMOUNT_KEY);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T zza(android.os.Bundle r3, java.lang.Class<T> r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L32
            java.lang.String r1 = "r"
            java.lang.Object r3 = r3.get(r1)
            if (r3 == 0) goto L32
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> L10
            return r3
        L10:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r4
            r4 = 1
            r1[r4] = r3
            java.lang.String r3 = "Unexpected object type. Expected, Received: %s, %s"
            java.lang.String r3 = java.lang.String.format(r3, r1)
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L32:
            return r0
            fill-array 0x0034: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzcs.zza(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzc(long j) {
        return (String) zza(zza(j), String.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void zza(Bundle bundle) {
        synchronized (this.zza) {
            try {
                this.zza.set(bundle);
                this.zzb = true;
            } finally {
                this.zza.notify();
            }
        }
    }
}
