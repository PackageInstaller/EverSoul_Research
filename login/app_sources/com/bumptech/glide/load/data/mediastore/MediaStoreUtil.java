package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.liapp.y;

/* loaded from: classes.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= MINI_THUMB_HEIGHT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MediaStoreUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && y.֬ڱܱײٮ(-1159406207).equals(uri.getScheme()) && y.ۮڭڭܬި(862094195).equals(uri.getAuthority());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains(y.ݬֲ֮ܲت(1513079271));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }
}
