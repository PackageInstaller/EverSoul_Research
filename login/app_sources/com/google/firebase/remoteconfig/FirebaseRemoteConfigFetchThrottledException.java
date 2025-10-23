package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends FirebaseRemoteConfigException {
    private final long throttleEndTimeMillis;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigFetchThrottledException(long j) {
        this("Fetch was throttled.", j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseRemoteConfigFetchThrottledException(String str, long j) {
        super(str);
        this.throttleEndTimeMillis = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }
}
