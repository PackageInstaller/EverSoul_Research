package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.measurement.internal.zzif;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgn extends zzmo implements zzai {
    final LruCache<String, com.google.android.gms.internal.measurement.zzb> zza;
    final com.google.android.gms.internal.measurement.zzv zzb;
    private final Map<String, Map<String, String>> zzc;
    private final Map<String, Set<String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzg;
    private final Map<String, zzfc.zzd> zzh;
    private final Map<String, Map<String, Integer>> zzi;
    private final Map<String, String> zzj;
    private final Map<String, String> zzk;
    private final Map<String, String> zzl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zzb(String str, String str2) {
        Integer num;
        zzt();
        zzv(str);
        Map<String, Integer> map = this.zzi.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzmo
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final long zza(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0L;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzj().zzu().zza("Unable to parse timezone offset. appId", zzfp.zza(str), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ com.google.android.gms.internal.measurement.zzb zza(zzgn zzgnVar, String str) {
        zzgnVar.zzak();
        Preconditions.checkNotEmpty(str);
        if (!zzgnVar.zzl(str)) {
            return null;
        }
        if (zzgnVar.zzh.containsKey(str) && zzgnVar.zzh.get(str) != null) {
            zzgnVar.zza(str, zzgnVar.zzh.get(str));
        } else {
            zzgnVar.zzv(str);
        }
        return zzgnVar.zza.snapshot().get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzml
    public final /* bridge */ /* synthetic */ zzu zzg() {
        return super.zzg();
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
    @Override // com.google.android.gms.measurement.internal.zzml
    public final /* bridge */ /* synthetic */ zzal zzh() {
        return super.zzh();
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
    @Override // com.google.android.gms.measurement.internal.zzml
    public final /* bridge */ /* synthetic */ zzgn zzm() {
        return super.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzgw zzl() {
        return super.zzl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzif.zza zza(String str, zzif.zza zzaVar) {
        zzt();
        zzv(str);
        zzfc.zza zzb = zzb(str);
        if (zzb == null) {
            return null;
        }
        for (zzfc.zza.zzc zzcVar : zzb.zze()) {
            if (zzaVar == zza(zzcVar.zzc())) {
                return zza(zzcVar.zzb());
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzif.zza zza(zzfc.zza.zze zzeVar) {
        int i = zzgu.zzb[zzeVar.ordinal()];
        if (i == 1) {
            return zzif.zza.AD_STORAGE;
        }
        if (i == 2) {
            return zzif.zza.ANALYTICS_STORAGE;
        }
        if (i == 3) {
            return zzif.zza.AD_USER_DATA;
        }
        if (i != 4) {
            return null;
        }
        return zzif.zza.AD_PERSONALIZATION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzml
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzml
    public final /* bridge */ /* synthetic */ zzmn zzo() {
        return super.zzo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzml
    /* renamed from: g_ */
    public final /* bridge */ /* synthetic */ zzmz mo178g_() {
        return super.mo178g_();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzng zzq() {
        return super.zzq();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzfc.zza zzb(String str) {
        zzt();
        zzv(str);
        zzfc.zzd zzc = zzc(str);
        if (zzc == null || !zzc.zzp()) {
            return null;
        }
        return zzc.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final zzfc.zzd zzc(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzv(str);
        return this.zzh.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzfc.zzd zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfc.zzd.zzg();
        }
        try {
            zzfc.zzd zzdVar = (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) ((zzfc.zzd.zza) zzmz.zza(zzfc.zzd.zze(), bArr)).zzah());
            zzj().zzp().zza("Parsed config. version, gmp_app_id", zzdVar.zzs() ? Long.valueOf(zzdVar.zzc()) : null, zzdVar.zzq() ? zzdVar.zzi() : null);
            return zzdVar;
        } catch (com.google.android.gms.internal.measurement.zzjq e) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzfp.zza(str), e);
            return zzfc.zzd.zzg();
        } catch (RuntimeException e2) {
            zzj().zzu().zza("Unable to merge remote config. appId", zzfp.zza(str), e2);
            return zzfc.zzd.zzg();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzai
    public final String zza(String str, String str2) {
        zzt();
        zzv(str);
        Map<String, String> map = this.zzc.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final String zzd(String str) {
        zzt();
        return this.zzl.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final String zze(String str) {
        zzt();
        return this.zzk.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzf(String str) {
        zzt();
        zzv(str);
        return this.zzj.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Map<String, String> zza(zzfc.zzd zzdVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzdVar != null) {
            for (zzfc.zzg zzgVar : zzdVar.zzn()) {
                arrayMap.put(zzgVar.zzb(), zzgVar.zzc());
            }
        }
        return arrayMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Set<String> zzg(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final SortedSet<String> zzh(String str) {
        zzt();
        zzv(str);
        TreeSet treeSet = new TreeSet();
        zzfc.zza zzb = zzb(str);
        if (zzb == null) {
            return treeSet;
        }
        Iterator<zzfc.zza.zzf> it = zzb.zzc().iterator();
        while (it.hasNext()) {
            treeSet.add(it.next().zzb());
        }
        return treeSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgn(zzmp zzmpVar) {
        super(zzmpVar);
        this.zzc = new ArrayMap();
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
        this.zzj = new ArrayMap();
        this.zzk = new ArrayMap();
        this.zzl = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zza = new zzgt(this, 20);
        this.zzb = new zzgs(this);
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
    protected final void zzi(String str) {
        zzt();
        this.zzk.put(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(String str, zzfc.zzd.zza zzaVar) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            Iterator<zzfc.zzb> it = zzaVar.zze().iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().zzb());
            }
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzfc.zzc.zza zzby = zzaVar.zza(i).zzby();
                if (zzby.zzb().isEmpty()) {
                    zzj().zzu().zza("EventConfig contained null event name");
                } else {
                    String zzb = zzby.zzb();
                    String zzb2 = zzig.zzb(zzby.zzb());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzby = zzby.zza(zzb2);
                        zzaVar.zza(i, zzby);
                    }
                    if (zzby.zze() && zzby.zzc()) {
                        arrayMap.put(zzb, true);
                    }
                    if (zzby.zzf() && zzby.zzd()) {
                        arrayMap2.put(zzby.zzb(), true);
                    }
                    if (zzby.zzg()) {
                        if (zzby.zza() < 2 || zzby.zza() > 65535) {
                            zzj().zzu().zza("Invalid sampling rate. Event name, sample rate", zzby.zzb(), Integer.valueOf(zzby.zza()));
                        } else {
                            arrayMap3.put(zzby.zzb(), Integer.valueOf(zzby.zza()));
                        }
                    }
                }
            }
        }
        this.zzd.put(str, hashSet);
        this.zze.put(str, arrayMap);
        this.zzg.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzv(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        if (this.zzh.get(str) == null) {
            zzan zze = zzh().zze(str);
            if (zze == null) {
                this.zzc.put(str, null);
                this.zze.put(str, null);
                this.zzd.put(str, null);
                this.zzg.put(str, null);
                this.zzh.put(str, null);
                this.zzj.put(str, null);
                this.zzk.put(str, null);
                this.zzl.put(str, null);
                this.zzi.put(str, null);
                return;
            }
            zzfc.zzd.zza zzby = zza(str, zze.zza).zzby();
            zza(str, zzby);
            this.zzc.put(str, zza((zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah())));
            this.zzh.put(str, (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
            zza(str, (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
            this.zzj.put(str, zzby.zzc());
            this.zzk.put(str, zze.zzb);
            this.zzl.put(str, zze.zzc);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(final String str, zzfc.zzd zzdVar) {
        if (zzdVar.zza() == 0) {
            this.zza.remove(str);
            return;
        }
        zzj().zzp().zza("EES programs found", Integer.valueOf(zzdVar.zza()));
        zzfp.zzc zzcVar = zzdVar.zzm().get(0);
        try {
            com.google.android.gms.internal.measurement.zzb zzbVar = new com.google.android.gms.internal.measurement.zzb();
            zzbVar.zza("internal.remoteConfig", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgo
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzm("internal.remoteConfig", new zzgv(zzgn.this, str));
                }
            });
            zzbVar.zza("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgr
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    final zzgn zzgnVar = zzgn.this;
                    final String str2 = str;
                    return new com.google.android.gms.internal.measurement.zzx("internal.appMetadata", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgp
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            zzgn zzgnVar2 = zzgn.this;
                            String str3 = str2;
                            zzg zzd = zzgnVar2.zzh().zzd(str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put("platform", "android");
                            hashMap.put("package_name", str3);
                            hashMap.put("gmp_version", 84002L);
                            if (zzd != null) {
                                String zzaa = zzd.zzaa();
                                if (zzaa != null) {
                                    hashMap.put("app_version", zzaa);
                                }
                                hashMap.put("app_version_int", Long.valueOf(zzd.zzc()));
                                hashMap.put("dynamite_version", Long.valueOf(zzd.zzm()));
                            }
                            return hashMap;
                        }
                    });
                }
            });
            zzbVar.zza("internal.logger", new Callable() { // from class: com.google.android.gms.measurement.internal.zzgq
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new com.google.android.gms.internal.measurement.zzr(zzgn.this.zzb);
                }
            });
            zzbVar.zza(zzcVar);
            this.zza.put(str, zzbVar);
            zzj().zzp().zza("EES program loaded for appId, activities", str, Integer.valueOf(zzcVar.zza().zza()));
            Iterator<zzfp.zzb> it = zzcVar.zza().zzd().iterator();
            while (it.hasNext()) {
                zzj().zzp().zza("EES program activity", it.next().zzb());
            }
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            zzj().zzg().zza("Failed to load EES program. appId", str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzj(String str) {
        zzt();
        this.zzh.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzk(String str) {
        zzt();
        zzfc.zzd zzc = zzc(str);
        if (zzc == null) {
            return false;
        }
        return zzc.zzo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzl(String str) {
        zzfc.zzd zzdVar;
        return (TextUtils.isEmpty(str) || (zzdVar = this.zzh.get(str)) == null || zzdVar.zza() == 0) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzm(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzb(String str, zzif.zza zzaVar) {
        zzt();
        zzv(str);
        zzfc.zza zzb = zzb(str);
        if (zzb == null) {
            return false;
        }
        Iterator<zzfc.zza.zzb> it = zzb.zzd().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfc.zza.zzb next = it.next();
            if (zzaVar == zza(next.zzc())) {
                if (next.zzb() == zzfc.zza.zzd.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzn(String str) {
        zzt();
        zzv(str);
        zzfc.zza zzb = zzb(str);
        return zzb == null || !zzb.zzg() || zzb.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzc(String str, String str2) {
        Boolean bool;
        zzt();
        zzv(str);
        if ("ecommerce_purchase".equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zzg.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzd(String str, String str2) {
        Boolean bool;
        zzt();
        zzv(str);
        if (zzm(str) && zzng.zzg(str2)) {
            return true;
        }
        if (zzo(str) && zzng.zzh(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzo(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean zza(String str, byte[] bArr, String str2, String str3) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        zzfc.zzd.zza zzby = zza(str, bArr).zzby();
        if (zzby == null) {
            return false;
        }
        zza(str, zzby);
        zza(str, (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
        this.zzh.put(str, (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
        this.zzj.put(str, zzby.zzc());
        this.zzk.put(str, str2);
        this.zzl.put(str, str3);
        this.zzc.put(str, zza((zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah())));
        zzh().zza(str, new ArrayList(zzby.zzd()));
        try {
            zzby.zzb();
            bArr = ((zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah())).zzbv();
        } catch (RuntimeException e) {
            zzj().zzu().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzfp.zza(str), e);
        }
        zzal zzh = zzh();
        Preconditions.checkNotEmpty(str);
        zzh.zzt();
        zzh.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (zzh.m176e_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzh.zzj().zzg().zza("Failed to update remote config (got 0). appId", zzfp.zza(str));
            }
        } catch (SQLiteException e2) {
            zzh.zzj().zzg().zza("Error storing remote config. appId", zzfp.zza(str), e2);
        }
        this.zzh.put(str, (zzfc.zzd) ((com.google.android.gms.internal.measurement.zzjf) zzby.zzah()));
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzp(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("app_instance_id");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzq(String str) {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("device_model") || this.zzd.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzr(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("enhanced_user_id");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzs(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("google_signals");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzt(String str) {
        zzt();
        zzv(str);
        if (this.zzd.get(str) != null) {
            return this.zzd.get(str).contains("os_version") || this.zzd.get(str).contains(DeviceRequestsHelper.DEVICE_INFO_PARAM);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzu(String str) {
        zzt();
        zzv(str);
        return this.zzd.get(str) != null && this.zzd.get(str).contains("user_id");
    }
}
