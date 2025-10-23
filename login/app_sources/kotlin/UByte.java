package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UByte.kt */
@Metadata(m838d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u000fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u001b\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0012J\u001b\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0016\u0010n\u001a\u00020\u0010H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0013H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0016\u0010r\u001a\u00020\u0016H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, m839d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m1452boximpl(byte b) {
        return new UByte(b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m1458constructorimpl(byte b) {
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1464equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m1508unboximpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1465equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1470hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1496toByteimpl(byte b) {
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1497toDoubleimpl(byte b) {
        return b & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1498toFloatimpl(byte b) {
        return b & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m1499toIntimpl(byte b) {
        return b & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m1500toLongimpl(byte b) {
        return b & 255;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m1501toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1503toUBytew2LRezQ(byte b) {
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return m1464equalsimpl(this.data, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return m1470hashCodeimpl(this.data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m1508unboximpl() {
        return this.data;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(m1508unboximpl() & 255, uByte.m1508unboximpl() & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m1453compareTo7apg3OU(byte b) {
        return Intrinsics.compare(m1508unboximpl() & 255, b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m1454compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m1457compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m1456compareToWZ4Q5Ns(byte b, int i) {
        int compare;
        compare = Integer.compare(UInt.m1535constructorimpl(b & 255) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1455compareToVKZWuLQ(byte b, long j) {
        int compare;
        compare = Long.compare(ULong.m1614constructorimpl(b & 255) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1482plus7apg3OU(byte b, byte b2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) + UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1485plusxj2QHRw(byte b, short s) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) + UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1484plusWZ4Q5Ns(byte b, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1483plusVKZWuLQ(byte b, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(b & 255) + j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1473minus7apg3OU(byte b, byte b2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) - UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1476minusxj2QHRw(byte b, short s) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) - UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1475minusWZ4Q5Ns(byte b, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) - i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1474minusVKZWuLQ(byte b, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(b & 255) - j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1492times7apg3OU(byte b, byte b2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) * UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1495timesxj2QHRw(byte b, short s) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) * UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1494timesWZ4Q5Ns(byte b, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(b & 255) * i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1493timesVKZWuLQ(byte b, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(b & 255) * j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1460div7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1463divxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1462divWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1461divVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(b & 255), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1488rem7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1491remxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1490remWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1489remVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(b & 255), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1466floorDiv7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1469floorDivxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(s & UShort.MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1468floorDivWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(b & 255), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1467floorDivVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(b & 255), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1477mod7apg3OU(byte b, byte b2) {
        return m1458constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1480modxj2QHRw(byte b, short s) {
        return UShort.m1721constructorimpl((short) UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1479modWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(b & 255), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1478modVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(b & 255), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m1471incw2LRezQ(byte b) {
        return m1458constructorimpl((byte) (b + 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m1459decw2LRezQ(byte b) {
        return m1458constructorimpl((byte) (b - 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m1486rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m1487rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m2720untilJ1ME1BU(UInt.m1535constructorimpl(b & 255), UInt.m1535constructorimpl(b2 & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m1451and7apg3OU(byte b, byte b2) {
        return m1458constructorimpl((byte) (b & b2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m1481or7apg3OU(byte b, byte b2) {
        return m1458constructorimpl((byte) (b | b2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m1507xor7apg3OU(byte b, byte b2) {
        return m1458constructorimpl((byte) (b ^ b2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m1472invw2LRezQ(byte b) {
        return m1458constructorimpl((byte) (~b));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1506toUShortMh2AYeg(byte b) {
        return UShort.m1721constructorimpl((short) (b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1504toUIntpVg5ArA(byte b) {
        return UInt.m1535constructorimpl(b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1505toULongsVKNKU(byte b) {
        return ULong.m1614constructorimpl(b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1502toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return m1502toStringimpl(this.data);
    }
}
