package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.singular.sdk.internal.GeneralHttpServiceBase;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SLSingularDeviceIdentifier {
    private static final SingularLog logger = SingularLog.getLogger("SLSingularDeviceIdentifier");
    private String sdidValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getValue() {
        return this.sdidValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean exists() {
        return !Utils.isEmptyOrNull(this.sdidValue) || SingularInstance.getInstance().getContext().getSharedPreferences(Constants.PREF_SESSION, 0).contains(Constants.CUSTOM_SDID_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void loadSdidFromPrefs(Context context) {
        this.sdidValue = context.getSharedPreferences(Constants.PREF_SESSION, 0).getString(Constants.PREF_SINGULAR_DEVICE_ID_KEY, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void saveSdidToPrefs(Context context, String str) {
        logger.debug("saving SDID to prefs : " + str);
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_SESSION, 0).edit();
        edit.putString(Constants.PREF_SINGULAR_DEVICE_ID_KEY, str);
        edit.commit();
        loadSdidFromPrefs(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void sendResolveRequestIfNeeded(DeviceInfo deviceInfo, final Context context) {
        if (exists()) {
            logger.debug("sdid exists, exiting /resolve request flow");
            return;
        }
        GeneralHttpService generalHttpService = new GeneralHttpService();
        SingularParamsBase withDeviceInfo = new SingularParamsBase().withDeviceInfo(deviceInfo);
        int andIncrementRetryCountForKey = Utils.getAndIncrementRetryCountForKey(SingularInstance.getInstance().getContext(), "resolve");
        if (andIncrementRetryCountForKey > 3) {
            withDeviceInfo.put((SingularParamsBase) Constants.RETRY_COUNT, String.valueOf(andIncrementRetryCountForKey));
        }
        withDeviceInfo.put((SingularParamsBase) "sdk", Utils.getSdkVersion());
        generalHttpService.sendSynchronousRequest("/resolve", withDeviceInfo, null, new GeneralHttpServiceBase.CompletionHandler() { // from class: com.singular.sdk.internal.SLSingularDeviceIdentifier.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.GeneralHttpServiceBase.CompletionHandler
            public void onSuccess(String str, int i) {
                if (i != 200 || Utils.isEmptyOrNull(str)) {
                    return;
                }
                SLSingularDeviceIdentifier.logger.debug("/resolve request successful");
                Utils.resetRetryCountForKey(SingularInstance.getInstance().getContext(), "resolve");
                try {
                    if (SLSingularDeviceIdentifier.this.exists()) {
                        SLSingularDeviceIdentifier.logger.debug("/resolve request successful, but ignoring, because SDID already exists, exiting.");
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has(Constants.SDID_KEY)) {
                        SLSingularDeviceIdentifier.logger.debug("SDID not found in response");
                        return;
                    }
                    String string = jSONObject.getString(Constants.SDID_KEY);
                    if (Utils.isEmptyOrNull(string)) {
                        return;
                    }
                    SLSingularDeviceIdentifier.logger.debug("SDID resolved successfully: %s", string);
                    SLSingularDeviceIdentifier.this.saveSdidToPrefs(context, string);
                    if (SingularInstance.getInstance().getSingularConfig().sdidAccessorHandler != null) {
                        SingularInstance.getInstance().getSingularConfig().sdidAccessorHandler.sdidReceived(SingularInstance.getInstance().getDeviceInfo().sdid.getValue());
                    }
                } catch (Throwable th) {
                    SLSingularDeviceIdentifier.logger.error("failed to resolve SDID with throwable: %s", Utils.formatException(th));
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.GeneralHttpServiceBase.CompletionHandler
            public void onFailure(String str) {
                SLSingularDeviceIdentifier.logger.error("onFailure to /resolve SDID with error: %s", str);
            }
        });
    }
}
