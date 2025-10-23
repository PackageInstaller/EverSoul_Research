package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class zzjz extends zzjy<Object> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjz() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final boolean zze(zzlq zzlqVar) {
        return zzlqVar instanceof zzkk.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final zzkb<Object> zzb(Object obj) {
        return ((zzkk.zzc) obj).zzrw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final zzkb<Object> zzc(Object obj) {
        return ((zzkk.zzc) obj).zzdg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final void zzd(Object obj) {
        zzb(obj).zzbp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final void zza(zzns zznsVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjy
    final Object zza(zzjx zzjxVar, zzlq zzlqVar, int i) {
        return zzjxVar.zza(zzlqVar, i);
    }
}
