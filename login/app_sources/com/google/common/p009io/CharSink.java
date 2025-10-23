package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected CharSink() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Writer openBufferedStream() throws IOException {
        Writer openStream = openStream();
        if (openStream instanceof BufferedWriter) {
            return (BufferedWriter) openStream;
        }
        return new BufferedWriter(openStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            writer.append(charSequence);
            writer.flush();
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeLines(Iterable<? extends CharSequence> iterable) throws IOException {
        writeLines(iterable, System.getProperty("line.separator"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeLines(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(str);
        try {
            Writer writer = (Writer) Closer.create().register(openBufferedStream());
            Iterator<? extends CharSequence> it = iterable.iterator();
            while (it.hasNext()) {
                writer.append(it.next()).append((CharSequence) str);
            }
            writer.flush();
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            long copy = CharStreams.copy(readable, writer);
            writer.flush();
            return copy;
        } finally {
        }
    }
}
