package kotlinx.coroutines.tasks;

import com.singular.sdk.internal.Constants;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* compiled from: Tasks.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m839d2 = {"Lkotlinx/coroutines/tasks/DirectExecutor;", "Ljava/util/concurrent/Executor;", "()V", "execute", "", Constants.REVENUE_AMOUNT_KEY, "Ljava/lang/Runnable;", "kotlinx-coroutines-play-services"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
final class DirectExecutor implements Executor {
    public static final DirectExecutor INSTANCE = new DirectExecutor();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DirectExecutor() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable r) {
        r.run();
    }
}
