package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompatApi23;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String str, ResultWrapper resultWrapper, Bundle bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        try {
            Field declaredField = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            sResultFlags = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            Log.w(TAG, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void notifyChildrenChanged(Object obj, String str, Bundle bundle) {
        ((MediaBrowserService) obj).notifyChildrenChanged(str, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getBrowserRootHints(Object obj) {
        return ((MediaBrowserService) obj).getBrowserRootHints();
    }

    static class ResultWrapper {
        MediaBrowserService.Result mResultObj;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResultWrapper(MediaBrowserService.Result result) {
            this.mResultObj = result;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void sendResult(List<Parcel> list, int i) {
            try {
                MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, i);
            } catch (IllegalAccessException e) {
                Log.w(MediaBrowserServiceCompatApi26.TAG, e);
            }
            this.mResultObj.sendResult(parcelListToItemList(list));
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

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            super(context, serviceCompatProxy);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(str, new ResultWrapper(result), bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaBrowserServiceCompatApi26() {
    }
}
