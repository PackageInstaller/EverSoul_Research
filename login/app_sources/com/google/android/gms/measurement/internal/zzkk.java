package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkk implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzki zzb;
    private final /* synthetic */ zzki zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzkh zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkk(zzkh zzkhVar, Bundle bundle, zzki zzkiVar, zzki zzkiVar2, long j) {
        this.zza = bundle;
        this.zzb = zzkiVar;
        this.zzc = zzkiVar2;
        this.zzd = j;
        this.zze = zzkhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzkh.zza(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
