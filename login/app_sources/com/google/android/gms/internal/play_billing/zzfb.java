package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzfb {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzev zza(ExecutorService executorService) {
        if (executorService instanceof zzev) {
            return (zzev) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzfa((ScheduledExecutorService) executorService) : new zzex(executorService);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzew zzb(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof zzew ? (zzew) scheduledExecutorService : new zzfa(scheduledExecutorService);
    }
}
