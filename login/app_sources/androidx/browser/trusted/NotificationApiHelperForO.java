package androidx.browser.trusted;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

/* loaded from: classes.dex */
class NotificationApiHelperForO {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isChannelEnabled(NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Notification copyNotificationOntoChannel(Context context, NotificationManager notificationManager, Notification notification, String str, String str2) {
        notificationManager.createNotificationChannel(new NotificationChannel(str, str2, 3));
        if (notificationManager.getNotificationChannel(str).getImportance() == 0) {
            return null;
        }
        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, notification);
        recoverBuilder.setChannelId(str);
        return recoverBuilder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NotificationApiHelperForO() {
    }
}
