package com.android.installreferrer.commons;

import android.util.Log;

/* loaded from: classes.dex */
public final class InstallReferrerCommons {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logVerbose(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            Log.v(str, str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logWarn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            Log.w(str, str2);
        }
    }
}
