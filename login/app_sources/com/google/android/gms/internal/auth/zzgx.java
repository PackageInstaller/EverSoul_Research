package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzgx extends zzgy {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgx(Unsafe unsafe) {
        super(unsafe);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzj(obj, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzi(obj, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zzc(Object obj, long j, boolean z) {
        if (zzgz.zza) {
            zzgz.zzi(obj, j, z);
        } else {
            zzgz.zzj(obj, j, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zzd(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final void zze(Object obj, long j, float f) {
        zzm(obj, j, Float.floatToIntBits(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgy
    public final boolean zzf(Object obj, long j) {
        return zzgz.zza ? zzgz.zzq(obj, j) : zzgz.zzr(obj, j);
    }
}
