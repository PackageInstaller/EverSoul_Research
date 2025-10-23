package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgl {
    private final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzgl(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.zza = zzaVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Context context, Intent intent) {
        zzfp zzj = zzhd.zza(context, null, null).zzj();
        if (intent == null) {
            zzj.zzu().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzj.zzp().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzj.zzp().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzj.zzu().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
