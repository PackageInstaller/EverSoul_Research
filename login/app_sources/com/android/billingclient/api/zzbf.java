package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.liapp.y;
import java.lang.ref.WeakReference;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzbf extends com.google.android.gms.internal.play_billing.zzaf {
    final WeakReference zza;
    final ResultReceiver zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzbf(WeakReference weakReference, ResultReceiver resultReceiver, zzbl zzblVar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzag
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.send(6, null);
            return;
        }
        String str = y.ݬֲ֮ܲت(1512928239);
        boolean containsKey = bundle.containsKey(str);
        String str2 = y.ٴسسݬߨ(1392804282);
        if (!containsKey) {
            com.google.android.gms.internal.play_billing.zze.zzl(str2, y.ٲٴݴ״ٰ(1781564712));
            this.zzb.send(6, bundle);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zze.zzb(bundle, str2);
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zze.zzl(str2, y.ݮڮֲڭܩ(-629024092) + zzb);
            this.zzb.send(zzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(y.֬ڱܱײٮ(-1159350863));
        String str3 = y.ۮڭڭܬި(861941275);
        String str4 = y.ݮڮֲڭܩ(-629117764);
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zze.zzl(str2, "The PendingIntent for the external offer dialog is null");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(str, 6);
            bundle2.putString(str4, str3);
            this.zzb.send(6, bundle2);
            return;
        }
        try {
            Activity activity = (Activity) this.zza.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("external_payment_dialog_result_receiver", this.zzb);
            intent.putExtra("external_payment_dialog_pending_intent", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e) {
            com.google.android.gms.internal.play_billing.zze.zzm(str2, y.֬ڱܱײٮ(-1159351119), e);
            Bundle bundle3 = new Bundle();
            bundle3.putInt(str, 6);
            bundle3.putString(str4, str3);
            bundle3.putInt(y.ٲٴݴ״ٰ(1781566728), 98);
            bundle3.putString(y.ٲٴݴ״ٰ(1781567704), String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzbf.zzb(e.getMessage())));
            this.zzb.send(6, bundle3);
        }
    }
}
