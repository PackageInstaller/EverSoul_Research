package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class SnackbarManager {
    private static final int LONG_DURATION_MS = 2750;
    static final int MSG_TIMEOUT = 0;
    private static final int SHORT_DURATION_MS = 1500;
    private static SnackbarManager snackbarManager;
    private SnackbarRecord currentSnackbar;
    private SnackbarRecord nextSnackbar;
    private final Object lock = new Object();
    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.handleTimeout((SnackbarRecord) message.obj);
            return true;
        }
    });

    interface Callback {
        void dismiss(int i);

        void show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SnackbarManager getInstance() {
        if (snackbarManager == null) {
            snackbarManager = new SnackbarManager();
        }
        return snackbarManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SnackbarManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void show(int i, Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar.duration = i;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
                scheduleTimeoutLocked(this.currentSnackbar);
                return;
            }
            if (isNextSnackbarLocked(callback)) {
                this.nextSnackbar.duration = i;
            } else {
                this.nextSnackbar = new SnackbarRecord(i, callback);
            }
            SnackbarRecord snackbarRecord = this.currentSnackbar;
            if (snackbarRecord == null || !cancelSnackbarLocked(snackbarRecord, 4)) {
                this.currentSnackbar = null;
                showNextSnackbarLocked();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dismiss(Callback callback, int i) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.currentSnackbar, i);
            } else if (isNextSnackbarLocked(callback)) {
                cancelSnackbarLocked(this.nextSnackbar, i);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDismissed(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                this.currentSnackbar = null;
                if (this.nextSnackbar != null) {
                    showNextSnackbarLocked();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onShown(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback)) {
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pauseTimeout(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && !this.currentSnackbar.paused) {
                this.currentSnackbar.paused = true;
                this.handler.removeCallbacksAndMessages(this.currentSnackbar);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void restoreTimeoutIfPaused(Callback callback) {
        synchronized (this.lock) {
            if (isCurrentSnackbarLocked(callback) && this.currentSnackbar.paused) {
                this.currentSnackbar.paused = false;
                scheduleTimeoutLocked(this.currentSnackbar);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCurrent(Callback callback) {
        boolean isCurrentSnackbarLocked;
        synchronized (this.lock) {
            isCurrentSnackbarLocked = isCurrentSnackbarLocked(callback);
        }
        return isCurrentSnackbarLocked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCurrentOrNext(Callback callback) {
        boolean z;
        synchronized (this.lock) {
            z = isCurrentSnackbarLocked(callback) || isNextSnackbarLocked(callback);
        }
        return z;
    }

    private static class SnackbarRecord {
        final WeakReference<Callback> callback;
        int duration;
        boolean paused;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SnackbarRecord(int i, Callback callback) {
            this.callback = new WeakReference<>(callback);
            this.duration = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isSnackbar(Callback callback) {
            return callback != null && this.callback.get() == callback;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void showNextSnackbarLocked() {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        if (snackbarRecord != null) {
            this.currentSnackbar = snackbarRecord;
            this.nextSnackbar = null;
            Callback callback = snackbarRecord.callback.get();
            if (callback != null) {
                callback.show();
            } else {
                this.currentSnackbar = null;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean cancelSnackbarLocked(SnackbarRecord snackbarRecord, int i) {
        Callback callback = snackbarRecord.callback.get();
        if (callback == null) {
            return false;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        callback.dismiss(i);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isCurrentSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.currentSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isNextSnackbarLocked(Callback callback) {
        SnackbarRecord snackbarRecord = this.nextSnackbar;
        return snackbarRecord != null && snackbarRecord.isSnackbar(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void scheduleTimeoutLocked(SnackbarRecord snackbarRecord) {
        int i;
        if (snackbarRecord.duration == -2) {
            return;
        }
        if (snackbarRecord.duration > 0) {
            i = snackbarRecord.duration;
        } else {
            i = snackbarRecord.duration == -1 ? 1500 : LONG_DURATION_MS;
        }
        this.handler.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.handler;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void handleTimeout(SnackbarRecord snackbarRecord) {
        synchronized (this.lock) {
            if (this.currentSnackbar == snackbarRecord || this.nextSnackbar == snackbarRecord) {
                cancelSnackbarLocked(snackbarRecord, 2);
            }
        }
    }
}
