package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;

@Module
/* loaded from: classes.dex */
public abstract class SchedulingConfigModule {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    static SchedulerConfig config(Clock clock) {
        return SchedulerConfig.getDefault(clock);
    }
}
