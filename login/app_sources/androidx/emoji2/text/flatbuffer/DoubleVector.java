package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class DoubleVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DoubleVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 8, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double get(int i) {
        return this.f119bb.getDouble(__element(i));
    }
}
