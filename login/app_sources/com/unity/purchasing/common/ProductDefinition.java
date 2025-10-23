package com.unity.purchasing.common;

/* loaded from: classes3.dex */
public class ProductDefinition {

    /* renamed from: id */
    public String f1144id;
    public String storeSpecificId;
    public ProductType type;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProductDefinition(String str, String str2, ProductType productType) {
        this.f1144id = str;
        this.storeSpecificId = str2;
        this.type = productType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProductDefinition(String str, ProductType productType) {
        this(str, str, productType);
    }
}
