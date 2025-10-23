package kotlin.time;

import kotlin.Metadata;

/* compiled from: TimeSource.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000f"}, m839d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface TimeMark {
    /* renamed from: elapsedNow-UwyO8pc */
    long mo2755elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    /* renamed from: minus-LRDsOJo */
    TimeMark mo2756minusLRDsOJo(long duration);

    /* renamed from: plus-LRDsOJo */
    TimeMark mo2758plusLRDsOJo(long duration);

    /* compiled from: TimeSource.kt */
    @Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m2903plusLRDsOJo(TimeMark timeMark, long j) {
            return new AdjustedTimeMark(timeMark, j, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m2902minusLRDsOJo(TimeMark timeMark, long j) {
            return timeMark.mo2758plusLRDsOJo(Duration.m2818unaryMinusUwyO8pc(j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static boolean hasPassedNow(TimeMark timeMark) {
            return !Duration.m2799isNegativeimpl(timeMark.mo2755elapsedNowUwyO8pc());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static boolean hasNotPassedNow(TimeMark timeMark) {
            return Duration.m2799isNegativeimpl(timeMark.mo2755elapsedNowUwyO8pc());
        }
    }
}
