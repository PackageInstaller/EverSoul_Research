package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes2.dex */
public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableLong() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableLong(long j) {
        this.value = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableLong(String str) {
        this.value = Long.parseLong(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Long.valueOf(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setValue(long j) {
        this.value = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void increment() {
        this.value++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAndIncrement() {
        long j = this.value;
        this.value = 1 + j;
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long incrementAndGet() {
        long j = this.value + 1;
        this.value = j;
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void decrement() {
        this.value--;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAndDecrement() {
        long j = this.value;
        this.value = j - 1;
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long decrementAndGet() {
        long j = this.value - 1;
        this.value = j;
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(long j) {
        this.value += j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(Number number) {
        this.value += number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(long j) {
        this.value -= j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long addAndGet(long j) {
        long j2 = this.value + j;
        this.value = j2;
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long addAndGet(Number number) {
        long longValue = this.value + number.longValue();
        this.value = longValue;
        return longValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAndAdd(long j) {
        long j2 = this.value;
        this.value = j + j2;
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getAndAdd(Number number) {
        long j = this.value;
        this.value = number.longValue() + j;
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
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
    public Long toLong() {
        return Long.valueOf(longValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof MutableLong) && this.value == ((MutableLong) obj).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        long j = this.value;
        return (int) (j ^ (j >>> 32));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(MutableLong mutableLong) {
        return NumberUtils.compare(this.value, mutableLong.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.valueOf(this.value);
    }
}
