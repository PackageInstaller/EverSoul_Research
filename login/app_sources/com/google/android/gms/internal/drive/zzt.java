package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

@Deprecated
/* loaded from: classes2.dex */
public final class zzt {
    private String zzba;
    private DriveId zzbd;
    private Integer zzdk;
    private final int zzdl = 0;
    private MetadataChangeSet zzdm;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzt(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(MetadataChangeSet metadataChangeSet) {
        this.zzdm = (MetadataChangeSet) Preconditions.checkNotNull(metadataChangeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MetadataChangeSet zzc() {
        return this.zzdm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(DriveId driveId) {
        this.zzbd = (DriveId) Preconditions.checkNotNull(driveId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DriveId zzd() {
        return this.zzbd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(String str) {
        this.zzba = (String) Preconditions.checkNotNull(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zze() {
        return this.zzba;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(int i) {
        this.zzdk = Integer.valueOf(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRequestId() {
        return this.zzdk.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzg() {
        Preconditions.checkNotNull(this.zzdm, "Must provide initial metadata via setInitialMetadata.");
        Integer num = this.zzdk;
        this.zzdk = Integer.valueOf(num == null ? 0 : num.intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IntentSender build(GoogleApiClient googleApiClient) {
        Preconditions.checkState(googleApiClient.isConnected(), "Client must be connected");
        zzg();
        zzaw zzawVar = (zzaw) googleApiClient.getClient(Drive.CLIENT_KEY);
        this.zzdm.zzq().zza(zzawVar.getContext());
        try {
            return ((zzeo) zzawVar.getService()).zza(new zzu(this.zzdm.zzq(), this.zzdk.intValue(), this.zzba, this.zzbd, 0));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
