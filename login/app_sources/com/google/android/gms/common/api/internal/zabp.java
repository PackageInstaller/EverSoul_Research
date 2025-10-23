package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zabp implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ zabq zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zabp(zabq zabqVar) {
        this.zaa = zabqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.zaa.zaa.zar.post(new zabo(this));
    }
}
