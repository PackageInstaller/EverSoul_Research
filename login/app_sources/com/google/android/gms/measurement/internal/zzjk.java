package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjk implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjk(zzio zzioVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(this.zzb.zze().zzf(this.zzb.zzg().zzad()));
            } finally {
                this.zza.notify();
            }
        }
    }
}
