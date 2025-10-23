package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzgv {
    private final Object zza;
    private final int zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgv(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgv)) {
            return false;
        }
        zzgv zzgvVar = (zzgv) obj;
        return this.zza == zzgvVar.zza && this.zzb == zzgvVar.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
