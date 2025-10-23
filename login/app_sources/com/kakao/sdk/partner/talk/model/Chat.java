package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chats.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u00011BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003Jb\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\bHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016¨\u00062"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/Chat;", "Landroid/os/Parcelable;", "id", "", "title", "", "imageUrl", "memberCount", "", "displayMemberImages", "", "chatType", "Lcom/kakao/sdk/partner/talk/model/Chat$Type;", "titleSource", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/partner/talk/model/Chat$Type;Ljava/lang/String;)V", "getChatType", "()Lcom/kakao/sdk/partner/talk/model/Chat$Type;", "getDisplayMemberImages", "()Ljava/util/List;", "getId", "()J", "getImageUrl", "()Ljava/lang/String;", "getMemberCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getTitleSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/partner/talk/model/Chat$Type;Ljava/lang/String;)Lcom/kakao/sdk/partner/talk/model/Chat;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Chat implements Parcelable {
    public static final Parcelable.Creator<Chat> CREATOR = new Creator();
    private final Type chatType;
    private final List<String> displayMemberImages;
    private final long id;
    private final String imageUrl;
    private final Integer memberCount;
    private final String title;
    private final String titleSource;

    /* compiled from: Chats.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Chat> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Chat createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Chat(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.createStringArrayList(), Type.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Chat[] newArray(int i) {
            return new Chat[i];
        }
    }

    /* compiled from: Chats.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/Chat$Type;", "", "(Ljava/lang/String;I)V", "REGULAR", "OPEN", "UNKNOWN", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public enum Type {
        REGULAR,
        OPEN,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.title;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.imageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component4() {
        return this.memberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component5() {
        return this.displayMemberImages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type component6() {
        return this.chatType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component7() {
        return this.titleSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Chat copy(long id, String title, String imageUrl, Integer memberCount, List<String> displayMemberImages, Type chatType, String titleSource) {
        Intrinsics.checkNotNullParameter(chatType, "chatType");
        Intrinsics.checkNotNullParameter(titleSource, "titleSource");
        return new Chat(id, title, imageUrl, memberCount, displayMemberImages, chatType, titleSource);
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
        if (!(other instanceof Chat)) {
            return false;
        }
        Chat chat = (Chat) other;
        return this.id == chat.id && Intrinsics.areEqual(this.title, chat.title) && Intrinsics.areEqual(this.imageUrl, chat.imageUrl) && Intrinsics.areEqual(this.memberCount, chat.memberCount) && Intrinsics.areEqual(this.displayMemberImages, chat.displayMemberImages) && this.chatType == chat.chatType && Intrinsics.areEqual(this.titleSource, chat.titleSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.memberCount;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.displayMemberImages;
        return ((((hashCode4 + (list != null ? list.hashCode() : 0)) * 31) + this.chatType.hashCode()) * 31) + this.titleSource.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Chat(id=" + this.id + ", title=" + ((Object) this.title) + ", imageUrl=" + ((Object) this.imageUrl) + ", memberCount=" + this.memberCount + ", displayMemberImages=" + this.displayMemberImages + ", chatType=" + this.chatType + ", titleSource=" + this.titleSource + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int intValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.imageUrl);
        Integer num = this.memberCount;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        parcel.writeStringList(this.displayMemberImages);
        parcel.writeString(this.chatType.name());
        parcel.writeString(this.titleSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Chat(long j, String str, String str2, Integer num, List<String> list, Type chatType, String titleSource) {
        Intrinsics.checkNotNullParameter(chatType, "chatType");
        Intrinsics.checkNotNullParameter(titleSource, "titleSource");
        this.id = j;
        this.title = str;
        this.imageUrl = str2;
        this.memberCount = num;
        this.displayMemberImages = list;
        this.chatType = chatType;
        this.titleSource = titleSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitle() {
        return this.title;
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
    public final List<String> getDisplayMemberImages() {
        return this.displayMemberImages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type getChatType() {
        return this.chatType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTitleSource() {
        return this.titleSource;
    }
}
