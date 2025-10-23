package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzej extends zzdf.zza {
    private final /* synthetic */ zzdf.zzb zzc;
    private final /* synthetic */ zzdf zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzej(zzdf zzdfVar, zzdf.zzb zzbVar) {
        super(zzdfVar);
        this.zzc = zzbVar;
        this.zzd = zzdfVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzdf.zza
    final void zza() throws RemoteException {
        zzcu zzcuVar;
        zzcuVar = this.zzd.zzj;
        ((zzcu) Preconditions.checkNotNull(zzcuVar)).registerOnMeasurementEventListener(this.zzc);
    }
}
