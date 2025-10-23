package com.google.common.graph;

import com.google.common.graph.GraphConstants;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StandardMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n) {
        return this.backingValueGraph.addNode(n);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n, N n2) {
        return this.backingValueGraph.putEdgeValue(n, n2, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n) {
        return this.backingValueGraph.removeNode(n);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n, N n2) {
        return this.backingValueGraph.removeEdge(n, n2) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
