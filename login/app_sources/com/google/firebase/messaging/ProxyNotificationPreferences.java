package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
final class ProxyNotificationPreferences {
    private static final String FCM_PREFERENCES = "com.google.firebase.messaging";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProxyNotificationPreferences() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static SharedPreferences getPreference(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setProxyNotificationsInitialized(Context context, boolean z) {
        SharedPreferences.Editor edit = getPreference(context).edit();
        edit.putBoolean("proxy_notification_initialized", z);
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isProxyNotificationInitialized(Context context) {
        return getPreference(context).getBoolean("proxy_notification_initialized", false);
    }
}
