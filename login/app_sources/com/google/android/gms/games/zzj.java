package com.google.android.gms.games;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.games.internal.zzak;
import com.google.android.gms.games.internal.zzar;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
class zzj extends Api.AbstractClientBuilder {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzj(zzi zziVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzn zznVar = (zzn) obj;
        if (zznVar == null) {
            zznVar = new zzl(null).zze();
        }
        zzak zzakVar = new zzak(context, looper, clientSettings, zznVar, connectionCallbacks, onConnectionFailedListener, zzar.zza());
        if (zznVar.zzo.zzc()) {
            zzakVar.zzS(com.google.android.gms.games.internal.zzg.zzc(context));
        }
        return zzakVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Api.BaseClientBuilder
    public final int getPriority() {
        return 1;
    }
}
