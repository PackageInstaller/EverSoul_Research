package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public final class zzbn extends zzdp implements DriveFile {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbn(DriveId driveId) {
        super(driveId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveFile
    public final PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient googleApiClient, int i, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (i != 268435456 && i != 536870912 && i != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        }
        return googleApiClient.enqueue(new zzbo(this, googleApiClient, i, downloadProgressListener == null ? null : new zzbp(googleApiClient.registerListener(downloadProgressListener))));
    }
}
