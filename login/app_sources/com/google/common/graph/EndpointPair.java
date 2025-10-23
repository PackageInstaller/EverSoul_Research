package com.google.common.graph;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N"})
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class EndpointPair<N> implements Iterable<N> {
    private final N nodeU;
    private final N nodeV;

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public abstract N source();

    public abstract N target();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EndpointPair(N n, N n2) {
        this.nodeU = (N) Preconditions.checkNotNull(n);
        this.nodeV = (N) Preconditions.checkNotNull(n2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N> EndpointPair<N> ordered(N n, N n2) {
        return new Ordered(n, n2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <N> EndpointPair<N> unordered(N n, N n2) {
        return new Unordered(n2, n);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    static <N> EndpointPair<N> m328of(Graph<?> graph, N n, N n2) {
        return graph.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    static <N> EndpointPair<N> m329of(Network<?, ?> network, N n, N n2) {
        return network.isDirected() ? ordered(n, n2) : unordered(n, n2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final N nodeU() {
        return this.nodeU;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final N nodeV() {
        return this.nodeV;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final N adjacentNode(N n) {
        if (n.equals(this.nodeU)) {
            return this.nodeV;
        }
        if (n.equals(this.nodeV)) {
            return this.nodeU;
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(n);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length()).append("EndpointPair ").append(valueOf).append(" does not contain node ").append(valueOf2).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.nodeU, this.nodeV);
    }

    private static final class Ordered<N> extends EndpointPair<N> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Ordered(N n, N n2) {
            super(n, n2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            return source().equals(endpointPair.source()) && target().equals(endpointPair.target());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(source());
            String valueOf2 = String.valueOf(target());
            return new StringBuilder(String.valueOf(valueOf).length() + 6 + String.valueOf(valueOf2).length()).append("<").append(valueOf).append(" -> ").append(valueOf2).append(">").toString();
        }
    }

    private static final class Unordered<N> extends EndpointPair<N> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Unordered(N n, N n2) {
            super(n, n2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            return nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(nodeU());
            String valueOf2 = String.valueOf(nodeV());
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length()).append("[").append(valueOf).append(", ").append(valueOf2).append("]").toString();
        }
    }
}
