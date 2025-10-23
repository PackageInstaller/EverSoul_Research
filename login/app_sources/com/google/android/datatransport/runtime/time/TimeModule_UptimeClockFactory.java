package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Clock get() {
        return uptimeClock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeModule_UptimeClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Clock uptimeClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.uptimeClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    private static final class InstanceHolder {
        private static final TimeModule_UptimeClockFactory INSTANCE = new TimeModule_UptimeClockFactory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceHolder() {
        }
    }
}
