package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes2.dex */
public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {
    static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
    private final AnalyticsConnector analyticsConnector;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String str, Bundle bundle) {
        this.analyticsConnector.logEvent(FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS, str, bundle);
    }
}
