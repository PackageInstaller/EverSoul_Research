package androidx.browser.trusted;

import android.app.NotificationManager;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class NotificationApiHelperForM {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Parcelable[] getActiveNotifications(NotificationManager notificationManager) {
        return notificationManager.getActiveNotifications();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NotificationApiHelperForM() {
    }
}
