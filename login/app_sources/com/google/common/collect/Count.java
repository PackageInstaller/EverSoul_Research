package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Count implements Serializable {
    private int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Count(int i) {
        this.value = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int get() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(int i) {
        this.value += i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void set(int i) {
        this.value = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAndSet(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof Count) && ((Count) obj).value == this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return Integer.toString(this.value);
    }
}
