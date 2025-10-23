package com.google.common.cache;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public enum RemovalCause {
    EXPLICIT { // from class: com.google.common.cache.RemovalCause.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    REPLACED { // from class: com.google.common.cache.RemovalCause.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    },
    COLLECTED { // from class: com.google.common.cache.RemovalCause.3
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    EXPIRED { // from class: com.google.common.cache.RemovalCause.4
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    },
    SIZE { // from class: com.google.common.cache.RemovalCause.5
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return true;
        }
    };

    abstract boolean wasEvicted();
}
