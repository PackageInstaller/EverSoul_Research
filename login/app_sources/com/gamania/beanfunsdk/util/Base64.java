package com.gamania.beanfunsdk.util;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okio.Utf8;

/* loaded from: classes.dex */
public class Base64 {
    public static final boolean DECODE = false;
    public static final boolean ENCODE = true;

    /* renamed from: a */
    private static final byte[] f208a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    private static final byte[] f209b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, kotlin.p031io.encoding.Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.f349VT, Ascii.f338FF, Ascii.f336CR, Ascii.f346SO, Ascii.f345SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.f337EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.f339FS, Ascii.f340GS, Ascii.f344RS, Ascii.f348US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};

    public static class InputStream extends FilterInputStream {

        /* renamed from: a */
        private boolean f210a;

        /* renamed from: b */
        private int f211b;

        /* renamed from: c */
        private byte[] f212c;

        /* renamed from: d */
        private int f213d;

        /* renamed from: e */
        private int f214e;

        /* renamed from: f */
        private int f215f;

        /* renamed from: g */
        private boolean f216g;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, false);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InputStream(java.io.InputStream inputStream, boolean z) {
            this(inputStream, z, true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InputStream(java.io.InputStream inputStream, boolean z, boolean z2) {
            super(inputStream);
            this.f216g = z2;
            this.f210a = z;
            int i = z ? 4 : 3;
            this.f213d = i;
            this.f212c = new byte[i];
            this.f211b = -1;
            this.f215f = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read;
            if (this.f211b < 0) {
                if (this.f210a) {
                    byte[] bArr = new byte[3];
                    int i = 0;
                    for (int i2 = 0; i2 < 3; i2++) {
                        try {
                            int read2 = ((FilterInputStream) this).in.read();
                            if (read2 >= 0) {
                                bArr[i2] = (byte) read2;
                                i++;
                            }
                        } catch (IOException e) {
                            if (i2 == 0) {
                                throw e;
                            }
                        }
                    }
                    if (i <= 0) {
                        return -1;
                    }
                    Base64.m99b(bArr, 0, i, this.f212c, 0);
                    this.f211b = 0;
                    this.f214e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i3 = 0;
                    while (i3 < 4) {
                        do {
                            read = ((FilterInputStream) this).in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (Base64.f209b[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i3] = (byte) read;
                        i3++;
                    }
                    if (i3 != 4) {
                        if (i3 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.f214e = Base64.m96b(bArr2, 0, this.f212c, 0);
                    this.f211b = 0;
                }
            }
            int i4 = this.f211b;
            if (i4 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i4 >= this.f214e) {
                return -1;
            }
            if (this.f210a && this.f216g && this.f215f >= 76) {
                this.f215f = 0;
                return 10;
            }
            this.f215f++;
            byte[] bArr3 = this.f212c;
            int i5 = i4 + 1;
            this.f211b = i5;
            byte b = bArr3[i4];
            if (i5 >= this.f213d) {
                this.f211b = -1;
            }
            return b & 255;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i + i3] = (byte) read;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class OutputStream extends FilterOutputStream {

        /* renamed from: a */
        private boolean f217a;

        /* renamed from: b */
        private int f218b;

        /* renamed from: c */
        private byte[] f219c;

        /* renamed from: d */
        private int f220d;

        /* renamed from: e */
        private int f221e;

        /* renamed from: f */
        private boolean f222f;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OutputStream(java.io.OutputStream outputStream, boolean z) {
            this(outputStream, z, true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OutputStream(java.io.OutputStream outputStream, boolean z, boolean z2) {
            super(outputStream);
            this.f222f = z2;
            this.f217a = z;
            int i = z ? 3 : 4;
            this.f220d = i;
            this.f219c = new byte[i];
            this.f218b = 0;
            this.f221e = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            ((FilterOutputStream) this).out.close();
            this.f219c = null;
            ((FilterOutputStream) this).out = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() {
            super.flush();
            int i = this.f218b;
            if (i > 0) {
                if (!this.f217a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(Base64.m98b(this.f219c, i));
            }
            ((FilterOutputStream) this).out.flush();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) {
            if (this.f217a) {
                byte[] bArr = this.f219c;
                int i2 = this.f218b;
                int i3 = i2 + 1;
                this.f218b = i3;
                bArr[i2] = (byte) i;
                int i4 = this.f220d;
                if (i3 < i4) {
                    return;
                }
                ((FilterOutputStream) this).out.write(Base64.m98b(bArr, i4));
                int i5 = this.f221e + 4;
                this.f221e = i5;
                if (this.f222f && i5 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f221e = 0;
                }
            } else {
                int i6 = i & 127;
                if (Base64.f209b[i6] <= -5) {
                    if (Base64.f209b[i6] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr2 = this.f219c;
                int i7 = this.f218b;
                int i8 = i7 + 1;
                this.f218b = i8;
                bArr2[i7] = (byte) i;
                if (i8 < this.f220d) {
                    return;
                } else {
                    ((FilterOutputStream) this).out.write(Base64.m97b(bArr2));
                }
            }
            this.f218b = 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Base64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static int m96b(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte b = bArr[i + 2];
        if (b == 61) {
            byte[] bArr3 = f209b;
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] & 255) << 12) | ((bArr3[bArr[i]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b2 = bArr[i + 3];
        if (b2 == 61) {
            byte[] bArr4 = f209b;
            int i3 = ((bArr4[bArr[i + 1]] & 255) << 12) | ((bArr4[bArr[i]] & 255) << 18) | ((bArr4[b] & 255) << 6);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        }
        try {
            byte[] bArr5 = f209b;
            int i4 = ((bArr5[bArr[i + 1]] & 255) << 12) | ((bArr5[bArr[i]] & 255) << 18) | ((bArr5[b] & 255) << 6) | (bArr5[b2] & 255);
            bArr2[i2] = (byte) (i4 >> 16);
            bArr2[i2 + 1] = (byte) (i4 >> 8);
            bArr2[i2 + 2] = (byte) i4;
            return 3;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static byte[] m97b(byte[] bArr) {
        byte[] bArr2 = new byte[3];
        int m96b = m96b(bArr, 0, bArr2, 0);
        byte[] bArr3 = new byte[m96b];
        System.arraycopy(bArr2, 0, bArr3, 0, m96b);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static byte[] m98b(byte[] bArr, int i) {
        byte[] bArr2 = new byte[4];
        m99b(bArr, 0, i, bArr2, 0);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static byte[] m99b(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
        if (i2 == 1) {
            byte[] bArr3 = f208a;
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = kotlin.p031io.encoding.Base64.padSymbol;
            bArr2[i3 + 3] = kotlin.p031io.encoding.Base64.padSymbol;
            return bArr2;
        }
        if (i2 == 2) {
            byte[] bArr4 = f208a;
            bArr2[i3] = bArr4[i4 >>> 18];
            bArr2[i3 + 1] = bArr4[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr4[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = kotlin.p031io.encoding.Base64.padSymbol;
            return bArr2;
        }
        if (i2 != 3) {
            return bArr2;
        }
        byte[] bArr5 = f208a;
        bArr2[i3] = bArr5[i4 >>> 18];
        bArr2[i3 + 1] = bArr5[(i4 >>> 12) & 63];
        bArr2[i3 + 2] = bArr5[(i4 >>> 6) & 63];
        bArr2[i3 + 3] = bArr5[i4 & 63];
        return bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decode(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = (byte) (bArr[i5] & Byte.MAX_VALUE);
            byte b2 = f209b[b];
            if (b2 < -5) {
                return null;
            }
            if (b2 >= -1) {
                int i6 = i3 + 1;
                bArr3[i3] = b;
                if (i6 > 3) {
                    i4 += m96b(bArr3, 0, bArr2, i4);
                    if (b == 61) {
                        break;
                    }
                    i3 = 0;
                } else {
                    i3 = i6;
                }
            }
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr4, 0, i4);
        return bArr4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004a: MOVE (r3 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:61:0x004a */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object decodeToObject(String str) {
        ?? r1;
        ClassNotFoundException e;
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        IOException e2;
        ByteArrayInputStream byteArrayInputStream2;
        ByteArrayInputStream byteArrayInputStream3;
        byte[] bArr;
        byte[] decode = decode(str);
        ByteArrayInputStream byteArrayInputStream4 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode);
            } catch (IOException e3) {
                e2 = e3;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (ClassNotFoundException e4) {
                e = e4;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                try {
                    byteArrayInputStream4.close();
                } catch (Exception unused) {
                }
                try {
                    r1.close();
                    throw th;
                } catch (Exception unused2) {
                    throw th;
                }
            }
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e5) {
                e2 = e5;
                objectInputStream = null;
            } catch (ClassNotFoundException e6) {
                e = e6;
                objectInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream3 = byteArrayInputStream;
                bArr = null;
                byteArrayInputStream4 = byteArrayInputStream3;
                r1 = bArr;
                byteArrayInputStream4.close();
                r1.close();
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused3) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused4) {
                }
                return readObject;
            } catch (IOException e7) {
                e2 = e7;
                e2.printStackTrace();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused5) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused6) {
                }
                return null;
            } catch (ClassNotFoundException e8) {
                e = e8;
                e.printStackTrace();
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused7) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused8) {
                }
                return null;
            }
        } catch (Throwable th3) {
            byteArrayInputStream3 = byteArrayInputStream2;
            bArr = decode;
            th = th3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String decodeToString(String str) {
        return new String(decode(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeBytes(byte[] bArr, int i, int i2) {
        return encodeBytes(bArr, i, i2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeBytes(byte[] bArr, int i, int i2, boolean z) {
        int i3 = (i2 * 4) / 3;
        byte[] bArr2 = new byte[(i2 % 3 > 0 ? 4 : 0) + i3 + (z ? i3 / 76 : 0)];
        int i4 = i2 - 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            m99b(bArr, i5 + i, 3, bArr2, i6);
            i7 += 4;
            if (z && i7 == 76) {
                bArr2[i6 + 4] = 10;
                i6++;
                i7 = 0;
            }
            i5 += 3;
            i6 += 4;
        }
        if (i5 < i2) {
            m99b(bArr, i + i5, i2 - i5, bArr2, i6);
            i6 += 4;
        }
        return new String(bArr2, 0, i6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeBytes(byte[] bArr, boolean z) {
        return encodeBytes(bArr, 0, bArr.length, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeObject(Serializable serializable, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    outputStream = new OutputStream(byteArrayOutputStream, true, z);
                    try {
                        objectOutputStream = new ObjectOutputStream(outputStream);
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream.close();
                            throw th;
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    objectOutputStream = null;
                    outputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                objectOutputStream = null;
                byteArrayOutputStream = null;
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                outputStream = null;
            }
            try {
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                } catch (Exception unused4) {
                }
                try {
                    outputStream.close();
                } catch (Exception unused5) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused6) {
                }
                return new String(byteArrayOutputStream.toByteArray());
            } catch (IOException e4) {
                e = e4;
                e.printStackTrace();
                try {
                    objectOutputStream.close();
                } catch (Exception unused7) {
                }
                try {
                    outputStream.close();
                } catch (Exception unused8) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused9) {
                }
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream2 = z;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeString(String str) {
        return encodeString(str, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeString(String str, boolean z) {
        return encodeBytes(str.getBytes(), z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void main(String[] strArr) {
    }
}
