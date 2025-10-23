package com.bumptech.glide.load.data;

import com.google.common.base.Ascii;
import com.liapp.y;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        byte[] bArr = {-1, -31, 0, Ascii.f339FS, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781763688) + i);
        }
        this.orientation = (byte) i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        int i;
        int i2 = this.position;
        if (i2 < 2 || i2 > (i = ORIENTATION_POSITION)) {
            read = super.read();
        } else if (i2 == i) {
            read = this.orientation;
        } else {
            read = EXIF_SEGMENT[i2 - 2] & 255;
        }
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.position;
        int i5 = ORIENTATION_POSITION;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.orientation;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.position += i3;
        }
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.position = (int) (this.position + skip);
        }
        return skip;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
