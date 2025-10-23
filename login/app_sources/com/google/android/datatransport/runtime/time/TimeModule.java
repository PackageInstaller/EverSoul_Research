package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;

@Module
/* loaded from: classes.dex */
public abstract class TimeModule {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    static Clock eventClock() {
        return new WallTimeClock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    static Clock uptimeClock() {
        return new UptimeClock();
    }
}
