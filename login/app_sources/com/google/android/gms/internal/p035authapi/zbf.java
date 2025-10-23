package com.google.android.gms.internal.p035authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
final class zbf extends zbd {
    final /* synthetic */ zbg zba;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbf(zbg zbgVar) {
        this.zba = zbgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbb(Status status, Credential credential) {
        this.zba.setResult((zbg) new zbe(status, credential));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult((zbg) new zbe(status, null));
    }
}
