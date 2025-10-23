package com.google.common.base;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Preconditions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Preconditions() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkState(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), Long.valueOf(j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, char c, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c), obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, int i, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i), obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Character.valueOf(c)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, long j, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j), obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int checkElementIndex(int i, int i2) {
        return checkElementIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int checkElementIndex(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(badElementIndex(i, i2, str));
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String badElementIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int checkPositionIndex(int i, int i2) {
        return checkPositionIndex(i, i2, FirebaseAnalytics.Param.INDEX);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int checkPositionIndex(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(badPositionIndex(i, i2, str));
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String badPositionIndex(int i, int i2, String str) {
        if (i < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i, i2, i3));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String badPositionIndexes(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return badPositionIndex(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? badPositionIndex(i2, i3, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }
}
