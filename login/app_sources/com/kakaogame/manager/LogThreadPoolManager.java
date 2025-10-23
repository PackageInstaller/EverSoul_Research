package com.kakaogame.manager;

import com.kakaogame.Logger;
import com.liapp.y;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogThreadPoolManager.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/manager/LogThreadPoolManager;", "", "()V", "CORE_POOL_SIZE", "", "MAX_POOL_SIZE", "TAG", "", "threadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "run", "", "runnable", "Ljava/lang/Runnable;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LogThreadPoolManager {
    private static final int CORE_POOL_SIZE = 1;
    private static final int MAX_POOL_SIZE = 2;
    private static final String TAG = "LogThreadPoolManager";
    public static final LogThreadPoolManager INSTANCE = new LogThreadPoolManager();
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LogThreadPoolManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void run(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, y.ݮڮֲڭܩ(-628413836));
        Logger.INSTANCE.m706v(y.ٲٴݴ״ٰ(1782186992), y.ٴسسݬߨ(1393499690) + runnable);
        threadPool.execute(new Runnable() { // from class: com.kakaogame.manager.LogThreadPoolManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                LogThreadPoolManager.run$lambda$0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void run$lambda$0(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, y.ݬֲ֮ܲت(1512454063));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158725199) + runnable;
        String str2 = y.ٲٴݴ״ٰ(1782186992);
        logger.m706v(str2, str);
        try {
            runnable.run();
        } catch (OutOfMemoryError e) {
            Logger.INSTANCE.m702e(str2, y.ݮڮֲڭܩ(-628414012), e);
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(str2, th.toString(), th);
        }
    }
}
