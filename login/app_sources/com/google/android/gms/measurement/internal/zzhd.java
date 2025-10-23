package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zzok;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public class zzhd implements zzid {
    private static volatile zzhd zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private int zzah;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzab zzh;
    private final zzag zzi;
    private final zzgb zzj;
    private final zzfp zzk;
    private final zzgw zzl;
    private final zzly zzm;
    private final zzng zzn;
    private final zzfo zzo;
    private final Clock zzp;
    private final zzkh zzq;
    private final zzio zzr;
    private final zzb zzs;
    private final zzkc zzt;
    private final String zzu;
    private zzfm zzv;
    private zzkq zzw;
    private zzay zzx;
    private zzfj zzy;
    private boolean zzz = false;
    private AtomicInteger zzai = new AtomicInteger(0);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzc() {
        zzl().zzt();
        if (this.zzi.zzw()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzad()) {
            return 8;
        }
        Boolean zzv = zzn().zzv();
        if (zzv != null) {
            return zzv.booleanValue() ? 0 : 3;
        }
        Boolean zze = this.zzi.zze("firebase_analytics_collection_enabled");
        if (zze != null) {
            return zze.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzad;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzid
    @Pure
    public final Context zza() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzid
    @Pure
    public final Clock zzb() {
        return this.zzp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzb zze() {
        zzb zzbVar = this.zzs;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzid
    @Pure
    public final zzab zzd() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzag zzf() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzay zzg() {
        zza((zzia) this.zzx);
        return this.zzx;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzfj zzh() {
        zza((zze) this.zzy);
        return this.zzy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzfm zzi() {
        zza((zze) this.zzv);
        return this.zzv;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzfo zzk() {
        return this.zzo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzid
    @Pure
    public final zzfp zzj() {
        zza((zzia) this.zzk);
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzfp zzm() {
        zzfp zzfpVar = this.zzk;
        if (zzfpVar == null || !zzfpVar.zzaf()) {
            return null;
        }
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzgb zzn() {
        zza((zzib) this.zzj);
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzid
    @Pure
    public final zzgw zzl() {
        zza((zzia) this.zzl);
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SideEffectFree
    final zzgw zzo() {
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzhd zza(Context context, com.google.android.gms.internal.measurement.zzdd zzddVar, Long l) {
        if (zzddVar != null && (zzddVar.zze == null || zzddVar.zzf == null)) {
            zzddVar = new com.google.android.gms.internal.measurement.zzdd(zzddVar.zza, zzddVar.zzb, zzddVar.zzc, zzddVar.zzd, null, null, zzddVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzhd.class) {
                if (zzb == null) {
                    zzb = new zzhd(new zzim(context, zzddVar, l));
                }
            }
        } else if (zzddVar != null && zzddVar.zzg != null && zzddVar.zzg.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzddVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzio zzp() {
        zza((zze) this.zzr);
        return this.zzr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    private final zzkc zzai() {
        zza((zzia) this.zzt);
        return this.zzt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzkh zzq() {
        zza((zze) this.zzq);
        return this.zzq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzkq zzr() {
        zza((zze) this.zzw);
        return this.zzw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzly zzs() {
        zza((zze) this.zzm);
        return this.zzm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final zzng zzt() {
        zza((zzib) this.zzn);
        return this.zzn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final String zzu() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final String zzv() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final String zzw() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final String zzx() {
        return this.zzu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzhd zzhdVar, zzim zzimVar) {
        zzhdVar.zzl().zzt();
        zzay zzayVar = new zzay(zzhdVar);
        zzayVar.zzad();
        zzhdVar.zzx = zzayVar;
        zzfj zzfjVar = new zzfj(zzhdVar, zzimVar.zzf);
        zzfjVar.zzv();
        zzhdVar.zzy = zzfjVar;
        zzfm zzfmVar = new zzfm(zzhdVar);
        zzfmVar.zzv();
        zzhdVar.zzv = zzfmVar;
        zzkq zzkqVar = new zzkq(zzhdVar);
        zzkqVar.zzv();
        zzhdVar.zzw = zzkqVar;
        zzhdVar.zzn.zzae();
        zzhdVar.zzj.zzae();
        zzhdVar.zzy.zzw();
        zzhdVar.zzj().zzn().zza("App measurement initialized, version", 84002L);
        zzhdVar.zzj().zzn().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzad = zzfjVar.zzad();
        if (TextUtils.isEmpty(zzhdVar.zzd)) {
            if (zzhdVar.zzt().zzf(zzad)) {
                zzhdVar.zzj().zzn().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhdVar.zzj().zzn().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + zzad);
            }
        }
        zzhdVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzhdVar.zzag != zzhdVar.zzai.get()) {
            zzhdVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhdVar.zzag), Integer.valueOf(zzhdVar.zzai.get()));
        }
        zzhdVar.zzz = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzhd(zzim zzimVar) {
        long currentTimeMillis;
        boolean z = false;
        Preconditions.checkNotNull(zzimVar);
        zzab zzabVar = new zzab(zzimVar.zza);
        this.zzh = zzabVar;
        zzfd.zza = zzabVar;
        Context context = zzimVar.zza;
        this.zzc = context;
        this.zzd = zzimVar.zzb;
        this.zze = zzimVar.zzc;
        this.zzf = zzimVar.zzd;
        this.zzg = zzimVar.zzh;
        this.zzac = zzimVar.zze;
        this.zzu = zzimVar.zzj;
        this.zzaf = true;
        com.google.android.gms.internal.measurement.zzdd zzddVar = zzimVar.zzg;
        if (zzddVar != null && zzddVar.zzg != null) {
            Object obj = zzddVar.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzddVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzgv.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        if (zzimVar.zzi != null) {
            currentTimeMillis = zzimVar.zzi.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        this.zzi = new zzag(this);
        zzgb zzgbVar = new zzgb(this);
        zzgbVar.zzad();
        this.zzj = zzgbVar;
        zzfp zzfpVar = new zzfp(this);
        zzfpVar.zzad();
        this.zzk = zzfpVar;
        zzng zzngVar = new zzng(this);
        zzngVar.zzad();
        this.zzn = zzngVar;
        this.zzo = new zzfo(new zzil(zzimVar, this));
        this.zzs = new zzb(this);
        zzkh zzkhVar = new zzkh(this);
        zzkhVar.zzv();
        this.zzq = zzkhVar;
        zzio zzioVar = new zzio(this);
        zzioVar.zzv();
        this.zzr = zzioVar;
        zzly zzlyVar = new zzly(this);
        zzlyVar.zzv();
        this.zzm = zzlyVar;
        zzkc zzkcVar = new zzkc(this);
        zzkcVar.zzad();
        this.zzt = zzkcVar;
        zzgw zzgwVar = new zzgw(this);
        zzgwVar.zzad();
        this.zzl = zzgwVar;
        if (zzimVar.zzg != null && zzimVar.zzg.zzb != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zzio zzp = zzp();
            if (zzp.zza().getApplicationContext() instanceof Application) {
                Application application = (Application) zzp.zza().getApplicationContext();
                if (zzp.zza == null) {
                    zzp.zza = new zzjx(zzp);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzp.zza);
                    application.registerActivityLifecycleCallbacks(zzp.zza);
                    zzp.zzj().zzp().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzj().zzu().zza("Application context is not an Application");
        }
        zzgwVar.zzb(new zzhe(this, zzimVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(zzib zzibVar) {
        if (zzibVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(zze zzeVar) {
        if (zzeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzeVar.zzy()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zzeVar.getClass()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(zzia zziaVar) {
        if (zziaVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zziaVar.zzaf()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(zziaVar.getClass()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzy() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzz() {
        this.zzai.incrementAndGet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzj().zzu().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzn().zzo.zza(true);
        if (bArr == null || bArr.length == 0) {
            zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "");
            String optString2 = jSONObject.optString("gclid", "");
            String optString3 = jSONObject.optString("gbraid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzj().zzc().zza("Deferred Deep Link is empty.");
                return;
            }
            Bundle bundle = new Bundle();
            if (zzok.zza() && this.zzi.zza(zzbg.zzcs)) {
                if (!zzt().zzi(optString)) {
                    zzj().zzu().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                    return;
                }
                bundle.putString("gbraid", optString3);
            } else if (!zzt().zzi(optString)) {
                zzj().zzu().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zzng zzt = zzt();
            if (TextUtils.isEmpty(optString) || !zzt.zza(optString, optDouble)) {
                return;
            }
            zzt.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzaa() {
        this.zzag++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(boolean z) {
        zzl().zzt();
        this.zzaf = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x00d8, code lost:
    
        if (r1.zzi() != false) goto L37;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zza(com.google.android.gms.internal.measurement.zzdd r10) {
        /*
            Method dump skipped, instructions count: 1080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhd.zza(com.google.android.gms.internal.measurement.zzdd):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzab() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzac() {
        return zzc() == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzad() {
        zzl().zzt();
        return this.zzaf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final boolean zzae() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean zzaf() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzt();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(zzt().zze("android.permission.INTERNET") && zzt().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzx() || (zzng.zza(this.zzc) && zzng.zza(this.zzc, false))));
            this.zzaa = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzt().zza(zzh().zzae(), zzh().zzac()) && TextUtils.isEmpty(zzh().zzac())) {
                    z = false;
                }
                this.zzaa = Boolean.valueOf(z);
            }
        }
        return this.zzaa.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Pure
    public final boolean zzag() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzah() {
        zzl().zzt();
        zza((zzia) zzai());
        String zzad = zzh().zzad();
        Pair<String, Boolean> zza = zzn().zza(zzad);
        if (!this.zzi.zzu() || ((Boolean) zza.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza.first)) {
            zzj().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzai().zzc()) {
            zzj().zzu().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        if (zzns.zza() && this.zzi.zza(zzbg.zzcn)) {
            zzkq zzr = zzr();
            zzr.zzt();
            zzr.zzu();
            if (!zzr.zzak() || zzr.zzq().zzg() >= 234200) {
                zzio zzp = zzp();
                zzp.zzt();
                zzaj zzaa = zzp.zzo().zzaa();
                Bundle bundle = zzaa != null ? zzaa.zza : null;
                if (bundle == null) {
                    int i = this.zzah;
                    this.zzah = i + 1;
                    boolean z = i < 10;
                    zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzah));
                    return z;
                }
                sb.append("&gcs=").append(zzif.zza(bundle, 100).zze());
                zzav zza2 = zzav.zza(bundle, 100);
                sb.append("&dma=").append(zza2.zzd() == Boolean.FALSE ? 0 : 1);
                if (!TextUtils.isEmpty(zza2.zze())) {
                    sb.append("&dma_cps=").append(zza2.zze());
                }
                sb.append("&npa=").append(zzav.zza(bundle) == Boolean.TRUE ? 0 : 1);
                zzj().zzp().zza("Consent query parameters to Bow", sb);
            }
        }
        zzng zzt = zzt();
        zzh();
        URL zza3 = zzt.zza(84002L, zzad, (String) zza.first, zzn().zzp.zza() - 1, sb.toString());
        if (zza3 != null) {
            zzkc zzai = zzai();
            zzkb zzkbVar = new zzkb() { // from class: com.google.android.gms.measurement.internal.zzhf
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.measurement.internal.zzkb
                public final void zza(String str, int i2, Throwable th, byte[] bArr, Map map) {
                    zzhd.this.zza(str, i2, th, bArr, map);
                }
            };
            zzai.zzt();
            zzai.zzac();
            Preconditions.checkNotNull(zza3);
            Preconditions.checkNotNull(zzkbVar);
            zzai.zzl().zza(new zzke(zzai, zzad, zza3, null, null, zzkbVar));
        }
        return false;
    }
}
