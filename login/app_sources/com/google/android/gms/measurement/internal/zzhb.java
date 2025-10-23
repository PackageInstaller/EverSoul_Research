package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhb<V> extends FutureTask<V> implements Comparable<zzhb<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzgw zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzhb zzhbVar = (zzhb) obj;
        boolean z = this.zza;
        if (z != zzhbVar.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzhbVar.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzj().zzm().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhb(zzgw zzgwVar, Runnable runnable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzcl.zza().zza(runnable), null);
        AtomicLong atomicLong;
        this.zzd = zzgwVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzgw.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgwVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhb(zzgw zzgwVar, Callable<V> callable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzcl.zza().zza(callable));
        AtomicLong atomicLong;
        this.zzd = zzgwVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzgw.zza;
        long andIncrement = atomicLong.getAndIncrement();
        this.zzb = andIncrement;
        this.zzc = str;
        this.zza = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzgwVar.zzj().zzg().zza("Tasks index overflow");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzd.zzj().zzg().zza(this.zzc, th);
        if ((th instanceof zzgz) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }
}
