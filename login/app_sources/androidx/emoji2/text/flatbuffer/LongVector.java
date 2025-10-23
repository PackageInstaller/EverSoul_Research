package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class LongVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LongVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 8, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long get(int i) {
        return this.f119bb.getLong(__element(i));
    }
}
