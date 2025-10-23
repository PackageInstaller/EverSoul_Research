package org.apache.commons.lang3.reflect;

import com.liapp.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class FieldUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field getField(Class<?> cls, String str) {
        Field field = getField(cls, str, false);
        MemberUtils.setAccessibleWorkaround(field);
        return field;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field getField(Class<?> cls, String str, boolean z) {
        Field declaredField;
        Validate.isTrue(cls != null, y.٬ݯح׭٩(575871006), new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(str), y.٬ݯح׭٩(575871294), new Object[0]);
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                declaredField = cls2.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                if (!z) {
                    continue;
                } else {
                    declaredField.setAccessible(true);
                }
            }
            return declaredField;
        }
        Iterator<Class<?>> it = ClassUtils.getAllInterfaces(cls).iterator();
        Field field = null;
        while (it.hasNext()) {
            try {
                Field field2 = it.next().getField(str);
                Validate.isTrue(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field2;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field getDeclaredField(Class<?> cls, String str) {
        return getDeclaredField(cls, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        Validate.isTrue(cls != null, y.٬ݯح׭٩(575871006), new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(str), y.٬ݯح׭٩(575871294), new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!MemberUtils.isAccessible(declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field[] getAllFields(Class<?> cls) {
        List<Field> allFieldsList = getAllFieldsList(cls);
        return (Field[]) allFieldsList.toArray(new Field[allFieldsList.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Field> getAllFieldsList(Class<?> cls) {
        Validate.isTrue(cls != null, y.٬ݯح׭٩(575871006), new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            Collections.addAll(arrayList, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        List<Field> fieldsListWithAnnotation = getFieldsListWithAnnotation(cls, cls2);
        return (Field[]) fieldsListWithAnnotation.toArray(new Field[fieldsListWithAnnotation.size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<Field> getFieldsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        Validate.isTrue(cls2 != null, y.ۮڭڭܬި(862238587), new Object[0]);
        List<Field> allFieldsList = getAllFieldsList(cls);
        ArrayList arrayList = new ArrayList();
        for (Field field : allFieldsList) {
            if (field.getAnnotation(cls2) != null) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readStaticField(field, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, y.٬ݯح׭٩(575872182), new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), y.ٲٴݴ״ٰ(1781909104), field.getName());
        return readField(field, (Object) null, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readStaticField(cls, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(field, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readDeclaredStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readDeclaredStaticField(cls, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readDeclaredStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        return readStaticField(declaredField, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, y.٬ݯح׭٩(575872182), new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        return field.get(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readField(Object obj, String str) throws IllegalAccessException {
        return readField(obj, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, y.ݮڮֲڭܩ(-628823084), new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readDeclaredField(Object obj, String str) throws IllegalAccessException {
        return readDeclaredField(obj, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object readDeclaredField(Object obj, String str, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, y.ݮڮֲڭܩ(-628823084), new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls, str);
        return readField(declaredField, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeStaticField(field, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, y.٬ݯح׭٩(575872182), new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), y.ٴسسݬߨ(1392564746), field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeStaticField(cls, str, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        writeStaticField(field, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeDeclaredStaticField(cls, str, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, (Object) null, obj, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Validate.isTrue(field != null, y.٬ݯح׭٩(575872182), new Object[0]);
        if (z && !field.isAccessible()) {
            field.setAccessible(true);
        } else {
            MemberUtils.setAccessibleWorkaround(field);
        }
        field.set(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeFinalModifier(Field field) {
        removeFinalModifier(field, true);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void removeFinalModifier(Field field, boolean z) {
        Validate.isTrue(field != null, y.٬ݯح׭٩(575872182), new Object[0]);
        try {
            if (Modifier.isFinal(field.getModifiers())) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                boolean z2 = z && !declaredField.isAccessible();
                if (z2) {
                    declaredField.setAccessible(true);
                }
                try {
                    declaredField.setInt(field, field.getModifiers() & (-17));
                    if (z2) {
                        declaredField.setAccessible(false);
                    }
                } catch (Throwable th) {
                    if (z2) {
                        declaredField.setAccessible(false);
                    }
                    throw th;
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, y.ݮڮֲڭܩ(-628823084), new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(field, obj, obj2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeDeclaredField(obj, str, obj2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.isTrue(obj != null, y.ݮڮֲڭܩ(-628823084), new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }
}
