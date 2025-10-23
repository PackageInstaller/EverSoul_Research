package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        checkNotClosed();
        this.target.append(new String(cArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer
    public void write(int i) throws IOException {
        checkNotClosed();
        this.target.append((char) i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer
    public void write(String str) throws IOException {
        Preconditions.checkNotNull(str);
        checkNotClosed();
        this.target.append(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        Preconditions.checkNotNull(str);
        checkNotClosed();
        this.target.append(str, i, i2 + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        checkNotClosed();
        this.target.append(c);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence) throws IOException {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence, int i, int i2) throws IOException {
        checkNotClosed();
        this.target.append(charSequence, i, i2);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }
}
