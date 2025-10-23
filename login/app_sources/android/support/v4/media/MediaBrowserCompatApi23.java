package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* loaded from: classes5.dex */
class MediaBrowserCompatApi23 {

    interface ItemCallback {
        void onError(String str);

        void onItemLoaded(Parcel parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getItem(Object obj, String str, Object obj2) {
        ((MediaBrowser) obj).getItem(str, (MediaBrowser.ItemCallback) obj2);
    }

    static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {
        protected final T mItemCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ItemCallbackProxy(T t) {
            this.mItemCallback = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.mItemCallback.onItemLoaded(null);
                return;
            }
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            this.mItemCallback.onItemLoaded(obtain);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            this.mItemCallback.onError(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaBrowserCompatApi23() {
    }
}
