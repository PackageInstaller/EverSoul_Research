package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzey extends zzeh implements ScheduledFuture, zzeu {
    private final ScheduledFuture zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzey(zzeu zzeuVar, ScheduledFuture scheduledFuture) {
        super(zzeuVar);
        this.zza = scheduledFuture;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzeg, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = zzc().cancel(z);
        if (cancel) {
            this.zza.cancel(z);
        }
        return cancel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
