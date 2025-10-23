package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzby;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zzj implements zzk<Boolean> {
    final /* synthetic */ String zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzj(String str) {
        this.zza = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Boolean zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Logger logger;
        Bundle zzg = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzg(this.zza);
        zzl.zzd(zzg);
        String string = zzg.getString("Error");
        Intent intent = (Intent) zzg.getParcelable("userRecoveryIntent");
        zzby zza = zzby.zza(string);
        if (zzby.SUCCESS.equals(zza)) {
            return true;
        }
        if (!zzby.zzb(zza)) {
            throw new GoogleAuthException(string);
        }
        logger = zzl.zzd;
        String valueOf = String.valueOf(zza);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 31);
        sb.append("isUserRecoverableError status: ");
        sb.append(valueOf);
        logger.m163w("GoogleAuthUtil", sb.toString());
        throw new UserRecoverableAuthException(string, intent);
    }
}
