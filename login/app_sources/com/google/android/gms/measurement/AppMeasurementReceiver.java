package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzgl;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzgl.zza {
    private zzgl zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzgl.zza
    public final void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzgl(this);
        }
        this.zza.zza(context, intent);
    }
}
