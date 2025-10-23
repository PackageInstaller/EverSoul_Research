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
final class zzbd extends com.google.android.gms.internal.play_billing.zzab {
    final WeakReference zza;
    final ResultReceiver zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzbd(WeakReference weakReference, ResultReceiver resultReceiver, zzbl zzblVar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzac
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
            com.google.android.gms.internal.play_billing.zze.zzl(str2, y.ٴسسݬߨ(1392876442) + zzb);
            this.zzb.send(zzb, bundle);
            return;
        }
        String str3 = y.دײܮڳܯ(2051888109);
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(str3);
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zze.zzk(str2, y.ݬֲ֮ܲت(1512881719));
            this.zzb.send(0, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.zza.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("alternative_billing_only_dialog_result_receiver", this.zzb);
            intent.putExtra(str3, pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e) {
            com.google.android.gms.internal.play_billing.zze.zzm(str2, y.ۮڭڭܬި(862060275), e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(str, 6);
            bundle2.putString(y.ݮڮֲڭܩ(-629117764), y.ۮڭڭܬި(861941275));
            bundle2.putInt(y.ٲٴݴ״ٰ(1781566728), 75);
            bundle2.putString(y.ٲٴݴ״ٰ(1781567704), String.format("%s: %s", e.getClass().getName(), com.google.android.gms.internal.play_billing.zzbf.zzb(e.getMessage())));
            this.zzb.send(6, bundle2);
        }
    }
}
