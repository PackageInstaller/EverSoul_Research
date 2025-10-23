package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@Immutable(containerOf = {"N", "E"})
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors((ImmutableNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors((ImmutableNetwork<N, E>) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), getNodeConnections(network), getEdgeToReferenceNode(network));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        if (network instanceof ImmutableNetwork) {
            return (ImmutableNetwork) network;
        }
        return new ImmutableNetwork<>(network);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> Map<N, NetworkConnections<N, E>> getNodeConnections(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n : network.nodes()) {
            builder.put(n, connectionsOf(network, n));
        }
        return builder.buildOrThrow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> Map<E, N> getEdgeToReferenceNode(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E e : network.edges()) {
            builder.put(e, network.incidentNodes(e).nodeU());
        }
        return builder.buildOrThrow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> NetworkConnections<N, E> connectionsOf(Network<N, E> network, N n) {
        if (network.isDirected()) {
            Map asMap = Maps.asMap(network.inEdges(n), sourceNodeFn(network));
            Map asMap2 = Maps.asMap(network.outEdges(n), targetNodeFn(network));
            int size = network.edgesConnecting(n, n).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.ofImmutable(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.ofImmutable(asMap, asMap2, size);
        }
        Map asMap3 = Maps.asMap(network.incidentEdges(n), adjacentNodeFn(network, n));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.ofImmutable(asMap3);
        }
        return UndirectedNetworkConnections.ofImmutable(asMap3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> Function<E, N> sourceNodeFn(final Network<N, E> network) {
        return new Function() { // from class: com.google.common.graph.ImmutableNetwork$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object source;
                source = Network.this.incidentNodes(obj).source();
                return source;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> Function<E, N> targetNodeFn(final Network<N, E> network) {
        return new Function() { // from class: com.google.common.graph.ImmutableNetwork$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object target;
                target = Network.this.incidentNodes(obj).target();
                return target;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <N, E> Function<E, N> adjacentNodeFn(final Network<N, E> network, final N n) {
        return new Function() { // from class: com.google.common.graph.ImmutableNetwork$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object adjacentNode;
                adjacentNode = Network.this.incidentNodes(obj).adjacentNode(n);
                return adjacentNode;
            }
        };
    }

    public static class Builder<N, E> {
        private final MutableNetwork<N, E> mutableNetwork;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder(NetworkBuilder<N, E> networkBuilder) {
            this.mutableNetwork = (MutableNetwork<N, E>) networkBuilder.build();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder<N, E> addNode(N n) {
            this.mutableNetwork.addNode(n);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder<N, E> addEdge(N n, N n2, E e) {
            this.mutableNetwork.addEdge(n, n2, e);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e) {
            this.mutableNetwork.addEdge(endpointPair, e);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.mutableNetwork);
        }
    }
}
