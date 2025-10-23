package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import com.liapp.y;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InputStream obtain(InputStream inputStream, String str) {
        return obtain(inputStream, parseContentLength(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InputStream obtain(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int parseContentLength(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                String str2 = y.ٴسسݬߨ(1392983658);
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, y.ݮڮֲڭܩ(-628946292) + str, e);
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - this.readSoFar, this.in.available());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        checkReadSoFarOrThrow(read >= 0 ? 1 : -1);
        return read;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int checkReadSoFarOrThrow(int i) throws IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - this.readSoFar > 0) {
            throw new IOException(y.دײܮڳܯ(2051948069) + this.contentLength + y.دײܮڳܯ(2051948469) + this.readSoFar);
        }
        return i;
    }
}
