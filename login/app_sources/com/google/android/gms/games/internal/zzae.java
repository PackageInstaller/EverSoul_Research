package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzae extends zza {
    final /* synthetic */ zzak zza;
    private final TaskCompletionSource zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzae(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzakVar;
        this.zzb = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zze(DataHolder dataHolder) {
        zzj(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzj(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode == 10003) {
            zzak.zzq(this.zza, this.zzb);
            dataHolder.close();
            return;
        }
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zzb.setResult(new AnnotatedData(new PlayerBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zza(this.zzb, statusCode);
            dataHolder.close();
        }
    }
}
