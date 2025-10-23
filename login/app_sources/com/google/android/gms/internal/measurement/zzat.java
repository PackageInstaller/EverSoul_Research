package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzat implements zzaq {
    private final String zza;
    private final ArrayList<zzaq> zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        String str = this.zza;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<zzaq> arrayList = this.zzb;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ArrayList<zzaq> zzb() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzat(String str, List<zzaq> list) {
        this.zza = str;
        ArrayList<zzaq> arrayList = new ArrayList<>();
        this.zzb = arrayList;
        arrayList.addAll(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        String str = this.zza;
        if (str == null ? zzatVar.zza != null : !str.equals(zzatVar.zza)) {
            return false;
        }
        ArrayList<zzaq> arrayList = this.zzb;
        ArrayList<zzaq> arrayList2 = zzatVar.zzb;
        return arrayList != null ? arrayList.equals(arrayList2) : arrayList2 == null;
    }
}
