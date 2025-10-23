package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class MediaSessionCompatApi21 {
    static final String TAG = "MediaSessionCompatApi21";

    interface Callback {
        void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void onCustomAction(String str, Bundle bundle);

        void onFastForward();

        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onPlayFromMediaId(String str, Bundle bundle);

        void onPlayFromSearch(String str, Bundle bundle);

        void onRewind();

        void onSeekTo(long j);

        void onSetRating(Object obj);

        void onSetRating(Object obj, Bundle bundle);

        void onSkipToNext();

        void onSkipToPrevious();

        void onSkipToQueueItem(long j);

        void onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createSession(Context context, String str) {
        return new MediaSession(context, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object verifySession(Object obj) {
        if (obj instanceof MediaSession) {
            return obj;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object verifyToken(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCallback(Object obj, Object obj2, Handler handler) {
        ((MediaSession) obj).setCallback((MediaSession.Callback) obj2, handler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setFlags(Object obj, int i) {
        ((MediaSession) obj).setFlags(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setPlaybackToLocal(Object obj, int i) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(i);
        ((MediaSession) obj).setPlaybackToLocal(builder.build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setPlaybackToRemote(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackToRemote((VolumeProvider) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setActive(Object obj, boolean z) {
        ((MediaSession) obj).setActive(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isActive(Object obj) {
        return ((MediaSession) obj).isActive();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void sendSessionEvent(Object obj, String str, Bundle bundle) {
        ((MediaSession) obj).sendSessionEvent(str, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void release(Object obj) {
        ((MediaSession) obj).release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Parcelable getSessionToken(Object obj) {
        return ((MediaSession) obj).getSessionToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setPlaybackState(Object obj, Object obj2) {
        ((MediaSession) obj).setPlaybackState((PlaybackState) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMetadata(Object obj, Object obj2) {
        ((MediaSession) obj).setMetadata((MediaMetadata) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setSessionActivity(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setSessionActivity(pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMediaButtonReceiver(Object obj, PendingIntent pendingIntent) {
        ((MediaSession) obj).setMediaButtonReceiver(pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setQueue(Object obj, List<Object> list) {
        if (list == null) {
            ((MediaSession) obj).setQueue(null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((MediaSession.QueueItem) it.next());
        }
        ((MediaSession) obj).setQueue(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setQueueTitle(Object obj, CharSequence charSequence) {
        ((MediaSession) obj).setQueueTitle(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setExtras(Object obj, Bundle bundle) {
        ((MediaSession) obj).setExtras(bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasCallback(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mCallback");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return declaredField.get(obj) != null;
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            Log.w(TAG, "Failed to get mCallback object.");
        }
        return false;
    }

    static class CallbackProxy<T extends Callback> extends MediaSession.Callback {
        protected final T mCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onCommand(str, bundle, resultReceiver);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.mCallback.onMediaButtonEvent(intent) || super.onMediaButtonEvent(intent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.mCallback.onPlay();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onPlayFromMediaId(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onPlayFromSearch(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            this.mCallback.onSkipToQueueItem(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.mCallback.onPause();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.mCallback.onSkipToNext();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.mCallback.onSkipToPrevious();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.mCallback.onFastForward();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.mCallback.onRewind();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.mCallback.onStop();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            this.mCallback.onSeekTo(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.mCallback.onSetRating(rating);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onCustomAction(str, bundle);
        }
    }

    static class QueueItem {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object createItem(Object obj, long j) {
            return new MediaSession.QueueItem((MediaDescription) obj, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object getDescription(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static long getQueueId(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private QueueItem() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaSessionCompatApi21() {
    }
}
