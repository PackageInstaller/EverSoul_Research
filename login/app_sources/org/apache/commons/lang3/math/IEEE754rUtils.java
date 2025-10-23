package org.apache.commons.lang3.math;

import com.liapp.y;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class IEEE754rUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double min(double... dArr) {
        Validate.isTrue(dArr != null, y.֬ڱܱײٮ(-1159249767), new Object[0]);
        Validate.isTrue(dArr.length != 0, y.ۮڭڭܬި(862235787), new Object[0]);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = min(dArr[i], d);
        }
        return d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float min(float... fArr) {
        Validate.isTrue(fArr != null, y.֬ڱܱײٮ(-1159249767), new Object[0]);
        Validate.isTrue(fArr.length != 0, y.ۮڭڭܬި(862235787), new Object[0]);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = min(fArr[i], f);
        }
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double min(double d, double d2, double d3) {
        return min(min(d, d2), d3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double min(double d, double d2) {
        return Double.isNaN(d) ? d2 : Double.isNaN(d2) ? d : Math.min(d, d2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float min(float f, float f2, float f3) {
        return min(min(f, f2), f3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float min(float f, float f2) {
        return Float.isNaN(f) ? f2 : Float.isNaN(f2) ? f : Math.min(f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double max(double... dArr) {
        Validate.isTrue(dArr != null, y.֬ڱܱײٮ(-1159249767), new Object[0]);
        Validate.isTrue(dArr.length != 0, y.ۮڭڭܬި(862235787), new Object[0]);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            d = max(dArr[i], d);
        }
        return d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float max(float... fArr) {
        Validate.isTrue(fArr != null, y.֬ڱܱײٮ(-1159249767), new Object[0]);
        Validate.isTrue(fArr.length != 0, y.ۮڭڭܬި(862235787), new Object[0]);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            f = max(fArr[i], f);
        }
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double max(double d, double d2, double d3) {
        return max(max(d, d2), d3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double max(double d, double d2) {
        return Double.isNaN(d) ? d2 : Double.isNaN(d2) ? d : Math.max(d, d2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float max(float f, float f2, float f3) {
        return max(max(f, f2), f3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float max(float f, float f2) {
        return Float.isNaN(f) ? f2 : Float.isNaN(f2) ? f : Math.max(f, f2);
    }
}
