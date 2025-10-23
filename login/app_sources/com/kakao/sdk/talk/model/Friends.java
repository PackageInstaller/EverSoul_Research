package com.kakao.sdk.talk.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.talk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Friends.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001)B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003JT\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, m839d2 = {"Lcom/kakao/sdk/talk/model/Friends;", "T", "Landroid/os/Parcelable;", "totalCount", "", Constants.ELEMENTS, "", "favoriteCount", "beforeUrl", "", "afterUrl", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAfterUrl", "()Ljava/lang/String;", "getBeforeUrl", "getElements", "()Ljava/util/List;", "getFavoriteCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalCount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/kakao/sdk/talk/model/Friends;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Friends<T extends Parcelable> implements Parcelable {
    private final String afterUrl;
    private final String beforeUrl;
    private final List<T> elements;
    private final Integer favoriteCount;
    private final int totalCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<Friends<T>> CREATOR = new Creator();

    /* compiled from: Friends.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Friends<T>> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Friends<T> createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i = 0; i != readInt2; i++) {
                    arrayList.add(parcel.readParcelable(Friends.class.getClassLoader()));
                }
            }
            return new Friends<>(readInt, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Friends<T>[] newArray(int i) {
            return new Friends[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Friends copy$default(Friends friends, int i, List list, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = friends.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = friends.elements;
        }
        List list2 = list;
        if ((i2 & 4) != 0) {
            num = friends.favoriteCount;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str = friends.beforeUrl;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = friends.afterUrl;
        }
        return friends.copy(i, list2, num2, str3, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<T> component2() {
        return this.elements;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component3() {
        return this.favoriteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component4() {
        return this.beforeUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.afterUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Friends<T> copy(int totalCount, List<? extends T> elements, Integer favoriteCount, String beforeUrl, String afterUrl) {
        return new Friends<>(totalCount, elements, favoriteCount, beforeUrl, afterUrl);
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
        if (!(other instanceof Friends)) {
            return false;
        }
        Friends friends = (Friends) other;
        return this.totalCount == friends.totalCount && Intrinsics.areEqual(this.elements, friends.elements) && Intrinsics.areEqual(this.favoriteCount, friends.favoriteCount) && Intrinsics.areEqual(this.beforeUrl, friends.beforeUrl) && Intrinsics.areEqual(this.afterUrl, friends.afterUrl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.totalCount) * 31;
        List<T> list = this.elements;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.favoriteCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.beforeUrl;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.afterUrl;
        return hashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Friends(totalCount=" + this.totalCount + ", elements=" + this.elements + ", favoriteCount=" + this.favoriteCount + ", beforeUrl=" + ((Object) this.beforeUrl) + ", afterUrl=" + ((Object) this.afterUrl) + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.totalCount);
        List<T> list = this.elements;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }
        Integer num = this.favoriteCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.beforeUrl);
        parcel.writeString(this.afterUrl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Friends(int i, List<? extends T> list, Integer num, String str, String str2) {
        this.totalCount = i;
        this.elements = list;
        this.favoriteCount = num;
        this.beforeUrl = str;
        this.afterUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<T> getElements() {
        return this.elements;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getFavoriteCount() {
        return this.favoriteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBeforeUrl() {
        return this.beforeUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAfterUrl() {
        return this.afterUrl;
    }

    /* compiled from: Friends.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/talk/model/Friends$Companion;", "", "()V", "fromJson", "Lcom/kakao/sdk/talk/model/Friends;", "T", "Landroid/os/Parcelable;", TypedValues.Custom.S_STRING, "", "clazz", "Ljava/lang/Class;", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final <T extends Parcelable> Friends<T> fromJson(String string, Class<T> clazz) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return (Friends) KakaoJson.INSTANCE.parameterizedFromJson(string, Friends.class, clazz);
        }
    }
}
