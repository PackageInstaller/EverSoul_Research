package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public interface SnapshotsClient {
    public static final int DISPLAY_LIMIT_NONE = -1;
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class DataOrConflict<T> {
        private final Object zza;
        private final SnapshotConflict zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DataOrConflict(Object obj, SnapshotConflict snapshotConflict) {
            this.zza = obj;
            this.zzb = snapshotConflict;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.zzb;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public T getData() {
            if (isConflict()) {
                throw new IllegalStateException("getData called when there is a conflict.");
            }
            return (T) this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isConflict() {
            return this.zzb != null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionPolicy {
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class SnapshotConflict {
        private final Snapshot zza;
        private final String zzb;
        private final Snapshot zzc;
        private final SnapshotContents zzd;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnapshotConflict(Snapshot snapshot, String str, Snapshot snapshot2, SnapshotContents snapshotContents) {
            this.zza = snapshot;
            this.zzb = str;
            this.zzc = snapshot2;
            this.zzd = snapshotContents;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getConflictId() {
            return this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Snapshot getConflictingSnapshot() {
            return this.zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Snapshot getSnapshot() {
            return this.zza;
        }
    }

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class SnapshotContentUnavailableApiException extends ApiException {
        protected final SnapshotMetadata metadata;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnapshotContentUnavailableApiException(Status status, SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    Task<SnapshotMetadata> commitAndClose(Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange);

    Task<String> delete(SnapshotMetadata snapshotMetadata);

    Task<Void> discardAndClose(Snapshot snapshot);

    Task<Integer> getMaxCoverImageSize();

    Task<Integer> getMaxDataSize();

    Task<Intent> getSelectSnapshotIntent(String str, boolean z, boolean z2, int i);

    Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z);

    Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata);

    Task<DataOrConflict<Snapshot>> open(SnapshotMetadata snapshotMetadata, int i);

    Task<DataOrConflict<Snapshot>> open(String str, boolean z);

    Task<DataOrConflict<Snapshot>> open(String str, boolean z, int i);

    Task<DataOrConflict<Snapshot>> resolveConflict(String str, Snapshot snapshot);

    Task<DataOrConflict<Snapshot>> resolveConflict(String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents);
}
