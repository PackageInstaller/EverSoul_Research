package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzh implements zzk<Void> {
    final /* synthetic */ String zza;
    final /* synthetic */ Bundle zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzh(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Void zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zzd = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzd(this.zza, this.zzb);
        zzl.zzd(zzd);
        String string = zzd.getString("Error");
        if (zzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
