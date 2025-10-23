package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzaj implements zzaq {
    private final zzaq zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return (this.zzb.hashCode() * 31) + this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        throw new IllegalStateException("Control does not have functions");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzaj(this.zzb, this.zza.zzc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        throw new IllegalStateException("Control is not a boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        throw new IllegalStateException("Control is not a double");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        throw new IllegalStateException("Control is not a String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzb() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaj() {
        this.zza = zzc;
        this.zzb = "return";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaj(String str) {
        this.zza = zzc;
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaj(String str, zzaq zzaqVar) {
        this.zza = zzaqVar;
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        return this.zzb.equals(zzajVar.zzb) && this.zza.equals(zzajVar.zza);
    }
}
