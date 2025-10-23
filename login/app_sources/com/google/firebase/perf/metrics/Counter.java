package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() { // from class: com.google.firebase.perf.metrics.Counter.1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Parcelable.Creator
        public Counter[] newArray(int i) {
            return new Counter[i];
        }
    };
    private final AtomicLong count;
    private final String name;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Counter(String str) {
        this.name = str;
        this.count = new AtomicLong(0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Counter(Parcel parcel) {
        this.name = parcel.readString();
        this.count = new AtomicLong(parcel.readLong());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void increment(long j) {
        this.count.addAndGet(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    long getCount() {
        return this.count.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCount(long j) {
        this.count.set(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeLong(this.count.get());
    }
}
