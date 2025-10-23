package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class BaseVector {

    /* renamed from: bb */
    protected ByteBuffer f119bb;
    private int element_size;
    private int length;
    private int vector;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int __vector() {
        return this.vector;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int __element(int i) {
        return this.vector + (i * this.element_size);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void __reset(int i, int i2, ByteBuffer byteBuffer) {
        this.f119bb = byteBuffer;
        if (byteBuffer != null) {
            this.vector = i;
            this.length = byteBuffer.getInt(i - 4);
            this.element_size = i2;
        } else {
            this.vector = 0;
            this.length = 0;
            this.element_size = 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        __reset(0, 0, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int length() {
        return this.length;
    }
}
