package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Funnels {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Funnels() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }

    private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StringCharsetFunnel(Charset charset) {
            this.charset = (Charset) Preconditions.checkNotNull(charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.charset);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String name = this.charset.name();
            return new StringBuilder(String.valueOf(name).length() + 22).append("Funnels.stringFunnel(").append(name).append(")").toString();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    private enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(funnel);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), primitiveSink);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.elementFunnel);
            return new StringBuilder(String.valueOf(valueOf).length() + 26).append("Funnels.sequentialFunnel(").append(valueOf).append(")").toString();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    private enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.hash.Funnel
        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new SinkAsStream(primitiveSink);
    }

    private static class SinkAsStream extends OutputStream {
        final PrimitiveSink sink;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SinkAsStream(PrimitiveSink primitiveSink) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.OutputStream
        public void write(int i) {
            this.sink.putByte((byte) i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.sink.putBytes(bArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.sink.putBytes(bArr, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.sink);
            return new StringBuilder(String.valueOf(valueOf).length() + 24).append("Funnels.asOutputStream(").append(valueOf).append(")").toString();
        }
    }
}
