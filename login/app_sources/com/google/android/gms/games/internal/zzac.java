package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzac extends zza {
    private final TaskCompletionSource zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzac(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzr(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 0 || z) {
            this.zza.setResult(new AnnotatedData(new SnapshotMetadataBuffer(dataHolder), z));
        } else {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
        }
    }
}
