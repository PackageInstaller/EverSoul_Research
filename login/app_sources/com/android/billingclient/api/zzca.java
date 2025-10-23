package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzca implements ServiceConnection {
    final /* synthetic */ zzcc zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzca(zzcc zzccVar, zzcb zzcbVar) {
        this.zza = zzccVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zze.zzk("BillingClientTesting", y.ٲٴݴ״ٰ(1781588312));
        this.zza.zzc = com.google.android.gms.internal.play_billing.zzau.zzc(iBinder);
        this.zza.zzb = 2;
        this.zza.zzaT(26);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zze.zzl("BillingClientTesting", y.֬ڱܱײٮ(-1159355831));
        this.zza.zzc = null;
        this.zza.zzb = 0;
    }
}
