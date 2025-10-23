package com.kakao.sdk.partner.talk.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.talk.Constants;
import com.kakao.sdk.talk.model.FriendOrder;
import com.kakao.sdk.talk.model.Order;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Friend.kt */
@Metadata(m838d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bi\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\u0010\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003Jr\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00109J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>HÖ\u0003J\t\u0010?\u001a\u00020\u0006HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\u0019\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006F"}, m839d2 = {"Lcom/kakao/sdk/partner/talk/model/PartnerFriendsContext;", "Landroid/os/Parcelable;", "url", "", "(Ljava/lang/String;)V", "offset", "", "limit", Constants.ORDER, "Lcom/kakao/sdk/talk/model/Order;", "friendType", "Lcom/kakao/sdk/partner/talk/model/FriendType;", "friendOrder", "Lcom/kakao/sdk/talk/model/FriendOrder;", "friendFilter", "Lcom/kakao/sdk/partner/talk/model/FriendFilter;", "countryCodes", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/partner/talk/model/FriendType;Lcom/kakao/sdk/talk/model/FriendOrder;Lcom/kakao/sdk/partner/talk/model/FriendFilter;Ljava/util/List;Ljava/lang/String;)V", "getCountryCodes", "()Ljava/util/List;", "setCountryCodes", "(Ljava/util/List;)V", "getFriendFilter", "()Lcom/kakao/sdk/partner/talk/model/FriendFilter;", "setFriendFilter", "(Lcom/kakao/sdk/partner/talk/model/FriendFilter;)V", "getFriendOrder", "()Lcom/kakao/sdk/talk/model/FriendOrder;", "setFriendOrder", "(Lcom/kakao/sdk/talk/model/FriendOrder;)V", "getFriendType", "()Lcom/kakao/sdk/partner/talk/model/FriendType;", "setFriendType", "(Lcom/kakao/sdk/partner/talk/model/FriendType;)V", "getLimit", "()Ljava/lang/Integer;", "setLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getOffset", "setOffset", "getOrder", "()Lcom/kakao/sdk/talk/model/Order;", "setOrder", "(Lcom/kakao/sdk/talk/model/Order;)V", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Lcom/kakao/sdk/talk/model/Order;Lcom/kakao/sdk/partner/talk/model/FriendType;Lcom/kakao/sdk/talk/model/FriendOrder;Lcom/kakao/sdk/partner/talk/model/FriendFilter;Ljava/util/List;Ljava/lang/String;)Lcom/kakao/sdk/partner/talk/model/PartnerFriendsContext;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "partner-talk_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PartnerFriendsContext implements Parcelable {
    public static final Parcelable.Creator<PartnerFriendsContext> CREATOR = new Creator();
    private List<String> countryCodes;
    private FriendFilter friendFilter;
    private FriendOrder friendOrder;
    private FriendType friendType;
    private Integer limit;
    private Integer offset;
    private Order order;
    private final String url;

    /* compiled from: Friend.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<PartnerFriendsContext> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerFriendsContext createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PartnerFriendsContext(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Order.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : FriendType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : FriendOrder.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : FriendFilter.valueOf(parcel.readString()), parcel.createStringArrayList(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final PartnerFriendsContext[] newArray(int i) {
            return new PartnerFriendsContext[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerFriendsContext() {
        this(null, null, null, null, null, null, null, null, 255, null);
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
    public final FriendType component4() {
        return this.friendType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendOrder component5() {
        return this.friendOrder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FriendFilter component6() {
        return this.friendFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> component7() {
        return this.countryCodes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component8() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PartnerFriendsContext copy(Integer offset, Integer limit, Order order, FriendType friendType, FriendOrder friendOrder, FriendFilter friendFilter, List<String> countryCodes, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new PartnerFriendsContext(offset, limit, order, friendType, friendOrder, friendFilter, countryCodes, url);
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
        if (!(other instanceof PartnerFriendsContext)) {
            return false;
        }
        PartnerFriendsContext partnerFriendsContext = (PartnerFriendsContext) other;
        return Intrinsics.areEqual(this.offset, partnerFriendsContext.offset) && Intrinsics.areEqual(this.limit, partnerFriendsContext.limit) && this.order == partnerFriendsContext.order && this.friendType == partnerFriendsContext.friendType && this.friendOrder == partnerFriendsContext.friendOrder && this.friendFilter == partnerFriendsContext.friendFilter && Intrinsics.areEqual(this.countryCodes, partnerFriendsContext.countryCodes) && Intrinsics.areEqual(this.url, partnerFriendsContext.url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.offset;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.limit;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Order order = this.order;
        int hashCode3 = (hashCode2 + (order == null ? 0 : order.hashCode())) * 31;
        FriendType friendType = this.friendType;
        int hashCode4 = (hashCode3 + (friendType == null ? 0 : friendType.hashCode())) * 31;
        FriendOrder friendOrder = this.friendOrder;
        int hashCode5 = (hashCode4 + (friendOrder == null ? 0 : friendOrder.hashCode())) * 31;
        FriendFilter friendFilter = this.friendFilter;
        int hashCode6 = (hashCode5 + (friendFilter == null ? 0 : friendFilter.hashCode())) * 31;
        List<String> list = this.countryCodes;
        return ((hashCode6 + (list != null ? list.hashCode() : 0)) * 31) + this.url.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PartnerFriendsContext(offset=" + this.offset + ", limit=" + this.limit + ", order=" + this.order + ", friendType=" + this.friendType + ", friendOrder=" + this.friendOrder + ", friendFilter=" + this.friendFilter + ", countryCodes=" + this.countryCodes + ", url=" + this.url + ')';
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
        FriendType friendType = this.friendType;
        if (friendType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(friendType.name());
        }
        FriendOrder friendOrder = this.friendOrder;
        if (friendOrder == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(friendOrder.name());
        }
        FriendFilter friendFilter = this.friendFilter;
        if (friendFilter == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(friendFilter.name());
        }
        parcel.writeStringList(this.countryCodes);
        parcel.writeString(this.url);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerFriendsContext(Integer num, Integer num2, Order order, FriendType friendType, FriendOrder friendOrder, FriendFilter friendFilter, List<String> list, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.offset = num;
        this.limit = num2;
        this.order = order;
        this.friendType = friendType;
        this.friendOrder = friendOrder;
        this.friendFilter = friendFilter;
        this.countryCodes = list;
        this.url = url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PartnerFriendsContext(Integer num, Integer num2, Order order, FriendType friendType, FriendOrder friendOrder, FriendFilter friendFilter, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : order, (i & 8) != 0 ? null : friendType, (i & 16) != 0 ? null : friendOrder, (i & 32) != 0 ? null : friendFilter, (i & 64) == 0 ? list : null, (i & 128) != 0 ? "" : str);
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
    public final FriendType getFriendType() {
        return this.friendType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFriendType(FriendType friendType) {
        this.friendType = friendType;
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
    public final FriendFilter getFriendFilter() {
        return this.friendFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFriendFilter(FriendFilter friendFilter) {
        this.friendFilter = friendFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getCountryCodes() {
        return this.countryCodes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCountryCodes(List<String> list) {
        this.countryCodes = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PartnerFriendsContext(String url) throws IllegalArgumentException {
        this(null, null, null, null, null, null, null, null, 136, null);
        Order order;
        FriendType friendType;
        FriendOrder friendOrder;
        FriendFilter friendFilter;
        Intrinsics.checkNotNullParameter(url, "url");
        Uri parse = Uri.parse(url);
        if (parse == null) {
            throw new IllegalArgumentException();
        }
        String queryParameter = parse.getQueryParameter("offset");
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
        String queryParameter4 = parse.getQueryParameter(Constants.FRIEND_TYPE);
        if (queryParameter4 != null) {
            try {
                FriendType[] values2 = FriendType.values();
                int length2 = values2.length;
                int i3 = 0;
                while (i3 < length2) {
                    friendType = values2[i3];
                    i3++;
                    SerializedName serializedName2 = (SerializedName) friendType.getClass().getField(friendType.name()).getAnnotation(SerializedName.class);
                    if (Intrinsics.areEqual(serializedName2 == null ? null : serializedName2.value(), queryParameter4)) {
                        break;
                    }
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        friendType = null;
        this.friendType = friendType;
        String queryParameter5 = parse.getQueryParameter(Constants.FRIEND_ORDER);
        if (queryParameter5 != null) {
            try {
                FriendOrder[] values3 = FriendOrder.values();
                int length3 = values3.length;
                int i4 = 0;
                while (i4 < length3) {
                    friendOrder = values3[i4];
                    i4++;
                    SerializedName serializedName3 = (SerializedName) friendOrder.getClass().getField(friendOrder.name()).getAnnotation(SerializedName.class);
                    if (Intrinsics.areEqual(serializedName3 == null ? null : serializedName3.value(), queryParameter5)) {
                        break;
                    }
                }
            } catch (IllegalArgumentException unused3) {
            }
        }
        friendOrder = null;
        this.friendOrder = friendOrder;
        String queryParameter6 = parse.getQueryParameter(Constants.FRIEND_FILTER);
        if (queryParameter6 != null) {
            try {
                FriendFilter[] values4 = FriendFilter.values();
                int length4 = values4.length;
                while (i < length4) {
                    friendFilter = values4[i];
                    i++;
                    SerializedName serializedName4 = (SerializedName) friendFilter.getClass().getField(friendFilter.name()).getAnnotation(SerializedName.class);
                    if (Intrinsics.areEqual(serializedName4 == null ? null : serializedName4.value(), queryParameter6)) {
                        break;
                    }
                }
            } catch (IllegalArgumentException unused4) {
            }
        }
        friendFilter = null;
        this.friendFilter = friendFilter;
        String queryParameter7 = parse.getQueryParameter(Constants.COUNTRY_CODES);
        this.countryCodes = queryParameter7 != null ? StringsKt.split$default((CharSequence) queryParameter7, new String[]{","}, false, 0, 6, (Object) null) : null;
    }
}
