package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaab extends zag {
    private final ListenerHolder zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zaab(ListenerHolder listenerHolder) {
        this.zaa = listenerHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.moduleinstall.internal.zah
    public final void zab(ModuleInstallStatusUpdate moduleInstallStatusUpdate) {
        this.zaa.notifyListener(new zaaa(this, moduleInstallStatusUpdate));
    }
}
