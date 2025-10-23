package com.kakao.sdk.partner.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgeAuthError.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/AgeAuthError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Landroid/os/Parcelable;", "reason", "Lcom/kakao/sdk/partner/user/model/AgeAuthErrorCause;", "msg", "", "(Lcom/kakao/sdk/partner/user/model/AgeAuthErrorCause;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getReason", "()Lcom/kakao/sdk/partner/user/model/AgeAuthErrorCause;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgeAuthError extends RuntimeException implements Parcelable {
    public static final Parcelable.Creator<AgeAuthError> CREATOR = new Creator();
    private final String msg;
    private final AgeAuthErrorCause reason;

    /* compiled from: AgeAuthError.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<AgeAuthError> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AgeAuthError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AgeAuthError(AgeAuthErrorCause.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AgeAuthError[] newArray(int i) {
            return new AgeAuthError[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ AgeAuthError copy$default(AgeAuthError ageAuthError, AgeAuthErrorCause ageAuthErrorCause, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            ageAuthErrorCause = ageAuthError.reason;
        }
        if ((i & 2) != 0) {
            str = ageAuthError.msg;
        }
        return ageAuthError.copy(ageAuthErrorCause, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthErrorCause component1() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.msg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthError copy(AgeAuthErrorCause reason, String msg) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(msg, "msg");
        return new AgeAuthError(reason, msg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgeAuthError)) {
            return false;
        }
        AgeAuthError ageAuthError = (AgeAuthError) other;
        return this.reason == ageAuthError.reason && Intrinsics.areEqual(this.msg, ageAuthError.msg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.reason.hashCode() * 31) + this.msg.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public String toString() {
        return "AgeAuthError(reason=" + this.reason + ", msg=" + this.msg + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.reason.name());
        parcel.writeString(this.msg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthErrorCause getReason() {
        return this.reason;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMsg() {
        return this.msg;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AgeAuthError(AgeAuthErrorCause reason, String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.reason = reason;
        this.msg = msg;
    }
}
