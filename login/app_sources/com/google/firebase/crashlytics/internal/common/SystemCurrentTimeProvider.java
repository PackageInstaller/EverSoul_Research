package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public class SystemCurrentTimeProvider implements CurrentTimeProvider {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.common.CurrentTimeProvider
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
