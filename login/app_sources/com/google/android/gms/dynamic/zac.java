package com.google.android.gms.dynamic;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zac implements zah {
    final /* synthetic */ Bundle zaa;
    final /* synthetic */ DeferredLifecycleHelper zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zab = deferredLifecycleHelper;
        this.zaa = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.zab.zaa;
        lifecycleDelegate2.onCreate(this.zaa);
    }
}
