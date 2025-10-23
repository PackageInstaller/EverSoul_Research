package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppAdLibrary {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loadRewardedVideo(Context context, String placementID, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, placementID), callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_REWARDED_VIDEO, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void loadInterstitialAd(Context context, String placementID, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, placementID), callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.LOAD_INTERSTITIAL_AD, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void showRewardedVideo(Context context, String placementID, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, placementID), callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_REWARDED_VIDEO, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void showInterstitialAd(Context context, String placementID, DaemonRequest.Callback callback) {
        try {
            DaemonRequest.executeAsync(context, new JSONObject().put(SDKConstants.PARAM_PLACEMENT_ID, placementID), callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
        } catch (JSONException e) {
            SDKLogger.logInternalError(context, SDKMessageEnum.SHOW_INTERSTITIAL_AD, e);
        }
    }
}
