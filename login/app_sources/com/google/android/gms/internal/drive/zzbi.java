package com.google.android.gms.internal.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class zzbi implements DriveContents {
    private static final GmsLogger zzbz = new GmsLogger("DriveContentsImpl", "");
    private final Contents zzes;
    private boolean closed = false;
    private boolean zzet = false;
    private boolean zzeu = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbi(Contents contents) {
        this.zzes = (Contents) Preconditions.checkNotNull(contents);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final DriveId getDriveId() {
        return this.zzes.getDriveId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final int getMode() {
        return this.zzes.getMode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        if (this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        return this.zzes.getParcelFileDescriptor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final InputStream getInputStream() {
        if (this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (this.zzes.getMode() != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (this.zzet) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        }
        this.zzet = true;
        return this.zzes.getInputStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final OutputStream getOutputStream() {
        if (this.closed) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (this.zzes.getMode() != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (this.zzeu) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        }
        this.zzeu = true;
        return this.zzes.getOutputStream();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (this.zzes.getMode() != 268435456) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        }
        zzj();
        return googleApiClient.enqueue(new zzbj(this, googleApiClient));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : com.google.android.gms.drive.zzn.zza(executionOptions));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final PendingResult<Status> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, com.google.android.gms.drive.zzn zznVar) {
        if (zznVar == null) {
            zznVar = (com.google.android.gms.drive.zzn) new com.google.android.gms.drive.zzp().build();
        }
        if (this.zzes.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        }
        if (ExecutionOptions.zza(zznVar.zzn()) && !this.zzes.zzb()) {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        zznVar.zza(googleApiClient);
        if (this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (getDriveId() == null) {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
        }
        if (metadataChangeSet == null) {
            metadataChangeSet = MetadataChangeSet.zzax;
        }
        zzj();
        return googleApiClient.execute(new zzbk(this, googleApiClient, metadataChangeSet, zznVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final void discard(GoogleApiClient googleApiClient) {
        if (this.closed) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzj();
        ((zzbm) googleApiClient.execute(new zzbm(this, googleApiClient))).setResultCallback(new zzbl(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final Contents zzi() {
        return this.zzes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final void zzj() {
        IOUtils.closeQuietly(this.zzes.getParcelFileDescriptor());
        this.closed = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveContents
    public final boolean zzk() {
        return this.closed;
    }
}
