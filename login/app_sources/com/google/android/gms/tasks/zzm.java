package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
final class zzm implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzn zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzm(zzn zznVar, Task task) {
        this.zzb = zznVar;
        this.zza = task;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.zzb.zzb;
        synchronized (obj) {
            zzn zznVar = this.zzb;
            onSuccessListener = zznVar.zzc;
            if (onSuccessListener != null) {
                onSuccessListener2 = zznVar.zzc;
                onSuccessListener2.onSuccess(this.zza.getResult());
            }
        }
    }
}
