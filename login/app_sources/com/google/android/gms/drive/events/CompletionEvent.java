package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzev;
import com.google.android.gms.internal.drive.zzhs;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CompletionEvent extends AbstractSafeParcelable implements ResourceEvent {
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    private final int status;
    private final String zzca;
    private final ParcelFileDescriptor zzcb;
    private final ParcelFileDescriptor zzcc;
    private final MetadataBundle zzcd;
    private final List<String> zzce;
    private final IBinder zzcf;
    private boolean zzcg = false;
    private boolean zzch = false;
    private boolean zzci = false;
    private final DriveId zzk;
    private static final GmsLogger zzbz = new GmsLogger("CompletionEvent", "");
    public static final Parcelable.Creator<CompletionEvent> CREATOR = new zzg();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CompletionEvent(DriveId driveId, String str, ParcelFileDescriptor parcelFileDescriptor, ParcelFileDescriptor parcelFileDescriptor2, MetadataBundle metadataBundle, List<String> list, int i, IBinder iBinder) {
        this.zzk = driveId;
        this.zzca = str;
        this.zzcb = parcelFileDescriptor;
        this.zzcc = parcelFileDescriptor2;
        this.zzcd = metadataBundle;
        this.zzce = list;
        this.status = i;
        this.zzcf = iBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzca, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcb, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcc, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzcd, i2, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzce, false);
        SafeParcelWriter.writeInt(parcel, 8, this.status);
        SafeParcelWriter.writeIBinder(parcel, 9, this.zzcf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.ResourceEvent
    public final DriveId getDriveId() {
        zzv();
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAccountName() {
        zzv();
        return this.zzca;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InputStream getBaseContentsInputStream() {
        zzv();
        if (this.zzcb == null) {
            return null;
        }
        if (this.zzcg) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzcg = true;
        return new FileInputStream(this.zzcb.getFileDescriptor());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InputStream getModifiedContentsInputStream() {
        zzv();
        if (this.zzcc == null) {
            return null;
        }
        if (this.zzch) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzch = true;
        return new FileInputStream(this.zzcc.getFileDescriptor());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MetadataChangeSet getModifiedMetadataChangeSet() {
        zzv();
        if (this.zzcd != null) {
            return new MetadataChangeSet(this.zzcd);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getTrackingTags() {
        zzv();
        return new ArrayList(this.zzce);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getStatus() {
        zzv();
        return this.status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void dismiss() {
        zza(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void snooze() {
        zza(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(boolean z) {
        zzv();
        this.zzci = true;
        IOUtils.closeQuietly(this.zzcb);
        IOUtils.closeQuietly(this.zzcc);
        MetadataBundle metadataBundle = this.zzcd;
        if (metadataBundle != null && metadataBundle.zzd(zzhs.zzkq)) {
            ((BitmapTeleporter) this.zzcd.zza(zzhs.zzkq)).release();
        }
        IBinder iBinder = this.zzcf;
        if (iBinder == null) {
            zzbz.efmt("CompletionEvent", "No callback on %s", z ? "snooze" : "dismiss");
            return;
        }
        try {
            zzev.zza(iBinder).zza(z);
        } catch (RemoteException e) {
            zzbz.m146e("CompletionEvent", String.format("RemoteException on %s", z ? "snooze" : "dismiss"), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzv() {
        if (this.zzci) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String sb;
        List<String> list = this.zzce;
        if (list == null) {
            sb = "<null>";
        } else {
            String join = TextUtils.join("','", list);
            sb = new StringBuilder(String.valueOf(join).length() + 2).append("'").append(join).append("'").toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", this.zzk, Integer.valueOf(this.status), sb);
    }
}
