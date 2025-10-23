package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import com.liapp.y;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzn {
    private final Context zza;
    private final PurchasesUpdatedListener zzb;
    private final zzb zzc;
    private final UserChoiceBillingListener zzd;
    private final zzch zze;
    private final zzm zzf = new zzm(this, true);
    private final zzm zzg = new zzm(this, false);
    private boolean zzh;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final PurchasesUpdatedListener zzd() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzn(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzco zzcoVar, zzb zzbVar, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zzc = zzbVar;
        this.zzd = userChoiceBillingListener;
        this.zze = zzchVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzf() {
        this.zzf.zzc(this.zza);
        this.zzg.zzc(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzg(boolean z) {
        IntentFilter intentFilter = new IntentFilter(y.ۮڭڭܬި(862034307));
        IntentFilter intentFilter2 = new IntentFilter(y.ٴسسݬߨ(1392790042));
        intentFilter2.addAction(y.دײܮڳܯ(2051886589));
        this.zzh = z;
        this.zzg.zza(this.zza, intentFilter2);
        if (this.zzh) {
            this.zzf.zzb(this.zza, intentFilter, y.ݬֲ֮ܲت(1512835695));
        } else {
            this.zzf.zza(this.zza, intentFilter);
        }
    }
}
