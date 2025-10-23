package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.availableBytes = Integer.MIN_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.availableBytes = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (getBytesToRead(1L) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1L);
        return read;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int bytesToRead = (int) getBytesToRead(i2);
        if (bytesToRead == -1) {
            return -1;
        }
        int read = super.read(bArr, i, bytesToRead);
        updateAvailableBytesAfterRead(read);
        return read;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long bytesToRead = getBytesToRead(j);
        if (bytesToRead == -1) {
            return 0L;
        }
        long skip = super.skip(bytesToRead);
        updateAvailableBytesAfterRead(skip);
        return skip;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.availableBytes;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getBytesToRead(long j) {
        int i = this.availableBytes;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateAvailableBytesAfterRead(long j) {
        int i = this.availableBytes;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.availableBytes = (int) (i - j);
    }
}
