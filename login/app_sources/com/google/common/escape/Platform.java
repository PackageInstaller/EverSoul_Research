package com.google.common.escape;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() { // from class: com.google.common.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Platform() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }
}
