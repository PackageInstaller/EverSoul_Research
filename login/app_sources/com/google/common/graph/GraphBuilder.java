package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableGraph;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <N1 extends N> GraphBuilder<N1> cast() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GraphBuilder(boolean z) {
        super(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return new GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder()).incidentEdgeOrder(graph.incidentEdgeOrder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> ImmutableGraph.Builder<N1> immutable() {
        return new ImmutableGraph.Builder<>(cast());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GraphBuilder<N> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GraphBuilder<N> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.m188of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        GraphBuilder<N1> cast = cast();
        cast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> GraphBuilder<N1> incidentEdgeOrder(ElementOrder<N1> elementOrder) {
        Preconditions.checkArgument(elementOrder.type() == ElementOrder.Type.UNORDERED || elementOrder.type() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        GraphBuilder<N1> cast = cast();
        cast.incidentEdgeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return cast;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> MutableGraph<N1> build() {
        return new StandardMutableGraph(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GraphBuilder<N> copy() {
        GraphBuilder<N> graphBuilder = new GraphBuilder<>(this.directed);
        graphBuilder.allowsSelfLoops = this.allowsSelfLoops;
        graphBuilder.nodeOrder = this.nodeOrder;
        graphBuilder.expectedNodeCount = this.expectedNodeCount;
        graphBuilder.incidentEdgeOrder = this.incidentEdgeOrder;
        return graphBuilder;
    }
}
