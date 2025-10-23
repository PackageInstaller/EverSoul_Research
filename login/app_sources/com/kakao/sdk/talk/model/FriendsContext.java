package com.kakao.sdk.talk.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.talk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Friends.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B?\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003JH\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00061"}, m839d2 = {"Lcom/kakao/sdk/talk/model/FriendsContext;", "Landroid/os/Parcelable;", "url", "", "(Ljava/lang/String;)V", "offset", "", "limit", Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/talk/model/FriendOrder;Ljava/lang/String;)V", "getFriendOrder", "()Lcom/kakao/sdk/talk/model/FriendOrder;", "setFriendOrder", "(Lcom/kakao/sdk/talk/model/FriendOrder;)V", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOffset", "setOffset", "getOrder", "()Lcom/kakao/sdk/talk/model/Order;", "setOrder", "(Lcom/kakao/sdk/talk/model/Order;)V", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/talk/model/FriendOrder;Ljava/lang/String;)Lcom/kakao/sdk/talk/model/FriendsContext;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FriendsContext implements Parcelable {
    public static final Parcelable.Creator<FriendsContext> CREATOR = new Creator();
    private FriendOrder friendOrder;
    private Integer limit;
    private Integer offset;
    private Order order;
    private final String url;

    /* compiled from: Friends.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<FriendsContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FriendsContext createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FriendsContext(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Order.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : FriendOrder.valueOf(parcel.readString()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final FriendsContext[] newArray(int i) {
            return new FriendsContext[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FriendsContext() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ FriendsContext copy$default(FriendsContext friendsContext, Integer num, Integer num2, Order order, FriendOrder friendOrder, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = friendsContext.offset;
        }
        if ((i & 2) != 0) {
            num2 = friendsContext.limit;
        }
        Integer num3 = num2;
        if ((i & 4) != 0) {
            order = friendsContext.order;
        }
        Order order2 = order;
        if ((i & 8) != 0) {
            friendOrder = friendsContext.friendOrder;
        }
        FriendOrder friendOrder2 = friendOrder;
        if ((i & 16) != 0) {
            str = friendsContext.url;
        }
        return friendsContext.copy(num, num3, order2, friendOrder2, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component1() {
        return this.offset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component2() {
        return this.limit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Order component3() {
        return this.order;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendOrder component4() {
        return this.friendOrder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendsContext copy(Integer offset, Integer limit, Order order, FriendOrder friendOrder, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new FriendsContext(offset, limit, order, friendOrder, url);
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
        if (!(other instanceof FriendsContext)) {
            return false;
        }
        FriendsContext friendsContext = (FriendsContext) other;
        return Intrinsics.areEqual(this.offset, friendsContext.offset) && Intrinsics.areEqual(this.limit, friendsContext.limit) && this.order == friendsContext.order && this.friendOrder == friendsContext.friendOrder && Intrinsics.areEqual(this.url, friendsContext.url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.offset;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.limit;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Order order = this.order;
        int hashCode3 = (hashCode2 + (order == null ? 0 : order.hashCode())) * 31;
        FriendOrder friendOrder = this.friendOrder;
        return ((hashCode3 + (friendOrder != null ? friendOrder.hashCode() : 0)) * 31) + this.url.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "FriendsContext(offset=" + this.offset + ", limit=" + this.limit + ", order=" + this.order + ", friendOrder=" + this.friendOrder + ", url=" + this.url + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.offset;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.limit;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Order order = this.order;
        if (order == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(order.name());
        }
        FriendOrder friendOrder = this.friendOrder;
        if (friendOrder == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(friendOrder.name());
        }
        parcel.writeString(this.url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FriendsContext(Integer num, Integer num2, Order order, FriendOrder friendOrder, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.offset = num;
        this.limit = num2;
        this.order = order;
        this.friendOrder = friendOrder;
        this.url = url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ FriendsContext(Integer num, Integer num2, Order order, FriendOrder friendOrder, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : order, (i & 8) == 0 ? friendOrder : null, (i & 16) != 0 ? "" : str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getOffset() {
        return this.offset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setOffset(Integer num) {
        this.offset = num;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getLimit() {
        return this.limit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setLimit(Integer num) {
        this.limit = num;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Order getOrder() {
        return this.order;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setOrder(Order order) {
        this.order = order;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendOrder getFriendOrder() {
        return this.friendOrder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFriendOrder(FriendOrder friendOrder) {
        this.friendOrder = friendOrder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FriendsContext(String url) throws IllegalArgumentException {
        this(null, null, null, null, null, 16, null);
        Order order;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        if (parse == null) {
            throw new IllegalArgumentException();
        }
        String queryParameter = parse.getQueryParameter("offset");
        FriendOrder friendOrder = null;
        this.offset = queryParameter == null ? null : Integer.valueOf(Integer.parseInt(queryParameter));
        String queryParameter2 = parse.getQueryParameter("limit");
        this.limit = queryParameter2 == null ? null : Integer.valueOf(Integer.parseInt(queryParameter2));
        String queryParameter3 = parse.getQueryParameter(Constants.ORDER);
        int i = 0;
        if (queryParameter3 != null) {
            try {
                Order[] values = Order.values();
                int length = values.length;
                int i2 = 0;
                while (i2 < length) {
                    order = values[i2];
                    i2++;
                    SerializedName serializedName = (SerializedName) order.getClass().getField(order.name()).getAnnotation(SerializedName.class);
                    if (Intrinsics.areEqual(serializedName == null ? null : serializedName.value(), queryParameter3)) {
                        break;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        order = null;
        this.order = order;
        String queryParameter4 = parse.getQueryParameter(Constants.FRIEND_ORDER);
        if (queryParameter4 != null) {
            try {
                FriendOrder[] values2 = FriendOrder.values();
                int length2 = values2.length;
                while (true) {
                    if (i >= length2) {
                        break;
                    }
                    FriendOrder friendOrder2 = values2[i];
                    i++;
                    SerializedName serializedName2 = (SerializedName) friendOrder2.getClass().getField(friendOrder2.name()).getAnnotation(SerializedName.class);
                    if (Intrinsics.areEqual(serializedName2 == null ? null : serializedName2.value(), queryParameter4)) {
                        friendOrder = friendOrder2;
                        break;
                    }
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        this.friendOrder = friendOrder;
    }
}
