package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LongAddables() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.2
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LongAddable create() {
        return SUPPLIER.get();
    }

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PureJavaLongAddable() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }
}
