package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AbstractBaseGraph() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected long edgeCount() {
        long j = 0;
        while (nodes().iterator().hasNext()) {
            j += degree(r0.next());
        }
        Preconditions.checkState((1 & j) == 0);
        return j >>> 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.m330of(AbstractBaseGraph.this);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV());
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n) {
        Preconditions.checkNotNull(n);
        Preconditions.checkArgument(nodes().contains(n), "Node %s is not an element of this graph.", n);
        return new C15212(this, this, n);
    }

    /* renamed from: com.google.common.graph.AbstractBaseGraph$2 */
    class C15212 extends IncidentEdgeSet<N> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C15212(AbstractBaseGraph abstractBaseGraph, BaseGraph baseGraph, Object obj) {
            super(baseGraph, obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
            if (this.graph.isDirected()) {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((BaseGraph<N>) this.node).iterator(), new Function() { // from class: com.google.common.graph.AbstractBaseGraph$2$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return AbstractBaseGraph.C15212.this.m1161lambda$iterator$0$comgooglecommongraphAbstractBaseGraph$2(obj);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors((BaseGraph<N>) this.node), ImmutableSet.m263of(this.node)).iterator(), new Function() { // from class: com.google.common.graph.AbstractBaseGraph$2$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        return AbstractBaseGraph.C15212.this.m1162lambda$iterator$1$comgooglecommongraphAbstractBaseGraph$2(obj);
                    }
                })));
            }
            return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function() { // from class: com.google.common.graph.AbstractBaseGraph$2$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return AbstractBaseGraph.C15212.this.m1163lambda$iterator$2$comgooglecommongraphAbstractBaseGraph$2(obj);
                }
            }));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: lambda$iterator$0$com-google-common-graph-AbstractBaseGraph$2, reason: not valid java name */
        /* synthetic */ EndpointPair m1161lambda$iterator$0$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
            return EndpointPair.ordered(obj, this.node);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: lambda$iterator$1$com-google-common-graph-AbstractBaseGraph$2, reason: not valid java name */
        /* synthetic */ EndpointPair m1162lambda$iterator$1$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
            return EndpointPair.ordered(this.node, obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: lambda$iterator$2$com-google-common-graph-AbstractBaseGraph$2, reason: not valid java name */
        /* synthetic */ EndpointPair m1163lambda$iterator$2$comgooglecommongraphAbstractBaseGraph$2(Object obj) {
            return EndpointPair.unordered(this.node, obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public int degree(N n) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n).size(), successors((Object) n).size());
        }
        Set<N> adjacentNodes = adjacentNodes(n);
        return IntMath.saturatedAdd(adjacentNodes.size(), (allowsSelfLoops() && adjacentNodes.contains(n)) ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n) {
        return isDirected() ? predecessors((Object) n).size() : degree(n);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n) {
        return isDirected() ? successors((Object) n).size() : degree(n);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n, N n2) {
        Preconditions.checkNotNull(n);
        Preconditions.checkNotNull(n2);
        return nodes().contains(n) && successors((Object) n).contains(n2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nodeU = endpointPair.nodeU();
        return nodes().contains(nodeU) && successors((Object) nodeU).contains(endpointPair.nodeV());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), "Mismatch: unordered endpoints cannot be used with directed graphs");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }
}
