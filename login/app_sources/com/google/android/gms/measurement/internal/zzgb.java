package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.measurement.internal.zzif;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgb extends zzia {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private long zzaa;
    public zzgf zzb;
    public final zzgg zzc;
    public final zzgg zzd;
    public final zzgh zze;
    public final zzgg zzf;
    public final zzge zzg;
    public final zzgh zzh;
    public final zzgd zzi;
    public final zzge zzj;
    public final zzgg zzk;
    public final zzgg zzl;
    public boolean zzm;
    public zzge zzn;
    public zzge zzo;
    public zzgg zzp;
    public final zzgh zzq;
    public final zzgh zzr;
    public final zzgg zzs;
    public final zzgd zzt;
    private SharedPreferences zzv;
    private Object zzw;
    private SharedPreferences zzx;
    private String zzy;
    private boolean zzz;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final SharedPreferences zzc() {
        zzt();
        zzac();
        if (this.zzx == null) {
            synchronized (this.zzw) {
                if (this.zzx == null) {
                    this.zzx = zza().getSharedPreferences(zza().getPackageName() + "_preferences", 0);
                }
            }
        }
        return this.zzx;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzia
    protected final boolean zzo() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final SharedPreferences zzg() {
        zzt();
        zzac();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Pair<String, Boolean> zza(String str) {
        zzt();
        if (zzny.zza() && zze().zza(zzbg.zzck) && !zzn().zza(zzif.zza.AD_STORAGE)) {
            return new Pair<>("", false);
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (this.zzy != null && elapsedRealtime < this.zzaa) {
            return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
        }
        this.zzaa = elapsedRealtime + zze().zzd(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            this.zzy = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzy = id;
            }
            this.zzz = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            this.zzy = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzy, Boolean.valueOf(this.zzz));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final SparseArray<Long> zzh() {
        Bundle zza2 = this.zzi.zza();
        if (zza2 == null) {
            return new SparseArray<>();
        }
        int[] intArray = zza2.getIntArray("uriSources");
        long[] longArray = zza2.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzav zzm() {
        zzt();
        return zzav.zza(zzg().getString("dma_consent_settings", null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzif zzn() {
        zzt();
        return zzif.zza(zzg().getString("consent_settings", "G1"), zzg().getInt("consent_source", 100));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Boolean zzp() {
        zzt();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Boolean zzu() {
        zzt();
        if (zzg().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Boolean zzv() {
        zzt();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final String zzw() {
        zzt();
        String string = zzg().getString("previous_os_version", null);
        zzf().zzac();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzx() {
        zzt();
        return zzg().getString("admob_app_id", null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzy() {
        zzt();
        return zzg().getString("gmp_app_id", null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgb(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzw = new Object();
        this.zzf = new zzgg(this, "session_timeout", 1800000L);
        this.zzg = new zzge(this, "start_new_session", true);
        this.zzk = new zzgg(this, "last_pause_time", 0L);
        this.zzl = new zzgg(this, SDKAnalyticsEvents.PARAMETER_SESSION_ID, 0L);
        this.zzh = new zzgh(this, "non_personalized_ads", null);
        this.zzi = new zzgd(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzge(this, "allow_remote_dynamite", false);
        this.zzc = new zzgg(this, "first_open_time", 0L);
        this.zzd = new zzgg(this, "app_install_time", 0L);
        this.zze = new zzgh(this, "app_instance_id", null);
        this.zzn = new zzge(this, "app_backgrounded", false);
        this.zzo = new zzge(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzgg(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzgh(this, "firebase_feature_rollouts", null);
        this.zzr = new zzgh(this, "deferred_attribution_cache", null);
        this.zzs = new zzgg(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzgd(this, "default_event_parameters", null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzz() {
        zzt();
        Boolean zzv = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv != null) {
            zza(zzv);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzia
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzaa() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzv.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzgf(this, "health_monitor", Math.max(0L, zzbg.zzc.zza(null).longValue()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(String str) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzc(String str) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled_from_api");
        }
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(boolean z) {
        zzt();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(boolean z) {
        zzt();
        zzj().zzp().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzab() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(zzif zzifVar) {
        zzt();
        int zza2 = zzifVar.zza();
        if (!zza(zza2)) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("consent_settings", zzifVar.zze());
        edit.putInt("consent_source", zza2);
        edit.apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(zzav zzavVar) {
        zzt();
        if (!zzif.zza(zzavVar.zza(), zzm().zza())) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("dma_consent_settings", zzavVar.zzf());
        edit.apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(int i) {
        return zzif.zza(i, zzg().getInt("consent_source", 100));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean zza(zzmf zzmfVar) {
        zzt();
        String string = zzg().getString("stored_tcf_param", "");
        String zzc = zzmfVar.zzc();
        if (zzc.equals(string)) {
            return false;
        }
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("stored_tcf_param", zzc);
        edit.apply();
        return true;
    }
}
