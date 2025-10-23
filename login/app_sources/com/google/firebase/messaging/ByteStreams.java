package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes2.dex */
final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static byte[] createBuffer() {
        return new byte[8192];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int saturatedCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ByteStreams() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i) throws IOException {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i) * 2));
        while (i < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i2 = 0;
            while (i2 < min2) {
                int read = inputStream.read(bArr, i2, min2 - i2);
                if (read == -1) {
                    return combineBuffers(queue, i);
                }
                i2 += read;
                i += read;
            }
            min = saturatedCast(min * (min < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] combineBuffers(Queue<byte[]> queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i) {
            return remove;
        }
        int length = i - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i - length, min);
            length -= min;
        }
        return copyOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InputStream limit(InputStream inputStream, long j) {
        return new LimitedInputStream(inputStream, j);
    }

    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LimitedInputStream(InputStream inputStream, long j) {
            super(inputStream);
            this.mark = -1L;
            this.left = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() throws IOException {
            return (int) Math.min(this.in.available(), this.left);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i) {
            this.in.mark(i);
            this.mark = this.left;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.left;
            if (j == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) Math.min(i2, j));
            if (read != -1) {
                this.left -= read;
            }
            return read;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            this.in.reset();
            this.left = this.mark;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long skip = this.in.skip(Math.min(j, this.left));
            this.left -= skip;
            return skip;
        }
    }
}
