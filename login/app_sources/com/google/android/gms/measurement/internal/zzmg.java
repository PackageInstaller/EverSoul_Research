package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzpt;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmg {
    final /* synthetic */ zzly zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmg(zzly zzlyVar) {
        this.zza = zzlyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        this.zza.zzt();
        if (this.zza.zzk().zza(this.zza.zzb().currentTimeMillis())) {
            this.zza.zzk().zzg.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.zza.zzj().zzp().zza("Detected application was in foreground");
                zzb(this.zza.zzb().currentTimeMillis(), false);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(long j, boolean z) {
        this.zza.zzt();
        this.zza.zzab();
        if (this.zza.zzk().zza(j)) {
            this.zza.zzk().zzg.zza(true);
            if (zzpt.zza() && this.zza.zze().zza(zzbg.zzbq)) {
                this.zza.zzg().zzag();
            }
        }
        this.zza.zzk().zzk.zza(j);
        if (this.zza.zzk().zzg.zza()) {
            zzb(j, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb(long j, boolean z) {
        this.zza.zzt();
        if (this.zza.zzu.zzac()) {
            this.zza.zzk().zzk.zza(j);
            this.zza.zzj().zzp().zza("Session started, time", Long.valueOf(this.zza.zzb().elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", valueOf, j);
            this.zza.zzk().zzl.zza(valueOf.longValue());
            this.zza.zzk().zzg.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_s", j, bundle);
            String zza = this.zza.zzk().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            this.zza.zzm().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ssr", j, bundle2);
        }
    }
}
