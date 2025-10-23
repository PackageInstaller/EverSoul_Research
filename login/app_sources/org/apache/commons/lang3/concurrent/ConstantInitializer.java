package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.util.Objects;

/* loaded from: classes2.dex */
public class ConstantInitializer<T> implements ConcurrentInitializer<T> {
    private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
    private final T object;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConstantInitializer(T t) {
        this.object = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T getObject() {
        return this.object;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        return getObject();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        if (getObject() != null) {
            return getObject().hashCode();
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConstantInitializer) {
            return Objects.equals(getObject(), ((ConstantInitializer) obj).getObject());
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.format(y.ݮڮֲڭܩ(-628827092), Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject()));
    }
}
