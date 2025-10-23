package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzbe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
final class zza extends Api.AbstractClientBuilder<zzbe, AuthProxyOptions> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zza() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Api.AbstractClientBuilder
    public final /* bridge */ /* synthetic */ zzbe buildClient(Context context, Looper looper, ClientSettings clientSettings, AuthProxyOptions authProxyOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzbe(context, looper, clientSettings, authProxyOptions, connectionCallbacks, onConnectionFailedListener);
    }
}
