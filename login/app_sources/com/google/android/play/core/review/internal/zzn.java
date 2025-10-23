package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
final class zzn extends zzj {
    final /* synthetic */ zzt zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzn(zzt zztVar) {
        this.zza = zztVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        IInterface iInterface;
        zzi zziVar;
        Context context;
        ServiceConnection serviceConnection;
        zzt zztVar = this.zza;
        iInterface = zztVar.zzn;
        if (iInterface != null) {
            zziVar = zztVar.zzc;
            zziVar.zzd("Unbind from service.", new Object[0]);
            zzt zztVar2 = this.zza;
            context = zztVar2.zzb;
            serviceConnection = zztVar2.zzm;
            context.unbindService(serviceConnection);
            this.zza.zzh = false;
            this.zza.zzn = null;
            this.zza.zzm = null;
        }
        this.zza.zzt();
    }
}
