package org.apache.commons.lang3.builder;

import com.liapp.y;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.reflect.FieldUtils;

/* loaded from: classes2.dex */
public class ReflectionDiffBuilder implements Builder<DiffResult> {
    private final DiffBuilder diffBuilder;
    private final Object left;
    private final Object right;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> ReflectionDiffBuilder(T t, T t2, ToStringStyle toStringStyle) {
        this.left = t;
        this.right = t2;
        this.diffBuilder = new DiffBuilder(t, t2, toStringStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.builder.Builder
    public DiffResult build() {
        if (this.left.equals(this.right)) {
            return this.diffBuilder.build();
        }
        appendFields(this.left.getClass());
        return this.diffBuilder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void appendFields(Class<?> cls) {
        for (Field field : FieldUtils.getAllFields(cls)) {
            if (accept(field)) {
                try {
                    this.diffBuilder.append(field.getName(), FieldUtils.readField(field, this.left, true), FieldUtils.readField(field, this.right, true));
                } catch (IllegalAccessException e) {
                    throw new InternalError(y.ݬֲ֮ܲت(1512685471) + e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean accept(Field field) {
        if (field.getName().indexOf(36) == -1 && !Modifier.isTransient(field.getModifiers())) {
            return !Modifier.isStatic(field.getModifiers());
        }
        return false;
    }
}
