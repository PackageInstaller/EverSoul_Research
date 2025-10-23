package org.apache.commons.lang3;

import com.liapp.y;

/* loaded from: classes2.dex */
public class ClassPathUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Object[] objArr = {y.ݬֲ֮ܲت(1512979991)};
        String str2 = y.֬ڱܱײٮ(-1159247639);
        Validate.notNull(cls, str2, objArr);
        Validate.notNull(str, str2, y.ݬֲ֮ܲت(1512979839));
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toFullyQualifiedName(Package r4, String str) {
        Object[] objArr = {y.ݬֲ֮ܲت(1512979991)};
        String str2 = y.֬ڱܱײٮ(-1159247639);
        Validate.notNull(r4, str2, objArr);
        Validate.notNull(str, str2, y.ݬֲ֮ܲت(1512979839));
        return r4.getName() + y.ݮڮֲڭܩ(-629059348) + str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Object[] objArr = {y.ݬֲ֮ܲت(1512979991)};
        String str2 = y.֬ڱܱײٮ(-1159247639);
        Validate.notNull(cls, str2, objArr);
        Validate.notNull(str, str2, y.ݬֲ֮ܲت(1512979839));
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toFullyQualifiedPath(Package r4, String str) {
        Object[] objArr = {y.ݬֲ֮ܲت(1512979991)};
        String str2 = y.֬ڱܱײٮ(-1159247639);
        Validate.notNull(r4, str2, objArr);
        Validate.notNull(str, str2, y.ݬֲ֮ܲت(1512979839));
        return r4.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + y.ۮڭڭܬި(861981587) + str;
    }
}
