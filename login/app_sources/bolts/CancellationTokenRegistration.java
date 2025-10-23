package bolts;

import com.liapp.y;
import java.io.Closeable;

/* loaded from: classes.dex */
public class CancellationTokenRegistration implements Closeable {
    private Runnable action;
    private boolean closed;
    private final Object lock = new Object();
    private CancellationTokenSource tokenSource;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CancellationTokenRegistration(CancellationTokenSource cancellationTokenSource, Runnable runnable) {
        this.tokenSource = cancellationTokenSource;
        this.action = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.tokenSource.unregister(this);
            this.tokenSource = null;
            this.action = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runAction() {
        synchronized (this.lock) {
            throwIfClosed();
            this.action.run();
            close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void throwIfClosed() {
        if (this.closed) {
            throw new IllegalStateException(y.٬ݯح׭٩(576152022));
        }
    }
}
