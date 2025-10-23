package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
final class zzj implements zzq {
    private final Executor zza;
    private final Object zzb = new Object();

    @Nullable
    private OnCompleteListener zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzj(Executor executor, OnCompleteListener onCompleteListener) {
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        synchronized (this.zzb) {
            if (this.zzc == null) {
                return;
            }
            this.zza.execute(new zzi(this, task));
        }
    }
}
