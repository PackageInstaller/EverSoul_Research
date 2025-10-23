package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgm implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzby zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgj zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgm(zzgj zzgjVar, com.google.android.gms.internal.measurement.zzby zzbyVar, ServiceConnection serviceConnection) {
        this.zza = zzbyVar;
        this.zzb = serviceConnection;
        this.zzc = zzgjVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzgk zzgkVar = this.zzc.zza;
        str = this.zzc.zzb;
        com.google.android.gms.internal.measurement.zzby zzbyVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza = zzgkVar.zza(str, zzbyVar);
        zzgkVar.zza.zzl().zzt();
        zzgkVar.zza.zzy();
        if (zza != null) {
            long j = zza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzgkVar.zza.zzj().zzu().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzgkVar.zza.zzj().zzg().zza("No referrer defined in Install Referrer response");
                } else {
                    zzgkVar.zza.zzj().zzp().zza("InstallReferrer API result", string);
                    Bundle zza2 = zzgkVar.zza.zzt().zza(Uri.parse("?" + string), zzpz.zza() && zzgkVar.zza.zzf().zza(zzbg.zzby), zzok.zza() && zzgkVar.zza.zzf().zza(zzbg.zzct));
                    if (zza2 == null) {
                        zzgkVar.zza.zzj().zzg().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza2.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = zza.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzgkVar.zza.zzj().zzg().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzgkVar.zza.zzn().zzd.zza()) {
                            zzgkVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzgkVar.zza.zzac()) {
                            zzgkVar.zza.zzn().zzd.zza(j);
                            zzgkVar.zza.zzj().zzp().zza("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zza2.putString("_cis", "referrer API v2");
                            zzgkVar.zza.zzp().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zza2, str);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzgkVar.zza.zza(), serviceConnection);
        }
    }
}
