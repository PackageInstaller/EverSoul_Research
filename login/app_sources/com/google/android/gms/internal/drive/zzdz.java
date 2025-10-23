package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;

/* loaded from: classes2.dex */
final class zzdz implements DriveResource.MetadataResult {
    private final Status zzdy;
    private final Metadata zzgr;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzdz(Status status, Metadata metadata) {
        this.zzdy = status;
        this.zzgr = metadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzdy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveResource.MetadataResult
    public final Metadata getMetadata() {
        return this.zzgr;
    }
}
