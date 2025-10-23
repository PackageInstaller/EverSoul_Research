package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzpn;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmc implements Runnable {
    long zza;
    long zzb;
    final /* synthetic */ zzlz zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmc(zzlz zzlzVar, long j, long j2) {
        this.zzc = zzlzVar;
        this.zza = j;
        this.zzb = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzmc zzmcVar = zzmc.this;
                zzlz zzlzVar = zzmcVar.zzc;
                long j = zzmcVar.zza;
                long j2 = zzmcVar.zzb;
                zzlzVar.zza.zzt();
                zzlzVar.zza.zzj().zzc().zza("Application going to the background");
                zzlzVar.zza.zzk().zzn.zza(true);
                zzlzVar.zza.zza(true);
                if (!zzlzVar.zza.zze().zzv()) {
                    zzlzVar.zza.zzb.zzb(j2);
                    zzlzVar.zza.zza(false, false, j2);
                }
                if (zzpn.zza() && zzlzVar.zza.zze().zza(zzbg.zzcd)) {
                    zzlzVar.zza.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j));
                } else {
                    zzlzVar.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, new Bundle());
                }
            }
        });
    }
}
