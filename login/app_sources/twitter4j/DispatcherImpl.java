package twitter4j;

import com.liapp.y;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
final class DispatcherImpl implements Dispatcher {
    private static final long SHUTDOWN_TIME = 5000;
    private static final Logger logger = Logger.getLogger(DispatcherImpl.class);
    private final ExecutorService executorService;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DispatcherImpl(final Configuration configuration) {
        this.executorService = Executors.newFixedThreadPool(configuration.getAsyncNumThreads(), new ThreadFactory() { // from class: twitter4j.DispatcherImpl.1
            int count = 0;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                int i = this.count;
                this.count = i + 1;
                thread.setName(String.format(y.٬ݯح׭٩(576296886), Integer.valueOf(i)));
                thread.setDaemon(configuration.isDaemonEnabled());
                return thread;
            }
        });
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: twitter4j.DispatcherImpl.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                DispatcherImpl.this.executorService.shutdown();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Dispatcher
    public synchronized void invokeLater(Runnable runnable) {
        this.executorService.execute(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.Dispatcher
    public synchronized void shutdown() {
        this.executorService.shutdown();
        try {
            if (!this.executorService.awaitTermination(5000L, TimeUnit.MILLISECONDS)) {
                this.executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
        }
    }
}
