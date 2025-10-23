package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes5.dex */
class MediaDescriptionCompatApi21 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getMediaId(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getTitle(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getSubtitle(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSequence getDescription(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bitmap getIconBitmap(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri getIconUri(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getExtras(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeToParcel(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object fromParcel(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    static class Builder {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setMediaId(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setTitle(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setSubtitle(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setDescription(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setIconBitmap(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setIconUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setExtras(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Object build(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaDescriptionCompatApi21() {
    }
}
