package com.android.billingclient.api;

import android.text.TextUtils;
import com.liapp.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class ProductDetails {
    private final String zza;
    private final JSONObject zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final List zzj;
    private final List zzk;

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RecurrenceMode {
        public static final int FINITE_RECURRING = 2;
        public static final int INFINITE_RECURRING = 1;
        public static final int NON_RECURRING = 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDescription() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getName() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getProductId() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getProductType() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<SubscriptionOfferDetails> getSubscriptionOfferDetails() {
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTitle() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzb() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String zzc() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final List zzd() {
        return this.zzk;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class InstallmentPlanDetails {
        private final int commitmentPaymentsCount;
        private final int subsequentCommitmentPaymentsCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getInstallmentPlanCommitmentPaymentsCount() {
            return this.commitmentPaymentsCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getSubsequentInstallmentPlanCommitmentPaymentsCount() {
            return this.subsequentCommitmentPaymentsCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InstallmentPlanDetails(JSONObject jSONObject) throws JSONException {
            this.commitmentPaymentsCount = jSONObject.getInt(y.ݮڮֲڭܩ(-629121780));
            this.subsequentCommitmentPaymentsCount = jSONObject.optInt(y.ٴسسݬߨ(1392798330));
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class OneTimePurchaseOfferDetails {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final String zze;
        private final zzcs zzf;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getFormattedPrice() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getPriceAmountMicros() {
            return this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final zzcs zza() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String zzb() {
            return this.zzd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final String zzc() {
            return this.zze;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        OneTimePurchaseOfferDetails(JSONObject jSONObject) throws JSONException {
            this.zza = jSONObject.optString(y.٬ݯح׭٩(576171790));
            this.zzb = jSONObject.optLong(y.֬ڱܱײٮ(-1159448959));
            this.zzc = jSONObject.optString(y.ٴسسݬߨ(1392796682));
            String optString = jSONObject.optString(y.دײܮڳܯ(2051892893));
            this.zzd = true == optString.isEmpty() ? null : optString;
            jSONObject.optString(y.֬ڱܱײٮ(-1159448479)).isEmpty();
            jSONObject.optString(y.ۮڭڭܬި(861932691)).isEmpty();
            jSONObject.optInt(y.ٲٴݴ״ٰ(1781627168));
            JSONArray optJSONArray = jSONObject.optJSONArray(y.֬ڱܱײٮ(-1159447631));
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            com.google.android.gms.internal.play_billing.zzco.zzk(arrayList);
            String str = y.ݮڮֲڭܩ(-629124428);
            if (jSONObject.has(str)) {
                jSONObject.optLong(str);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(y.ٴسسݬߨ(1392797490));
            if (optJSONObject != null) {
                optJSONObject.getInt(y.ݬֲ֮ܲت(1512917903));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(y.٬ݯح׭٩(576169094));
            if (optJSONObject2 != null) {
                optJSONObject2.getLong(y.ݬֲ֮ܲت(1512917671));
                optJSONObject2.getLong(y.دײܮڳܯ(2051892149));
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject(y.ٲٴݴ״ٰ(1781628200));
            if (optJSONObject3 != null) {
                optJSONObject3.getInt(y.ݬֲ֮ܲت(1512917375));
                optJSONObject3.getInt(y.ۮڭڭܬި(861932123));
            }
            this.zze = jSONObject.optString(y.ۮڭڭܬި(861934899));
            JSONObject optJSONObject4 = jSONObject.optJSONObject(y.֬ڱܱײٮ(-1159454287));
            if (optJSONObject4 != null) {
                optJSONObject4.getLong(y.٬ݯح׭٩(576174374));
                optJSONObject4.getLong(y.ݮڮֲڭܩ(-629126724));
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject(y.ٲٴݴ״ٰ(1781621192));
            if (optJSONObject5 != null) {
                optJSONObject5.getString(y.ٲٴݴ״ٰ(1781620800));
                optJSONObject5.optString(y.دײܮڳܯ(2051898805)).isEmpty();
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject(y.ۮڭڭܬި(861934003));
            this.zzf = optJSONObject6 != null ? new zzcs(optJSONObject6) : null;
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class PricingPhase {
        private final String zza;
        private final long zzb;
        private final String zzc;
        private final String zzd;
        private final int zze;
        private final int zzf;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getBillingCycleCount() {
            return this.zze;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getBillingPeriod() {
            return this.zzd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getFormattedPrice() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getPriceAmountMicros() {
            return this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getPriceCurrencyCode() {
            return this.zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getRecurrenceMode() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PricingPhase(JSONObject jSONObject) {
            this.zzd = jSONObject.optString(y.ۮڭڭܬި(861933619));
            this.zzc = jSONObject.optString(y.ٴسسݬߨ(1392796682));
            this.zza = jSONObject.optString(y.٬ݯح׭٩(576171790));
            this.zzb = jSONObject.optLong(y.֬ڱܱײٮ(-1159448959));
            this.zzf = jSONObject.optInt(y.ۮڭڭܬި(861933643));
            this.zze = jSONObject.optInt(y.ݮڮֲڭܩ(-629125716));
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class PricingPhases {
        private final List zza;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<PricingPhase> getPricingPhaseList() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PricingPhases(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(new PricingPhase(optJSONObject));
                    }
                }
            }
            this.zza = arrayList;
        }
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class SubscriptionOfferDetails {
        private final String zza;
        private final String zzb;
        private final String zzc;
        private final PricingPhases zzd;
        private final List zze;
        private final InstallmentPlanDetails zzf;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getBasePlanId() {
            return this.zza;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InstallmentPlanDetails getInstallmentPlanDetails() {
            return this.zzf;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getOfferId() {
            return this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<String> getOfferTags() {
            return this.zze;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getOfferToken() {
            return this.zzc;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PricingPhases getPricingPhases() {
            return this.zzd;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SubscriptionOfferDetails(JSONObject jSONObject) throws JSONException {
            String str = y.دײܮڳܯ(2051897573);
            this.zza = jSONObject.optString(str);
            String optString = jSONObject.optString(y.֬ڱܱײٮ(-1159448479));
            this.zzb = true == optString.isEmpty() ? null : optString;
            this.zzc = jSONObject.getString(y.دײܮڳܯ(2051892893));
            this.zzd = new PricingPhases(jSONObject.getJSONArray(y.ݬֲ֮ܲت(1512919407)));
            JSONObject optJSONObject = jSONObject.optJSONObject(y.٬ݯح׭٩(576175966));
            this.zzf = optJSONObject != null ? new InstallmentPlanDetails(optJSONObject) : null;
            JSONObject optJSONObject2 = jSONObject.optJSONObject(y.ۮڭڭܬި(861936923));
            if (optJSONObject2 != null) {
                optJSONObject2.getString(y.֬ڱܱײٮ(-1159452199));
                optJSONObject2.optString(y.ٲٴݴ״ٰ(1781623336));
                optJSONObject2.optString(y.ٲٴݴ״ٰ(1781623392));
                optJSONObject2.optString(y.ٴسسݬߨ(1392801274));
                optJSONObject2.optString(str);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(y.ۮڭڭܬި(861937467));
                if (optJSONObject3 != null) {
                    new PricingPhase(optJSONObject3);
                }
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(y.֬ڱܱײٮ(-1159447631));
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
            this.zze = arrayList;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ProductDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        String optString = jSONObject.optString("productId");
        this.zzc = optString;
        String optString2 = jSONObject.optString(y.ٲٴݴ״ٰ(1781623144));
        this.zzd = optString2;
        if (TextUtils.isEmpty(optString)) {
            throw new IllegalArgumentException(y.ۮڭڭܬި(861935779));
        }
        if (TextUtils.isEmpty(optString2)) {
            throw new IllegalArgumentException(y.ٴسسݬߨ(1392799938));
        }
        this.zze = jSONObject.optString("title");
        this.zzf = jSONObject.optString("name");
        this.zzg = jSONObject.optString("description");
        jSONObject.optString("packageDisplayName");
        jSONObject.optString("iconUrl");
        this.zzh = jSONObject.optString("skuDetailsToken");
        this.zzi = jSONObject.optString("serializedDocid");
        JSONArray optJSONArray = jSONObject.optJSONArray("subscriptionOfferDetails");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(new SubscriptionOfferDetails(optJSONArray.getJSONObject(i)));
            }
            this.zzj = arrayList;
        } else {
            this.zzj = (optString2.equals("subs") || optString2.equals("play_pass_subs")) ? new ArrayList() : null;
        }
        JSONObject optJSONObject = this.zzb.optJSONObject(y.ۮڭڭܬި(861937563));
        JSONArray optJSONArray2 = this.zzb.optJSONArray(y.ݬֲ֮ܲت(1512922127));
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                arrayList2.add(new OneTimePurchaseOfferDetails(optJSONArray2.getJSONObject(i2)));
            }
            this.zzk = arrayList2;
            return;
        }
        if (optJSONObject == null) {
            this.zzk = null;
        } else {
            arrayList2.add(new OneTimePurchaseOfferDetails(optJSONObject));
            this.zzk = arrayList2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductDetails) {
            return TextUtils.equals(this.zza, ((ProductDetails) obj).zza);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OneTimePurchaseOfferDetails getOneTimePurchaseOfferDetails() {
        List list = this.zzk;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (OneTimePurchaseOfferDetails) this.zzk.get(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        List list = this.zzj;
        return y.دײܮڳܯ(2051895309) + this.zza + y.ٴسسݬߨ(1392800570) + this.zzb.toString() + y.ٲٴݴ״ٰ(1781624048) + this.zzc + y.دײܮڳܯ(2051886637) + this.zzd + y.֬ڱܱײٮ(-1159458351) + this.zze + y.ݮڮֲڭܩ(-629114596) + this.zzh + y.֬ڱܱײٮ(-1159458015) + String.valueOf(list) + y.ۮڭڭܬި(861939259);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        return this.zzb.optString(y.ٴسسݬߨ(1392791418));
    }
}
