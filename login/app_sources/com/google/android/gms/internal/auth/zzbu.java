package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzbu implements ProxyApi.ProxyResult {
    private final Status zza;
    private ProxyResponse zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbu(ProxyResponse proxyResponse) {
        this.zzb = proxyResponse;
        this.zza = Status.RESULT_SUCCESS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbu(Status status) {
        this.zza = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult
    public final ProxyResponse getResponse() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}
