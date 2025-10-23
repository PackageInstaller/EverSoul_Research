package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class zzbp implements DriveFile.DownloadProgressListener {
    private final ListenerHolder<DriveFile.DownloadProgressListener> zzfa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbp(ListenerHolder<DriveFile.DownloadProgressListener> listenerHolder) {
        this.zzfa = listenerHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
    public final void onProgress(long j, long j2) {
        this.zzfa.notifyListener(new zzbq(this, j, j2));
    }
}
