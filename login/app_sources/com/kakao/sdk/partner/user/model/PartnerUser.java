package com.kakao.sdk.partner.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.user.Constants;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PartnerUser.kt */
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jz\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020.HÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020.HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00069"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/PartnerUser;", "Landroid/os/Parcelable;", "id", "", Constants.PROPERTIES, "", "", "kakaoAccount", "Lcom/kakao/sdk/partner/user/model/PartnerAccount;", "groupUserToken", "hasSignedUp", "", "forPartner", "Lcom/kakao/sdk/partner/user/model/ForPartner;", "connectedAt", "Ljava/util/Date;", "synchedAt", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/partner/user/model/PartnerAccount;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/partner/user/model/ForPartner;Ljava/util/Date;Ljava/util/Date;)V", "getConnectedAt", "()Ljava/util/Date;", "getForPartner", "()Lcom/kakao/sdk/partner/user/model/ForPartner;", "getGroupUserToken", "()Ljava/lang/String;", "getHasSignedUp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKakaoAccount", "()Lcom/kakao/sdk/partner/user/model/PartnerAccount;", "getProperties", "()Ljava/util/Map;", "getSynchedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/partner/user/model/PartnerAccount;Ljava/lang/String;Ljava/lang/Boolean;Lcom/kakao/sdk/partner/user/model/ForPartner;Ljava/util/Date;Ljava/util/Date;)Lcom/kakao/sdk/partner/user/model/PartnerUser;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerUser implements Parcelable {
    public static final Parcelable.Creator<PartnerUser> CREATOR = new Creator();
    private final Date connectedAt;
    private final ForPartner forPartner;
    private final String groupUserToken;
    private final Boolean hasSignedUp;
    private final Long id;
    private final PartnerAccount kakaoAccount;
    private final Map<String, String> properties;
    private final Date synchedAt;

    /* compiled from: PartnerUser.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PartnerUser> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerUser createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            return new PartnerUser(valueOf, linkedHashMap, parcel.readInt() == 0 ? null : PartnerAccount.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() != 0 ? ForPartner.CREATOR.createFromParcel(parcel) : null, (Date) parcel.readSerializable(), (Date) parcel.readSerializable());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerUser[] newArray(int i) {
            return new PartnerUser[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> component2() {
        return this.properties;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerAccount component3() {
        return this.kakaoAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.groupUserToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component5() {
        return this.hasSignedUp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ForPartner component6() {
        return this.forPartner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component7() {
        return this.connectedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component8() {
        return this.synchedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerUser copy(Long id, Map<String, String> properties, PartnerAccount kakaoAccount, String groupUserToken, Boolean hasSignedUp, ForPartner forPartner, Date connectedAt, Date synchedAt) {
        return new PartnerUser(id, properties, kakaoAccount, groupUserToken, hasSignedUp, forPartner, connectedAt, synchedAt);
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
        if (!(other instanceof PartnerUser)) {
            return false;
        }
        PartnerUser partnerUser = (PartnerUser) other;
        return Intrinsics.areEqual(this.id, partnerUser.id) && Intrinsics.areEqual(this.properties, partnerUser.properties) && Intrinsics.areEqual(this.kakaoAccount, partnerUser.kakaoAccount) && Intrinsics.areEqual(this.groupUserToken, partnerUser.groupUserToken) && Intrinsics.areEqual(this.hasSignedUp, partnerUser.hasSignedUp) && Intrinsics.areEqual(this.forPartner, partnerUser.forPartner) && Intrinsics.areEqual(this.connectedAt, partnerUser.connectedAt) && Intrinsics.areEqual(this.synchedAt, partnerUser.synchedAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Map<String, String> map = this.properties;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        PartnerAccount partnerAccount = this.kakaoAccount;
        int hashCode3 = (hashCode2 + (partnerAccount == null ? 0 : partnerAccount.hashCode())) * 31;
        String str = this.groupUserToken;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.hasSignedUp;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        ForPartner forPartner = this.forPartner;
        int hashCode6 = (hashCode5 + (forPartner == null ? 0 : forPartner.hashCode())) * 31;
        Date date = this.connectedAt;
        int hashCode7 = (hashCode6 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.synchedAt;
        return hashCode7 + (date2 != null ? date2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PartnerUser(id=" + this.id + ", properties=" + this.properties + ", kakaoAccount=" + this.kakaoAccount + ", groupUserToken=" + ((Object) this.groupUserToken) + ", hasSignedUp=" + this.hasSignedUp + ", forPartner=" + this.forPartner + ", connectedAt=" + this.connectedAt + ", synchedAt=" + this.synchedAt + ')';
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
        Map<String, String> map = this.properties;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                parcel.writeString(entry.getKey());
                parcel.writeString(entry.getValue());
            }
        }
        PartnerAccount partnerAccount = this.kakaoAccount;
        if (partnerAccount == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            partnerAccount.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.groupUserToken);
        Boolean bool = this.hasSignedUp;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        ForPartner forPartner = this.forPartner;
        if (forPartner == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            forPartner.writeToParcel(parcel, flags);
        }
        parcel.writeSerializable(this.connectedAt);
        parcel.writeSerializable(this.synchedAt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerUser(Long l, Map<String, String> map, PartnerAccount partnerAccount, String str, Boolean bool, ForPartner forPartner, Date date, Date date2) {
        this.id = l;
        this.properties = map;
        this.kakaoAccount = partnerAccount;
        this.groupUserToken = str;
        this.hasSignedUp = bool;
        this.forPartner = forPartner;
        this.connectedAt = date;
        this.synchedAt = date2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getProperties() {
        return this.properties;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerAccount getKakaoAccount() {
        return this.kakaoAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getGroupUserToken() {
        return this.groupUserToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getHasSignedUp() {
        return this.hasSignedUp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ForPartner getForPartner() {
        return this.forPartner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getConnectedAt() {
        return this.connectedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getSynchedAt() {
        return this.synchedAt;
    }
}
