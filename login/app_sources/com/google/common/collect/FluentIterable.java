package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> iterableDelegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FluentIterable() {
        this.iterableDelegate = Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FluentIterable(Iterable<E> iterable) {
        this.iterableDelegate = Optional.m188of(iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Iterable<E> getDelegate() {
        return this.iterableDelegate.mo182or((Optional<Iterable<E>>) this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new FluentIterable<E>(iterable) { // from class: com.google.common.collect.FluentIterable.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> FluentIterable<E> from(E[] eArr) {
        return from(Arrays.asList(eArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> fluentIterable) {
        return (FluentIterable) Preconditions.checkNotNull(fluentIterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return concatNoDefensiveCopy(iterable, iterable2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3, iterable4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FluentIterable<T> concat(Iterable<? extends T>... iterableArr) {
        return concatNoDefensiveCopy((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() { // from class: com.google.common.collect.FluentIterable.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.concat(Iterators.transform(iterable.iterator(), Iterables.toIterator()));
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> FluentIterable<T> concatNoDefensiveCopy(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            Preconditions.checkNotNull(iterable);
        }
        return new FluentIterable<T>() { // from class: com.google.common.collect.FluentIterable.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.concat(new AbstractIndexedListIterator<Iterator<? extends T>>(iterableArr.length) { // from class: com.google.common.collect.FluentIterable.3.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.common.collect.AbstractIndexedListIterator
                    public Iterator<? extends T> get(int i) {
                        return iterableArr[i].iterator();
                    }
                });
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> FluentIterable<E> m200of() {
        return from(Collections.emptyList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> FluentIterable<E> m201of(@ParametricNullness E e, E... eArr) {
        return from(Lists.asList(e, eArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return Iterables.toString(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int size() {
        return Iterables.size(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean contains(@CheckForNull Object obj) {
        return Iterables.contains(getDelegate(), obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(getDelegate()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> append(Iterable<? extends E> iterable) {
        return concat(getDelegate(), iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> append(E... eArr) {
        return concat(getDelegate(), Arrays.asList(eArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> filter(Predicate<? super E> predicate) {
        return from(Iterables.filter(getDelegate(), predicate));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> FluentIterable<T> filter(Class<T> cls) {
        return from(Iterables.filter((Iterable<?>) getDelegate(), (Class) cls));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(getDelegate(), predicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(getDelegate(), predicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(getDelegate(), predicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> FluentIterable<T> transform(Function<? super E, T> function) {
        return from(Iterables.transform(getDelegate(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Optional<E> first() {
        Iterator<E> it = getDelegate().iterator();
        return it.hasNext() ? Optional.m188of(it.next()) : Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Optional<E> last() {
        E next;
        Iterable<E> delegate = getDelegate();
        if (delegate instanceof List) {
            List list = (List) delegate;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.m188of(list.get(list.size() - 1));
        }
        Iterator<E> it = delegate.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (delegate instanceof SortedSet) {
            return Optional.m188of(((SortedSet) delegate).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.m188of(next);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> skip(int i) {
        return from(Iterables.skip(getDelegate(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FluentIterable<E> limit(int i) {
        return from(Iterables.limit(getDelegate(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isEmpty() {
        return !getDelegate().iterator().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(getDelegate());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> function) {
        return Maps.toMap(getDelegate(), function);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> function) {
        return Multimaps.index(getDelegate(), function);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> function) {
        return Maps.uniqueIndex(getDelegate(), function);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final E[] toArray(Class<E> cls) {
        return (E[]) Iterables.toArray(getDelegate(), cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <C extends Collection<? super E>> C copyInto(C c) {
        Preconditions.checkNotNull(c);
        Iterable<E> delegate = getDelegate();
        if (delegate instanceof Collection) {
            c.addAll((Collection) delegate);
        } else {
            Iterator<E> it = delegate.iterator();
            while (it.hasNext()) {
                c.add(it.next());
            }
        }
        return c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    public final E get(int i) {
        return (E) Iterables.get(getDelegate(), i);
    }

    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FromIterableFunction() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }
}
