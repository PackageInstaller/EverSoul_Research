package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    private final int value;
    public static final UnsignedInteger ZERO = fromIntBits(0);
    public static final UnsignedInteger ONE = fromIntBits(1);
    public static final UnsignedInteger MAX_VALUE = fromIntBits(-1);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UnsignedInteger(int i) {
        this.value = i & (-1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedInteger fromIntBits(int i) {
        return new UnsignedInteger(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedInteger valueOf(long j) {
        Preconditions.checkArgument((4294967295L & j) == j, "value (%s) is outside the range for an unsigned integer value", j);
        return fromIntBits((int) j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedInteger valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 32, "value (%s) is outside the range for an unsigned integer value", bigInteger);
        return fromIntBits(bigInteger.intValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedInteger valueOf(String str) {
        return valueOf(str, 10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static UnsignedInteger valueOf(String str, int i) {
        return fromIntBits(UnsignedInts.parseUnsignedInt(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedInteger plus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value + ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedInteger minus(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value - ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedInteger times(UnsignedInteger unsignedInteger) {
        return fromIntBits(this.value * ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedInteger dividedBy(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.divide(this.value, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).value));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnsignedInteger mod(UnsignedInteger unsignedInteger) {
        return fromIntBits(UnsignedInts.remainder(this.value, ((UnsignedInteger) Preconditions.checkNotNull(unsignedInteger)).value));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.toLong(this.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(UnsignedInteger unsignedInteger) {
        Preconditions.checkNotNull(unsignedInteger);
        return UnsignedInts.compare(this.value, unsignedInteger.value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        return (obj instanceof UnsignedInteger) && this.value == ((UnsignedInteger) obj).value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return toString(10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(int i) {
        return UnsignedInts.toString(this.value, i);
    }
}
