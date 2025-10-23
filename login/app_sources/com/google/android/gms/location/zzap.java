package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
abstract class zzap implements RemoteCall<com.google.android.gms.internal.location.zzaz, TaskCompletionSource<Boolean>> {
    private boolean zza = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzb(boolean z) {
        this.zza = false;
    }
}
