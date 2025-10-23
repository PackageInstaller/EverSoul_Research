package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class IntVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public IntVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int get(int i) {
        return this.f119bb.getInt(__element(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAsUnsigned(int i) {
        return get(i) & 4294967295L;
    }
}
