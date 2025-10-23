package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(m838d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, m840k = 4, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JobKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final CompletableJob Job(Job job) {
        return JobKt__JobKt.Job(job);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancel(coroutineContext, cancellationException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void cancel(Job job, String str, Throwable th) {
        JobKt__JobKt.cancel(job, str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Object cancelAndJoin(Job job, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin(job, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void cancelChildren(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(coroutineContext, cancellationException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void cancelChildren(Job job, CancellationException cancellationException) {
        JobKt__JobKt.cancelChildren(job, cancellationException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final DisposableHandle cancelFutureOnCompletion(Job job, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion(job, future);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final DisposableHandle disposeOnCompletion(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.disposeOnCompletion(job, disposableHandle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ensureActive(CoroutineContext coroutineContext) {
        JobKt__JobKt.ensureActive(coroutineContext);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ensureActive(Job job) {
        JobKt__JobKt.ensureActive(job);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Job getJob(CoroutineContext coroutineContext) {
        return JobKt__JobKt.getJob(coroutineContext);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isActive(CoroutineContext coroutineContext) {
        return JobKt__JobKt.isActive(coroutineContext);
    }
}
