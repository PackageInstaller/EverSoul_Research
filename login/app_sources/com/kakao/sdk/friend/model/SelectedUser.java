package com.kakao.sdk.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0014HÖ\u0001R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010\u0004R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b$\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b%\u0010#R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\u000b¨\u0006*"}, m839d2 = {"Lcom/kakao/sdk/friend/model/SelectedUser;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Long;", "", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "id", "uuid", "profileNickname", "profileThumbnailImage", Constants.FAVORITE, "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/kakao/sdk/friend/model/SelectedUser;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/lang/Long;", "getId", "Ljava/lang/String;", "getUuid", "()Ljava/lang/String;", "getProfileNickname", "getProfileThumbnailImage", "Ljava/lang/Boolean;", "getFavorite", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class SelectedUser implements Parcelable {
    public static final Parcelable.Creator<SelectedUser> CREATOR = new Creator();
    private final Boolean favorite;
    private final Long id;
    private final String profileNickname;
    private final String profileThumbnailImage;
    private final String uuid;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<SelectedUser> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedUser createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new SelectedUser(valueOf2, readString, readString2, readString3, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedUser[] newArray(int i) {
            return new SelectedUser[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SelectedUser(Long l, String uuid, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.id = l;
        this.uuid = uuid;
        this.profileNickname = str;
        this.profileThumbnailImage = str2;
        this.favorite = bool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SelectedUser copy$default(SelectedUser selectedUser, Long l, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            l = selectedUser.id;
        }
        if ((i & 2) != 0) {
            str = selectedUser.uuid;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = selectedUser.profileNickname;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = selectedUser.profileThumbnailImage;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            bool = selectedUser.favorite;
        }
        return selectedUser.copy(l, str4, str5, str6, bool);
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
    public final SelectedUser copy(Long id, String uuid, String profileNickname, String profileThumbnailImage, Boolean favorite) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new SelectedUser(id, uuid, profileNickname, profileThumbnailImage, favorite);
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
        if (!(other instanceof SelectedUser)) {
            return false;
        }
        SelectedUser selectedUser = (SelectedUser) other;
        return Intrinsics.areEqual(this.id, selectedUser.id) && Intrinsics.areEqual(this.uuid, selectedUser.uuid) && Intrinsics.areEqual(this.profileNickname, selectedUser.profileNickname) && Intrinsics.areEqual(this.profileThumbnailImage, selectedUser.profileThumbnailImage) && Intrinsics.areEqual(this.favorite, selectedUser.favorite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getFavorite() {
        return this.favorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
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
    public final String getUuid() {
        return this.uuid;
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
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "SelectedUser(id=" + this.id + ", uuid=" + this.uuid + ", profileNickname=" + ((Object) this.profileNickname) + ", profileThumbnailImage=" + ((Object) this.profileThumbnailImage) + ", favorite=" + this.favorite + ')';
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
    }
}
