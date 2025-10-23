package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlh implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzo zzc;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zzd;
    private final /* synthetic */ zzkq zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlh(zzkq zzkqVar, String str, String str2, zzo zzoVar, com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzoVar;
        this.zzd = zzcvVar;
        this.zze = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfiVar = this.zze.zzb;
            if (zzfiVar == null) {
                this.zze.zzj().zzg().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            ArrayList<Bundle> zzb = zzng.zzb(zzfiVar.zza(this.zza, this.zzb, this.zzc));
            this.zze.zzam();
            this.zze.zzq().zza(this.zzd, zzb);
        } catch (RemoteException e) {
            this.zze.zzj().zzg().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } finally {
            this.zze.zzq().zza(this.zzd, arrayList);
        }
    }
}
