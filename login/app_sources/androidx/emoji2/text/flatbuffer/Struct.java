package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class Struct {

    /* renamed from: bb */
    protected ByteBuffer f124bb;
    protected int bb_pos;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void __reset(int i, ByteBuffer byteBuffer) {
        this.f124bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i;
        } else {
            this.bb_pos = 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void __reset() {
        __reset(0, null);
    }
}
