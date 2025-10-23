package org.checkerframework.checker.formatter.qual;

import com.liapp.y;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: classes2.dex */
public enum ConversionCategory {
    GENERAL(y.ٴسسݬߨ(1392619874), null),
    CHAR(y.֬ڱܱײٮ(-1159598959), Character.class, Byte.class, Short.class, Integer.class),
    INT(y.֬ڱܱײٮ(-1159598903), Byte.class, Short.class, Integer.class, Long.class, BigInteger.class),
    FLOAT(y.٬ݯح׭٩(575829614), Float.class, Double.class, BigDecimal.class),
    TIME(y.ٴسسݬߨ(1392620170), Long.class, Calendar.class, Date.class),
    CHAR_AND_INT(null, Byte.class, Short.class, Integer.class),
    INT_AND_TIME(null, Long.class),
    NULL(null, new Class[0]),
    UNUSED(null, null);

    public final String chars;
    public final Class<?>[] types;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConversionCategory(String str, Class... clsArr) {
        this.chars = str;
        if (clsArr == null) {
            this.types = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class cls : clsArr) {
            arrayList.add(cls);
            Class<? extends Object> unwrapPrimitive = unwrapPrimitive(cls);
            if (unwrapPrimitive != null) {
                arrayList.add(unwrapPrimitive);
            }
        }
        this.types = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class<? extends Object> unwrapPrimitive(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConversionCategory fromConversionChar(char c) {
        ConversionCategory[] conversionCategoryArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 5; i++) {
            ConversionCategory conversionCategory = conversionCategoryArr[i];
            if (conversionCategory.chars.contains(String.valueOf(c))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512613855) + c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return intersect(conversionCategory, conversionCategory2) == conversionCategory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.retainAll(arrayToSet(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory5 = conversionCategoryArr[i];
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3;
        ConversionCategory conversionCategory4 = UNUSED;
        if (conversionCategory == conversionCategory4 || conversionCategory2 == conversionCategory4 || conversionCategory == (conversionCategory4 = GENERAL) || conversionCategory2 == conversionCategory4) {
            return conversionCategory4;
        }
        ConversionCategory conversionCategory5 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory5 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == (conversionCategory3 = INT_AND_TIME) && conversionCategory2 == conversionCategory5)) {
            return INT;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.addAll(arrayToSet(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {NULL, conversionCategory5, conversionCategory3, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory6 = conversionCategoryArr[i];
            if (arrayToSet(conversionCategory6.types).equals(arrayToSet)) {
                return conversionCategory6;
            }
        }
        return GENERAL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAssignableFrom(Class<?> cls) {
        if (this.types == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> cls2 : this.types) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    @Pure
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(y.٬ݯح׭٩(575818030));
        Class<?>[] clsArr = this.types;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(y.ݬֲ֮ܲت(1513068719), y.ٲٴݴ״ٰ(1781830360), y.ٴسسݬߨ(1392959042));
        for (Class<?> cls : this.types) {
            stringJoiner.add(cls.getSimpleName());
        }
        sb.append(y.دײܮڳܯ(2051829469));
        sb.append(stringJoiner);
        return sb.toString();
    }
}
