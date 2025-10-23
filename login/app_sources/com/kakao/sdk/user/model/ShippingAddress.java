package com.kakao.sdk.user.model;

import com.google.gson.annotations.JsonAdapter;
import com.kakao.sdk.common.json.KakaoIntDateTypeAdapter;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserShippingAddresses.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0095\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00066"}, m839d2 = {"Lcom/kakao/sdk/user/model/ShippingAddress;", "", "id", "", "name", "", "isDefault", "", "updatedAt", "Ljava/util/Date;", "type", "Lcom/kakao/sdk/user/model/ShippingAddressType;", "baseAddress", "detailAddress", "receiverName", "receiverPhoneNumber1", "receiverPhoneNumber2", "zoneNumber", "zipCode", "(JLjava/lang/String;ZLjava/util/Date;Lcom/kakao/sdk/user/model/ShippingAddressType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseAddress", "()Ljava/lang/String;", "getDetailAddress", "getId", "()J", "()Z", "getName", "getReceiverName", "getReceiverPhoneNumber1", "getReceiverPhoneNumber2", "getType", "()Lcom/kakao/sdk/user/model/ShippingAddressType;", "getUpdatedAt", "()Ljava/util/Date;", "getZipCode", "getZoneNumber", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ShippingAddress {
    private final String baseAddress;
    private final String detailAddress;
    private final long id;
    private final boolean isDefault;
    private final String name;
    private final String receiverName;
    private final String receiverPhoneNumber1;
    private final String receiverPhoneNumber2;
    private final ShippingAddressType type;

    @JsonAdapter(KakaoIntDateTypeAdapter.class)
    private final Date updatedAt;
    private final String zipCode;
    private final String zoneNumber;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long component1() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component10() {
        return this.receiverPhoneNumber2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component11() {
        return this.zoneNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component12() {
        return this.zipCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component2() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean component3() {
        return this.isDefault;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date component4() {
        return this.updatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ShippingAddressType component5() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component6() {
        return this.baseAddress;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component7() {
        return this.detailAddress;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component8() {
        return this.receiverName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component9() {
        return this.receiverPhoneNumber1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ShippingAddress copy(long id, String name, boolean isDefault, Date updatedAt, ShippingAddressType type, String baseAddress, String detailAddress, String receiverName, String receiverPhoneNumber1, String receiverPhoneNumber2, String zoneNumber, String zipCode) {
        return new ShippingAddress(id, name, isDefault, updatedAt, type, baseAddress, detailAddress, receiverName, receiverPhoneNumber1, receiverPhoneNumber2, zoneNumber, zipCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShippingAddress)) {
            return false;
        }
        ShippingAddress shippingAddress = (ShippingAddress) other;
        return this.id == shippingAddress.id && Intrinsics.areEqual(this.name, shippingAddress.name) && this.isDefault == shippingAddress.isDefault && Intrinsics.areEqual(this.updatedAt, shippingAddress.updatedAt) && this.type == shippingAddress.type && Intrinsics.areEqual(this.baseAddress, shippingAddress.baseAddress) && Intrinsics.areEqual(this.detailAddress, shippingAddress.detailAddress) && Intrinsics.areEqual(this.receiverName, shippingAddress.receiverName) && Intrinsics.areEqual(this.receiverPhoneNumber1, shippingAddress.receiverPhoneNumber1) && Intrinsics.areEqual(this.receiverPhoneNumber2, shippingAddress.receiverPhoneNumber2) && Intrinsics.areEqual(this.zoneNumber, shippingAddress.zoneNumber) && Intrinsics.areEqual(this.zipCode, shippingAddress.zipCode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.isDefault;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        Date date = this.updatedAt;
        int hashCode3 = (i2 + (date == null ? 0 : date.hashCode())) * 31;
        ShippingAddressType shippingAddressType = this.type;
        int hashCode4 = (hashCode3 + (shippingAddressType == null ? 0 : shippingAddressType.hashCode())) * 31;
        String str2 = this.baseAddress;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.detailAddress;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.receiverName;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.receiverPhoneNumber1;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.receiverPhoneNumber2;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.zoneNumber;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.zipCode;
        return hashCode10 + (str8 != null ? str8.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("ShippingAddress(id=");
        sb.append(this.id).append(", name=").append((Object) this.name).append(", isDefault=").append(this.isDefault).append(", updatedAt=").append(this.updatedAt).append(", type=").append(this.type).append(", baseAddress=").append((Object) this.baseAddress).append(", detailAddress=").append((Object) this.detailAddress).append(", receiverName=").append((Object) this.receiverName).append(", receiverPhoneNumber1=").append((Object) this.receiverPhoneNumber1).append(", receiverPhoneNumber2=").append((Object) this.receiverPhoneNumber2).append(", zoneNumber=").append((Object) this.zoneNumber).append(", zipCode=");
        sb.append((Object) this.zipCode).append(')');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShippingAddress(long j, String str, boolean z, Date date, ShippingAddressType shippingAddressType, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.id = j;
        this.name = str;
        this.isDefault = z;
        this.updatedAt = date;
        this.type = shippingAddressType;
        this.baseAddress = str2;
        this.detailAddress = str3;
        this.receiverName = str4;
        this.receiverPhoneNumber1 = str5;
        this.receiverPhoneNumber2 = str6;
        this.zoneNumber = str7;
        this.zipCode = str8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isDefault() {
        return this.isDefault;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ShippingAddressType getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBaseAddress() {
        return this.baseAddress;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDetailAddress() {
        return this.detailAddress;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getReceiverName() {
        return this.receiverName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getReceiverPhoneNumber1() {
        return this.receiverPhoneNumber1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getReceiverPhoneNumber2() {
        return this.receiverPhoneNumber2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getZoneNumber() {
        return this.zoneNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getZipCode() {
        return this.zipCode;
    }
}
