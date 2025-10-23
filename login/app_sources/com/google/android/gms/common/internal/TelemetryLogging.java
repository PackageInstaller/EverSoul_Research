package com.google.android.gms.common.internal;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class TelemetryLogging {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TelemetryLogging() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TelemetryLoggingClient getClient(Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TelemetryLoggingClient getClient(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }
}
