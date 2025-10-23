package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class zzao implements DriveApi.DriveIdResult {
    private final Status zzdy;
    private final DriveId zzk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzao(Status status, DriveId driveId) {
        this.zzdy = status;
        this.zzk = driveId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveApi.DriveIdResult
    public final DriveId getDriveId() {
        return this.zzk;
    }
}
