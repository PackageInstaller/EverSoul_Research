package com.google.android.gms.games.internal;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzl {
    public static final zzl zza = new zzl(new zzj(null));
    private final boolean zzb;
    private final boolean zzc;
    private final boolean zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzl(zzj zzjVar) {
        boolean z;
        boolean z2;
        boolean z3;
        z = zzjVar.zza;
        this.zzb = z;
        z2 = zzjVar.zzb;
        this.zzc = z2;
        z3 = zzjVar.zzc;
        this.zzd = z3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzj zza() {
        return new zzj(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzl zzlVar = (zzl) obj;
            if (this.zzb == zzlVar.zzb && this.zzc == zzlVar.zzc && this.zzd == zzlVar.zzd) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return ((((this.zzb ? 1 : 0) * 31) + (this.zzc ? 1 : 0)) * 31) + (this.zzd ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzd() {
        return this.zzc;
    }
}
