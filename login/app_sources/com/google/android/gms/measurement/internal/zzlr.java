package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzlv;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzlr<T extends Context & zzlv> {
    private final T zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza(final Intent intent, int i, final int i2) {
        final zzfp zzj = zzhd.zza(this.zza, null, null).zzj();
        if (intent == null) {
            zzj.zzu().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzj.zzp().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlt
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    zzlr.this.zza(i2, zzj, intent);
                }
            });
        }
        return 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzhh(zzmp.zza(this.zza));
        }
        zzc().zzu().zza("onBind received unknown action", action);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzfp zzc() {
        return zzhd.zza(this.zza, null, null).zzj();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzlr(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(int i, zzfp zzfpVar, Intent intent) {
        if (this.zza.zza(i)) {
            zzfpVar.zzp().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzp().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(zzfp zzfpVar, JobParameters jobParameters) {
        zzfpVar.zzp().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza() {
        zzhd.zza(this.zza, null, null).zzj().zzp().zza("Local AppMeasurementService is starting up");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb() {
        zzhd.zza(this.zza, null, null).zzj().zzp().zza("Local AppMeasurementService is shutting down");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onRebind called with null intent");
        } else {
            zzc().zzp().zza("onRebind called. action", intent.getAction());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(Runnable runnable) {
        zzmp zza = zzmp.zza(this.zza);
        zza.zzl().zzb(new zzlw(this, zza, runnable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(final JobParameters jobParameters) {
        final zzfp zzj = zzhd.zza(this.zza, null, null).zzj();
        String string = jobParameters.getExtras().getString("action");
        zzj.zzp().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzlu
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzlr.this.zza(zzj, jobParameters);
            }
        });
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc(Intent intent) {
        if (intent == null) {
            zzc().zzg().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzp().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
