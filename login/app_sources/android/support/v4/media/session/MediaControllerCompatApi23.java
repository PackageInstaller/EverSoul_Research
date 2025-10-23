package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes5.dex */
class MediaControllerCompatApi23 {

    public static class TransportControls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void playFromUri(Object obj, Uri uri, Bundle bundle) {
            ((MediaController.TransportControls) obj).playFromUri(uri, bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TransportControls() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaControllerCompatApi23() {
    }
}
