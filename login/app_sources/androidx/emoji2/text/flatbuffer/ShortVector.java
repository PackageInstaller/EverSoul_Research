package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import kotlin.UShort;

/* loaded from: classes.dex */
public final class ShortVector extends BaseVector {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShortVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 2, byteBuffer);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short get(int i) {
        return this.f119bb.getShort(__element(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAsUnsigned(int i) {
        return get(i) & UShort.MAX_VALUE;
    }
}
