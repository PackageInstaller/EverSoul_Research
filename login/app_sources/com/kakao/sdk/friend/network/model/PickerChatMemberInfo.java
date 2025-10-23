package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChatMemberInfo;", "Landroid/os/Parcelable;", "", "displayAllProfile", "Z", "b", "()Z", "Lcom/kakao/sdk/friend/network/model/PickerChatMembers;", "chatMembers", "Lcom/kakao/sdk/friend/network/model/PickerChatMembers;", "a", "()Lcom/kakao/sdk/friend/network/model/PickerChatMembers;", "<init>", "(ZLcom/kakao/sdk/friend/network/model/PickerChatMembers;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerChatMemberInfo implements Parcelable {
    public static final Parcelable.Creator<PickerChatMemberInfo> CREATOR = new Creator();
    private final PickerChatMembers chatMembers;
    private final boolean displayAllProfile;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChatMemberInfo(boolean z, PickerChatMembers chatMembers) {
        Intrinsics.checkNotNullParameter(chatMembers, "chatMembers");
        this.displayAllProfile = z;
        this.chatMembers = chatMembers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final PickerChatMembers m639a() {
        return this.chatMembers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final boolean m640b() {
        return this.displayAllProfile;
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
        if (!(obj instanceof PickerChatMemberInfo)) {
            return false;
        }
        PickerChatMemberInfo pickerChatMemberInfo = (PickerChatMemberInfo) obj;
        return this.displayAllProfile == pickerChatMemberInfo.displayAllProfile && Intrinsics.areEqual(this.chatMembers, pickerChatMemberInfo.chatMembers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        boolean z = this.displayAllProfile;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.chatMembers.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerChatMemberInfo(displayAllProfile=" + this.displayAllProfile + ", chatMembers=" + this.chatMembers + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.displayAllProfile ? 1 : 0);
        this.chatMembers.writeToParcel(out, i);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChatMemberInfo> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMemberInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickerChatMemberInfo(parcel.readInt() != 0, PickerChatMembers.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChatMemberInfo[] newArray(int i) {
            return new PickerChatMemberInfo[i];
        }
    }
}
