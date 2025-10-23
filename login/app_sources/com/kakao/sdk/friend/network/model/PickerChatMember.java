package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakaogame.idp.KGKakao2Auth;
import com.singular.sdk.internal.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0081\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChatMember;", "Landroid/os/Parcelable;", "", "appRegistered", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "", "id", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "nickname", "Ljava/lang/String;", "d", "()Ljava/lang/String;", KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "uuid", "f", "isFriend", "g", "msgBlocked", "c", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerChatMember implements Parcelable {
    public static final Parcelable.Creator<PickerChatMember> CREATOR = new Creator();
    private final Boolean appRegistered;
    private final Long id;
    private final Boolean isFriend;
    private final Boolean msgBlocked;
    private final String nickname;

    @SerializedName("thumbnail_image")
    private final String thumbnailImageUrl;
    private final String uuid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatMember(Boolean bool, Long l, String str, String str2, String uuid, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.appRegistered = bool;
        this.id = l;
        this.nickname = str;
        this.thumbnailImageUrl = str2;
        this.uuid = uuid;
        this.isFriend = bool2;
        this.msgBlocked = bool3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Boolean m632a() {
        return this.appRegistered;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final Long m633b() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final Boolean m634c() {
        return this.msgBlocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final String m635d() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final String m636e() {
        return this.thumbnailImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickerChatMember)) {
            return false;
        }
        PickerChatMember pickerChatMember = (PickerChatMember) obj;
        return Intrinsics.areEqual(this.appRegistered, pickerChatMember.appRegistered) && Intrinsics.areEqual(this.id, pickerChatMember.id) && Intrinsics.areEqual(this.nickname, pickerChatMember.nickname) && Intrinsics.areEqual(this.thumbnailImageUrl, pickerChatMember.thumbnailImageUrl) && Intrinsics.areEqual(this.uuid, pickerChatMember.uuid) && Intrinsics.areEqual(this.isFriend, pickerChatMember.isFriend) && Intrinsics.areEqual(this.msgBlocked, pickerChatMember.msgBlocked);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    public final String m637f() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: g */
    public final Boolean m638g() {
        return this.isFriend;
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
        Boolean bool2 = this.isFriend;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.msgBlocked;
        return hashCode5 + (bool3 != null ? bool3.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerChatMember(appRegistered=" + this.appRegistered + ", id=" + this.id + ", nickname=" + ((Object) this.nickname) + ", thumbnailImageUrl=" + ((Object) this.thumbnailImageUrl) + ", uuid=" + this.uuid + ", isFriend=" + this.isFriend + ", msgBlocked=" + this.msgBlocked + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Boolean bool = this.appRegistered;
        if (bool == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Long l = this.id;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
        out.writeString(this.nickname);
        out.writeString(this.thumbnailImageUrl);
        out.writeString(this.uuid);
        Boolean bool2 = this.isFriend;
        if (bool2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.msgBlocked;
        if (bool3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(bool3.booleanValue() ? 1 : 0);
        }
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChatMember> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMember createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Boolean valueOf2;
            Boolean valueOf3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
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
            return new PickerChatMember(valueOf, valueOf4, readString, readString2, readString3, valueOf2, valueOf3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMember[] newArray(int i) {
            return new PickerChatMember[i];
        }
    }
}
