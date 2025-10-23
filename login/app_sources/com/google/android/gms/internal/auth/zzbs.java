package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzbs extends zzbj {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbs(zzbt zzbtVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzbj
    protected final void zza(Context context, zzbh zzbhVar) throws RemoteException {
        zzbhVar.zzd(new zzbr(this));
    }
}
