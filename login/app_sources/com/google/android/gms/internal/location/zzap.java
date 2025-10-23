package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzap implements ListenerHolder.Notifier<LocationCallback> {
    final /* synthetic */ LocationResult zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzap(zzar zzarVar, LocationResult locationResult) {
        this.zza = locationResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(LocationCallback locationCallback) {
        locationCallback.onLocationResult(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
