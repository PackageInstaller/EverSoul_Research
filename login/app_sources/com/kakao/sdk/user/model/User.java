package com.kakao.sdk.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.user.Constants;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: User.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020)HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020)HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u00064"}, m839d2 = {"Lcom/kakao/sdk/user/model/User;", "Landroid/os/Parcelable;", "id", "", Constants.PROPERTIES, "", "", "kakaoAccount", "Lcom/kakao/sdk/user/model/Account;", "groupUserToken", "connectedAt", "Ljava/util/Date;", "synchedAt", "hasSignedUp", "", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/user/model/Account;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;)V", "getConnectedAt", "()Ljava/util/Date;", "getGroupUserToken", "()Ljava/lang/String;", "getHasSignedUp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKakaoAccount", "()Lcom/kakao/sdk/user/model/Account;", "getProperties", "()Ljava/util/Map;", "getSynchedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/util/Map;Lcom/kakao/sdk/user/model/Account;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/kakao/sdk/user/model/User;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Creator();
    private final Date connectedAt;
    private final String groupUserToken;
    private final Boolean hasSignedUp;
    private final Long id;
    private final Account kakaoAccount;
    private final Map<String, String> properties;
    private final Date synchedAt;

    /* compiled from: User.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<User> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final User createFromParcel(Parcel parcel) {
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
            return new User(valueOf, linkedHashMap, parcel.readInt() == 0 ? null : Account.CREATOR.createFromParcel(parcel), parcel.readString(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), parcel.readInt() != 0 ? Boolean.valueOf(parcel.readInt() != 0) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final User[] newArray(int i) {
            return new User[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ User copy$default(User user, Long l, Map map, Account account, String str, Date date, Date date2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            l = user.id;
        }
        if ((i & 2) != 0) {
            map = user.properties;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            account = user.kakaoAccount;
        }
        Account account2 = account;
        if ((i & 8) != 0) {
            str = user.groupUserToken;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            date = user.connectedAt;
        }
        Date date3 = date;
        if ((i & 32) != 0) {
            date2 = user.synchedAt;
        }
        Date date4 = date2;
        if ((i & 64) != 0) {
            bool = user.hasSignedUp;
        }
        return user.copy(l, map2, account2, str2, date3, date4, bool);
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
    public final Account component3() {
        return this.kakaoAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.groupUserToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component5() {
        return this.connectedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component6() {
        return this.synchedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component7() {
        return this.hasSignedUp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final User copy(Long id, Map<String, String> properties, Account kakaoAccount, String groupUserToken, Date connectedAt, Date synchedAt, Boolean hasSignedUp) {
        return new User(id, properties, kakaoAccount, groupUserToken, connectedAt, synchedAt, hasSignedUp);
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
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.properties, user.properties) && Intrinsics.areEqual(this.kakaoAccount, user.kakaoAccount) && Intrinsics.areEqual(this.groupUserToken, user.groupUserToken) && Intrinsics.areEqual(this.connectedAt, user.connectedAt) && Intrinsics.areEqual(this.synchedAt, user.synchedAt) && Intrinsics.areEqual(this.hasSignedUp, user.hasSignedUp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.id;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Map<String, String> map = this.properties;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Account account = this.kakaoAccount;
        int hashCode3 = (hashCode2 + (account == null ? 0 : account.hashCode())) * 31;
        String str = this.groupUserToken;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.connectedAt;
        int hashCode5 = (hashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.synchedAt;
        int hashCode6 = (hashCode5 + (date2 == null ? 0 : date2.hashCode())) * 31;
        Boolean bool = this.hasSignedUp;
        return hashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "User(id=" + this.id + ", properties=" + this.properties + ", kakaoAccount=" + this.kakaoAccount + ", groupUserToken=" + ((Object) this.groupUserToken) + ", connectedAt=" + this.connectedAt + ", synchedAt=" + this.synchedAt + ", hasSignedUp=" + this.hasSignedUp + ')';
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
        Account account = this.kakaoAccount;
        if (account == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            account.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.groupUserToken);
        parcel.writeSerializable(this.connectedAt);
        parcel.writeSerializable(this.synchedAt);
        Boolean bool = this.hasSignedUp;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public User(Long l, Map<String, String> map, Account account, String str, Date date, Date date2, Boolean bool) {
        this.id = l;
        this.properties = map;
        this.kakaoAccount = account;
        this.groupUserToken = str;
        this.connectedAt = date;
        this.synchedAt = date2;
        this.hasSignedUp = bool;
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
    public final Account getKakaoAccount() {
        return this.kakaoAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getGroupUserToken() {
        return this.groupUserToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getConnectedAt() {
        return this.connectedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getSynchedAt() {
        return this.synchedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getHasSignedUp() {
        return this.hasSignedUp;
    }
}
