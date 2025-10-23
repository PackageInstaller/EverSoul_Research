package androidx.browser.trusted;

import androidx.concurrent.futures.ResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
class FutureUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> ListenableFuture<T> immediateFailedFuture(Throwable th) {
        ResolvableFuture create = ResolvableFuture.create();
        create.setException(th);
        return create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FutureUtils() {
    }
}
