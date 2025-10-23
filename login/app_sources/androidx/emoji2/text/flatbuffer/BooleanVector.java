package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class BooleanVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BooleanVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 1, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean get(int i) {
        return this.f119bb.get(__element(i)) != 0;
    }
}
