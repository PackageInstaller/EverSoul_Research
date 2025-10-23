package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzoj;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzme {
    protected long zza;
    final /* synthetic */ zzly zzb;
    private long zzc;
    private final zzat zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final long zza(long j) {
        long j2 = j - this.zza;
        this.zza = j;
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzme zzmeVar) {
        zzmeVar.zzb.zzt();
        zzmeVar.zza(false, false, zzmeVar.zzb.zzb().elapsedRealtime());
        zzmeVar.zzb.zzc().zza(zzmeVar.zzb.zzb().elapsedRealtime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzme(zzly zzlyVar) {
        this.zzb = zzlyVar;
        this.zzd = new zzmd(this, zzlyVar.zzu);
        long elapsedRealtime = zzlyVar.zzb().elapsedRealtime();
        this.zzc = elapsedRealtime;
        this.zza = elapsedRealtime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        this.zzd.zza();
        this.zzc = 0L;
        this.zza = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(long j) {
        this.zzd.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzc(long j) {
        this.zzb.zzt();
        this.zzd.zza();
        this.zzc = j;
        this.zza = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzb.zzt();
        this.zzb.zzu();
        if (!zzoj.zza() || !this.zzb.zze().zza(zzbg.zzbl) || this.zzb.zzu.zzac()) {
            this.zzb.zzk().zzk.zza(this.zzb.zzb().currentTimeMillis());
        }
        long j2 = j - this.zzc;
        if (!z && j2 < 1000) {
            this.zzb.zzj().zzp().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (!z2) {
            j2 = zza(j);
        }
        this.zzb.zzj().zzp().zza("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        zzng.zza(this.zzb.zzn().zza(!this.zzb.zze().zzv()), bundle, true);
        if (!z2) {
            this.zzb.zzm().zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
        }
        this.zzc = j;
        this.zzd.zza();
        this.zzd.zza(DateUtils.MILLIS_PER_HOUR);
        return true;
    }
}
