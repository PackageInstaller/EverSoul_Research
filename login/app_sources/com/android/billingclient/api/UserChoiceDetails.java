package com.android.billingclient.api;

import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
public final class UserChoiceDetails {
    private final String mOriginalJson;
    private final JSONObject mParsedJson;
    private final List<Product> mProducts;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Product> getProducts() {
        return this.mProducts;
    }

    /* compiled from: com.android.billingclient:billing@@7.1.1 */
    public static class Product {

        /* renamed from: id */
        private final String f145id;
        private final String offerToken;
        private final String type;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Product(String str, String str2, String str3) {
            this.f145id = str;
            this.type = str2;
            this.offerToken = str3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getId() {
            return this.f145id;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getOfferToken() {
            return this.offerToken;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getType() {
            return this.type;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Product(JSONObject jSONObject) {
            this.f145id = jSONObject.optString(y.֬ڱܱײٮ(-1159452199));
            this.type = jSONObject.optString(y.ۮڭڭܬި(862050875));
            String optString = jSONObject.optString(y.ٴسسݬߨ(1392882474));
            this.offerToken = true == optString.isEmpty() ? null : optString;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Product)) {
                return false;
            }
            Product product = (Product) obj;
            return this.f145id.equals(product.getId()) && this.type.equals(product.getType()) && Objects.equals(this.offerToken, product.getOfferToken());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hash(this.f145id, this.type, this.offerToken);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.format(y.٬ݯح׭٩(576092134), this.f145id, this.type, this.offerToken);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UserChoiceDetails(String str) throws JSONException {
        this.mOriginalJson = str;
        JSONObject jSONObject = new JSONObject(str);
        this.mParsedJson = jSONObject;
        this.mProducts = toProductList(jSONObject.optJSONArray("products"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static List<Product> toProductList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(new Product(optJSONObject));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getExternalTransactionToken() {
        return this.mParsedJson.optString(y.ٴسسݬߨ(1392872610));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getOriginalExternalTransactionId() {
        String optString = this.mParsedJson.optString(y.ݮڮֲڭܩ(-629083148));
        if (optString.isEmpty()) {
            return null;
        }
        return optString;
    }
}
