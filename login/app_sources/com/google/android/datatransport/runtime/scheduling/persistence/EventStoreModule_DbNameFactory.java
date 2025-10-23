package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class EventStoreModule_DbNameFactory implements Factory<String> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public String get() {
        return dbName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EventStoreModule_DbNameFactory create() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String dbName() {
        return (String) Preconditions.checkNotNull(EventStoreModule.dbName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    private static final class InstanceHolder {
        private static final EventStoreModule_DbNameFactory INSTANCE = new EventStoreModule_DbNameFactory();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceHolder() {
        }
    }
}
