package com.kakaogame.log.tracer;

import com.kakaogame.core.CoreManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiCallRtt.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\r¨\u0006 "}, m839d2 = {"Lcom/kakaogame/log/tracer/ApiCallRtt;", "", "jobId", "", "jobName", "", "uri", "startTime", "", "(ILjava/lang/String;Ljava/lang/String;J)V", "getJobId", "()I", "getJobName", "()Ljava/lang/String;", "oneWayRtt", "getOneWayRtt", "()J", "setOneWayRtt", "(J)V", "serverElapsed", "getServerElapsed", "setServerElapsed", "serverResponseTime", "getServerResponseTime", "setServerResponseTime", "serverStartTime", "getServerStartTime", "setServerStartTime", "getStartTime", "getUri", "responseApi", "serverDuration", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ApiCallRtt {
    private final int jobId;
    private final String jobName;
    private long oneWayRtt;
    private long serverElapsed;
    private long serverResponseTime;
    private long serverStartTime;
    private final long startTime;
    private final String uri;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiCallRtt(int i, String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051420309));
        Intrinsics.checkNotNullParameter(str2, y.ۮڭڭܬި(862392755));
        this.jobId = i;
        this.jobName = str;
        this.uri = str2;
        this.startTime = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getJobId() {
        return this.jobId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJobName() {
        return this.jobName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUri() {
        return this.uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getServerStartTime() {
        return this.serverStartTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setServerStartTime(long j) {
        this.serverStartTime = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getServerResponseTime() {
        return this.serverResponseTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setServerResponseTime(long j) {
        this.serverResponseTime = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getServerElapsed() {
        return this.serverElapsed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setServerElapsed(long j) {
        this.serverElapsed = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getOneWayRtt() {
        return this.oneWayRtt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setOneWayRtt(long j) {
        this.oneWayRtt = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApiCallRtt responseApi(long serverStartTime, long serverResponseTime, long serverDuration) {
        long currentTimeMillis = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        this.serverStartTime = serverStartTime;
        this.serverResponseTime = serverResponseTime;
        this.serverElapsed = serverDuration;
        this.oneWayRtt = ((currentTimeMillis - this.startTime) - serverDuration) / 2;
        return this;
    }
}
