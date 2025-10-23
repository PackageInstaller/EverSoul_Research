package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
public class TaskCompletionSource<TResult> {
    private final zzw zza = new zzw();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TaskCompletionSource() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<TResult> getTask() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setException(Exception exc) {
        this.zza.zza(exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResult(TResult tresult) {
        this.zza.zzb(tresult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean trySetException(Exception exc) {
        return this.zza.zzd(exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean trySetResult(TResult tresult) {
        return this.zza.zze(tresult);
    }
}
