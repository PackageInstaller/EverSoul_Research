package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import com.kakaogame.idp.KGKakao2Auth;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Friend.kt */
@Metadata(m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u009c\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00105J\t\u00106\u001a\u000207HÖ\u0001J\u0013\u00108\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u000207HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u000207HÖ\u0001R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001f¨\u0006B"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", "Landroid/os/Parcelable;", "id", "", "uuid", "", "profileNickname", "profileThumbnailImage", Constants.FAVORITE, "", KGKakao2Auth.KEY_SERVICE_USER_ID, "registeredToApp", "appRegistered", Constants.RELATION, "Lcom/kakao/sdk/partner/talk/model/FriendRelation;", "talkOs", "msgAllowed", "allowedMsg", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/partner/talk/model/FriendRelation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAllowedMsg", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAppRegistered", "getFavorite", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMsgAllowed$annotations", "()V", "getMsgAllowed", "getProfileNickname", "()Ljava/lang/String;", "getProfileThumbnailImage", "getRegisteredToApp$annotations", "getRegisteredToApp", "getRelation", "()Lcom/kakao/sdk/partner/talk/model/FriendRelation;", "getServiceUserId", "getTalkOs", "getUuid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/kakao/sdk/partner/talk/model/FriendRelation;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerFriend implements Parcelable {
    public static final Parcelable.Creator<PartnerFriend> CREATOR = new Creator();
    private final Boolean allowedMsg;
    private final Boolean appRegistered;
    private final Boolean favorite;
    private final Long id;
    private final Boolean msgAllowed;
    private final String profileNickname;
    private final String profileThumbnailImage;
    private final Boolean registeredToApp;
    private final FriendRelation relation;
    private final Long serviceUserId;
    private final String talkOs;
    private final String uuid;

    /* compiled from: Friend.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PartnerFriend> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerFriend createFromParcel(Parcel parcel) {
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
            if (parcel.readInt() == 0) {
                valueOf3 = null;
            } else {
                valueOf3 = Boolean.valueOf(parcel.readInt() != 0);
            }
            FriendRelation createFromParcel = parcel.readInt() == 0 ? null : FriendRelation.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
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
            return new PartnerFriend(valueOf6, readString, readString2, readString3, valueOf, valueOf7, valueOf2, valueOf3, createFromParcel, readString4, valueOf4, valueOf5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerFriend[] newArray(int i) {
            return new PartnerFriend[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "해당 property는 'allowedMsg'로 대체되었습니다. ")
    public static /* synthetic */ void getMsgAllowed$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "해당 property는 'appRegistered'로 대체되었습니다. ")
    public static /* synthetic */ void getRegisteredToApp$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component10() {
        return this.talkOs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component11() {
        return this.msgAllowed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component12() {
        return this.allowedMsg;
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
    public final Long component6() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component7() {
        return this.registeredToApp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component8() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendRelation component9() {
        return this.relation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerFriend copy(Long id, String uuid, String profileNickname, String profileThumbnailImage, Boolean favorite, Long serviceUserId, Boolean registeredToApp, Boolean appRegistered, FriendRelation relation, String talkOs, Boolean msgAllowed, Boolean allowedMsg) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new PartnerFriend(id, uuid, profileNickname, profileThumbnailImage, favorite, serviceUserId, registeredToApp, appRegistered, relation, talkOs, msgAllowed, allowedMsg);
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
        if (!(other instanceof PartnerFriend)) {
            return false;
        }
        PartnerFriend partnerFriend = (PartnerFriend) other;
        return Intrinsics.areEqual(this.id, partnerFriend.id) && Intrinsics.areEqual(this.uuid, partnerFriend.uuid) && Intrinsics.areEqual(this.profileNickname, partnerFriend.profileNickname) && Intrinsics.areEqual(this.profileThumbnailImage, partnerFriend.profileThumbnailImage) && Intrinsics.areEqual(this.favorite, partnerFriend.favorite) && Intrinsics.areEqual(this.serviceUserId, partnerFriend.serviceUserId) && Intrinsics.areEqual(this.registeredToApp, partnerFriend.registeredToApp) && Intrinsics.areEqual(this.appRegistered, partnerFriend.appRegistered) && Intrinsics.areEqual(this.relation, partnerFriend.relation) && Intrinsics.areEqual(this.talkOs, partnerFriend.talkOs) && Intrinsics.areEqual(this.msgAllowed, partnerFriend.msgAllowed) && Intrinsics.areEqual(this.allowedMsg, partnerFriend.allowedMsg);
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
        Boolean bool2 = this.registeredToApp;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.appRegistered;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        FriendRelation friendRelation = this.relation;
        int hashCode8 = (hashCode7 + (friendRelation == null ? 0 : friendRelation.hashCode())) * 31;
        String str3 = this.talkOs;
        int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool4 = this.msgAllowed;
        int hashCode10 = (hashCode9 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.allowedMsg;
        return hashCode10 + (bool5 != null ? bool5.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("PartnerFriend(id=");
        sb.append(this.id).append(", uuid=").append(this.uuid).append(", profileNickname=").append((Object) this.profileNickname).append(", profileThumbnailImage=").append((Object) this.profileThumbnailImage).append(", favorite=").append(this.favorite).append(", serviceUserId=").append(this.serviceUserId).append(", registeredToApp=").append(this.registeredToApp).append(", appRegistered=").append(this.appRegistered).append(", relation=").append(this.relation).append(", talkOs=").append((Object) this.talkOs).append(", msgAllowed=").append(this.msgAllowed).append(", allowedMsg=");
        sb.append(this.allowedMsg).append(')');
        return sb.toString();
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
        Long l2 = this.serviceUserId;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Boolean bool2 = this.registeredToApp;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.appRegistered;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        FriendRelation friendRelation = this.relation;
        if (friendRelation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            friendRelation.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.talkOs);
        Boolean bool4 = this.msgAllowed;
        if (bool4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.allowedMsg;
        if (bool5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool5.booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerFriend(Long l, String uuid, String str, String str2, Boolean bool, Long l2, Boolean bool2, Boolean bool3, FriendRelation friendRelation, String str3, Boolean bool4, Boolean bool5) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.id = l;
        this.uuid = uuid;
        this.profileNickname = str;
        this.profileThumbnailImage = str2;
        this.favorite = bool;
        this.serviceUserId = l2;
        this.registeredToApp = bool2;
        this.appRegistered = bool3;
        this.relation = friendRelation;
        this.talkOs = str3;
        this.msgAllowed = bool4;
        this.allowedMsg = bool5;
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
    public final Long getServiceUserId() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getRegisteredToApp() {
        return this.registeredToApp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAppRegistered() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendRelation getRelation() {
        return this.relation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTalkOs() {
        return this.talkOs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getMsgAllowed() {
        return this.msgAllowed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAllowedMsg() {
        return this.allowedMsg;
    }
}
