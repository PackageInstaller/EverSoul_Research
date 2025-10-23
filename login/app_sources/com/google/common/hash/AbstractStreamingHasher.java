package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class AbstractStreamingHasher extends AbstractHasher {
    private final ByteBuffer buffer;
    private final int bufferSize;
    private final int chunkSize;

    protected abstract HashCode makeHash();

    protected abstract void process(ByteBuffer byteBuffer);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractStreamingHasher(int i) {
        this(i, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractStreamingHasher(int i, int i2) {
        Preconditions.checkArgument(i2 % i == 0);
        this.buffer = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.bufferSize = i2;
        this.chunkSize = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void processRemaining(ByteBuffer byteBuffer) {
        Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        Java8Compatibility.limit(byteBuffer, this.chunkSize + 7);
        while (true) {
            int position = byteBuffer.position();
            int i = this.chunkSize;
            if (position < i) {
                byteBuffer.putLong(0L);
            } else {
                Java8Compatibility.limit(byteBuffer, i);
                Java8Compatibility.flip(byteBuffer);
                process(byteBuffer);
                return;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(byte[] bArr, int i, int i2) {
        return putBytesInternal(ByteBuffer.wrap(bArr, i, i2).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putBytes(ByteBuffer byteBuffer) {
        ByteOrder order = byteBuffer.order();
        try {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            return putBytesInternal(byteBuffer);
        } finally {
            byteBuffer.order(order);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Hasher putBytesInternal(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.buffer.remaining()) {
            this.buffer.put(byteBuffer);
            munchIfFull();
            return this;
        }
        int position = this.bufferSize - this.buffer.position();
        for (int i = 0; i < position; i++) {
            this.buffer.put(byteBuffer.get());
        }
        munch();
        while (byteBuffer.remaining() >= this.chunkSize) {
            process(byteBuffer);
        }
        this.buffer.put(byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putByte(byte b) {
        this.buffer.put(b);
        munchIfFull();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putShort(short s) {
        this.buffer.putShort(s);
        munchIfFull();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putChar(char c) {
        this.buffer.putChar(c);
        munchIfFull();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putInt(int i) {
        this.buffer.putInt(i);
        munchIfFull();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher putLong(long j) {
        this.buffer.putLong(j);
        munchIfFull();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.hash.Hasher
    public final HashCode hash() {
        munch();
        Java8Compatibility.flip(this.buffer);
        if (this.buffer.remaining() > 0) {
            processRemaining(this.buffer);
            ByteBuffer byteBuffer = this.buffer;
            Java8Compatibility.position(byteBuffer, byteBuffer.limit());
        }
        return makeHash();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void munchIfFull() {
        if (this.buffer.remaining() < 8) {
            munch();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void munch() {
        Java8Compatibility.flip(this.buffer);
        while (this.buffer.remaining() >= this.chunkSize) {
            process(this.buffer);
        }
        this.buffer.compact();
    }
}
