package com.unity.purchasing.common;

import com.singular.sdk.internal.Constants;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class UnityPurchasing implements IStoreCallback {
    private IUnityCallback bridge;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnityPurchasing(IUnityCallback iUnityCallback) {
        this.bridge = iUnityCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.purchasing.common.IStoreCallback
    public void OnSetupFailed(InitializationFailureReason initializationFailureReason) {
        this.bridge.OnSetupFailed(initializationFailureReason.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.purchasing.common.IStoreCallback
    public void OnProductsRetrieved(List<ProductDescription> list) {
        this.bridge.OnProductsRetrieved(SerialiseProducts(list));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.purchasing.common.IStoreCallback
    public void OnPurchaseSucceeded(String str, String str2, String str3) {
        this.bridge.OnPurchaseSucceeded(str, str2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.purchasing.common.IStoreCallback
    public void OnPurchaseFailed(PurchaseFailureDescription purchaseFailureDescription) {
        this.bridge.OnPurchaseFailed(SerialisePurchaseFailure(purchaseFailureDescription));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String SerialisePurchaseFailure(PurchaseFailureDescription purchaseFailureDescription) {
        SaneJSONObject saneJSONObject = new SaneJSONObject();
        saneJSONObject.put("message", purchaseFailureDescription.message);
        saneJSONObject.put("productId", purchaseFailureDescription.productId);
        saneJSONObject.put("reason", purchaseFailureDescription.reason.toString());
        saneJSONObject.put("storeSpecificErrorCode", purchaseFailureDescription.storeSpecificErrorCode);
        return saneJSONObject.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String SerialiseProducts(List<ProductDescription> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<ProductDescription> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(SerialiseProduct(it.next()));
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static JSONObject SerialiseProduct(ProductDescription productDescription) {
        SaneJSONObject saneJSONObject = new SaneJSONObject();
        saneJSONObject.put("metadata", SerialiseMetadata(productDescription.metadata));
        saneJSONObject.put(Constants.REVENUE_RECEIPT_KEY, productDescription.receipt);
        saneJSONObject.put("storeSpecificId", productDescription.storeSpecificId);
        saneJSONObject.put("transactionId", productDescription.transactionId);
        return saneJSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static JSONObject SerialiseMetadata(ProductMetadata productMetadata) {
        SaneJSONObject saneJSONObject = new SaneJSONObject();
        saneJSONObject.put("isoCurrencyCode", productMetadata.isoCurrencyCode);
        saneJSONObject.put("localizedDescription", productMetadata.localizedDescription);
        saneJSONObject.put("localizedPriceString", productMetadata.localizedPriceString);
        saneJSONObject.put("localizedPrice", productMetadata.localizedPrice == null ? 0.0d : productMetadata.localizedPrice.doubleValue());
        saneJSONObject.put("localizedTitle", productMetadata.localizedTitle);
        return saneJSONObject;
    }
}
