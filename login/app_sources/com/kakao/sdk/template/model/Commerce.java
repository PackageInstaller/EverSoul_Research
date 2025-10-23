package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Components.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ`\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\u0003HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, m839d2 = {"Lcom/kakao/sdk/template/model/Commerce;", "Landroid/os/Parcelable;", "regularPrice", "", "discountPrice", "fixedDiscountPrice", "discountRate", "productName", "", "currencyUnit", "currencyUnitPosition", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCurrencyUnit", "()Ljava/lang/String;", "getCurrencyUnitPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDiscountPrice", "getDiscountRate", "getFixedDiscountPrice", "getProductName", "getRegularPrice", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Commerce;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Commerce implements Parcelable {
    public static final Parcelable.Creator<Commerce> CREATOR = new Creator();
    private final String currencyUnit;
    private final Integer currencyUnitPosition;
    private final Integer discountPrice;
    private final Integer discountRate;
    private final Integer fixedDiscountPrice;
    private final String productName;
    private final int regularPrice;

    /* compiled from: Components.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Creator implements Parcelable.Creator<Commerce> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Commerce createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Commerce(parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public final Commerce[] newArray(int i) {
            return new Commerce[i];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i) {
        this(i, null, null, null, null, null, null, 126, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num) {
        this(i, num, null, null, null, null, null, 124, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num, Integer num2) {
        this(i, num, num2, null, null, null, null, 120, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num, Integer num2, Integer num3) {
        this(i, num, num2, num3, null, null, null, 112, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num, Integer num2, Integer num3, String str) {
        this(i, num, num2, num3, str, null, null, 96, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num, Integer num2, Integer num3, String str, String str2) {
        this(i, num, num2, num3, str, str2, null, 64, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Commerce copy$default(Commerce commerce, int i, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = commerce.regularPrice;
        }
        if ((i2 & 2) != 0) {
            num = commerce.discountPrice;
        }
        Integer num5 = num;
        if ((i2 & 4) != 0) {
            num2 = commerce.fixedDiscountPrice;
        }
        Integer num6 = num2;
        if ((i2 & 8) != 0) {
            num3 = commerce.discountRate;
        }
        Integer num7 = num3;
        if ((i2 & 16) != 0) {
            str = commerce.productName;
        }
        String str3 = str;
        if ((i2 & 32) != 0) {
            str2 = commerce.currencyUnit;
        }
        String str4 = str2;
        if ((i2 & 64) != 0) {
            num4 = commerce.currencyUnitPosition;
        }
        return commerce.copy(i, num5, num6, num7, str3, str4, num4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int component1() {
        return this.regularPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component2() {
        return this.discountPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component3() {
        return this.fixedDiscountPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component4() {
        return this.discountRate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component5() {
        return this.productName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String component6() {
        return this.currencyUnit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer component7() {
        return this.currencyUnitPosition;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Commerce copy(int regularPrice, Integer discountPrice, Integer fixedDiscountPrice, Integer discountRate, String productName, String currencyUnit, Integer currencyUnitPosition) {
        return new Commerce(regularPrice, discountPrice, fixedDiscountPrice, discountRate, productName, currencyUnit, currencyUnitPosition);
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
        if (!(other instanceof Commerce)) {
            return false;
        }
        Commerce commerce = (Commerce) other;
        return this.regularPrice == commerce.regularPrice && Intrinsics.areEqual(this.discountPrice, commerce.discountPrice) && Intrinsics.areEqual(this.fixedDiscountPrice, commerce.fixedDiscountPrice) && Intrinsics.areEqual(this.discountRate, commerce.discountRate) && Intrinsics.areEqual(this.productName, commerce.productName) && Intrinsics.areEqual(this.currencyUnit, commerce.currencyUnit) && Intrinsics.areEqual(this.currencyUnitPosition, commerce.currencyUnitPosition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = Integer.hashCode(this.regularPrice) * 31;
        Integer num = this.discountPrice;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.fixedDiscountPrice;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.discountRate;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.productName;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currencyUnit;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num4 = this.currencyUnitPosition;
        return hashCode6 + (num4 != null ? num4.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Commerce(regularPrice=" + this.regularPrice + ", discountPrice=" + this.discountPrice + ", fixedDiscountPrice=" + this.fixedDiscountPrice + ", discountRate=" + this.discountRate + ", productName=" + ((Object) this.productName) + ", currencyUnit=" + ((Object) this.currencyUnit) + ", currencyUnitPosition=" + this.currencyUnitPosition + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.regularPrice);
        Integer num = this.discountPrice;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.fixedDiscountPrice;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.discountRate;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.productName);
        parcel.writeString(this.currencyUnit);
        Integer num4 = this.currencyUnitPosition;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Commerce(int i, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4) {
        this.regularPrice = i;
        this.discountPrice = num;
        this.fixedDiscountPrice = num2;
        this.discountRate = num3;
        this.productName = str;
        this.currencyUnit = str2;
        this.currencyUnitPosition = num4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ Commerce(int i, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) == 0 ? num4 : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRegularPrice() {
        return this.regularPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getDiscountPrice() {
        return this.discountPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getFixedDiscountPrice() {
        return this.fixedDiscountPrice;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getDiscountRate() {
        return this.discountRate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProductName() {
        return this.productName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCurrencyUnit() {
        return this.currencyUnit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getCurrencyUnitPosition() {
        return this.currencyUnitPosition;
    }
}
