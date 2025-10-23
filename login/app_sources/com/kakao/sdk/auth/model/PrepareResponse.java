package com.kakao.sdk.auth.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrepareResponse.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/auth/model/PrepareResponse;", "Landroid/os/Parcelable;", "kauthTxId", "", "(Ljava/lang/String;)V", "getKauthTxId", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PrepareResponse implements Parcelable {
    public static final Parcelable.Creator<PrepareResponse> CREATOR = new Creator();
    private final String kauthTxId;

    /* compiled from: PrepareResponse.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PrepareResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PrepareResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PrepareResponse(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PrepareResponse[] newArray(int i) {
            return new PrepareResponse[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ PrepareResponse copy$default(PrepareResponse prepareResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = prepareResponse.kauthTxId;
        }
        return prepareResponse.copy(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component1() {
        return this.kauthTxId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PrepareResponse copy(String kauthTxId) {
        Intrinsics.checkNotNullParameter(kauthTxId, "kauthTxId");
        return new PrepareResponse(kauthTxId);
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
        return (other instanceof PrepareResponse) && Intrinsics.areEqual(this.kauthTxId, ((PrepareResponse) other).kauthTxId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.kauthTxId.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PrepareResponse(kauthTxId=" + this.kauthTxId + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.kauthTxId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PrepareResponse(String kauthTxId) {
        Intrinsics.checkNotNullParameter(kauthTxId, "kauthTxId");
        this.kauthTxId = kauthTxId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKauthTxId() {
        return this.kauthTxId;
    }
}
