package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public interface Resolver<T> {
        Object attachCompleter(Completer<T> completer) throws Exception;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CallbackToFutureAdapter() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> ListenableFuture<T> getFuture(Resolver<T> resolver) {
        Completer<T> completer = new Completer<>();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.tag = attachCompleter;
            }
        } catch (Exception e) {
            safeFuture.setException(e);
        }
        return safeFuture;
    }

    private static final class SafeFuture<T> implements ListenableFuture<T> {
        final WeakReference<Completer<T>> completerWeakReference;
        private final AbstractResolvableFuture<T> delegate = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            protected String pendingToString() {
                Completer<T> completer = SafeFuture.this.completerWeakReference.get();
                return completer == null ? "Completer object has been garbage collected, future will fail soon" : "tag=[" + completer.tag + "]";
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SafeFuture(Completer<T> completer) {
            this.completerWeakReference = new WeakReference<>(completer);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            Completer<T> completer = this.completerWeakReference.get();
            boolean cancel = this.delegate.cancel(z);
            if (cancel && completer != null) {
                completer.fireCancellationListeners();
            }
            return cancel;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean cancelWithoutNotifyingCompleter(boolean z) {
            return this.delegate.cancel(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean set(T t) {
            return this.delegate.set(t);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean setException(Throwable th) {
            return this.delegate.setException(th);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.delegate.isDone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(j, timeUnit);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.delegate.addListener(runnable, executor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return this.delegate.toString();
        }
    }

    public static final class Completer<T> {
        private boolean attemptedSetting;
        private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
        SafeFuture<T> future;
        Object tag;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Completer() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean set(T t) {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z = safeFuture != null && safeFuture.set(t);
            if (z) {
                setCompletedNormally();
            }
            return z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean setException(Throwable th) {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z = safeFuture != null && safeFuture.setException(th);
            if (z) {
                setCompletedNormally();
            }
            return z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean setCancelled() {
            this.attemptedSetting = true;
            SafeFuture<T> safeFuture = this.future;
            boolean z = safeFuture != null && safeFuture.cancelWithoutNotifyingCompleter(true);
            if (z) {
                setCompletedNormally();
            }
            return z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void addCancellationListener(Runnable runnable, Executor executor) {
            ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
            if (resolvableFuture != null) {
                resolvableFuture.addListener(runnable, executor);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void fireCancellationListeners() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture.set(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setCompletedNormally() {
            this.tag = null;
            this.future = null;
            this.cancellationFuture = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.future;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
            }
            if (this.attemptedSetting || (resolvableFuture = this.cancellationFuture) == null) {
                return;
            }
            resolvableFuture.set(null);
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }
}
