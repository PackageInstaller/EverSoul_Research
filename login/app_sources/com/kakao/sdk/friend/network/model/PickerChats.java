package com.kakao.sdk.friend.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m837bv = {}, m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, m839d2 = {"Lcom/kakao/sdk/friend/network/model/PickerChats;", "Landroid/os/Parcelable;", "", "totalCount", "I", "getTotalCount", "()I", "", "Lcom/kakao/sdk/friend/network/model/PickerChat;", Constants.ELEMENTS, "Ljava/util/List;", "a", "()Ljava/util/List;", "", "beforeUrl", "Ljava/lang/String;", "getBeforeUrl", "()Ljava/lang/String;", "afterUrl", "getAfterUrl", "<init>", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final /* data */ class PickerChats implements Parcelable {
    public static final Parcelable.Creator<PickerChats> CREATOR = new Creator();
    private final String afterUrl;
    private final String beforeUrl;
    private final List<PickerChat> elements;
    private final int totalCount;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PickerChats(int i, List<PickerChat> list, String str, String str2) {
        this.totalCount = i;
        this.elements = list;
        this.beforeUrl = str;
        this.afterUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final List<PickerChat> m643a() {
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
        if (!(obj instanceof PickerChats)) {
            return false;
        }
        PickerChats pickerChats = (PickerChats) obj;
        return this.totalCount == pickerChats.totalCount && Intrinsics.areEqual(this.elements, pickerChats.elements) && Intrinsics.areEqual(this.beforeUrl, pickerChats.beforeUrl) && Intrinsics.areEqual(this.afterUrl, pickerChats.afterUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.totalCount) * 31;
        List<PickerChat> list = this.elements;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.beforeUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.afterUrl;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PickerChats(totalCount=" + this.totalCount + ", elements=" + this.elements + ", beforeUrl=" + ((Object) this.beforeUrl) + ", afterUrl=" + ((Object) this.afterUrl) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.totalCount);
        List<PickerChat> list = this.elements;
        if (list == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(list.size());
            Iterator<PickerChat> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(out, i);
            }
        }
        out.writeString(this.beforeUrl);
        out.writeString(this.afterUrl);
    }

    @Metadata(m837bv = {}, m838d1 = {}, m839d2 = {}, m840k = 3, m841mv = {1, 6, 0})
    public static final class Creator implements Parcelable.Creator<PickerChats> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChats createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList2.add(PickerChat.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new PickerChats(readInt, arrayList, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public PickerChats[] newArray(int i) {
            return new PickerChats[i];
        }
    }
}
