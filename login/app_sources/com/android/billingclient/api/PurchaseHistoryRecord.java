package com.android.billingclient.api;

import android.text.TextUtils;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public class PurchaseHistoryRecord {
    private final String zza;
    private final String zzb;
    private final JSONObject zzc;

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
        return y.ۮڭڭܬި(862047635).concat(String.valueOf(this.zza));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PurchaseHistoryRecord(String str, String str2) throws JSONException {
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
        if (!(obj instanceof PurchaseHistoryRecord)) {
            return false;
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        return TextUtils.equals(this.zza, purchaseHistoryRecord.getOriginalJson()) && TextUtils.equals(this.zzb, purchaseHistoryRecord.getSignature());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDeveloperPayload() {
        return this.zzc.optString(y.ٲٴݴ״ٰ(1781577504));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> getProducts() {
        return zza();
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
}
