package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
final class zzbk {
    private final TaskCompletionSource zza;
    private final zzap zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbk(zzap zzapVar, TaskCompletionSource taskCompletionSource, byte[] bArr) {
        this.zzb = zzapVar;
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(GoogleApi googleApi) {
        this.zzb.zza(googleApi).addOnCompleteListener(zzfe.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.games_v2.zzbj
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                zzbk.this.zzb(task);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zzb(Task task) {
        if (task.isSuccessful()) {
            this.zza.setResult(task.getResult());
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zza;
        Exception exception = task.getException();
        zzfb.zza(exception);
        taskCompletionSource.setException(exception);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(Exception exc) {
        this.zza.setException(exc);
    }
}
