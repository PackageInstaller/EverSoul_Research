package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UnsignedLong(long j) {
        this.value = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedLong valueOf(long j) {
        Preconditions.checkArgument(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedLong valueOf(String str, int i) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
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
        long j = this.value;
        if (j >= 0) {
            return j;
        }
        return ((j & 1) | (j >>> 1)) * 2.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public double doubleValue() {
        long j = this.value;
        if (j >= 0) {
            return j;
        }
        return ((j & 1) | (j >>> 1)) * 2.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Longs.hashCode(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return UnsignedLongs.toString(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(int i) {
        return UnsignedLongs.toString(this.value, i);
    }
}
