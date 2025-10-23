package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* loaded from: classes5.dex */
class MediaBrowserCompatApi26 {

    interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(String str, List<?> list, Bundle bundle);

        void onError(String str, Bundle bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object createSubscriptionCallback(SubscriptionCallback subscriptionCallback) {
        return new SubscriptionCallbackProxy(subscriptionCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void subscribe(Object obj, String str, Bundle bundle, Object obj2) {
        ((MediaBrowser) obj).subscribe(str, bundle, (MediaBrowser.SubscriptionCallback) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void unsubscribe(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).unsubscribe(str, (MediaBrowser.SubscriptionCallback) obj2);
    }

    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SubscriptionCallbackProxy(T t) {
            super(t);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List<MediaBrowser.MediaItem> list, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(str, list, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((SubscriptionCallback) this.mSubscriptionCallback).onError(str, bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaBrowserCompatApi26() {
    }
}
