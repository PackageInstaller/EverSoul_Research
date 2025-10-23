package com.android.billingclient.api;

import com.liapp.y;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class QueryProductDetailsParams {
    private final com.google.android.gms.internal.play_billing.zzco zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ QueryProductDetailsParams(Builder builder, zzcz zzczVar) {
        this.zza = builder.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final com.google.android.gms.internal.play_billing.zzco zza() {
        return this.zza;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Product {
        private final String zza;
        private final String zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Product(Builder builder, zzcz zzczVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return new Builder(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zza() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzb() {
            return this.zzb;
        }

        /* compiled from: com.android.billingclient:billing@@7.1.1 */
        public static class Builder {
            private String zza;
            private String zzb;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                throw null;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(zzcz zzczVar) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setProductId(String str) {
                this.zza = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setProductType(String str) {
                this.zzb = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Product build() {
                if (!y.ݮڮֲڭܩ(-629041716).equals(this.zzb)) {
                    if (this.zza != null) {
                        if (this.zzb != null) {
                            return new Product(this, null);
                        }
                        throw new IllegalArgumentException(y.٬ݯح׭٩(576087606));
                    }
                    throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159332295));
                }
                throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512867951));
            }
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Builder {
        private com.google.android.gms.internal.play_billing.zzco zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            throw null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zzcz zzczVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public QueryProductDetailsParams build() {
            if (this.zza != null) {
                return new QueryProductDetailsParams(this, null);
            }
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781578376));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProductList(List<Product> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException(y.ݮڮֲڭܩ(-629041932));
            }
            HashSet hashSet = new HashSet();
            for (Product product : list) {
                if (!y.٬ݯح׭٩(576176702).equals(product.zzb())) {
                    hashSet.add(product.zzb());
                }
            }
            if (hashSet.size() > 1) {
                throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512869007));
            }
            this.zza = com.google.android.gms.internal.play_billing.zzco.zzk(list);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzb() {
        return ((Product) this.zza.get(0)).zzb();
    }
}
