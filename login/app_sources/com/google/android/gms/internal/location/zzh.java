package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzh implements zzbg<zzam> {
    final /* synthetic */ zzi zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzh(zzi zziVar) {
        this.zza = zziVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzam zza() throws DeadObjectException {
        return (zzam) this.zza.getService();
    }
}
