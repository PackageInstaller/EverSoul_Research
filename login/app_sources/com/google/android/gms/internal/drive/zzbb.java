package com.google.android.gms.internal.drive;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveClient;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public final class zzbb extends DriveClient {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbb(Context context, Drive.zza zzaVar) {
        super(context, zzaVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbb(Activity activity, Drive.zza zzaVar) {
        super(activity, zzaVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<DriveId> getDriveId(String str) {
        Preconditions.checkNotNull(str, "resourceId must not be null");
        return doRead(new zzbc(this, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<IntentSender> newOpenFileActivityIntentSender(OpenFileActivityOptions openFileActivityOptions) {
        return doRead(new zzbf(this, openFileActivityOptions));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<IntentSender> newCreateFileActivityIntentSender(CreateFileActivityOptions createFileActivityOptions) {
        return doRead(new zzbg(this, createFileActivityOptions));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<Void> requestSync() {
        return doWrite(new zzbh(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<TransferPreferences> getUploadPreferences() {
        return doRead(new zzbd(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.DriveClient
    public final Task<Void> setUploadPreferences(TransferPreferences transferPreferences) {
        Preconditions.checkNotNull(transferPreferences, "transferPreferences cannot be null.");
        return doWrite(new zzbe(this, transferPreferences));
    }
}
