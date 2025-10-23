package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

@Deprecated
/* loaded from: classes2.dex */
public final class zzcb implements DrivePreferencesApi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public final PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new zzcc(this, googleApiClient));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public final PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (!(fileUploadPreferences instanceof zzei)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        return googleApiClient.execute(new zzcd(this, googleApiClient, (zzei) fileUploadPreferences));
    }
}
