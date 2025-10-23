package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;
import com.google.android.datatransport.runtime.dagger.Provides;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
/* loaded from: classes.dex */
public abstract class EventStoreModule {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    @Named("SQLITE_DB_NAME")
    static String dbName() {
        return "com.google.android.datatransport.events";
    }

    @Binds
    abstract ClientHealthMetricsStore clientHealthMetricsStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    abstract EventStore eventStore(SQLiteEventStore sQLiteEventStore);

    @Binds
    abstract SynchronizationGuard synchronizationGuard(SQLiteEventStore sQLiteEventStore);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    static EventStoreConfig storeConfig() {
        return EventStoreConfig.DEFAULT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    @Named("SCHEMA_VERSION")
    static int schemaVersion() {
        return SchemaManager.SCHEMA_VERSION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    @Singleton
    @Named("PACKAGE_NAME")
    static String packageName(Context context) {
        return context.getPackageName();
    }
}
