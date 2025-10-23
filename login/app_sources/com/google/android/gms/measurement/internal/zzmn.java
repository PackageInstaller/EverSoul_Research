package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzqa;
import java.util.HashMap;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzmn extends zzml {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Uri.Builder zza(String str) {
        String zzf = zzm().zzf(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zze().zzd(str, zzbg.zzaw));
        if (TextUtils.isEmpty(zzf)) {
            builder.authority(zze().zzd(str, zzbg.zzax));
        } else {
            builder.authority(zzf + "." + zze().zzd(str, zzbg.zzax));
        }
        builder.path(zze().zzd(str, zzbg.zzay));
        return builder;
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
    public final zzmq zzb(String str) {
        if (zzqa.zza() && zze().zza(zzbg.zzbs)) {
            zzj().zzp().zza("sgtm feature flag enabled.");
            zzg zzd = zzh().zzd(str);
            if (zzd == null) {
                return new zzmq(zzc(str));
            }
            zzmq zzmqVar = null;
            if (zzd.zzan()) {
                zzj().zzp().zza("sgtm upload enabled in manifest.");
                zzfc.zzd zzc = zzm().zzc(zzd.zzx());
                if (zzc != null && zzc.zzr()) {
                    String zzd2 = zzc.zzh().zzd();
                    if (!TextUtils.isEmpty(zzd2)) {
                        String zzc2 = zzc.zzh().zzc();
                        zzj().zzp().zza("sgtm configured with upload_url, server_info", zzd2, TextUtils.isEmpty(zzc2) ? "Y" : "N");
                        if (TextUtils.isEmpty(zzc2)) {
                            zzmqVar = new zzmq(zzd2);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-google-sgtm-server-info", zzc2);
                            zzmqVar = new zzmq(zzd2, hashMap);
                        }
                    }
                }
            }
            if (zzmqVar != null) {
                return zzmqVar;
            }
        }
        return new zzmq(zzc(str));
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
    private final String zzc(String str) {
        String zzf = zzm().zzf(str);
        if (!TextUtils.isEmpty(zzf)) {
            Uri parse = Uri.parse(zzbg.zzq.zza(null));
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.authority(zzf + "." + parse.getAuthority());
            return buildUpon.build().toString();
        }
        return zzbg.zzq.zza(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmn(zzmp zzmpVar) {
        super(zzmpVar);
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
