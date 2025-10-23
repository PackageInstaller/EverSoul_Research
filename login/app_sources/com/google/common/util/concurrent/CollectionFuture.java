package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    @CheckForNull
    private List<Present<V>> values;

    abstract C combine(List<Present<V>> list);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
        super(immutableCollection, z, true);
        List<Present<V>> newArrayListWithCapacity;
        if (immutableCollection.isEmpty()) {
            newArrayListWithCapacity = Collections.emptyList();
        } else {
            newArrayListWithCapacity = Lists.newArrayListWithCapacity(immutableCollection.size());
        }
        for (int i = 0; i < immutableCollection.size(); i++) {
            newArrayListWithCapacity.add(null);
        }
        this.values = newArrayListWithCapacity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AggregateFuture
    final void collectOneValue(int i, @ParametricNullness V v) {
        List<Present<V>> list = this.values;
        if (list != null) {
            list.set(i, new Present<>(v));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AggregateFuture
    final void handleAllCompleted() {
        List<Present<V>> list = this.values;
        if (list != null) {
            set(combine(list));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AggregateFuture
    void releaseResources(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.releaseResources(releaseResourcesReason);
        this.values = null;
    }

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z);
            init();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.CollectionFuture
        public List<V> combine(List<Present<V>> list) {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
            Iterator<Present<V>> it = list.iterator();
            while (it.hasNext()) {
                Present<V> next = it.next();
                newArrayListWithCapacity.add(next != null ? next.value : null);
            }
            return Collections.unmodifiableList(newArrayListWithCapacity);
        }
    }

    private static final class Present<V> {
        V value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Present(V v) {
            this.value = v;
        }
    }
}
