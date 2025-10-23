package com.unity3d.player;

import android.app.Activity;

/* loaded from: classes3.dex */
public class MultiWindowSupport {
    private static boolean s_LastMultiWindowMode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isInMultiWindowMode(Activity activity) {
        if (activity != null && PlatformSupport.NOUGAT_SUPPORT) {
            return activity.isInMultiWindowMode();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMultiWindowModeChangedToTrue(Activity activity) {
        return !s_LastMultiWindowMode && isInMultiWindowMode(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void saveMultiWindowMode(Activity activity) {
        s_LastMultiWindowMode = isInMultiWindowMode(activity);
    }
}
