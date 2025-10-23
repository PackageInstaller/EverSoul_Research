package com.google.android.datatransport;

/* loaded from: classes.dex */
public abstract class ProductData {
    public abstract Integer getProductId();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ProductData withProductId(Integer num) {
        return new AutoValue_ProductData(num);
    }
}
