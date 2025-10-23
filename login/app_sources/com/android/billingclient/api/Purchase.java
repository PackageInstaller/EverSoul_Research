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
public class Purchase {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PurchaseState {
        public static final int PENDING = 2;
        public static final int PURCHASED = 1;
        public static final int UNSPECIFIED_STATE = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalJson() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSignature() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1781578496).concat(String.valueOf(this.zza));
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static final class PendingPurchaseUpdate {
        private final JSONObject mParsedJson;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PendingPurchaseUpdate(JSONObject jSONObject) {
            this.mParsedJson = jSONObject;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public List<String> getProducts() {
            JSONArray optJSONArray;
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = this.mParsedJson;
            String str = y.٬ݯح׭٩(576088710);
            if (jSONObject.has(str) && (optJSONArray = this.mParsedJson.optJSONArray(str)) != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
            }
            return arrayList;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getPurchaseToken() {
            return this.mParsedJson.optString(y.دײܮڳܯ(2051845477));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Purchase(String str, String str2) throws JSONException {
        this.zza = str;
        this.zzb = str2;
        this.zzc = new JSONObject(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final ArrayList zza() {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = this.zzc;
        String str = y.٬ݯح׭٩(576088710);
        if (jSONObject.has(str)) {
            JSONArray optJSONArray = this.zzc.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
            }
        } else {
            JSONObject jSONObject2 = this.zzc;
            String str2 = y.֬ڱܱײٮ(-1159452199);
            if (jSONObject2.has(str2)) {
                arrayList.add(this.zzc.optString(str2));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return TextUtils.equals(this.zza, purchase.getOriginalJson()) && TextUtils.equals(this.zzb, purchase.getSignature());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccountIdentifiers getAccountIdentifiers() {
        JSONObject jSONObject = this.zzc;
        String optString = jSONObject.optString(y.ݮڮֲڭܩ(-629040164));
        String optString2 = jSONObject.optString(y.ٲٴݴ״ٰ(1781652312));
        if (optString == null && optString2 == null) {
            return null;
        }
        return new AccountIdentifiers(optString, optString2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDeveloperPayload() {
        return this.zzc.optString(y.ٲٴݴ״ٰ(1781577504));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOrderId() {
        String optString = this.zzc.optString(y.ٲٴݴ״ٰ(1781577680));
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return optString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPackageName() {
        return this.zzc.optString(y.ٴسسݬߨ(1392791418));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingPurchaseUpdate getPendingPurchaseUpdate() {
        JSONObject optJSONObject = this.zzc.optJSONObject(y.ۮڭڭܬި(862044219));
        if (optJSONObject == null) {
            return null;
        }
        return new PendingPurchaseUpdate(optJSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> getProducts() {
        return zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPurchaseState() {
        return this.zzc.optInt(y.٬ݯح׭٩(576089590), 1) != 4 ? 1 : 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getPurchaseTime() {
        return this.zzc.optLong(y.٬ݯح׭٩(576089614));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPurchaseToken() {
        JSONObject jSONObject = this.zzc;
        return jSONObject.optString(y.٬ݯح׭٩(576089758), jSONObject.optString(y.دײܮڳܯ(2051845477)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getQuantity() {
        return this.zzc.optInt(y.֬ڱܱײٮ(-1159333927), 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public ArrayList<String> getSkus() {
        return zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAcknowledged() {
        return this.zzc.optBoolean(y.ݮڮֲڭܩ(-629039260), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAutoRenewing() {
        return this.zzc.optBoolean(y.ݬֲ֮ܲت(1512865855));
    }
}
