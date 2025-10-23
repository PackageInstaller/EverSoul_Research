package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
class zzao extends com.google.android.gms.internal.location.zzah {
    private final TaskCompletionSource<Void> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzao(TaskCompletionSource<Void> taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(com.google.android.gms.internal.location.zzaa zzaaVar) {
        TaskUtil.setResultOrApiException(zzaaVar.getStatus(), this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zzc() {
    }
}
