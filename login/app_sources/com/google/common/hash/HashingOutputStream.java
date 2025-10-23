package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        this.hasher.putByte((byte) i);
        this.out.write(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.hasher.putBytes(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCode hash() {
        return this.hasher.hash();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
