package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzey implements SnapshotsClient {
    private final zzar zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzey(zzar zzarVar) {
        this.zza = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotMetadata> commitAndClose(final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzeh
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final Snapshot snapshot2 = Snapshot.this;
                final SnapshotMetadataChange snapshotMetadataChange2 = snapshotMetadataChange;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzep
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzt((TaskCompletionSource) obj2, Snapshot.this, snapshotMetadataChange2);
                    }
                }).setMethodKey(6722).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<String> delete(final SnapshotMetadata snapshotMetadata) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzei
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final SnapshotMetadata snapshotMetadata2 = SnapshotMetadata.this;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeq
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzu((TaskCompletionSource) obj2, SnapshotMetadata.this.getSnapshotId());
                    }
                }).setMethodKey(6724).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Void> discardAndClose(final Snapshot snapshot) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzex
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final Snapshot snapshot2 = Snapshot.this;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeg
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        SnapshotContents snapshotContents = Snapshot.this.getSnapshotContents();
                        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
                        Contents zza = snapshotContents.zza();
                        snapshotContents.zzb();
                        ((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzt(zza);
                        ((TaskCompletionSource) obj2).setResult(null);
                    }
                }).setMethodKey(6723).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxCoverImageSize() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzen
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzev
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzd()));
                    }
                }).setMethodKey(6718).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxDataSize() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzeo
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzew
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zze()));
                    }
                }).setMethodKey(6717).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Intent> getSelectSnapshotIntent(final String str, final boolean z, final boolean z2, final int i) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzel
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z3 = z;
                final boolean z4 = z2;
                final int i2 = i;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzet
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzm(str2, z3, z4, i2));
                    }
                }).setMethodKey(6719).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<AnnotatedData<SnapshotMetadataBuffer>> load(final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzem
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeu
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzJ((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6720).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        SnapshotMetadataChange build = builder.build();
        return this.zza.zzb(new zzej(str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i) {
        return open(snapshotMetadata.getUniqueName(), false, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(String str, boolean z) {
        return open(str, z, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(final String str, final boolean z, final int i) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzek
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z2 = z;
                final int i2 = i;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzes
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzL((TaskCompletionSource) obj2, str2, z2, i2);
                    }
                }).setMethodKey(6721).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        return this.zza.zzb(new zzej(str, str2, snapshotMetadataChange, snapshotContents));
    }
}
