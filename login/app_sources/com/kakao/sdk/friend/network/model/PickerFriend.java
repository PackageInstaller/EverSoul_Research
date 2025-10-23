package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakaogame.idp.KGKakao2Auth;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularParamsBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0081\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR\u0019\u0010 \u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u0019\u0010$\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014¨\u0006("}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerFriend;", "Landroid/os/Parcelable;", "", "id", "Ljava/lang/Long;", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "()Ljava/lang/Long;", "", "uuid", "Ljava/lang/String;", SingularParamsBase.Constants.IDENTIFIER_KEYSPACE_KEY, "()Ljava/lang/String;", "profileNickname", "f", "profileThumbnailImage", "g", "", com.kakao.sdk.talk.Constants.FAVORITE, "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", KGKakao2Auth.KEY_SERVICE_USER_ID, "getServiceUserId", "appRegistered", "c", "Lcom/kakao/sdk/friend/network/model/PickerFriendRelation;", com.kakao.sdk.talk.Constants.RELATION, "Lcom/kakao/sdk/friend/network/model/PickerFriendRelation;", SingularParamsBase.Constants.PACKAGE_NAME_KEY, "()Lcom/kakao/sdk/friend/network/model/PickerFriendRelation;", "talkOs", "j", "allowedMsg", "b", "isFriend", "l", "ageFiltered", "a", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/kakao/sdk/friend/network/model/PickerFriendRelation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerFriend implements Parcelable {
    public static final Parcelable.Creator<PickerFriend> CREATOR = new Creator();
    private final Boolean ageFiltered;
    private final Boolean allowedMsg;
    private final Boolean appRegistered;
    private final Boolean favorite;
    private final Long id;
    private final Boolean isFriend;
    private final String profileNickname;
    private final String profileThumbnailImage;
    private final PickerFriendRelation relation;
    private final Long serviceUserId;
    private final String talkOs;
    private final String uuid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriend(Long l, String uuid, String str, String str2, Boolean bool, Long l2, Boolean bool2, PickerFriendRelation pickerFriendRelation, String str3, Boolean bool3, Boolean bool4, Boolean bool5) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.id = l;
        this.uuid = uuid;
        this.profileNickname = str;
        this.profileThumbnailImage = str2;
        this.favorite = bool;
        this.serviceUserId = l2;
        this.appRegistered = bool2;
        this.relation = pickerFriendRelation;
        this.talkOs = str3;
        this.allowedMsg = bool3;
        this.isFriend = bool4;
        this.ageFiltered = bool5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Boolean m644a() {
        return this.ageFiltered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final Boolean m645b() {
        return this.allowedMsg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final Boolean m646c() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final Boolean m647d() {
        return this.favorite;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final Long m648e() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickerFriend)) {
            return false;
        }
        PickerFriend pickerFriend = (PickerFriend) obj;
        return Intrinsics.areEqual(this.id, pickerFriend.id) && Intrinsics.areEqual(this.uuid, pickerFriend.uuid) && Intrinsics.areEqual(this.profileNickname, pickerFriend.profileNickname) && Intrinsics.areEqual(this.profileThumbnailImage, pickerFriend.profileThumbnailImage) && Intrinsics.areEqual(this.favorite, pickerFriend.favorite) && Intrinsics.areEqual(this.serviceUserId, pickerFriend.serviceUserId) && Intrinsics.areEqual(this.appRegistered, pickerFriend.appRegistered) && Intrinsics.areEqual(this.relation, pickerFriend.relation) && Intrinsics.areEqual(this.talkOs, pickerFriend.talkOs) && Intrinsics.areEqual(this.allowedMsg, pickerFriend.allowedMsg) && Intrinsics.areEqual(this.isFriend, pickerFriend.isFriend) && Intrinsics.areEqual(this.ageFiltered, pickerFriend.ageFiltered);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    public final String m649f() {
        return this.profileNickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: g */
    public final String m650g() {
        return this.profileThumbnailImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: h */
    public final boolean m651h() {
        return this.id != null;
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
        Long l2 = this.serviceUserId;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Boolean bool2 = this.appRegistered;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        PickerFriendRelation pickerFriendRelation = this.relation;
        int hashCode7 = (hashCode6 + (pickerFriendRelation == null ? 0 : pickerFriendRelation.hashCode())) * 31;
        String str3 = this.talkOs;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool3 = this.allowedMsg;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isFriend;
        int hashCode10 = (hashCode9 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.ageFiltered;
        return hashCode10 + (bool5 != null ? bool5.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public final PickerFriendRelation m652i() {
        return this.relation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: j */
    public final String m653j() {
        return this.talkOs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: k */
    public final String m654k() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: l */
    public final Boolean m655l() {
        return this.isFriend;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("PickerFriend(id=");
        sb.append(this.id).append(", uuid=").append(this.uuid).append(", profileNickname=").append((Object) this.profileNickname).append(", profileThumbnailImage=").append((Object) this.profileThumbnailImage).append(", favorite=").append(this.favorite).append(", serviceUserId=").append(this.serviceUserId).append(", appRegistered=").append(this.appRegistered).append(", relation=").append(this.relation).append(", talkOs=").append((Object) this.talkOs).append(", allowedMsg=").append(this.allowedMsg).append(", isFriend=").append(this.isFriend).append(", ageFiltered=");
        sb.append(this.ageFiltered).append(')');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Long l = this.id;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
        out.writeString(this.uuid);
        out.writeString(this.profileNickname);
        out.writeString(this.profileThumbnailImage);
        Boolean bool = this.favorite;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l2 = this.serviceUserId;
        if (l2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l2.longValue());
        }
        Boolean bool2 = this.appRegistered;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        PickerFriendRelation pickerFriendRelation = this.relation;
        if (pickerFriendRelation == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            pickerFriendRelation.writeToParcel(out, i);
        }
        out.writeString(this.talkOs);
        Boolean bool3 = this.allowedMsg;
        if (bool3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        Boolean bool4 = this.isFriend;
        if (bool4 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.ageFiltered;
        if (bool5 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool5.booleanValue() ? 1 : 0);
        }
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerFriend> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriend createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Boolean valueOf4;
            Boolean valueOf5;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Long valueOf6 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Long valueOf7 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            PickerFriendRelation createFromParcel = parcel.readInt() == 0 ? null : PickerFriendRelation.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf4 = null;
            } else {
                valueOf4 = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                valueOf5 = null;
            } else {
                valueOf5 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PickerFriend(valueOf6, readString, readString2, readString3, valueOf, valueOf7, valueOf2, createFromParcel, readString4, valueOf3, valueOf4, valueOf5);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriend[] newArray(int i) {
            return new PickerFriend[i];
        }
    }
}
