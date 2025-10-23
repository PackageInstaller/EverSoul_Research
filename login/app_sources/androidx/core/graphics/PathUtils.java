package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PathUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<PathSegment> flatten(Path path) {
        return flatten(path, 0.5f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Collection<PathSegment> flatten(Path path, float f) {
        float[] approximate = Api26Impl.approximate(path, f);
        int length = approximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i2 = i * 3;
            int i3 = (i - 1) * 3;
            float f2 = approximate[i2];
            float f3 = approximate[i2 + 1];
            float f4 = approximate[i2 + 2];
            float f5 = approximate[i3];
            float f6 = approximate[i3 + 1];
            float f7 = approximate[i3 + 2];
            if (f2 != f5 && (f3 != f6 || f4 != f7)) {
                arrayList.add(new PathSegment(new PointF(f6, f7), f5, new PointF(f3, f4), f2));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PathUtils() {
    }

    static class Api26Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api26Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }
}
