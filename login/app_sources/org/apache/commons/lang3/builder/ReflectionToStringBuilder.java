package org.apache.commons.lang3.builder;

import com.liapp.y;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    protected String[] excludeFieldNames;
    private boolean excludeNullValues;
    private Class<?> upToClass;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Object obj) {
        return toString(obj, null, false, false, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Object obj, ToStringStyle toStringStyle) {
        return toString(obj, toStringStyle, false, false, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z) {
        return toString(obj, toStringStyle, z, false, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toString(Object obj, ToStringStyle toStringStyle, boolean z, boolean z2) {
        return toString(obj, toStringStyle, z, z2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> String toString(T t, ToStringStyle toStringStyle, boolean z, boolean z2, boolean z3, Class<? super T> cls) {
        return new ReflectionToStringBuilder(t, toStringStyle, null, cls, z, z2, z3).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringExclude(Object obj, Collection<String> collection) {
        return toStringExclude(obj, toNoNullStringArray(collection));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] toNoNullStringArray(Collection<String> collection) {
        if (collection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return toNoNullStringArray(collection.toArray());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] toNoNullStringArray(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj.toString());
            }
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringExclude(Object obj, String... strArr) {
        return new ReflectionToStringBuilder(obj).setExcludeFieldNames(strArr).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object checkNotNull(Object obj) {
        Validate.isTrue(obj != null, y.ۮڭڭܬި(862256155), new Object[0]);
        return obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReflectionToStringBuilder(Object obj) {
        super(checkNotNull(obj));
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle) {
        super(checkNotNull(obj), toStringStyle);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReflectionToStringBuilder(Object obj, ToStringStyle toStringStyle, StringBuffer stringBuffer) {
        super(checkNotNull(obj), toStringStyle, stringBuffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2) {
        super(checkNotNull(t), toStringStyle, stringBuffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> ReflectionToStringBuilder(T t, ToStringStyle toStringStyle, StringBuffer stringBuffer, Class<? super T> cls, boolean z, boolean z2, boolean z3) {
        super(checkNotNull(t), toStringStyle, stringBuffer);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(cls);
        setAppendTransients(z);
        setAppendStatics(z2);
        setExcludeNullValues(z3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean accept(Field field) {
        if (field.getName().indexOf(36) != -1) {
            return false;
        }
        if (Modifier.isTransient(field.getModifiers()) && !isAppendTransients()) {
            return false;
        }
        if (Modifier.isStatic(field.getModifiers()) && !isAppendStatics()) {
            return false;
        }
        String[] strArr = this.excludeFieldNames;
        if (strArr == null || Arrays.binarySearch(strArr, field.getName()) < 0) {
            return !field.isAnnotationPresent(ToStringExclude.class);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void appendFieldsIn(Class<?> cls) {
        if (cls.isArray()) {
            reflectionAppendArray(getObject());
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        AccessibleObject.setAccessible(declaredFields, true);
        for (Field field : declaredFields) {
            String name = field.getName();
            if (accept(field)) {
                try {
                    Object value = getValue(field);
                    if (!this.excludeNullValues || value != null) {
                        append(name, value, !field.isAnnotationPresent(ToStringSummary.class));
                    }
                } catch (IllegalAccessException e) {
                    throw new InternalError(y.ݬֲ֮ܲت(1512685471) + e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String[] getExcludeFieldNames() {
        return (String[]) this.excludeFieldNames.clone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Object getValue(Field field) throws IllegalAccessException {
        return field.get(getObject());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isExcludeNullValues() {
        return this.excludeNullValues;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReflectionToStringBuilder reflectionAppendArray(Object obj) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, obj);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAppendStatics(boolean z) {
        this.appendStatics = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAppendTransients(boolean z) {
        this.appendTransients = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExcludeNullValues(boolean z) {
        this.excludeNullValues = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ReflectionToStringBuilder setExcludeFieldNames(String... strArr) {
        if (strArr == null) {
            this.excludeFieldNames = null;
        } else {
            String[] noNullStringArray = toNoNullStringArray(strArr);
            this.excludeFieldNames = noNullStringArray;
            Arrays.sort(noNullStringArray);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUpToClass(Class<?> cls) {
        Object object;
        if (cls != null && (object = getObject()) != null && !cls.isInstance(object)) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159673023));
        }
        this.upToClass = cls;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        Class<?> cls = getObject().getClass();
        appendFieldsIn(cls);
        while (cls.getSuperclass() != null && cls != getUpToClass()) {
            cls = cls.getSuperclass();
            appendFieldsIn(cls);
        }
        return super.toString();
    }
}
