package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;

/* compiled from: TimeSource.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, m839d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: TimeSource.kt */
    @Metadata(m838d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m839d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    TimeMark markNow();

    /* compiled from: TimeSource.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n"}, m839d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Monotonic() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m2905boximpl(m2904markNowz9LOYto());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m2905boximpl(m2904markNowz9LOYto());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m2904markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m2899markNowz9LOYto();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        /* compiled from: TimeSource.kt */
        @Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010!J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010!J\u0010\u0010%\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006)"}, m839d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "compareTo", "", "other", "compareTo-6eNON_k", "(JJ)I", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(JJ)J", "minus-6eNON_k", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m2905boximpl(long j) {
                return new ValueTimeMark(j);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m2908constructorimpl(long j) {
                return j;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m2910equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).m2922unboximpl();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m2911equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m2914hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: toString-impl, reason: not valid java name */
            public static String m2919toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object obj) {
                return m2910equalsimpl(this.reading, obj);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m2914hashCodeimpl(this.reading);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String toString() {
                return m2919toStringimpl(this.reading);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ long m2922unboximpl() {
                return this.reading;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Comparable
            public int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo2756minusLRDsOJo(long j) {
                return m2905boximpl(m2920minusLRDsOJo(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo2756minusLRDsOJo(long j) {
                return m2905boximpl(m2920minusLRDsOJo(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo2758plusLRDsOJo(long j) {
                return m2905boximpl(m2921plusLRDsOJo(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo2758plusLRDsOJo(long j) {
                return m2905boximpl(m2921plusLRDsOJo(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: compareTo-impl, reason: not valid java name */
            public static int m2907compareToimpl(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m2905boximpl(j).compareTo(other);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m2909elapsedNowUwyO8pc(long j) {
                return MonotonicTimeSource.INSTANCE.m2898elapsedFrom6eNON_k(j);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo2755elapsedNowUwyO8pc() {
                return m2909elapsedNowUwyO8pc(this.reading);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m2918plusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m2896adjustReading6QKq23U(j, j2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m2921plusLRDsOJo(long j) {
                return m2918plusLRDsOJo(this.reading, j);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m2916minusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m2896adjustReading6QKq23U(j, Duration.m2818unaryMinusUwyO8pc(j2));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m2920minusLRDsOJo(long j) {
                return m2916minusLRDsOJo(this.reading, j);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m2913hasPassedNowimpl(long j) {
                return !Duration.m2799isNegativeimpl(m2909elapsedNowUwyO8pc(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m2913hasPassedNowimpl(this.reading);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m2912hasNotPassedNowimpl(long j) {
                return Duration.m2799isNegativeimpl(m2909elapsedNowUwyO8pc(j));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m2912hasNotPassedNowimpl(this.reading);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo2757minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m2917minusUwyO8pc(this.reading, other);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m2917minusUwyO8pc(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m2919toStringimpl(j)) + " and " + other);
                }
                return m2915minus6eNON_k(j, ((ValueTimeMark) other).m2922unboximpl());
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m2915minus6eNON_k(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m2897differenceBetweenfRLX17w(j, j2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m2906compareTo6eNON_k(long j, long j2) {
                return Duration.m2765compareToLRDsOJo(m2915minus6eNON_k(j, j2), Duration.INSTANCE.m2868getZEROUwyO8pc());
            }
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m839d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }
    }
}
