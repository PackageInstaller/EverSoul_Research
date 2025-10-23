package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

/* loaded from: classes2.dex */
final class zzcf implements DrivePreferencesApi.FileUploadPreferencesResult {
    private final Status zzdy;
    private final FileUploadPreferences zzfm;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzcf(zzcb zzcbVar, Status status, FileUploadPreferences fileUploadPreferences) {
        this.zzdy = status;
        this.zzfm = fileUploadPreferences;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
    public final FileUploadPreferences getFileUploadPreferences() {
        return this.zzfm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzcf(zzcb zzcbVar, Status status, FileUploadPreferences fileUploadPreferences, zzcc zzccVar) {
        this(zzcbVar, status, fileUploadPreferences);
    }
}
