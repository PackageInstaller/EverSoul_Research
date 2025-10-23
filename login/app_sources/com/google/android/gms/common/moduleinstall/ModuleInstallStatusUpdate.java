package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();
    private final int zaa;
    private final int zab;
    private final Long zac;
    private final Long zad;
    private final int zae;
    private final ProgressInfo zaf;

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    public static class ProgressInfo {
        private final long zaa;
        private final long zab;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ProgressInfo(long j, long j2) {
            Preconditions.checkNotZero(j2);
            this.zaa = j;
            this.zab = j2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getBytesDownloaded() {
            return this.zaa;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getTotalBytesToDownload() {
            return this.zab;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ModuleInstallStatusUpdate(int i, int i2, Long l, Long l2, int i3) {
        this.zaa = i;
        this.zab = i2;
        this.zac = l;
        this.zad = l2;
        this.zae = i3;
        this.zaf = (l == null || l2 == null || l2.longValue() == 0) ? null : new ProgressInfo(l.longValue(), l2.longValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getErrorCode() {
        return this.zae;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInstallState() {
        return this.zab;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProgressInfo getProgressInfo() {
        return this.zaf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSessionId() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeInt(parcel, 2, getInstallState());
        SafeParcelWriter.writeLongObject(parcel, 3, this.zac, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zad, false);
        SafeParcelWriter.writeInt(parcel, 5, getErrorCode());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
