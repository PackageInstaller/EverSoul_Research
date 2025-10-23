package com.bumptech.glide.request;

/* loaded from: classes.dex */
public interface RequestCoordinator {
    boolean canNotifyCleared(Request request);

    boolean canNotifyStatusChanged(Request request);

    boolean canSetImage(Request request);

    boolean isAnyResourceSet();

    void onRequestFailed(Request request);

    void onRequestSuccess(Request request);

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RequestState(boolean z) {
            this.isComplete = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isComplete() {
            return this.isComplete;
        }
    }
}
