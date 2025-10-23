package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzns;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzhh extends zzfh {
    private final zzmp zza;
    private Boolean zzb;
    private String zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final zzaj zza(zzo zzoVar) {
        zzb(zzoVar, false);
        Preconditions.checkNotEmpty(zzoVar.zza);
        if (!zzns.zza()) {
            return new zzaj(null);
        }
        try {
            return (zzaj) this.zza.zzl().zzb(new zzhs(this, zzoVar)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzj().zzg().zza("Failed to get consent. appId", zzfp.zza(zzoVar.zza), e);
            return new zzaj(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzbe zzb(zzbe zzbeVar, zzo zzoVar) {
        boolean z = false;
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbeVar.zza) && zzbeVar.zzb != null && zzbeVar.zzb.zza() != 0) {
            String zzd = zzbeVar.zzb.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                z = true;
            }
        }
        if (!z) {
            return zzbeVar;
        }
        this.zza.zzj().zzn().zza("Event has been filtered ", zzbeVar.toString());
        return new zzbe("_cmpx", zzbeVar.zzb, zzbeVar.zzc, zzbeVar.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final String zzb(zzo zzoVar) {
        zzb(zzoVar, false);
        return this.zza.zzb(zzoVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzmh> zza(zzo zzoVar, Bundle bundle) {
        zzb(zzoVar, false);
        Preconditions.checkNotNull(zzoVar.zza);
        try {
            return (List) this.zza.zzl().zza(new zzhz(this, zzoVar, bundle)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get trigger URIs. appId", zzfp.zza(zzoVar.zza), e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(zzo zzoVar, boolean z) {
        zzb(zzoVar, false);
        String str = zzoVar.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zznd> list = (List) this.zza.zzl().zza(new zzhy(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznd zzndVar : list) {
                if (z || !zzng.zzg(zzndVar.zzc)) {
                    arrayList.add(new zznb(zzndVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties. appId", zzfp.zza(zzoVar.zza), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzae> zza(String str, String str2, zzo zzoVar) {
        zzb(zzoVar, false);
        String str3 = zzoVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzl().zza(new zzho(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzae> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzl().zza(new zzhr(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(String str, String str2, boolean z, zzo zzoVar) {
        zzb(zzoVar, false);
        String str3 = zzoVar.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zznd> list = (List) this.zza.zzl().zza(new zzhm(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznd zzndVar : list) {
                if (z || !zzng.zzg(zzndVar.zzc)) {
                    arrayList.add(new zznb(zzndVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to query user properties. appId", zzfp.zza(zzoVar.zza), e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zznd> list = (List) this.zza.zzl().zza(new zzhp(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zznd zzndVar : list) {
                if (z || !zzng.zzg(zzndVar.zzc)) {
                    arrayList.add(new zznb(zzndVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to get user properties as. appId", zzfp.zza(str), e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhh(zzmp zzmpVar) {
        this(zzmpVar, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzhh(zzmp zzmpVar, String str) {
        Preconditions.checkNotNull(zzmpVar);
        this.zza = zzmpVar;
        this.zzc = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzc(zzo zzoVar) {
        zzb(zzoVar, false);
        zza(new zzhi(this, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb(zzo zzoVar, boolean z) {
        Preconditions.checkNotNull(zzoVar);
        Preconditions.checkNotEmpty(zzoVar.zza);
        zza(zzoVar.zza, false);
        this.zza.zzq().zza(zzoVar.zzb, zzoVar.zzp);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(String str, boolean z) {
        boolean z2;
        if (TextUtils.isEmpty(str)) {
            this.zza.zzj().zzg().zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zza(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.zza.zza()).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    z2 = true;
                    this.zzb = Boolean.valueOf(z2);
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zza.zzj().zzg().zza("Measurement Service called with invalid calling package. appId", zzfp.zza(str));
                throw e;
            }
        }
        if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zza(), Binder.getCallingUid(), str)) {
            this.zzc = str;
        }
        if (str.equals(this.zzc)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzc(zzbe zzbeVar, zzo zzoVar) {
        boolean z;
        if (!this.zza.zzi().zzl(zzoVar.zza)) {
            zzd(zzbeVar, zzoVar);
            return;
        }
        this.zza.zzj().zzp().zza("EES config found for", zzoVar.zza);
        zzgn zzi = this.zza.zzi();
        String str = zzoVar.zza;
        com.google.android.gms.internal.measurement.zzb zzbVar = TextUtils.isEmpty(str) ? null : zzi.zza.get(str);
        if (zzbVar == null) {
            this.zza.zzj().zzp().zza("EES not loaded for", zzoVar.zza);
            zzd(zzbeVar, zzoVar);
            return;
        }
        try {
            Map<String, Object> zza = this.zza.zzp().zza(zzbeVar.zzb.zzb(), true);
            String zza2 = zzig.zza(zzbeVar.zza);
            if (zza2 == null) {
                zza2 = zzbeVar.zza;
            }
            z = zzbVar.zza(new com.google.android.gms.internal.measurement.zzad(zza2, zzbeVar.zzd, zza));
        } catch (com.google.android.gms.internal.measurement.zzc unused) {
            this.zza.zzj().zzg().zza("EES error. appId, eventName", zzoVar.zzb, zzbeVar.zza);
            z = false;
        }
        if (!z) {
            this.zza.zzj().zzp().zza("EES was not applied to event", zzbeVar.zza);
            zzd(zzbeVar, zzoVar);
            return;
        }
        if (zzbVar.zzd()) {
            this.zza.zzj().zzp().zza("EES edited event", zzbeVar.zza);
            zzd(this.zza.zzp().zza(zzbVar.zza().zzb()), zzoVar);
        } else {
            zzd(zzbeVar, zzoVar);
        }
        if (zzbVar.zzc()) {
            for (com.google.android.gms.internal.measurement.zzad zzadVar : zzbVar.zza().zzc()) {
                this.zza.zzj().zzp().zza("EES logging created event", zzadVar.zzb());
                zzd(this.zza.zzp().zza(zzadVar), zzoVar);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final /* synthetic */ void zza(String str, Bundle bundle) {
        this.zza.zzf().zza(str, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzbe zzbeVar, zzo zzoVar) {
        Preconditions.checkNotNull(zzbeVar);
        zzb(zzoVar, false);
        zza(new zzhv(this, zzbeVar, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzbe zzbeVar, String str, String str2) {
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza(new zzhu(this, zzbeVar, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzd(zzbe zzbeVar, zzo zzoVar) {
        this.zza.zzr();
        this.zza.zza(zzbeVar, zzoVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzd(zzo zzoVar) {
        Preconditions.checkNotEmpty(zzoVar.zza);
        zza(zzoVar.zza, false);
        zza(new zzhq(this, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzl().zzg()) {
            runnable.run();
        } else {
            this.zza.zzl().zzb(runnable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzae zzaeVar, zzo zzoVar) {
        Preconditions.checkNotNull(zzaeVar);
        Preconditions.checkNotNull(zzaeVar.zzc);
        zzb(zzoVar, false);
        zzae zzaeVar2 = new zzae(zzaeVar);
        zzaeVar2.zza = zzoVar.zza;
        zza(new zzhk(this, zzaeVar2, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzae zzaeVar) {
        Preconditions.checkNotNull(zzaeVar);
        Preconditions.checkNotNull(zzaeVar.zzc);
        Preconditions.checkNotEmpty(zzaeVar.zza);
        zza(zzaeVar.zza, true);
        zza(new zzhn(this, new zzae(zzaeVar)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zze(zzo zzoVar) {
        Preconditions.checkNotEmpty(zzoVar.zza);
        Preconditions.checkNotNull(zzoVar.zzt);
        zzht zzhtVar = new zzht(this, zzoVar);
        Preconditions.checkNotNull(zzhtVar);
        if (this.zza.zzl().zzg()) {
            zzhtVar.run();
        } else {
            this.zza.zzl().zzc(zzhtVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(long j, String str, String str2, String str3) {
        zza(new zzhl(this, str2, str3, str, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(final Bundle bundle, zzo zzoVar) {
        zzb(zzoVar, false);
        final String str = zzoVar.zza;
        Preconditions.checkNotNull(str);
        zza(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhg
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                zzhh.this.zza(str, bundle);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzf(zzo zzoVar) {
        zzb(zzoVar, false);
        zza(new zzhj(this, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zznb zznbVar, zzo zzoVar) {
        Preconditions.checkNotNull(zznbVar);
        zzb(zzoVar, false);
        zza(new zzhw(this, zznbVar, zzoVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final byte[] zza(zzbe zzbeVar, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbeVar);
        zza(str, true);
        this.zza.zzj().zzc().zza("Log and bundle. event", this.zza.zzg().zza(zzbeVar.zza));
        long nanoTime = this.zza.zzb().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzl().zzb(new zzhx(this, zzbeVar, str)).get();
            if (bArr == null) {
                this.zza.zzj().zzg().zza("Log and bundle returned null. appId", zzfp.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzj().zzc().zza("Log and bundle processed. event, size, time_ms", this.zza.zzg().zza(zzbeVar.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzb().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzj().zzg().zza("Failed to log and bundle. appId, event, error", zzfp.zza(str), this.zza.zzg().zza(zzbeVar.zza), e);
            return null;
        }
    }
}
