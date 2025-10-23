package com.google.common.base;

import java.nio.Buffer;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Java8Compatibility {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void clear(Buffer buffer) {
        buffer.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void flip(Buffer buffer) {
        buffer.flip();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void limit(Buffer buffer, int i) {
        buffer.limit(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void position(Buffer buffer, int i) {
        buffer.position(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Java8Compatibility() {
    }
}
