package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkj implements Runnable {
    private final /* synthetic */ zzki zza;
    private final /* synthetic */ zzki zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzkh zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkj(zzkh zzkhVar, zzki zzkiVar, zzki zzkiVar2, long j, boolean z) {
        this.zza = zzkiVar;
        this.zzb = zzkiVar2;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzkhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
