package com.kakaogame.log.tracer;

import com.kakaogame.core.CoreManager;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Job.kt */
@Metadata(m838d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005J4\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00052\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-J8\u0010.\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00052\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-J\u001e\u0010/\u001a\u00020)2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000f¨\u00060"}, m839d2 = {"Lcom/kakaogame/log/tracer/Job;", "", "jobId", "", "name", "", "(ILjava/lang/String;)V", "actions", "", "Lcom/kakaogame/log/tracer/Action;", "getActions", "()Ljava/util/Map;", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "jobCode", "Lcom/kakaogame/log/tracer/TraceJobCode;", "getJobCode", "()Lcom/kakaogame/log/tracer/TraceJobCode;", "setJobCode", "(Lcom/kakaogame/log/tracer/TraceJobCode;)V", "getJobId", "()I", "getName", "()Ljava/lang/String;", "running", "", "getRunning", "()Z", "setRunning", "(Z)V", "startTime", "getStartTime", "addAction", "", "actionName", "finish", "", "Lcom/kakaogame/log/tracer/Trace;", ServerConstants.TRACE_RESULT_CODE, "description", "extras", "", "finishAction", "start", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Job {
    private final Map<String, Action> actions;
    private long duration;
    private TraceJobCode jobCode;
    private final int jobId;
    private final String name;
    private boolean running;
    private final long startTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Job(int i, String str) {
        Intrinsics.checkNotNullParameter(str, y.ٲٴݴ״ٰ(1781623392));
        this.jobId = i;
        this.name = str;
        this.jobCode = TraceJobCode.GAME_CUSTOM;
        this.startTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        this.running = true;
        this.actions = new LinkedHashMap();
        this.jobCode = TraceJobCode.INSTANCE.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getJobId() {
        return this.jobId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TraceJobCode getJobCode() {
        return this.jobCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setJobCode(TraceJobCode traceJobCode) {
        Intrinsics.checkNotNullParameter(traceJobCode, y.ٴسسݬߨ(1392633402));
        this.jobCode = traceJobCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getStartTime() {
        return this.startTime;
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
    public final boolean getRunning() {
        return this.running;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setRunning(boolean z) {
        this.running = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Action> getActions() {
        return this.actions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Trace start(Map<String, ? extends Object> extras) {
        return new Trace(this.jobId, this.name, this.startTime, extras);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addAction(String actionName) {
        Intrinsics.checkNotNullParameter(actionName, y.٬ݯح׭٩(576517918));
        if (this.running) {
            this.actions.put(actionName, new Action(actionName));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Trace finishAction(String actionName, int resultCode, String description, Map<String, ? extends Object> extras) {
        Action action;
        Trace finish;
        Intrinsics.checkNotNullParameter(actionName, y.٬ݯح׭٩(576517918));
        Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
        if (!this.running || (action = this.actions.get(actionName)) == null || (finish = action.finish(resultCode, description, extras)) == null) {
            return null;
        }
        finish.setJobInfo(this.jobId, this.name);
        return finish;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Trace> finish(int resultCode, String description, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
        ArrayList arrayList = new ArrayList();
        if (this.running) {
            this.running = false;
            for (Map.Entry<String, Action> entry : this.actions.entrySet()) {
                if (entry.getValue().isRunning()) {
                    Trace finish = entry.getValue().finish(this.jobCode.getCode() + 10000 + 999, y.٬ݯح׭٩(576518078), null);
                    if (finish != null) {
                        finish.setJobInfo(this.jobId, this.name);
                        arrayList.add(finish);
                    }
                }
            }
            this.duration = CoreManager.INSTANCE.getInstance().currentTimeMillis() - this.startTime;
            arrayList.add(new Trace(this.jobId, this.name, this.startTime, this.duration, resultCode, description, extras));
        }
        return arrayList;
    }
}
