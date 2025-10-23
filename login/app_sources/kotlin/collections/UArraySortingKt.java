package kotlin.collections;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UArraySorting.kt */
@Metadata(m838d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m839d2 = {"partition", "", "array", "Lkotlin/UByteArray;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UArraySortingKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m1896partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m1516getw2LRezQ = UByteArray.m1516getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m1516getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m1516getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m1516getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m1516getw2LRezQ2 = UByteArray.m1516getw2LRezQ(bArr, i);
                UByteArray.m1521setVurrAj0(bArr, i, UByteArray.m1516getw2LRezQ(bArr, i2));
                UByteArray.m1521setVurrAj0(bArr, i2, m1516getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m1900quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m1896partition4UcCI2c = m1896partition4UcCI2c(bArr, i, i2);
        int i3 = m1896partition4UcCI2c - 1;
        if (i < i3) {
            m1900quickSort4UcCI2c(bArr, i, i3);
        }
        if (m1896partition4UcCI2c < i2) {
            m1900quickSort4UcCI2c(bArr, m1896partition4UcCI2c, i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m1897partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m1779getMh2AYeg = UShortArray.m1779getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m1779getMh2AYeg2 = UShortArray.m1779getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m1779getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m1779getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m1779getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m1779getMh2AYeg3 = UShortArray.m1779getMh2AYeg(sArr, i);
                UShortArray.m1784set01HTLdE(sArr, i, UShortArray.m1779getMh2AYeg(sArr, i2));
                UShortArray.m1784set01HTLdE(sArr, i2, m1779getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m1901quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m1897partitionAa5vz7o = m1897partitionAa5vz7o(sArr, i, i2);
        int i3 = m1897partitionAa5vz7o - 1;
        if (i < i3) {
            m1901quickSortAa5vz7o(sArr, i, i3);
        }
        if (m1897partitionAa5vz7o < i2) {
            m1901quickSortAa5vz7o(sArr, m1897partitionAa5vz7o, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int m1898partitionoBK06Vg(int[] r3, int r4, int r5) {
        /*
            int r0 = r4 + r5
            int r0 = r0 / 2
            int r0 = kotlin.UIntArray.m1595getpVg5ArA(r3, r0)
        L8:
            if (r4 > r5) goto L39
        La:
            int r1 = kotlin.UIntArray.m1595getpVg5ArA(r3, r4)
            int r1 = kotlin.UByte$$ExternalSyntheticBackport0.m$2(r1, r0)
            if (r1 >= 0) goto L17
            int r4 = r4 + 1
            goto La
        L17:
            int r1 = kotlin.UIntArray.m1595getpVg5ArA(r3, r5)
            int r1 = kotlin.UByte$$ExternalSyntheticBackport0.m$2(r1, r0)
            if (r1 <= 0) goto L24
            int r5 = r5 + (-1)
            goto L17
        L24:
            if (r4 > r5) goto L8
            int r1 = kotlin.UIntArray.m1595getpVg5ArA(r3, r4)
            int r2 = kotlin.UIntArray.m1595getpVg5ArA(r3, r5)
            kotlin.UIntArray.m1600setVXSXFK8(r3, r4, r2)
            kotlin.UIntArray.m1600setVXSXFK8(r3, r5, r1)
            int r4 = r4 + 1
            int r5 = r5 + (-1)
            goto L8
        L39:
            return r4
            fill-array 0x003a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.UArraySortingKt.m1898partitionoBK06Vg(int[], int, int):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m1902quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m1898partitionoBK06Vg = m1898partitionoBK06Vg(iArr, i, i2);
        int i3 = m1898partitionoBK06Vg - 1;
        if (i < i3) {
            m1902quickSortoBK06Vg(iArr, i, i3);
        }
        if (m1898partitionoBK06Vg < i2) {
            m1902quickSortoBK06Vg(iArr, m1898partitionoBK06Vg, i2);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0012 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: partition--nroSd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int m1895partitionnroSd4(long[] r6, int r7, int r8) {
        /*
            int r0 = r7 + r8
            int r0 = r0 / 2
            long r0 = kotlin.ULongArray.m1674getsVKNKU(r6, r0)
        L8:
            if (r7 > r8) goto L39
        La:
            long r2 = kotlin.ULongArray.m1674getsVKNKU(r6, r7)
            int r2 = kotlin.UByte$$ExternalSyntheticBackport0.m848m(r2, r0)
            if (r2 >= 0) goto L17
            int r7 = r7 + 1
            goto La
        L17:
            long r2 = kotlin.ULongArray.m1674getsVKNKU(r6, r8)
            int r2 = kotlin.UByte$$ExternalSyntheticBackport0.m848m(r2, r0)
            if (r2 <= 0) goto L24
            int r8 = r8 + (-1)
            goto L17
        L24:
            if (r7 > r8) goto L8
            long r2 = kotlin.ULongArray.m1674getsVKNKU(r6, r7)
            long r4 = kotlin.ULongArray.m1674getsVKNKU(r6, r8)
            kotlin.ULongArray.m1679setk8EXiF4(r6, r7, r4)
            kotlin.ULongArray.m1679setk8EXiF4(r6, r8, r2)
            int r7 = r7 + 1
            int r8 = r8 + (-1)
            goto L8
        L39:
            return r7
            fill-array 0x003a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.UArraySortingKt.m1895partitionnroSd4(long[], int, int):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m1899quickSortnroSd4(long[] jArr, int i, int i2) {
        int m1895partitionnroSd4 = m1895partitionnroSd4(jArr, i, i2);
        int i3 = m1895partitionnroSd4 - 1;
        if (i < i3) {
            m1899quickSortnroSd4(jArr, i, i3);
        }
        if (m1895partitionnroSd4 < i2) {
            m1899quickSortnroSd4(jArr, m1895partitionnroSd4, i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m1904sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1900quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m1905sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1901quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m1906sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1902quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m1903sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m1899quickSortnroSd4(array, i, i2 - 1);
    }
}
