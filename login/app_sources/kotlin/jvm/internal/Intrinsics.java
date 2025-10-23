package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public class Intrinsics {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Intrinsics() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String stringPlus(String str, Object obj) {
        return str + obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwNpe(String str) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwJavaNpe(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwUninitializedProperty(String str) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwAssert(String str) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwIllegalArgument(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwIllegalState(String str) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str + " must not be null")));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str + " must not be null")));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Method specified as non-null returned null: " + str + "." + str2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Field specified as non-null is null: " + str + "." + str2)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullIAE(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullNPE(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void throwParameterIsNullIAE(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(str))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void throwParameterIsNullNPE(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(str))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String createParameterIsNullExceptionMessage(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(Double d, Double d2) {
        if (d == null) {
            if (d2 == null) {
                return true;
            }
        } else if (d2 != null && d.doubleValue() == d2.doubleValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(Float f, Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void needClassReification() {
        throwUndefinedForReified();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkHasClass(String str) throws ClassNotFoundException {
        String replace = str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + replace + " is not found. Please update the Kotlin runtime to the latest version", e)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + replace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return (T) sanitizeStackTrace(t, Intrinsics.class.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static class Kotlin {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Kotlin() {
        }
    }
}
