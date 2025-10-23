package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: UnsignedUtils.kt */
@Metadata(m838d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0001\u001a\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\u0013H\u0001\u001a\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0013H\u0001\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\tH\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m839d2 = {"doubleToUInt", "Lkotlin/UInt;", "v", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "ulongCompare", "", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToString", "", "base", "kotlin-stdlib"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UnsignedKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final double uintToDouble(int i) {
        return (Integer.MAX_VALUE & i) + (((i >>> 31) << 30) * 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int ulongCompare(long j, long j2) {
        return Intrinsics.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m1791uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m1535constructorimpl((int) ((i & 4294967295L) / (i2 & 4294967295L)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m1792uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m1535constructorimpl((int) ((i & 4294967295L) % (i2 & 4294967295L)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m1793ulongDivideeb3DHEI(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 < 0 ? ULong.m1614constructorimpl(0L) : ULong.m1614constructorimpl(1L);
        }
        if (j >= 0) {
            return ULong.m1614constructorimpl(j / j2);
        }
        long j3 = ((j >>> 1) / j2) << 1;
        compare = Long.compare(ULong.m1614constructorimpl(j - (j3 * j2)) ^ Long.MIN_VALUE, ULong.m1614constructorimpl(j2) ^ Long.MIN_VALUE);
        return ULong.m1614constructorimpl(j3 + (compare < 0 ? 0 : 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m1794ulongRemaindereb3DHEI(long j, long j2) {
        int compare;
        int compare2;
        if (j2 < 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
            return compare2 < 0 ? j : ULong.m1614constructorimpl(j - j2);
        }
        if (j >= 0) {
            return ULong.m1614constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        compare = Long.compare(ULong.m1614constructorimpl(j3) ^ Long.MIN_VALUE, ULong.m1614constructorimpl(j2) ^ Long.MIN_VALUE);
        if (compare < 0) {
            j2 = 0;
        }
        return ULong.m1614constructorimpl(j3 - j2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        if (d <= 2.147483647E9d) {
            return UInt.m1535constructorimpl((int) d);
        }
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl((int) (d - Integer.MAX_VALUE)) + UInt.m1535constructorimpl(Integer.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final long doubleToULong(double d) {
        if (Double.isNaN(d) || d <= ulongToDouble(0L)) {
            return 0L;
        }
        if (d >= ulongToDouble(-1L)) {
            return -1L;
        }
        if (d < 9.223372036854776E18d) {
            return ULong.m1614constructorimpl((long) d);
        }
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, CharsKt.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(l, "toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l2, "toString(this, checkRadix(radix))");
        StringBuilder append = sb.append(l2);
        String l3 = Long.toString(j4, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
        return append.append(l3).toString();
    }
}
