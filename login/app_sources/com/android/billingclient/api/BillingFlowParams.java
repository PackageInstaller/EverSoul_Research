package com.android.billingclient.api;

import android.text.TextUtils;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ProductDetails;
import com.liapp.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public class BillingFlowParams {
    public static final String EXTRA_PARAM_KEY_ACCOUNT_ID = "accountId";
    private boolean zza;
    private String zzb;
    private String zzc;
    private SubscriptionUpdateParams zzd;
    private com.google.android.gms.internal.play_billing.zzco zze;
    private ArrayList zzf;
    private boolean zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BillingFlowParams() {
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ BillingFlowParams(zzcf zzcfVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzc() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzd() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List zzh() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzp() {
        return this.zzg;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class ProductDetailsParams {
        private final ProductDetails zza;
        private final String zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ ProductDetailsParams(Builder builder, zzcf zzcfVar) {
            this.zza = builder.zza;
            this.zzb = builder.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return new Builder(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ProductDetails zza() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzb() {
            return this.zzb;
        }

        /* compiled from: com.android.billingclient:billing@@7.1.1 */
        public static class Builder {
            private ProductDetails zza;
            private String zzb;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
                throw null;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(zzcf zzcfVar) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public ProductDetailsParams build() {
                com.google.android.gms.internal.play_billing.zzbe.zzc(this.zza, y.ۮڭڭܬި(861956259));
                if (this.zza.getSubscriptionOfferDetails() != null) {
                    com.google.android.gms.internal.play_billing.zzbe.zzc(this.zzb, y.ٴسسݬߨ(1392772082));
                }
                return new ProductDetailsParams(this, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOfferToken(String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.zzb = str;
                    return this;
                }
                throw new IllegalArgumentException(y.ٴسسݬߨ(1392778858));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setProductDetails(ProductDetails productDetails) {
                this.zza = productDetails;
                if (productDetails.getOneTimePurchaseOfferDetails() != null) {
                    productDetails.getOneTimePurchaseOfferDetails().getClass();
                    ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails();
                    if (oneTimePurchaseOfferDetails.zzb() != null) {
                        this.zzb = oneTimePurchaseOfferDetails.zzb();
                    }
                }
                return this;
            }
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class SubscriptionUpdateParams {
        private String zza;
        private String zzb;
        private int zzc = 0;

        /* compiled from: com.android.billingclient:billing@@7.1.1 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ReplacementMode {
            public static final int CHARGE_FULL_PRICE = 5;
            public static final int CHARGE_PRORATED_PRICE = 2;
            public static final int DEFERRED = 6;
            public static final int UNKNOWN_REPLACEMENT_MODE = 0;
            public static final int WITHOUT_PRORATION = 3;
            public static final int WITH_TIME_PRORATION = 1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SubscriptionUpdateParams() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ SubscriptionUpdateParams(zzcf zzcfVar) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder newBuilder() {
            return new Builder(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final int zza() {
            return this.zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final String zzc() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final String zzd() {
            return this.zzb;
        }

        /* compiled from: com.android.billingclient:billing@@7.1.1 */
        public static class Builder {
            private String zza;
            private String zzb;
            private boolean zzc;
            private int zzd = 0;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Builder() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* synthetic */ Builder(zzcf zzcfVar) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static /* synthetic */ Builder zza(Builder builder) {
                builder.zzc = true;
                return builder;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOldPurchaseToken(String str) {
                this.zza = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setOriginalExternalTransactionId(String str) {
                this.zzb = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setSubscriptionReplacementMode(int i) {
                this.zzd = i;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Deprecated
            public final Builder zzb(String str) {
                this.zza = str;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public SubscriptionUpdateParams build() {
                zzcf zzcfVar = null;
                boolean z = (TextUtils.isEmpty(this.zza) && TextUtils.isEmpty(null)) ? false : true;
                boolean isEmpty = true ^ TextUtils.isEmpty(this.zzb);
                if (!z || !isEmpty) {
                    if (this.zzc || z || isEmpty) {
                        SubscriptionUpdateParams subscriptionUpdateParams = new SubscriptionUpdateParams(zzcfVar);
                        subscriptionUpdateParams.zza = this.zza;
                        subscriptionUpdateParams.zzc = this.zzd;
                        subscriptionUpdateParams.zzb = this.zzb;
                        return subscriptionUpdateParams;
                    }
                    throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512911319));
                }
                throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159445983));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static /* bridge */ /* synthetic */ Builder zzb(SubscriptionUpdateParams subscriptionUpdateParams) {
            Builder newBuilder = newBuilder();
            newBuilder.zzb(subscriptionUpdateParams.zza);
            newBuilder.setSubscriptionReplacementMode(subscriptionUpdateParams.zzc);
            newBuilder.setOriginalExternalTransactionId(subscriptionUpdateParams.zzb);
            return newBuilder;
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Builder {
        private String zza;
        private String zzb;
        private List zzc;
        private ArrayList zzd;
        private boolean zze;
        private SubscriptionUpdateParams.Builder zzf;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setIsOfferPersonalized(boolean z) {
            this.zze = z;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setObfuscatedAccountId(String str) {
            this.zza = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setObfuscatedProfileId(String str) {
            this.zzb = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public BillingFlowParams build() {
            com.google.android.gms.internal.play_billing.zzco zzl;
            ArrayList arrayList = this.zzd;
            boolean z = true;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            List list = this.zzc;
            boolean z3 = (list == null || list.isEmpty()) ? false : true;
            if (!z2 && !z3) {
                throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159440863));
            }
            if (!z2 || !z3) {
                zzcf zzcfVar = null;
                if (!z2) {
                    this.zzc.forEach(new Consumer() { // from class: com.android.billingclient.api.zzce
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            if (((BillingFlowParams.ProductDetailsParams) obj) == null) {
                                throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512889823));
                            }
                        }
                    });
                } else {
                    if (this.zzd.contains(null)) {
                        throw new IllegalArgumentException(y.٬ݯح׭٩(576177374));
                    }
                    if (this.zzd.size() > 1) {
                        SkuDetails skuDetails = (SkuDetails) this.zzd.get(0);
                        String type = skuDetails.getType();
                        ArrayList arrayList2 = this.zzd;
                        int size = arrayList2.size();
                        int i = 0;
                        while (true) {
                            String str = y.٬ݯح׭٩(576176702);
                            if (i < size) {
                                SkuDetails skuDetails2 = (SkuDetails) arrayList2.get(i);
                                if (!type.equals(str) && !skuDetails2.getType().equals(str) && !type.equals(skuDetails2.getType())) {
                                    throw new IllegalArgumentException(y.ٴسسݬߨ(1392772818));
                                }
                                i++;
                            } else {
                                String zzd = skuDetails.zzd();
                                ArrayList arrayList3 = this.zzd;
                                int size2 = arrayList3.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    SkuDetails skuDetails3 = (SkuDetails) arrayList3.get(i2);
                                    if (!type.equals(str) && !skuDetails3.getType().equals(str) && !zzd.equals(skuDetails3.zzd())) {
                                        throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781602432));
                                    }
                                }
                            }
                        }
                    }
                }
                BillingFlowParams billingFlowParams = new BillingFlowParams(zzcfVar);
                if ((!z2 || ((SkuDetails) this.zzd.get(0)).zzd().isEmpty()) && (!z3 || ((ProductDetailsParams) this.zzc.get(0)).zza().zza().isEmpty())) {
                    z = false;
                }
                billingFlowParams.zza = z;
                billingFlowParams.zzb = this.zza;
                billingFlowParams.zzc = this.zzb;
                billingFlowParams.zzd = this.zzf.build();
                ArrayList arrayList4 = this.zzd;
                billingFlowParams.zzf = arrayList4 != null ? new ArrayList(arrayList4) : new ArrayList();
                billingFlowParams.zzg = this.zze;
                List list2 = this.zzc;
                if (list2 != null) {
                    zzl = com.google.android.gms.internal.play_billing.zzco.zzk(list2);
                } else {
                    zzl = com.google.android.gms.internal.play_billing.zzco.zzl();
                }
                billingFlowParams.zze = zzl;
                return billingFlowParams;
            }
            throw new IllegalArgumentException(y.دײܮڳܯ(2051868165));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setProductDetailsParamsList(List<ProductDetailsParams> list) {
            this.zzc = new ArrayList(list);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public Builder setSkuDetails(SkuDetails skuDetails) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(skuDetails);
            this.zzd = arrayList;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setSubscriptionUpdateParams(SubscriptionUpdateParams subscriptionUpdateParams) {
            this.zzf = SubscriptionUpdateParams.zzb(subscriptionUpdateParams);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* synthetic */ Builder(zzcf zzcfVar) {
            SubscriptionUpdateParams.Builder newBuilder = SubscriptionUpdateParams.newBuilder();
            SubscriptionUpdateParams.Builder.zza(newBuilder);
            this.zzf = newBuilder;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zzd.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final BillingResult zzb() {
        if (this.zze.isEmpty()) {
            return zzcj.zzl;
        }
        ProductDetailsParams productDetailsParams = (ProductDetailsParams) this.zze.get(0);
        int i = 1;
        while (true) {
            int size = this.zze.size();
            String str = y.٬ݯح׭٩(576176702);
            if (i < size) {
                ProductDetailsParams productDetailsParams2 = (ProductDetailsParams) this.zze.get(i);
                if (!productDetailsParams2.zza().getProductType().equals(productDetailsParams.zza().getProductType()) && !productDetailsParams2.zza().getProductType().equals(str)) {
                    return zzcj.zza(5, y.ٴسسݬߨ(1392776546));
                }
                i++;
            } else {
                String zza = productDetailsParams.zza().zza();
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                com.google.android.gms.internal.play_billing.zzco zzcoVar = this.zze;
                int size2 = zzcoVar.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ProductDetailsParams productDetailsParams3 = (ProductDetailsParams) zzcoVar.get(i2);
                    productDetailsParams3.zza().getProductType().equals(y.ݬֲ֮ܲت(1512957919));
                    if (!hashSet.contains(productDetailsParams3.zza().getProductId())) {
                        hashSet.add(productDetailsParams3.zza().getProductId());
                        if (!productDetailsParams.zza().getProductType().equals(str) && !productDetailsParams3.zza().getProductType().equals(str) && !zza.equals(productDetailsParams3.zza().zza())) {
                            return zzcj.zza(5, y.ۮڭڭܬި(861960539));
                        }
                    } else {
                        return zzcj.zza(5, String.format(y.֬ڱܱײٮ(-1159443551), productDetailsParams3.zza().getProductId()));
                    }
                }
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (hashSet.contains(str2)) {
                        return zzcj.zza(5, String.format(y.ۮڭڭܬި(861960403), str2));
                    }
                }
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = productDetailsParams.zza().getOneTimePurchaseOfferDetails();
                if (oneTimePurchaseOfferDetails == null || oneTimePurchaseOfferDetails.zza() == null) {
                    return zzcj.zzl;
                }
                return zzcj.zza(5, y.٬ݯح׭٩(576170126));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zze() {
        return this.zzd.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzf() {
        return this.zzd.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ArrayList zzg() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzf);
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzq() {
        return (this.zzb == null && this.zzc == null && this.zzd.zzd() == null && this.zzd.zza() == 0 && !this.zze.stream().anyMatch(new Predicate() { // from class: com.android.billingclient.api.zzcd
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return false;
            }
        }) && !this.zza && !this.zzg) ? false : true;
    }
}
