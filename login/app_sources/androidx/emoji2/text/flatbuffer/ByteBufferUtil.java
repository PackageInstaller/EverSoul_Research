package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ByteBufferUtil {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getSizePrefix(ByteBuffer byteBuffer) {
        return byteBuffer.getInt(byteBuffer.position());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteBuffer removeSizePrefix(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(duplicate.position() + 4);
        return duplicate;
    }
}
