package androidx.core.math;

/* loaded from: classes.dex */
public class MathUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long clamp(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MathUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int addExact(int i, int i2) {
        int i3 = i + i2;
        if (((i ^ i3) & (i2 ^ i3)) >= 0) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long addExact(long j, long j2) {
        long j3 = j + j2;
        if (((j ^ j3) & (j2 ^ j3)) >= 0) {
            return j3;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int subtractExact(int i, int i2) {
        int i3 = i - i2;
        if (((i ^ i3) & (i2 ^ i)) >= 0) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long subtractExact(long j, long j2) {
        long j3 = j - j2;
        if (((j ^ j3) & (j2 ^ j)) >= 0) {
            return j3;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int multiplyExact(int i, int i2) {
        long j = i * i2;
        int i3 = (int) j;
        if (i3 == j) {
            return i3;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long multiplyExact(long j, long j2) {
        long j3 = j * j2;
        if (((Math.abs(j) | Math.abs(j2)) >>> 31) == 0 || ((j2 == 0 || j3 / j2 == j) && !(j == Long.MIN_VALUE && j2 == -1))) {
            return j3;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long incrementExact(long j) {
        if (j != Long.MAX_VALUE) {
            return j + 1;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("long overflow");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int toIntExact(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
