package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ClientMetrics {
    private static final ClientMetrics DEFAULT_INSTANCE = new Builder().build();
    private final String app_namespace_;
    private final GlobalMetrics global_metrics_;
    private final List<LogSourceMetrics> log_source_metrics_;
    private final TimeWindow window_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.window_ = timeWindow;
        this.log_source_metrics_ = list;
        this.global_metrics_ = globalMetrics;
        this.app_namespace_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Ignore
    public TimeWindow getWindow() {
        TimeWindow timeWindow = this.window_;
        return timeWindow == null ? TimeWindow.getDefaultInstance() : timeWindow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "window")
    public TimeWindow getWindowInternal() {
        return this.window_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "logSourceMetrics")
    public List<LogSourceMetrics> getLogSourceMetricsList() {
        return this.log_source_metrics_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Ignore
    public GlobalMetrics getGlobalMetrics() {
        GlobalMetrics globalMetrics = this.global_metrics_;
        return globalMetrics == null ? GlobalMetrics.getDefaultInstance() : globalMetrics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "globalMetrics")
    public GlobalMetrics getGlobalMetricsInternal() {
        return this.global_metrics_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAppNamespace() {
        return this.app_namespace_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ClientMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private TimeWindow window_ = null;
        private List<LogSourceMetrics> log_source_metrics_ = new ArrayList();
        private GlobalMetrics global_metrics_ = null;
        private String app_namespace_ = "";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ClientMetrics build() {
            return new ClientMetrics(this.window_, Collections.unmodifiableList(this.log_source_metrics_), this.global_metrics_, this.app_namespace_);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setWindow(TimeWindow timeWindow) {
            this.window_ = timeWindow;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addLogSourceMetrics(LogSourceMetrics logSourceMetrics) {
            this.log_source_metrics_.add(logSourceMetrics);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLogSourceMetricsList(List<LogSourceMetrics> list) {
            this.log_source_metrics_ = list;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setGlobalMetrics(GlobalMetrics globalMetrics) {
            this.global_metrics_ = globalMetrics;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAppNamespace(String str) {
            this.app_namespace_ = str;
            return this;
        }
    }
}
