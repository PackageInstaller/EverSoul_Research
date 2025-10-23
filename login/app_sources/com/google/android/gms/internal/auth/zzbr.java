package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzbr extends zzbd {
    final /* synthetic */ zzbs zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbr(zzbs zzbsVar) {
        this.zza = zzbsVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzc(String str) {
        if (str != null) {
            this.zza.setResult((zzbs) new zzbv(str));
        } else {
            this.zza.setResult((zzbs) new zzbv(new Status(AuthApiStatusCodes.AUTH_APP_CERT_ERROR)));
        }
    }
}
