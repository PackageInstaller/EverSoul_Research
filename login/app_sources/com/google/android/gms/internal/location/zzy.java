package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzy extends zzah {
    private final BaseImplementation.ResultHolder<Status> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzy(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zza = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzai
    public final void zzb(zzaa zzaaVar) {
        this.zza.setResult(zzaaVar.getStatus());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzai
    public final void zzc() {
    }
}
