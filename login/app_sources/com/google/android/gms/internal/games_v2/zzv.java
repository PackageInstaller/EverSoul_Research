package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
final class zzv extends zzm {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzv(zzw zzwVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzm, com.google.android.gms.internal.games_v2.zzad
    public final void zzb(Status status, zzaa zzaaVar) {
        if (zzaaVar == null) {
            this.zza.setException(new ApiException(status));
        } else {
            this.zza.setResult(zzaaVar);
        }
    }
}
