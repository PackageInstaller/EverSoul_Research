package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;

/* loaded from: classes2.dex */
abstract class zzcg extends zzau<DrivePreferencesApi.FileUploadPreferencesResult> {
    private final /* synthetic */ zzcb zzfk;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcg(zzcb zzcbVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzfk = zzcbVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected /* synthetic */ Result createFailedResult(Status status) {
        return new zzcf(this.zzfk, status, null, 0 == true ? 1 : 0);
    }
}
