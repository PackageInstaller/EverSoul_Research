package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class CallableBackgroundInitializer<T> extends BackgroundInitializer<T> {
    private final Callable<T> callable;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CallableBackgroundInitializer(Callable<T> callable) {
        checkCallable(callable);
        this.callable = callable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CallableBackgroundInitializer(Callable<T> callable, ExecutorService executorService) {
        super(executorService);
        checkCallable(callable);
        this.callable = callable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.BackgroundInitializer
    protected T initialize() throws Exception {
        return this.callable.call();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkCallable(Callable<T> callable) {
        Validate.isTrue(callable != null, y.ݬֲ֮ܲت(1512686943), new Object[0]);
    }
}
