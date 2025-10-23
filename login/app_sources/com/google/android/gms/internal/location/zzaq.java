package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzaq implements ListenerHolder.Notifier<LocationCallback> {
    final /* synthetic */ LocationAvailability zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzaq(zzar zzarVar, LocationAvailability locationAvailability) {
        this.zza = locationAvailability;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(LocationCallback locationCallback) {
        locationCallback.onLocationAvailability(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
