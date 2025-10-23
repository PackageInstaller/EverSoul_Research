package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
class PlaybackStateCompatApi21 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getState(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getPosition(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getBufferedPosition(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getPlaybackSpeed(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getActions(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getErrorMessage(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getLastPositionUpdateTime(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Object> getCustomActions(Object obj) {
        return ((PlaybackState) obj).getCustomActions();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getActiveQueueItemId(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object newInstance(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<Object> list, long j5) {
        PlaybackState.Builder builder = new PlaybackState.Builder();
        builder.setState(i, j, f, j4);
        builder.setBufferedPosition(j2);
        builder.setActions(j3);
        builder.setErrorMessage(charSequence);
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            builder.addCustomAction((PlaybackState.CustomAction) it.next());
        }
        builder.setActiveQueueItemId(j5);
        return builder.build();
    }

    static final class CustomAction {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static String getAction(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static CharSequence getName(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getIcon(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Bundle getExtras(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object newInstance(String str, CharSequence charSequence, int i, Bundle bundle) {
            PlaybackState.CustomAction.Builder builder = new PlaybackState.CustomAction.Builder(str, charSequence, i);
            builder.setExtras(bundle);
            return builder.build();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CustomAction() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PlaybackStateCompatApi21() {
    }
}
