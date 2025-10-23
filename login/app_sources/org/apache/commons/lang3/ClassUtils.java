package org.apache.commons.lang3;

import com.liapp.y;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.mutable.MutableObject;

/* loaded from: classes2.dex */
public class ClassUtils {
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    private static final Map<String, String> abbreviationMap;
    private static final Map<String, Class<?>> namePrimitiveMap;
    private static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    private static final Map<String, String> reverseAbbreviationMap;
    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final String PACKAGE_SEPARATOR = String.valueOf(PACKAGE_SEPARATOR_CHAR);
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    public enum Interfaces {
        INCLUDE,
        EXCLUDE
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        HashMap hashMap = new HashMap();
        namePrimitiveMap = hashMap;
        Class cls = Boolean.TYPE;
        String str = y.ٴسسݬߨ(1392973754);
        hashMap.put(str, cls);
        Class cls2 = Byte.TYPE;
        String str2 = y.٬ݯح׭٩(575984670);
        hashMap.put(str2, cls2);
        Class cls3 = Character.TYPE;
        String str3 = y.٬ݯح׭٩(575984750);
        hashMap.put(str3, cls3);
        Class cls4 = Short.TYPE;
        String str4 = y.ۮڭڭܬި(862157243);
        hashMap.put(str4, cls4);
        Class cls5 = Integer.TYPE;
        String str5 = y.ۮڭڭܬި(862157299);
        hashMap.put(str5, cls5);
        Class cls6 = Long.TYPE;
        String str6 = y.֬ڱܱײٮ(-1159246383);
        hashMap.put(str6, cls6);
        Class cls7 = Double.TYPE;
        String str7 = y.ݮڮֲڭܩ(-628939444);
        hashMap.put(str7, cls7);
        Class cls8 = Float.TYPE;
        String str8 = y.ݮڮֲڭܩ(-628939508);
        hashMap.put(str8, cls8);
        hashMap.put(y.٬ݯح׭٩(575985062), Void.TYPE);
        HashMap hashMap2 = new HashMap();
        primitiveWrapperMap = hashMap2;
        hashMap2.put(Boolean.TYPE, Boolean.class);
        hashMap2.put(Byte.TYPE, Byte.class);
        hashMap2.put(Character.TYPE, Character.class);
        hashMap2.put(Short.TYPE, Short.class);
        hashMap2.put(Integer.TYPE, Integer.class);
        hashMap2.put(Long.TYPE, Long.class);
        hashMap2.put(Double.TYPE, Double.class);
        hashMap2.put(Float.TYPE, Float.class);
        hashMap2.put(Void.TYPE, Void.TYPE);
        wrapperPrimitiveMap = new HashMap();
        for (Map.Entry entry : hashMap2.entrySet()) {
            Class<?> cls9 = (Class) entry.getKey();
            Class<?> cls10 = (Class) entry.getValue();
            if (!cls9.equals(cls10)) {
                wrapperPrimitiveMap.put(cls10, cls9);
            }
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put(str5, y.دײܮڳܯ(2051937205));
        hashMap3.put(str, y.֬ڱܱײٮ(-1159246623));
        hashMap3.put(str8, y.ٴسسݬߨ(1392972202));
        hashMap3.put(str6, y.ݮڮֲڭܩ(-628939172));
        hashMap3.put(str4, y.ݮڮֲڭܩ(-628939148));
        hashMap3.put(str2, y.֬ڱܱײٮ(-1159246079));
        hashMap3.put(str7, y.ݮڮֲڭܩ(-628939260));
        hashMap3.put(str3, y.ݮڮֲڭܩ(-628939204));
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            hashMap4.put(entry2.getValue(), entry2.getKey());
        }
        abbreviationMap = Collections.unmodifiableMap(hashMap3);
        reverseAbbreviationMap = Collections.unmodifiableMap(hashMap4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortClassName(Class<?> cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortClassName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.startsWith(y.ٴسسݬߨ(1392956562))) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb.append(y.ۮڭڭܬި(862157459));
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map<String, String> map = reverseAbbreviationMap;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int lastIndexOf = str.lastIndexOf(46);
        int indexOf = str.indexOf(36, lastIndexOf != -1 ? lastIndexOf + 1 : 0);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', PACKAGE_SEPARATOR_CHAR);
        }
        return substring + ((Object) sb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getSimpleName(Class<?> cls) {
        return getSimpleName(cls, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getSimpleName(Class<?> cls, String str) {
        return cls == null ? str : cls.getSimpleName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getSimpleName(Object obj) {
        return getSimpleName(obj, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getSimpleName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getSimpleName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Class<?> cls) {
        return getName(cls, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Class<?> cls, String str) {
        return cls == null ? str : cls.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Object obj) {
        return getName(obj, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getName(Object obj, String str) {
        return obj == null ? str : obj.getClass().getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Class<?> cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
            str = str.substring(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getAbbreviatedName(Class<?> cls, int i) {
        return cls == null ? "" : getAbbreviatedName(cls.getName(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getAbbreviatedName(String str, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        if (str == null) {
            return "";
        }
        int countMatches = StringUtils.countMatches(str, PACKAGE_SEPARATOR_CHAR);
        String[] strArr = new String[countMatches + 1];
        int length = str.length() - 1;
        for (int i2 = countMatches; i2 >= 0; i2--) {
            int lastIndexOf = str.lastIndexOf(46, length);
            String substring = str.substring(lastIndexOf + 1, length + 1);
            i -= substring.length();
            if (i2 > 0) {
                i--;
            }
            if (i2 == countMatches) {
                strArr[i2] = substring;
            } else if (i > 0) {
                strArr[i2] = substring;
            } else {
                strArr[i2] = substring.substring(0, 1);
            }
            length = lastIndexOf - 1;
        }
        return StringUtils.join(strArr, PACKAGE_SEPARATOR_CHAR);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Class<?>> convertClassNamesToClasses(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Class.forName(it.next()));
            } catch (Exception unused) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<String> convertClassesToClassNames(List<Class<?>> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (Class<?> cls : list) {
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAssignable(Class<?>[] clsArr, Class<?>... clsArr2) {
        return isAssignable(clsArr, clsArr2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!ArrayUtils.isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isPrimitiveOrWrapper(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isPrimitive() || isPrimitiveWrapper(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isPrimitiveWrapper(Class<?> cls) {
        return wrapperPrimitiveMap.containsKey(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        return isAssignable(cls, cls2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(cls)) {
                return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Long.TYPE.equals(cls)) {
                return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            }
            if (Float.TYPE.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Short.TYPE.equals(cls)) {
                return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Byte.TYPE.equals(cls)) {
                return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            return false;
        }
        return cls2.isAssignableFrom(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> primitiveToWrapper(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : primitiveWrapperMap.get(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?>[] primitivesToWrappers(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = primitiveToWrapper(clsArr[i]);
        }
        return clsArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return wrapperPrimitiveMap.get(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?>[] wrappersToPrimitives(Class<?>... clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            clsArr2[i] = wrapperToPrimitive(clsArr[i]);
        }
        return clsArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isInnerClass(Class<?> cls) {
        return (cls == null || cls.getEnclosingClass() == null) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> getClass(ClassLoader classLoader, String str, boolean z) throws ClassNotFoundException {
        try {
            Map<String, Class<?>> map = namePrimitiveMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return Class.forName(toCanonicalName(str), z, classLoader);
        } catch (ClassNotFoundException e) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    return getClass(classLoader, str.substring(0, lastIndexOf) + '$' + str.substring(lastIndexOf + 1), z);
                } catch (ClassNotFoundException unused) {
                    throw e;
                }
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?> getClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.class.getClassLoader();
        }
        return getClass(contextClassLoader, str, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Method getPublicMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method method = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
            return method;
        }
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    Method method2 = cls2.getMethod(str, clsArr);
                    if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
                        return method2;
                    }
                } catch (NoSuchMethodException unused) {
                    continue;
                }
            }
        }
        throw new NoSuchMethodException(y.دײܮڳܯ(2051936493) + str + y.دײܮڳܯ(2051829469) + ArrayUtils.toString(clsArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        Validate.notNull(deleteWhitespace, y.ۮڭڭܬި(862157555), new Object[0]);
        String str2 = y.ۮڭڭܬި(862157459);
        if (!deleteWhitespace.endsWith(str2)) {
            return deleteWhitespace;
        }
        StringBuilder sb = new StringBuilder();
        while (deleteWhitespace.endsWith(str2)) {
            deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
            sb.append(y.ٴسسݬߨ(1392956562));
        }
        String str3 = abbreviationMap.get(deleteWhitespace);
        if (str3 != null) {
            sb.append(str3);
        } else {
            sb.append(y.ٴسسݬߨ(1392972506)).append(deleteWhitespace).append(y.֬ڱܱײٮ(-1159407399));
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Class<?>[] toClass(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj == null ? null : obj.getClass();
        }
        return clsArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCanonicalName(Class<?> cls) {
        return getCanonicalName(cls, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCanonicalName(Class<?> cls, String str) {
        String canonicalName;
        return (cls == null || (canonicalName = cls.getCanonicalName()) == null) ? str : canonicalName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCanonicalName(Object obj) {
        return getCanonicalName(obj, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCanonicalName(Object obj, String str) {
        String canonicalName;
        return (obj == null || (canonicalName = obj.getClass().getCanonicalName()) == null) ? str : canonicalName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortCanonicalName(Class<?> cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageCanonicalName(Class<?> cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getCanonicalName(String str) {
        int length;
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            return null;
        }
        int i = 0;
        while (deleteWhitespace.startsWith(y.ٴسسݬߨ(1392956562))) {
            i++;
            deleteWhitespace = deleteWhitespace.substring(1);
        }
        if (i < 1) {
            return deleteWhitespace;
        }
        if (deleteWhitespace.startsWith(y.ٴسسݬߨ(1392972506))) {
            if (deleteWhitespace.endsWith(y.֬ڱܱײٮ(-1159407399))) {
                length = deleteWhitespace.length() - 1;
            } else {
                length = deleteWhitespace.length();
            }
            deleteWhitespace = deleteWhitespace.substring(1, length);
        } else if (!deleteWhitespace.isEmpty()) {
            deleteWhitespace = reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
        }
        StringBuilder sb = new StringBuilder(deleteWhitespace);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Iterable<Class<?>> hierarchy(Class<?> cls) {
        return hierarchy(cls, Interfaces.EXCLUDE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Iterable<Class<?>> hierarchy(final Class<?> cls, Interfaces interfaces) {
        final Iterable<Class<?>> iterable = new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                final MutableObject mutableObject = new MutableObject(cls);
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.1.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return mutableObject.getValue2() != null;
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public Class<?> next() {
                        Class<?> cls2 = (Class) mutableObject.getValue2();
                        mutableObject.setValue(cls2.getSuperclass());
                        return cls2;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
        return interfaces != Interfaces.INCLUDE ? iterable : new Iterable<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Iterable
            public Iterator<Class<?>> iterator() {
                final HashSet hashSet = new HashSet();
                final Iterator it = iterable.iterator();
                return new Iterator<Class<?>>() { // from class: org.apache.commons.lang3.ClassUtils.2.1
                    Iterator<Class<?>> interfaces = Collections.emptySet().iterator();

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.interfaces.hasNext() || it.hasNext();
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public Class<?> next() {
                        if (this.interfaces.hasNext()) {
                            Class<?> next = this.interfaces.next();
                            hashSet.add(next);
                            return next;
                        }
                        Class<?> cls2 = (Class) it.next();
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        walkInterfaces(linkedHashSet, cls2);
                        this.interfaces = linkedHashSet.iterator();
                        return cls2;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    private void walkInterfaces(Set<Class<?>> set, Class<?> cls2) {
                        for (Class<?> cls3 : cls2.getInterfaces()) {
                            if (!hashSet.contains(cls3)) {
                                set.add(cls3);
                            }
                            walkInterfaces(set, cls3);
                        }
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
