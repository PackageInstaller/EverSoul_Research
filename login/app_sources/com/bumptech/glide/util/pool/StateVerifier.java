package com.bumptech.glide.util.pool;

import com.liapp.y;

/* loaded from: classes.dex */
public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    abstract void setRecycled(boolean z);

    public abstract void throwIfRecycled();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StateVerifier() {
    }

    private static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DefaultStateVerifier() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException(y.ݬֲ֮ܲت(1512970775));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void setRecycled(boolean z) {
            this.isReleased = z;
        }
    }

    private static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DebugStateVerifier() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.util.pool.StateVerifier
        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new IllegalStateException(y.ݬֲ֮ܲت(1512970775), this.recycledAtStackTraceException);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.util.pool.StateVerifier
        void setRecycled(boolean z) {
            if (z) {
                this.recycledAtStackTraceException = new RuntimeException(y.دײܮڳܯ(2051945293));
            } else {
                this.recycledAtStackTraceException = null;
            }
        }
    }
}
