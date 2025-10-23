package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class MultiInputStream extends InputStream {

    /* renamed from: in */
    @CheckForNull
    private InputStream f417in;

    /* renamed from: it */
    private Iterator<? extends ByteSource> f418it;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f418it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f417in;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f417in = null;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void advance() throws IOException {
        close();
        if (this.f418it.hasNext()) {
            this.f417in = this.f418it.next().openStream();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f417in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f417in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        while (true) {
            InputStream inputStream = this.f417in;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            advance();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.f417in;
        if (inputStream == null || j <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f417in.skip(j - 1) + 1;
    }
}
