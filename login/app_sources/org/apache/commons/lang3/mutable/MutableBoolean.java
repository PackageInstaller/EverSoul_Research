package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

/* loaded from: classes2.dex */
public class MutableBoolean implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean> {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableBoolean() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableBoolean(boolean z) {
        this.value = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableBoolean(Boolean bool) {
        this.value = bool.booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Boolean getValue2() {
        return Boolean.valueOf(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(boolean z) {
        this.value = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFalse() {
        this.value = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTrue() {
        this.value = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Boolean bool) {
        this.value = bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTrue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFalse() {
        return !this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean booleanValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean toBoolean() {
        return Boolean.valueOf(booleanValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MutableBoolean) && this.value == ((MutableBoolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.value ? Boolean.TRUE : Boolean.FALSE).hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(MutableBoolean mutableBoolean) {
        return BooleanUtils.compare(this.value, mutableBoolean.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.valueOf(this.value);
    }
}
