package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlb implements Runnable {
    private final /* synthetic */ zzbe zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zzc;
    private final /* synthetic */ zzkq zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlb(zzkq zzkqVar, zzbe zzbeVar, String str, com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        this.zza = zzbeVar;
        this.zzb = str;
        this.zzc = zzcvVar;
        this.zzd = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        try {
            zzfiVar = this.zzd.zzb;
            if (zzfiVar == null) {
                this.zzd.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] zza = zzfiVar.zza(this.zza, this.zzb);
            this.zzd.zzam();
            this.zzd.zzq().zza(this.zzc, zza);
        } catch (RemoteException e) {
            this.zzd.zzj().zzg().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzq().zza(this.zzc, (byte[]) null);
        }
    }
}
