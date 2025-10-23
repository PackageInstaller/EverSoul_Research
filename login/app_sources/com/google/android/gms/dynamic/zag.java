package com.google.android.gms.dynamic;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zag implements zah {
    final /* synthetic */ DeferredLifecycleHelper zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.zaa.zaa;
        lifecycleDelegate2.onResume();
    }
}
