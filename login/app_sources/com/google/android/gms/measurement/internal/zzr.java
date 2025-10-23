package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.messaging.Constants;
import kotlinx.coroutines.DebugKt;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzr {
    private final zzhd zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzr(zzhd zzhdVar) {
        this.zza = zzhdVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzl().zzt();
        if (this.zza.zzac()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.zzn().zzr.zza(str2);
        this.zza.zzn().zzs.zza(this.zza.zzb().currentTimeMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        this.zza.zzl().zzt();
        if (zzc()) {
            if (zzd()) {
                this.zza.zzn().zzr.zza(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", SDKConstants.PARAM_INTENT);
                bundle.putLong("_cc", 1L);
                this.zza.zzp().zzc(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmpx", bundle);
            } else {
                String zza = this.zza.zzn().zzr.zza();
                if (TextUtils.isEmpty(zza)) {
                    this.zza.zzj().zzm().zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = ((this.zza.zzn().zzs.zza() / DateUtils.MILLIS_PER_HOUR) - 1) * DateUtils.MILLIS_PER_HOUR;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza2);
                    this.zza.zzp().zzc(pair.first == null ? "app" : (String) pair.first, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, (Bundle) pair.second);
                }
                this.zza.zzn().zzr.zza(null);
            }
            this.zza.zzn().zzs.zza(0L);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb() {
        if (zzc() && zzd()) {
            this.zza.zzn().zzr.zza(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzc() {
        return this.zza.zzn().zzs.zza() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zzd() {
        return zzc() && this.zza.zzb().currentTimeMillis() - this.zza.zzn().zzs.zza() > this.zza.zzf().zzc(null, zzbg.zzat);
    }
}
