package com.google.android.datatransport.runtime.retries;

/* loaded from: classes.dex */
public final class Retries {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Retries() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <TInput, TResult, TException extends Throwable> TResult retry(int i, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        TResult apply;
        if (i < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.shouldRetry(tinput, apply);
            if (tinput == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return apply;
    }
}
