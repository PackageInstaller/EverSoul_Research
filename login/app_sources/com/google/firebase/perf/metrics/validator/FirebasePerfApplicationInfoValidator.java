package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.p010v1.ApplicationInfo;

/* loaded from: classes2.dex */
public class FirebasePerfApplicationInfoValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ApplicationInfo applicationInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public boolean isValidPerfMetric() {
        if (isValidApplicationInfo()) {
            return true;
        }
        logger.warn("ApplicationInfo is invalid");
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isValidApplicationInfo() {
        ApplicationInfo applicationInfo = this.applicationInfo;
        if (applicationInfo == null) {
            logger.warn("ApplicationInfo is null");
            return false;
        }
        if (!applicationInfo.hasGoogleAppId()) {
            logger.warn("GoogleAppId is null");
            return false;
        }
        if (!this.applicationInfo.hasAppInstanceId()) {
            logger.warn("AppInstanceId is null");
            return false;
        }
        if (!this.applicationInfo.hasApplicationProcessState()) {
            logger.warn("ApplicationProcessState is null");
            return false;
        }
        if (!this.applicationInfo.hasAndroidAppInfo()) {
            return true;
        }
        if (!this.applicationInfo.getAndroidAppInfo().hasPackageName()) {
            logger.warn("AndroidAppInfo.packageName is null");
            return false;
        }
        if (this.applicationInfo.getAndroidAppInfo().hasSdkVersion()) {
            return true;
        }
        logger.warn("AndroidAppInfo.sdkVersion is null");
        return false;
    }
}
