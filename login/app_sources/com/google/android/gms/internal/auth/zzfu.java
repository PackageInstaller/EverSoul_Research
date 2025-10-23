package com.google.android.gms.internal.auth;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfu<T> implements zzgb<T> {
    private final zzfq zza;
    private final zzgp<?, ?> zzb;
    private final zzeh<?> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfu(zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfq zzfqVar) {
        this.zzb = zzgpVar;
        zzehVar.zzc(zzfqVar);
        this.zzc = zzehVar;
        this.zza = zzfqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> zzfu<T> zzb(zzgp<?, ?> zzgpVar, zzeh<?> zzehVar, zzfq zzfqVar) {
        return new zzfu<>(zzgpVar, zzehVar, zzfqVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final int zza(T t) {
        return this.zzb.zza(t).hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final T zzd() {
        return (T) ((zzeo) ((zzeq) this.zza).zzj(5, null, null)).zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zze(T t) {
        this.zzb.zze(t);
        this.zzc.zzb(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzf(T t, T t2) {
        zzgd.zzf(this.zzb, t, t2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final void zzg(T t, byte[] bArr, int i, int i2, zzdp zzdpVar) throws IOException {
        zzeq zzeqVar = (zzeq) t;
        if (zzeqVar.zzc == zzgq.zza()) {
            zzeqVar.zzc = zzgq.zzc();
        }
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzh(T t, T t2) {
        return this.zzb.zza(t).equals(this.zzb.zza(t2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzgb
    public final boolean zzi(T t) {
        this.zzc.zza(t);
        throw null;
    }
}
