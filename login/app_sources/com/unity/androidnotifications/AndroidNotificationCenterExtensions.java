package com.unity.androidnotifications;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

/* loaded from: classes3.dex */
public class AndroidNotificationCenterExtensions {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    protected static AndroidNotificationCenterExtensions extentionsImpl;
    protected Context context;
    protected NotificationManager notificationManager;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidNotificationCenterExtensions(Context context, NotificationManager notificationManager) {
        this.context = context;
        this.notificationManager = notificationManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AndroidNotificationCenterExtensions getExtensionsImpl(Context context, NotificationManager notificationManager) {
        AndroidNotificationCenterExtensions androidNotificationCenterExtensions = extentionsImpl;
        if (androidNotificationCenterExtensions != null) {
            return androidNotificationCenterExtensions;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            extentionsImpl = new AndroidNotificationCenterExtensionsOreo(context, notificationManager);
        } else {
            extentionsImpl = new AndroidNotificationCenterExtensions(context, notificationManager);
        }
        return extentionsImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean areNotificationsEnabled() {
        return this.notificationManager.areNotificationsEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean areNotificationsEnabled(String str) {
        return areNotificationsEnabled();
    }
}
