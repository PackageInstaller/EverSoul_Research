package com.unity.purchasing.common;

import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class ProductMetadata {
    public final String isoCurrencyCode;
    public final String localizedDescription;
    public final BigDecimal localizedPrice;
    public final String localizedPriceString;
    public final String localizedTitle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProductMetadata(String str, String str2, String str3, String str4, BigDecimal bigDecimal) {
        this.localizedPriceString = str == null ? "" : str;
        this.localizedTitle = str2;
        this.localizedDescription = str3;
        this.isoCurrencyCode = str4;
        this.localizedPrice = bigDecimal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "{ProductMetadata: localizedPriceString = " + this.localizedPriceString + ", localizedTitle = " + this.localizedTitle + ", localizedDescription = " + this.localizedDescription + ", isoCurrencyCode = " + this.isoCurrencyCode + ", localizedPrice = " + this.localizedPrice + ", }";
    }
}
