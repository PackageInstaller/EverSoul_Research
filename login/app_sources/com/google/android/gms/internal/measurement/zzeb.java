package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzeb extends zzdf.zza {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzcs zzd;
    private final /* synthetic */ zzdf zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzeb(zzdf zzdfVar, Bundle bundle, zzcs zzcsVar) {
        super(zzdfVar);
        this.zzc = bundle;
        this.zzd = zzcsVar;
        this.zze = zzdfVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzdf.zza
    protected final void zzb() {
        this.zzd.zza((Bundle) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzdf.zza
    final void zza() throws RemoteException {
        zzcu zzcuVar;
        zzcuVar = this.zze.zzj;
        ((zzcu) Preconditions.checkNotNull(zzcuVar)).performAction(this.zzc, this.zzd, this.zza);
    }
}
