package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import com.kakaogame.idp.KGKakao2Auth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Friends.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J`\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#HÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006."}, m839d2 = {"Lcom/kakao/sdk/talk/model/Friend;", "Landroid/os/Parcelable;", "id", "", "uuid", "", "profileNickname", "profileThumbnailImage", Constants.FAVORITE, "", "allowedMsg", KGKakao2Auth.KEY_SERVICE_USER_ID, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getAllowedMsg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFavorite", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getProfileNickname", "()Ljava/lang/String;", "getProfileThumbnailImage", "getServiceUserId", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/kakao/sdk/talk/model/Friend;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Friend implements Parcelable {
    public static final Parcelable.Creator<Friend> CREATOR = new Creator();
    private final Boolean allowedMsg;
    private final Boolean favorite;
    private final Long id;
    private final String profileNickname;
    private final String profileThumbnailImage;
    private final Long serviceUserId;
    private final String uuid;

    /* compiled from: Friends.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Friend> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Friend createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Friend(valueOf3, readString, readString2, readString3, valueOf, valueOf2, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Friend[] newArray(int i) {
            return new Friend[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Friend copy$default(Friend friend, Long l, String str, String str2, String str3, Boolean bool, Boolean bool2, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = friend.id;
        }
        if ((i & 2) != 0) {
            str = friend.uuid;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = friend.profileNickname;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = friend.profileThumbnailImage;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            bool = friend.favorite;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            bool2 = friend.allowedMsg;
        }
        Boolean bool4 = bool2;
        if ((i & 64) != 0) {
            l2 = friend.serviceUserId;
        }
        return friend.copy(l, str4, str5, str6, bool3, bool4, l2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.profileNickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.profileThumbnailImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component5() {
        return this.favorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component6() {
        return this.allowedMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component7() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Friend copy(Long id, String uuid, String profileNickname, String profileThumbnailImage, Boolean favorite, Boolean allowedMsg, Long serviceUserId) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new Friend(id, uuid, profileNickname, profileThumbnailImage, favorite, allowedMsg, serviceUserId);
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
        if (!(other instanceof Friend)) {
            return false;
        }
        Friend friend = (Friend) other;
        return Intrinsics.areEqual(this.id, friend.id) && Intrinsics.areEqual(this.uuid, friend.uuid) && Intrinsics.areEqual(this.profileNickname, friend.profileNickname) && Intrinsics.areEqual(this.profileThumbnailImage, friend.profileThumbnailImage) && Intrinsics.areEqual(this.favorite, friend.favorite) && Intrinsics.areEqual(this.allowedMsg, friend.allowedMsg) && Intrinsics.areEqual(this.serviceUserId, friend.serviceUserId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.id;
        int hashCode = (((l == null ? 0 : l.hashCode()) * 31) + this.uuid.hashCode()) * 31;
        String str = this.profileNickname;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.profileThumbnailImage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.favorite;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.allowedMsg;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l2 = this.serviceUserId;
        return hashCode5 + (l2 != null ? l2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Friend(id=" + this.id + ", uuid=" + this.uuid + ", profileNickname=" + ((Object) this.profileNickname) + ", profileThumbnailImage=" + ((Object) this.profileThumbnailImage) + ", favorite=" + this.favorite + ", allowedMsg=" + this.allowedMsg + ", serviceUserId=" + this.serviceUserId + ')';
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
        parcel.writeString(this.uuid);
        parcel.writeString(this.profileNickname);
        parcel.writeString(this.profileThumbnailImage);
        Boolean bool = this.favorite;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.allowedMsg;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Long l2 = this.serviceUserId;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Friend(Long l, String uuid, String str, String str2, Boolean bool, Boolean bool2, Long l2) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.id = l;
        this.uuid = uuid;
        this.profileNickname = str;
        this.profileThumbnailImage = str2;
        this.favorite = bool;
        this.allowedMsg = bool2;
        this.serviceUserId = l2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileNickname() {
        return this.profileNickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileThumbnailImage() {
        return this.profileThumbnailImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getFavorite() {
        return this.favorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAllowedMsg() {
        return this.allowedMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getServiceUserId() {
        return this.serviceUserId;
    }
}
