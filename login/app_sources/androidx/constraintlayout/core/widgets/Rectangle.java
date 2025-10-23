package androidx.constraintlayout.core.widgets;

/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f49x;

    /* renamed from: y */
    public int f50y;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBounds(int i, int i2, int i3, int i4) {
        this.f49x = i;
        this.f50y = i2;
        this.width = i3;
        this.height = i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void grow(int i, int i2) {
        this.f49x -= i;
        this.f50y -= i2;
        this.width += i * 2;
        this.height += i2 * 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean intersects(Rectangle rectangle) {
        int i;
        int i2;
        int i3 = this.f49x;
        int i4 = rectangle.f49x;
        return i3 >= i4 && i3 < i4 + rectangle.width && (i = this.f50y) >= (i2 = rectangle.f50y) && i < i2 + rectangle.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f49x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f50y) && i2 < i3 + this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCenterX() {
        return (this.f49x + this.width) / 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCenterY() {
        return (this.f50y + this.height) / 2;
    }
}
