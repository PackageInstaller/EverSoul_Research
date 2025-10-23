package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class zzbx implements DriveFolder.DriveFileResult {
    private final Status zzdy;
    private final DriveFile zzfi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbx(Status status, DriveFile driveFile) {
        this.zzdy = status;
        this.zzfi = driveFile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveFolder.DriveFileResult
    public final DriveFile getDriveFile() {
        return this.zzfi;
    }
}
