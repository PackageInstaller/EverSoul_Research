package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() { // from class: com.google.firebase.perf.util.Timer.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public Timer[] newArray(int i) {
            return new Timer[i];
        }
    };
    private long elapsedRealtimeMicros;
    private long wallClockMicros;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Timer ofElapsedRealtime(long j) {
        long micros = TimeUnit.MILLISECONDS.toMicros(j);
        return new Timer(wallClockMicros() + (micros - elapsedRealtimeMicros()), micros);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long wallClockMicros() {
        return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long elapsedRealtimeMicros() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Timer() {
        this(wallClockMicros(), elapsedRealtimeMicros());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Timer(long j, long j2) {
        this.wallClockMicros = j;
        this.elapsedRealtimeMicros = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Timer(long j) {
        this(j, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Timer(Parcel parcel) {
        this(parcel.readLong(), parcel.readLong());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        this.wallClockMicros = wallClockMicros();
        this.elapsedRealtimeMicros = elapsedRealtimeMicros();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMicros() {
        return this.wallClockMicros;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getDurationMicros() {
        return getDurationMicros(new Timer());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getDurationMicros(Timer timer) {
        return timer.elapsedRealtimeMicros - this.elapsedRealtimeMicros;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getCurrentTimestampMicros() {
        return this.wallClockMicros + getDurationMicros();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.wallClockMicros);
        parcel.writeLong(this.elapsedRealtimeMicros);
    }
}
