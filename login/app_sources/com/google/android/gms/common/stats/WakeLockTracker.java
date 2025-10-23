package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@Deprecated
/* loaded from: classes.dex */
public class WakeLockTracker {
    private static final WakeLockTracker zza = new WakeLockTracker();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static WakeLockTracker getInstance() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, String str4) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerDeadlineEvent(Context context, String str, String str2, String str3, int i, List<String> list, boolean z, long j) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void registerReleaseEvent(Context context, Intent intent) {
    }
}
