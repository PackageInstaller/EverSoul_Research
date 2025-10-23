package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class TimeModule_EventClockFactory implements Factory<Clock> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Clock get() {
        return eventClock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeModule_EventClockFactory create() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Clock eventClock() {
        return (Clock) Preconditions.checkNotNull(TimeModule.eventClock(), "Cannot return null from a non-@Nullable @Provides method");
    }

    private static final class InstanceHolder {
        private static final TimeModule_EventClockFactory INSTANCE = new TimeModule_EventClockFactory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceHolder() {
        }
    }
}
