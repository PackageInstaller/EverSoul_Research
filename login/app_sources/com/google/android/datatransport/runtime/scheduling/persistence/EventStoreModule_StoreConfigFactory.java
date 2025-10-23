package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class EventStoreModule_StoreConfigFactory implements Factory<EventStoreConfig> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public EventStoreConfig get() {
        return storeConfig();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EventStoreModule_StoreConfigFactory create() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EventStoreConfig storeConfig() {
        return (EventStoreConfig) Preconditions.checkNotNull(EventStoreModule.storeConfig(), "Cannot return null from a non-@Nullable @Provides method");
    }

    private static final class InstanceHolder {
        private static final EventStoreModule_StoreConfigFactory INSTANCE = new EventStoreModule_StoreConfigFactory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceHolder() {
        }
    }
}
