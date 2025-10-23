package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
class zzag extends zza {
    private final BaseImplementation.ResultHolder zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzag(BaseImplementation.ResultHolder resultHolder) {
        this.zza = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzs(Object obj) {
        this.zza.setResult(obj);
    }
}
