package org.apache.commons.lang3.mutable;

import com.liapp.y;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class MutableObject<T> implements Mutable<T>, Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableObject() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableObject(T t) {
        this.value = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public T getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(T t) {
        this.value = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() == obj.getClass()) {
            return this.value.equals(((MutableObject) obj).value);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        T t = this.value;
        return t == null ? y.ݮڮֲڭܩ(-628841308) : t.toString();
    }
}
