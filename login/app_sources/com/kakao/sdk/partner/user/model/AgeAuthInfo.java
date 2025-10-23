package com.kakao.sdk.partner.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AgeAuthInfo.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jb\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\u0007HÖ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u000eHÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001e¨\u00064"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/AgeAuthInfo;", "Landroid/os/Parcelable;", "id", "", "authLevel", "Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;", "authLevelCode", "", "bypassAgeLimit", "", "authenticatedAt", "Ljava/util/Date;", "ciNeedsAgreement", "ci", "", "(Ljava/lang/Long;Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAuthLevel", "()Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;", "getAuthLevelCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAuthenticatedAt", "()Ljava/util/Date;", "getBypassAgeLimit", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCi", "()Ljava/lang/String;", "getCiNeedsAgreement", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/kakao/sdk/partner/user/model/AgeAuthInfo;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgeAuthInfo implements Parcelable {
    public static final Parcelable.Creator<AgeAuthInfo> CREATOR = new Creator();
    private final AgeAuthLevel authLevel;
    private final Integer authLevelCode;
    private final Date authenticatedAt;
    private final Boolean bypassAgeLimit;
    private final String ci;
    private final Boolean ciNeedsAgreement;
    private final Long id;

    /* compiled from: AgeAuthInfo.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<AgeAuthInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AgeAuthInfo createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            AgeAuthLevel valueOf4 = parcel.readInt() == 0 ? null : AgeAuthLevel.valueOf(parcel.readString());
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Date date = (Date) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new AgeAuthInfo(valueOf3, valueOf4, valueOf5, valueOf, date, valueOf2, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final AgeAuthInfo[] newArray(int i) {
            return new AgeAuthInfo[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ AgeAuthInfo copy$default(AgeAuthInfo ageAuthInfo, Long l, AgeAuthLevel ageAuthLevel, Integer num, Boolean bool, Date date, Boolean bool2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = ageAuthInfo.id;
        }
        if ((i & 2) != 0) {
            ageAuthLevel = ageAuthInfo.authLevel;
        }
        AgeAuthLevel ageAuthLevel2 = ageAuthLevel;
        if ((i & 4) != 0) {
            num = ageAuthInfo.authLevelCode;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            bool = ageAuthInfo.bypassAgeLimit;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            date = ageAuthInfo.authenticatedAt;
        }
        Date date2 = date;
        if ((i & 32) != 0) {
            bool2 = ageAuthInfo.ciNeedsAgreement;
        }
        Boolean bool4 = bool2;
        if ((i & 64) != 0) {
            str = ageAuthInfo.ci;
        }
        return ageAuthInfo.copy(l, ageAuthLevel2, num2, bool3, date2, bool4, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthLevel component2() {
        return this.authLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component3() {
        return this.authLevelCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component4() {
        return this.bypassAgeLimit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component5() {
        return this.authenticatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component6() {
        return this.ciNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component7() {
        return this.ci;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthInfo copy(Long id, AgeAuthLevel authLevel, Integer authLevelCode, Boolean bypassAgeLimit, Date authenticatedAt, Boolean ciNeedsAgreement, String ci) {
        return new AgeAuthInfo(id, authLevel, authLevelCode, bypassAgeLimit, authenticatedAt, ciNeedsAgreement, ci);
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
        if (!(other instanceof AgeAuthInfo)) {
            return false;
        }
        AgeAuthInfo ageAuthInfo = (AgeAuthInfo) other;
        return Intrinsics.areEqual(this.id, ageAuthInfo.id) && this.authLevel == ageAuthInfo.authLevel && Intrinsics.areEqual(this.authLevelCode, ageAuthInfo.authLevelCode) && Intrinsics.areEqual(this.bypassAgeLimit, ageAuthInfo.bypassAgeLimit) && Intrinsics.areEqual(this.authenticatedAt, ageAuthInfo.authenticatedAt) && Intrinsics.areEqual(this.ciNeedsAgreement, ageAuthInfo.ciNeedsAgreement) && Intrinsics.areEqual(this.ci, ageAuthInfo.ci);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        AgeAuthLevel ageAuthLevel = this.authLevel;
        int hashCode2 = (hashCode + (ageAuthLevel == null ? 0 : ageAuthLevel.hashCode())) * 31;
        Integer num = this.authLevelCode;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.bypassAgeLimit;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Date date = this.authenticatedAt;
        int hashCode5 = (hashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Boolean bool2 = this.ciNeedsAgreement;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.ci;
        return hashCode6 + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "AgeAuthInfo(id=" + this.id + ", authLevel=" + this.authLevel + ", authLevelCode=" + this.authLevelCode + ", bypassAgeLimit=" + this.bypassAgeLimit + ", authenticatedAt=" + this.authenticatedAt + ", ciNeedsAgreement=" + this.ciNeedsAgreement + ", ci=" + ((Object) this.ci) + ')';
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
        AgeAuthLevel ageAuthLevel = this.authLevel;
        if (ageAuthLevel == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(ageAuthLevel.name());
        }
        Integer num = this.authLevelCode;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.bypassAgeLimit;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeSerializable(this.authenticatedAt);
        Boolean bool2 = this.ciNeedsAgreement;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.ci);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AgeAuthInfo(Long l, AgeAuthLevel ageAuthLevel, Integer num, Boolean bool, Date date, Boolean bool2, String str) {
        this.id = l;
        this.authLevel = ageAuthLevel;
        this.authLevelCode = num;
        this.bypassAgeLimit = bool;
        this.authenticatedAt = date;
        this.ciNeedsAgreement = bool2;
        this.ci = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AgeAuthLevel getAuthLevel() {
        return this.authLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getAuthLevelCode() {
        return this.authLevelCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getBypassAgeLimit() {
        return this.bypassAgeLimit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getAuthenticatedAt() {
        return this.authenticatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getCiNeedsAgreement() {
        return this.ciNeedsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCi() {
        return this.ci;
    }
}
