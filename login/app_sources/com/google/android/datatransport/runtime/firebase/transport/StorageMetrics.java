package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes.dex */
public final class StorageMetrics {
    private static final StorageMetrics DEFAULT_INSTANCE = new Builder().build();
    private final long current_cache_size_bytes_;
    private final long max_cache_size_bytes_;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StorageMetrics(long j, long j2) {
        this.current_cache_size_bytes_ = j;
        this.max_cache_size_bytes_ = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getCurrentCacheSizeBytes() {
        return this.current_cache_size_bytes_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMaxCacheSizeBytes() {
        return this.max_cache_size_bytes_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StorageMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder {
        private long current_cache_size_bytes_ = 0;
        private long max_cache_size_bytes_ = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StorageMetrics build() {
            return new StorageMetrics(this.current_cache_size_bytes_, this.max_cache_size_bytes_);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setCurrentCacheSizeBytes(long j) {
            this.current_cache_size_bytes_ = j;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setMaxCacheSizeBytes(long j) {
            this.max_cache_size_bytes_ = j;
            return this;
        }
    }
}
