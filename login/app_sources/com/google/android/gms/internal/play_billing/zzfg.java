package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzfg extends zzes {
    final /* synthetic */ zzfh zza;
    private final Callable zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzfg(zzfh zzfhVar, Callable callable) {
        this.zza = zzfhVar;
        callable.getClass();
        this.zzb = callable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzes
    final Object zza() throws Exception {
        return this.zzb.call();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzes
    final String zzb() {
        return this.zzb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzes
    final void zzc(Throwable th) {
        this.zza.zzo(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzes
    final void zzd(Object obj) {
        this.zza.zzn(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzes
    final boolean zzf() {
        return this.zza.isDone();
    }
}
