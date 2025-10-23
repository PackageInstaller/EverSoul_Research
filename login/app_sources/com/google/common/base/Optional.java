package com.google.common.base;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@DoNotMock("Use Optional.of(value) or Optional.absent()")
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    /* renamed from: or */
    public abstract Optional<T> mo180or(Optional<? extends T> optional);

    /* renamed from: or */
    public abstract T mo181or(Supplier<? extends T> supplier);

    /* renamed from: or */
    public abstract T mo182or(T t);

    @CheckForNull
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <T> Optional<T> m188of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Optional<T> fromNullable(@CheckForNull T t) {
        return t == null ? absent() : new Present(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Optional() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() { // from class: com.google.common.base.Optional.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() { // from class: com.google.common.base.Optional.1.1
                    private final Iterator<? extends Optional<? extends T>> iterator;

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        this.iterator = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.common.base.AbstractIterator
                    @CheckForNull
                    protected T computeNext() {
                        while (this.iterator.hasNext()) {
                            Optional<? extends T> next = this.iterator.next();
                            if (next.isPresent()) {
                                return next.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }
}
