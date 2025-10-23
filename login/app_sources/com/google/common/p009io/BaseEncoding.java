package com.google.common.p009io;

import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");

    public abstract boolean canDecode(CharSequence charSequence);

    abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public abstract InputStream decodingStream(Reader reader);

    abstract void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i);

    abstract int maxEncodedSize(int i);

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BaseEncoding() {
    }

    public static final class DecodingException extends IOException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DecodingException(String str) {
            super(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DecodingException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i2));
        try {
            encodeTo(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.p009io.ByteSink
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] extract(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.p009io.ByteSource
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BaseEncoding base64() {
        return BASE64;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BaseEncoding base32() {
        return BASE32;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BaseEncoding base16() {
        return BASE16;
    }

    private static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int min = Math.min(8, Integer.lowestOneBit(log2));
                try {
                    this.charsPerChunk = 8 / min;
                    this.bytesPerChunk = log2 / min;
                    this.mask = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c = cArr[i];
                        Preconditions.checkArgument(c < 128, "Non-ASCII character: %s", c);
                        Preconditions.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                        bArr[c] = (byte) i;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.charsPerChunk];
                    for (int i2 = 0; i2 < this.bytesPerChunk; i2++) {
                        zArr[IntMath.divide(i2 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e) {
                    String str2 = new String(cArr);
                    throw new IllegalArgumentException(str2.length() != 0 ? "Illegal alphabet ".concat(str2) : new String("Illegal alphabet "), e);
                }
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException(new StringBuilder(35).append("Illegal alphabet length ").append(cArr.length).toString(), e2);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        char encode(int i) {
            return this.chars[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isValidPaddingStartPosition(int i) {
            return this.validPadding[i % this.charsPerChunk];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean canDecode(char c) {
            return c <= 127 && this.decodabet[c] != -1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int decode(char c) throws DecodingException {
            if (c > 127) {
                String valueOf = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(valueOf.length() != 0 ? "Unrecognized character: 0x".concat(valueOf) : new String("Unrecognized character: 0x"));
            }
            byte b = this.decodabet[c];
            if (b != -1) {
                return b;
            }
            if (c <= ' ' || c == 127) {
                String valueOf2 = String.valueOf(Integer.toHexString(c));
                throw new DecodingException(valueOf2.length() != 0 ? "Unrecognized character: 0x".concat(valueOf2) : new String("Unrecognized character: 0x"));
            }
            throw new DecodingException(new StringBuilder(25).append("Unrecognized character: ").append(c).toString());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean hasLowerCase() {
            for (char c : this.chars) {
                if (Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean hasUpperCase() {
            for (char c : this.chars) {
                if (Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i < cArr2.length) {
                    cArr[i] = Ascii.toUpperCase(cArr2[i]);
                    i++;
                } else {
                    return new Alphabet(String.valueOf(this.name).concat(".upperCase()"), cArr);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i < cArr2.length) {
                    cArr[i] = Ascii.toLowerCase(cArr2[i]);
                    i++;
                } else {
                    return new Alphabet(String.valueOf(this.name).concat(".lowerCase()"), cArr);
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean matches(char c) {
            byte[] bArr = this.decodabet;
            return c < bArr.length && bArr[c] != -1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return this.name;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }
    }

    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;

        @CheckForNull
        @LazyInit
        private transient BaseEncoding lowerCase;

        @CheckForNull
        final Character paddingChar;

        @CheckForNull
        @LazyInit
        private transient BaseEncoding upperCase;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StandardBaseEncoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StandardBaseEncoding(Alphabet alphabet, @CheckForNull Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.paddingChar = ch;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int maxEncodedSize(int i) {
            return this.alphabet.charsPerChunk * IntMath.divide(i, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.OutputStream
                public void write(int i) throws IOException {
                    this.bitBuffer = (i & 255) | (this.bitBuffer << 8);
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= StandardBaseEncoding.this.alphabet.bitsPerChar) {
                        writer.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer >> (this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    writer.flush();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        writer.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer << (StandardBaseEncoding.this.alphabet.bitsPerChar - this.bitBufferLength)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                                writer.write(StandardBaseEncoding.this.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                encodeChunkTo(appendable, bArr, i + i3, Math.min(this.alphabet.bytesPerChunk, i2 - i3));
                i3 += this.alphabet.bytesPerChunk;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void encodeChunkTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            Preconditions.checkArgument(i2 <= this.alphabet.bytesPerChunk);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | (bArr[i + i4] & 255)) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i3 < i2 * 8) {
                appendable.append(this.alphabet.encode(((int) (j >>> (i5 - i3))) & this.alphabet.mask));
                i3 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i3 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i3 += this.alphabet.bitsPerChar;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int maxDecodedSize(int i) {
            return (int) (((this.alphabet.bitsPerChar * i) + 7) / 8);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.paddingChar;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                return false;
            }
            for (int i = 0; i < trimTrailingPadding.length(); i++) {
                if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(trimTrailingPadding.length()).toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < trimTrailingPadding.length()) {
                long j = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.alphabet.charsPerChunk; i4++) {
                    j <<= this.alphabet.bitsPerChar;
                    if (i + i4 < trimTrailingPadding.length()) {
                        j |= this.alphabet.decode(trimTrailingPadding.charAt(i3 + i));
                        i3++;
                    }
                }
                int i5 = (this.alphabet.bytesPerChunk * 8) - (i3 * this.alphabet.bitsPerChar);
                int i6 = (this.alphabet.bytesPerChunk - 1) * 8;
                while (i6 >= i5) {
                    bArr[i2] = (byte) ((j >>> i6) & 255);
                    i6 -= 8;
                    i2++;
                }
                i += this.alphabet.charsPerChunk;
            }
            return i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int readChars = 0;
                boolean hitPadding = false;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.InputStream
                public int read() throws IOException {
                    while (true) {
                        int read = reader.read();
                        if (read == -1) {
                            if (this.hitPadding || StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                                return -1;
                            }
                            throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(this.readChars).toString());
                        }
                        this.readChars++;
                        char c = (char) read;
                        if (StandardBaseEncoding.this.paddingChar != null && StandardBaseEncoding.this.paddingChar.charValue() == c) {
                            if (this.hitPadding || (this.readChars != 1 && StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                                this.hitPadding = true;
                            }
                        } else {
                            if (this.hitPadding) {
                                throw new DecodingException(new StringBuilder(61).append("Expected padding character but found '").append(c).append("' at index ").append(this.readChars).toString());
                            }
                            int i = this.bitBuffer << StandardBaseEncoding.this.alphabet.bitsPerChar;
                            this.bitBuffer = i;
                            this.bitBuffer = StandardBaseEncoding.this.alphabet.decode(c) | i;
                            int i2 = this.bitBufferLength + StandardBaseEncoding.this.alphabet.bitsPerChar;
                            this.bitBufferLength = i2;
                            if (i2 >= 8) {
                                int i3 = i2 - 8;
                                this.bitBufferLength = i3;
                                return (this.bitBuffer >> i3) & 255;
                            }
                        }
                    }
                    throw new DecodingException(new StringBuilder(41).append("Padding cannot start at index ").append(this.readChars).toString());
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int i3 = i2 + i;
                    Preconditions.checkPositionIndexes(i, i3, bArr.length);
                    int i4 = i;
                    while (i4 < i3) {
                        int read = read();
                        if (read == -1) {
                            int i5 = i4 - i;
                            if (i5 == 0) {
                                return -1;
                            }
                            return i5;
                        }
                        bArr[i4] = (byte) read;
                        i4++;
                    }
                    return i4 - i;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            Character ch;
            return (8 % this.alphabet.bitsPerChar == 0 || ((ch = this.paddingChar) != null && ch.charValue() == c)) ? this : newInstance(this.alphabet, Character.valueOf(c));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase = this.alphabet.upperCase();
                baseEncoding = upperCase == this.alphabet ? this : newInstance(upperCase, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase = this.alphabet.lowerCase();
                baseEncoding = lowerCase == this.alphabet ? this : newInstance(lowerCase, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('").append(this.paddingChar).append("')");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            return this.alphabet.equals(standardBaseEncoding.alphabet) && Objects.equal(this.paddingChar, standardBaseEncoding.paddingChar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i = 0; i < 256; i++) {
                this.encoding[i] = alphabet.encode(i >>> 4);
                this.encoding[i | 256] = alphabet.encode(i & 15);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.p009io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.encoding[i4]);
                appendable.append(this.encoding[i4 | 256]);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.p009io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(charSequence.length()).toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.alphabet.decode(charSequence.charAt(i)) << 4) | this.alphabet.decode(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base16Encoding(alphabet);
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Base64Encoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Base64Encoding(Alphabet alphabet, @CheckForNull Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.p009io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.alphabet.encode(i6 >>> 18));
                appendable.append(this.alphabet.encode((i6 >>> 12) & 63));
                appendable.append(this.alphabet.encode((i6 >>> 6) & 63));
                appendable.append(this.alphabet.encode(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                encodeChunkTo(appendable, bArr, i, i3 - i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.p009io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                throw new DecodingException(new StringBuilder(32).append("Invalid input length ").append(trimTrailingPadding.length()).toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < trimTrailingPadding.length()) {
                int i3 = i + 1;
                int i4 = i3 + 1;
                int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i3)) << 12);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (decode >>> 16);
                if (i4 < trimTrailingPadding.length()) {
                    int i6 = i4 + 1;
                    int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i4)) << 6);
                    i2 = i5 + 1;
                    bArr[i5] = (byte) ((decode2 >>> 8) & 255);
                    if (i6 < trimTrailingPadding.length()) {
                        i4 = i6 + 1;
                        i5 = i2 + 1;
                        bArr[i2] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i6))) & 255);
                    } else {
                        i = i6;
                    }
                }
                i2 = i5;
                i = i4;
            }
            return i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base64Encoding(alphabet, ch);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Reader
            public int read() throws IOException {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Reader
            public int read(char[] cArr, int i, int i2) throws IOException {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Appendable separatingAppendable(Appendable appendable, String str, int i) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        return new Appendable(i, appendable, str) { // from class: com.google.common.io.BaseEncoding.4
            int charsUntilSeparator;
            final /* synthetic */ int val$afterEveryChars;
            final /* synthetic */ Appendable val$delegate;
            final /* synthetic */ String val$separator;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.val$afterEveryChars = i;
                this.val$delegate = appendable;
                this.val$separator = str;
                this.charsUntilSeparator = i;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Appendable
            public Appendable append(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c);
                this.charsUntilSeparator--;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence, int i2, int i3) {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Writer separatingWriter(final Writer writer, String str, int i) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Writer
            public void write(int i2) throws IOException {
                separatingAppendable.append((char) i2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                writer.flush();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                writer.close();
            }
        };
    }

    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int maxEncodedSize(int i) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            this.delegate.encodeTo(separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int maxDecodedSize(int i) {
            return this.delegate.maxDecodedSize(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(ignoringReader(reader, this.separator));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.p009io.BaseEncoding
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.delegate);
            String str = this.separator;
            return new StringBuilder(String.valueOf(valueOf).length() + 31 + String.valueOf(str).length()).append(valueOf).append(".withSeparator(\"").append(str).append("\", ").append(this.afterEveryChars).append(")").toString();
        }
    }
}
