package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes5.dex */
class MediaControllerCompatApi24 {

    public static class TransportControls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void prepare(Object obj) {
            ((MediaController.TransportControls) obj).prepare();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void prepareFromMediaId(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromMediaId(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void prepareFromSearch(Object obj, String str, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromSearch(str, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void prepareFromUri(Object obj, Uri uri, Bundle bundle) {
            ((MediaController.TransportControls) obj).prepareFromUri(uri, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TransportControls() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaControllerCompatApi24() {
    }
}
