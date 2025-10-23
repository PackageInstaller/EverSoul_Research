package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;

/* loaded from: classes2.dex */
final class zzal implements Releasable, DriveApi.DriveContentsResult {
    private final Status zzdy;
    private final DriveContents zzo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzal(Status status, DriveContents driveContents) {
        this.zzdy = status;
        this.zzo = driveContents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveApi.DriveContentsResult
    public final DriveContents getDriveContents() {
        return this.zzo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        DriveContents driveContents = this.zzo;
        if (driveContents != null) {
            driveContents.zzj();
        }
    }
}
