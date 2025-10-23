package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class UnsafeByteOperations {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UnsafeByteOperations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteString unsafeWrap(byte[] bArr) {
        return ByteString.wrap(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteString unsafeWrap(byte[] bArr, int i, int i2) {
        return ByteString.wrap(bArr, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteString unsafeWrap(ByteBuffer byteBuffer) {
        return ByteString.wrap(byteBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void unsafeWriteTo(ByteString byteString, ByteOutput byteOutput) throws IOException {
        byteString.writeTo(byteOutput);
    }
}
