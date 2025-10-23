package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class MediaBrowserServiceCompatApi21 {

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String str, int i, Bundle bundle);

        void onLoadChildren(String str, ResultWrapper<List<Parcel>> resultWrapper);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void onCreate(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static IBinder onBind(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setSessionToken(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void notifyChildrenChanged(Object obj, String str) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str);
    }

    static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResultWrapper(MediaBrowserService.Result result) {
            this.mResultObj = result;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void sendResult(T t) {
            if (t instanceof List) {
                this.mResultObj.sendResult(parcelListToItemList((List) t));
                return;
            }
            if (t instanceof Parcel) {
                Parcel parcel = (Parcel) t;
                parcel.setDataPosition(0);
                this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
                return;
            }
            this.mResultObj.sendResult(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void detach() {
            this.mResultObj.detach();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }
    }

    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        BrowserRoot(String str, Bundle bundle) {
            this.mRootId = str;
            this.mExtras = bundle;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.mServiceProxy = serviceCompatProxy;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            BrowserRoot onGetRoot = this.mServiceProxy.onGetRoot(str, i, bundle == null ? null : new Bundle(bundle));
            if (onGetRoot == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(onGetRoot.mRootId, onGetRoot.mExtras);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
            this.mServiceProxy.onLoadChildren(str, new ResultWrapper<>(result));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaBrowserServiceCompatApi21() {
    }
}
