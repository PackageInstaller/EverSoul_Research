package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UnionVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnionVector __assign(int i, int i2, ByteBuffer byteBuffer) {
        __reset(i, i2, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Table get(Table table, int i) {
        return Table.__union(table, __element(i), this.f119bb);
    }
}
