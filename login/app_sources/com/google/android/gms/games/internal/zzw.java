package com.google.android.gms.games.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.games_v2.zzez;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzw extends com.google.android.gms.internal.games_v2.zzaj {
    final /* synthetic */ zzak zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzw(zzak zzakVar) {
        super(zzakVar.getContext().getMainLooper(), 1000);
        this.zza = zzakVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzaj
    protected final void zza(String str, int i) {
        try {
            if (this.zza.isConnected()) {
                ((zzap) this.zza.getService()).zzw(str, i);
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
            sb.append("Unable to increment event ");
            sb.append(str);
            sb.append(" by ");
            sb.append(i);
            sb.append(" because the games client is no longer connected");
            zzez.zzc("GamesGmsClientImpl", sb.toString());
        } catch (RemoteException e) {
            zzak.zzU(e);
        } catch (SecurityException e2) {
            int i2 = zzak.zze;
            zzez.zzd("GamesGmsClientImpl", "Is player signed out?", e2);
        }
    }
}
