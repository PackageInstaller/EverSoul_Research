package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public class zzjv {
    private static final zzis zza = zzis.zza;
    private zzhu zzb;
    private volatile zzkr zzc;
    private volatile zzhu zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzbw();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhu zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                return this.zzd;
            }
            if (this.zzc == null) {
                this.zzd = zzhu.zza;
            } else {
                this.zzd = this.zzc.zzbu();
            }
            return this.zzd;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzkr zzb(zzkr zzkrVar) {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    try {
                        this.zzc = zzkrVar;
                        this.zzd = zzhu.zza;
                    } catch (zzjq unused) {
                        this.zzc = zzkrVar;
                        this.zzd = zzhu.zza;
                    }
                }
            }
        }
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzkr zza(zzkr zzkrVar) {
        zzkr zzkrVar2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzkrVar;
        return zzkrVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjv)) {
            return false;
        }
        zzjv zzjvVar = (zzjv) obj;
        zzkr zzkrVar = this.zzc;
        zzkr zzkrVar2 = zzjvVar.zzc;
        if (zzkrVar == null && zzkrVar2 == null) {
            return zzc().equals(zzjvVar.zzc());
        }
        if (zzkrVar != null && zzkrVar2 != null) {
            return zzkrVar.equals(zzkrVar2);
        }
        if (zzkrVar != null) {
            return zzkrVar.equals(zzjvVar.zzb(zzkrVar.zzcf()));
        }
        return zzb(zzkrVar2.zzcf()).equals(zzkrVar2);
    }
}
