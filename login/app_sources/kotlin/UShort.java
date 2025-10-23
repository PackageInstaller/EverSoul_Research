package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import okhttp3.internal.p034ws.WebSocketProtocol;

/* compiled from: UShort.kt */
@Metadata(m838d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013J\u001b\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J\u001b\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J\u001b\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010\u001fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0010J\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0013J\u001b\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u0010J\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0013J\u001b\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u0010J\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0013J\u001b\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0016\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0016\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, m839d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m1715boximpl(short s) {
        return new UShort(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m1721constructorimpl(short s) {
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1727equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m1771unboximpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1728equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1733hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m1759toByteimpl(short s) {
        return (byte) s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m1760toDoubleimpl(short s) {
        return s & MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m1761toFloatimpl(short s) {
        return s & MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m1762toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m1763toLongimpl(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m1764toShortimpl(short s) {
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m1769toUShortMh2AYeg(short s) {
        return s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return m1727equalsimpl(this.data, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return m1733hashCodeimpl(this.data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m1771unboximpl() {
        return this.data;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m1771unboximpl() & MAX_VALUE, uShort.m1771unboximpl() & MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m1716compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m1719compareToxj2QHRw(short s) {
        return Intrinsics.compare(m1771unboximpl() & MAX_VALUE, s & MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m1720compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m1718compareToWZ4Q5Ns(short s, int i) {
        int compare;
        compare = Integer.compare(UInt.m1535constructorimpl(s & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m1717compareToVKZWuLQ(short s, long j) {
        int compare;
        compare = Long.compare(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m1745plus7apg3OU(short s, byte b) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) + UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m1748plusxj2QHRw(short s, short s2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) + UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1747plusWZ4Q5Ns(short s, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) + i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m1746plusVKZWuLQ(short s, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m1736minus7apg3OU(short s, byte b) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) - UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m1739minusxj2QHRw(short s, short s2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) - UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m1738minusWZ4Q5Ns(short s, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) - i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m1737minusVKZWuLQ(short s, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m1755times7apg3OU(short s, byte b) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) * UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m1758timesxj2QHRw(short s, short s2) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) * UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m1757timesWZ4Q5Ns(short s, int i) {
        return UInt.m1535constructorimpl(UInt.m1535constructorimpl(s & MAX_VALUE) * i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m1756timesVKZWuLQ(short s, long j) {
        return ULong.m1614constructorimpl(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m1723div7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m1726divxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m1725divWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m1724divVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m1751rem7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m1754remxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m1753remWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m1752remVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m1729floorDiv7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(b & 255));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m1732floorDivxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m1731floorDivWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m1535constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m1730floorDivVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m1740mod7apg3OU(short s, byte b) {
        return UByte.m1458constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(b & 255)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m1743modxj2QHRw(short s, short s2) {
        return m1721constructorimpl((short) UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m1742modWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m847m(UInt.m1535constructorimpl(s & MAX_VALUE), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m1741modVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m849m(ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m1734incMh2AYeg(short s) {
        return m1721constructorimpl((short) (s + 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m1722decMh2AYeg(short s) {
        return m1721constructorimpl((short) (s - 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m1749rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m1750rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m2720untilJ1ME1BU(UInt.m1535constructorimpl(s & MAX_VALUE), UInt.m1535constructorimpl(s2 & MAX_VALUE));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m1714andxj2QHRw(short s, short s2) {
        return m1721constructorimpl((short) (s & s2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m1744orxj2QHRw(short s, short s2) {
        return m1721constructorimpl((short) (s | s2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m1770xorxj2QHRw(short s, short s2) {
        return m1721constructorimpl((short) (s ^ s2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m1735invMh2AYeg(short s) {
        return m1721constructorimpl((short) (~s));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m1766toUBytew2LRezQ(short s) {
        return UByte.m1458constructorimpl((byte) s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m1767toUIntpVg5ArA(short s) {
        return UInt.m1535constructorimpl(s & MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m1768toULongsVKNKU(short s) {
        return ULong.m1614constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1765toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return m1765toStringimpl(this.data);
    }
}
