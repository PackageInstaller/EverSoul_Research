package com.android.billingclient.api;

import com.android.billingclient.api.ProductDetails;
import com.liapp.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class zzcs {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcs(JSONObject jSONObject) throws JSONException {
        jSONObject.getString(y.ٲٴݴ״ٰ(1781623144));
        JSONArray optJSONArray = jSONObject.optJSONArray(y.دײܮڳܯ(2051810021));
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(optJSONArray.getInt(i)));
            }
        }
        new ProductDetails.PricingPhases(jSONObject.getJSONArray(y.ݬֲ֮ܲت(1512919407)));
    }
}
