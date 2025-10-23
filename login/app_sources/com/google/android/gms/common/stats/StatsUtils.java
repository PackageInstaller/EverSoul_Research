package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@Deprecated
/* loaded from: classes.dex */
public class StatsUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getEventKey(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock));
        if (true == TextUtils.isEmpty(str)) {
            str = "";
        }
        return String.valueOf(valueOf).concat(String.valueOf(str));
    }
}
