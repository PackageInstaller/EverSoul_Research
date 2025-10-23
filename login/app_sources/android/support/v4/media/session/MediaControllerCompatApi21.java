package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int i, int i2, int i3, int i4, int i5);

        void onExtrasChanged(Bundle bundle);

        void onMetadataChanged(Object obj);

        void onPlaybackStateChanged(Object obj);

        void onQueueChanged(List<?> list);

        void onQueueTitleChanged(CharSequence charSequence);

        void onSessionDestroyed();

        void onSessionEvent(String str, Bundle bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object fromToken(Context context, Object obj) {
        return new MediaController(context, (MediaSession.Token) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void registerCallback(Object obj, Object obj2, Handler handler) {
        ((MediaController) obj).registerCallback((MediaController.Callback) obj2, handler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void unregisterCallback(Object obj, Object obj2) {
        ((MediaController) obj).unregisterCallback((MediaController.Callback) obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMediaController(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getMediaController(Activity activity) {
        return activity.getMediaController();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getSessionToken(Object obj) {
        return ((MediaController) obj).getSessionToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getTransportControls(Object obj) {
        return ((MediaController) obj).getTransportControls();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getPlaybackState(Object obj) {
        return ((MediaController) obj).getPlaybackState();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getMetadata(Object obj) {
        return ((MediaController) obj).getMetadata();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Object> getQueue(Object obj) {
        List<MediaSession.QueueItem> queue = ((MediaController) obj).getQueue();
        if (queue == null) {
            return null;
        }
        return new ArrayList(queue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getQueueTitle(Object obj) {
        return ((MediaController) obj).getQueueTitle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getExtras(Object obj) {
        return ((MediaController) obj).getExtras();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getRatingType(Object obj) {
        return ((MediaController) obj).getRatingType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getFlags(Object obj) {
        return ((MediaController) obj).getFlags();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getPlaybackInfo(Object obj) {
        return ((MediaController) obj).getPlaybackInfo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PendingIntent getSessionActivity(Object obj) {
        return ((MediaController) obj).getSessionActivity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean dispatchMediaButtonEvent(Object obj, KeyEvent keyEvent) {
        return ((MediaController) obj).dispatchMediaButtonEvent(keyEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setVolumeTo(Object obj, int i, int i2) {
        ((MediaController) obj).setVolumeTo(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void adjustVolume(Object obj, int i, int i2) {
        ((MediaController) obj).adjustVolume(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void sendCommand(Object obj, String str, Bundle bundle, ResultReceiver resultReceiver) {
        ((MediaController) obj).sendCommand(str, bundle, resultReceiver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Object obj) {
        return ((MediaController) obj).getPackageName();
    }

    public static class TransportControls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void play(Object obj) {
            ((MediaController.TransportControls) obj).play();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void pause(Object obj) {
            ((MediaController.TransportControls) obj).pause();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void stop(Object obj) {
            ((MediaController.TransportControls) obj).stop();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void seekTo(Object obj, long j) {
            ((MediaController.TransportControls) obj).seekTo(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void fastForward(Object obj) {
            ((MediaController.TransportControls) obj).fastForward();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void rewind(Object obj) {
            ((MediaController.TransportControls) obj).rewind();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void skipToNext(Object obj) {
            ((MediaController.TransportControls) obj).skipToNext();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void skipToPrevious(Object obj) {
            ((MediaController.TransportControls) obj).skipToPrevious();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setRating(Object obj, Object obj2) {
            ((MediaController.TransportControls) obj).setRating((Rating) obj2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void playFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromMediaId(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void playFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromSearch(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void skipToQueueItem(Object obj, long j) {
            ((MediaController.TransportControls) obj).skipToQueueItem(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void sendCustomAction(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).sendCustomAction(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TransportControls() {
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getPlaybackType(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getPlaybackType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AudioAttributes getAudioAttributes(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getLegacyAudioStream(Object obj) {
            return toLegacyStreamType(getAudioAttributes(obj));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getVolumeControl(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getVolumeControl();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getMaxVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getMaxVolume();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getCurrentVolume(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getCurrentVolume();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static int toLegacyStreamType(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage == 13) {
                return 1;
            }
            switch (usage) {
                case 2:
                    return 0;
                case 3:
                    return 8;
                case 4:
                    return 4;
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                    return 5;
                case 6:
                    return 2;
                default:
                    return 3;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PlaybackInfo() {
        }
    }

    static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T mCallback;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CallbackProxy(T t) {
            this.mCallback = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onSessionEvent(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.mCallback.onPlaybackStateChanged(playbackState);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.mCallback.onMetadataChanged(mediaMetadata);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.mCallback.onQueueChanged(list);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.mCallback.onQueueTitleChanged(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.ensureClassLoader(bundle);
            this.mCallback.onExtrasChanged(bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.mCallback.onAudioInfoChanged(playbackInfo.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaControllerCompatApi21() {
    }
}
