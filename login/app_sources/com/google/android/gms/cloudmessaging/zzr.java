package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
abstract class zzr {
    final int zza;
    final TaskCompletionSource zzb = new TaskCompletionSource();
    final int zzc;
    final Bundle zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzr(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "Request { what=" + this.zzc + " id=" + this.zza + " oneWay=" + zzb() + "}";
    }

    abstract void zza(Bundle bundle);

    abstract boolean zzb();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzc(zzs zzsVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + zzsVar.toString());
        }
        this.zzb.setException(zzsVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzd(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(obj));
        }
        this.zzb.setResult(obj);
    }
}
