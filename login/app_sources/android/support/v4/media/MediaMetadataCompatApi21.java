package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import java.util.Set;

/* loaded from: classes5.dex */
class MediaMetadataCompatApi21 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Set<String> keySet(Object obj) {
        return ((MediaMetadata) obj).keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bitmap getBitmap(Object obj, String str) {
        return ((MediaMetadata) obj).getBitmap(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getLong(Object obj, String str) {
        return ((MediaMetadata) obj).getLong(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object getRating(Object obj, String str) {
        return ((MediaMetadata) obj).getRating(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getText(Object obj, String str) {
        return ((MediaMetadata) obj).getText(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        ((MediaMetadata) obj).writeToParcel(parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createFromParcel(Parcel parcel) {
        return MediaMetadata.CREATOR.createFromParcel(parcel);
    }

    public static class Builder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putBitmap(Object obj, String str, Bitmap bitmap) {
            ((MediaMetadata.Builder) obj).putBitmap(str, bitmap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putLong(Object obj, String str, long j) {
            ((MediaMetadata.Builder) obj).putLong(str, j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putRating(Object obj, String str, Object obj2) {
            ((MediaMetadata.Builder) obj).putRating(str, (Rating) obj2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putText(Object obj, String str, CharSequence charSequence) {
            ((MediaMetadata.Builder) obj).putText(str, charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putString(Object obj, String str, String str2) {
            ((MediaMetadata.Builder) obj).putString(str, str2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object build(Object obj) {
            return ((MediaMetadata.Builder) obj).build();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaMetadataCompatApi21() {
    }
}
