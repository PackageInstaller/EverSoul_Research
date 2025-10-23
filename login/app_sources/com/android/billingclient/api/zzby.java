package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzej;
import com.liapp.y;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzby implements zzej {
    final /* synthetic */ Consumer zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzcc zzc;
    final /* synthetic */ int zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzby(zzcc zzccVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        this.zzc = zzccVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzej
    public final void zza(Throwable th) {
        boolean z = th instanceof TimeoutException;
        String str = y.֬ڱܱײٮ(-1159348447);
        if (z) {
            this.zzc.zzaS(114, 28, zzcj.zzG);
            com.google.android.gms.internal.play_billing.zze.zzm(str, y.٬ݯح׭٩(576071422), th);
        } else {
            this.zzc.zzaS(107, 28, zzcj.zzG);
            com.google.android.gms.internal.play_billing.zze.zzm(str, y.ݮڮֲڭܩ(-629028660), th);
        }
        this.zzb.run();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        boolean zzaP;
        BillingResult zzaQ;
        Integer num = (Integer) obj;
        int intValue = num.intValue();
        zzcc zzccVar = this.zzc;
        zzaP = zzcc.zzaP(intValue);
        if (zzaP) {
            zzaQ = zzccVar.zzaQ(this.zzd, num.intValue());
            this.zza.accept(zzaQ);
        } else {
            this.zzb.run();
        }
    }
}
