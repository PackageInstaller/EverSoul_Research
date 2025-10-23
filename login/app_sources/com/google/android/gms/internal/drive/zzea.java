package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;

/* loaded from: classes2.dex */
abstract class zzea extends zzau<DriveResource.MetadataResult> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzea(zzdp zzdpVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzdz(status, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzea(zzdp zzdpVar, GoogleApiClient googleApiClient, zzdq zzdqVar) {
        this(zzdpVar, googleApiClient);
    }
}
