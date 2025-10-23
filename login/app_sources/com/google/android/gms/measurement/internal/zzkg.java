package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zzpt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkg extends zzmo {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzmo
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzkg(zzmp zzmpVar) {
        super(zzmpVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] zza(zzbe zzbeVar, String str) {
        zznd zzndVar;
        Bundle bundle;
        zzg zzgVar;
        zzfi.zzj.zza zzaVar;
        zzfi.zzi.zza zzaVar2;
        byte[] bArr;
        long j;
        zzba zza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbeVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbg.zzbd)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbeVar.zza) && !"_iapx".equals(zzbeVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbeVar.zza);
            return null;
        }
        zzfi.zzi.zza zzb = zzfi.zzi.zzb();
        zzh().zzp();
        try {
            zzg zzd = zzh().zzd(str);
            if (zzd == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzd.zzal()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzfi.zzj.zza zzp = zzfi.zzj.zzu().zzg(1).zzp("android");
            if (!TextUtils.isEmpty(zzd.zzx())) {
                zzp.zzb(zzd.zzx());
            }
            if (!TextUtils.isEmpty(zzd.zzz())) {
                zzp.zzd((String) Preconditions.checkNotNull(zzd.zzz()));
            }
            if (!TextUtils.isEmpty(zzd.zzaa())) {
                zzp.zze((String) Preconditions.checkNotNull(zzd.zzaa()));
            }
            if (zzd.zzc() != -2147483648L) {
                zzp.zze((int) zzd.zzc());
            }
            zzp.zzf(zzd.zzo()).zzd(zzd.zzm());
            String zzac = zzd.zzac();
            String zzv = zzd.zzv();
            if (!TextUtils.isEmpty(zzac)) {
                zzp.zzm(zzac);
            } else if (!TextUtils.isEmpty(zzv)) {
                zzp.zza(zzv);
            }
            zzp.zzj(zzd.zzt());
            zzif zzb2 = this.zzf.zzb(str);
            zzp.zzc(zzd.zzl());
            if (this.zzu.zzac() && zze().zzi(zzp.zzt()) && zzb2.zzg() && !TextUtils.isEmpty(null)) {
                zzp.zzj((String) null);
            }
            zzp.zzg(zzb2.zze());
            if (zzb2.zzg() && zzd.zzak()) {
                Pair<String, Boolean> zza2 = zzn().zza(zzd.zzx(), zzb2);
                if (zzd.zzak() && zza2 != null && !TextUtils.isEmpty((CharSequence) zza2.first)) {
                    zzp.zzq(zza((String) zza2.first, Long.toString(zzbeVar.zzd)));
                    if (zza2.second != null) {
                        zzp.zzc(((Boolean) zza2.second).booleanValue());
                    }
                }
            }
            zzf().zzac();
            zzfi.zzj.zza zzi = zzp.zzi(Build.MODEL);
            zzf().zzac();
            zzi.zzo(Build.VERSION.RELEASE).zzi((int) zzf().zzg()).zzs(zzf().zzh());
            if (zzb2.zzh() && zzd.zzy() != null) {
                zzp.zzc(zza((String) Preconditions.checkNotNull(zzd.zzy()), Long.toString(zzbeVar.zzd)));
            }
            if (!TextUtils.isEmpty(zzd.zzab())) {
                zzp.zzl((String) Preconditions.checkNotNull(zzd.zzab()));
            }
            String zzx = zzd.zzx();
            List<zznd> zzi2 = zzh().zzi(zzx);
            Iterator<zznd> it = zzi2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zzndVar = null;
                    break;
                }
                zzndVar = it.next();
                if ("_lte".equals(zzndVar.zzc)) {
                    break;
                }
            }
            if (zzndVar == null || zzndVar.zze == null) {
                zznd zzndVar2 = new zznd(zzx, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzb().currentTimeMillis(), 0L);
                zzi2.add(zzndVar2);
                zzh().zza(zzndVar2);
            }
            zzfi.zzn[] zznVarArr = new zzfi.zzn[zzi2.size()];
            for (int i = 0; i < zzi2.size(); i++) {
                zzfi.zzn.zza zzb3 = zzfi.zzn.zze().zza(zzi2.get(i).zzc).zzb(zzi2.get(i).zzd);
                mo178g_().zza(zzb3, zzi2.get(i).zze);
                zznVarArr[i] = (zzfi.zzn) ((com.google.android.gms.internal.measurement.zzjf) zzb3.zzah());
            }
            zzp.zze(Arrays.asList(zznVarArr));
            mo178g_().zza(zzp);
            if (zzns.zza() && zze().zza(zzbg.zzcm)) {
                this.zzf.zza(zzd, zzp);
            }
            zzft zza3 = zzft.zza(zzbeVar);
            zzq().zza(zza3.zzb, zzh().zzc(str));
            zzq().zza(zza3, zze().zzb(str));
            Bundle bundle2 = zza3.zzb;
            bundle2.putLong("_c", 1L);
            zzj().zzc().zza("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", zzbeVar.zzc);
            if (zzq().zzf(zzp.zzt())) {
                zzq().zza(bundle2, "_dbg", (Object) 1L);
                zzq().zza(bundle2, "_r", (Object) 1L);
            }
            zzba zzd2 = zzh().zzd(str, zzbeVar.zza);
            if (zzd2 == null) {
                bundle = bundle2;
                zzgVar = zzd;
                zzaVar = zzp;
                zzaVar2 = zzb;
                bArr = null;
                zza = new zzba(str, zzbeVar.zza, 0L, 0L, zzbeVar.zzd, 0L, null, null, null, null);
                j = 0;
            } else {
                bundle = bundle2;
                zzgVar = zzd;
                zzaVar = zzp;
                zzaVar2 = zzb;
                bArr = null;
                j = zzd2.zzf;
                zza = zzd2.zza(zzbeVar.zzd);
            }
            zzh().zza(zza);
            zzax zzaxVar = new zzax(this.zzu, zzbeVar.zzc, str, zzbeVar.zza, zzbeVar.zzd, j, bundle);
            zzfi.zze.zza zza4 = zzfi.zze.zze().zzb(zzaxVar.zzc).zza(zzaxVar.zzb).zza(zzaxVar.zzd);
            Iterator<String> it2 = zzaxVar.zze.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                zzfi.zzg.zza zza5 = zzfi.zzg.zze().zza(next);
                Object zzc = zzaxVar.zze.zzc(next);
                if (zzc != null) {
                    mo178g_().zza(zza5, zzc);
                    zza4.zza(zza5);
                }
            }
            zzfi.zzj.zza zzaVar3 = zzaVar;
            zzaVar3.zza(zza4).zza(zzfi.zzk.zza().zza(zzfi.zzf.zza().zza(zza.zzc).zza(zzbeVar.zza)));
            zzaVar3.zza(zzg().zza(zzgVar.zzx(), Collections.emptyList(), zzaVar3.zzab(), Long.valueOf(zza4.zzc()), Long.valueOf(zza4.zzc())));
            if (zza4.zzg()) {
                zzaVar3.zzi(zza4.zzc()).zze(zza4.zzc());
            }
            long zzp2 = zzgVar.zzp();
            if (zzp2 != 0) {
                zzaVar3.zzg(zzp2);
            }
            long zzr = zzgVar.zzr();
            if (zzr != 0) {
                zzaVar3.zzh(zzr);
            } else if (zzp2 != 0) {
                zzaVar3.zzh(zzp2);
            }
            String zzaf = zzgVar.zzaf();
            if (zzpt.zza() && zze().zze(str, zzbg.zzbr) && zzaf != null) {
                zzaVar3.zzr(zzaf);
            }
            zzgVar.zzaj();
            zzaVar3.zzf((int) zzgVar.zzq()).zzl(84002L).zzk(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
            if (zze().zza(zzbg.zzbv)) {
                this.zzf.zza(zzaVar3.zzt(), zzaVar3);
            }
            zzfi.zzi.zza zzaVar4 = zzaVar2;
            zzaVar4.zza(zzaVar3);
            zzg zzgVar2 = zzgVar;
            zzgVar2.zzp(zzaVar3.zzf());
            zzgVar2.zzn(zzaVar3.zze());
            zzh().zza(zzgVar2);
            zzh().zzw();
            try {
                return mo178g_().zzb(((zzfi.zzi) ((com.google.android.gms.internal.measurement.zzjf) zzaVar4.zzah())).zzbv());
            } catch (IOException e) {
                zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzfp.zza(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            zzj().zzc().zza("app instance id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            zzj().zzc().zza("Resettable device id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            zzh().zzu();
        }
    }
}
