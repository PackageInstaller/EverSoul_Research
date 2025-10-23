package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgj implements ServiceConnection {
    final /* synthetic */ zzgk zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgj(zzgk zzgkVar, String str) {
        this.zza = zzgkVar;
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.zza.zza.zzj().zzu().zza("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzby zza = com.google.android.gms.internal.measurement.zzcb.zza(iBinder);
            if (zza == null) {
                this.zza.zza.zzj().zzu().zza("Install Referrer Service implementation was not found");
            } else {
                this.zza.zza.zzj().zzp().zza("Install Referrer Service connected");
                this.zza.zza.zzl().zzb(new zzgm(this, zza, this));
            }
        } catch (RuntimeException e) {
            this.zza.zza.zzj().zzu().zza("Exception occurred while calling Install Referrer API", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzj().zzp().zza("Install Referrer Service disconnected");
    }
}
