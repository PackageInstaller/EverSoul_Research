package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzg implements zza {
    private AnalyticsConnector.AnalyticsConnectorListener zza;
    private AppMeasurementSdk zzb;
    private zzf zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.analytics.connector.internal.zza
    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zza(Set<String> set) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.analytics.connector.internal.zza
    public final void zzb() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        zzf zzfVar = new zzf(this);
        this.zzc = zzfVar;
        this.zzb.registerOnMeasurementEventListener(zzfVar);
    }
}
