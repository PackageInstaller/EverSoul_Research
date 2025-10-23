package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzau;
import com.google.android.gms.internal.auth.zzav;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzi extends zzm {
    final /* synthetic */ zzav zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzi(AccountTransferClient accountTransferClient, int i, zzav zzavVar) {
        super(1610);
        this.zza = zzavVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.accounttransfer.zzk
    protected final void zza(zzau zzauVar) throws RemoteException {
        zzauVar.zzf(this.zzc, this.zza);
    }
}
