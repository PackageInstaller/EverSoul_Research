package com.google.android.datatransport;

/* loaded from: classes.dex */
final class AutoValue_ProductData extends ProductData {
    private final Integer productId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_ProductData(Integer num) {
        this.productId = num;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.ProductData
    public Integer getProductId() {
        return this.productId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "ProductData{productId=" + this.productId + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        Integer num = this.productId;
        Integer productId = ((ProductData) obj).getProductId();
        return num == null ? productId == null : num.equals(productId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Integer num = this.productId;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }
}
