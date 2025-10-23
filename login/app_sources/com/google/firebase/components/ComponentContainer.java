package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes2.dex */
public interface ComponentContainer {
    <T> Deferred<T> getDeferred(Qualified<T> qualified);

    <T> Provider<T> getProvider(Qualified<T> qualified);

    <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> T get(Class<T> cls) {
        return (T) get(Qualified.unqualified(cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> Deferred<T> getDeferred(Class<T> cls) {
        return getDeferred(Qualified.unqualified(cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> Set<T> setOf(Class<T> cls) {
        return setOf(Qualified.unqualified(cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        return setOfProvider(Qualified.unqualified(cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> T get(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default <T> Set<T> setOf(Qualified<T> qualified) {
        return setOfProvider(qualified).get();
    }
}
