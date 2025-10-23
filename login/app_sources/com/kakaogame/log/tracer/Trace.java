package com.kakaogame.log.tracer;

import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Trace.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0002\u0010\nBO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0002\u0010\u000eBG\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0002\u0010\u0010BG\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0016\u00102\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\b\u00104\u001a\u00020\u0005H\u0016R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001a\u0010\"\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001a\u0010*\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001a\u0010-\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001a¨\u00065"}, m839d2 = {"Lcom/kakaogame/log/tracer/Trace;", "", "id", "", ServerConstants.TRACE_JOB_NAME, "", "startTime", "", "extras", "", "(ILjava/lang/String;JLjava/util/Map;)V", "duration", "code", "description", "(ILjava/lang/String;JJILjava/lang/String;Ljava/util/Map;)V", "action", "(Ljava/lang/String;JJILjava/lang/String;Ljava/util/Map;)V", "rttServerUrl", "(ILjava/lang/String;Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "getJob", "setJob", "jobId", "getJobId", "()I", "setJobId", "(I)V", ServerConstants.TRACE_RESULT_CODE, "getResultCode", "setResultCode", ServerConstants.TRACE_RESULT_DESCRIPTION, "getResultDescription", "setResultDescription", ServerConstants.TRACE_RTT_CHECK_SERVER_URL, "getRttCheckServerUrl", "setRttCheckServerUrl", "getStartTime", "setStartTime", "setJobInfo", "", "toString", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Trace {
    private String action;
    private long duration;
    private Map<String, Object> extras;
    private String job;
    private int jobId;
    private int resultCode;
    private String resultDescription;
    private String rttCheckServerUrl;
    private long startTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getJobId() {
        return this.jobId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setJobId(int i) {
        this.jobId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getJob() {
        return this.job;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setJob(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.job = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAction() {
        return this.action;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setAction(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.action = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setStartTime(long j) {
        this.startTime = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setDuration(long j) {
        this.duration = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setResultCode(int i) {
        this.resultCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getResultDescription() {
        return this.resultDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setResultDescription(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.resultDescription = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRttCheckServerUrl() {
        return this.rttCheckServerUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setRttCheckServerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        this.rttCheckServerUrl = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setExtras(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, y.ٴسسݬߨ(1392633402));
        this.extras = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Trace(int i, String str, long j, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576505910));
        this.job = "";
        this.action = "";
        this.resultCode = 200;
        this.resultDescription = "";
        this.rttCheckServerUrl = "";
        this.extras = new LinkedHashMap();
        this.jobId = i;
        this.job = str;
        this.action = str + "_start";
        this.startTime = j;
        this.duration = 0L;
        this.resultCode = 200;
        if (map != null) {
            this.extras.putAll(map);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Trace(int i, String str, long j, long j2, int i2, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576505910));
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1392801274));
        this.job = "";
        this.action = "";
        this.resultCode = 200;
        this.resultDescription = "";
        this.rttCheckServerUrl = "";
        this.extras = new LinkedHashMap();
        this.jobId = i;
        this.job = str;
        this.startTime = j;
        this.duration = j2;
        this.action = str + "_end";
        this.resultCode = i2;
        this.resultDescription = str2;
        if (map != null) {
            this.extras.putAll(map);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Trace(String str, long j, long j2, int i, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(str2, y.ٴسسݬߨ(1392801274));
        this.job = "";
        this.action = "";
        this.resultCode = 200;
        this.resultDescription = "";
        this.rttCheckServerUrl = "";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.extras = linkedHashMap;
        this.action = str;
        this.startTime = j;
        this.duration = j2;
        this.resultCode = i;
        this.resultDescription = str2;
        if (map != null) {
            linkedHashMap.putAll(map);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Trace(int i, String str, String str2, long j, long j2, int i2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(576505910));
        Intrinsics.checkNotNullParameter(str2, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(str3, y.ٴسسݬߨ(1392801274));
        Intrinsics.checkNotNullParameter(str4, y.ݬֲ֮ܲت(1512449975));
        this.job = "";
        this.action = "";
        this.resultCode = 200;
        this.resultDescription = "";
        this.rttCheckServerUrl = "";
        this.extras = new LinkedHashMap();
        this.jobId = i;
        this.job = str;
        this.action = str2;
        this.startTime = j;
        this.duration = j2;
        this.resultCode = i2;
        this.resultDescription = str3;
        this.rttCheckServerUrl = str4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setJobInfo(int id, String job) {
        Intrinsics.checkNotNullParameter(job, y.٬ݯح׭٩(576505910));
        this.jobId = id;
        this.job = job;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576506030) + this.jobId + y.ٲٴݴ״ٰ(1782191088) + this.job + y.ݬֲ֮ܲت(1512449751) + this.action + y.ٴسسݬߨ(1393495442) + this.startTime + y.٬ݯح׭٩(576506382) + this.duration + y.ۮڭڭܬި(862676891) + this.resultCode + y.دײܮڳܯ(2051396309) + this.resultDescription + y.ݮڮֲڭܩ(-628409484) + this.extras + '\n';
    }
}
