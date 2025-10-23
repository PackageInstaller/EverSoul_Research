package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: CoroutineScheduler.kt */
@Metadata(m838d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0005"}, m839d2 = {"isSchedulerWorker", "", "thread", "Ljava/lang/Thread;", "mayNotBlock", "kotlinx-coroutines-core"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CoroutineSchedulerKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isSchedulerWorker(Thread thread) {
        return thread instanceof CoroutineScheduler.Worker;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean mayNotBlock(Thread thread) {
        return (thread instanceof CoroutineScheduler.Worker) && ((CoroutineScheduler.Worker) thread).state == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
