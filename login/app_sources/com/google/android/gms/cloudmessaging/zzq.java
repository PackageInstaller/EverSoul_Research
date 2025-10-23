package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
/* loaded from: classes.dex */
final class zzq extends zzr {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzq(int i, int i2, Bundle bundle) {
        super(i, i2, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.cloudmessaging.zzr
    final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzs(4, "Invalid response to one way request", null));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.cloudmessaging.zzr
    final boolean zzb() {
        return true;
    }
}
