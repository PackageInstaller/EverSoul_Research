package androidx.core.os;

/* loaded from: classes.dex */
public final class CancellationSignal {
    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        void onCancel();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel() {
        synchronized (this) {
            if (this.mIsCanceled) {
                return;
            }
            this.mIsCanceled = true;
            this.mCancelInProgress = true;
            OnCancelListener onCancelListener = this.mOnCancelListener;
            Object obj = this.mCancellationSignalObj;
            if (onCancelListener != null) {
                try {
                    onCancelListener.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.mCancelInProgress = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                Api16Impl.cancel(obj);
            }
            synchronized (this) {
                this.mCancelInProgress = false;
                notifyAll();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnCancelListener(OnCancelListener onCancelListener) {
        synchronized (this) {
            waitForCancelFinishedLocked();
            if (this.mOnCancelListener == onCancelListener) {
                return;
            }
            this.mOnCancelListener = onCancelListener;
            if (this.mIsCanceled && onCancelListener != null) {
                onCancelListener.onCancel();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getCancellationSignalObject() {
        Object obj;
        synchronized (this) {
            if (this.mCancellationSignalObj == null) {
                android.os.CancellationSignal createCancellationSignal = Api16Impl.createCancellationSignal();
                this.mCancellationSignalObj = createCancellationSignal;
                if (this.mIsCanceled) {
                    Api16Impl.cancel(createCancellationSignal);
                }
            }
            obj = this.mCancellationSignalObj;
        }
        return obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void cancel(Object obj) {
            ((android.os.CancellationSignal) obj).cancel();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static android.os.CancellationSignal createCancellationSignal() {
            return new android.os.CancellationSignal();
        }
    }
}
