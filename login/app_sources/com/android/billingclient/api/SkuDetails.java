package com.android.billingclient.api;

import android.text.TextUtils;
import com.liapp.y;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
@Deprecated
/* loaded from: classes.dex */
public class SkuDetails {
    private final String zza;
    private final JSONObject zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalJson() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.֬ڱܱײٮ(-1159337287).concat(String.valueOf(this.zza));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SkuDetails(String str) throws JSONException {
        this.zza = str;
        JSONObject jSONObject = new JSONObject(str);
        this.zzb = jSONObject;
        if (TextUtils.isEmpty(jSONObject.optString("productId"))) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781571728));
        }
        if (TextUtils.isEmpty(jSONObject.optString("type"))) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781572000));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SkuDetails) {
            return TextUtils.equals(this.zza, ((SkuDetails) obj).zza);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDescription() {
        return this.zzb.optString(y.ٴسسݬߨ(1392801274));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getFreeTrialPeriod() {
        return this.zzb.optString(y.ݮڮֲڭܩ(-629044124));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIconUrl() {
        return this.zzb.optString(y.ٲٴݴ״ٰ(1781573544));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIntroductoryPrice() {
        return this.zzb.optString(y.ݬֲ֮ܲت(1512870559));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getIntroductoryPriceAmountMicros() {
        return this.zzb.optLong(y.ٴسسݬߨ(1392884162));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIntroductoryPriceCycles() {
        return this.zzb.optInt(y.ݮڮֲڭܩ(-629043516));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getIntroductoryPricePeriod() {
        return this.zzb.optString(y.٬ݯح׭٩(576094062));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalPrice() {
        JSONObject jSONObject = this.zzb;
        String str = y.ٴسسݬߨ(1392882810);
        if (jSONObject.has(str)) {
            return this.zzb.optString(str);
        }
        return getPrice();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getOriginalPriceAmountMicros() {
        JSONObject jSONObject = this.zzb;
        String str = y.ٴسسݬߨ(1392882938);
        if (jSONObject.has(str)) {
            return this.zzb.optLong(str);
        }
        return getPriceAmountMicros();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPrice() {
        return this.zzb.optString(y.ۮڭڭܬި(862051435));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getPriceAmountMicros() {
        return this.zzb.optLong(y.٬ݯح׭٩(576090534));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPriceCurrencyCode() {
        return this.zzb.optString(y.ۮڭڭܬި(862052107));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSku() {
        return this.zzb.optString(y.֬ڱܱײٮ(-1159452199));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getSubscriptionPeriod() {
        return this.zzb.optString(y.ۮڭڭܬި(862052307));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTitle() {
        return this.zzb.optString(y.ٲٴݴ״ٰ(1781623336));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getType() {
        return this.zzb.optString(y.ٲٴݴ״ٰ(1781623144));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int zza() {
        return this.zzb.optInt(y.֬ڱܱײٮ(-1159337271));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String zzb() {
        return this.zzb.optString(y.ٴسسݬߨ(1392881674));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String zzc() {
        String optString = this.zzb.optString(y.دײܮڳܯ(2051892893));
        return optString.isEmpty() ? this.zzb.optString(y.ݬֲ֮ܲت(1512872767)) : optString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzd() {
        return this.zzb.optString(y.ٴسسݬߨ(1392791418));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String zze() {
        return this.zzb.optString(y.ۮڭڭܬި(861934899));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzf() {
        return this.zzb.optString(y.ۮڭڭܬި(862050323));
    }
}
