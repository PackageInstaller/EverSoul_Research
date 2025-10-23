package bolts;

import com.liapp.y;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final Task<TResult> task = new Task<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<TResult> getTask() {
        return this.task;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean trySetResult(TResult tresult) {
        return this.task.trySetResult(tresult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean trySetError(Exception exc) {
        return this.task.trySetError(exc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException(y.ۮڭڭܬި(861984355));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setResult(TResult tresult) {
        if (!trySetResult(tresult)) {
            throw new IllegalStateException(y.٬ݯح׭٩(576159110));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setError(Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1781638984));
        }
    }
}
