package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Callables {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Callables() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Callable<T> returning(@ParametricNullness final T t) {
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$returning$0(t);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> AsyncCallable<T> asAsyncCallable(final Callable<T> callable, final ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new AsyncCallable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.util.concurrent.AsyncCallable
            public final ListenableFuture call() {
                ListenableFuture submit;
                submit = ListeningExecutorService.this.submit(callable);
                return submit;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> Callable<T> threadRenaming(final Callable<T> callable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(callable);
        return new Callable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.lambda$threadRenaming$2(Supplier.this, callable);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ Object lambda$threadRenaming$2(Supplier supplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (trySetName) {
                trySetName(name, currentThread);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Runnable threadRenaming(final Runnable runnable, final Supplier<String> supplier) {
        Preconditions.checkNotNull(supplier);
        Preconditions.checkNotNull(runnable);
        return new Runnable() { // from class: com.google.common.util.concurrent.Callables$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                Callables.lambda$threadRenaming$3(Supplier.this, runnable);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void lambda$threadRenaming$3(Supplier supplier, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean trySetName = trySetName((String) supplier.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (trySetName) {
                trySetName(name, currentThread);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean trySetName(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
