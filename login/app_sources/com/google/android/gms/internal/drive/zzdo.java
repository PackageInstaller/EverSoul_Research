package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.events.OpenFileCallback;

/* loaded from: classes2.dex */
final class zzdo implements ListenerHolder.Notifier<OpenFileCallback> {
    private final /* synthetic */ zzdg zzgp;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdo(zzdk zzdkVar, zzdg zzdgVar) {
        this.zzgp = zzdgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(OpenFileCallback openFileCallback) {
        this.zzgp.accept(openFileCallback);
    }
}
