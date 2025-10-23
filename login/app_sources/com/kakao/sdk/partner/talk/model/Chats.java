package com.kakao.sdk.partner.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.kakao.sdk.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chats.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/Chats;", "Landroid/os/Parcelable;", "totalCount", "", Constants.ELEMENTS, "", "Lcom/kakao/sdk/partner/talk/model/Chat;", "beforeUrl", "", "afterUrl", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAfterUrl", "()Ljava/lang/String;", "getBeforeUrl", "getElements", "()Ljava/util/List;", "getTotalCount", "()I", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Chats implements Parcelable {
    public static final Parcelable.Creator<Chats> CREATOR = new Creator();
    private final String afterUrl;
    private final String beforeUrl;
    private final List<Chat> elements;
    private final int totalCount;

    /* compiled from: Chats.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Chats> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Chats createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList2.add(Chat.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new Chats(readInt, arrayList, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Chats[] newArray(int i) {
            return new Chats[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Chats copy$default(Chats chats, int i, List list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = chats.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = chats.elements;
        }
        if ((i2 & 4) != 0) {
            str = chats.beforeUrl;
        }
        if ((i2 & 8) != 0) {
            str2 = chats.afterUrl;
        }
        return chats.copy(i, list, str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Chat> component2() {
        return this.elements;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component3() {
        return this.beforeUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.afterUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Chats copy(int totalCount, List<Chat> elements, String beforeUrl, String afterUrl) {
        return new Chats(totalCount, elements, beforeUrl, afterUrl);
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
        if (!(other instanceof Chats)) {
            return false;
        }
        Chats chats = (Chats) other;
        return this.totalCount == chats.totalCount && Intrinsics.areEqual(this.elements, chats.elements) && Intrinsics.areEqual(this.beforeUrl, chats.beforeUrl) && Intrinsics.areEqual(this.afterUrl, chats.afterUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.totalCount) * 31;
        List<Chat> list = this.elements;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.beforeUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.afterUrl;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Chats(totalCount=" + this.totalCount + ", elements=" + this.elements + ", beforeUrl=" + ((Object) this.beforeUrl) + ", afterUrl=" + ((Object) this.afterUrl) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.totalCount);
        List<Chat> list = this.elements;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Chat> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.beforeUrl);
        parcel.writeString(this.afterUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Chats(int i, List<Chat> list, String str, String str2) {
        this.totalCount = i;
        this.elements = list;
        this.beforeUrl = str;
        this.afterUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Chat> getElements() {
        return this.elements;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBeforeUrl() {
        return this.beforeUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAfterUrl() {
        return this.afterUrl;
    }
}
