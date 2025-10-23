package com.singular.sdk.internal;

import com.kakaogame.auth.agreement.AgreementService;
import com.singular.sdk.internal.ConfigManagerRepo;
import com.singular.sdk.internal.GeneralHttpServiceBase;
import com.singular.sdk.internal.SingularParamsBase;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigManagerRepoNetwork extends ConfigManagerRepo {
    private static final SingularLog logger = SingularLog.getLogger("ConfigManagerRepoNetwork");
    private GeneralHttpServiceBase httpService;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.ConfigManagerRepo
    public void saveConfig(SLRemoteConfiguration sLRemoteConfiguration, ConfigManagerRepo.CompletionHandler completionHandler) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigManagerRepoNetwork() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigManagerRepoNetwork(GeneralHttpServiceBase generalHttpServiceBase) {
        this.httpService = generalHttpServiceBase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.ConfigManagerRepo
    public void getConfig(ConfigManagerRepo.CompletionHandler completionHandler) {
        getConfig(completionHandler, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void waitAndRetry(final ConfigManagerRepo.CompletionHandler completionHandler, final int i, String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        if (i > 0) {
            newSingleThreadScheduledExecutor.schedule(new Runnable() { // from class: com.singular.sdk.internal.ConfigManagerRepoNetwork.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    ConfigManagerRepoNetwork.this.getConfig(completionHandler, i - 1);
                }
            }, 3000L, TimeUnit.MILLISECONDS);
        } else if (completionHandler != null) {
            completionHandler.onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getConfig(final ConfigManagerRepo.CompletionHandler completionHandler, final int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdk", Utils.getSdkVersion());
        DeviceInfo deviceInfo = SingularInstance.getInstance().getDeviceInfo();
        if (deviceInfo != null) {
            hashMap.put(SingularParamsBase.Constants.PLATFORM_KEY, deviceInfo.platform);
            hashMap.put(AgreementService.VALUE_NO, deviceInfo.appName);
            hashMap.put(SingularParamsBase.Constants.PACKAGE_NAME_KEY, deviceInfo.packageName);
            hashMap.put("v", deviceInfo.osVersion);
        }
        int andIncrementRetryCountForKey = Utils.getAndIncrementRetryCountForKey(SingularInstance.getInstance().getContext(), "config");
        if (andIncrementRetryCountForKey > 3) {
            hashMap.put(Constants.RETRY_COUNT, String.valueOf(andIncrementRetryCountForKey));
        }
        this.httpService.sendRequest("/config", hashMap, null, new GeneralHttpServiceBase.CompletionHandler() { // from class: com.singular.sdk.internal.ConfigManagerRepoNetwork.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.GeneralHttpServiceBase.CompletionHandler
            public void onSuccess(String str, int i2) {
                if (i2 != 200 || str == null) {
                    ConfigManagerRepoNetwork.this.waitAndRetry(completionHandler, i, "get config failed with code = " + i2);
                    return;
                }
                try {
                    SLRemoteConfiguration fromJson = SLRemoteConfiguration.fromJson(new JSONObject(str));
                    ConfigManagerRepo.CompletionHandler completionHandler2 = completionHandler;
                    if (completionHandler2 != null) {
                        completionHandler2.onCompleted(fromJson);
                    }
                    Utils.resetRetryCountForKey(SingularInstance.getInstance().getContext(), "config");
                } catch (JSONException e) {
                    ConfigManagerRepoNetwork.logger.error(Utils.formatException(e));
                    ConfigManagerRepoNetwork.this.waitAndRetry(completionHandler, i, e.getMessage());
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.GeneralHttpServiceBase.CompletionHandler
            public void onFailure(String str) {
                ConfigManagerRepoNetwork.this.waitAndRetry(completionHandler, i, str);
            }
        });
    }
}
