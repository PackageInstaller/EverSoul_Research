package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzph;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzq extends BroadcastReceiver {
    private final zzhd zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzq(zzhd zzhdVar) {
        this.zza = zzhdVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzj().zzu().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzj().zzu().zza("App receiver called with null action");
            return;
        }
        action.hashCode();
        if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzhd zzhdVar = this.zza;
            if (zzph.zza() && zzhdVar.zzf().zzf(null, zzbg.zzcf)) {
                zzhdVar.zzj().zzp().zza("App receiver notified triggers are available");
                zzhdVar.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzs
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzhd zzhdVar2 = zzhd.this;
                        if (!zzhdVar2.zzt().zzw()) {
                            zzhdVar2.zzj().zzu().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        final zzio zzp = zzhdVar2.zzp();
                        Objects.requireNonNull(zzp);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzp
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzio.this.zzal();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzj().zzu().zza("App receiver called with unknown action");
    }
}
