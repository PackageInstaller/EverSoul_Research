package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzax {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzaz zze;
    private final String zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzax zza(zzhd zzhdVar, long j) {
        return new zzax(zzhdVar, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "Event{appId='" + this.zza + "', name='" + this.zzb + "', params=" + String.valueOf(this.zze) + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzax(zzhd zzhdVar, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzaz zzazVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhdVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId", zzfp.zza(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzhdVar.zzj().zzg().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzb = zzhdVar.zzt().zzb(next, bundle2.get(next));
                    if (zzb == null) {
                        zzhdVar.zzj().zzu().zza("Param value can't be null", zzhdVar.zzk().zzb(next));
                        it.remove();
                    } else {
                        zzhdVar.zzt().zza(bundle2, next, zzb);
                    }
                }
            }
            zzazVar = new zzaz(bundle2);
        } else {
            zzazVar = new zzaz(new Bundle());
        }
        this.zze = zzazVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzax(zzhd zzhdVar, String str, String str2, String str3, long j, long j2, zzaz zzazVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzazVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhdVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId, name", zzfp.zza(str2), zzfp.zza(str3));
        }
        this.zze = zzazVar;
    }
}
