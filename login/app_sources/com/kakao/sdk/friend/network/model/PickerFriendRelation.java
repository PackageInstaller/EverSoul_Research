package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerFriendRelation;", "Landroid/os/Parcelable;", "Lcom/kakao/sdk/friend/network/model/PickerRelation;", "talk", "Lcom/kakao/sdk/friend/network/model/PickerRelation;", "b", "()Lcom/kakao/sdk/friend/network/model/PickerRelation;", "story", "a", "<init>", "(Lcom/kakao/sdk/friend/network/model/PickerRelation;Lcom/kakao/sdk/friend/network/model/PickerRelation;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerFriendRelation implements Parcelable {
    public static final Parcelable.Creator<PickerFriendRelation> CREATOR = new Creator();
    private final PickerRelation story;
    private final PickerRelation talk;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PickerFriendRelation() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1)
            return
            fill-array 0x0006: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.friend.network.model.PickerFriendRelation.<init>():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriendRelation(PickerRelation pickerRelation, PickerRelation pickerRelation2) {
        this.talk = pickerRelation;
        this.story = pickerRelation2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PickerFriendRelation(PickerRelation pickerRelation, PickerRelation pickerRelation2, int i) {
        this(null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final PickerRelation m656a() {
        return this.story;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final PickerRelation m657b() {
        return this.talk;
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
        if (!(obj instanceof PickerFriendRelation)) {
            return false;
        }
        PickerFriendRelation pickerFriendRelation = (PickerFriendRelation) obj;
        return this.talk == pickerFriendRelation.talk && this.story == pickerFriendRelation.story;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        PickerRelation pickerRelation = this.talk;
        int hashCode = (pickerRelation == null ? 0 : pickerRelation.hashCode()) * 31;
        PickerRelation pickerRelation2 = this.story;
        return hashCode + (pickerRelation2 != null ? pickerRelation2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerFriendRelation(talk=" + this.talk + ", story=" + this.story + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        PickerRelation pickerRelation = this.talk;
        if (pickerRelation == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(pickerRelation.name());
        }
        PickerRelation pickerRelation2 = this.story;
        if (pickerRelation2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeString(pickerRelation2.name());
        }
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerFriendRelation> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriendRelation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickerFriendRelation(parcel.readInt() == 0 ? null : PickerRelation.valueOf(parcel.readString()), parcel.readInt() != 0 ? PickerRelation.valueOf(parcel.readString()) : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriendRelation[] newArray(int i) {
            return new PickerFriendRelation[i];
        }
    }
}
