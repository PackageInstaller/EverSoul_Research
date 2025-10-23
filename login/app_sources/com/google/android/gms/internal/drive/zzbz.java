package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class zzbz implements DriveFolder.DriveFolderResult {
    private final Status zzdy;
    private final DriveFolder zzfj;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbz(Status status, DriveFolder driveFolder) {
        this.zzdy = status;
        this.zzfj = driveFolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveFolder.DriveFolderResult
    public final DriveFolder getDriveFolder() {
        return this.zzfj;
    }
}
