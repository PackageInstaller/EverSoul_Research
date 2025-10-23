package bolts;

import bolts.Task;

/* loaded from: classes.dex */
class UnobservedErrorNotifier {
    private Task<?> task;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnobservedErrorNotifier(Task<?> task) {
        this.task = task;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void finalize() throws Throwable {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        try {
            Task<?> task = this.task;
            if (task != null && (unobservedExceptionHandler = Task.getUnobservedExceptionHandler()) != null) {
                unobservedExceptionHandler.unobservedException(task, new UnobservedTaskException(task.getError()));
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setObserved() {
        this.task = null;
    }
}
