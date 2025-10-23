package com.google.common.p009io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LittleEndianDataInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        ByteStreams.readFully(this, bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        ByteStreams.readFully(this, bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return Ints.fromBytes((byte) 0, (byte) 0, readAndCheckByte(), readAndCheckByte());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        return Ints.fromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte2, readAndCheckByte);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte readAndCheckByte = readAndCheckByte();
        byte readAndCheckByte2 = readAndCheckByte();
        byte readAndCheckByte3 = readAndCheckByte();
        byte readAndCheckByte4 = readAndCheckByte();
        byte readAndCheckByte5 = readAndCheckByte();
        byte readAndCheckByte6 = readAndCheckByte();
        return Longs.fromBytes(readAndCheckByte(), readAndCheckByte(), readAndCheckByte6, readAndCheckByte5, readAndCheckByte4, readAndCheckByte3, readAndCheckByte2, readAndCheckByte);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte readAndCheckByte() throws IOException, EOFException {
        int read = this.in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }
}
