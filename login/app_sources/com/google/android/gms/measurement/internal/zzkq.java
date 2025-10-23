package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzkq extends zze {
    private final zzlj zza;
    private zzfi zzb;
    private volatile Boolean zzc;
    private final zzat zzd;
    private final zzmi zze;
    private final List<Runnable> zzf;
    private final zzat zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzo zzb(boolean z) {
        return zzg().zza(z ? zzj().zzx() : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final zzaj zzaa() {
        zzt();
        zzu();
        zzfi zzfiVar = this.zzb;
        if (zzfiVar == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzo zzb = zzb(false);
        Preconditions.checkNotNull(zzb);
        try {
            zzaj zza = zzfiVar.zza(zzb);
            zzam();
            return zza;
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to get consents; remote exception", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzay zzf() {
        return super.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfj zzg() {
        return super.zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfm zzh() {
        return super.zzh();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzfo zzi() {
        return super.zzi();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzfp zzj() {
        return super.zzj();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzgb zzk() {
        return super.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzgw zzl() {
        return super.zzl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzio zzm() {
        return super.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkh zzn() {
        return super.zzn();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkq zzo() {
        return super.zzo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzly zzp() {
        return super.zzp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzng zzq() {
        return super.zzq();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Boolean zzab() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzd(zzkq zzkqVar) {
        zzkqVar.zzt();
        if (zzkqVar.zzah()) {
            zzkqVar.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzkqVar.zzae();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzkq zzkqVar, ComponentName componentName) {
        zzkqVar.zzt();
        if (zzkqVar.zzb != null) {
            zzkqVar.zzb = null;
            zzkqVar.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzkqVar.zzt();
            zzkqVar.zzad();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzkq(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzf = new ArrayList();
        this.zze = new zzmi(zzhdVar.zzb());
        this.zza = new zzlj(this);
        this.zzd = new zzkp(this, zzhdVar);
        this.zzg = new zzlc(this, zzhdVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzac() {
        zzt();
        zzu();
        zzo zzb = zzb(true);
        zzh().zzab();
        zza(new zzkx(this, zzb));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzad() {
        zzt();
        zzu();
        if (zzah()) {
            return;
        }
        if (zzak()) {
            this.zza.zza();
            return;
        }
        if (zze().zzx()) {
            return;
        }
        List<ResolveInfo> queryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if ((queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzae() {
        zzt();
        zzu();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzal() {
        zzt();
        zzj().zzp().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (RuntimeException e) {
                zzj().zzg().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        zzt();
        zzu();
        zza(new zzky(this, zzb(false), zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza(new zzkv(this, atomicReference, zzb(false)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(com.google.android.gms.internal.measurement.zzcv zzcvVar, String str, String str2) {
        zzt();
        zzu();
        zza(new zzlh(this, str, str2, zzb(false), zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(AtomicReference<List<zzae>> atomicReference, String str, String str2, String str3) {
        zzt();
        zzu();
        zza(new zzli(this, atomicReference, str, str2, str3, zzb(false)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(AtomicReference<List<zzmh>> atomicReference, Bundle bundle) {
        zzt();
        zzu();
        zza(new zzku(this, atomicReference, zzb(false), bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(AtomicReference<List<zznb>> atomicReference, boolean z) {
        zzt();
        zzu();
        zza(new zzkr(this, atomicReference, zzb(false), z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(com.google.android.gms.internal.measurement.zzcv zzcvVar, String str, String str2, boolean z) {
        zzt();
        zzu();
        zza(new zzks(this, str, str2, zzb(false), z, zzcvVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(AtomicReference<List<zznb>> atomicReference, String str, String str2, String str3, boolean z) {
        zzt();
        zzu();
        zza(new zzlk(this, atomicReference, str, str2, str3, zzb(false), z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(zzbe zzbeVar, String str) {
        Preconditions.checkNotNull(zzbeVar);
        zzt();
        zzu();
        zza(new zzlg(this, true, zzb(true), zzh().zza(zzbeVar), zzbeVar, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(com.google.android.gms.internal.measurement.zzcv zzcvVar, zzbe zzbeVar, String str) {
        zzt();
        zzu();
        if (zzq().zza(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzcvVar, new byte[0]);
        } else {
            zza(new zzlb(this, zzbeVar, str, zzcvVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzam() {
        zzt();
        this.zze.zzb();
        this.zzd.zza(zzbg.zzaj.zza(null).longValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzaf() {
        zzt();
        zzu();
        zzo zzb = zzb(false);
        zzh().zzaa();
        zza(new zzkw(this, zzb));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzah()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzj().zzg().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(DateUtils.MILLIS_PER_MINUTE);
            zzad();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(zzfi zzfiVar, AbstractSafeParcelable abstractSafeParcelable, zzo zzoVar) {
        int i;
        zzt();
        zzu();
        int i2 = 100;
        int i3 = 0;
        while (i3 < 1001 && i2 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza = zzh().zza(100);
            if (zza != null) {
                arrayList.addAll(zza);
                i = zza.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbe) {
                    try {
                        zzfiVar.zza((zzbe) abstractSafeParcelable2, zzoVar);
                    } catch (RemoteException e) {
                        zzj().zzg().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zznb) {
                    try {
                        zzfiVar.zza((zznb) abstractSafeParcelable2, zzoVar);
                    } catch (RemoteException e2) {
                        zzj().zzg().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzae) {
                    try {
                        zzfiVar.zza((zzae) abstractSafeParcelable2, zzoVar);
                    } catch (RemoteException e3) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i2 = i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(zzae zzaeVar) {
        Preconditions.checkNotNull(zzaeVar);
        zzt();
        zzu();
        zza(new zzlf(this, true, zzb(true), zzh().zza(zzaeVar), new zzae(zzaeVar), zzaeVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(boolean z) {
        zzt();
        zzu();
        if (z) {
            zzh().zzaa();
        }
        if (zzaj()) {
            zza(new zzld(this, zzb(false)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(zzki zzkiVar) {
        zzt();
        zzu();
        zza(new zzla(this, zzkiVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza(new zzkz(this, zzb(false), bundle));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzag() {
        zzt();
        zzu();
        zza(new zzle(this, zzb(true)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(zzfi zzfiVar) {
        zzt();
        Preconditions.checkNotNull(zzfiVar);
        this.zzb = zzfiVar;
        zzam();
        zzal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(zznb zznbVar) {
        zzt();
        zzu();
        zza(new zzkt(this, zzb(true), zzh().zza(zznbVar), zznbVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzah() {
        zzt();
        zzu();
        return this.zzb != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzai() {
        zzt();
        zzu();
        return !zzak() || zzq().zzg() >= 200900;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzaj() {
        zzt();
        zzu();
        return !zzak() || zzq().zzg() >= zzbg.zzbm.zza(null).intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f5  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean zzak() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkq.zzak():boolean");
    }
}
