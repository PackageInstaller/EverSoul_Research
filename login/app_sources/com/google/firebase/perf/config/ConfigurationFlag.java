package com.google.firebase.perf.config;

/* loaded from: classes2.dex */
abstract class ConfigurationFlag<T> {
    protected abstract T getDefault();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getDeviceCacheFlag() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getMetadataFlag() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getRemoteConfigFlag() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConfigurationFlag() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected T getDefaultOnRcFetchFail() {
        return getDefault();
    }
}
