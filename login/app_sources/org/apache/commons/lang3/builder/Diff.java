package org.apache.commons.lang3.builder;

import com.liapp.y;
import java.lang.reflect.Type;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.tuple.Pair;

/* loaded from: classes2.dex */
public abstract class Diff<T> extends Pair<T, T> {
    private static final long serialVersionUID = 1;
    private final String fieldName;
    private final Type type = (Type) ObjectUtils.defaultIfNull(TypeUtils.getTypeArguments(getClass(), Diff.class).get(Diff.class.getTypeParameters()[0]), Object.class);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Diff(String str) {
        this.fieldName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Type getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFieldName() {
        return this.fieldName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Pair
    public final String toString() {
        return String.format(y.ݬֲ֮ܲت(1512680351), this.fieldName, getLeft(), getRight());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final T setValue(T t) {
        throw new UnsupportedOperationException(y.֬ڱܱײٮ(-1159669231));
    }
}
