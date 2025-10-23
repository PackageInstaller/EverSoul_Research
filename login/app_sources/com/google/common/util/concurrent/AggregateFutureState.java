package com.google.common.util.concurrent;

import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import kotlin.UByte$$ExternalSyntheticBackport0;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    abstract void addInitialException(Set<Throwable> set);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ int access$306(AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.remaining - 1;
        aggregateFutureState.remaining = i;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        AtomicHelper synchronizedAtomicHelper;
        Throwable th = null;
        byte b = 0;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
        } catch (Throwable th2) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th = th2;
        }
        ATOMIC_HELPER = synchronizedAtomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AggregateFutureState(int i) {
        this.remaining = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set<Throwable> newConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(newConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, newConcurrentHashSet);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    private static abstract class AtomicHelper {
        abstract void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        abstract int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AtomicHelper() {
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            UByte$$ExternalSyntheticBackport0.m852m(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SynchronizedAtomicHelper() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (((AggregateFutureState) aggregateFutureState).seenExceptions == set) {
                    ((AggregateFutureState) aggregateFutureState).seenExceptions = set2;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            int access$306;
            synchronized (aggregateFutureState) {
                access$306 = AggregateFutureState.access$306(aggregateFutureState);
            }
            return access$306;
        }
    }
}
