package com.google.android.gms.location;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzaj extends LocationCallback {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ FusedLocationProviderClient zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzaj(FusedLocationProviderClient fusedLocationProviderClient, TaskCompletionSource taskCompletionSource) {
        this.zzb = fusedLocationProviderClient;
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.location.LocationCallback
    public final void onLocationAvailability(LocationAvailability locationAvailability) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.location.LocationCallback
    public final void onLocationResult(LocationResult locationResult) {
        this.zza.trySetResult(locationResult.getLastLocation());
        this.zzb.removeLocationUpdates(this);
    }
}
