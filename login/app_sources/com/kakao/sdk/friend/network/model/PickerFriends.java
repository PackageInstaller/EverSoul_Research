package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerFriends;", "Landroid/os/Parcelable;", "", "totalCount", "I", "getTotalCount", "()I", "", "Lcom/kakao/sdk/friend/network/model/PickerFriend;", Constants.ELEMENTS, "Ljava/util/List;", "a", "()Ljava/util/List;", "favoriteCount", "getFavoriteCount", "", "beforeUrl", "Ljava/lang/String;", "getBeforeUrl", "()Ljava/lang/String;", "afterUrl", "getAfterUrl", "<init>", "(ILjava/util/List;ILjava/lang/String;Ljava/lang/String;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerFriends implements Parcelable {
    public static final Parcelable.Creator<PickerFriends> CREATOR = new Creator();
    private final String afterUrl;
    private final String beforeUrl;
    private final List<PickerFriend> elements;
    private final int favoriteCount;
    private final int totalCount;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerFriends(int i, List<PickerFriend> list, int i2, String str, String str2) {
        this.totalCount = i;
        this.elements = list;
        this.favoriteCount = i2;
        this.beforeUrl = str;
        this.afterUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final List<PickerFriend> m658a() {
        return this.elements;
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
        if (!(obj instanceof PickerFriends)) {
            return false;
        }
        PickerFriends pickerFriends = (PickerFriends) obj;
        return this.totalCount == pickerFriends.totalCount && Intrinsics.areEqual(this.elements, pickerFriends.elements) && this.favoriteCount == pickerFriends.favoriteCount && Intrinsics.areEqual(this.beforeUrl, pickerFriends.beforeUrl) && Intrinsics.areEqual(this.afterUrl, pickerFriends.afterUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.totalCount) * 31;
        List<PickerFriend> list = this.elements;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.favoriteCount)) * 31;
        String str = this.beforeUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.afterUrl;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerFriends(totalCount=" + this.totalCount + ", elements=" + this.elements + ", favoriteCount=" + this.favoriteCount + ", beforeUrl=" + ((Object) this.beforeUrl) + ", afterUrl=" + ((Object) this.afterUrl) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.totalCount);
        List<PickerFriend> list = this.elements;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PickerFriend> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i);
            }
        }
        out.writeInt(this.favoriteCount);
        out.writeString(this.beforeUrl);
        out.writeString(this.afterUrl);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerFriends> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriends createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList2.add(PickerFriend.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PickerFriends(readInt, arrayList, parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerFriends[] newArray(int i) {
            return new PickerFriends[i];
        }
    }
}
