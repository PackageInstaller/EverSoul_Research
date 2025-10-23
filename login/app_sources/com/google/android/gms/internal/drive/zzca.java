package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
abstract class zzca extends zzau<DriveFolder.DriveFolderResult> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzca(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzbz(status, null);
    }
}
