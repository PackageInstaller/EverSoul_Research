package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.friend.model.PickerChatType;
import com.singular.sdk.internal.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0019\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b¨\u0006!"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChat;", "Landroid/os/Parcelable;", "", "id", "J", "c", "()J", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "imageUrl", "d", "", "memberCount", "Ljava/lang/Integer;", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "()Ljava/lang/Integer;", "", "displayMemberImages", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/model/PickerChatType;", "chatType", "Lcom/kakao/sdk/friend/model/PickerChatType;", "a", "()Lcom/kakao/sdk/friend/model/PickerChatType;", "titleSource", "g", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/friend/model/PickerChatType;Ljava/lang/String;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerChat implements Parcelable {
    public static final Parcelable.Creator<PickerChat> CREATOR = new Creator();
    private final PickerChatType chatType;
    private final List<String> displayMemberImages;
    private final long id;
    private final String imageUrl;
    private final Integer memberCount;
    private final String title;
    private final String titleSource;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChat(long j, String str, String str2, Integer num, List<String> list, PickerChatType chatType, String titleSource) {
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
    /* renamed from: a */
    public final PickerChatType m625a() {
        return this.chatType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final List<String> m626b() {
        return this.displayMemberImages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final long m627c() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final String m628d() {
        return this.imageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public final Integer m629e() {
        return this.memberCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickerChat)) {
            return false;
        }
        PickerChat pickerChat = (PickerChat) obj;
        return this.id == pickerChat.id && Intrinsics.areEqual(this.title, pickerChat.title) && Intrinsics.areEqual(this.imageUrl, pickerChat.imageUrl) && Intrinsics.areEqual(this.memberCount, pickerChat.memberCount) && Intrinsics.areEqual(this.displayMemberImages, pickerChat.displayMemberImages) && this.chatType == pickerChat.chatType && Intrinsics.areEqual(this.titleSource, pickerChat.titleSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: f */
    public final String m630f() {
        return this.title;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: g */
    public final String m631g() {
        return this.titleSource;
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
        return "PickerChat(id=" + this.id + ", title=" + ((Object) this.title) + ", imageUrl=" + ((Object) this.imageUrl) + ", memberCount=" + this.memberCount + ", displayMemberImages=" + this.displayMemberImages + ", chatType=" + this.chatType + ", titleSource=" + this.titleSource + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.id);
        out.writeString(this.title);
        out.writeString(this.imageUrl);
        Integer num = this.memberCount;
        if (num == null) {
            intValue = 0;
        } else {
            out.writeInt(1);
            intValue = num.intValue();
        }
        out.writeInt(intValue);
        out.writeStringList(this.displayMemberImages);
        out.writeString(this.chatType.name());
        out.writeString(this.titleSource);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChat> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChat createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickerChat(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.createStringArrayList(), PickerChatType.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChat[] newArray(int i) {
            return new PickerChat[i];
        }
    }
}
