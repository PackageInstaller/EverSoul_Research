package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class SharedPreferencesUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SharedPreferencesUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void publishWorldReadableSharedPreferences(Context context, SharedPreferences.Editor editor, String str) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
