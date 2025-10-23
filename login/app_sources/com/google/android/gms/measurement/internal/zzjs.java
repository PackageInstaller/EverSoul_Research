package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjs implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjs(zzio zzioVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zze().zzc(this.zzb.zzg().zzad(), zzbg.zzam)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
