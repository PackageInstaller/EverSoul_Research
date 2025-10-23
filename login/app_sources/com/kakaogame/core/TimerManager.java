package com.kakaogame.core;

import com.kakaogame.Logger;
import com.liapp.y;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimerManager.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/core/TimerManager;", "", "timerTask", "Ljava/lang/Runnable;", "initialDelay", "", "timerInterval", "(Ljava/lang/Runnable;JJ)V", "lock", "prevTaskTime", "timer", "Ljava/util/concurrent/ScheduledFuture;", "startTimer", "", "stopTimer", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TimerManager {
    private static final String TAG = "TimerManager";
    private final long initialDelay;
    private final Object lock = new Object();
    private long prevTaskTime;
    private ScheduledFuture<?> timer;
    private final long timerInterval;
    private final Runnable timerTask;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimerManager(Runnable runnable, long j, long j2) {
        this.timerTask = runnable;
        this.initialDelay = j;
        this.timerInterval = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void startTimer() {
        Logger.INSTANCE.m706v(y.ݮڮֲڭܩ(-628535716), y.ۮڭڭܬި(862524235) + this.timer);
        try {
            synchronized (this.lock) {
                if (this.timer != null) {
                    return;
                }
                if (this.timerTask == null) {
                    return;
                }
                if (this.timerInterval < 0) {
                    return;
                }
                this.timer = new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(new Runnable() { // from class: com.kakaogame.core.TimerManager$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimerManager.startTimer$lambda$1$lambda$0(TimerManager.this);
                    }
                }, this.initialDelay, this.timerInterval, TimeUnit.MILLISECONDS);
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628535716), e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void startTimer$lambda$1$lambda$0(TimerManager timerManager) {
        Intrinsics.checkNotNullParameter(timerManager, y.ٴسسݬߨ(1393322442));
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576634358);
        String str2 = y.ݮڮֲڭܩ(-628535716);
        logger.m706v(str2, str);
        try {
            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - timerManager.prevTaskTime);
            long j = timerManager.timerInterval;
            try {
                if (!CoreManager.INSTANCE.getInstance().isPaused()) {
                    timerManager.timerTask.run();
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
            }
            timerManager.prevTaskTime = System.nanoTime();
        } catch (Exception e2) {
            Logger.INSTANCE.m702e(str2, e2.toString(), e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopTimer() {
        Logger.INSTANCE.m706v(y.ݮڮֲڭܩ(-628535716), y.ۮڭڭܬި(862524379));
        try {
            synchronized (this.lock) {
                ScheduledFuture<?> scheduledFuture = this.timer;
                if (scheduledFuture != null) {
                    Intrinsics.checkNotNull(scheduledFuture);
                    scheduledFuture.cancel(false);
                    this.timer = null;
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628535716), e.toString(), e);
        }
    }
}
