package bolts;

import com.liapp.y;
import java.util.Locale;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class CancellationToken {
    private final CancellationTokenSource tokenSource;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.tokenSource = cancellationTokenSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CancellationTokenRegistration register(Runnable runnable) {
        return this.tokenSource.register(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return String.format(Locale.US, y.ٲٴݴ״ٰ(1781644232), getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested()));
    }
}
