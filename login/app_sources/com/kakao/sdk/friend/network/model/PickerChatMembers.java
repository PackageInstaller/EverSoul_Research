package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.partner.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0081\b\u0018\u00002\u00020\u0001:\u0001\u001bBE\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001f\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChatMembers;", "Landroid/os/Parcelable;", "", "activeMembersCount", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "activeFriendsCount", "getActiveFriendsCount", "", "Lcom/kakao/sdk/friend/network/model/PickerChatMember;", "members", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/kakao/sdk/friend/network/model/PickerChatMembers$Type;", "type", "Lcom/kakao/sdk/friend/network/model/PickerChatMembers$Type;", "getType", "()Lcom/kakao/sdk/friend/network/model/PickerChatMembers$Type;", "", Constants.TOKEN, "Ljava/lang/Long;", "getToken", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/friend/network/model/PickerChatMembers$Type;Ljava/lang/Long;)V", "Type", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerChatMembers implements Parcelable {
    public static final Parcelable.Creator<PickerChatMembers> CREATOR = new Creator();
    private final Integer activeFriendsCount;
    private final Integer activeMembersCount;
    private final List<PickerChatMember> members;
    private final Long token;
    private final Type type;

    @Metadata(m837bv = {}, m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChatMembers$Type;", "", "<init>", "(Ljava/lang/String;I)V", "DIRECT_CHAT", "MULTI_CHAT", "UNKNOWN", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
    public enum Type {
        DIRECT_CHAT,
        MULTI_CHAT,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatMembers(Integer num, Integer num2, List<PickerChatMember> list, Type type, Long l) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.activeMembersCount = num;
        this.activeFriendsCount = num2;
        this.members = list;
        this.type = type;
        this.token = l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Integer m641a() {
        return this.activeMembersCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final List<PickerChatMember> m642b() {
        return this.members;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PickerChatMembers)) {
            return false;
        }
        PickerChatMembers pickerChatMembers = (PickerChatMembers) obj;
        return Intrinsics.areEqual(this.activeMembersCount, pickerChatMembers.activeMembersCount) && Intrinsics.areEqual(this.activeFriendsCount, pickerChatMembers.activeFriendsCount) && Intrinsics.areEqual(this.members, pickerChatMembers.members) && this.type == pickerChatMembers.type && Intrinsics.areEqual(this.token, pickerChatMembers.token);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.activeMembersCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.activeFriendsCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<PickerChatMember> list = this.members;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.type.hashCode()) * 31;
        Long l = this.token;
        return hashCode3 + (l != null ? l.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerChatMembers(activeMembersCount=" + this.activeMembersCount + ", activeFriendsCount=" + this.activeFriendsCount + ", members=" + this.members + ", type=" + this.type + ", token=" + this.token + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Integer num = this.activeMembersCount;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.activeFriendsCount;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        List<PickerChatMember> list = this.members;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PickerChatMember> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i);
            }
        }
        out.writeString(this.type.name());
        Long l = this.token;
        if (l == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeLong(l.longValue());
        }
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChatMembers> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMembers createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList2.add(PickerChatMember.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PickerChatMembers(valueOf, valueOf2, arrayList, Type.valueOf(parcel.readString()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMembers[] newArray(int i) {
            return new PickerChatMembers[i];
        }
    }
}
