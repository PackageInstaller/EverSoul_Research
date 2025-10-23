package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerUsers;", "Landroid/os/Parcelable;", "", "displayAllProfile", "Z", "a", "()Z", "Lcom/kakao/sdk/friend/network/model/Me;", TournamentShareDialogURIBuilder.f184me, "Lcom/kakao/sdk/friend/network/model/Me;", "c", "()Lcom/kakao/sdk/friend/network/model/Me;", "Lcom/kakao/sdk/friend/network/model/PickerFriends;", NativeProtocol.AUDIENCE_FRIENDS, "Lcom/kakao/sdk/friend/network/model/PickerFriends;", "b", "()Lcom/kakao/sdk/friend/network/model/PickerFriends;", "<init>", "(ZLcom/kakao/sdk/friend/network/model/Me;Lcom/kakao/sdk/friend/network/model/PickerFriends;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerUsers implements Parcelable {
    public static final Parcelable.Creator<PickerUsers> CREATOR = new Creator();
    private final boolean displayAllProfile;
    private final PickerFriends friends;
    private final C2225Me me;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerUsers(boolean z, C2225Me me, PickerFriends friends) {
        Intrinsics.checkNotNullParameter(me, "me");
        Intrinsics.checkNotNullParameter(friends, "friends");
        this.displayAllProfile = z;
        this.me = me;
        this.friends = friends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m663a() {
        return this.displayAllProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final PickerFriends m664b() {
        return this.friends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final C2225Me m665c() {
        return this.me;
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
        if (!(obj instanceof PickerUsers)) {
            return false;
        }
        PickerUsers pickerUsers = (PickerUsers) obj;
        return this.displayAllProfile == pickerUsers.displayAllProfile && Intrinsics.areEqual(this.me, pickerUsers.me) && Intrinsics.areEqual(this.friends, pickerUsers.friends);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        boolean z = this.displayAllProfile;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.me.hashCode()) * 31) + this.friends.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerUsers(displayAllProfile=" + this.displayAllProfile + ", me=" + this.me + ", friends=" + this.friends + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.displayAllProfile ? 1 : 0);
        this.me.writeToParcel(out, i);
        this.friends.writeToParcel(out, i);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerUsers> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerUsers createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickerUsers(parcel.readInt() != 0, C2225Me.CREATOR.createFromParcel(parcel), PickerFriends.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerUsers[] newArray(int i) {
            return new PickerUsers[i];
        }
    }
}
