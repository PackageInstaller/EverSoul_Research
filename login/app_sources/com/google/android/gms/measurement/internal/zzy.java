package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfi;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzy {
    private zzfi.zze zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzu zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzfi.zze zza(String str, zzfi.zze zzeVar) {
        String zzg = zzeVar.zzg();
        List<zzfi.zzg> zzh = zzeVar.zzh();
        this.zzd.mo178g_();
        Long l = (Long) zzmz.zzb(zzeVar, "_eid");
        boolean z = l != null;
        if (z && zzg.equals("_ep")) {
            Preconditions.checkNotNull(l);
            this.zzd.mo178g_();
            zzg = (String) zzmz.zzb(zzeVar, "_en");
            if (TextUtils.isEmpty(zzg)) {
                this.zzd.zzj().zzm().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<zzfi.zze, Long> zza = this.zzd.zzh().zza(str, l);
                if (zza == null || zza.first == null) {
                    this.zzd.zzj().zzm().zza("Extra parameter without existing main event. eventName, eventId", zzg, l);
                    return null;
                }
                this.zza = (zzfi.zze) zza.first;
                this.zzc = ((Long) zza.second).longValue();
                this.zzd.mo178g_();
                this.zzb = (Long) zzmz.zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzal zzh2 = this.zzd.zzh();
                zzh2.zzt();
                zzh2.zzj().zzp().zza("Clearing complex main event info. appId", str);
                try {
                    zzh2.m176e_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzh2.zzj().zzg().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzh().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzfi.zzg zzgVar : this.zza.zzh()) {
                this.zzd.mo178g_();
                if (zzmz.zza(zzeVar, zzgVar.zzg()) == null) {
                    arrayList.add(zzgVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzm().zza("No unique parameters in main event. eventName", zzg);
            } else {
                arrayList.addAll(zzh);
                zzh = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzeVar;
            this.zzd.mo178g_();
            Object zzb = zzmz.zzb(zzeVar, "_epc");
            long longValue = ((Long) (zzb != null ? zzb : 0L)).longValue();
            this.zzc = longValue;
            if (longValue <= 0) {
                this.zzd.zzj().zzm().zza("Complex event with zero extra param count. eventName", zzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l), this.zzc, zzeVar);
            }
        }
        return (zzfi.zze) ((com.google.android.gms.internal.measurement.zzjf) zzeVar.zzby().zza(zzg).zzd().zza(zzh).zzah());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzy(zzu zzuVar) {
        this.zzd = zzuVar;
    }
}
