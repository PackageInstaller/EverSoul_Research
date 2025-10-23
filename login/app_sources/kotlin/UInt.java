package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UInt.kt */
@Metadata(m838d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010EJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u000fJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u000bJ\u001b\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u001dJ\u001b\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0016J\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010\u000bJ\u001e\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u000fJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u000bJ\u001b\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bU\u0010\u001dJ\u001b\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\b¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\b¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u0016\u0010q\u001a\u00020\rH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010ZJ\u0016\u0010s\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010\u0005J\u0016\u0010u\u001a\u00020\u0011H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010hJ\u0016\u0010w\u001a\u00020\u0014H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bx\u0010lJ\u001b\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006|"}, m839d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m1529boximpl(int i) {
        return new UInt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1535constructorimpl(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1541equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m1587unboximpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1542equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1547hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1575toByteimpl(int i) {
        return (byte) i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m1578toIntimpl(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m1579toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m1580toShortimpl(int i) {
        return (short) i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1583toUIntpVg5ArA(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return m1541equalsimpl(this.data, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return m1547hashCodeimpl(this.data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1587unboximpl() {
        return this.data;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m1587unboximpl(), uInt.m1587unboximpl());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m1530compareTo7apg3OU(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m1535constructorimpl(b & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m1534compareToxj2QHRw(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m1535constructorimpl(s & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m1532compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m1587unboximpl(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m1533compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1531compareToVKZWuLQ(int i, long j) {
        int compare;
        compare = Long.compare(ULong.m1614constructorimpl(i & 4294967295L) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1559plus7apg3OU(int i, byte b) {
        return m1535constructorimpl(i + m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1562plusxj2QHRw(int i, short s) {
        return m1535constructorimpl(i + m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1561plusWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i + i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1560plusVKZWuLQ(int i, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(i & 4294967295L) + j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1550minus7apg3OU(int i, byte b) {
        return m1535constructorimpl(i - m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1553minusxj2QHRw(int i, short s) {
        return m1535constructorimpl(i - m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1552minusWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i - i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1551minusVKZWuLQ(int i, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(i & 4294967295L) - j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1571times7apg3OU(int i, byte b) {
        return m1535constructorimpl(i * m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1574timesxj2QHRw(int i, short s) {
        return m1535constructorimpl(i * m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1573timesWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i * i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1572timesVKZWuLQ(int i, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(i & 4294967295L) * j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1537div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1540divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1539divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1791uintDivideJ1ME1BU(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1538divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(i & 4294967295L), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1565rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m847m(i, m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1568remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m847m(i, m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1567remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m1792uintRemainderJ1ME1BU(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1566remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(i & 4294967295L), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1543floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1546floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1545floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1544floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(i & 4294967295L), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1554mod7apg3OU(int i, byte b) {
        return UByte.m1458constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m847m(i, m1535constructorimpl(b & 255)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1557modxj2QHRw(int i, short s) {
        return UShort.m1721constructorimpl((short) UByte$$ExternalSyntheticBackport0.m847m(i, m1535constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1556modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m847m(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1555modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(i & 4294967295L), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m1548incpVg5ArA(int i) {
        return m1535constructorimpl(i + 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m1536decpVg5ArA(int i) {
        return m1535constructorimpl(i - 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m1563rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m1564rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m2720untilJ1ME1BU(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m1569shlpVg5ArA(int i, int i2) {
        return m1535constructorimpl(i << i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m1570shrpVg5ArA(int i, int i2) {
        return m1535constructorimpl(i >>> i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m1528andWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i & i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m1558orWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i | i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m1586xorWZ4Q5Ns(int i, int i2) {
        return m1535constructorimpl(i ^ i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m1549invpVg5ArA(int i) {
        return m1535constructorimpl(~i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1582toUBytew2LRezQ(int i) {
        return UByte.m1458constructorimpl((byte) i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1585toUShortMh2AYeg(int i) {
        return UShort.m1721constructorimpl((short) i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1584toULongsVKNKU(int i) {
        return ULong.m1614constructorimpl(i & 4294967295L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1577toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1576toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1581toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return m1581toStringimpl(this.data);
    }
}
