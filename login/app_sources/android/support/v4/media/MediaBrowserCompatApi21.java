package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import java.util.List;

/* loaded from: classes5.dex */
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    interface SubscriptionCallback {
        void onChildrenLoaded(String str, List<?> list);

        void onError(String str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createConnectionCallback(ConnectionCallback connectionCallback) {
        return new ConnectionCallbackProxy(connectionCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createBrowser(Context context, ComponentName componentName, Object obj, Bundle bundle) {
        return new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) obj, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void connect(Object obj) {
        ((MediaBrowser) obj).connect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void disconnect(Object obj) {
        ((MediaBrowser) obj).disconnect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isConnected(Object obj) {
        return ((MediaBrowser) obj).isConnected();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ComponentName getServiceComponent(Object obj) {
        return ((MediaBrowser) obj).getServiceComponent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getRoot(Object obj) {
        return ((MediaBrowser) obj).getRoot();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getExtras(Object obj) {
        return ((MediaBrowser) obj).getExtras();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getSessionToken(Object obj) {
        return ((MediaBrowser) obj).getSessionToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void subscribe(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void unsubscribe(Object obj, String str) {
        ((MediaBrowser) obj).unsubscribe(str);
    }

    static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConnectionCallbackProxy(T t) {
            this.mConnectionCallback = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SubscriptionCallbackProxy(T t) {
            this.mSubscriptionCallback = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list) {
            this.mSubscriptionCallback.onChildrenLoaded(str, list);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str) {
            this.mSubscriptionCallback.onError(str);
        }
    }

    static class MediaItem {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getFlags(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getFlags();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object getDescription(Object obj) {
            return ((MediaBrowser.MediaItem) obj).getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MediaItem() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaBrowserCompatApi21() {
    }
}
