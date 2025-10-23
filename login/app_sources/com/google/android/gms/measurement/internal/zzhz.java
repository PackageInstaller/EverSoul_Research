package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzph;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhz implements Callable<List<zzmh>> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzhh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzmh> call() throws Exception {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzc.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzc.zza;
        zzo zzoVar = this.zza;
        Bundle bundle = this.zzb;
        zzmpVar2.zzl().zzt();
        if (!zzph.zza() || !zzmpVar2.zze().zze(zzoVar.zza, zzbg.zzce) || zzoVar.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzmpVar2.zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzal zzf = zzmpVar2.zzf();
                        String str = zzoVar.zza;
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzf.zzt();
                        zzf.zzak();
                        try {
                            zzf.zzj().zzp().zza("Pruned " + zzf.m176e_().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)}) + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzfp.zza(str), e);
                        }
                    }
                }
            }
        }
        return zzmpVar2.zzf().zzh(zzoVar.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhz(zzhh zzhhVar, zzo zzoVar, Bundle bundle) {
        this.zza = zzoVar;
        this.zzb = bundle;
        this.zzc = zzhhVar;
    }
}
