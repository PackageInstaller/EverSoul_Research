package com.kakao.sdk.friend.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J%\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\f\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0002HÖ\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, m839d2 = {"Lcom/kakao/sdk/friend/model/SelectedUsers;", "Landroid/os/Parcelable;", "", "component1", "", "Lcom/kakao/sdk/friend/model/SelectedUser;", "component2", "totalCount", "users", "copy", "", "toString", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "I", "getTotalCount", "()I", "Ljava/util/List;", "getUsers", "()Ljava/util/List;", "<init>", "(ILjava/util/List;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class SelectedUsers implements Parcelable {
    public static final Parcelable.Creator<SelectedUsers> CREATOR = new Creator();
    private final int totalCount;
    private final List<SelectedUser> users;

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<SelectedUsers> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedUsers createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList2.add(SelectedUser.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new SelectedUsers(readInt, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final SelectedUsers[] newArray(int i) {
            return new SelectedUsers[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SelectedUsers(int i, List<SelectedUser> list) {
        this.totalCount = i;
        this.users = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ SelectedUsers copy$default(SelectedUsers selectedUsers, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = selectedUsers.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = selectedUsers.users;
        }
        return selectedUsers.copy(i, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<SelectedUser> component2() {
        return this.users;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SelectedUsers copy(int totalCount, List<SelectedUser> users) {
        return new SelectedUsers(totalCount, users);
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
        if (!(other instanceof SelectedUsers)) {
            return false;
        }
        SelectedUsers selectedUsers = (SelectedUsers) other;
        return this.totalCount == selectedUsers.totalCount && Intrinsics.areEqual(this.users, selectedUsers.users);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<SelectedUser> getUsers() {
        return this.users;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.totalCount) * 31;
        List<SelectedUser> list = this.users;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "SelectedUsers(totalCount=" + this.totalCount + ", users=" + this.users + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.totalCount);
        List<SelectedUser> list = this.users;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        Iterator<SelectedUser> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
