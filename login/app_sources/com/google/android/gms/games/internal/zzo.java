package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzo implements BaseImplementation.ResultHolder {
    final /* synthetic */ BaseGmsClient.SignOutCallbacks zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzo(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        this.zza = signOutCallbacks;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.onSignOutComplete();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        this.zza.onSignOutComplete();
    }
}
