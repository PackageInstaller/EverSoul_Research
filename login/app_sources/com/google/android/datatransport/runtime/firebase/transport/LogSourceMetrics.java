package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LogSourceMetrics {
    private static final LogSourceMetrics DEFAULT_INSTANCE = new Builder().build();
    private final List<LogEventDropped> log_event_dropped_;
    private final String log_source_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.log_source_ = str;
        this.log_event_dropped_ = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLogSource() {
        return this.log_source_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "logEventDropped")
    public List<LogEventDropped> getLogEventDroppedList() {
        return this.log_event_dropped_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LogSourceMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private String log_source_ = "";
        private List<LogEventDropped> log_event_dropped_ = new ArrayList();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LogSourceMetrics build() {
            return new LogSourceMetrics(this.log_source_, Collections.unmodifiableList(this.log_event_dropped_));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLogSource(String str) {
            this.log_source_ = str;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLogEventDropped(LogEventDropped logEventDropped) {
            this.log_event_dropped_.add(logEventDropped);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLogEventDroppedList(List<LogEventDropped> list) {
            this.log_event_dropped_ = list;
            return this;
        }
    }
}
