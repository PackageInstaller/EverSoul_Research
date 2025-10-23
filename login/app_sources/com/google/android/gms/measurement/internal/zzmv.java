package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmv implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzmw zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmv(zzmw zzmwVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        this.zzd = zzmwVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zza((zzbe) Preconditions.checkNotNull(this.zzd.zza.zzq().zza(this.zza, this.zzb, this.zzc, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zzd.zza.zzb().currentTimeMillis(), false, true)), this.zza);
    }
}
