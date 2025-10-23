package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableValueGraph;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class ValueGraphBuilder<N, V> extends AbstractGraphBuilder<N> {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <N1 extends N, V1 extends V> ValueGraphBuilder<N1, V1> cast() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ValueGraphBuilder(boolean z) {
        super(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ValueGraphBuilder<Object, Object> directed() {
        return new ValueGraphBuilder<>(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ValueGraphBuilder<Object, Object> undirected() {
        return new ValueGraphBuilder<>(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N, V> ValueGraphBuilder<N, V> from(ValueGraph<N, V> valueGraph) {
        return new ValueGraphBuilder(valueGraph.isDirected()).allowsSelfLoops(valueGraph.allowsSelfLoops()).nodeOrder(valueGraph.nodeOrder()).incidentEdgeOrder(valueGraph.incidentEdgeOrder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N, V1 extends V> ImmutableValueGraph.Builder<N1, V1> immutable() {
        return new ImmutableValueGraph.Builder<>(cast());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ValueGraphBuilder<N, V> allowsSelfLoops(boolean z) {
        this.allowsSelfLoops = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ValueGraphBuilder<N, V> expectedNodeCount(int i) {
        this.expectedNodeCount = Optional.m188of(Integer.valueOf(Graphs.checkNonNegative(i)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> ValueGraphBuilder<N1, V> nodeOrder(ElementOrder<N1> elementOrder) {
        ValueGraphBuilder<N1, V> valueGraphBuilder = (ValueGraphBuilder<N1, V>) cast();
        valueGraphBuilder.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return valueGraphBuilder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N> ValueGraphBuilder<N1, V> incidentEdgeOrder(ElementOrder<N1> elementOrder) {
        Preconditions.checkArgument(elementOrder.type() == ElementOrder.Type.UNORDERED || elementOrder.type() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        ValueGraphBuilder<N1, V> valueGraphBuilder = (ValueGraphBuilder<N1, V>) cast();
        valueGraphBuilder.incidentEdgeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return valueGraphBuilder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> build() {
        return new StandardMutableValueGraph(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ValueGraphBuilder<N, V> copy() {
        ValueGraphBuilder<N, V> valueGraphBuilder = new ValueGraphBuilder<>(this.directed);
        valueGraphBuilder.allowsSelfLoops = this.allowsSelfLoops;
        valueGraphBuilder.nodeOrder = this.nodeOrder;
        valueGraphBuilder.expectedNodeCount = this.expectedNodeCount;
        valueGraphBuilder.incidentEdgeOrder = this.incidentEdgeOrder;
        return valueGraphBuilder;
    }
}
