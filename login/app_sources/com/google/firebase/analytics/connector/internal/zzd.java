package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzd implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zze zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzd(zze zzeVar) {
        this.zza = zzeVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzij
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (this.zza.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", zzb.zza(str2));
            analyticsConnectorListener = this.zza.zzb;
            analyticsConnectorListener.onMessageTriggered(2, bundle2);
        }
    }
}
