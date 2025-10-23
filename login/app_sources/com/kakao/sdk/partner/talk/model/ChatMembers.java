package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.partner.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMembers.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001,B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0014JN\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/ChatMembers;", "Landroid/os/Parcelable;", "activeMembersCount", "", "activeFriendsCount", "members", "", "Lcom/kakao/sdk/partner/talk/model/ChatMember;", "type", "Lcom/kakao/sdk/partner/talk/model/ChatMembers$Type;", Constants.TOKEN, "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/partner/talk/model/ChatMembers$Type;Ljava/lang/Long;)V", "getActiveFriendsCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActiveMembersCount", "getMembers", "()Ljava/util/List;", "getToken", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "()Lcom/kakao/sdk/partner/talk/model/ChatMembers$Type;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/partner/talk/model/ChatMembers$Type;Ljava/lang/Long;)Lcom/kakao/sdk/partner/talk/model/ChatMembers;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChatMembers implements Parcelable {
    public static final Parcelable.Creator<ChatMembers> CREATOR = new Creator();
    private final Integer activeFriendsCount;
    private final Integer activeMembersCount;
    private final List<ChatMember> members;
    private final Long token;
    private final Type type;

    /* compiled from: ChatMembers.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<ChatMembers> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ChatMembers createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(ChatMember.CREATOR.createFromParcel(parcel));
                }
            }
            return new ChatMembers(valueOf, valueOf2, arrayList, Type.valueOf(parcel.readString()), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final ChatMembers[] newArray(int i) {
            return new ChatMembers[i];
        }
    }

    /* compiled from: ChatMembers.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/ChatMembers$Type;", "", "(Ljava/lang/String;I)V", "DIRECT_CHAT", "MULTI_CHAT", "UNKNOWN", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public enum Type {
        DIRECT_CHAT,
        MULTI_CHAT,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ChatMembers copy$default(ChatMembers chatMembers, Integer num, Integer num2, List list, Type type, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            num = chatMembers.activeMembersCount;
        }
        if ((i & 2) != 0) {
            num2 = chatMembers.activeFriendsCount;
        }
        Integer num3 = num2;
        if ((i & 4) != 0) {
            list = chatMembers.members;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            type = chatMembers.type;
        }
        Type type2 = type;
        if ((i & 16) != 0) {
            l = chatMembers.token;
        }
        return chatMembers.copy(num, num3, list2, type2, l);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component1() {
        return this.activeMembersCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component2() {
        return this.activeFriendsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ChatMember> component3() {
        return this.members;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type component4() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component5() {
        return this.token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ChatMembers copy(Integer activeMembersCount, Integer activeFriendsCount, List<ChatMember> members, Type type, Long token) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new ChatMembers(activeMembersCount, activeFriendsCount, members, type, token);
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
        if (!(other instanceof ChatMembers)) {
            return false;
        }
        ChatMembers chatMembers = (ChatMembers) other;
        return Intrinsics.areEqual(this.activeMembersCount, chatMembers.activeMembersCount) && Intrinsics.areEqual(this.activeFriendsCount, chatMembers.activeFriendsCount) && Intrinsics.areEqual(this.members, chatMembers.members) && this.type == chatMembers.type && Intrinsics.areEqual(this.token, chatMembers.token);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.activeMembersCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.activeFriendsCount;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<ChatMember> list = this.members;
        int hashCode3 = (((hashCode2 + (list == null ? 0 : list.hashCode())) * 31) + this.type.hashCode()) * 31;
        Long l = this.token;
        return hashCode3 + (l != null ? l.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ChatMembers(activeMembersCount=" + this.activeMembersCount + ", activeFriendsCount=" + this.activeFriendsCount + ", members=" + this.members + ", type=" + this.type + ", token=" + this.token + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.activeMembersCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.activeFriendsCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        List<ChatMember> list = this.members;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<ChatMember> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.type.name());
        Long l = this.token;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChatMembers(Integer num, Integer num2, List<ChatMember> list, Type type, Long l) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.activeMembersCount = num;
        this.activeFriendsCount = num2;
        this.members = list;
        this.type = type;
        this.token = l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getActiveMembersCount() {
        return this.activeMembersCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getActiveFriendsCount() {
        return this.activeFriendsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ChatMember> getMembers() {
        return this.members;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getToken() {
        return this.token;
    }
}
