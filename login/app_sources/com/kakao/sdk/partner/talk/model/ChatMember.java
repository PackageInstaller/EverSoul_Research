package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakaogame.idp.KGKakao2Auth;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMembers.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJT\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020 HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006+"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/ChatMember;", "Landroid/os/Parcelable;", "appRegistered", "", "id", "", "nickname", "", KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, "uuid", "msgBlocked", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAppRegistered", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMsgBlocked", "getNickname", "()Ljava/lang/String;", "getThumbnailImageUrl", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/kakao/sdk/partner/talk/model/ChatMember;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatMember implements Parcelable {
    public static final Parcelable.Creator<ChatMember> CREATOR = new Creator();
    private final Boolean appRegistered;
    private final Long id;
    private final Boolean msgBlocked;
    private final String nickname;

    @SerializedName("thumbnail_image")
    private final String thumbnailImageUrl;
    private final String uuid;

    /* compiled from: ChatMembers.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ChatMember> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ChatMember createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf2 = null;
            } else {
                valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ChatMember(valueOf, valueOf3, readString, readString2, readString3, valueOf2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ChatMember[] newArray(int i) {
            return new ChatMember[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ChatMember copy$default(ChatMember chatMember, Boolean bool, Long l, String str, String str2, String str3, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = chatMember.appRegistered;
        }
        if ((i & 2) != 0) {
            l = chatMember.id;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str = chatMember.nickname;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = chatMember.thumbnailImageUrl;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = chatMember.uuid;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            bool2 = chatMember.msgBlocked;
        }
        return chatMember.copy(bool, l2, str4, str5, str6, bool2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component1() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component2() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.thumbnailImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component6() {
        return this.msgBlocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ChatMember copy(Boolean appRegistered, Long id, String nickname, String thumbnailImageUrl, String uuid, Boolean msgBlocked) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new ChatMember(appRegistered, id, nickname, thumbnailImageUrl, uuid, msgBlocked);
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
        if (!(other instanceof ChatMember)) {
            return false;
        }
        ChatMember chatMember = (ChatMember) other;
        return Intrinsics.areEqual(this.appRegistered, chatMember.appRegistered) && Intrinsics.areEqual(this.id, chatMember.id) && Intrinsics.areEqual(this.nickname, chatMember.nickname) && Intrinsics.areEqual(this.thumbnailImageUrl, chatMember.thumbnailImageUrl) && Intrinsics.areEqual(this.uuid, chatMember.uuid) && Intrinsics.areEqual(this.msgBlocked, chatMember.msgBlocked);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Boolean bool = this.appRegistered;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Long l = this.id;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.nickname;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.thumbnailImageUrl;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.uuid.hashCode()) * 31;
        Boolean bool2 = this.msgBlocked;
        return hashCode4 + (bool2 != null ? bool2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ChatMember(appRegistered=" + this.appRegistered + ", id=" + this.id + ", nickname=" + ((Object) this.nickname) + ", thumbnailImageUrl=" + ((Object) this.thumbnailImageUrl) + ", uuid=" + this.uuid + ", msgBlocked=" + this.msgBlocked + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Boolean bool = this.appRegistered;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l = this.id;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.nickname);
        parcel.writeString(this.thumbnailImageUrl);
        parcel.writeString(this.uuid);
        Boolean bool2 = this.msgBlocked;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChatMember(Boolean bool, Long l, String str, String str2, String uuid, Boolean bool2) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.appRegistered = bool;
        this.id = l;
        this.nickname = str;
        this.thumbnailImageUrl = str2;
        this.uuid = uuid;
        this.msgBlocked = bool2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getAppRegistered() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThumbnailImageUrl() {
        return this.thumbnailImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getMsgBlocked() {
        return this.msgBlocked;
    }
}
