package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableShort extends Number implements Comparable<MutableShort>, Mutable<Number> {
    private static final long serialVersionUID = -2135791679;
    private short value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableShort() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableShort(short s) {
        this.value = s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableShort(String str) {
        this.value = Short.parseShort(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue, reason: avoid collision after fix types in other method */
    public Number getValue2() {
        return Short.valueOf(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(short s) {
        this.value = s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.shortValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void increment() {
        this.value = (short) (this.value + 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getAndIncrement() {
        short s = this.value;
        this.value = (short) (s + 1);
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short incrementAndGet() {
        short s = (short) (this.value + 1);
        this.value = s;
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getAndDecrement() {
        short s = this.value;
        this.value = (short) (s - 1);
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short decrementAndGet() {
        short s = (short) (this.value - 1);
        this.value = s;
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(short s) {
        this.value = (short) (this.value + s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(short s) {
        this.value = (short) (this.value - s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short addAndGet(short s) {
        short s2 = (short) (this.value + s);
        this.value = s2;
        return s2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short addAndGet(Number number) {
        short shortValue = (short) (this.value + number.shortValue());
        this.value = shortValue;
        return shortValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getAndAdd(short s) {
        short s2 = this.value;
        this.value = (short) (s + s2);
        return s2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short getAndAdd(Number number) {
        short s = this.value;
        this.value = (short) (number.shortValue() + s);
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
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
    public Short toShort() {
        return Short.valueOf(shortValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MutableShort) && this.value == ((MutableShort) obj).shortValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(MutableShort mutableShort) {
        return NumberUtils.compare(this.value, mutableShort.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.valueOf((int) this.value);
    }
}
