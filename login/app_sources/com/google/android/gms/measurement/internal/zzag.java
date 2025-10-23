package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzoq;
import com.google.android.gms.internal.measurement.zzov;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzag extends zzib {
    private Boolean zza;
    private String zzb;
    private zzai zzc;
    private Boolean zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final double zza(String str, zzfg<Double> zzfgVar) {
        if (str == null) {
            return zzfgVar.zza(null).doubleValue();
        }
        String zza = this.zzc.zza(str, zzfgVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzfgVar.zza(null).doubleValue();
        }
        try {
            return zzfgVar.zza(Double.valueOf(Double.parseDouble(zza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfgVar.zza(null).doubleValue();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zzc() {
        return (zzov.zza() && zze().zzf(null, zzbg.zzcb) && zzq().zza(231100000, true)) ? 35 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zza(String str) {
        return zza(str, zzbg.zzah, 500, 2000);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zza(String str, boolean z) {
        if (!zzoq.zza() || !zze().zzf(null, zzbg.zzcu)) {
            return 100;
        }
        if (z) {
            return zza(str, zzbg.zzar, 100, 500);
        }
        return 500;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zzb(String str, boolean z) {
        return Math.max(zza(str, z), 256);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzg() {
        return zzq().zza(201500000, true) ? 100 : 25;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb(String str) {
        return zza(str, zzbg.zzai, 25, 100);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzc(String str) {
        return zzb(str, zzbg.zzo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb(String str, zzfg<Integer> zzfgVar) {
        if (str == null) {
            return zzfgVar.zza(null).intValue();
        }
        String zza = this.zzc.zza(str, zzfgVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzfgVar.zza(null).intValue();
        }
        try {
            return zzfgVar.zza(Integer.valueOf(Integer.parseInt(zza))).intValue();
        } catch (NumberFormatException unused) {
            return zzfgVar.zza(null).intValue();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza(String str, zzfg<Integer> zzfgVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzfgVar), i2), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final long zzd(String str) {
        return zzc(str, zzbg.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zzh() {
        return zzbg.zzd.zza(null).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zzm() {
        return zzbg.zzad.zza(null).longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zzc(String str, zzfg<Long> zzfgVar) {
        if (str == null) {
            return zzfgVar.zza(null).longValue();
        }
        String zza = this.zzc.zza(str, zzfgVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzfgVar.zza(null).longValue();
        }
        try {
            return zzfgVar.zza(Long.valueOf(Long.parseLong(zza))).longValue();
        } catch (NumberFormatException unused) {
            return zzfgVar.zza(null).longValue();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bundle zzz() {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo == null) {
                zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzng zzq() {
        return super.zzq();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Boolean zze(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (zzz.containsKey(str)) {
            return Boolean.valueOf(zzz.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzn() {
        return zza("debug.firebase.analytics.app", "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzo() {
        return zza("debug.deferred.deeplink", "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzd(String str, zzfg<String> zzfgVar) {
        if (str == null) {
            return zzfgVar.zza(null);
        }
        return zzfgVar.zza(this.zzc.zza(str, zzfgVar.zza()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzp() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzf(String str) {
        return zzd(str, zzbg.zzal);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zza(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            zzj().zzg().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List<java.lang.String> zzg(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzfp r4 = r3.zzj()
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzg()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zza()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfp r0 = r3.zzj()
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzg()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
            fill-array 0x0052: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.zzg(java.lang.String):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzag(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzb = "";
        this.zzc = new zzai() { // from class: com.google.android.gms.measurement.internal.zzaf
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.measurement.internal.zzai
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(zzai zzaiVar) {
        this.zzc = zzaiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzu() {
        Boolean zze = zze("google_analytics_adid_collection_enabled");
        return zze == null || zze.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzh(String str) {
        return zzf(str, zzbg.zzak);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzfg<Boolean> zzfgVar) {
        return zzf(null, zzfgVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zze(String str, zzfg<Boolean> zzfgVar) {
        return zzf(str, zzfgVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzf(String str, zzfg<Boolean> zzfgVar) {
        if (str == null) {
            return zzfgVar.zza(null).booleanValue();
        }
        String zza = this.zzc.zza(str, zzfgVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzfgVar.zza(null).booleanValue();
        }
        return zzfgVar.zza(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza))).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzi(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "gaia_collection_enabled"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzv() {
        Boolean zze = zze("google_analytics_automatic_screen_reporting_enabled");
        return zze == null || zze.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzw() {
        Boolean zze = zze("firebase_analytics_collection_deactivated");
        return zze != null && zze.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzj(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.zzc.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzx() {
        if (this.zza == null) {
            Boolean zze = zze("app_measurement_lite");
            this.zza = zze;
            if (zze == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzag();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzd == null) {
            synchronized (this) {
                if (this.zzd == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzd = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }
}
