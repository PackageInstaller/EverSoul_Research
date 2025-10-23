package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* loaded from: classes.dex */
public final class EventStoreModule_SchemaVersionFactory implements Factory<Integer> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(schemaVersion());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EventStoreModule_SchemaVersionFactory create() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int schemaVersion() {
        return EventStoreModule.schemaVersion();
    }

    private static final class InstanceHolder {
        private static final EventStoreModule_SchemaVersionFactory INSTANCE = new EventStoreModule_SchemaVersionFactory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceHolder() {
        }
    }
}
