package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;
import android.support.customtabs.trusted.ITrustedWebActivityService;

/* loaded from: classes.dex */
public final class TrustedWebActivityServiceConnection {
    private static final String KEY_ACTIVE_NOTIFICATIONS = "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS";
    private static final String KEY_CHANNEL_NAME = "android.support.customtabs.trusted.CHANNEL_NAME";
    private static final String KEY_NOTIFICATION = "android.support.customtabs.trusted.NOTIFICATION";
    private static final String KEY_NOTIFICATION_SUCCESS = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS";
    private static final String KEY_PLATFORM_ID = "android.support.customtabs.trusted.PLATFORM_ID";
    private static final String KEY_PLATFORM_TAG = "android.support.customtabs.trusted.PLATFORM_TAG";
    private final ComponentName mComponentName;
    private final ITrustedWebActivityService mService;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TrustedWebActivityServiceConnection(ITrustedWebActivityService iTrustedWebActivityService, ComponentName componentName) {
        this.mService = iTrustedWebActivityService;
        this.mComponentName = componentName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean areNotificationsEnabled(String str) throws RemoteException {
        return ResultArgs.fromBundle(this.mService.areNotificationsEnabled(new NotificationsEnabledArgs(str).toBundle())).success;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean notify(String str, int i, Notification notification, String str2) throws RemoteException {
        return ResultArgs.fromBundle(this.mService.notifyNotificationWithChannel(new NotifyNotificationArgs(str, i, notification, str2).toBundle())).success;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel(String str, int i) throws RemoteException {
        this.mService.cancelNotification(new CancelNotificationArgs(str, i).toBundle());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Parcelable[] getActiveNotifications() throws RemoteException {
        return ActiveNotificationsArgs.fromBundle(this.mService.getActiveNotifications()).notifications;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSmallIconId() throws RemoteException {
        return this.mService.getSmallIconId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bitmap getSmallIconBitmap() throws RemoteException {
        return (Bitmap) this.mService.getSmallIconBitmap().getParcelable(TrustedWebActivityService.KEY_SMALL_ICON_BITMAP);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle sendExtraCommand(String str, Bundle bundle, TrustedWebActivityCallback trustedWebActivityCallback) throws RemoteException {
        ITrustedWebActivityCallback wrapCallback = wrapCallback(trustedWebActivityCallback);
        return this.mService.extraCommand(str, bundle, wrapCallback == null ? null : wrapCallback.asBinder());
    }

    static class NotifyNotificationArgs {
        public final String channelName;
        public final Notification notification;
        public final int platformId;
        public final String platformTag;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NotifyNotificationArgs(String str, int i, Notification notification, String str2) {
            this.platformTag = str;
            this.platformId = i;
            this.notification = notification;
            this.channelName = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static NotifyNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG);
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_PLATFORM_ID);
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_NOTIFICATION);
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME);
            return new NotifyNotificationArgs(bundle.getString(TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG), bundle.getInt(TrustedWebActivityServiceConnection.KEY_PLATFORM_ID), (Notification) bundle.getParcelable(TrustedWebActivityServiceConnection.KEY_NOTIFICATION), bundle.getString(TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG, this.platformTag);
            bundle.putInt(TrustedWebActivityServiceConnection.KEY_PLATFORM_ID, this.platformId);
            bundle.putParcelable(TrustedWebActivityServiceConnection.KEY_NOTIFICATION, this.notification);
            bundle.putString(TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME, this.channelName);
            return bundle;
        }
    }

    static class CancelNotificationArgs {
        public final int platformId;
        public final String platformTag;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CancelNotificationArgs(String str, int i) {
            this.platformTag = str;
            this.platformId = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CancelNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG);
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_PLATFORM_ID);
            return new CancelNotificationArgs(bundle.getString(TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG), bundle.getInt(TrustedWebActivityServiceConnection.KEY_PLATFORM_ID));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceConnection.KEY_PLATFORM_TAG, this.platformTag);
            bundle.putInt(TrustedWebActivityServiceConnection.KEY_PLATFORM_ID, this.platformId);
            return bundle;
        }
    }

    static class ResultArgs {
        public final boolean success;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResultArgs(boolean z) {
            this.success = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ResultArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_NOTIFICATION_SUCCESS);
            return new ResultArgs(bundle.getBoolean(TrustedWebActivityServiceConnection.KEY_NOTIFICATION_SUCCESS));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(TrustedWebActivityServiceConnection.KEY_NOTIFICATION_SUCCESS, this.success);
            return bundle;
        }
    }

    static class ActiveNotificationsArgs {
        public final Parcelable[] notifications;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.notifications = parcelableArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ActiveNotificationsArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_ACTIVE_NOTIFICATIONS);
            return new ActiveNotificationsArgs(bundle.getParcelableArray(TrustedWebActivityServiceConnection.KEY_ACTIVE_NOTIFICATIONS));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(TrustedWebActivityServiceConnection.KEY_ACTIVE_NOTIFICATIONS, this.notifications);
            return bundle;
        }
    }

    static class NotificationsEnabledArgs {
        public final String channelName;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NotificationsEnabledArgs(String str) {
            this.channelName = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static NotificationsEnabledArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceConnection.ensureBundleContains(bundle, TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME);
            return new NotificationsEnabledArgs(bundle.getString(TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceConnection.KEY_CHANNEL_NAME, this.channelName);
            return bundle;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void ensureBundleContains(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException("Bundle must contain " + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ITrustedWebActivityCallback wrapCallback(final TrustedWebActivityCallback trustedWebActivityCallback) {
        if (trustedWebActivityCallback == null) {
            return null;
        }
        return new ITrustedWebActivityCallback.Stub() { // from class: androidx.browser.trusted.TrustedWebActivityServiceConnection.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String str, Bundle bundle) throws RemoteException {
                TrustedWebActivityCallback.this.onExtraCallback(str, bundle);
            }
        };
    }
}
