package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgw extends zzia {
    private static final AtomicLong zza = new AtomicLong(Long.MIN_VALUE);
    private zzha zzb;
    private zzha zzc;
    private final PriorityBlockingQueue<zzhb<?>> zzd;
    private final BlockingQueue<zzhb<?>> zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Thread.UncaughtExceptionHandler zzg;
    private final Object zzh;
    private final Semaphore zzi;
    private volatile boolean zzj;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzia
    protected final boolean zzo() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzay zzf() {
        return super.zzf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzfo zzi() {
        return super.zzi();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzfp zzj() {
        return super.zzj();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzgb zzk() {
        return super.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib, com.google.android.gms.measurement.internal.zzid
    @Pure
    public final /* bridge */ /* synthetic */ zzgw zzl() {
        return super.zzl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    @Pure
    public final /* bridge */ /* synthetic */ zzng zzq() {
        return super.zzq();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzl().zzb(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzj().zzu().zza("Interrupted waiting for " + str);
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzj().zzu().zza("Timed out waiting for " + str);
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhb<?> zzhbVar = new zzhb<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            if (!this.zzd.isEmpty()) {
                zzj().zzu().zza("Callable skipped the worker queue.");
            }
            zzhbVar.run();
        } else {
            zza(zzhbVar);
        }
        return zzhbVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(callable);
        zzhb<?> zzhbVar = new zzhb<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzb) {
            zzhbVar.run();
        } else {
            zza(zzhbVar);
        }
        return zzhbVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgw(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzh = new Object();
        this.zzi = new Semaphore(2);
        this.zzd = new PriorityBlockingQueue<>();
        this.zze = new LinkedBlockingQueue();
        this.zzf = new zzgy(this, "Thread death: Uncaught exception on worker thread");
        this.zzg = new zzgy(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final void zzr() {
        if (Thread.currentThread() != this.zzc) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzib
    public final void zzt() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(zzhb<?> zzhbVar) {
        synchronized (this.zzh) {
            this.zzd.add(zzhbVar);
            zzha zzhaVar = this.zzb;
            if (zzhaVar == null) {
                zzha zzhaVar2 = new zzha(this, "Measurement Worker", this.zzd);
                this.zzb = zzhaVar2;
                zzhaVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzhaVar.zza();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zzhb<?> zzhbVar = new zzhb<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzh) {
            this.zze.add(zzhbVar);
            zzha zzhaVar = this.zzc;
            if (zzhaVar == null) {
                zzha zzhaVar2 = new zzha(this, "Measurement Network", this.zze);
                this.zzc = zzhaVar2;
                zzhaVar2.setUncaughtExceptionHandler(this.zzg);
                this.zzc.start();
            } else {
                zzhaVar.zza();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zza(new zzhb<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(Runnable runnable) throws IllegalStateException {
        zzac();
        Preconditions.checkNotNull(runnable);
        zza(new zzhb<>(this, runnable, true, "Task exception on worker thread"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzg() {
        return Thread.currentThread() == this.zzb;
    }
}
