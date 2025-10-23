package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class EventStoreModule_PackageNameFactory implements Factory<String> {
    private final Provider<Context> contextProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EventStoreModule_PackageNameFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public String get() {
        return packageName(this.contextProvider.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EventStoreModule_PackageNameFactory create(Provider<Context> provider) {
        return new EventStoreModule_PackageNameFactory(provider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String packageName(Context context) {
        return (String) Preconditions.checkNotNull(EventStoreModule.packageName(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
