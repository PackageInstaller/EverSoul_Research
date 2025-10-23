package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.GmsLogger;

/* loaded from: classes2.dex */
final class zzbl implements ResultCallback<Status> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbl(zzbi zzbiVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* synthetic */ void onResult(Status status) {
        GmsLogger gmsLogger;
        Status status2 = status;
        if (status2.isSuccess()) {
            return;
        }
        gmsLogger = zzbi.zzbz;
        gmsLogger.efmt("DriveContentsImpl", "Error discarding contents, status: %s", status2);
    }
}
