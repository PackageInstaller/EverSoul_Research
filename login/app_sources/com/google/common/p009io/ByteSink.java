package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ByteSink {
    public abstract OutputStream openStream() throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ByteSink() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSink asCharSink(Charset charset) {
        return new AsCharSink(charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OutputStream openBufferedStream() throws IOException {
        OutputStream openStream = openStream();
        if (openStream instanceof BufferedOutputStream) {
            return (BufferedOutputStream) openStream;
        }
        return new BufferedOutputStream(openStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void write(byte[] bArr) throws IOException {
        Preconditions.checkNotNull(bArr);
        try {
            OutputStream outputStream = (OutputStream) Closer.create().register(openStream());
            outputStream.write(bArr);
            outputStream.flush();
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long writeFrom(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        try {
            OutputStream outputStream = (OutputStream) Closer.create().register(openStream());
            long copy = ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            return copy;
        } finally {
        }
    }

    private final class AsCharSink extends CharSink {
        private final Charset charset;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AsCharSink(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSink
        public Writer openStream() throws IOException {
            return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String obj = ByteSink.this.toString();
            String valueOf = String.valueOf(this.charset);
            return new StringBuilder(String.valueOf(obj).length() + 13 + String.valueOf(valueOf).length()).append(obj).append(".asCharSink(").append(valueOf).append(")").toString();
        }
    }
}
