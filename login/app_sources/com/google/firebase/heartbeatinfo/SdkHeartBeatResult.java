package com.google.firebase.heartbeatinfo;

/* loaded from: classes2.dex */
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    public abstract long getMillis();

    public abstract String getSdkName();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SdkHeartBeatResult create(String str, long j) {
        return new AutoValue_SdkHeartBeatResult(str, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return getMillis() < sdkHeartBeatResult.getMillis() ? -1 : 1;
    }
}
