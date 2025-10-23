package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = Util.createQueue(0);
    private IOException exception;
    private InputStream wrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExceptionCatchingInputStream obtain(InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.setInputStream(inputStream);
        return poll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void clearQueue() {
        while (true) {
            Queue<ExceptionCatchingInputStream> queue = QUEUE;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExceptionCatchingInputStream() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setInputStream(InputStream inputStream) {
        this.wrapped = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.wrapped.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public void mark(int i) {
        this.wrapped.mark(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.wrapped.read(bArr);
        } catch (IOException e) {
            this.exception = e;
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.wrapped.read(bArr, i, i2);
        } catch (IOException e) {
            this.exception = e;
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.wrapped.reset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.wrapped.skip(j);
        } catch (IOException e) {
            this.exception = e;
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read() {
        try {
            return this.wrapped.read();
        } catch (IOException e) {
            this.exception = e;
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IOException getException() {
        return this.exception;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            queue.offer(this);
        }
    }
}
