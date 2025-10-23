package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableByte() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableByte(byte b) {
        this.value = b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableByte(String str) {
        this.value = Byte.parseByte(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Byte.valueOf(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(byte b) {
        this.value = b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte getAndIncrement() {
        byte b = this.value;
        this.value = (byte) (b + 1);
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte incrementAndGet() {
        byte b = (byte) (this.value + 1);
        this.value = b;
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte getAndDecrement() {
        byte b = this.value;
        this.value = (byte) (b - 1);
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte decrementAndGet() {
        byte b = (byte) (this.value - 1);
        this.value = b;
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(byte b) {
        this.value = (byte) (this.value + b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(Number number) {
        this.value = (byte) (this.value + number.byteValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(byte b) {
        this.value = (byte) (this.value - b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte addAndGet(byte b) {
        byte b2 = (byte) (this.value + b);
        this.value = b2;
        return b2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte addAndGet(Number number) {
        byte byteValue = (byte) (this.value + number.byteValue());
        this.value = byteValue;
        return byteValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte getAndAdd(byte b) {
        byte b2 = this.value;
        this.value = (byte) (b + b2);
        return b2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte getAndAdd(Number number) {
        byte b = this.value;
        this.value = (byte) (number.byteValue() + b);
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public byte byteValue() {
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
    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(MutableByte mutableByte) {
        return NumberUtils.compare(this.value, mutableByte.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.valueOf((int) this.value);
    }
}
