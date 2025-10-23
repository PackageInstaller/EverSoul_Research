package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class BillingConfig {
    private final String countryCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BillingConfig(String str, String str2) {
        this.countryCode = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static BillingConfig forCountryCode(String str) {
        return new BillingConfig(null, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getCountryCode() {
        return this.countryCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BillingConfig(String str) throws JSONException {
        this.countryCode = new JSONObject(str).optString("countryCode");
    }
}
