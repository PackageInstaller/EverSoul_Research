package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* renamed from: fn */
    abstract long mo198fn(long j, long j2);

    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0 */
        volatile long f356p0;

        /* renamed from: p1 */
        volatile long f357p1;

        /* renamed from: p2 */
        volatile long f358p2;

        /* renamed from: p3 */
        volatile long f359p3;

        /* renamed from: p4 */
        volatile long f360p4;

        /* renamed from: p5 */
        volatile long f361p5;

        /* renamed from: p6 */
        volatile long f362p6;

        /* renamed from: q0 */
        volatile long f363q0;

        /* renamed from: q1 */
        volatile long f364q1;

        /* renamed from: q2 */
        volatile long f365q2;

        /* renamed from: q3 */
        volatile long f366q3;

        /* renamed from: q4 */
        volatile long f367q4;

        /* renamed from: q5 */
        volatile long f368q5;

        /* renamed from: q6 */
        volatile long f369q6;
        volatile long value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Cell(long j) {
            this.value = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        final boolean cas(long j, long j2) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j, j2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Striped64() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean casBase(long j, long j2) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void retryUpdate(long r17, @javax.annotation.CheckForNull int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.retryUpdate(long, int[], boolean):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void internalReset(long j) {
        Cell[] cellArr = this.cells;
        this.base = j;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.cache.Striped64.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        } catch (PrivilegedActionException e) {
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }
    }
}
