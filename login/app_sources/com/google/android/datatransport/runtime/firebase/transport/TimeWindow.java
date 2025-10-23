package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes.dex */
public final class TimeWindow {
    private static final TimeWindow DEFAULT_INSTANCE = new Builder().build();
    private final long end_ms_;
    private final long start_ms_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TimeWindow(long j, long j2) {
        this.start_ms_ = j;
        this.end_ms_ = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getStartMs() {
        return this.start_ms_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getEndMs() {
        return this.end_ms_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TimeWindow getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private long start_ms_ = 0;
        private long end_ms_ = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public TimeWindow build() {
            return new TimeWindow(this.start_ms_, this.end_ms_);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setStartMs(long j) {
            this.start_ms_ = j;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setEndMs(long j) {
            this.end_ms_ = j;
            return this;
        }
    }
}
