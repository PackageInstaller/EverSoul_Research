package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableInt() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableInt(int i) {
        this.value = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableInt(String str) {
        this.value = Integer.parseInt(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Integer.valueOf(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(int i) {
        this.value = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void increment() {
        this.value++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAndIncrement() {
        int i = this.value;
        this.value = i + 1;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int incrementAndGet() {
        int i = this.value + 1;
        this.value = i;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void decrement() {
        this.value--;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAndDecrement() {
        int i = this.value;
        this.value = i - 1;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int decrementAndGet() {
        int i = this.value - 1;
        this.value = i;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(int i) {
        this.value += i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(Number number) {
        this.value += number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(int i) {
        this.value -= i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int addAndGet(Number number) {
        int intValue = this.value + number.intValue();
        this.value = intValue;
        return intValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAndAdd(int i) {
        int i2 = this.value;
        this.value = i + i2;
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAndAdd(Number number) {
        int i = this.value;
        this.value = number.intValue() + i;
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MutableInt) && this.value == ((MutableInt) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(MutableInt mutableInt) {
        return NumberUtils.compare(this.value, mutableInt.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.valueOf(this.value);
    }
}
