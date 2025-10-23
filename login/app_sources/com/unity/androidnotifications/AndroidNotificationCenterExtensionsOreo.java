package com.unity.androidnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes3.dex */
public class AndroidNotificationCenterExtensionsOreo extends AndroidNotificationCenterExtensions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidNotificationCenterExtensionsOreo(Context context, NotificationManager notificationManager) {
        super(context, notificationManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.androidnotifications.AndroidNotificationCenterExtensions
    public boolean areNotificationsEnabled(String str) {
        if (!super.areNotificationsEnabled()) {
            return false;
        }
        NotificationChannel notificationChannel = this.notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }
}
