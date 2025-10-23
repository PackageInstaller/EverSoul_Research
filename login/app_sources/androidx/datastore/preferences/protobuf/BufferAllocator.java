package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: androidx.datastore.preferences.protobuf.BufferAllocator.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int i) {
            return AllocatedBuffer.wrap(new byte[i]);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.datastore.preferences.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i));
        }
    };

    public abstract AllocatedBuffer allocateDirectBuffer(int i);

    public abstract AllocatedBuffer allocateHeapBuffer(int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BufferAllocator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
