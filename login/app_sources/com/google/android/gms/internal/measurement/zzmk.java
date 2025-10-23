package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmk extends zzmi<zzmh, zzmh> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ int zza(zzmh zzmhVar) {
        return zzmhVar.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final boolean zza(zzlk zzlkVar) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ int zzb(zzmh zzmhVar) {
        return zzmhVar.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ zzmh zzc(Object obj) {
        zzmh zzmhVar = ((zzjf) obj).zzb;
        if (zzmhVar != zzmh.zzc()) {
            return zzmhVar;
        }
        zzmh zzd = zzmh.zzd();
        zza(obj, zzd);
        return zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ zzmh zzd(Object obj) {
        return ((zzjf) obj).zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ zzmh zza(zzmh zzmhVar, zzmh zzmhVar2) {
        zzmh zzmhVar3 = zzmhVar;
        zzmh zzmhVar4 = zzmhVar2;
        if (zzmh.zzc().equals(zzmhVar4)) {
            return zzmhVar3;
        }
        if (zzmh.zzc().equals(zzmhVar3)) {
            return zzmh.zza(zzmhVar3, zzmhVar4);
        }
        return zzmhVar3.zza(zzmhVar4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ zzmh zza() {
        return zzmh.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ zzmh zze(zzmh zzmhVar) {
        zzmh zzmhVar2 = zzmhVar;
        zzmhVar2.zze();
        return zzmhVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmk() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zza(zzmh zzmhVar, int i, int i2) {
        zzmhVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zza(zzmh zzmhVar, int i, long j) {
        zzmhVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zza(zzmh zzmhVar, int i, zzmh zzmhVar2) {
        zzmhVar.zza((i << 3) | 3, zzmhVar2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zza(zzmh zzmhVar, int i, zzhu zzhuVar) {
        zzmhVar.zza((i << 3) | 2, zzhuVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zzb(zzmh zzmhVar, int i, long j) {
        zzmhVar.zza(i << 3, Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final void zzf(Object obj) {
        ((zzjf) obj).zzb.zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zzb(Object obj, zzmh zzmhVar) {
        zza(obj, zzmhVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(Object obj, zzmh zzmhVar) {
        ((zzjf) obj).zzb = zzmhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zzc(Object obj, zzmh zzmhVar) {
        zza(obj, zzmhVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zza(zzmh zzmhVar, zzne zzneVar) throws IOException {
        zzmhVar.zza(zzneVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzmi
    final /* synthetic */ void zzb(zzmh zzmhVar, zzne zzneVar) throws IOException {
        zzmhVar.zzb(zzneVar);
    }
}
