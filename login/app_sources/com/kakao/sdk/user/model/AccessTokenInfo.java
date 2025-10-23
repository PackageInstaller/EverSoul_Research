package com.kakao.sdk.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.user.Constants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessTokenInfo.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006&"}, m839d2 = {"Lcom/kakao/sdk/user/model/AccessTokenInfo;", "Landroid/os/Parcelable;", "id", "", "expiresIn", "appId", "", Constants.EXPIRESINMILLIS, "(Ljava/lang/Long;JILjava/lang/Long;)V", "getAppId", "()I", "getExpiresIn", "()J", "getExpiresInMillis$annotations", "()V", "getExpiresInMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;JILjava/lang/Long;)Lcom/kakao/sdk/user/model/AccessTokenInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AccessTokenInfo implements Parcelable {
    public static final Parcelable.Creator<AccessTokenInfo> CREATOR = new Creator();
    private final int appId;
    private final long expiresIn;

    @SerializedName(Constants.EXPIRESINMILLIS)
    private final Long expiresInMillis;
    private final Long id;

    /* compiled from: AccessTokenInfo.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<AccessTokenInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AccessTokenInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccessTokenInfo(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readLong(), parcel.readInt(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AccessTokenInfo[] newArray(int i) {
            return new AccessTokenInfo[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ AccessTokenInfo copy$default(AccessTokenInfo accessTokenInfo, Long l, long j, int i, Long l2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = accessTokenInfo.id;
        }
        if ((i2 & 2) != 0) {
            j = accessTokenInfo.expiresIn;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            i = accessTokenInfo.appId;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            l2 = accessTokenInfo.expiresInMillis;
        }
        return accessTokenInfo.copy(l, j2, i3, l2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "'초' 단위를 사용하는 'expiresIn' 속성으로 대체되었습니다.")
    public static /* synthetic */ void getExpiresInMillis$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component2() {
        return this.expiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component3() {
        return this.appId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component4() {
        return this.expiresInMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AccessTokenInfo copy(Long id, long expiresIn, int appId, Long expiresInMillis) {
        return new AccessTokenInfo(id, expiresIn, appId, expiresInMillis);
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
        if (!(other instanceof AccessTokenInfo)) {
            return false;
        }
        AccessTokenInfo accessTokenInfo = (AccessTokenInfo) other;
        return Intrinsics.areEqual(this.id, accessTokenInfo.id) && this.expiresIn == accessTokenInfo.expiresIn && this.appId == accessTokenInfo.appId && Intrinsics.areEqual(this.expiresInMillis, accessTokenInfo.expiresInMillis);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.id;
        int hashCode = (((((l == null ? 0 : l.hashCode()) * 31) + Long.hashCode(this.expiresIn)) * 31) + Integer.hashCode(this.appId)) * 31;
        Long l2 = this.expiresInMillis;
        return hashCode + (l2 != null ? l2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "AccessTokenInfo(id=" + this.id + ", expiresIn=" + this.expiresIn + ", appId=" + this.appId + ", expiresInMillis=" + this.expiresInMillis + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Long l = this.id;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeLong(this.expiresIn);
        parcel.writeInt(this.appId);
        Long l2 = this.expiresInMillis;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessTokenInfo(Long l, long j, int i, Long l2) {
        this.id = l;
        this.expiresIn = j;
        this.appId = i;
        this.expiresInMillis = l2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getExpiresIn() {
        return this.expiresIn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAppId() {
        return this.appId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getExpiresInMillis() {
        return this.expiresInMillis;
    }
}
