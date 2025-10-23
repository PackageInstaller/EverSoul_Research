package org.apache.commons.lang3;

import com.liapp.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isTrue(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isTrue(boolean z, String str, double d) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isTrue(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isTrue(boolean z) {
        if (!z) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051651165));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T notNull(T t) {
        return (T) notNull(t, y.ٴسسݬߨ(1392545778), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T notNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (tArr.length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] notEmpty(T[] tArr) {
        return (T[]) notEmpty(tArr, y.٬ݯح׭٩(575883686), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Collection<?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (t.isEmpty()) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Collection<?>> T notEmpty(T t) {
        return (T) notEmpty(t, y.ۮڭڭܬި(862247595), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Map<?, ?>> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (t.isEmpty()) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Map<?, ?>> T notEmpty(T t) {
        return (T) notEmpty(t, y.ٲٴݴ״ٰ(1781896096), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T notEmpty(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (t.length() != 0) {
            return t;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T notEmpty(T t) {
        return (T) notEmpty(t, y.ݬֲ֮ܲت(1512675807), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T notBlank(T t, String str, Object... objArr) {
        if (t == null) {
            throw new NullPointerException(String.format(str, objArr));
        }
        if (StringUtils.isBlank(t)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T notBlank(T t) {
        return (T) notBlank(t, y.ݮڮֲڭܩ(-628849476), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((Integer[]) objArr, Integer.valueOf(i))));
            }
        }
        return tArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] noNullElements(T[] tArr) {
        return (T[]) noNullElements(tArr, y.ݬֲ֮ܲت(1512676535), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Iterable<?>> T noNullElements(T t, String str, Object... objArr) {
        notNull(t);
        Iterator it = t.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll(objArr, Integer.valueOf(i))));
            }
            i++;
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Iterable<?>> T noNullElements(T t) {
        return (T) noNullElements(t, y.٬ݯح׭٩(575893878), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] validIndex(T[] tArr, int i, String str, Object... objArr) {
        notNull(tArr);
        if (i < 0 || i >= tArr.length) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return tArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T[] validIndex(T[] tArr, int i) {
        return (T[]) validIndex(tArr, i, y.ٴسسݬߨ(1392544658), Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Collection<?>> T validIndex(T t, int i, String str, Object... objArr) {
        notNull(t);
        if (i < 0 || i >= t.size()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Collection<?>> T validIndex(T t, int i) {
        return (T) validIndex(t, i, y.ۮڭڭܬި(862249827), Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T validIndex(T t, int i, String str, Object... objArr) {
        notNull(t);
        if (i < 0 || i >= t.length()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends CharSequence> T validIndex(T t, int i) {
        return (T) validIndex(t, i, y.ݮڮֲڭܩ(-628835124), Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void validState(boolean z) {
        if (!z) {
            throw new IllegalStateException(y.ݮڮֲڭܩ(-628838068));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void validState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, str));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void notNaN(double d) {
        notNaN(d, y.ٲٴݴ״ٰ(1781895568), new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void notNaN(double d, String str, Object... objArr) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void finite(double d) {
        finite(d, y.دײܮڳܯ(2051651885), Double.valueOf(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void finite(double d, String str, Object... objArr) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t, t2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void inclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) < 0 || comparable.compareTo(t2) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void inclusiveBetween(long j, long j2, long j3) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void inclusiveBetween(long j, long j2, long j3, String str) {
        if (j3 < j || j3 > j2) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void inclusiveBetween(double d, double d2, double d3) {
        if (d3 < d || d3 > d2) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void inclusiveBetween(double d, double d2, double d3, String str) {
        if (d3 < d || d3 > d2) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t, t2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void exclusiveBetween(T t, T t2, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t) <= 0 || comparable.compareTo(t2) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void exclusiveBetween(long j, long j2, long j3) {
        if (j3 <= j || j3 >= j2) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j3), Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void exclusiveBetween(long j, long j2, long j3, String str) {
        if (j3 <= j || j3 >= j2) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void exclusiveBetween(double d, double d2, double d3) {
        if (d3 <= d || d3 >= d2) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d3), Double.valueOf(d), Double.valueOf(d2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void exclusiveBetween(double d, double d2, double d3, String str) {
        if (d3 <= d || d3 >= d2) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (cls.isInstance(obj)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls.getName();
        objArr[1] = obj == null ? "null" : obj.getClass().getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls2 == null ? "null" : cls2.getName();
        objArr[1] = cls.getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
