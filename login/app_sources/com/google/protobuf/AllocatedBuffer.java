package com.google.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes3.dex */
abstract class AllocatedBuffer {
    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AllocatedBuffer() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AllocatedBuffer wrap(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return wrapNoCheck(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] array() {
                return byteBuffer.array();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i) {
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int limit() {
                return byteBuffer.limit();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() { // from class: com.google.protobuf.AllocatedBuffer.2
            private int position;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public byte[] array() {
                return bArr;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i3) {
                if (i3 < 0 || i3 > i2) {
                    throw new IllegalArgumentException("Invalid position: " + i3);
                }
                this.position = i3;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int limit() {
                return i2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.protobuf.AllocatedBuffer
            public int remaining() {
                return i2 - this.position;
            }
        };
    }
}
