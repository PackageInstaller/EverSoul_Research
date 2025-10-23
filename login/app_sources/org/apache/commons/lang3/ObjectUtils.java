package org.apache.commons.lang3;

import com.liapp.y;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* loaded from: classes2.dex */
public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte CONST(byte b) {
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static char CONST(char c) {
        return c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double CONST(double d) {
        return d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float CONST(float f) {
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int CONST(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long CONST(long j) {
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T CONST(T t) {
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static short CONST(short s) {
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean CONST(boolean z) {
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean allNotNull(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int i = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                i = (i * 31) + hashCode(obj);
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb = new StringBuilder(name.length() + 1 + hexString.length());
        sb.append(name).append(AT_SIGN).append(hexString);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Validate.notNull(obj, y.ݮڮֲڭܩ(-628932092), new Object[0]);
        appendable.append(obj.getClass().getName()).append(AT_SIGN).append(Integer.toHexString(System.identityHashCode(obj)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Validate.notNull(obj, y.ݮڮֲڭܩ(-628932092), new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        strBuilder.ensureCapacity(strBuilder.length() + name.length() + 1 + hexString.length());
        strBuilder.append(name).append(AT_SIGN).append(hexString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Validate.notNull(obj, y.ݮڮֲڭܩ(-628932092), new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name).append(AT_SIGN).append(hexString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void identityToString(StringBuilder sb, Object obj) {
        Validate.notNull(obj, y.ݮڮֲڭܩ(-628932092), new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        sb.ensureCapacity(sb.length() + name.length() + 1 + hexString.length());
        sb.append(name).append(AT_SIGN).append(hexString);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, true) < 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t = null;
        if (tArr != null) {
            for (T t2 : tArr) {
                if (compare(t2, t, false) > 0) {
                    t = t2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<? super T>> int compare(T t, T t2) {
        return compare(t, t2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Comparable<? super T>> int compare(T t, T t2, boolean z) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return z ? 1 : -1;
        }
        if (t2 == null) {
            return z ? -1 : 1;
        }
        return t.compareTo(t2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, y.ݬֲ֮ܲت(1512987711), new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, y.֬ڱܱײٮ(-1159254775), new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap hashMap = new HashMap(tArr.length);
        int i = 0;
        for (T t : tArr) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t);
            if (mutableInt == null) {
                hashMap.put(t, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        while (true) {
            T t2 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue == i) {
                    break;
                }
                if (intValue > i) {
                    t2 = (T) entry.getKey();
                    i = intValue;
                }
            }
            return t2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T clone(T t) {
        if (!(t instanceof Cloneable)) {
            return null;
        }
        if (t.getClass().isArray()) {
            Class<?> componentType = t.getClass().getComponentType();
            if (componentType.isPrimitive()) {
                int length = Array.getLength(t);
                T t2 = (T) Array.newInstance(componentType, length);
                while (true) {
                    int i = length - 1;
                    if (length <= 0) {
                        return t2;
                    }
                    Array.set(t2, i, Array.get(t, i));
                    length = i;
                }
            } else {
                return (T) ((Object[]) t).clone();
            }
        } else {
            try {
                return (T) t.getClass().getMethod("clone", new Class[0]).invoke(t, new Object[0]);
            } catch (IllegalAccessException e) {
                throw new CloneFailedException(y.ٴسسݬߨ(1392997490) + t.getClass().getName(), e);
            } catch (NoSuchMethodException e2) {
                throw new CloneFailedException(y.ݬֲ֮ܲت(1512988295) + t.getClass().getName() + y.ٲٴݴ״ٰ(1781689008), e2);
            } catch (InvocationTargetException e3) {
                throw new CloneFailedException(y.دײܮڳܯ(2051963237) + t.getClass().getName(), e3.getCause());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T cloneIfPossible(T t) {
        T t2 = (T) clone(t);
        return t2 == null ? t : t2;
    }

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Null() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte CONST_BYTE(int i) {
        if (i < -128 || i > 127) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2051964117) + i + y.ۮڭڭܬި(862078387));
        }
        return (byte) i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static short CONST_SHORT(int i) {
        if (i < -32768 || i > 32767) {
            throw new IllegalArgumentException(y.٬ݯح׭٩(575978750) + i + y.ۮڭڭܬި(862078387));
        }
        return (short) i;
    }
}
