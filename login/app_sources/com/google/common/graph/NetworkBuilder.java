package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
    boolean allowsParallelEdges;
    ElementOrder<? super E> edgeOrder;
    Optional<Integer> expectedEdgeCount;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NetworkBuilder(boolean z) {
        super(z);
        this.allowsParallelEdges = false;
        this.edgeOrder = ElementOrder.insertion();
        this.expectedEdgeCount = Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(cast());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkBuilder<N, E> allowsParallelEdges(boolean z) {
        this.allowsParallelEdges = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkBuilder<N, E> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkBuilder<N, E> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.m188of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NetworkBuilder<N, E> expectedEdgeCount(int i) {
        this.expectedEdgeCount = Optional.m188of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> networkBuilder = (NetworkBuilder<N1, E>) cast();
        networkBuilder.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> networkBuilder = (NetworkBuilder<N, E1>) cast();
        networkBuilder.edgeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new StandardMutableNetwork(this);
    }
}
