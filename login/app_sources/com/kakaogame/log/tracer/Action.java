package com.kakaogame.log.tracer;

import com.kakaogame.core.CoreManager;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Action.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001bJ\u0006\u0010\u001c\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/log/tracer/Action;", "", "name", "", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "getName", "()Ljava/lang/String;", "running", "", "getRunning", "()Z", "setRunning", "(Z)V", "startTime", "getStartTime", "finish", "Lcom/kakaogame/log/tracer/Trace;", "code", "", "description", "extras", "", "isRunning", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Action {
    private long duration;
    private final String name;
    private boolean running;
    private final long startTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Action(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٲٴݴ״ٰ(1781623392));
        this.name = str;
        this.startTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        this.running = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getName() {
        return this.name;
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
    public final Trace finish(int code, String description, Map<String, ? extends Object> extras) {
        Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
        if (!this.running) {
            return null;
        }
        this.running = false;
        this.duration = CoreManager.INSTANCE.getInstance().currentTimeMillis() - this.startTime;
        return new Trace(this.name, this.startTime, this.duration, code, description, extras);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isRunning() {
        return this.running;
    }
}
