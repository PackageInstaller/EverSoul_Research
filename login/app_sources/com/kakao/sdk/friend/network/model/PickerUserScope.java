package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerUserScope;", "Landroid/os/Parcelable;", "", "id", "J", "b", "()J", "", "profileNickname", "Z", "d", "()Z", "profileImage", "c", NativeProtocol.AUDIENCE_FRIENDS, "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "<init>", "(JZZLjava/lang/Boolean;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerUserScope implements Parcelable {
    public static final Parcelable.Creator<PickerUserScope> CREATOR = new Creator();
    private final Boolean friends;
    private final long id;
    private final boolean profileImage;
    private final boolean profileNickname;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerUserScope(long j, boolean z, boolean z2, Boolean bool) {
        this.id = j;
        this.profileNickname = z;
        this.profileImage = z2;
        this.friends = bool;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Boolean m659a() {
        return this.friends;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final long m660b() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final boolean m661c() {
        return this.profileImage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public final boolean m662d() {
        return this.profileNickname;
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
        if (!(obj instanceof PickerUserScope)) {
            return false;
        }
        PickerUserScope pickerUserScope = (PickerUserScope) obj;
        return this.id == pickerUserScope.id && this.profileNickname == pickerUserScope.profileNickname && this.profileImage == pickerUserScope.profileImage && Intrinsics.areEqual(this.friends, pickerUserScope.friends);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        boolean z = this.profileNickname;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.profileImage;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        Boolean bool = this.friends;
        return i3 + (bool == null ? 0 : bool.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerUserScope(id=" + this.id + ", profileNickname=" + this.profileNickname + ", profileImage=" + this.profileImage + ", friends=" + this.friends + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.id);
        out.writeInt(this.profileNickname ? 1 : 0);
        out.writeInt(this.profileImage ? 1 : 0);
        Boolean bool = this.friends;
        if (bool == null) {
            i2 = 0;
        } else {
            out.writeInt(1);
            i2 = bool.booleanValue();
        }
        out.writeInt(i2);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerUserScope> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerUserScope createFromParcel(Parcel parcel) {
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new PickerUserScope(readLong, z, z2, valueOf);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerUserScope[] newArray(int i) {
            return new PickerUserScope[i];
        }
    }
}
