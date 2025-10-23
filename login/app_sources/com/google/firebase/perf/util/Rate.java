package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Rate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long numTimeUnits;
    private long numTokensPerTotalTimeUnit;
    private TimeUnit timeUnit;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Rate(long j, long j2, TimeUnit timeUnit) {
        this.numTokensPerTotalTimeUnit = j;
        this.numTimeUnits = j2;
        this.timeUnit = timeUnit;
    }

    /* renamed from: com.google.firebase.perf.util.Rate$1 */
    static /* synthetic */ class C18251 {
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
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getTokensPerSeconds() {
        int i = C18251.$SwitchMap$java$util$concurrent$TimeUnit[this.timeUnit.ordinal()];
        if (i == 1) {
            return (this.numTokensPerTotalTimeUnit / this.numTimeUnits) * TimeUnit.SECONDS.toNanos(1L);
        }
        if (i == 2) {
            return (this.numTokensPerTotalTimeUnit / this.numTimeUnits) * TimeUnit.SECONDS.toMicros(1L);
        }
        if (i == 3) {
            return (this.numTokensPerTotalTimeUnit / this.numTimeUnits) * TimeUnit.SECONDS.toMillis(1L);
        }
        return this.numTokensPerTotalTimeUnit / this.timeUnit.toSeconds(this.numTimeUnits);
    }
}
