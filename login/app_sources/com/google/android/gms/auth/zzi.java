package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzi implements zzk<List<AccountChangeEvent>> {
    final /* synthetic */ AccountChangeEventsRequest zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzi(AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = accountChangeEventsRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ List<AccountChangeEvent> zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        AccountChangeEventsResponse zzh = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzh(this.zza);
        zzl.zzd(zzh);
        return zzh.getEvents();
    }
}
