package org.apache.commons.lang3.builder;

import com.liapp.y;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class HashCodeBuilder implements Builder<Integer> {
    private static final int DEFAULT_INITIAL_VALUE = 17;
    private static final int DEFAULT_MULTIPLIER_VALUE = 37;
    private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal<>();
    private final int iConstant;
    private int iTotal;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Set<IDKey> getRegistry() {
        return REGISTRY.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isRegistered(Object obj) {
        Set<IDKey> registry = getRegistry();
        return registry != null && registry.contains(new IDKey(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void reflectionAppend(Object obj, Class<?> cls, HashCodeBuilder hashCodeBuilder, boolean z, String[] strArr) {
        if (isRegistered(obj)) {
            return;
        }
        try {
            register(obj);
            Field[] declaredFields = cls.getDeclaredFields();
            AccessibleObject.setAccessible(declaredFields, true);
            for (Field field : declaredFields) {
                if (!ArrayUtils.contains(strArr, field.getName()) && !field.getName().contains("$") && ((z || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(HashCodeExclude.class))) {
                    try {
                        hashCodeBuilder.append(field.get(obj));
                    } catch (IllegalAccessException unused) {
                        throw new InternalError("Unexpected IllegalAccessException");
                    }
                }
            }
        } finally {
            unregister(obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int reflectionHashCode(int i, int i2, Object obj) {
        return reflectionHashCode(i, i2, obj, false, null, new String[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int reflectionHashCode(int i, int i2, Object obj, boolean z) {
        return reflectionHashCode(i, i2, obj, z, null, new String[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> int reflectionHashCode(int i, int i2, T t, boolean z, Class<? super T> cls, String... strArr) {
        Validate.isTrue(t != null, y.ٲٴݴ״ٰ(1781892392), new Object[0]);
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i, i2);
        Class<?> cls2 = t.getClass();
        reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
        while (cls2.getSuperclass() != null && cls2 != cls) {
            cls2 = cls2.getSuperclass();
            reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
        }
        return hashCodeBuilder.toHashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, null, new String[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int reflectionHashCode(Object obj, String... strArr) {
        return reflectionHashCode(17, 37, obj, false, null, strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void register(Object obj) {
        Set<IDKey> registry = getRegistry();
        if (registry == null) {
            registry = new HashSet<>();
            REGISTRY.set(registry);
        }
        registry.add(new IDKey(obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void unregister(Object obj) {
        Set<IDKey> registry = getRegistry();
        if (registry != null) {
            registry.remove(new IDKey(obj));
            if (registry.isEmpty()) {
                REGISTRY.remove();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder() {
        this.iConstant = 37;
        this.iTotal = 17;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder(int i, int i2) {
        this.iTotal = 0;
        Validate.isTrue(i % 2 != 0, y.ݮڮֲڭܩ(-628839628), new Object[0]);
        Validate.isTrue(i2 % 2 != 0, y.ٲٴݴ״ٰ(1781893064), new Object[0]);
        this.iConstant = i2;
        this.iTotal = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(boolean z) {
        this.iTotal = (this.iTotal * this.iConstant) + (!z ? 1 : 0);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean z : zArr) {
                append(z);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(byte b) {
        this.iTotal = (this.iTotal * this.iConstant) + b;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte b : bArr) {
                append(b);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(char c) {
        this.iTotal = (this.iTotal * this.iConstant) + c;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char c : cArr) {
                append(c);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(double d) {
        return append(Double.doubleToLongBits(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double d : dArr) {
                append(d);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(float f) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float f : fArr) {
                append(f);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int i : iArr) {
                append(i);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(long j) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j ^ (j >> 32)));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long j : jArr) {
                append(j);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (obj.getClass().isArray()) {
            appendArray(obj);
        } else {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendArray(Object obj) {
        if (obj instanceof long[]) {
            append((long[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            append((int[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            append((short[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            append((char[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            append((byte[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            append((double[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else {
            append((Object[]) obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object obj : objArr) {
                append(obj);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short s : sArr) {
                append(s);
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashCodeBuilder appendSuper(int i) {
        this.iTotal = (this.iTotal * this.iConstant) + i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int toHashCode() {
        return this.iTotal;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.Builder
    public Integer build() {
        return Integer.valueOf(toHashCode());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return toHashCode();
    }
}
