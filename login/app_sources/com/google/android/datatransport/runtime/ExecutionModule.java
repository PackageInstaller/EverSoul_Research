package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

@Module
/* loaded from: classes.dex */
abstract class ExecutionModule {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExecutionModule() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    @Singleton
    static Executor executor() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
