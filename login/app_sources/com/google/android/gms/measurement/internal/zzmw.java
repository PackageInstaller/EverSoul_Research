package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmw implements zznf {
    final /* synthetic */ zzmp zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmw(zzmp zzmpVar) {
        this.zza = zzmpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zznf
    public final void zza(String str, String str2, Bundle bundle) {
        zzhd zzhdVar;
        zzhd zzhdVar2;
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl().zzb(new zzmv(this, str, str2, bundle));
            return;
        }
        zzhdVar = this.zza.zzm;
        if (zzhdVar != null) {
            zzhdVar2 = this.zza.zzm;
            zzhdVar2.zzj().zzg().zza("AppId not known when logging event", str2);
        }
    }
}
