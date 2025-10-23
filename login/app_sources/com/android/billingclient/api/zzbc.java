package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.liapp.y;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzbc extends com.google.android.gms.internal.play_billing.zzz {
    final ExternalOfferReportingDetailsListener zza;
    final zzch zzb;
    final int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzbc(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = externalOfferReportingDetailsListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzaa
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(95, 24, zzcj.zzk), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzcj.zzk, null);
            return;
        }
        String str = y.ٴسسݬߨ(1392804282);
        int zzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, str);
        BillingResult zza = zzcj.zza(zzb, com.google.android.gms.internal.play_billing.zze.zzh(bundle, str));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, y.֬ڱܱײٮ(-1159347879) + zzb);
            this.zzb.zzb(zzcg.zzb(23, 24, zza), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zza, null);
            return;
        }
        try {
            this.zza.onExternalOfferReportingDetailsResponse(zza, new ExternalOfferReportingDetails(bundle.getString(y.ݬֲ֮ܲت(1512879391))));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zze.zzm(str, y.دײܮڳܯ(2051841453), e);
            this.zzb.zzb(zzcg.zzb(104, 24, zzcj.zzk), this.zzc);
            this.zza.onExternalOfferReportingDetailsResponse(zzcj.zzk, null);
        }
    }
}
