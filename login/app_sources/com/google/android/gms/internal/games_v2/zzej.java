package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzej implements zzaq {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ SnapshotMetadataChange zzc;
    public final /* synthetic */ SnapshotContents zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ zzej(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = snapshotMetadataChange;
        this.zzd = snapshotContents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzaq
    public final Task zza(GoogleApi googleApi) {
        final String str = this.zza;
        final String str2 = this.zzb;
        final SnapshotMetadataChange snapshotMetadataChange = this.zzc;
        final SnapshotContents snapshotContents = this.zzd;
        return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzer
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((com.google.android.gms.games.internal.zzak) obj).zzN((TaskCompletionSource) obj2, str, str2, snapshotMetadataChange, snapshotContents);
            }
        }).setMethodKey(6725).build());
    }
}
