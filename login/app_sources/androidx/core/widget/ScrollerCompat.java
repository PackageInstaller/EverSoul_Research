package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
/* loaded from: classes.dex */
public final class ScrollerCompat {
    OverScroller mScroller;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ScrollerCompat(Context context, Interpolator interpolator) {
        this.mScroller = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4) {
        this.mScroller.startScroll(i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mScroller.startScroll(i, i2, i3, i4, i5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.mScroller.fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        return this.mScroller.springBack(i, i2, i3, i4, i5, i6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScroller.notifyHorizontalEdgeReached(i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mScroller.notifyVerticalEdgeReached(i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }
}
