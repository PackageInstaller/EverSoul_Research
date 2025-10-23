package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.create(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.mEdgeEffect, f, f2);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void onPull(EdgeEffect edgeEffect, float f, float f2) {
        Api21Impl.onPull(edgeEffect, f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.onPullDistance(edgeEffect, f, f2);
        }
        onPull(edgeEffect, f, f2);
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    private static class Api31Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api31Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void onPull(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }
}
