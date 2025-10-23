package com.google.android.gms.common.util;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class DefaultClock implements Clock {
    private static final DefaultClock zza = new DefaultClock();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DefaultClock() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Clock getInstance() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.util.Clock
    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.util.Clock
    public final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.util.Clock
    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.util.Clock
    public final long nanoTime() {
        return System.nanoTime();
    }
}
