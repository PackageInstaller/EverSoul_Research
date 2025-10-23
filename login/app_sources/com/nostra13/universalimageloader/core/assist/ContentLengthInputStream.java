package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class ContentLengthInputStream extends InputStream {
    private final int length;
    private final InputStream stream;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ContentLengthInputStream(InputStream inputStream, int i) {
        this.stream = inputStream;
        this.length = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int available() {
        return this.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public void mark(int i) {
        this.stream.mark(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.stream.read();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.stream.read(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.stream.read(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.stream.reset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.stream.skip(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.stream.markSupported();
    }
}
