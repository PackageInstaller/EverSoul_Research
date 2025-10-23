package com.kakaogame.util;

import com.liapp.y;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stopwatch.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/util/Stopwatch;", "", "name", "", "(Ljava/lang/String;)V", "durationMs", "", "getDurationMs", "()J", "getName", "()Ljava/lang/String;", "startNanoTime", "startTime", "getStartTime", "stopNanoTime", "stop", "", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Stopwatch {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final long startNanoTime;
    private final long startTime;
    private long stopNanoTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Stopwatch start(String str) {
        return INSTANCE.start(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Stopwatch(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٲٴݴ״ٰ(1781623392));
        this.name = str;
        this.startNanoTime = System.nanoTime();
        this.startTime = System.currentTimeMillis();
        this.stopNanoTime = -1L;
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
    public final void stop() {
        if (this.stopNanoTime == -1) {
            this.stopNanoTime = System.nanoTime();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getDurationMs() {
        return TimeUnit.NANOSECONDS.toMillis(this.stopNanoTime - this.startNanoTime);
    }

    /* compiled from: Stopwatch.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/util/Stopwatch$Companion;", "", "()V", "start", "Lcom/kakaogame/util/Stopwatch;", "name", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final Stopwatch start(String name) {
            Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
            return new Stopwatch(name);
        }
    }
}
