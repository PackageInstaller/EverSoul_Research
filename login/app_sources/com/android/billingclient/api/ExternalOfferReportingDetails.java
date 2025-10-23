package com.android.billingclient.api;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class ExternalOfferReportingDetails {
    private final String externalTransactionToken;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExternalOfferReportingDetails(String str) throws JSONException {
        this.externalTransactionToken = new JSONObject(str).optString("externalTransactionToken");
    }
}
