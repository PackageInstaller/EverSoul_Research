package com.google.common.p009io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) throws IOException {
        ((DataOutputStream) this.out).writeBoolean(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeByte(int i) throws IOException {
        ((DataOutputStream) this.out).writeByte(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) this.out).writeBytes(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeChar(int i) throws IOException {
        writeShort(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            writeChar(str.charAt(i));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeInt(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
        this.out.write((i >> 16) & 255);
        this.out.write((i >> 24) & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeLong(long j) throws IOException {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j));
        write(byteArray, 0, byteArray.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) this.out).writeUTF(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
