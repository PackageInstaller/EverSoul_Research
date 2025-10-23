package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;

/* loaded from: classes.dex */
public final class GlobalMetrics {
    private static final GlobalMetrics DEFAULT_INSTANCE = new Builder().build();
    private final StorageMetrics storage_metrics_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GlobalMetrics(StorageMetrics storageMetrics) {
        this.storage_metrics_ = storageMetrics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Ignore
    public StorageMetrics getStorageMetrics() {
        StorageMetrics storageMetrics = this.storage_metrics_;
        return storageMetrics == null ? StorageMetrics.getDefaultInstance() : storageMetrics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Encodable.Field(name = "storageMetrics")
    public StorageMetrics getStorageMetricsInternal() {
        return this.storage_metrics_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlobalMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private StorageMetrics storage_metrics_ = null;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public GlobalMetrics build() {
            return new GlobalMetrics(this.storage_metrics_);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setStorageMetrics(StorageMetrics storageMetrics) {
            this.storage_metrics_ = storageMetrics;
            return this;
        }
    }
}
