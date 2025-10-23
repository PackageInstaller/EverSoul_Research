package com.google.common.base;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Stopwatch {
    private long elapsedNanos;
    private boolean isRunning;
    private long startTick;
    private final Ticker ticker;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Stopwatch createUnstarted() {
        return new Stopwatch();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Stopwatch createUnstarted(Ticker ticker) {
        return new Stopwatch(ticker);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Stopwatch createStarted() {
        return new Stopwatch().start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Stopwatch createStarted(Ticker ticker) {
        return new Stopwatch(ticker).start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Stopwatch() {
        this.ticker = Ticker.systemTicker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Stopwatch(Ticker ticker) {
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker, "ticker");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRunning() {
        return this.isRunning;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Stopwatch start() {
        Preconditions.checkState(!this.isRunning, "This stopwatch is already running.");
        this.isRunning = true;
        this.startTick = this.ticker.read();
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Stopwatch stop() {
        long read = this.ticker.read();
        Preconditions.checkState(this.isRunning, "This stopwatch is already stopped.");
        this.isRunning = false;
        this.elapsedNanos += read - this.startTick;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Stopwatch reset() {
        this.elapsedNanos = 0L;
        this.isRunning = false;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long elapsedNanos() {
        return this.isRunning ? (this.ticker.read() - this.startTick) + this.elapsedNanos : this.elapsedNanos;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long elapsed(TimeUnit timeUnit) {
        return timeUnit.convert(elapsedNanos(), TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        long elapsedNanos = elapsedNanos();
        TimeUnit chooseUnit = chooseUnit(elapsedNanos);
        String formatCompact4Digits = Platform.formatCompact4Digits(elapsedNanos / TimeUnit.NANOSECONDS.convert(1L, chooseUnit));
        String abbreviate = abbreviate(chooseUnit);
        return new StringBuilder(String.valueOf(formatCompact4Digits).length() + 1 + String.valueOf(abbreviate).length()).append(formatCompact4Digits).append(StringUtils.SPACE).append(abbreviate).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static TimeUnit chooseUnit(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    /* renamed from: com.google.common.base.Stopwatch$1 */
    static /* synthetic */ class C12771 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[TimeUnit.values().length];
            $SwitchMap$java$util$concurrent$TimeUnit = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$util$concurrent$TimeUnit[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String abbreviate(TimeUnit timeUnit) {
        switch (C12771.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return Base2ndPWViewData.KEY_MIN;
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
