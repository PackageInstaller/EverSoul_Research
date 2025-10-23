package com.google.firebase.installations.time;

/* loaded from: classes2.dex */
public class SystemClock implements Clock {
    private static SystemClock singleton;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SystemClock() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SystemClock getInstance() {
        if (singleton == null) {
            singleton = new SystemClock();
        }
        return singleton;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
