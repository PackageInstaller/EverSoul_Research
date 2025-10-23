package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    private final int zzb;
    private final String zzc;
    private final PendingIntent zzd;
    private final ConnectionResult zze;
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    public static final Status RESULT_SUCCESS = new Status(0);
    public static final Status RESULT_INTERRUPTED = new Status(14);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status RESULT_CANCELED = new Status(16);
    public static final Status zza = new Status(17);
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status(int i) {
        this(i, (String) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Status(int i, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && Objects.equal(this.zzc, status.zzc) && Objects.equal(this.zzd, status.zzd) && Objects.equal(this.zze, status.zze);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConnectionResult getConnectionResult() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingIntent getResolution() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getStatusMessage() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasResolution() {
        return this.zzd != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCanceled() {
        return this.zzb == 16;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isInterrupted() {
        return this.zzb == 14;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckReturnValue
    public boolean isSuccess() {
        return this.zzb <= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            Preconditions.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.zzd);
        return stringHelper.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        String str = this.zzc;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status(int i, String str) {
        this(i, str, (PendingIntent) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i) {
        this(i, str, connectionResult.getResolution(), connectionResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status(int i, String str, PendingIntent pendingIntent) {
        this(i, str, pendingIntent, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startResolutionForResult(ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            Preconditions.checkNotNull(pendingIntent);
            activityResultLauncher.launch(new IntentSenderRequest.Builder(pendingIntent.getIntentSender()).build());
        }
    }
}
