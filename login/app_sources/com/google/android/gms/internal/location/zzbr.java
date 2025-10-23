package com.google.android.gms.internal.location;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzbr extends zzbs {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzbs zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbr(zzbs zzbsVar, int i, int i2) {
        this.zzc = zzbsVar;
        this.zza = i;
        this.zzb = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public final Object get(int i) {
        zzbm.zza(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbs, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbp
    final Object[] zzb() {
        return this.zzc.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbp
    final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbp
    final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbp
    final boolean zzf() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzbs
    /* renamed from: zzh */
    public final zzbs subList(int i, int i2) {
        zzbm.zzc(i, i2, this.zzb);
        zzbs zzbsVar = this.zzc;
        int i3 = this.zza;
        return zzbsVar.subList(i + i3, i2 + i3);
    }
}
