package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class Rect {
    public int bottom;
    public int left;
    public int right;
    public int top;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int width() {
        return this.right - this.left;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int height() {
        return this.bottom - this.top;
    }
}
