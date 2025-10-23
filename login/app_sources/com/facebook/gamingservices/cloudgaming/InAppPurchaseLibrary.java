package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseLibrary {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void onReady(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.ON_READY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_CATALOG);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getPurchases(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_PURCHASES);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void purchase(Context context, String productID, String developerPayload, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PRODUCT_ID, productID).put(SDKConstants.PARAM_DEVELOPER_PAYLOAD, developerPayload), callback, SDKMessageEnum.PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void consumePurchase(Context context, String purchaseToken, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PURCHASE_TOKEN, purchaseToken), callback, SDKMessageEnum.CONSUME_PURCHASE);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CONSUME_PURCHASE, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getSubscribableCatalog(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_SUBSCRIBABLE_CATALOG);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void purchaseSubscription(Context context, String productID, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PRODUCT_ID, productID), callback, SDKMessageEnum.PURCHASE_SUBSCRIPTION);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.PURCHASE_SUBSCRIPTION, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getSubscriptions(Context context, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, (JSONObject) null, callback, SDKMessageEnum.GET_SUBSCRIPTIONS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void cancelSubscription(Context context, String purchaseToken, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PURCHASE_TOKEN, purchaseToken), callback, SDKMessageEnum.CANCEL_SUBSCRIPTION);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.CANCEL_SUBSCRIPTION, e);
        }
    }
}
