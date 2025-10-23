package org.checkerframework.checker.i18nformatter.qual;

import com.liapp.y;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/* loaded from: classes2.dex */
public enum I18nConversionCategory {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{y.٬ݯح׭٩(575818262), y.٬ݯح׭٩(575818342)}),
    NUMBER(new Class[]{Number.class}, new String[]{y.٬ݯح׭٩(575818374), y.دײܮڳܯ(2051574917)});

    public final String[] strings;
    public final Class<?>[] types;
    static I18nConversionCategory[] namedCategories = {DATE, NUMBER};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    I18nConversionCategory(Class[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        for (I18nConversionCategory i18nConversionCategory : namedCategories) {
            for (String str2 : i18nConversionCategory.strings) {
                if (str2.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512613103) + lowerCase);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        Set arrayToSet = arrayToSet(i18nConversionCategory.types);
        arrayToSet.retainAll(arrayToSet(i18nConversionCategory2.types));
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory5 = i18nConversionCategoryArr[i];
            if (arrayToSet(i18nConversionCategory5.types).equals(arrayToSet)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static I18nConversionCategory union(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        return (i18nConversionCategory == i18nConversionCategory3 || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = GENERAL) || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = DATE) || i18nConversionCategory2 == i18nConversionCategory3) ? i18nConversionCategory3 : NUMBER;
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
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(y.ٲٴݴ״ٰ(1781831472));
        } else {
            StringJoiner stringJoiner = new StringJoiner(y.ݬֲ֮ܲت(1513068719), y.֬ڱܱײٮ(-1159605239), y.ٴسسݬߨ(1392959042));
            for (Class<?> cls : this.types) {
                stringJoiner.add(cls.getCanonicalName());
            }
            sb.append(stringJoiner);
        }
        return sb.toString();
    }
}
