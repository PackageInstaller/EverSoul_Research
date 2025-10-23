package bolts;

import com.liapp.y;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
final class BoltsExecutors {
    private static final BoltsExecutors INSTANCE = new BoltsExecutors();
    private final ExecutorService background;
    private final Executor immediate;
    private final ScheduledExecutorService scheduled;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isAndroidRuntime() {
        String property = System.getProperty(y.دײܮڳܯ(2051910029));
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains(y.ٴسسݬߨ(1392813258));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BoltsExecutors() {
        this.background = !isAndroidRuntime() ? Executors.newCachedThreadPool() : AndroidExecutors.newCachedThreadPool();
        this.scheduled = Executors.newSingleThreadScheduledExecutor();
        this.immediate = new ImmediateExecutor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExecutorService background() {
        return INSTANCE.background;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ScheduledExecutorService scheduled() {
        return INSTANCE.scheduled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Executor immediate() {
        return INSTANCE.immediate;
    }

    private static class ImmediateExecutor implements Executor {
        private static final int MAX_DEPTH = 15;
        private ThreadLocal<Integer> executionDepth;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ImmediateExecutor() {
            this.executionDepth = new ThreadLocal<>();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (incrementDepth() <= 15) {
                    runnable.run();
                } else {
                    BoltsExecutors.background().execute(runnable);
                }
            } finally {
                decrementDepth();
            }
        }
    }
}
