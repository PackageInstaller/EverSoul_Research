package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzau extends com.google.android.gms.location.zzbc {
    private final ListenerHolder<LocationListener> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzau(ListenerHolder<LocationListener> listenerHolder) {
        this.zza = listenerHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zzc() {
        this.zza.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.location.zzbd
    public final synchronized void zzd(Location location) {
        this.zza.notifyListener(new zzat(this, location));
    }
}
