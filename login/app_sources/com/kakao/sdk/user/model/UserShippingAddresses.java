package com.kakao.sdk.user.model;

import com.google.gson.annotations.SerializedName;
import com.kakao.sdk.user.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserShippingAddresses.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J8\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m839d2 = {"Lcom/kakao/sdk/user/model/UserShippingAddresses;", "", "userId", "", "needsAgreement", "", "shippingAddresses", "", "Lcom/kakao/sdk/user/model/ShippingAddress;", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)V", "getNeedsAgreement", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShippingAddresses", "()Ljava/util/List;", "getUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;)Lcom/kakao/sdk/user/model/UserShippingAddresses;", "equals", "other", "hashCode", "", "toString", "", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserShippingAddresses {

    @SerializedName(Constants.SHIPPING_ADDRESSES_NEEDS_AGREEMENT)
    private final Boolean needsAgreement;
    private final List<ShippingAddress> shippingAddresses;
    private final Long userId;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ UserShippingAddresses copy$default(UserShippingAddresses userShippingAddresses, Long l, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = userShippingAddresses.userId;
        }
        if ((i & 2) != 0) {
            bool = userShippingAddresses.needsAgreement;
        }
        if ((i & 4) != 0) {
            list = userShippingAddresses.shippingAddresses;
        }
        return userShippingAddresses.copy(l, bool, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long component1() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean component2() {
        return this.needsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ShippingAddress> component3() {
        return this.shippingAddresses;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final UserShippingAddresses copy(Long userId, Boolean needsAgreement, List<ShippingAddress> shippingAddresses) {
        return new UserShippingAddresses(userId, needsAgreement, shippingAddresses);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserShippingAddresses)) {
            return false;
        }
        UserShippingAddresses userShippingAddresses = (UserShippingAddresses) other;
        return Intrinsics.areEqual(this.userId, userShippingAddresses.userId) && Intrinsics.areEqual(this.needsAgreement, userShippingAddresses.needsAgreement) && Intrinsics.areEqual(this.shippingAddresses, userShippingAddresses.shippingAddresses);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Long l = this.userId;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Boolean bool = this.needsAgreement;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        List<ShippingAddress> list = this.shippingAddresses;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "UserShippingAddresses(userId=" + this.userId + ", needsAgreement=" + this.needsAgreement + ", shippingAddresses=" + this.shippingAddresses + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserShippingAddresses(Long l, Boolean bool, List<ShippingAddress> list) {
        this.userId = l;
        this.needsAgreement = bool;
        this.shippingAddresses = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getNeedsAgreement() {
        return this.needsAgreement;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<ShippingAddress> getShippingAddresses() {
        return this.shippingAddresses;
    }
}
