package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zam {
    private final int zaa;
    private final ConnectionResult zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zam(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final int zaa() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final ConnectionResult zab() {
        return this.zab;
    }
}
