package com.unity.purchasing.common;

/* loaded from: classes3.dex */
public class ProductDescription {
    public final ProductMetadata metadata;
    public final String receipt;
    public final String storeSpecificId;
    public final String transactionId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProductDescription(String str, ProductMetadata productMetadata, String str2, String str3) {
        this.storeSpecificId = str;
        this.metadata = productMetadata;
        this.receipt = str2;
        this.transactionId = str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "{ProductDescription: storeSpecificId = " + this.storeSpecificId + ", metadata = " + this.metadata + ", receipt = " + this.receipt + ", transactionId = " + this.transactionId + ", }";
    }
}
