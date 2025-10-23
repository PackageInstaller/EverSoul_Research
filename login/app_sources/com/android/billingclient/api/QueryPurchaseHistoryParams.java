package com.android.billingclient.api;

import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class QueryPurchaseHistoryParams {
    private final String zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ QueryPurchaseHistoryParams(Builder builder, zzda zzdaVar) {
        this.zza = builder.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        return this.zza;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Builder {
        private String zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            throw null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zzda zzdaVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProductType(String str) {
            this.zza = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public QueryPurchaseHistoryParams build() {
            if (this.zza != null) {
                return new QueryPurchaseHistoryParams(this, null);
            }
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781572336));
        }
    }
}
