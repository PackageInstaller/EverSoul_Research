package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Hashing {

    /* renamed from: C1 */
    private static final long f373C1 = -862048943;

    /* renamed from: C2 */
    private static final long f374C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean needsResizing(int i, int i2, double d) {
        return ((double) i) > d * ((double) i2) && i2 < 1073741824;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Hashing() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int smear(int i) {
        return (int) (Integer.rotateLeft((int) (i * f373C1), 15) * f374C2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int smearedHash(@CheckForNull Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int closedTableSize(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d * highestOneBit))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }
}
