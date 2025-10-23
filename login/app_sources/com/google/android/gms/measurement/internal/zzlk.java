package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlk implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzo zze;
    private final /* synthetic */ boolean zzf;
    private final /* synthetic */ zzkq zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlk(zzkq zzkqVar, AtomicReference atomicReference, String str, String str2, String str3, zzo zzoVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzoVar;
        this.zzf = z;
        this.zzg = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfiVar = this.zzg.zzb;
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; remote exception", zzfp.zza(this.zzb), this.zzc, e);
                this.zza.set(Collections.emptyList());
            }
            if (zzfiVar == null) {
                this.zzg.zzj().zzg().zza("(legacy) Failed to get user properties; not connected to service", zzfp.zza(this.zzb), this.zzc, this.zzd);
                this.zza.set(Collections.emptyList());
                return;
            }
            if (TextUtils.isEmpty(this.zzb)) {
                Preconditions.checkNotNull(this.zze);
                this.zza.set(zzfiVar.zza(this.zzc, this.zzd, this.zzf, this.zze));
            } else {
                this.zza.set(zzfiVar.zza(this.zzb, this.zzc, this.zzd, this.zzf));
            }
            this.zzg.zzam();
            this.zza.notify();
        }
    }
}
