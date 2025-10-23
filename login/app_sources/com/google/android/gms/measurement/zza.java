package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzhd;
import com.google.android.gms.measurement.internal.zzij;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.measurement.internal.zzio;
import com.google.android.gms.measurement.internal.zznb;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zza extends AppMeasurement.zza {
    private final zzhd zza;
    private final zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final long zza() {
        return this.zza.zzt().zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Boolean zzb() {
        return this.zzb.zzaa();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Double zzc() {
        return this.zzb.zzab();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Integer zzd() {
        return this.zzb.zzac();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Long zze() {
        return this.zzb.zzad();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final Object zza(int i) {
        if (i == 0) {
            return zzj();
        }
        if (i == 1) {
            return zze();
        }
        if (i == 2) {
            return zzc();
        }
        if (i == 3) {
            return zzd();
        }
        if (i != 4) {
            return null;
        }
        return zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final String zzf() {
        return this.zzb.zzae();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final String zzg() {
        return this.zzb.zzaf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final String zzh() {
        return this.zzb.zzag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final String zzi() {
        return this.zzb.zzae();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final String zzj() {
        return this.zzb.zzai();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.AppMeasurement.zza
    public final Map<String, Object> zza(boolean z) {
        List<zznb> zza = this.zzb.zza(z);
        ArrayMap arrayMap = new ArrayMap(zza.size());
        for (zznb zznbVar : zza) {
            Object zza2 = zznbVar.zza();
            if (zza2 != null) {
                arrayMap.put(zznbVar.zza, zza2);
            }
        }
        return arrayMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza(zzhd zzhdVar) {
        super();
        Preconditions.checkNotNull(zzhdVar);
        this.zza = zzhdVar;
        this.zzb = zzhdVar.zzp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zzb(String str) {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzp().zza(str, str2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zzc(String str) {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zzb(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zzb.zza(str, str2, bundle, true, false, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(zzij zzijVar) {
        this.zzb.zza(zzijVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(Bundle bundle) {
        this.zzb.zzb(bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(zzik zzikVar) {
        this.zzb.zza(zzikVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zzb(zzij zzijVar) {
        this.zzb.zzb(zzijVar);
    }
}
