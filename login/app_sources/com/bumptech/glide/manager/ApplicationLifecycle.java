package com.bumptech.glide.manager;

/* loaded from: classes.dex */
class ApplicationLifecycle implements Lifecycle {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ApplicationLifecycle() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
