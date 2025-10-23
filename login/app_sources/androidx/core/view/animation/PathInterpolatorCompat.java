package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PathInterpolatorCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Interpolator create(Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Interpolator create(float f, float f2) {
        return Api21Impl.createPathInterpolator(f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Interpolator create(float f, float f2, float f3, float f4) {
        return Api21Impl.createPathInterpolator(f, f2, f3, f4);
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PathInterpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PathInterpolator createPathInterpolator(float f, float f2) {
            return new PathInterpolator(f, f2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PathInterpolator createPathInterpolator(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }
    }
}
