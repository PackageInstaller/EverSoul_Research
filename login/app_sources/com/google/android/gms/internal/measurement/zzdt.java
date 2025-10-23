package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzdt extends zzdf.zza {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzdf zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdt(zzdf zzdfVar, String str) {
        super(zzdfVar);
        this.zzc = str;
        this.zzd = zzdfVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzdf.zza
    final void zza() throws RemoteException {
        zzcu zzcuVar;
        zzcuVar = this.zzd.zzj;
        ((zzcu) Preconditions.checkNotNull(zzcuVar)).endAdUnitExposure(this.zzc, this.zzb);
    }
}
