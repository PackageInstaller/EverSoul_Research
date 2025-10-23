package org.apache.commons.lang3.reflect;

import com.liapp.y;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public abstract class TypeLiteral<T> implements Typed<T> {

    /* renamed from: T */
    private static final TypeVariable<Class<TypeLiteral>> f1526T = TypeLiteral.class.getTypeParameters()[0];
    private final String toString;
    public final Type value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected TypeLiteral() {
        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(getClass(), TypeLiteral.class);
        TypeVariable<Class<TypeLiteral>> typeVariable = f1526T;
        Type type = (Type) Validate.notNull(typeArguments.get(typeVariable), y.ݮڮֲڭܩ(-628825268), getClass(), TypeUtils.toLongString(typeVariable));
        this.value = type;
        this.toString = String.format(y.ٲٴݴ״ٰ(1781911456), y.٬ݯح׭٩(575870078), TypeUtils.toString(type));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TypeLiteral) {
            return TypeUtils.equals(this.value, ((TypeLiteral) obj).value);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value.hashCode() | 592;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.toString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.reflect.Typed
    public Type getType() {
        return this.value;
    }
}
