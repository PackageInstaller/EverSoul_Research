package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class CharStreams {
    private static final int DEFAULT_BUF_SIZE = 2048;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static CharBuffer createBuffer() {
        return CharBuffer.allocate(2048);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CharStreams() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long copy(Readable readable, Appendable appendable) throws IOException {
        if (readable instanceof Reader) {
            if (appendable instanceof StringBuilder) {
                return copyReaderToBuilder((Reader) readable, (StringBuilder) appendable);
            }
            return copyReaderToWriter((Reader) readable, asWriter(appendable));
        }
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(appendable);
        CharBuffer createBuffer = createBuffer();
        long j = 0;
        while (readable.read(createBuffer) != -1) {
            Java8Compatibility.flip(createBuffer);
            appendable.append(createBuffer);
            j += createBuffer.remaining();
            Java8Compatibility.clear(createBuffer);
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long copyReaderToBuilder(Reader reader, StringBuilder sb) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            sb.append(cArr, 0, read);
            j += read;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long copyReaderToWriter(Reader reader, Writer writer) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(writer);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += read;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Readable readable) throws IOException {
        return toStringBuilder(readable).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            copyReaderToBuilder((Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long exhaust(Readable readable) throws IOException {
        CharBuffer createBuffer = createBuffer();
        long j = 0;
        while (true) {
            long read = readable.read(createBuffer);
            if (read == -1) {
                return j;
            }
            j += read;
            Java8Compatibility.clear(createBuffer);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void skipFully(Reader reader, long j) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip == 0) {
                throw new EOFException();
            }
            j -= skip;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Writer nullWriter() {
        return NullWriter.INSTANCE;
    }

    private static final class NullWriter extends Writer {
        private static final NullWriter INSTANCE = new NullWriter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence) {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "CharStreams.nullWriter()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer
        public void write(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NullWriter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, str.length());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(@CheckForNull CharSequence charSequence, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, charSequence == null ? 4 : charSequence.length());
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new AppendableWriter(appendable);
    }
}
