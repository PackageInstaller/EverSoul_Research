package org.apache.commons.lang3.builder;

/* loaded from: classes2.dex */
final class IDKey {

    /* renamed from: id */
    private final int f1525id;
    private final Object value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IDKey(Object obj) {
        this.f1525id = System.identityHashCode(obj);
        this.value = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.f1525id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f1525id == iDKey.f1525id && this.value == iDKey.value;
    }
}
