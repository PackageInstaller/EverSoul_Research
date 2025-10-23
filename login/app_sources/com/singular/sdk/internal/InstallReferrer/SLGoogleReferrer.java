package com.singular.sdk.internal.InstallReferrer;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class SLGoogleReferrer implements SLInstallReferrerService {
    private static Map<String, Object> installReferrer;
    private static final SingularLog logger = SingularLog.getLogger("SLGoogleReferrer");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void makeInstallReferrerObject(String str, String str2, long j, long j2, String str3, long j3, long j4) {
        HashMap hashMap = new HashMap();
        installReferrer = hashMap;
        hashMap.put("referrer", str);
        installReferrer.put("referrer_source", str2);
        installReferrer.put("clickTimestampSeconds", Long.valueOf(j));
        installReferrer.put("installBeginTimestampSeconds", Long.valueOf(j2));
        installReferrer.put("current_device_time", Long.valueOf(Utils.getCurrentTimeMillis()));
        installReferrer.put("installVersion", str3);
        installReferrer.put("clickTimestampServerSeconds", Long.valueOf(j3));
        installReferrer.put("installBeginTimestampServerSeconds", Long.valueOf(j4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerService
    public void fetchReferrer(final Context context, final SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        try {
            final InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
            build.startConnection(new InstallReferrerStateListener() { // from class: com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(final int i) {
                    SLGoogleReferrer.logger.debug("google onInstallReferrerSetupFinished: responseCode=" + i);
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer.1.1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2 = i;
                            if (i2 == 0) {
                                try {
                                    C26101 c26101 = C26101.this;
                                    c26101.handleReferrerResponse(build);
                                } catch (Throwable unused) {
                                    SLGoogleReferrer.logger.error("google onInstallReferrerSetupFinished: failed to get referrer value");
                                }
                                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(SLGoogleReferrer.installReferrer);
                            } else if (i2 == 1) {
                                SLGoogleReferrer.logger.debug("google onInstallReferrerSetupFinished: SERVICE_UNAVAILABLE");
                                C26101 c261012 = C26101.this;
                                c261012.handleNotSupported(context);
                                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(SLGoogleReferrer.installReferrer);
                            } else if (i2 == 2) {
                                SLGoogleReferrer.logger.debug("google onInstallReferrerSetupFinished: FEATURE_NOT_SUPPORTED");
                                C26101 c261013 = C26101.this;
                                c261013.handleNotSupported(context);
                                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(SLGoogleReferrer.installReferrer);
                            } else if (i2 != 3) {
                                SLGoogleReferrer.logger.debug("Unexpected response code of install referrer response %d", Integer.valueOf(i));
                                C26101 c261014 = C26101.this;
                                c261014.handleNotSupported(context);
                                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(SLGoogleReferrer.installReferrer);
                            } else {
                                SLGoogleReferrer.logger.error("google onInstallReferrerSetupFinished: DEVELOPER_ERROR");
                                C26101 c261015 = C26101.this;
                                c261015.handleNotSupported(context);
                                sLInstallReferrerCompletionHandler.onInstallReferrerReceived(SLGoogleReferrer.installReferrer);
                            }
                            if (build.isReady()) {
                                build.endConnection();
                            }
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public void handleReferrerResponse(InstallReferrerClient installReferrerClient) throws Exception {
                    String str;
                    long j;
                    long j2;
                    ReferrerDetails installReferrer2 = installReferrerClient.getInstallReferrer();
                    if (isV2Supported(installReferrer2)) {
                        str = installReferrer2.getInstallVersion();
                        j = installReferrer2.getReferrerClickTimestampServerSeconds();
                        j2 = installReferrer2.getInstallBeginTimestampServerSeconds();
                    } else {
                        str = null;
                        j = -1;
                        j2 = -1;
                    }
                    SLGoogleReferrer.makeInstallReferrerObject(installReferrer2.getInstallReferrer(), NotificationCompat.CATEGORY_SERVICE, installReferrer2.getReferrerClickTimestampSeconds(), installReferrer2.getInstallBeginTimestampSeconds(), str, j, j2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private boolean isV2Supported(ReferrerDetails referrerDetails) {
                    try {
                        return referrerDetails.getClass().getMethod("getInstallVersion", new Class[0]) != null;
                    } catch (Throwable unused) {
                        return false;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public void handleNotSupported(Context context2) {
                    String cSIReferrer = Utils.getCSIReferrer(context2);
                    if (cSIReferrer != null) {
                        SLGoogleReferrer.makeInstallReferrerObject(cSIReferrer, SDKConstants.PARAM_INTENT, -1L, -1L, null, -1L, -1L);
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    build.endConnection();
                }
            });
        } catch (Throwable unused) {
            logger.error("google: failed to get referrer value");
        }
    }
}
