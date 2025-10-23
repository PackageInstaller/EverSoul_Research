package com.singular.unitybridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.liapp.y;
import com.singular.sdk.DeferredDeepLinkHandler;
import com.singular.sdk.SDIDAccessorHandler;
import com.singular.sdk.ShortLinkHandler;
import com.singular.sdk.Singular;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularDeviceAttributionHandler;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularParamsBase;
import com.unity3d.player.UnityPlayer;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SingularUnityBridge {
    static SingularConfig config;
    static int currentIntentHash;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void onNewIntent(final Intent intent) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                if (SingularUnityBridge.config == null || intent.hashCode() == SingularUnityBridge.currentIntentHash) {
                    return;
                }
                SingularUnityBridge.currentIntentHash = intent.hashCode();
                Intent intent2 = intent;
                if (intent2 == null || intent2.getData() == null) {
                    return;
                }
                if (y.ٲٴݴ״ٰ(1781642640).equals(intent.getAction())) {
                    SingularUnityBridge.config.withSingularLink(intent, SingularUnityBridge.config.linkCallback, SingularUnityBridge.config.shortlinkTimeoutSec);
                    Singular.init(UnityPlayer.currentActivity.getApplicationContext(), SingularUnityBridge.config);
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void init(String str) {
        String str2 = y.ݮڮֲڭܩ(-628211076);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("apiKey", null);
            String optString2 = jSONObject.optString("secret", null);
            if (optString != null && optString2 != null) {
                Context applicationContext = UnityPlayer.currentActivity.getApplicationContext();
                SingularConfig singularConfig = new SingularConfig(optString, optString2);
                String optString3 = jSONObject.optString("facebookAppId", null);
                if (!TextUtils.isEmpty(optString3)) {
                    singularConfig.withFacebookAppId(optString3);
                }
                String optString4 = jSONObject.optString(Constants.PREF_CSI_REFERRER_KEY, null);
                if (!TextUtils.isEmpty(optString4)) {
                    singularConfig.withOpenURI(Uri.parse(optString4));
                }
                if (jSONObject.optBoolean("enableDeferredDeepLinks", false)) {
                    singularConfig.withDDLHandler(new DeferredDeepLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.singular.sdk.DeferredDeepLinkHandler
                        public void handleLink(final String str3) {
                            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.2.1
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public void run() {
                                    String str4 = str3;
                                    String str5 = y.ۮڭڭܬި(862851419);
                                    String str6 = y.دײܮڳܯ(2051242629);
                                    if (str4 == null) {
                                        UnityPlayer.UnitySendMessage(str6, str5, "");
                                    } else {
                                        UnityPlayer.UnitySendMessage(str6, str5, str4);
                                    }
                                }
                            });
                        }
                    });
                    long optLong = jSONObject.optLong("ddlTimeoutSec", 0L);
                    if (optLong > 0) {
                        singularConfig.withDDLTimeoutInSec(optLong);
                    }
                }
                SingularLinkHandler singularLinkHandler = new SingularLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.3
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.singular.sdk.SingularLinkHandler
                    public void onResolved(final SingularLinkParams singularLinkParams) {
                        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.3.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, singularLinkParams.getDeeplink());
                                    jSONObject2.put("passthrough", singularLinkParams.getPassthrough());
                                    jSONObject2.put("is_deferred", singularLinkParams.isDeferred());
                                    if (singularLinkParams.getUrlParameters() != null) {
                                        jSONObject2.putOpt("url_parameters", new JSONObject(singularLinkParams.getUrlParameters()));
                                    }
                                } catch (JSONException e) {
                                    Log.d(y.دײܮڳܯ(2051242157), y.ۮڭڭܬި(862851259) + e.getMessage());
                                }
                                UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), y.ݬֲ֮ܲت(1512263879), jSONObject2.toString());
                            }
                        });
                    }
                };
                Intent intent = UnityPlayer.currentActivity.getIntent();
                currentIntentHash = intent.hashCode();
                long optLong2 = jSONObject.optLong("shortlinkResolveTimeout", 0L);
                if (optLong2 > 0) {
                    singularConfig.withSingularLink(intent, singularLinkHandler, optLong2);
                } else {
                    singularConfig.withSingularLink(intent, singularLinkHandler);
                }
                if (jSONObject.optBoolean("enableLogging", false)) {
                    singularConfig.withLoggingEnabled();
                }
                int optInt = jSONObject.optInt("logLevel", -1);
                if (optInt >= 0) {
                    singularConfig.withLogLevel(optInt);
                }
                String optString5 = jSONObject.optString("fcmDeviceToken", null);
                if (optString5 != null) {
                    singularConfig.withFCMDeviceToken(optString5);
                }
                long optLong3 = jSONObject.optLong("sessionTimeoutSec", 0L);
                if (optLong3 > 0) {
                    singularConfig.withSessionTimeoutInSec(optLong3);
                }
                String optString6 = jSONObject.optString("customUserId", null);
                if (optString6 != null) {
                    singularConfig.withCustomUserId(optString6);
                }
                String optString7 = jSONObject.optString(SingularParamsBase.Constants.IMEI_KEYSPACE_KEY, null);
                if (optString7 != null) {
                    singularConfig.withIMEI(optString7);
                }
                if (jSONObject.optBoolean("collectOAID", false)) {
                    singularConfig.withOAIDCollection();
                }
                if (jSONObject.has(str2)) {
                    singularConfig.withLimitDataSharing(jSONObject.optBoolean(str2));
                }
                singularConfig.limitedIdentifiresEnabled = Boolean.valueOf(jSONObject.optBoolean("limitedIdentifiersEnabled", false));
                JSONObject optJSONObject = jSONObject.optJSONObject("globalProperties");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        JSONObject jSONObject2 = optJSONObject.getJSONObject(keys.next());
                        String optString8 = jSONObject2.optString("Key", "");
                        if (optString8 != null && !optString8.trim().equals("")) {
                            singularConfig.withGlobalProperty(optString8, jSONObject2.optString("Value", ""), jSONObject2.optBoolean("OverrideExisting", false));
                        }
                    }
                }
                String optString9 = jSONObject.optString("customSdid", null);
                if (optString9 != null) {
                    singularConfig.withCustomSdid(optString9, new SDIDAccessorHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.4
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.singular.sdk.SDIDAccessorHandler
                        public void didSetSdid(final String str3) {
                            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.4.1
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public void run() {
                                    UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), y.٬ݯح׭٩(576303222), str3);
                                }
                            });
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.singular.sdk.SDIDAccessorHandler
                        public void sdidReceived(final String str3) {
                            UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.4.2
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public void run() {
                                    UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), y.دײܮڳܯ(2051241621), str3);
                                }
                            });
                        }
                    });
                }
                config = singularConfig;
                singularConfig.withSingularDeviceAttribution(new SingularDeviceAttributionHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.5
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.singular.sdk.SingularDeviceAttributionHandler
                    public void onDeviceAttributionInfoReceived(Map<String, Object> map) {
                        UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), "SingularDeviceAttributionCallback", new JSONObject(map).toString());
                    }
                });
                Singular.init(applicationContext, singularConfig);
            }
        } catch (Throwable th) {
            Log.d(y.دײܮڳܯ(2051242157), th.getMessage());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void createReferrerShortLink(String str, String str2, String str3, String str4) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str4);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        Singular.createReferrerShortLink(str, str2, str3, jSONObject, new ShortLinkHandler() { // from class: com.singular.unitybridge.SingularUnityBridge.6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.ShortLinkHandler
            public void onSuccess(final String str5) {
                UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.singular.unitybridge.SingularUnityBridge.6.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("data", str5);
                            jSONObject2.put("error", (Object) null);
                        } catch (JSONException e2) {
                            Log.d(y.دײܮڳܯ(2051242157), y.ۮڭڭܬި(862851259) + e2.getMessage());
                        }
                        UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), y.ۮڭڭܬި(862854307), jSONObject2.toString());
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.ShortLinkHandler
            public void onError(String str5) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("data", (Object) null);
                    jSONObject2.put("error", str5);
                } catch (JSONException e2) {
                    Log.d(y.دײܮڳܯ(2051242157), y.ۮڭڭܬި(862851259) + e2.getMessage());
                }
                UnityPlayer.UnitySendMessage(y.دײܮڳܯ(2051242629), "ShortLinkResolved", jSONObject2.toString());
            }
        });
    }
}
