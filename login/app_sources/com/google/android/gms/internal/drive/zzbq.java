package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
final class zzbq implements ListenerHolder.Notifier<DriveFile.DownloadProgressListener> {
    private final /* synthetic */ long zzfb;
    private final /* synthetic */ long zzfc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbq(zzbp zzbpVar, long j, long j2) {
        this.zzfb = j;
        this.zzfc = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(DriveFile.DownloadProgressListener downloadProgressListener) {
        downloadProgressListener.onProgress(this.zzfb, this.zzfc);
    }
}
