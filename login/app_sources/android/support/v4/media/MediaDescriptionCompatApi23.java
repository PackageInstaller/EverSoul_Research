package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* loaded from: classes5.dex */
class MediaDescriptionCompatApi23 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }

    static class Builder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaDescriptionCompatApi23() {
    }
}
