package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.encoding = encoding;
        this.bytes = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Encoding getEncoding() {
        return this.encoding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getBytes() {
        return this.bytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.encoding.equals(encodedPayload.encoding)) {
            return Arrays.equals(this.bytes, encodedPayload.bytes);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }
}
