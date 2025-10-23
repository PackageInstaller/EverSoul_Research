package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmt implements Callable<String> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzmp zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        if (!this.zzb.zzb((String) Preconditions.checkNotNull(this.zza.zza)).zzh() || !zzif.zza(this.zza.zzt).zzh()) {
            this.zzb.zzj().zzp().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        zzg zza = this.zzb.zza(this.zza);
        if (zza != null) {
            return zza.zzy();
        }
        this.zzb.zzj().zzu().zza("App info was null when attempting to get app instance id");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmt(zzmp zzmpVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzmpVar;
    }
}
