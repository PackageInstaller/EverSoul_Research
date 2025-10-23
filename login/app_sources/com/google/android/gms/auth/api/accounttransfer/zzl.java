package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzan;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzl extends zzan {
    final /* synthetic */ zzm zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzl(zzm zzmVar) {
        this.zza = zzmVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zzd(Status status) {
        this.zza.zzb.setException(new AccountTransferException(status));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzan, com.google.android.gms.internal.auth.zzat
    public final void zze() {
        this.zza.zzb.setResult(null);
    }
}
