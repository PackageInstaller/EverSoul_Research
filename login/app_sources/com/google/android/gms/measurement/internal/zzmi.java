package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmi {
    private final Clock zza;
    private long zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzmi(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza() {
        this.zzb = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb() {
        this.zzb = this.zza.elapsedRealtime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(long j) {
        return this.zzb == 0 || this.zza.elapsedRealtime() - this.zzb >= DateUtils.MILLIS_PER_HOUR;
    }
}
