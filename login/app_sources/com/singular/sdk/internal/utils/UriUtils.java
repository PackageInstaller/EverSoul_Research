package com.singular.sdk.internal.utils;

import android.net.Uri;

/* loaded from: classes3.dex */
public class UriUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UriUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isValid(Uri uri) {
        return uri != null && uri.isHierarchical() && uri.isAbsolute();
    }
}
