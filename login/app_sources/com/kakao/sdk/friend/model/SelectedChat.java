package com.kakao.sdk.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0006R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b'\u0010&R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, m839d2 = {"Lcom/kakao/sdk/friend/model/SelectedChat;", "Landroid/os/Parcelable;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "", "component3", "component4", "Lcom/kakao/sdk/friend/model/PickerChatType;", "component5", "id", "memberCount", "titleSource", "imageUrl", "type", "copy", "(JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/friend/model/PickerChatType;)Lcom/kakao/sdk/friend/model/SelectedChat;", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "J", "getId", "()J", "Ljava/lang/Integer;", "getMemberCount", "Ljava/lang/String;", "getTitleSource", "()Ljava/lang/String;", "getImageUrl", "Lcom/kakao/sdk/friend/model/PickerChatType;", "getType", "()Lcom/kakao/sdk/friend/model/PickerChatType;", "setType", "(Lcom/kakao/sdk/friend/model/PickerChatType;)V", "<init>", "(JLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/friend/model/PickerChatType;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class SelectedChat implements Parcelable {
    public static final Parcelable.Creator<SelectedChat> CREATOR = new Creator();
    private final long id;
    private final String imageUrl;
    private final Integer memberCount;
    private final String titleSource;
    private PickerChatType type;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<SelectedChat> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedChat createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectedChat(parcel.readLong(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PickerChatType.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedChat[] newArray(int i) {
            return new SelectedChat[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SelectedChat(long j, Integer num, String str, String str2, PickerChatType pickerChatType) {
        this.id = j;
        this.memberCount = num;
        this.titleSource = str;
        this.imageUrl = str2;
        this.type = pickerChatType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ SelectedChat(long j, Integer num, String str, String str2, PickerChatType pickerChatType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? 0 : num, str, str2, pickerChatType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SelectedChat copy$default(SelectedChat selectedChat, long j, Integer num, String str, String str2, PickerChatType pickerChatType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = selectedChat.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            num = selectedChat.memberCount;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str = selectedChat.titleSource;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = selectedChat.imageUrl;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            pickerChatType = selectedChat.type;
        }
        return selectedChat.copy(j2, num2, str3, str4, pickerChatType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component2() {
        return this.memberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.titleSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.imageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerChatType component5() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SelectedChat copy(long id, Integer memberCount, String titleSource, String imageUrl, PickerChatType type) {
        return new SelectedChat(id, memberCount, titleSource, imageUrl, type);
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
        if (!(other instanceof SelectedChat)) {
            return false;
        }
        SelectedChat selectedChat = (SelectedChat) other;
        return this.id == selectedChat.id && Intrinsics.areEqual(this.memberCount, selectedChat.memberCount) && Intrinsics.areEqual(this.titleSource, selectedChat.titleSource) && Intrinsics.areEqual(this.imageUrl, selectedChat.imageUrl) && this.type == selectedChat.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getMemberCount() {
        return this.memberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitleSource() {
        return this.titleSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PickerChatType getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        Integer num = this.memberCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.titleSource;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PickerChatType pickerChatType = this.type;
        return hashCode4 + (pickerChatType != null ? pickerChatType.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setType(PickerChatType pickerChatType) {
        this.type = pickerChatType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "SelectedChat(id=" + this.id + ", memberCount=" + this.memberCount + ", titleSource=" + ((Object) this.titleSource) + ", imageUrl=" + ((Object) this.imageUrl) + ", type=" + this.type + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        Integer num = this.memberCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.titleSource);
        parcel.writeString(this.imageUrl);
        PickerChatType pickerChatType = this.type;
        if (pickerChatType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(pickerChatType.name());
        }
    }
}
