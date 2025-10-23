package org.apache.commons.lang3;

import com.liapp.y;
import java.util.Random;

/* loaded from: classes2.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] nextBytes(int i) {
        Validate.isTrue(i >= 0, y.ٴسسݬߨ(1392996634), new Object[0]);
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int nextInt(int i, int i2) {
        Validate.isTrue(i2 >= i, y.ݬֲ֮ܲت(1512987015), new Object[0]);
        Validate.isTrue(i >= 0, y.٬ݯح׭٩(575977358), new Object[0]);
        return i == i2 ? i : i + RANDOM.nextInt(i2 - i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long nextLong(long j, long j2) {
        Validate.isTrue(j2 >= j, y.ݬֲ֮ܲت(1512987015), new Object[0]);
        Validate.isTrue(j >= 0, y.٬ݯح׭٩(575977358), new Object[0]);
        return j == j2 ? j : (long) nextDouble(j, j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long nextLong() {
        return nextLong(0L, Long.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double nextDouble(double d, double d2) {
        Validate.isTrue(d2 >= d, y.ݬֲ֮ܲت(1512987015), new Object[0]);
        Validate.isTrue(d >= 0.0d, y.٬ݯح׭٩(575977358), new Object[0]);
        return d == d2 ? d : d + ((d2 - d) * RANDOM.nextDouble());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double nextDouble() {
        return nextDouble(0.0d, Double.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float nextFloat(float f, float f2) {
        Validate.isTrue(f2 >= f, y.ݬֲ֮ܲت(1512987015), new Object[0]);
        Validate.isTrue(f >= 0.0f, y.٬ݯح׭٩(575977358), new Object[0]);
        return f == f2 ? f : f + ((f2 - f) * RANDOM.nextFloat());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float nextFloat() {
        return nextFloat(0.0f, Float.MAX_VALUE);
    }
}
