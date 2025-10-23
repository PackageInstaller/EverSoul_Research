package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzkh extends zze {
    protected zzki zza;
    private volatile zzki zzb;
    private volatile zzki zzc;
    private final Map<Activity, zzki> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzki zzg;
    private zzki zzh;
    private boolean zzi;
    private final Object zzj;

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
    private final zzki zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzki zzkiVar = this.zzd.get(activity);
        if (zzkiVar == null) {
            zzki zzkiVar2 = new zzki(null, zza(activity.getClass(), "Activity"), zzq().zzm());
            this.zzd.put(activity, zzkiVar2);
            zzkiVar = zzkiVar2;
        }
        return this.zzg != null ? this.zzg : zzkiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzki zzaa() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzki zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzki zzkiVar = this.zza;
        return zzkiVar != null ? zzkiVar : this.zzh;
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
    private final String zza(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] split = canonicalName.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > zze().zza((String) null, false) ? str2.substring(0, zze().zza((String) null, false)) : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzkh zzkhVar, Bundle bundle, zzki zzkiVar, zzki zzkiVar2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzkhVar.zza(zzkiVar, zzkiVar2, j, true, zzkhVar.zzq().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzkh(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(Activity activity, zzki zzkiVar, boolean z) {
        zzki zzkiVar2;
        zzki zzkiVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzkiVar.zzb == null) {
            zzkiVar2 = new zzki(zzkiVar.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzkiVar.zzc, zzkiVar.zze, zzkiVar.zzf);
        } else {
            zzkiVar2 = zzkiVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzkiVar2;
        zzl().zzb(new zzkj(this, zzkiVar2, zzkiVar3, zzb().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzki zzkiVar, zzki zzkiVar2, long j, boolean z, Bundle bundle) {
        zzt();
        boolean z2 = false;
        boolean z3 = (zzkiVar2 != null && zzkiVar2.zzc == zzkiVar.zzc && Objects.equals(zzkiVar2.zzb, zzkiVar.zzb) && Objects.equals(zzkiVar2.zza, zzkiVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzng.zza(zzkiVar, bundle2, true);
            if (zzkiVar2 != null) {
                if (zzkiVar2.zza != null) {
                    bundle2.putString("_pn", zzkiVar2.zza);
                }
                if (zzkiVar2.zzb != null) {
                    bundle2.putString("_pc", zzkiVar2.zzb);
                }
                bundle2.putLong("_pi", zzkiVar2.zzc);
            }
            if (z2) {
                long zza = zzp().zzb.zza(j);
                if (zza > 0) {
                    zzq().zza(bundle2, zza);
                }
            }
            if (!zze().zzv()) {
                bundle2.putLong("_mst", 1L);
            }
            zzm().zza(zzkiVar.zze ? "app" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_vs", (!zzkiVar.zze || zzkiVar.zzf == 0) ? zzb().currentTimeMillis() : zzkiVar.zzf, bundle2);
        }
        if (z2) {
            zza(this.zza, true, j);
        }
        this.zza = zzkiVar;
        if (zzkiVar.zze) {
            this.zzh = zzkiVar;
        }
        zzo().zza(zzkiVar);
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
    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zze().zzv() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzki(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzv()) {
            this.zzd.remove(activity);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzv()) {
            this.zzb = null;
            zzl().zzb(new zzkl(this, elapsedRealtime));
        } else {
            zzki zzd = zzd(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            zzl().zzb(new zzko(this, zzd, elapsedRealtime));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzv()) {
                    this.zzg = null;
                    zzl().zzb(new zzkn(this));
                }
            }
        }
        if (!zze().zzv()) {
            this.zzb = this.zzg;
            zzl().zzb(new zzkm(this));
        } else {
            zza(activity, zzd(activity), false);
            zzb zzc = zzc();
            zzc.zzl().zzb(new zzc(zzc, zzc.zzb().elapsedRealtime()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Activity activity, Bundle bundle) {
        zzki zzkiVar;
        if (!zze().zzv() || bundle == null || (zzkiVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzkiVar.zzc);
        bundle2.putString("name", zzkiVar.zza);
        bundle2.putString("referrer_name", zzkiVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzki zzkiVar, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (!zzp().zza(zzkiVar != null && zzkiVar.zzd, z, j) || zzkiVar == null) {
            return;
        }
        zzkiVar.zzd = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zze().zzv()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzki zzkiVar = this.zzb;
        if (zzkiVar == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass(), "Activity");
        }
        boolean equals = Objects.equals(zzkiVar.zzb, str2);
        boolean equals2 = Objects.equals(zzkiVar.zza, str);
        if (equals && equals2) {
            zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > zze().zza((String) null, false))) {
            zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
        zzki zzkiVar2 = new zzki(str, str2, zzq().zzm());
        this.zzd.put(activity, zzkiVar2);
        zza(activity, zzkiVar2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Bundle bundle, long j) {
        String str;
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzj().zzv().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String str2 = null;
            if (bundle != null) {
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > zze().zza((String) null, false))) {
                    zzj().zzv().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    str2 = string2;
                }
            } else {
                str = null;
            }
            if (str2 == null) {
                Activity activity = this.zze;
                str2 = activity != null ? zza(activity.getClass(), "Activity") : "Activity";
            }
            String str3 = str2;
            zzki zzkiVar = this.zzb;
            if (this.zzf && zzkiVar != null) {
                this.zzf = false;
                boolean equals = Objects.equals(zzkiVar.zzb, str3);
                boolean equals2 = Objects.equals(zzkiVar.zza, str);
                if (equals && equals2) {
                    zzj().zzv().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzj().zzp().zza("Logging screen view with name, class", str == null ? "null" : str, str3 == null ? "null" : str3);
            zzki zzkiVar2 = this.zzb == null ? this.zzc : this.zzb;
            zzki zzkiVar3 = new zzki(str, str3, zzq().zzm(), true, j);
            this.zzb = zzkiVar3;
            this.zzc = zzkiVar2;
            this.zzg = zzkiVar3;
            zzl().zzb(new zzkk(this, bundle, zzkiVar3, zzkiVar2, zzb().elapsedRealtime()));
        }
    }
}
