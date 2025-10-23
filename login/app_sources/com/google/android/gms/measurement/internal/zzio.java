package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zzoj;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzph;
import com.google.android.gms.internal.measurement.zzpt;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzif;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import kotlinx.coroutines.DebugKt;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzio extends zze {
    protected zzjx zza;
    final zzr zzb;
    private zzik zzc;
    private final Set<zzij> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private PriorityQueue<zzmh> zzi;
    private zzif zzj;
    private final AtomicLong zzk;
    private long zzl;
    private boolean zzm;
    private zzat zzn;
    private SharedPreferences.OnSharedPreferenceChangeListener zzo;
    private zzat zzp;
    private final zznf zzq;

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
    public final Boolean zzaa() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzix(this, atomicReference));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Double zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzju(this, atomicReference));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzjr(this, atomicReference));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzjs(this, atomicReference));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzae() {
        return this.zzf.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzaf() {
        zzki zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzag() {
        zzki zzaa = this.zzu.zzq().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzah() {
        if (this.zzu.zzu() != null) {
            return this.zzu.zzu();
        }
        try {
            return new zzgx(zza(), this.zzu.zzx()).zza("google_app_id");
        } catch (IllegalStateException e) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzai() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzjk(this, atomicReference));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzjo(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zzng.zzb((List<zzae>) list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<zznb> zza(boolean z) {
        zzu();
        zzj().zzp().zza("Getting user properties (FE)");
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzji(this, atomicReference, z));
        List<zznb> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzj().zzg().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> zza(String str, String str2, boolean z) {
        if (zzl().zzg()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzab.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzjn(this, atomicReference, null, str, str2, z));
        List<zznb> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zznb zznbVar : list) {
            Object zza = zznbVar.zza();
            if (zza != null) {
                arrayMap.put(zznbVar.zza, zza);
            }
        }
        return arrayMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final PriorityQueue<zzmh> zzaq() {
        Comparator comparing;
        if (this.zzi == null) {
            comparing = Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzin
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((zzmh) obj).zzb);
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zziq
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            });
            this.zzi = new PriorityQueue<>(comparing);
        }
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzio zzioVar, zzif zzifVar, zzif zzifVar2) {
        boolean zza = zzifVar.zza(zzifVar2, zzif.zza.ANALYTICS_STORAGE, zzif.zza.AD_STORAGE);
        boolean zzb = zzifVar.zzb(zzifVar2, zzif.zza.ANALYTICS_STORAGE, zzif.zza.AD_STORAGE);
        if (zza || zzb) {
            zzioVar.zzg().zzag();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zza(zzio zzioVar, zzif zzifVar, long j, boolean z, boolean z2) {
        zzioVar.zzt();
        zzioVar.zzu();
        zzif zzn = zzioVar.zzk().zzn();
        if (j <= zzioVar.zzl && zzif.zza(zzn.zza(), zzifVar.zza())) {
            zzioVar.zzj().zzn().zza("Dropped out-of-date consent setting, proposed settings", zzifVar);
            return;
        }
        if (zzioVar.zzk().zza(zzifVar)) {
            zzioVar.zzl = j;
            zzioVar.zzo().zza(z);
            if (z2) {
                zzioVar.zzo().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzioVar.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzifVar.zza()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzio(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzm = true;
        this.zzq = new zzjp(this);
        this.zzf = new AtomicReference<>();
        this.zzj = zzif.zza;
        this.zzl = -1L;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzr(zzhdVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzaj() {
        zzt();
        zzu();
        if (this.zzu.zzaf()) {
            Boolean zze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (zze != null && zze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzit
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzio.this.zzam();
                    }
                });
            }
            zzo().zzac();
            this.zzm = false;
            String zzw = zzk().zzw();
            if (TextUtils.isEmpty(zzw)) {
                return;
            }
            zzf().zzac();
            if (zzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", zzw);
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
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
    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzl().zzb(new zzjl(this, bundle2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzak() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzal() {
        if (zzph.zza() && zze().zza(zzbg.zzcf)) {
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzab.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzu();
            zzj().zzp().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 5000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzip
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    zzio zzioVar = zzio.this;
                    AtomicReference<List<zzmh>> atomicReference2 = atomicReference;
                    Bundle zza = zzioVar.zzk().zzi.zza();
                    zzkq zzo = zzioVar.zzo();
                    if (zza == null) {
                        zza = new Bundle();
                    }
                    zzo.zza(atomicReference2, zza);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzis
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzio.this.zza(list);
                    }
                });
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzam() {
        zzt();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza);
        if (zza >= 5) {
            zzj().zzu().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (zzns.zza() && zze().zza(zzbg.zzcn)) {
                if (this.zzn == null) {
                    this.zzn = new zzjh(this, this.zzu);
                }
                this.zzn.zza(0L);
                return;
            }
            this.zzu.zzah();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzan() {
        zzt();
        zzj().zzc().zza("Handle tcf update.");
        SharedPreferences zzc = zzk().zzc();
        Boolean zze = zze().zze(" google_analytics_tcf_data_enabled");
        zzmf zza = zzmf.zza(zzc, zze == null ? true : zze.booleanValue());
        if (zzk().zza(zza)) {
            Bundle zza2 = zza.zza();
            if (zza2 != Bundle.EMPTY) {
                zza(zza2, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zza.zzb());
            zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_tcf", bundle);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(List list) {
        zzt();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzh = zzk().zzh();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzmh zzmhVar = (zzmh) it.next();
                if (!zzh.contains(zzmhVar.zzc) || zzh.get(zzmhVar.zzc).longValue() < zzmhVar.zzb) {
                    zzaq().add(zzmhVar);
                }
            }
            zzao();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            ((zzat) Preconditions.checkNotNull(this.zzp)).zza(500L);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(Bundle bundle) {
        if (bundle == null) {
            zzk().zzt.zza(new Bundle());
            return;
        }
        Bundle zza = zzk().zzt.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                zzq();
                if (zzng.zza(obj)) {
                    zzq();
                    zzng.zza(this.zzq, 27, (String) null, (String) null, 0);
                }
                zzj().zzv().zza("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzng.zzg(str)) {
                zzj().zzv().zza("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                zza.remove(str);
            } else if (zzq().zza("param", str, zze().zza((String) null, false), obj)) {
                zzq().zza(zza, str, obj);
            }
        }
        zzq();
        if (zzng.zza(zza, zze().zzg())) {
            zzq();
            zzng.zza(this.zzq, 26, (String) null, (String) null, 0);
            zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        zzk().zzt.zza(zza);
        zzo().zza(zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzn().zza(bundle2, j);
        } else {
            zzb(str3, str2, j, bundle2, z2, !z2 || this.zzc == null || zzng.zzg(str2), z, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzs();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzc(String str, String str2, Bundle bundle) {
        zzt();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(String str, String str2, long j, Bundle bundle) {
        zzt();
        zza(str, str2, j, bundle, true, this.zzc == null || zzng.zzg(str2), true, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean zza;
        String str4;
        long j2;
        String str5;
        String str6;
        boolean z4;
        int length;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzt();
        zzu();
        if (!this.zzu.zzac()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzaf = zzg().zzaf();
        if (zzaf != null && !zzaf.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        boolean z5 = true;
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzag()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e) {
                    zzj().zzu().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzn().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            if (bundle.containsKey("gclid")) {
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
            }
            if (zzok.zza() && zze().zza(zzbg.zzcs) && bundle.containsKey("gbraid")) {
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_gbraid", bundle.getString("gbraid"), zzb().currentTimeMillis());
            }
        }
        if (z && zzng.zzj(str2)) {
            zzq().zza(bundle, zzk().zzt.zza());
        }
        if (!z3 && !"_iap".equals(str2)) {
            zzng zzt = this.zzu.zzt();
            int i = 2;
            if (zzt.zzc(NotificationCompat.CATEGORY_EVENT, str2)) {
                if (!zzt.zza(NotificationCompat.CATEGORY_EVENT, zzig.zza, zzig.zzb, str2)) {
                    i = 13;
                } else if (zzt.zza(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                    i = 0;
                }
            }
            if (i != 0) {
                zzj().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzt();
                String zza2 = zzng.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzng.zza(this.zzq, i, "_ev", zza2, length);
                return;
            }
        }
        zzki zza3 = zzn().zza(false);
        if (zza3 != null && !bundle.containsKey("_sc")) {
            zza3.zzd = true;
        }
        zzng.zza(zza3, bundle, z && !z3);
        boolean equals = "am".equals(str);
        boolean zzg = zzng.zzg(str2);
        if (z && this.zzc != null && !zzg && !equals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j);
            return;
        }
        if (this.zzu.zzaf()) {
            int zza4 = zzq().zza(str2);
            if (zza4 != 0) {
                zzj().zzh().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzq();
                String zza5 = zzng.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzt();
                zzng.zza(this.zzq, str3, zza4, "_ev", zza5, length);
                return;
            }
            Bundle zza6 = zzq().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(zza6);
            if (zzn().zza(false) != null && "_ae".equals(str2)) {
                zzme zzmeVar = zzp().zzb;
                long elapsedRealtime = zzmeVar.zzb.zzb().elapsedRealtime();
                long j3 = elapsedRealtime - zzmeVar.zza;
                zzmeVar.zza = elapsedRealtime;
                if (j3 > 0) {
                    zzq().zza(zza6, j3);
                }
            }
            if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str) && "_ssr".equals(str2)) {
                zzng zzq = zzq();
                String string = zza6.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzq.zzk().zzq.zza())) {
                    zzq.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    z4 = false;
                } else {
                    zzq.zzk().zzq.zza(string);
                    z4 = true;
                }
                if (!z4) {
                    return;
                }
            } else if ("_ae".equals(str2)) {
                String zza7 = zzq().zzk().zzq.zza();
                if (!TextUtils.isEmpty(zza7)) {
                    zza6.putString("_ffr", zza7);
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza6);
            if (zze().zza(zzbg.zzcj)) {
                zza = zzp().zzaa();
            } else {
                zza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() > 0 && zzk().zza(j) && zza) {
                zzj().zzp().zza("Current session is expired, remove the session number, ID, and engagement time");
                j2 = 0;
                str4 = "_ae";
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", (Object) null, zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", (Object) null, zzb().currentTimeMillis());
                zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            } else {
                str4 = "_ae";
                j2 = 0;
            }
            if (zza6.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                zzj().zzp().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzu.zzs().zza.zza(j, true);
            }
            ArrayList arrayList2 = new ArrayList(zza6.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                String str7 = (String) obj;
                if (str7 != null) {
                    zzq();
                    Bundle[] zzb = zzng.zzb(zza6.get(str7));
                    if (zzb != null) {
                        zza6.putParcelableArray(str7, zzb);
                    }
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                Bundle bundle2 = (Bundle) arrayList.get(i3);
                if (i3 != 0 ? z5 : false) {
                    str6 = "_ep";
                    str5 = str;
                } else {
                    str5 = str;
                    str6 = str2;
                }
                bundle2.putString("_o", str5);
                if (z2) {
                    bundle2 = zzq().zza(bundle2, (String) null);
                }
                Bundle bundle3 = bundle2;
                zzo().zza(new zzbe(str6, new zzaz(bundle3), str, j), str3);
                if (!equals) {
                    Iterator<zzij> it = this.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle3), j);
                    }
                }
                i3++;
                z5 = true;
            }
            if (zzn().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzp().zza(true, true, zzb().elapsedRealtime());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzao() {
        zzmh poll;
        MeasurementManagerFutures zzn;
        zzt();
        if (zzaq().isEmpty() || this.zzh || (poll = zzaq().poll()) == null || (zzn = zzq().zzn()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzp().zza("Registering trigger URI", poll.zza);
        ListenableFuture<Unit> registerTriggerAsync = zzn.registerTriggerAsync(Uri.parse(poll.zza));
        if (registerTriggerAsync == null) {
            this.zzh = false;
            zzaq().add(poll);
            return;
        }
        SparseArray<Long> zzh = zzk().zzh();
        zzh.put(poll.zzc, Long.valueOf(poll.zzb));
        zzgb zzk = zzk();
        if (zzh == null) {
            zzk.zzi.zza(null);
        } else {
            int[] iArr = new int[zzh.size()];
            long[] jArr = new long[zzh.size()];
            for (int i = 0; i < zzh.size(); i++) {
                iArr[i] = zzh.keyAt(i);
                jArr[i] = zzh.valueAt(i).longValue();
            }
            Bundle bundle = new Bundle();
            bundle.putIntArray("uriSources", iArr);
            bundle.putLongArray("uriTimestamps", jArr);
            zzk.zzi.zza(bundle);
        }
        Futures.addCallback(registerTriggerAsync, new zziz(this, poll), new zzja(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzij zzijVar) {
        zzu();
        Preconditions.checkNotNull(zzijVar);
        if (this.zzd.add(zzijVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener already registered");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzap() {
        zzt();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzo == null) {
            this.zzp = new zzjd(this, this.zzu);
            this.zzo = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zziw
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzio.this.zza(sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(long j, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zzly zzp = zzp();
        zzp.zzt();
        zzp.zzb.zza();
        if (zzpt.zza() && zze().zza(zzbg.zzbq)) {
            zzg().zzag();
        }
        boolean zzac = this.zzu.zzac();
        zzgb zzk = zzk();
        zzk.zzc.zza(j);
        if (!TextUtils.isEmpty(zzk.zzk().zzq.zza())) {
            zzk.zzq.zza(null);
        }
        if (zzoj.zza() && zzk.zze().zza(zzbg.zzbl)) {
            zzk.zzk.zza(0L);
        }
        zzk.zzl.zza(0L);
        if (!zzk.zze().zzw()) {
            zzk.zzb(!zzac);
        }
        zzk.zzr.zza(null);
        zzk.zzs.zza(0L);
        zzk.zzt.zza(null);
        if (z) {
            zzo().zzaf();
        }
        if (zzoj.zza() && zze().zza(zzbg.zzbl)) {
            zzp().zza.zza();
        }
        this.zzm = !zzac;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzl().zzb(new zzjg(this, str, str2, j, zzng.zza(bundle), z, z2, z3, str3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(String str, String str2, long j, Object obj) {
        zzl().zzb(new zzjf(this, str, str2, obj, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(String str) {
        this.zzf.set(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzu().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzic.zza(bundle2, "app_id", String.class, null);
        zzic.zza(bundle2, "origin", String.class, null);
        zzic.zza(bundle2, "name", String.class, null);
        zzic.zza(bundle2, "value", Object.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzic.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzq().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzq().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object zzc = zzq().zzc(string, obj);
        if (zzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzic.zza(bundle2, zzc);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j3));
        } else {
            zzl().zzb(new zzjm(this, bundle2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzif zzifVar, long j) {
        zzif zzifVar2;
        boolean z;
        zzif zzifVar3;
        boolean z2;
        boolean z3;
        zzu();
        int zza = zzifVar.zza();
        if (zza != -10 && zzifVar.zzc() == null && zzifVar.zzd() == null) {
            zzj().zzv().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzg) {
            zzifVar2 = this.zzj;
            z = false;
            if (zzif.zza(zza, zzifVar2.zza())) {
                z3 = zzifVar.zzc(this.zzj);
                if (zzifVar.zzh() && !this.zzj.zzh()) {
                    z = true;
                }
                zzif zzb = zzifVar.zzb(this.zzj);
                this.zzj = zzb;
                zzifVar3 = zzb;
                z2 = z;
                z = true;
            } else {
                zzifVar3 = zzifVar;
                z2 = false;
                z3 = false;
            }
        }
        if (!z) {
            zzj().zzn().zza("Ignoring lower-priority consent settings, proposed settings", zzifVar3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z3) {
            zza((String) null);
            zzl().zzc(new zzjv(this, zzifVar3, j, andIncrement, z2, zzifVar2));
            return;
        }
        zzjy zzjyVar = new zzjy(this, zzifVar3, andIncrement, z2, zzifVar2);
        if (zza == 30 || zza == -10) {
            zzl().zzc(zzjyVar);
        } else {
            zzl().zzb(zzjyVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(Bundle bundle, int i, long j) {
        zzu();
        String zza = zzif.zza(bundle);
        if (zza != null) {
            zzj().zzv().zza("Ignoring invalid consent setting", zza);
            zzj().zzv().zza("Valid consent values are 'granted', 'denied'");
        }
        zzif zza2 = zzif.zza(bundle, i);
        if (zzns.zza() && zze().zza(zzbg.zzcl)) {
            if (zza2.zzi()) {
                zza(zza2, j);
            }
            zzav zza3 = zzav.zza(bundle, i);
            if (zza3.zzg()) {
                zza(zza3);
            }
            Boolean zza4 = zzav.zza(bundle);
            if (zza4 != null) {
                zza(i == -30 ? "tcf" : "app", FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS, (Object) zza4.toString(), false);
                return;
            }
            return;
        }
        zza(zza2, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(zzav zzavVar) {
        zzl().zzb(new zzjw(this, zzavVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzik zzikVar) {
        zzik zzikVar2;
        zzt();
        zzu();
        if (zzikVar != null && zzikVar != (zzikVar2 = this.zzc)) {
            Preconditions.checkState(zzikVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzikVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Boolean bool) {
        zzu();
        zzl().zzb(new zzjt(this, bool));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(zzif zzifVar) {
        zzt();
        boolean z = (zzifVar.zzh() && zzifVar.zzg()) || zzo().zzaj();
        if (z != this.zzu.zzad()) {
            this.zzu.zzb(z);
            Boolean zzu = zzk().zzu();
            if (!z || zzu == null || zzu.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Boolean bool, boolean z) {
        zzt();
        zzu();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzad() || !(bool == null || bool.booleanValue())) {
            zzar();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzb().currentTimeMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            i = zzq().zzb(str2);
        } else {
            zzng zzq = zzq();
            if (zzq.zzc("user property", str2)) {
                if (!zzq.zza("user property", zzih.zza, str2)) {
                    i = 15;
                } else if (zzq.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzq();
            String zza = zzng.zza(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.zzu.zzt();
            zzng.zza(this.zzq, i, "_ev", zza, length);
            return;
        }
        if (obj != null) {
            int zza2 = zzq().zza(str2, obj);
            if (zza2 != 0) {
                zzq();
                String zza3 = zzng.zza(str2, 24, true);
                length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
                this.zzu.zzt();
                zzng.zza(this.zzq, zza2, "_ev", zza3, length);
                return;
            }
            Object zzc = zzq().zzc(str2, obj);
            if (zzc != null) {
                zza(str3, str2, j, zzc);
                return;
            }
            return;
        }
        zza(str3, str2, j, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzt()
            r8.zzu()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L63
            boolean r0 = r11 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L53
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzgb r0 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgh r0 = r0.zzh
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r10.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r11 = "true"
        L4e:
            r0.zza(r11)
            r6 = r10
            goto L61
        L53:
            if (r11 != 0) goto L63
            com.google.android.gms.measurement.internal.zzgb r10 = r8.zzk()
            com.google.android.gms.measurement.internal.zzgh r10 = r10.zzh
            java.lang.String r0 = "unset"
            r10.zza(r0)
            r6 = r11
        L61:
            r3 = r1
            goto L65
        L63:
            r3 = r10
            r6 = r11
        L65:
            com.google.android.gms.measurement.internal.zzhd r10 = r8.zzu
            boolean r10 = r10.zzac()
            if (r10 != 0) goto L7b
            com.google.android.gms.measurement.internal.zzfp r9 = r8.zzj()
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzp()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zza(r10)
            return
        L7b:
            com.google.android.gms.measurement.internal.zzhd r10 = r8.zzu
            boolean r10 = r10.zzaf()
            if (r10 != 0) goto L84
            return
        L84:
            com.google.android.gms.measurement.internal.zznb r10 = new com.google.android.gms.measurement.internal.zznb
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzkq r9 = r8.zzo()
            r9.zza(r10)
            return
            fill-array 0x0094: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzio.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(zzij zzijVar) {
        zzu();
        Preconditions.checkNotNull(zzijVar);
        if (this.zzd.remove(zzijVar)) {
            return;
        }
        zzj().zzu().zza("OnEventListener had not been registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzar() {
        zzt();
        String zza = zzk().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(zza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (this.zzu.zzac() && this.zzm) {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzaj();
            if (zzoj.zza() && zze().zza(zzbg.zzbl)) {
                zzp().zza.zza();
            }
            zzl().zzb(new zzjb(this));
            return;
        }
        zzj().zzc().zza("Updating Scion state (FE)");
        zzo().zzag();
    }
}
