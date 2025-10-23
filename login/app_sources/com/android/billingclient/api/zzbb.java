package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.liapp.y;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzbb extends com.google.android.gms.internal.play_billing.zzx {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzch zzb;
    final int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzbb(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzch zzchVar, int i, zzbl zzblVar) {
        this.zza = alternativeBillingOnlyReportingDetailsListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzy
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zzb(zzcg.zzb(71, 15, zzcj.zzk), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzcj.zzk, null);
            return;
        }
        String str = y.ٴسسݬߨ(1392804282);
        int zzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, str);
        BillingResult zza = zzcj.zza(zzb, com.google.android.gms.internal.play_billing.zze.zzh(bundle, str));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str, y.ٴسسݬߨ(1392870890) + zzb);
            this.zzb.zzb(zzcg.zzb(23, 15, zza), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, null);
            return;
        }
        try {
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, new AlternativeBillingOnlyReportingDetails(bundle.getString(y.دײܮڳܯ(2051834477))));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zze.zzm(str, y.ٲٴݴ״ٰ(1781571232), e);
            this.zzb.zzb(zzcg.zzb(72, 15, zzcj.zzk), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zzcj.zzk, null);
        }
    }
}
