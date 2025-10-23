package com.android.billingclient.api;

import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class PendingPurchasesParams {
    private final boolean enableOneTimeProducts;
    private final boolean enablePrepaidPlans;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PendingPurchasesParams(boolean z, boolean z2) {
        this.enableOneTimeProducts = z;
        this.enablePrepaidPlans = z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isEnabledForOneTimeProducts() {
        return this.enableOneTimeProducts;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isEnabledForPrepaidPlans() {
        return this.enablePrepaidPlans;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class Builder {
        private boolean enableOneTimeProducts;
        private boolean enablePrepaidPlans;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder enableOneTimeProducts() {
            this.enableOneTimeProducts = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder enablePrepaidPlans() {
            this.enablePrepaidPlans = true;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PendingPurchasesParams build() {
            if (!this.enableOneTimeProducts) {
                throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512944167));
            }
            return new PendingPurchasesParams(true, this.enablePrepaidPlans);
        }
    }
}
