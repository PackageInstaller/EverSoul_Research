package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzha extends Thread {
    private final Object zza;
    private final BlockingQueue<zzhb<?>> zzb;
    private boolean zzc = false;
    private final /* synthetic */ zzgw zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzha(zzgw zzgwVar, String str, BlockingQueue<zzhb<?>> blockingQueue) {
        this.zzd = zzgwVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zza = new Object();
        this.zzb = blockingQueue;
        setName(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzb() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzha zzhaVar;
        zzha zzhaVar2;
        obj = this.zzd.zzh;
        synchronized (obj) {
            if (!this.zzc) {
                semaphore = this.zzd.zzi;
                semaphore.release();
                obj2 = this.zzd.zzh;
                obj2.notifyAll();
                zzhaVar = this.zzd.zzb;
                if (this == zzhaVar) {
                    this.zzd.zzb = null;
                } else {
                    zzhaVar2 = this.zzd.zzc;
                    if (this == zzhaVar2) {
                        this.zzd.zzc = null;
                    } else {
                        this.zzd.zzj().zzg().zza("Current scheduler thread is neither worker nor network");
                    }
                }
                this.zzc = true;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(InterruptedException interruptedException) {
        this.zzd.zzj().zzu().zza(getName() + " was interrupted", interruptedException);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza() {
        synchronized (this.zza) {
            this.zza.notifyAll();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        Object obj;
        boolean z;
        boolean z2 = false;
        while (!z2) {
            try {
                semaphore = this.zzd.zzi;
                semaphore.acquire();
                z2 = true;
            } catch (InterruptedException e) {
                zza(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzhb<?> poll = this.zzb.poll();
                if (poll != null) {
                    Process.setThreadPriority(poll.zza ? threadPriority : 10);
                    poll.run();
                } else {
                    synchronized (this.zza) {
                        if (this.zzb.peek() == null) {
                            z = this.zzd.zzj;
                            if (!z) {
                                try {
                                    this.zza.wait(30000L);
                                } catch (InterruptedException e2) {
                                    zza(e2);
                                }
                            }
                        }
                    }
                    obj = this.zzd.zzh;
                    synchronized (obj) {
                        if (this.zzb.peek() == null) {
                            zzb();
                            return;
                        }
                    }
                }
            }
        } finally {
            zzb();
        }
    }
}
