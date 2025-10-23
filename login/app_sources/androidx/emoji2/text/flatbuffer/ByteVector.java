package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class ByteVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ByteVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 1, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte get(int i) {
        return this.f119bb.get(__element(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAsUnsigned(int i) {
        return get(i) & 255;
    }
}
