package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzbp extends zzbd {
    final /* synthetic */ zzbq zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbp(zzbq zzbqVar) {
        this.zza = zzbqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzb(ProxyResponse proxyResponse) {
        this.zza.setResult((zzbq) new zzbu(proxyResponse));
    }
}
