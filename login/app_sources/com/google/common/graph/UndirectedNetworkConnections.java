package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UndirectedNetworkConnections(Map<E, N> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    static <N, E> UndirectedNetworkConnections<N, E> m333of() {
        return new UndirectedNetworkConnections<>(HashBiMap.create(2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap) this.incidentEdgeMap).values());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(N n) {
        return new EdgesConnecting(((BiMap) this.incidentEdgeMap).inverse(), n);
    }
}
