package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzlp extends zzmo {
    public final zzgg zza;
    public final zzgg zzb;
    public final zzgg zzc;
    public final zzgg zzd;
    public final zzgg zze;
    private final Map<String, zzls> zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzmo
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzls zzlsVar;
        AdvertisingIdClient.Info info;
        zzt();
        long elapsedRealtime = zzb().elapsedRealtime();
        zzls zzlsVar2 = this.zzg.get(str);
        if (zzlsVar2 != null && elapsedRealtime < zzlsVar2.zzc) {
            return new Pair<>(zzlsVar2.zza, Boolean.valueOf(zzlsVar2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzd = zze().zzd(str) + elapsedRealtime;
        try {
            long zzc = zze().zzc(str, zzbg.zzb);
            if (zzc > 0) {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(zza());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzlsVar2 != null && elapsedRealtime < zzlsVar2.zzc + zzc) {
                        return new Pair<>(zzlsVar2.zza, Boolean.valueOf(zzlsVar2.zzb));
                    }
                    info = null;
                }
            } else {
                info = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            }
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            zzlsVar = new zzls("", false, zzd);
        }
        if (info == null) {
            return new Pair<>("00000000-0000-0000-0000-000000000000", false);
        }
        String id = info.getId();
        zzlsVar = id != null ? new zzls(id, info.isLimitAdTrackingEnabled(), zzd) : new zzls("", info.isLimitAdTrackingEnabled(), zzd);
        this.zzg.put(str, zzlsVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(zzlsVar.zza, Boolean.valueOf(zzlsVar.zzb));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Pair<String, Boolean> zza(String str, zzif zzifVar) {
        if (zzifVar.zzg()) {
            return zza(str);
        }
        return new Pair<>("", false);
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
    @Deprecated
    final String zza(String str, boolean z) {
        zzt();
        String str2 = z ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest zzu = zzng.zzu();
        if (zzu == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzu.digest(str2.getBytes())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlp(zzmp zzmpVar) {
        super(zzmpVar);
        this.zzg = new HashMap();
        zzgb zzk = zzk();
        Objects.requireNonNull(zzk);
        this.zza = new zzgg(zzk, "last_delete_stale", 0L);
        zzgb zzk2 = zzk();
        Objects.requireNonNull(zzk2);
        this.zzb = new zzgg(zzk2, "backoff", 0L);
        zzgb zzk3 = zzk();
        Objects.requireNonNull(zzk3);
        this.zzc = new zzgg(zzk3, "last_upload", 0L);
        zzgb zzk4 = zzk();
        Objects.requireNonNull(zzk4);
        this.zzd = new zzgg(zzk4, "last_upload_attempt", 0L);
        zzgb zzk5 = zzk();
        Objects.requireNonNull(zzk5);
        this.zze = new zzgg(zzk5, "midnight_offset", 0L);
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
}
