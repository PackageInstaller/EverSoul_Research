package com.google.common.p009io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class CharSource {
    public abstract Reader openStream() throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected CharSource() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ByteSource asByteSource(Charset charset) {
        return new AsByteSource(charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BufferedReader openBufferedStream() throws IOException {
        Reader openStream = openStream();
        if (openStream instanceof BufferedReader) {
            return (BufferedReader) openStream;
        }
        return new BufferedReader(openStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long length() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        try {
            return countBySkipping((Reader) Closer.create().register(openStream()));
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long countBySkipping(Reader reader) throws IOException {
        long j = 0;
        while (true) {
            long skip = reader.skip(Long.MAX_VALUE);
            if (skip == 0) {
                return j;
            }
            j += skip;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        try {
            return CharStreams.copy((Reader) Closer.create().register(openStream()), appendable);
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer create = Closer.create();
        try {
            return CharStreams.copy((Reader) create.register(openStream()), (Writer) create.register(charSink.openStream()));
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String read() throws IOException {
        try {
            return CharStreams.toString((Reader) Closer.create().register(openStream()));
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    public String readFirstLine() throws IOException {
        try {
            return ((BufferedReader) Closer.create().register(openBufferedStream())).readLine();
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableList<String> readLines() throws IOException {
        try {
            BufferedReader bufferedReader = (BufferedReader) Closer.create().register(openBufferedStream());
            ArrayList newArrayList = Lists.newArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    newArrayList.add(readLine);
                } else {
                    return ImmutableList.copyOf((Collection) newArrayList);
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        try {
            return (T) CharStreams.readLines((Reader) Closer.create().register(openStream()), lineProcessor);
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEmpty() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue() == 0;
        }
        Closer create = Closer.create();
        try {
            return ((Reader) create.register(openStream())).read() == -1;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } finally {
                create.close();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource concat(CharSource... charSourceArr) {
        return concat(ImmutableList.copyOf(charSourceArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource wrap(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return new StringCharSource((String) charSequence);
        }
        return new CharSequenceCharSource(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }

    private final class AsByteSource extends ByteSource {
        final Charset charset;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        AsByteSource(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (charset.equals(this.charset)) {
                return CharSource.this;
            }
            return super.asCharSource(charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.ByteSource
        public InputStream openStream() throws IOException {
            return new ReaderInputStream(CharSource.this.openStream(), this.charset, 8192);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String obj = CharSource.this.toString();
            String valueOf = String.valueOf(this.charset);
            return new StringBuilder(String.valueOf(obj).length() + 15 + String.valueOf(valueOf).length()).append(obj).append(".asByteSource(").append(valueOf).append(")").toString();
        }
    }

    private static class CharSequenceCharSource extends CharSource {
        private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
        protected final CharSequence seq;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected CharSequenceCharSource(CharSequence charSequence) {
            this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public String read() {
            return this.seq.toString();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public boolean isEmpty() {
            return this.seq.length() == 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public long length() {
            return this.seq.length();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.m188of(Long.valueOf(this.seq.length()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Iterator<String> linesIterator() {
            return new AbstractIterator<String>() { // from class: com.google.common.io.CharSource.CharSequenceCharSource.1
                Iterator<String> lines;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.lines = CharSequenceCharSource.LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                public String computeNext() {
                    if (this.lines.hasNext()) {
                        String next = this.lines.next();
                        if (this.lines.hasNext() || !next.isEmpty()) {
                            return next;
                        }
                    }
                    return endOfData();
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        @CheckForNull
        public String readFirstLine() {
            Iterator<String> linesIterator = linesIterator();
            if (linesIterator.hasNext()) {
                return linesIterator.next();
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(linesIterator());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        @ParametricNullness
        public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
            Iterator<String> linesIterator = linesIterator();
            while (linesIterator.hasNext() && lineProcessor.processLine(linesIterator.next())) {
            }
            return lineProcessor.getResult();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String truncate = Ascii.truncate(this.seq, 30, "...");
            return new StringBuilder(String.valueOf(truncate).length() + 17).append("CharSource.wrap(").append(truncate).append(")").toString();
        }
    }

    private static class StringCharSource extends CharSequenceCharSource {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected StringCharSource(String str) {
            super(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.p009io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.seq);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.seq);
            return this.seq.length();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public long copyTo(CharSink charSink) throws IOException {
            Preconditions.checkNotNull(charSink);
            try {
                ((Writer) Closer.create().register(charSink.openStream())).write((String) this.seq);
                return this.seq.length();
            } finally {
            }
        }
    }

    private static final class EmptyCharSource extends StringCharSource {
        private static final EmptyCharSource INSTANCE = new EmptyCharSource();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EmptyCharSource() {
            super("");
        }
    }

    private static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.sources = (Iterable) Preconditions.checkNotNull(iterable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends CharSource> it = this.sources.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public Optional<Long> lengthIfKnown() {
            Iterator<? extends CharSource> it = this.sources.iterator();
            long j = 0;
            while (it.hasNext()) {
                Optional<Long> lengthIfKnown = it.next().lengthIfKnown();
                if (!lengthIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j += lengthIfKnown.get().longValue();
            }
            return Optional.m188of(Long.valueOf(j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.CharSource
        public long length() throws IOException {
            Iterator<? extends CharSource> it = this.sources.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().length();
            }
            return j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.sources);
            return new StringBuilder(String.valueOf(valueOf).length() + 19).append("CharSource.concat(").append(valueOf).append(")").toString();
        }
    }
}
