package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzf implements AppMeasurementSdk.OnEventListener {
    private final /* synthetic */ zzg zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzf(zzg zzgVar) {
        this.zza = zzgVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.api.AppMeasurementSdk.OnEventListener, com.google.android.gms.measurement.internal.zzij
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || !zzb.zze(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        analyticsConnectorListener = this.zza.zza;
        analyticsConnectorListener.onMessageTriggered(3, bundle2);
    }
}
