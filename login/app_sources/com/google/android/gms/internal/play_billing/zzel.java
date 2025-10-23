package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzel extends zzen {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzeu zza(Object obj) {
        return new zzeo(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzeu zzb(zzeu zzeuVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzeuVar.isDone() ? zzeuVar : zzff.zzs(zzeuVar, 28500L, timeUnit, scheduledExecutorService);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(zzeu zzeuVar, zzej zzejVar, Executor executor) {
        zzeuVar.zzb(new zzek(zzeuVar, zzejVar), executor);
    }
}
